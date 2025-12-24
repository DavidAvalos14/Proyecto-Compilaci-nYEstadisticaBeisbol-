/*------------------------------------------------------------------------------------------
							Liga de Beisbol Sertoma 

						PERIODO: VACACIONES DE INVIERNO 2024 - 25   

            Script de base de datos para llevar la compilación y estadistica
        
  Autor       : Angel David Avalos Carrillo
  Nombre      : Compilacion.sql
  Fecha       : ENERO/2025
  Compilador  : Miscrosoft SQL Server Management Studio
  Descripción : Este script contiene las tablas:
					1. Liga
					2. Temporada
					3. Categoria
					4. Equipo
					5. Jugador
					6. Jornada
					7. JEquipo
					8. JBateador
					9. JPicher
				Con los atributos necesarios mas aparte
				las consultas que son requeridas para la 
				aplicación
==========================================================================================*/

create database CompilacionYEstadistica

--==========================================================================================

/*CREAR LAS TABLAS*/

--Crear la tabla Liga
create table Liga (
	id_liga int identity primary key,
	liga_nombre varchar(50) not null unique,
	liga_tipo varchar(50) null
)

--Crear la tabla Temporada (Las temporadas pertenecen a una liga)
create table Temporada (
	id_temporada int identity primary key,
	temp_nombre varchar(50) not null unique,
	temp_periodo varchar(50) null,
	liga int,
	constraint FK_TL foreign key (liga) references Liga (id_liga)
	on delete cascade
	on update cascade
)

CREATE TRIGGER trg_InsertJornadaOnTemporada
ON Temporada
AFTER INSERT
AS
BEGIN
    -- Variables para insertar la jornada
    DECLARE @id_temporada INT;
    DECLARE @temp_nombre VARCHAR(50);
    DECLARE @numJornada VARCHAR(100);
    DECLARE @default_fechaInicio DATE = GETDATE(); -- Fecha actual como inicio
    DECLARE @default_fechaFin DATE = DATEADD(DAY, 7, GETDATE()); -- Fecha fin una semana después

    -- Obtenemos los valores de la temporada recién insertada
    SELECT @id_temporada = id_temporada, @temp_nombre = temp_nombre FROM INSERTED;

    -- Crear el nombre dinámico de la jornada
    SET @numJornada = @temp_nombre + '-JornadaDefault';

    -- Insertamos una jornada por defecto vinculada a la temporada
    INSERT INTO Jornada (numJornada, fechaInicio, fechaFin, temporada)
    VALUES (@numJornada, @default_fechaInicio, @default_fechaFin, @id_temporada);
END;
GO


--Crear la tabla Categoria (Las categorías pertenecen a una liga)
create table Categoria (
	id_categoria int identity primary key,
	cat_nombre varchar(50) not null unique,
	liga int,
	constraint FK_CL foreign key (liga) references Liga (id_liga)
	on delete cascade
	on update cascade
)

--Crear la tabla Equipo (Los equipos pertenecen a una temporada y a una categoría)
Create table Equipo(
	id_equipo int identity primary key,
	e_nombre varchar(50) not null,
	temporada int,
	constraint FK_ET foreign key (temporada) references Temporada (id_temporada)
	on delete no action
	on update no action,
	categoria int,
	constraint FK_EC foreign key (categoria) references Categoria (id_categoria)
	on delete cascade
	on update cascade 
)


--Crear la tabla jugador (Los jugadores pertenecen a un equipo)
Create table Jugador(
	id_jugador int identity primary key,
	j_nombre varchar(60) not null,
	equipo int,
	constraint FK_JE foreign key (equipo) references Equipo (id_equipo)
	on delete cascade
	on update cascade
)

--Crear tabla Jornada (Las jornadas pertenecen a una temporada)
Create table Jornada(
	id_jornada int identity primary key,
	numJornada varchar(100) not null unique,
	fechaInicio date not null,
	fechaFin date not null,
	temporada int,
	constraint FK_JT foreign key (temporada) references Temporada (id_temporada)
	on delete cascade
	on update cascade
)


--Crear tabla de JEquipo (Datos que pertenecen a una jornada)
Create table JEquipo(
	id_jequipo int identity primary key,
	je_gano int null,
	je_perdio int null,
	je_carrarasAnotadas int null,
	je_carrerasRecibidas int null,
	je_diferencial as je_carrarasAnotadas - je_carrerasRecibidas,
	jornada int,
	constraint FK_JEJO foreign key (jornada) references Jornada (id_jornada)
	on delete no action
	on update no action,
	equipo int,
	constraint FK_JEE foreign key (equipo) references Equipo (id_equipo)
	on delete cascade
	on update cascade,
	rival int,
	constraint FK_JER foreign key (rival) references Equipo (id_equipo)
	on delete no action
	on update no action,
	constraint CHK_EQUIPO_RIVAL CHECK (equipo != rival)
)

--Crear tabla de JBateador (Datos que pertenecen a una jornada)
Create table JBateador(
	id_jbateador int identity primary key,
	jb_ap decimal(10,2) null,
	jb_tl decimal(10,2) null,
	jb_hits int null,
	jb_dobles int null,
	jb_triples int null,
	jb_hr int null,
	jb_cp int null,
	jb_bb int null,
	jb_bg int null,
	jb_br int null,
	jb_sacF int null,
	jb_toqueF int null,
	jb_sacrificios as jb_sacF + jb_toqueF,
	--jb_prom  as (CASE WHEN jb_tl = 0 THEN 0 ELSE jb_hits / jb_tl END),
	--jb_slg as (CASE WHEN jb_ap = 0 THEN 0 ELSE ((jb_hits - jb_dobles - jb_triples - jb_hr) + (2 * jb_dobles) + (3 * jb_triples) + (4 * jb_hr)) / jb_tl),
	--jb_obp as (CASE WHEN (jb_tl + jb_bb + jb_bg + jb_sacF) = 0 THEN 0 ELSE (jb_hits + jb_bb + jb_bg) / (jb_tl + jb_bb + jb_bg + jb_sacF)),
	--jb_ops as jb_slg + jb_obp,
	jornada int,
	constraint FK_JBJO foreign key (jornada) references Jornada (id_jornada)
	on delete no action
	on update no action,
	jugador int,
	constraint FK_JBJU foreign key (jugador) references Jugador (id_jugador)
	on delete cascade
	on update cascade
)

--Crear la tabla JPicher (Datos que pertenecen a una jugada)
create table JPicher(
	id_jpicher int identity primary key,
	jp_innings decimal(10,2) null,
	jp_gano int null,
	jp_perdio int null,
	jp_carrerasPermitidas int null,
	jp_carrerasLimpias int null,
	jp_ponches int null,
	jp_hits int null,
	jp_basesBola int null,
	jp_basesGolpe int null,
	jp_sacrificios int null,
	jp_legalesEnfrentados float null,
	--jp_era as (CASE WHEN jp_innings = 0 THEN 0 ELSE (jp_carrerasLimpias / jp_innings) * 9),
	--jp_whip as (CASE WHEN jp_innings = 0 THEN 0 ELSE (jp_basesBola + jp_hits) / jp_innings),
	--jp_avg as (CASE WHEN jp_legalesEnfrentados = 0 THEN 0 ELSE jp_hits / jp_legalesEnfrentados)
	jornada int,
	constraint FK_JPJO foreign key (jornada) references Jornada (id_jornada)
	on delete no action
	on update no action,
	jugador int,
	constraint FK_JPJU foreign key (jugador) references Jugador (id_jugador)
	on delete cascade
	on update cascade
)

--==========================================================================================

/*Restricciones para que solo haya un resultado por jornada*/

-- Bateador
ALTER TABLE JBateador
ADD CONSTRAINT UQ_Bateador_Jornada UNIQUE (jornada, jugador)

-- Lanzador
ALTER TABLE JPicher
ADD CONSTRAINT UQ_Picher_Jornada UNIQUE (jornada, jugador)

-- Equipo

ALTER TABLE JEquipo
ADD CONSTRAINT UQ_Equipo_Jornada UNIQUE (jornada, equipo)

--==========================================================================================

/*ALtas, Modificaciones y Bajas de Cada tabla*/

/*Ligas*/

-- Alta
insert into Liga values (?, ?)

-- Modificar
update Liga SET liga_nombre = '', liga_tipo = '' WHERE id_liga = 0

--Baja
delete from Liga where id_liga = 0

/*Temporadas*/

-- Alta
insert into Temporada values (?, ?, ?)

-- Modificar
update Temporada set temp_nombre = '', temp_periodo = '' WHERE id_temporada = 0

-- Baja
delete from Temporada where id_temporada = 0

/*Categorias*/

-- Alta
insert into Categoria values (?, ?)

-- Modificar
update Categoria set cat_nombre = '' where id_categoria = 0

-- Baja
delete from Categoria where id_categoria = 0

/*Equipos*/

-- Alta
insert into Equipo values (?, ?, ?)

-- Modificar 
UPDATE Equipo SET e_nombre = '', categoria = 0 WHERE id_equipo = (0)

-- Baja
DELETE FROM Equipo WHERE id_equipo = 0

/*Jugadores*/ 

-- Alta
insert into Jugador values (?, ?)

-- Modificar 
UPDATE Jugador SET j_nombre = '',  equipo = 0 WHERE id_jugador = 0

-- Baja
DELETE FROM Jugador WHERE id_jugador = 0

/*Jornadas*/

-- Alta
insert into Jornada values (?, ?, ?, ?)
--Se da de alta la jornada 0, con el id #1, para que se de de alta las Jornadas por Equipo conn valores Nulos
--para que se muestren en la tabla de posiciones

-- Modificar
UPDATE Jornada SET numJornada = 0, fechaInicio = '', fechaFin = '' WHERE id_jornada = 0

-- Baja
DELETE FROM Jornada WHERE id_jornada = 5


/*JEquipo*/

-- Alta
insert into JEquipo values --(?, ?, ?, ?, ?, ?, ?)

-- Modifcar
UPDATE JEquipo SET je_gano = 0, je_perdio = 0, je_carrarasAnotadas = 0, je_carrerasRecibidas = 0 WHERE id_jequipo = 0

-- Baja
DELETE FROM JEquipo WHERE id_jequipo = --?

select * from JEquipo
where equipo = --?

/*JBateador*/

-- Alta
insert into JBateador values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)

-- Modificar
UPDATE JBateador SET jb_ap = 0, jb_tl = 0, jb_hits = 0, jb_dobles = 0, jb_triples = 0, jb_hr = 0, jb_cp = 0,
jb_bb = 0, jb_bg = 0, jb_br = 0, jb_sacF = 0, jb_toqueF WHERE id_jbateador = 0

-- Baja
DELETE FROM JBateador WHERE id_jbateador = 0


/*JPicher*/

-- Alta
insert into JPicher values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)

-- Modificar
update JPicher set jp_innings = 0, jp_gano = 0, jp_perdio = 0, jp_carrerasPermitidas = 0, jp_carrerasLimpias = 0,
jp_ponches = 0, jp_hits = 0, jp_basesBola = 0, jp_basesGolpe = 0, jp_sacrificios = 0, jp_legalesEnfrentados = 0 where id_jpicher = 0

-- Baja
delete from JPicher where id_jpicher = 0

--==========================================================================================

/*Claves de cada una de las tablas*/

-- Ligas (Su nombre es unico)
SELECT 
	id_liga AS Clave
FROM 
	Liga
WHERE 
	liga_nombre like 'Sertoma'

-- Temporadas (Su nombre es unico)
SELECT
	id_temporada AS Clave
FROM 
	Temporada
WHERE
	temp_nombre = '2025-A'

-- Categorías (Su nombre es unico)
SELECT
	id_categoria AS Clave
FROM
	Categoria
WHERE
	cat_nombre = 0

-- Equipo (La combinación de nombre con categoría es unica)
SELECT
	id_equipo AS Clave
FROM 
	Equipo
WHERE
	(e_nombre = 0 and categoria = 0)

-- Jugador (La combinacion del nombre y su equipo es unica)
SELECT
	id_jugador AS Clave
FROM 
	Jugador
WHERE
	(j_nombre = 0 and equipo = 0)

-- Jornada (Su nombre es Unico)
SELECT 
	id_jornada AS Clave
FROM 
	Jornada
WHERE 
	(numJornada = 0)

-- JEquipo (Solo tiene un registro por jornada)
SELECT 
	id_jequipo AS Clave
FROM 
	JEquipo 
WHERE 
	jornada = 0 AND equipo = 0

-- JBateador (Solo tiene un registro por jornada)
SELECT 
	id_jbateador AS Clave 
FROM 
	JBateador 
WHERE 
	(jornada = 0 and jugador = 0)

-- JLanzador (Solo tiene un registro por jornada)
SELECT 
	id_jpicher AS Clave 
FROM 
	JPicher 
WHERE 
	(jornada = 0 and jugador = 0)

--==========================================================================================

/*Mostrar los datos correspondientes a cada tabla*/

-- Nombre y tipo de las ligas
SELECT 
	liga_nombre AS Liga
FROM
	Liga

-- Nombre y periodo de las temporadas
SELECT
	temp_nombre AS Temporadas, temp_periodo AS Periodo
FROM
	Temporada
WHERE 
	liga = 0

-- Nombre de las categorías
SELECT
	cat_nombre AS Categorias
FROM
	Categoria
WHERE
	liga = 1

-- Conseguir el numero de jornada, Fecha de Inicio, Fecha de Fin 
SELECT
	numJornada AS Jornada,
	fechaInicio AS Inicio,
	fechaFin AS Fin
FROM
	Jornada
WHERE
	temporada  = 9

--Equipos por categoría
SELECT 
	e_nombre AS Nombre
FROM
	Equipo
WHERE
	categoria = 0

-- Conseguir el Equipo, Juegos Jugados, Ganados, Perdidos, Carreras Anotadas, Carreras Recibidas y Diferencial
WITH Estadisticas AS (
    SELECT  
        e.id_equipo,
        e.e_nombre,
        COUNT(je.id_jequipo) AS Juegos_Jugados,
        SUM(je.je_gano) AS Ganados,
        SUM(je.je_perdio) AS Perdidos,
        CAST(SUM(je.je_gano) AS FLOAT) / NULLIF(SUM(je.je_gano + je.je_perdio), 0) AS Porcentaje_Victorias,
        SUM(je.je_carrarasAnotadas) AS Carreras_Anotadas,
        SUM(je.je_carrerasRecibidas) AS Carreras_Recibidas,
        SUM(je.je_diferencial) AS Diferencial
    FROM 
        Equipo e
    JOIN 
        JEquipo je ON e.id_equipo = je.equipo
    WHERE 
        e.categoria = 2
    GROUP BY 
        e.id_equipo, e.e_nombre
),
-- Encuentra los duelos directos entre equipos con el mismo porcentaje
PartidosEntreEmpatados AS (
    SELECT 
        je.equipo,
        je.rival,
        SUM(CASE WHEN je.je_gano = 1 THEN 1 ELSE 0 END) AS GanadosContra,
        SUM(je.je_carrarasAnotadas - je.je_carrerasRecibidas) AS DiferenciaContra
    FROM 
        JEquipo je
    JOIN Estadisticas e1 ON je.equipo = e1.id_equipo
    JOIN Estadisticas e2 ON je.rival = e2.id_equipo
    WHERE 
        e1.Porcentaje_Victorias = e2.Porcentaje_Victorias
    GROUP BY 
        je.equipo, je.rival
),
ResumenDesempate AS (
    SELECT 
        equipo,
        SUM(GanadosContra) AS TotalGanadosDirectos,
        SUM(DiferenciaContra) AS TotalDiferenciaDirecta
    FROM 
        PartidosEntreEmpatados
    GROUP BY 
        equipo
)
SELECT 
    e.e_nombre AS Equipo,
    es.Juegos_Jugados,
    es.Ganados,
    es.Perdidos,
    es.Porcentaje_Victorias AS Porcentaje_De_Victorias,
    es.Carreras_Anotadas,
    es.Carreras_Recibidas,
    es.Diferencial,
    COALESCE(rd.TotalGanadosDirectos, 0) AS Ganados_Directos,
    COALESCE(rd.TotalDiferenciaDirecta, 0) AS Diferencia_Directa
FROM 
    Estadisticas es
JOIN 
    Equipo e ON es.id_equipo = e.id_equipo
LEFT JOIN 
    ResumenDesempate rd ON es.id_equipo = rd.equipo
ORDER BY 
    es.Porcentaje_Victorias DESC,
    Ganados_Directos DESC,
    Diferencia_Directa DESC,
    es.Diferencial DESC;


/**/
WITH PartidosDirectos AS (
    SELECT 
        je1.equipo AS Equipo,
        je1.rival AS Rival,
        SUM(CASE WHEN je1.je_gano = 1 THEN 1 ELSE 0 END) AS GanadosContraRival,
        SUM(je1.je_carrarasAnotadas - je1.je_carrerasRecibidas) AS DiferenciaContraRival
    FROM 
        JEquipo je1
    GROUP BY 
        je1.equipo, je1.rival
),
GanadosDiferenciales AS (
    SELECT 
        pd.Equipo AS Equipo,
        SUM(pd.GanadosContraRival) AS TotalGanadosContraRival,
        SUM(pd.DiferenciaContraRival) AS TotalDiferenciaContraRival
    FROM 
        PartidosDirectos pd
    GROUP BY 
        pd.Equipo
)
SELECT  
    e.e_nombre AS Equipo,
    COUNT(je.id_jequipo) AS Juegos_Jugados,
    SUM(je.je_gano) AS Ganados,
    SUM(je.je_perdio) AS Perdidos,
    CASE 
        WHEN SUM(je.je_gano) + SUM(je.je_perdio) = 0 THEN 0
        ELSE CAST(SUM(je.je_gano) AS FLOAT) / (SUM(je.je_gano) + SUM(je.je_perdio))
    END AS Porcentaje_De_Victorias,
    SUM(je.je_carrarasAnotadas) AS Carreras_Anotadas,
    SUM(je.je_carrerasRecibidas) AS Carreras_Recibidas,
    SUM(je.je_diferencial) AS Diferencial
FROM 
    Equipo e
JOIN 
    JEquipo je ON e.id_equipo = je.equipo
LEFT JOIN 
    GanadosDiferenciales gd ON e.id_equipo = gd.Equipo
WHERE
    e.categoria = 2
GROUP BY 
    e.id_equipo, e.e_nombre, gd.TotalGanadosContraRival, gd.TotalDiferenciaContraRival
ORDER BY
    Porcentaje_De_Victorias DESC,
    COALESCE(gd.TotalGanadosContraRival, 0) DESC,  -- Desempate por victorias directas
    COALESCE(gd.TotalDiferenciaContraRival, 0) DESC, -- Segundo desempate
    SUM(je.je_diferencial) DESC; -- Tercer desempate

--Conseguir el Jugador, Apariciones, Turnos Legales, Hits, HomeRuns, Carreras Producidas, Promedio de Bateo, 
SELECT 
    Jugador.j_nombre AS Jugador, 
    COUNT(jb_ap) - 1 AS Juegos_Jugados,
    SUM(jb_ap) AS Apariciones, 
    SUM(jb_tl) AS Turnos_Legales, 
    SUM(jb_hits) AS Hits, 
    SUM(jb_dobles) AS Dobles,
    SUM(jb_triples) AS Triples,
    SUM(jb_hr) AS HomeRuns, 
    SUM(jb_cp) AS Carreras_Producidas,
    SUM(jb_br) AS Robos,
    SUM(jb_bb) AS Bases_X_Bola,
    SUM(jb_bg) AS Bases_X_Golpe,
    SUM(jb_sacF) AS Elevados_Sacrificio,
    SUM(jb_toqueF) AS Toques_Sacrificio,
    SUM(jb_sacrificios) AS Sacrificios,
    CASE
        WHEN SUM(jb_tl) = 0 THEN 0
        ELSE (SUM(jb_hits) / SUM(jb_tl)) 
    END AS Promedio,
    CASE 
        WHEN SUM(jb_tl) = 0 THEN 0 
        ELSE (SUM(jb_hits) - SUM(jb_dobles) - SUM(jb_triples) - SUM(jb_hr) + 
              (2 * SUM(jb_dobles)) + (3 * SUM(jb_triples)) + (4 * SUM(jb_hr))) / SUM(jb_tl)
    END AS SLG,
    CASE 
        WHEN (SUM(jb_tl) + SUM(jb_bb) + SUM(jb_bg) + SUM(jb_sacF)) = 0 THEN 0
        ELSE (SUM(jb_hits) + SUM(jb_bb) + SUM(jb_bg)) / 
             (SUM(jb_tl) + SUM(jb_bb) + SUM(jb_bg) + SUM(jb_sacF))
    END AS OBP,
    CASE 
        WHEN SUM(jb_tl) = 0 THEN 0
        ELSE 
            (SUM(jb_hits) - SUM(jb_dobles) - SUM(jb_triples) - SUM(jb_hr) + 
            (2 * SUM(jb_dobles)) + (3 * SUM(jb_triples)) + (4 * SUM(jb_hr))) / SUM(jb_tl) +
            (SUM(jb_hits) + SUM(jb_bb) + SUM(jb_bg)) / 
            (SUM(jb_tl) + SUM(jb_bb) + SUM(jb_bg) + SUM(jb_sacF))
    END AS OPS
FROM JBateador 
JOIN Jugador ON JBateador.jugador = Jugador.id_jugador
WHERE 
    Jugador.equipo = 0
GROUP BY 
    Jugador.j_nombre;

-- Conseguir el jugador, innings, ganados, perdidos, carrerasPermitidas, carrerasLimpias, ponches, hits, basesXBola, basesXGolpe, Sacrificios, legalesEnfrentados
SELECT 
    Jugador.j_nombre AS Jugador, 
    COUNT(jp_innings) - 1 AS Juegos_Jugados,
    SUM(jp_innings) AS Innings_Lanzados,
	sum(jp_gano) AS Ganados,
	sum(jp_perdio) AS Perdidos,
	sum(jp_carrerasPermitidas) AS CarrerasPermitidas,
	sum(jp_carrerasLimpias) AS CarrerasLimpias,
	sum(jp_ponches) AS Ponches,
	sum(jp_hits) AS Hits,
	sum(jp_basesBola) AS Bases_por_Bola,
	sum(jp_basesGolpe) AS Bases_por_Golpe,
	sum(jp_sacrificios) AS Sacrificios,
	sum(jp_legalesEnfrentados) AS Legales_Enfrentados,
	CASE
		WHEN sum(jp_innings) = 0 THEN 0
		ELSE (sum(jp_carrerasLimpias) / sum(jp_innings) * 9)
	END AS ERA,
	CASE 
		WHEN sum(jp_innings) = 0 THEN 0
		ELSE ((sum(jp_hits) + sum(jp_basesBola)) / sum(jp_innings))
	END AS WHIP,
	CASE 
		WHEN sum(jp_legalesEnfrentados) = 0 THEN 0
		ELSE ((sum(jp_hits) / sum(jp_legalesEnfrentados)))
	END AS OAA
FROM JPicher 
JOIN Jugador ON JPicher.jugador = Jugador.id_jugador
WHERE 
    Jugador.equipo = 0
GROUP BY 
    Jugador.j_nombre

--==========================================================================================

/*Conseguir los 10 mayores registros de*/

-- Promedio de Bateo
SELECT TOP 10
    j.j_nombre AS Nombre_Jugador,
    e.e_nombre AS Nombre_Equipo,
    SUM(jj.jb_ap) AS Apariciones,
    SUM(jj.jb_tl) AS Turnos_Legales,
    SUM(jj.jb_hits) AS Hits,
    CASE 
        WHEN SUM(jj.jb_tl) = 0 THEN 0
        ELSE SUM(jj.jb_hits) / SUM(jj.jb_tl)
    END AS Promedio
FROM 
    JBateador jj
INNER JOIN 
    Jugador j ON jj.jugador = j.id_jugador
INNER JOIN 
    Equipo e ON j.equipo = e.id_equipo
WHERE
    e.categoria = 38 and e.temporada = 38
GROUP BY 
    j.j_nombre, e.e_nombre
HAVING
	sum(jb_ap) >= 0.0
ORDER BY 
    Promedio DESC,   -- Ordena por promedio en orden descendente
    Hits DESC,       -- Luego ordena por hits en orden descendente
	Turnos_Legales DESC, -- Luego por turnos legales
	Apariciones DESC; -- Al ultimo por apariciones

-- Hits
SELECT TOP 10
	j.j_nombre AS Nombre_Jugador,
    e.e_nombre AS Nombre_Equipo,
	sum(jj.jb_hits) AS Hits
FROM 
    JBateador jj
INNER JOIN 
    Jugador j ON jj.jugador = j.id_jugador
INNER JOIN 
    Equipo e ON j.equipo = e.id_equipo
WHERE
	e.categoria = 0
GROUP BY 
    j.j_nombre, e.e_nombre
ORDER BY 
    Hits DESC;

-- Dobles
SELECT TOP 10
	j.j_nombre AS Nombre_Jugador,
    e.e_nombre AS Nombre_Equipo,
	sum(jj.jb_dobles) AS Dobles
FROM 
    JBateador jj
INNER JOIN 
    Jugador j ON jj.jugador = j.id_jugador
INNER JOIN 
    Equipo e ON j.equipo = e.id_equipo
WHERE
	e.categoria = 0
GROUP BY 
    j.j_nombre, e.e_nombre
ORDER BY 
    Dobles DESC;

-- Triples
SELECT TOP 10
	j.j_nombre AS Nombre_Jugador,
    e.e_nombre AS Nombre_Equipo,
	sum(jj.jb_triples) AS Triples
FROM 
    JBateador jj
INNER JOIN 
    Jugador j ON jj.jugador = j.id_jugador
INNER JOIN 
    Equipo e ON j.equipo = e.id_equipo
WHERE
	e.categoria = 0
GROUP BY 
    j.j_nombre, e.e_nombre
ORDER BY 
    Triples DESC;

-- HomeRuns
SELECT TOP 10
	j.j_nombre AS Nombre_Jugador,
    e.e_nombre AS Nombre_Equipo,
	sum(jj.jb_hr) AS HomeRuns
FROM 
    JBateador jj
INNER JOIN 
    Jugador j ON jj.jugador = j.id_jugador
INNER JOIN 
    Equipo e ON j.equipo = e.id_equipo
WHERE
	e.categoria = 0
GROUP BY 
    j.j_nombre, e.e_nombre
ORDER BY 
    HomeRuns DESC;

-- Extra Bases
SELECT TOP 10
	j.j_nombre AS Nombre_Jugador,
    e.e_nombre AS Nombre_Equipo,
	sum(jj.jb_dobles) + sum(jj.jb_triples) + sum(jj.jb_hr) AS ExtraBases
FROM 
    JBateador jj
INNER JOIN 
    Jugador j ON jj.jugador = j.id_jugador
INNER JOIN 
    Equipo e ON j.equipo = e.id_equipo
WHERE
	e.categoria = 0
GROUP BY 
    j.j_nombre, e.e_nombre
ORDER BY 
    ExtraBases DESC;

--Carreras Producidas
SELECT TOP 10
	j.j_nombre AS Nombre_Jugador,
    e.e_nombre AS Nombre_Equipo,
	sum(jj.jb_cp) AS Producidas
FROM 
    JBateador jj
INNER JOIN 
    Jugador j ON jj.jugador = j.id_jugador
INNER JOIN 
    Equipo e ON j.equipo = e.id_equipo
WHERE
	e.categoria = 0 and e.temporada = 0
GROUP BY 
    j.j_nombre, e.e_nombre
ORDER BY 
    Producidas DESC;

--Robos de Base
SELECT TOP 10
	j.j_nombre AS Nombre_Jugador,
    e.e_nombre AS Nombre_Equipo,
	sum(jj.jb_br) AS Robos
FROM 
    JBateador jj
INNER JOIN 
    Jugador j ON jj.jugador = j.id_jugador
INNER JOIN 
    Equipo e ON j.equipo = e.id_equipo
WHERE
	e.categoria = 0
GROUP BY 
    j.j_nombre, e.e_nombre
ORDER BY 
    Robos DESC;

--Ganados y Perdidos
SELECT TOP 10
	j.j_nombre AS Nombre_Jugador,
    e.e_nombre AS Nombre_Equipo,
	sum(jj.jp_gano) AS Ganados,
	sum(jj.jp_perdio) AS Perdidos,
	CASE 
    WHEN SUM(jj.jp_gano) + SUM(jj.jp_perdio) = 0 THEN 0
    ELSE CAST(SUM(jj.jp_gano) AS FLOAT) / (SUM(jj.jp_gano) + SUM(jj.jp_perdio))
	END AS Porcentaje
FROM 
    JPicher jj
INNER JOIN 
    Jugador j ON jj.jugador = j.id_jugador
INNER JOIN 
    Equipo e ON j.equipo = e.id_equipo
WHERE
	e.categoria = 0
GROUP BY 
    j.j_nombre, e.e_nombre
HAVING
	sum(jj.jp_innings) >= 0
ORDER BY 
    Porcentaje DESC,
	Ganados DESC,
	Perdidos DESC;

-- Efectividad
SELECT TOP 10
	j.j_nombre AS Nombre_Jugador,
	e.e_nombre AS Nombre_Equipo,
	sum(jj.jp_carrerasLimpias) AS carrerasLimpias,
	sum(jj.jp_innings) AS Innings_Lanzados,
	CASE	
		WHEN sum(jj.jp_innings) = 0 THEN 0
		ELSE sum(jj.jp_carrerasLimpias) / sum(jj.jp_innings) * 9
		END AS ERA
FROM 
    JPicher jj
INNER JOIN 
    Jugador j ON jj.jugador = j.id_jugador
INNER JOIN 
    Equipo e ON j.equipo = e.id_equipo
WHERE
	e.categoria = 0
GROUP BY 
    j.j_nombre, e.e_nombre
HAVING
	sum(jj.jp_innings) >= 0
ORDER BY
	ERA DESC;

-- Ponches
SELECT TOP 10
	j.j_nombre AS Nombre_Jugador,
    e.e_nombre AS Nombre_Equipo,
	sum(jj.jp_ponches) AS Ponches
FROM 
    JPicher jj
INNER JOIN 
    Jugador j ON jj.jugador = j.id_jugador
INNER JOIN 
    Equipo e ON j.equipo = e.id_equipo
WHERE
	e.categoria = 0
GROUP BY 
    j.j_nombre, e.e_nombre
ORDER BY 
    Ponches DESC;

-- WHIP
SELECT TOP 10
	j.j_nombre AS Nombre_Jugador,
	e.e_nombre AS Nombre_Equipo,
	sum(jj.jp_basesBola) AS BasesBola,
	sum(jj.jp_hits) AS Hits,
	sum(jj.jp_innings) AS Innings_Lanzados,
	CASE	
		WHEN sum(jj.jp_innings) = 0 THEN 0
		ELSE sum(jj.jp_basesBola) + sum(jj.jp_hits) / sum(jj.jp_innings) 
		END AS WHIP
FROM 
    JPicher jj
INNER JOIN 
    Jugador j ON jj.jugador = j.id_jugador
INNER JOIN 
    Equipo e ON j.equipo = e.id_equipo
WHERE
	e.categoria = 0
GROUP BY 
    j.j_nombre, e.e_nombre
HAVING
	sum(jj.jp_innings) >= 0
ORDER BY
	WHIP DESC;

-- OAA
SELECT TOP 10
	j.j_nombre AS Nombre_Jugador,
	e.e_nombre AS Nombre_Equipo,
	CASE 
		WHEN sum(jp_legalesEnfrentados) = 0 THEN 0
		ELSE ((sum(jp_hits) / sum(jp_legalesEnfrentados)))
	END AS OAA
FROM 
    JPicher jj
INNER JOIN 
    Jugador j ON jj.jugador = j.id_jugador
INNER JOIN 
    Equipo e ON j.equipo = e.id_equipo
WHERE
	e.categoria = 9 and e.temporada = 4
GROUP BY 
    j.j_nombre, e.e_nombre
HAVING
	sum(jj.jp_innings) >= 0
ORDER BY
	OAA DESC;

-- OBP
SELECT TOP 10
	j.j_nombre AS Nombre_Jugador,
	e.e_nombre AS Nombre_Equipo,
	CASE 
        WHEN (SUM(jb_tl) + SUM(jb_bb) + SUM(jb_bg) + SUM(jb_sacF)) = 0 THEN 0
        ELSE (SUM(jb_hits) + SUM(jb_bb) + SUM(jb_bg)) / 
             (SUM(jb_tl) + SUM(jb_bb) + SUM(jb_bg) + SUM(jb_sacF))
    END AS OBP
FROM 
    JBateador jj
INNER JOIN 
    Jugador j ON jj.jugador = j.id_jugador
INNER JOIN 
    Equipo e ON j.equipo = e.id_equipo
WHERE
    e.categoria = 38 and e.temporada = 38
GROUP BY 
    j.j_nombre, e.e_nombre
HAVING
	sum(jb_ap) >= -1
ORDER BY 
    OBP DESC

-- SLG
SELECT TOP 10
	j.j_nombre AS Nombre_Jugador,
	e.e_nombre AS Nombre_Equipo,
	CASE 
        WHEN SUM(jb_tl) = 0 THEN 0 
        ELSE (SUM(jb_hits) - SUM(jb_dobles) - SUM(jb_triples) - SUM(jb_hr) + 
              (2 * SUM(jb_dobles)) + (3 * SUM(jb_triples)) + (4 * SUM(jb_hr))) / SUM(jb_tl)
    END AS SLG
FROM 
    JBateador jj
INNER JOIN 
    Jugador j ON jj.jugador = j.id_jugador
INNER JOIN 
    Equipo e ON j.equipo = e.id_equipo
WHERE
    e.categoria = 0
GROUP BY 
    j.j_nombre, e.e_nombre
HAVING
	sum(jb_ap) >= 0
ORDER BY 
    SLG DESC

-- OPS
SELECT TOP 10
	j.j_nombre AS Nombre_Jugador,
	e.e_nombre AS Nombre_Equipo,
	CASE 
        WHEN SUM(jb_tl) = 0 THEN 0
        ELSE 
            (SUM(jb_hits) - SUM(jb_dobles) - SUM(jb_triples) - SUM(jb_hr) + 
            (2 * SUM(jb_dobles)) + (3 * SUM(jb_triples)) + (4 * SUM(jb_hr))) / SUM(jb_tl) +
            (SUM(jb_hits) + SUM(jb_bb) + SUM(jb_bg)) / 
            (SUM(jb_tl) + SUM(jb_bb) + SUM(jb_bg) + SUM(jb_sacF))
    END AS OPS
FROM 
    JBateador jj
INNER JOIN 
    Jugador j ON jj.jugador = j.id_jugador
INNER JOIN 
    Equipo e ON j.equipo = e.id_equipo
WHERE
    e.categoria = 0
GROUP BY 
    j.j_nombre, e.e_nombre
HAVING
	sum(jb_ap) >= 0
ORDER BY 
    OPS DESC

--==========================================================================================

/*Conseguir el Jugador y Juegos Jugados*/

-- Bateadores
SELECT 
    j.j_nombre AS Jugador,
    COUNT(jj.id_jbateador) AS Juegos_Jugados
FROM 
    Jugador j
LEFT JOIN 
    JBateador jj ON j.id_jugador = jj.jugador
WHERE 
	(j.equipo = 0)
GROUP BY 
    j.j_nombre

-- Pichers
SELECT 
    j.j_nombre AS Jugador,
    COUNT(jj.id_jpicher) AS Juegos_Jugados
FROM 
    Jugador j
LEFT JOIN 
    JPicher jj ON j.id_jugador = jj.jugador
WHERE 
	(j.equipo = 0)
GROUP BY 
    j.j_nombre

--==========================================================================================

/*Mostrar la información de los Equipos por jornada*/
SELECT 
	numJornada AS Jornada, je_gano AS Ganados, je_perdio AS Perdidos,
	je_carrarasAnotadas AS Anotadas, je_carrerasRecibidas AS Recibidas, (select e_nombre from Equipo where id_equipo = rival) AS Rival
FROM
	JEquipo je
JOIN	
	Jornada j ON je.jornada = j.id_jornada
WHERE 
	equipo = 0

--==========================================================================================

/*Mostrar la información de los Jugadores por jornada*/

-- Bateadores
SELECT
	numJornada AS Jornada, jb_ap AS Apariciones, jb_tl AS Turnos_Legales,
	jb_hits AS Hits, jb_dobles AS Dobles, jb_triples AS Triples, jb_hr AS HomeRuns, jb_cp AS Carreras_Producidas, 
	jb_bb AS Bases, jb_bg AS Golpes, jb_br AS Robos, jb_sacF AS ElevadosSac, jb_toqueF AS ToquesSac
FROM
	JBateador jj
JOIN
	Jornada j ON jj.jornada = j.id_jornada
WHERE
	jugador = 64

-- Pichers
SELECT
	numJornada AS Jornada, jp_innings AS Innings, jp_gano AS Gano, jp_perdio AS Perdio, jp_carrerasPermitidas AS CarrerasPermitidas,
	jp_carrerasLimpias AS CarrerasLimpias, jp_ponches AS Ponches, jp_hits AS Hits, jp_basesBola AS Bases, jp_basesGolpe AS Golpes,
	jp_sacrificios AS Sacrificios, jp_legalesEnfrentados AS LegalesEnfrentados
FROM
	JPicher jj
JOIN
	Jornada j ON jj.jornada = j.id_jornada
WHERE
	jugador = 0


-- Suma de todas las estadisticas de los jugadores en determinado equipo
SELECT 
            Jugador.j_nombre AS Jugador, 
            COUNT(jb_ap) - 1 AS Juegos_Jugados, 
            SUM(jb_ap) AS Apariciones, 
            SUM(jb_tl) AS Turnos_Legales, 
            SUM(jb_hits) AS Hits, 
            SUM(jb_dobles) AS Dobles, 
            SUM(jb_triples) AS Triples, 
            SUM(jb_hr) AS HomeRuns, 
            SUM(jb_cp) AS Carreras_Producidas, 
            SUM(jb_br) AS Robos, 
            SUM(jb_bb) AS Bases_X_Bola, 
            SUM(jb_bg) AS Bases_X_Golpe, 
            SUM(jb_sacF) AS Elevados_Sacrificio, 
            SUM(jb_toqueF) AS Toques_Sacrificio, 
            SUM(jb_sacrificios) AS Sacrificios, 
            CASE 
            WHEN SUM(jb_tl) = 0 THEN 0 
            ELSE (SUM(jb_hits) / SUM(jb_tl)) 
            END AS Promedio,
            CASE 
            WHEN SUM(jb_tl) = 0 THEN 0 
            ELSE (SUM(jb_hits) - SUM(jb_dobles) - SUM(jb_triples) - SUM(jb_hr) + 
            (2 * SUM(jb_dobles)) + (3 * SUM(jb_triples)) + (4 * SUM(jb_hr))) / SUM(jb_tl) 
            END AS SLG,
            CASE 
            WHEN (SUM(jb_tl) + SUM(jb_bb) + SUM(jb_bg) + SUM(jb_sacF)) = 0 THEN 0 
            ELSE (SUM(jb_hits) + SUM(jb_bb) + SUM(jb_bg)) /
            (SUM(jb_tl) + SUM(jb_bb) + SUM(jb_bg) + SUM(jb_sacF)) 
            END AS OBP, 
            CASE 
            WHEN SUM(jb_tl) = 0 THEN 0 
            ELSE 
            (SUM(jb_hits) - SUM(jb_dobles) - SUM(jb_triples) - SUM(jb_hr) + 
            (2 * SUM(jb_dobles)) + (3 * SUM(jb_triples)) + (4 * SUM(jb_hr))) / SUM(jb_tl) + 
            (SUM(jb_hits) + SUM(jb_bb) + SUM(jb_bg)) / 
            (SUM(jb_tl) + SUM(jb_bb) + SUM(jb_bg) + SUM(jb_sacF)) 
            END AS OPS 
            FROM JBateador
            JOIN Jugador ON JBateador.jugador = Jugador.id_jugador
            WHERE Jugador.equipo = 48
            GROUP BY 
			Jugador.j_nombre;

--==========================================================================================

/*Seleccionar los Equipos por categoría*/
select e_nombre from Equipo where categoria = 0
--==========================================================================================

SELECT j_nombre FROM Jugador WHERE equipo = 64