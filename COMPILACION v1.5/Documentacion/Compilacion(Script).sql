/*------------------------------------------------------------------------------------------
							Liga de Beisbol Sertoma 

						PERIODO: VACACIONES DE VERANO 2024   

            Script de base de datos para llevar la compilación y estadistica
        
  Autor       : Angel David Avalos Carrillo
  Nombre      : Compilacion.sql
  Fecha       : JULIO/2024
  Compilador  : Miscrosoft SQL Server Management Studio
  Descripción : Este script contiene las tablas:
					1. Equipo
					2. Jugador
					3. Jornada
					4. JEquipo
					5. JJugador
				Con los atributos necesarios mas aparte
				las consultas que son requeridas para la 
				aplicación
==========================================================================================*/

create database COMPILACIONpruebas8

use COMPILACIONpruebas8

--==========================================================================================

--Crear la tabla equipo
Create table Equipo(
	id_equipo int identity primary key,
	e_nombre varchar(50) not null,
	e_categoria varchar(10) not null
)

--==========================================================================================

--Crear la tabla jugador (Los jugadores pertenecen a un equipo)
Create table Jugador(
	id_jugador int identity primary key,
	j_nombre varchar(60) not null,
	equipo int,
	constraint FK_JE foreign key (equipo) references Equipo (id_equipo)
	on delete cascade
	on update cascade
)

--==========================================================================================

--Crear tabla Jornada (Los jugadores y equipos juegan jornadas)
Create table Jornada(
	id_jornada int identity primary key,
	numJornada int not null UNIQUE,
	fechaInicio date not null,
	fechaFin date not null
)

--==========================================================================================

--Crear tabla de jornadas para los equipos
Create table JEquipo(
	id_jequipo int identity primary key,
	je_gano int not null,
	je_perdio int not null,
	je_carrarasAnotadas int null,
	je_carrerasRecibidas int null,
	jornada int,
	constraint FK_JEJO foreign key (jornada) references Jornada (id_jornada)
	on delete cascade
	on update cascade,
	equipo int,
	constraint FK_JE2 foreign key (equipo) references Equipo (id_equipo)
	on delete cascade
	on update cascade
)

--==========================================================================================

--Crear tabla de jornadas para los jugadores
Create table JJugador(
	id_jjugador int identity primary key,
	jj_ap decimal(10,2) null,
	jj_tl decimal(10,2) null,
	jj_hits decimal(10,2) null,
	jj_hr int null,
	jj_cp int null,
	jj_prom  as ((CASE WHEN jj_tl = 0 THEN 0 ELSE jj_hits / jj_tl END)),
	jj_br int null,
	jj_il decimal(10,2) null,
	jj_gano int null,
	jj_perdio int null,
	jornada int,
	constraint FK_JJJO foreign key (jornada) references Jornada (id_jornada)
	on delete cascade
	on update cascade,
	jugador int,
	constraint FK_JJ foreign key (jugador) references Jugador (id_jugador)
	on delete cascade
	on update cascade
)

--==========================================================================================

/*Añadir restricción para que cada jugador pueda tener solo un registro por jornada*/

ALTER TABLE JJugador
ADD CONSTRAINT UQ_Jugador_Jornada UNIQUE (jornada, jugador)

/* SELECT jornada, jugador, COUNT(*)
FROM JJugador
GROUP BY jornada, jugador
HAVING COUNT(*) > 1;

select j_nombre from Jugador where (id_jugador = 451)

SELECT J.j_nombre AS Jugador, E.e_nombre AS Equipo
FROM Jugador J
INNER JOIN Equipo E ON J.equipo = E.id_equipo
WHERE J.j_nombre = 'Ian Rodriguez'; */

--==========================================================================================

/*Añadir restriccion para que los equipos tengan solo un registro por jornada*/

ALTER TABLE JEquipo
ADD CONSTRAINT UQ_Equipo_Jornada UNIQUE (jornada, equipo);

--==========================================================================================

--Dar de alta equipos
insert into Equipo values --(?, ?)
/*('Cachorros', '5-6'),
('Piratas', '5-6'),
('Cachorros', '7-8'),
('Piratas', '7-8'),
('Cachorros', '9-10'),
('Piratas', '9-10'),
('Cachorros', '11-12'),
('Piratas', '11-12'),
('Cachorros', '13-14'),
('Piratas', '13-14'),
('Gigantes', '13-14')*/

--Modificar Equipos
UPDATE Equipo SET e_nombre = '', e_categoria = '' WHERE id_equipo = --(?)

--Dar de baja Equipos
DELETE FROM Equipo WHERE id_equipo = 16

select * from Equipo
where e_categoria like --? 

--==========================================================================================

--Dar de alta jugadores
insert into Jugador values --(?, ?)
/*('Jorge Avalos', 9),
('Gaby Avalos', 1),
('David Avalos', 9)*/

--Modificar Jugadores
UPDATE Jugador SET j_nombre = '',  equipo = 0 WHERE id_jugador = --?

--Dar de Baja Jugadores
DELETE FROM Jugador WHERE id_jugador = --?

select * from Jugador where equipo = --?

--==========================================================================================

--Dar de alta una jornada
insert into Jornada values --(?, ?, ?)
--Se da de alta la jornada 0, con el id #1, para que se de de alta las Jornadas por Equipo conn valores Nulos
--para que se muestren en la tabla de posiciones
/*(0,'2024-01-01','2024-12-31'),
(1, '2024-07-15', '2024-07-21'),
(2, '2024-07-22', '2024-07-28'),
(3, '2024-07-29', '2024-08-04')*/

--Modificar una Jornada
UPDATE Jornada SET numJornada = 0, fechaInicio = '', fechaFin = ''
WHERE id_jornada = --?

--Dar de Baja Jornadas
DELETE FROM Jornada WHERE id_jornada = --?

select * from Jornada

--==========================================================================================

--Vincular las jornadas a los equipos
insert into JEquipo values --(?, ?, ?, ?, ?, ?)
/*(0,0,0,0,1,2),
(1,0,10,6,2,1),
(0,1,3,12,3,1),
(1,0,4,2,2,9),
(1,0,9,0,3,9),
(0,1,5,3,2,10),
(1,0,11,8,3,10),
(1,0,4,1,2,11),
(0,1,0,10,3,11)*/

--Modifcar las jornadas de los equipos
UPDATE JEquipo SET je_gano = 0, je_perdio = 0, je_carrarasAnotadas = 0, je_carrerasRecibidas = 0
WHERE id_jequipo = --?

--Dar de baja jornadas de los equipos
DELETE FROM JEquipo WHERE id_jequipo = --?

select * from JEquipo
where equipo = --?

--==========================================================================================

--Vincular las jornadas a los jugadores
insert into JJugador values --(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
/*(4,3,2,0,1,1,null,null,null,1,1),
(5,4,3,1,3,1,4.3,1,0,2,1),
(4,4,1,0,0,1,3,0,1,1,2),
(3,2,1,0,1,0,null,null,null,2,2),
(5,3,2,1,2,0,null,null,null,3,1),
(4,4,2,0,1,1,5.0,1,0,1,3),
(4,4,2,0,1,1,4.0,0,1,1,3)*/

--Modifcar las jornadas de los jugadores
UPDATE JJugador SET jj_ap = 0, jj_tl = 0, jj_hits = 0, jj_hr = 0, 
jj_cp = 0, jj_il = 0, jj_gano = 0, jj_perdio = 0 WHERE id_jjugador = --?

--Dar de baja jornadas de los jugadores
DELETE FROM JJugador WHERE id_jjugador = --?

select * from JJugador 

--==========================================================================================

--Consultas que serán utilizadas para la aplicación

/*Claves de los Equipos*/
SELECT
	id_equipo AS Clave
FROM 
	Equipo
WHERE
	(e_nombre = '?' and e_categoria = '?')

/*Claves de los Jugadores*/
SELECT
	id_jugador
FROM 
	Jugador
WHERE
	(j_nombre = '?' and equipo = ?)

/*Clave de las Jornadas*/
SELECT 
	id_jornada
FROM 
	Jornada
WHERE 
	(numJornada = ?)

--==========================================================================================

/*Conseguir el Jugador, Apariciones, Turnos Legales, Hits, HomeRuns, Carreras Producidas,
Promedio de Bateo, Innings Lanzados, Ganados, Perdidos*/

SELECT 
	Jugador.j_nombre as Jugador, 
	COUNT(jj_ap)-1 AS Juegos_Jugados,
	sum(jj_ap) AS Apariciones, 
	sum(jj_tl) AS Turnos_Legales, 
	sum(jj_hits) as Hits, 
	sum(jj_hr) as HomeRuns, 
	sum(jj_cp) as Carreras_Producidas,
	CASE
		WHEN SUM(jj_tl) = 0 THEN 0
		ELSE (sum(jj_hits) / sum(jj_tl)) 
	END AS Promedio,
	sum(jj_br) as Robos,
	sum(jj_il) as Innings_Lanzados,
	sum(jj_gano) as Ganados, 
	sum(jj_perdio) as Perdidos 
FROM JJugador 
JOIN 
    Jugador ON JJugador.jugador = Jugador.id_jugador
WHERE 
	(Jugador.equipo = 12)
GROUP BY 
	Jugador.j_nombre

--==========================================================================================

/*Conseguir el Equipo, Juegos Jugados, Ganados, Perdidos, Carreras Anotadas, Carreras Recibidas y Diferencial*/
SELECT 
    e.e_nombre AS Equipo,
	--e.e_categoria AS Categoria,
	COUNT(*) AS Juegos_Jugados,
    SUM(je.je_gano) AS Ganados,
    SUM(je.je_perdio) AS Perdidos,
	CASE 
        WHEN SUM(je.je_gano) + SUM(je.je_perdio) = 0 THEN 0
        ELSE CAST(SUM(je.je_gano) AS FLOAT) / (SUM(je.je_gano) + SUM(je.je_perdio))
    END AS Porcentaje_De_Victorias,
    SUM(je.je_carrarasAnotadas) AS Carreras_Anotadas,
    SUM(je.je_carrerasRecibidas) AS Carreras_Recibidas,
	(SUM(je.je_carrarasAnotadas) - SUM(je.je_carrerasRecibidas)) AS Diferencial
FROM 
    Equipo e
JOIN 
    JEquipo je ON e.id_equipo = je.equipo
WHERE
	(e.e_categoria = '?')
GROUP BY 
    e.e_nombre
	--e.e_categoria
ORDER BY
	Porcentaje_De_Victorias DESC,
	Diferencial DESC

--==========================================================================================

/*Conseguir los 10 mayores registros de*/
--Promedio de Bateo
SELECT TOP 10
    j.j_nombre AS Nombre_Jugador,
    e.e_nombre AS Nombre_Equipo,
    SUM(jj.jj_ap) AS Apariciones,
    SUM(jj.jj_tl) AS Turnos_Legales,
    SUM(jj.jj_hits) AS Hits,
    CASE 
        WHEN SUM(jj.jj_tl) = 0 THEN 0
        ELSE SUM(jj.jj_hits) / SUM(jj.jj_tl)
    END AS Promedio
FROM 
    JJugador jj
INNER JOIN 
    Jugador j ON jj.jugador = j.id_jugador
INNER JOIN 
    Equipo e ON j.equipo = e.id_equipo
WHERE
    e.e_categoria = '7-8'
GROUP BY 
    j.j_nombre, e.e_nombre
HAVING
	sum(jj_ap) >= 5
ORDER BY 
    Promedio DESC,   -- Ordena por promedio en orden descendente
    Hits DESC,       -- Luego ordena por hits en orden descendente
	Turnos_Legales DESC,
	Apariciones DESC;


--==========================================================================================

--HomeRuns
SELECT TOP 10
	j.j_nombre AS Nombre_Jugador,
    e.e_nombre AS Nombre_Equipo,
	sum(jj.jj_hr) AS HomeRuns
FROM 
    JJugador jj
INNER JOIN 
    Jugador j ON jj.jugador = j.id_jugador
INNER JOIN 
    Equipo e ON j.equipo = e.id_equipo
WHERE
	e.e_categoria = '?'
GROUP BY 
    j.j_nombre, e.e_nombre
ORDER BY 
    HomeRuns DESC;

--==========================================================================================

--Carreras Producidas
SELECT TOP 10
	j.j_nombre AS Nombre_Jugador,
    e.e_nombre AS Nombre_Equipo,
	sum(jj.jj_cp) AS Producidas
FROM 
    JJugador jj
INNER JOIN 
    Jugador j ON jj.jugador = j.id_jugador
INNER JOIN 
    Equipo e ON j.equipo = e.id_equipo
WHERE
	e.e_categoria = '?'
GROUP BY 
    j.j_nombre, e.e_nombre
ORDER BY 
    Producidas DESC;

--==========================================================================================

--Robos de Base
SELECT TOP 10
	j.j_nombre AS Nombre_Jugador,
    e.e_nombre AS Nombre_Equipo,
	sum(jj.jj_br) AS Robos
FROM 
    JJugador jj
INNER JOIN 
    Jugador j ON jj.jugador = j.id_jugador
INNER JOIN 
    Equipo e ON j.equipo = e.id_equipo
WHERE
	e.e_categoria = '?'
GROUP BY 
    j.j_nombre, e.e_nombre
ORDER BY 
    Robos DESC;

--==========================================================================================

--Ganados y Perdidos
SELECT TOP 10
	j.j_nombre AS Nombre_Jugador,
    e.e_nombre AS Nombre_Equipo,
	sum(jj.jj_gano) AS Ganados,
	sum(jj.jj_perdio) AS Perdidos,
	CASE 
    WHEN SUM(jj.jj_gano) + SUM(jj.jj_perdio) = 0 THEN 0
    ELSE CAST(SUM(jj.jj_gano) AS FLOAT) / (SUM(jj.jj_gano) + SUM(jj.jj_perdio))
	END AS Porcentaje
FROM 
    JJugador jj
INNER JOIN 
    Jugador j ON jj.jugador = j.id_jugador
INNER JOIN 
    Equipo e ON j.equipo = e.id_equipo
WHERE
	e.e_categoria = '?'
GROUP BY 
    j.j_nombre, e.e_nombre
ORDER BY 
    Porcentaje DESC,
	Ganados DESC,
	Perdidos DESC;


--==========================================================================================

/*Conseguir el Jugador y Juegos Jugados*/
SELECT 
    j.j_nombre AS Jugador,
    COUNT(jj.id_jjugador) AS Juegos_Jugados
FROM 
    Jugador j
LEFT JOIN 
    JJugador jj ON j.id_jugador = jj.jugador
WHERE 
	(j.equipo = ?)
GROUP BY 
    j.j_nombre

--==========================================================================================

/*Mostrar la información de los Equipos por jornada*/
SELECT 
	numJornada AS Jornada, je_gano AS Ganados, je_perdio AS Perdidos,
	je_carrarasAnotadas AS Anotadas, je_carrerasRecibidas AS Recibidas
FROM
	JEquipo je
JOIN	
	Jornada j ON je.jornada = j.id_jornada
WHERE 
	equipo = ?

--==========================================================================================

/*Mostrar la información de los Jugadores por jornada*/
SELECT
	numJornada AS Jornada, jj_ap AS Apariciones, jj_tl AS Turnos_Legales,
	jj_hits AS Hits, jj_hr AS HomeRuns, jj_cp AS Carreras_Producidas,
	jj_prom AS Promedio, jj_br AS Robos, jj_il AS Innings_Lanzados, jj_gano AS Ganados,
	jj_perdio AS Perdidos
FROM
	JJugador jj
JOIN
	Jornada j ON jj.jornada = j.id_jornada
WHERE
	jugador = ?

--==========================================================================================

/*Seleccionar los Equipos por categoría*/
select e_nombre from Equipo where e_categoria = '?'
--==========================================================================================


--select numJornada
--from Jornada

select * from JJugador where id_jequipo = 18 