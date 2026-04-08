# Compilacion y Estadistica de Beisbol (COMPILACION v1.5)

Aplicacion de escritorio en Java (Swing) para administrar estadisticas de ligas de beisbol/softbol.

## Caracteristicas

- Altas, bajas y modificaciones de catalogos principales.
- Consulta de jornadas y juegos jugados.
- Consulta de standings, stats individuales y el núcleo principal de stats de beisbol/softbol.
- Reportes de lideres (bateo y picheo).
- Interfaz grafica con multiples formularios (`Frames`).
- Conexion a SQL Server desde `Clases.Conexion`.

## Tecnologias

- Java 17
- NetBeans (proyecto Ant)
- Microsoft SQL Server
- JDBC Driver para SQL Server (`mssql-jdbc-12.4.2.jre11.jar`)

## Estructura principal

- `src/Clases`: logica de conexion y operaciones de datos.
- `src/Frames`: formularios e interfaz grafica.
- `Documentacion`: scripts SQL y diagramas.
- `build.xml`: script Ant del proyecto.

## Requisitos previos

1. Tener instalado JDK 17.
2. Tener SQL Server en ejecucion.
3. Crear la base de datos usando los scripts en `Documentacion`.
4. Tener disponible el driver JDBC de SQL Server.

## Configuracion de base de datos

La conexion se define en `src/Clases/Conexion.java`.

Actualmente usa una cadena similar a:

- Servidor: `localhost:1433`
- Base de datos: `CompilacionYEstadistica`
- Usuario: `sa`
- Password: `12345678`

Tambien verifica que la propiedad del classpath en `nbproject/project.properties` apunte a la ruta correcta del archivo `mssql-jdbc-12.4.2.jre11.jar` en tu equipo.

## Notas

- Este proyecto fue generado como proyecto Java Ant en NetBeans.

## Autor

Angel David Avalos Carrillo
