/*------------------------------------------------------------------------------------------
                        Beisbol y Softbol 

                    PERIODO: VACACIONES DE INVIERNO 2024 - 25   

            Clase para conectar a la base de datos de Compilación
        
  Autor       : Angel David Avalos Carrillo
  Nombre      : Conexion.java
  Fecha       : DICIEMBRE/2024
  Compilador  : JDK 17 + Java NetBeans 22
  Descripción : Esta clase contiene datos para la conexión con
                la base de datos como:
                    1. Conectar
                    2. Desconectar
                Así como los métodos que se requieren para manejarla:
                    1. Alta (Ligas, Temporadas, Categorias, Equipos, Jugadores, Jornadas, JEquipos, JBateador, JPicher)
                    2. Baja (Ligas, Temporadas, Categorias, Equipos, Jugadores, Jornadas, JEquipos, JBateador, JPicher)
                    3. Modificar (Ligas, Temporadas, Categorias, Equipos, Jugadores, Jornadas, JEquipos, JBateador, JPicher)
                Y los métodos para mostrar la información de principal interés:
                    1. Mostrar la información general (Equipos, Jugadores)
                    2. Mostrar los lideres (Varios Departamentos, Ahora con filtro de apariciones e innings minimos)
                    3. Mostra la información jornada tras jornada (Equipos, Jugadores)
                Asi como las claves de las principales tablas
                    1. Claves (Ligas, Temporadas, Categorias, Equipos, Jugadores, Jornadas, JEquipos, JBateador, JPicher)
                Tambien Muestra equipos y jugadores
                    1. Equipos en una categoría
                    2. Jugadores  en un Equipo
                    3. Entre otras varias
                Agregar un método para imprimir cualquier tabla en un archivo de texto
==========================================================================================*/

package Clases;

//------------------------------------------------------------------------------------------

//import Frames.LogIn;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableModel;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.table.TableColumnModel;

//------------------------------------------------------------------------------------------

public class Conexion {

//------------------------------------------------------------------------------------------
    
    private Connection oConexion;
    TableColumnModel modeloColumna;
    DecimalFormat df = new DecimalFormat("#.000");

    
    //------------------------------------------------------------------------------------------

    public Conexion() {
        oConexion = null;
    }

    //------------------------------------------------------------------------------------------

    // Método para conectar con la base de datos
    public Connection conectar(){
        try {
            String cadena = "jdbc:sqlserver://localhost:1433;databaseName=CompilacionYEstadistica;integratedSecurity=false;encrypt=true;trustServerCertificate=true";
            oConexion =  DriverManager.getConnection(cadena,"sa","12345678");  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"No se pudo conectar a la base de datos..."+ex.toString());
        }
       
        return oConexion;
    }
    
   //------------------------------------------------------------------------------------------

    //Método para desconectar
    public void desconectar() {
        try {
            oConexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR DE DESCONEXION " + ex.getMessage());
        }
    }
    
    //------------------------------------------------------------------------------------------

    // Ligas
    // Alta
    public void altaLiga(String nombre, String tipo) {
        conectar();
        String query = "INSERT INTO Liga VALUES (?, ?)";
        try {
            PreparedStatement PS = oConexion.prepareStatement(query);
            PS.setString(1, nombre);
            PS.setString(2, tipo);
            PS.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el alta de la Liga", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Modificar
    public void modificarLiga(String nNombre, String nTipo, String nombre) {
        conectar();
        String query = "UPDATE Liga SET liga_nombre = '" + nNombre + 
                "', liga_tipo = '" + nTipo + "' "
                + "WHERE id_liga = " + claveLiga(nombre);
        try {
            PreparedStatement PS = oConexion.prepareStatement(query);
            PS.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar la Liga", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    // Baja
    public void bajaLiga(String nombre) {
        conectar();
        String query = "DELETE FROM Liga WHERE id_liga = ?";
        
        try {
            PreparedStatement PS = oConexion.prepareStatement(query);
            PS.setInt(1, claveLiga(nombre));
            PS.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la baja de la Liga", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Temporadas
    // Alta
    public void altaTemporada(String liga, String nombre, String periodo) {
        conectar();
        String query = "INSERT INTO Temporada VALUES (?, ?, ?)";
        try {
            PreparedStatement PS = oConexion.prepareStatement(query);
            PS.setString(1, nombre);
            PS.setString(2, periodo);
            PS.setInt(3, claveLiga(liga));
            PS.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el alta de la Temporada", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //Modificar
    public void modificarTemporada(String nNombre, String nPeriodo, String nombre) {
        conectar();
        String query = "update Temporada set temp_nombre = '" + nNombre + 
                "', temp_periodo = '" + nPeriodo + "' "
                + "WHERE id_temporada = " + claveTemporada(nombre);
        try {
            PreparedStatement PS = oConexion.prepareStatement(query);
            PS.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar la Temporada", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    // Baja
    public void bajaTemporada(String nombre) {
        conectar();
        String query = "DELETE FROM Temporada WHERE id_temporada = ?";
        
        try {
            PreparedStatement PS = oConexion.prepareStatement(query);
            int aux = claveTemporada(nombre);
            PS.setInt(1, claveTemporada(nombre));
            PS.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la baja de la Temporada", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Categorías
    // Alta
    public void altaCategoria(String liga, String nombre) {
        conectar();
        String query = "INSERT INTO Categoria VALUES (?, ?)";
        try {
            PreparedStatement PS = oConexion.prepareStatement(query);
            PS.setString(1, nombre);
            PS.setInt(2, claveLiga(liga));
            PS.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el alta de la Categoria", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //Modificar
    public void modificarCategoria(String nNombre, String categoria) {
        conectar();
        String query = "update Categoria set cat_nombre = '" + nNombre
                + "' WHERE id_categoria = " + claveCategoria(categoria);
        try {
            PreparedStatement PS = oConexion.prepareStatement(query);
            PS.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar la Categoria", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    // Baja
    public void bajaCategoria(String categoria) {
        conectar();
        String query = "DELETE FROM Categoria WHERE id_categoria = ?";
        
        try {
            PreparedStatement PS = oConexion.prepareStatement(query);
            PS.setInt(1, claveCategoria(categoria));
            PS.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la baja de la Categoria", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //Usar insert para dar de alta Equipos
    public void altaEquipo(String nombre, String temporada, String categoria){
        conectar();
        String query = "INSERT INTO Equipo VALUES (?, ?,?)";
        try {
            PreparedStatement PS = oConexion.prepareStatement(query);
            PS.setString(1, nombre);
            PS.setInt(2, claveTemporada(temporada));
            PS.setInt(3, claveCategoria(categoria));
            PS.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el alta del Equipo", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    //------------------------------------------------------------------------------------------
    
    //Usar Update para modificar los datos de los equipos
    public void modificarEquipo(String nombre, String categoria, int id){
        conectar();
        String query = "UPDATE Equipo SET e_nombre = '" + nombre + 
                "', categoria = '" + claveCategoria(categoria)+ 
                "' WHERE id_equipo = ?";
        try {
            PreparedStatement PS = oConexion.prepareStatement(query);
            PS.setInt(1, id);
            PS.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar el Equipo", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    //------------------------------------------------------------------------------------------
    
    //Usar Delete para dar de baja Equipos
    public void bajaEquipo(String nombre, String categoria, String temporada){
        conectar();
        String query = "DELETE FROM Equipo WHERE id_equipo = ? ";
        try {
            PreparedStatement PS = oConexion.prepareStatement(query);
            PS.setInt(1, claveEquipo(nombre, categoria, temporada));
            PS.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la baja del Equipo", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    //------------------------------------------------------------------------------------------
    
    //Usar Insert para dar de alta Jugadores
    public void altaJugador(String nombre, int equipo){
        conectar();
        String query = "INSERT INTO Jugador VALUES (?, ?)";
        try {
            PreparedStatement PS = oConexion.prepareStatement(query);
            PS.setString(1, nombre);
            PS.setInt(2, equipo);
            PS.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el alta del Jugador", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    //------------------------------------------------------------------------------------------
    
    //Usar Update para modificar los datos de los Jugadores
    public void modificarJugador(String nombre, int equipo, int id){
        conectar();
        String query = "UPDATE Jugador SET j_nombre = '" + nombre + "', equipo = '"
                + equipo + "' WHERE id_jugador = " + id;
        try {
            PreparedStatement PS = oConexion.prepareStatement(query);
            PS.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar el Jugador", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    //------------------------------------------------------------------------------------------
    
    //Usar Delete para dar de baja Jugadores
    public void bajaJugador(int id){
        conectar();
        String query = "DELETE FROM Jugador WHERE id_jugador = " + id;
        try {
            PreparedStatement PS = oConexion.prepareStatement(query);
            PS.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la baja del Jugador", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    //------------------------------------------------------------------------------------------
    
    //Usar Insert para dar de alta Jornadas
    public void altaJornada(String numJornada, String fechaI, String fechaF, String temporada){
        conectar();
        String query = "INSERT INTO Jornada VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement PS = oConexion.prepareStatement(query);
            PS.setString(1, numJornada);
            PS.setString(2, fechaI);
            PS.setString(3, fechaF);
            PS.setInt(4, claveTemporada(temporada));
            PS.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el alta de la Jornada", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    //------------------------------------------------------------------------------------------
    
    //Usar Update para modifcar la información de las Jornadas
    public void modificarJornada(String numJornada, String fechaI, String fechaF, int id){
        conectar();
        String query = "UPDATE Jornada SET numJornada = " + numJornada + ", fechaInicio = '"
                + fechaI + "', fechaFin = '" + fechaF + "' WHERE id_jornada = " + id;
        try {
            PreparedStatement PS = oConexion.prepareStatement(query);
            PS.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar la Jornada", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    //------------------------------------------------------------------------------------------
    
    //Usar Delete para eliminar las Jornadas
    public void bajaJornada(int id){
        conectar();
        String query = "DELETE FROM Jornada WHERE id_jornada = " + id;
        try {
            PreparedStatement PS = oConexion.prepareStatement(query);
            PS.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la baja de la Jornada", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    //------------------------------------------------------------------------------------------
    
    //Dar de alta las Jornadas de los Equipos
    public void altaJEquipo(int gano, int perdio, int anotadas, int recibidas, int rival, int jornada, int equipo){
        conectar();
        String query = "INSERT INTO JEquipo VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement PS = oConexion.prepareStatement(query);
            PS.setInt(1, gano);
            PS.setInt(2, perdio);
            PS.setInt(3, anotadas);
            PS.setInt(4, recibidas);
            PS.setInt(5, jornada);
            PS.setInt(6, equipo);
            PS.setInt(7, rival);
            PS.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el alta de la Jornada del Equipo", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    //------------------------------------------------------------------------------------------
    
    //Modificar la información de las Jornadas de los Equipos
    public void modificarJEquipo(int gano, int perdio, int anotadas, int recibidas, int rival, int id){
        conectar();
        String query = "UPDATE JEquipo SET je_gano = " + gano + ", je_perdio = "
                + perdio + ", je_carrarasAnotadas = " + anotadas + 
                ", je_carrerasRecibidas = " + recibidas + ", rival =  " + rival + "WHERE id_jequipo = " + id;
        try {
            PreparedStatement PS = oConexion.prepareStatement(query);
            PS.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar la Jornada del Equipo", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    //------------------------------------------------------------------------------------------
    
    //Dar de baja las Jornadas de los Equipos
    public void bajaJEquipo(int id){
        conectar();
        String query = "DELETE FROM JEquipo WHERE id_jequipo = " + id;
        try {
            PreparedStatement PS = oConexion.prepareStatement(query);
            PS.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la baja de la Jornada del Equipo", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    //------------------------------------------------------------------------------------------
    
    //Dar de alta Jornadas de los Jugadores
    public void altaJBateador(double ap, double tl, int hits, int dobles, int triples, int hr, int cp, int bb, int bg, int br, int sacF, int toqueF, String jornada, int jugador){
        conectar();
        String query = "INSERT INTO JBateador VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement PS = oConexion.prepareStatement(query);
            PS.setDouble(1, ap);
            PS.setDouble(2, tl);
            PS.setInt(3, hits);
            PS.setInt(4, dobles);
            PS.setInt(5, triples);
            PS.setInt(6, hr);
            PS.setInt(7, cp);
            PS.setInt(8, bb);
            PS.setInt(9, bg);
            PS.setInt(10, br);
            PS.setInt(11, sacF);
            PS.setInt(12, toqueF);
            PS.setInt(13, claveJornada(jornada));
            PS.setInt(14, jugador);
            PS.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el alta de la Jornada del Jugador", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    //------------------------------------------------------------------------------------------
    
    //Modificar la información de las Jornadas de los Jugadores
    public void modificarJBateador(double ap, double tl, int hits, int dobles, int triples, int hr, int cp, int bb, int bg, int br, int sacF, int sacT, int id){
        conectar();
        String query = "UPDATE JBateador SET jb_ap = " + ap + ", jb_tl = " + tl + ", jb_hits = " + hits + 
                ", jb_dobles = " + dobles + ", jb_triples = " + triples + ", jb_hr = " + hr + ", jb_cp = " + cp + 
                ", jb_bb = " + bb + ", jb_bg = " + bg + ", jb_br = " + br + ", jb_sacF = " + sacF + 
                ", jb_toqueF = " + sacT + " WHERE id_jbateador = " + id;
        try {
            PreparedStatement PS = oConexion.prepareStatement(query);
            PS.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar la Jornada del Jugador", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    //------------------------------------------------------------------------------------------
    
    //Dar de baja las Jornadas de los Jugadores
    public void bajaJBateador(int id){
        conectar();
        String query = "DELETE FROM JBateador WHERE id_jbateador = " + id;
        try {
            PreparedStatement PS = oConexion.prepareStatement(query);
            PS.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la baja de la Jornada del Jugador", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    //------------------------------------------------------------------------------------------
    
    public void altaJPicher(double innings, int gano, int perdio, int cp, int cl, int k, int h, int bb, int bg, int sac, double le, int jornada, int jugador) {
        conectar();
        String query = "INSERT INTO JPicher VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement PS = oConexion.prepareStatement(query);
            PS.setDouble(1, innings);
            PS.setInt(2, gano);
            PS.setInt(3, perdio);
            PS.setInt(4, cp);
            PS.setInt(5, cl);
            PS.setInt(6, k);
            PS.setInt(7, h);
            PS.setInt(8, bb);
            PS.setInt(9, bg);
            PS.setInt(10, sac);
            PS.setDouble(11, le);
            PS.setInt(12, jornada);
            PS.setInt(13, jugador);
            PS.executeUpdate();
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el alta de la Jornada del Jugador", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void modificarJPicher(double innings, int gano, int perdio, int cp, int cl, int k, int h, int bb, int bg, int sac, double le, int id) {
        conectar();
        String query = "UPDATE JPicher SET jp_innings = " + innings + ", jp_gano = " + gano + ", jp_perdio = " + perdio + 
                ", jp_carrerasPermitidas = " + cp + ", jp_carrerasLimpias = " + cl + ", jp_ponches = " + k + ", jp_hits = " + h + 
                ", jp_basesBola = " + bb + ", jp_basesGolpe = " + bg + ", jp_sacrificios = " + sac + ", jp_legalesEnfrentados = " + le + 
                "WHERE id_jpicher = " + id;
        try {
            PreparedStatement PS = oConexion.prepareStatement(query);
            PS.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar la Jornada del Jugador", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    public void bajaJPicher(int id) {
        conectar();
        String query = "delete from JPicher where id_jpicher = " + id;
        try {
            PreparedStatement PS = oConexion.prepareStatement(query);
            PS.execute();
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la baja de la Jornada del Jugador", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    //Mostrar la información de los Equipos (sumatoria de las jornadas)
    public void mostrarEquipo(DefaultTableModel Tabla, String categoria, String temporada){
        conectar();
        //Consultar solicitado
        //Separando por categorias 
        String query =  "WITH Estadisticas AS (\n"
                + "    SELECT  \n"
                + "        e.id_equipo,\n"
                + "        e.e_nombre,\n"
                + "        COUNT(je.id_jequipo) AS Juegos_Jugados,\n"
                + "        SUM(je.je_gano) AS Ganados,\n"
                + "        SUM(je.je_perdio) AS Perdidos,\n"
                + "        CAST(SUM(je.je_gano) AS FLOAT) / NULLIF(SUM(je.je_gano + je.je_perdio), 0) AS Porcentaje_Victorias,\n"
                + "        SUM(je.je_carrarasAnotadas) AS Carreras_Anotadas,\n"
                + "        SUM(je.je_carrerasRecibidas) AS Carreras_Recibidas,\n"
                + "        SUM(je.je_diferencial) AS Diferencial\n"
                + "    FROM \n"
                + "        Equipo e\n"
                + "    JOIN \n"
                + "        JEquipo je ON e.id_equipo = je.equipo\n"
                + "    WHERE \n"
                + "        e.categoria = " + claveCategoria(categoria) + " and e.temporada = " + claveTemporada(temporada) + "\n"
                + "    GROUP BY \n"
                + "        e.id_equipo, e.e_nombre\n"
                + "),\n"
                + "-- Encuentra los duelos directos entre equipos con el mismo porcentaje\n"
                + "PartidosEntreEmpatados AS (\n"
                + "    SELECT \n"
                + "        je.equipo,\n"
                + "        je.rival,\n"
                + "        SUM(CASE WHEN je.je_gano = 1 THEN 1 ELSE 0 END) AS GanadosContra,\n"
                + "        SUM(je.je_carrarasAnotadas - je.je_carrerasRecibidas) AS DiferenciaContra\n"
                + "    FROM \n"
                + "        JEquipo je\n"
                + "    JOIN Estadisticas e1 ON je.equipo = e1.id_equipo\n"
                + "    JOIN Estadisticas e2 ON je.rival = e2.id_equipo\n"
                + "    WHERE \n"
                + "        e1.Porcentaje_Victorias = e2.Porcentaje_Victorias\n"
                + "    GROUP BY \n"
                + "        je.equipo, je.rival\n"
                + "),\n"
                + "ResumenDesempate AS (\n"
                + "    SELECT \n"
                + "        equipo,\n"
                + "        SUM(GanadosContra) AS TotalGanadosDirectos,\n"
                + "        SUM(DiferenciaContra) AS TotalDiferenciaDirecta\n"
                + "    FROM \n"
                + "        PartidosEntreEmpatados\n"
                + "    GROUP BY \n"
                + "        equipo\n"
                + ")\n"
                + "SELECT \n"
                + "    e.e_nombre AS Equipo,\n"
                + "    es.Juegos_Jugados,\n"
                + "    es.Ganados,\n"
                + "    es.Perdidos,\n"
                + "    es.Porcentaje_Victorias AS Porcentaje_De_Victorias,\n"
                + "    es.Carreras_Anotadas,\n"
                + "    es.Carreras_Recibidas,\n"
                + "    es.Diferencial,\n"
                + "    COALESCE(rd.TotalGanadosDirectos, 0) AS Ganados_Directos,\n"
                + "    COALESCE(rd.TotalDiferenciaDirecta, 0) AS Diferencia_Directa\n"
                + "FROM \n"
                + "    Estadisticas es\n"
                + "JOIN \n"
                + "    Equipo e ON es.id_equipo = e.id_equipo\n"
                + "LEFT JOIN \n"
                + "    ResumenDesempate rd ON es.id_equipo = rd.equipo\n"
                + "ORDER BY \n"
                + "    es.Porcentaje_Victorias DESC,\n"
                + "    Ganados_Directos DESC,\n"
                + "    Diferencia_Directa DESC,\n"
                + "    es.Diferencial DESC;";
        
        try(PreparedStatement PS = oConexion.prepareStatement(query);
            ResultSet rs = PS.executeQuery()){
            
            Tabla.setRowCount(0);
            
            //Guardar los datos en cada renglón
            while(rs.next()){
                String equipo = rs.getString("Equipo");
                int juegos = rs.getInt("Juegos_Jugados");
                int ganados = rs.getInt("Ganados");
                int perdidos = rs.getInt("Perdidos");
                int diferencial = rs.getInt("Diferencial");
                int anotadas = rs.getInt("Carreras_Anotadas");
                int recibidas = rs.getInt("Carreras_Recibidas");
                float porcentaje = rs.getFloat("Porcentaje_De_Victorias");
                
                //Insertarlos en la tabla
                Tabla.addRow(new Object[]{equipo, juegos, ganados, perdidos,
                                          anotadas, recibidas, df.format(porcentaje), diferencial});
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error mostrando los Equipos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    //------------------------------------------------------------------------------------------
    
    //Mostrar la información de los Jugadores (sumatoria de las jornadas)
    public void mostrarBateador(DefaultTableModel Tabla, int id){
        conectar();
        //Consulta para obtener los datos que se desean,
        //Separado por equipo, agrupado por jugador
        String query = "SELECT " +
            "Jugador.j_nombre AS Jugador, " +
            "COUNT(jb_ap) AS Juegos_Jugados, " +
            "SUM(jb_ap) AS Apariciones, " +
            "SUM(jb_tl) AS Turnos_Legales, " +
            "SUM(jb_hits) AS Hits, " +
            "SUM(jb_dobles) AS Dobles, " +
            "SUM(jb_triples) AS Triples, " +
            "SUM(jb_hr) AS HomeRuns, " +
            "SUM(jb_cp) AS Carreras_Producidas, " +
            "SUM(jb_br) AS Robos, " +
            "SUM(jb_bb) AS Bases_X_Bola, " +
            "SUM(jb_bg) AS Bases_X_Golpe, " +
            "SUM(jb_sacF) AS Elevados_Sacrificio, " +
            "SUM(jb_toqueF) AS Toques_Sacrificio, " +
            "SUM(jb_sacrificios) AS Sacrificios, " +
            "CASE " +
            "WHEN SUM(jb_tl) = 0 THEN 0 " +
            "ELSE (SUM(jb_hits) / SUM(jb_tl)) " +
            "END AS Promedio, " +
            "CASE " +
            "WHEN SUM(jb_tl) = 0 THEN 0 " +
            "ELSE (SUM(jb_hits) - SUM(jb_dobles) - SUM(jb_triples) - SUM(jb_hr) + " +
            "(2 * SUM(jb_dobles)) + (3 * SUM(jb_triples)) + (4 * SUM(jb_hr))) / SUM(jb_tl) " +
            "END AS SLG, " +
            "CASE " +
            "WHEN (SUM(jb_tl) + SUM(jb_bb) + SUM(jb_bg) + SUM(jb_sacF)) = 0 THEN 0 " +
            "ELSE (SUM(jb_hits) + SUM(jb_bb) + SUM(jb_bg)) / " +
            "(SUM(jb_tl) + SUM(jb_bb) + SUM(jb_bg) + SUM(jb_sacF)) " +
            "END AS OBP, " +
            "CASE " +
            "WHEN SUM(jb_tl) = 0 THEN 0 " +
            "ELSE " +
            "(SUM(jb_hits) - SUM(jb_dobles) - SUM(jb_triples) - SUM(jb_hr) + " +
            "(2 * SUM(jb_dobles)) + (3 * SUM(jb_triples)) + (4 * SUM(jb_hr))) / SUM(jb_tl) + " +
            "(SUM(jb_hits) + SUM(jb_bb) + SUM(jb_bg)) / " +
            "(SUM(jb_tl) + SUM(jb_bb) + SUM(jb_bg) + SUM(jb_sacF)) " +
            "END AS OPS " +
            "FROM JBateador " +
            "JOIN Jugador ON JBateador.jugador = Jugador.id_jugador " +
            "WHERE Jugador.equipo = " + id + " " +
            "GROUP BY " +
            "Jugador.j_nombre " +
            "ORDER BY " +
            "Juegos_Jugados DESC";
        
        try (PreparedStatement PS = oConexion.prepareStatement(query);
            ResultSet rs = PS.executeQuery()){
        
        Tabla.setRowCount(0);
        
        //Guardar los datos de cada renglón
            while (rs.next()) {
                    String jugador = rs.getString("Jugador");
                    int juegosjugados = rs.getInt("Juegos_Jugados");
                    double apariciones = rs.getDouble("Apariciones");
                    double turnosLegales = rs.getDouble("Turnos_Legales");
                    int hits = rs.getInt("Hits");
                    int dobles = rs.getInt("dobles");
                    int triples = rs.getInt("triples");
                    int homeRuns = rs.getInt("HomeRuns");
                    int carrerasProducidas = rs.getInt("Carreras_Producidas");
                    int bb = rs.getInt("Bases_X_Bola");
                    int bg = rs.getInt("Bases_X_Golpe");
                    int br = rs.getInt("Robos");
                    int ts = rs.getInt("Toques_Sacrificio");
                    int fs = rs.getInt("Elevados_Sacrificio");
                    double promedio = rs.getDouble("Promedio");
                    int robos = rs.getInt("Robos");
                    double slg = rs.getDouble("SLG");
                    double obp = rs.getDouble("OBP");
                    double ops = rs.getDouble("OPS");

                    //Insertarlos en una tabla
                    Tabla.addRow(new Object[]{jugador, juegosjugados, apariciones, 
                        turnosLegales, hits, dobles, triples, homeRuns,  
                        df.format(promedio), carrerasProducidas, bb, bg, robos, ts, fs, (ts+fs), df.format(slg), df.format(obp), df.format(ops)});
            }
        }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error mostrando los Jugadores", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    public void mostrarPicher(DefaultTableModel Tabla, int id) {
        conectar();
        String query = "SELECT " +
                        "Jugador.j_nombre AS Jugador, " +
                        "COUNT(jp_innings) AS Juegos_Jugados, " +
                        "SUM(jp_innings) AS Innings_Lanzados, " +
                        "sum(jp_gano) AS Ganados, " +
                        "sum(jp_perdio) AS Perdidos, " +
                        "sum(jp_carrerasPermitidas) AS CarrerasPermitidas, " +
                        "sum(jp_carrerasLimpias) AS CarrerasLimpias, " +
                        "sum(jp_ponches) AS Ponches, " +
                        "sum(jp_hits) AS Hits, " +
                        "sum(jp_basesBola) AS Bases_por_Bola, " +
                        "sum(jp_basesGolpe) AS Bases_por_Golpe, " +
                        "sum(jp_sacrificios) AS Sacrificios, " +
                        "sum(jp_legalesEnfrentados) AS Legales_Enfrentados, " +
                        "CASE " +
                        "WHEN sum(jp_innings) = 0 THEN 0 " +
                        "ELSE (sum(jp_carrerasLimpias) / sum(jp_innings) * 9) " +
                        "END AS ERA, " +
                        "CASE " +
                        "WHEN sum(jp_innings) = 0 THEN 0 " +
                        "ELSE ((sum(jp_hits) + sum(jp_basesBola)) / sum(jp_innings)) " +
                        "END AS WHIP, " +
                        "CASE " +
                        "WHEN sum(jp_legalesEnfrentados) = 0 THEN 0 " +
                        "ELSE (sum(jp_hits) / sum(jp_legalesEnfrentados)) " +
                        "END AS OAA " +
                        "FROM JPicher " +
                        "JOIN Jugador ON JPicher.jugador = Jugador.id_jugador " +
                        "WHERE " +
                        "Jugador.equipo = " + id + " " +
                        "GROUP BY " +
                        "Jugador.j_nombre";
        
        try (PreparedStatement PS = oConexion.prepareStatement(query);
            ResultSet rs = PS.executeQuery()){
        
        Tabla.setRowCount(0);
        
            while(rs.next()) {
                String jugador = rs.getString("Jugador");
                int jj = rs.getInt("Juegos_Jugados");
                double il = rs.getDouble("Innings_Lanzados");
                int g = rs.getInt("Ganados");
                int p = rs.getInt("Perdidos");
                int cp = rs.getInt("CarrerasPermitidas");
                int cl = rs.getInt("CarrerasLimpias");
                int k = rs.getInt("Ponches");
                int h = rs.getInt("Hits");
                int bb = rs.getInt("Bases_por_Bola");
                int bg = rs.getInt("Bases_por_Golpe");
                int sac = rs.getInt("Sacrificios");
                int le = rs.getInt("Legales_Enfrentados");
                double era = rs.getDouble("ERA");
                double whip = rs.getDouble("WHIP");
                double oaa = rs.getDouble("OAA");
                
                Tabla.addRow(new Object[] {jugador, jj, il, g, p, cp, cl, k, h, bb, bg, sac, le, df.format(era), df.format(whip), df.format(oaa)});
            }
            
        }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error mostrando los Jugadores", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Mostrar los datos de las ligas
    public void mostrarLigas(DefaultTableModel Tabla) {
        conectar();
        String query = "SELECT liga_nombre AS Liga, liga_tipo AS Tipo FROM Liga";
        
        try (PreparedStatement PS = oConexion.prepareStatement(query);
            ResultSet rs = PS.executeQuery()) {
            
            Tabla.setRowCount(0);
            
            while (rs.next()) {
                String nombre = rs.getString("Liga");
                String tipo = rs.getString("Tipo");
                
                Tabla.addRow(new Object[]{nombre, tipo});
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error mostrando las Ligas", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Motrar los datos de las temporadas
    public void mostrarTemporadas(DefaultTableModel Tabla, String liga) {
        conectar();
        String query = "SELECT temp_nombre AS Temporadas, temp_periodo AS Periodo FROM Temporada WHERE liga = " + claveLiga(liga);
        
        try (PreparedStatement PS = oConexion.prepareStatement(query);
            ResultSet rs = PS.executeQuery()) {
            
            Tabla.setRowCount(0);
            
            while (rs.next()) {
                String nombre = rs.getString("Temporadas");
                String periodo = rs.getString("Periodo");
                
                Tabla.addRow(new Object[]{nombre, periodo});
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error mostrando las Temporadas", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Mostrar los datos de las categorías de las ligas
    public void mostrarCategorias(DefaultTableModel Tabla, String liga) {
        conectar();
        String query = "SELECT cat_nombre AS Categoria FROM Categoria WHERE liga = " + claveLiga(liga);
        
        try (PreparedStatement PS = oConexion.prepareStatement(query);
            ResultSet rs = PS.executeQuery()) {
            
            Tabla.setRowCount(0);
            
            while (rs.next()) {
                String categoria = rs.getString("Categoria");
                
                Tabla.addRow(new Object[]{categoria});
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error mostrando las Categorias", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //------------------------------------------------------------------------------------------
    
    //Mostrar los 10 mejores promedios de bateo
    public void lideresPromedio(JTable Tabla, String categoria, String temporada, double min) {
        DefaultTableModel CM = (DefaultTableModel)Tabla.getModel();
        TableColumnModel TCM = Tabla.getColumnModel();
        CM.setColumnIdentifiers(new Object[]{"Jugador", "Equipo", "AP", "TL", "Hits", "AVG"});
        conectar();
        //Consulta para sacar los 10 mejores promedios de bateo
        String query = "SELECT TOP 10 " +
                            "j.j_nombre AS Jugador, " +
                            "e.e_nombre AS Equipo, " +
                            "SUM(jj.jb_ap) AS Apariciones, " +
                            "SUM(jj.jb_tl) AS Turnos_Legales, " +
                            "SUM(jj.jb_hits) AS Hits, " +
                        "CASE " +
                            "WHEN SUM(jj.jb_tl) = 0 THEN 0 " +
                            "ELSE SUM(jj.jb_hits) / SUM(jj.jb_tl) " +
                        "END AS Promedio " +
                        "FROM " +
                            "JBateador jj " +
                        "INNER JOIN " +
                            "Jugador j ON jj.jugador = j.id_jugador " +
                        "INNER JOIN " +
                            "Equipo e ON j.equipo = e.id_equipo " +
                        "WHERE " + 
                            "e.categoria = " + claveCategoria(categoria) + " and e.temporada = " + claveTemporada(temporada) + " " +
                        "GROUP BY " +
                            "j.j_nombre, e.e_nombre " +
                        "HAVING " + 
                            "sum(jb_ap) >= " + min + " " +
                        "ORDER BY " +
                            "Promedio DESC, " +
                            "Hits DESC, " + 
                            "Turnos_Legales DESC, " +
                            "Apariciones DESC;";

        try (PreparedStatement PS = oConexion.prepareStatement(query)) {

            //PS.setString(1, categoria);

            try (ResultSet rs = PS.executeQuery()) {
                
                CM.setRowCount(0);
                CM.setColumnCount(6); // 536
                
                TCM.getColumn(0).setPreferredWidth(150);
                TCM.getColumn(1).setPreferredWidth(150);
                TCM.getColumn(2).setPreferredWidth(59);
                TCM.getColumn(3).setPreferredWidth(59);
                TCM.getColumn(4).setPreferredWidth(59);
                TCM.getColumn(5).setPreferredWidth(59);
                //Guardar los datos renglón por renglón
                while (rs.next()) {
                    String jugador = rs.getString("Jugador");
                    String equipo = rs.getString("Equipo");
                    double ap = rs.getDouble("Apariciones");
                    double tl = rs.getDouble("Turnos_Legales");
                    double hits = rs.getDouble("Hits");
                    double promedio = rs.getDouble("Promedio");

                    //Insertarlos en la tabla
                    CM.addRow(new Object[]{jugador, equipo, ap, tl, hits, df.format(promedio)});
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error mostrando los lideres", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    //------------------------------------------------------------------------------------------
    
    //Mostrar los 10 mejores en HomeRuns
    public void lideresHomeRuns(JTable Tabla, String categoria, String temporada) {
        DefaultTableModel CM = (DefaultTableModel)Tabla.getModel();
        TableColumnModel TCM = Tabla.getColumnModel();
        CM.setColumnIdentifiers(new Object[]{"Jugador", "Equipo", "HomeRuns"});
        conectar();
        String query = "SELECT TOP 10 " +
                            "j.j_nombre AS Jugador, " +
                            "e.e_nombre AS Equipo, " +
                            "sum(jj.jb_hr) AS HomeRuns " +
                        "FROM  " +
                            "JBateador jj " +
                        "INNER JOIN " +
                            "Jugador j ON jj.jugador = j.id_jugador " +
                        "INNER JOIN " +
                            "Equipo e ON j.equipo = e.id_equipo " +
                        "WHERE " +
                            "e.categoria = " + claveCategoria(categoria) + " and e.temporada = " + claveTemporada(temporada) + " " +
                        "GROUP BY " +
                            "j.j_nombre, e.e_nombre " +
                        "ORDER BY " +
                            "HomeRuns DESC;";

        try (PreparedStatement PS = oConexion.prepareStatement(query)) {

            //PS.setString(1, categoria);

            try (ResultSet rs = PS.executeQuery()) {
                
                CM.setRowCount(0);
                CM.setColumnCount(3);
                
                TCM.getColumn(0).setPreferredWidth(200);
                TCM.getColumn(1).setPreferredWidth(200);
                TCM.getColumn(2).setPreferredWidth(136);
                
                //Guardar los datos renglón por renglón
                while (rs.next()) {
                    String jugador = rs.getString("Jugador");
                    String equipo = rs.getString("Equipo");
                    int homeRuns = rs.getInt("HomeRuns");

                    //Agregarlos en la tabla
                    CM.addRow(new Object[]{jugador, equipo, homeRuns});
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los Lideres", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    //------------------------------------------------------------------------------------------
    
    //Mostrar los 10 mejores en producidas
    public void lideresProducidas(JTable Tabla, String categoria, String temporada){
        DefaultTableModel CM = (DefaultTableModel)Tabla.getModel();
        TableColumnModel TCM = Tabla.getColumnModel();
        CM.setColumnIdentifiers(new Object[]{"Jugador", "Equipo", "Producidas"});
        conectar();
        //Consulta que muestra los datos solicitados
        String query = "SELECT TOP 10 " +
                            "j.j_nombre AS Jugador, " +
                            "e.e_nombre AS Equipo, " +
                            "sum(jj.jb_cp) AS Producidas " +
                        "FROM " +
                            "JBateador jj " +
                        "INNER JOIN " +
                            "Jugador j ON jj.jugador = j.id_jugador " +
                        "INNER JOIN " +
                            "Equipo e ON j.equipo = e.id_equipo " +
                        "WHERE " +
                            "e.categoria = " + claveCategoria(categoria) + " and e.temporada = " + claveTemporada(temporada) + " " +
                        "GROUP BY \n" +
                            "j.j_nombre, e.e_nombre " +
                        "ORDER BY " +
                            "Producidas DESC;";
        
        try(PreparedStatement PS = oConexion.prepareStatement(query)){
            
            //PS.setString(1, categoria);
            
            try(ResultSet RS = PS.executeQuery()){
                CM.setRowCount(0);
                CM.setColumnCount(3);
                
                TCM.getColumn(0).setPreferredWidth(200);
                TCM.getColumn(1).setPreferredWidth(200);
                TCM.getColumn(2).setPreferredWidth(136);
                
                //Guardar la información por renglón
                while(RS.next()){
                    String jugador = RS.getString("Jugador");
                    String equipo = RS.getString("Equipo");
                    int cp = RS.getInt("Producidas");
                    
                    //Ageragrlo a la tabla
                    CM.addRow(new Object[]{jugador, equipo, cp});
                }
            }
            
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los Lideres", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    //------------------------------------------------------------------------------------------
    
    //Mostrar los 10 mejores en robos de base
    public void lideresRobos(JTable Tabla, String categoria, String temporada){
        DefaultTableModel CM = (DefaultTableModel)Tabla.getModel();
        TableColumnModel TCM = Tabla.getColumnModel();
        CM.setColumnIdentifiers(new Object[]{"Jugador", "Equipo", "Robos"});
        conectar();
        //Consulta que muestra los datos solicitados
        String query = "SELECT TOP 10" +
                            "j.j_nombre AS Jugador, " +
                            "e.e_nombre AS Equipo, " +
                            "sum(jj.jb_br) AS Robos " +
                        "FROM " +
                            "JBateador jj " +
                        "INNER JOIN " +
                            "Jugador j ON jj.jugador = j.id_jugador " +
                        "INNER JOIN " +
                            "Equipo e ON j.equipo = e.id_equipo " +
                        "WHERE " +
                            "e.categoria = " + claveCategoria(categoria) + " and e.temporada = " + claveTemporada(temporada) + " " +
                        "GROUP BY " +
                            "j.j_nombre, e.e_nombre " +
                        "ORDER BY " +
                            "Robos DESC;";
        
        try(PreparedStatement PS = oConexion.prepareStatement(query)){
            
            //PS.setString(1, categoria);
            
            try(ResultSet RS = PS.executeQuery()){
                CM.setRowCount(0);
                CM.setColumnCount(3);
            
                TCM.getColumn(0).setPreferredWidth(200);
                TCM.getColumn(1).setPreferredWidth(200);
                TCM.getColumn(2).setPreferredWidth(136);
                
                //Guardar la información por renglón
                while(RS.next()){
                    String jugador = RS.getString("Jugador");
                    String equipo = RS.getString("Equipo");
                    int br = RS.getInt("Robos");
                    
                    //Ageragrlo a la tabla
                    CM.addRow(new Object[]{jugador, equipo, br});
                }
            }
            
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los Lideres", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    //------------------------------------------------------------------------------------------
    
    //Mostrar los 10 mejores en picheo
    public void lideresPicheo(JTable Tabla, String categoria, String temporada) {
        DefaultTableModel CM = (DefaultTableModel)Tabla.getModel();
        TableColumnModel TCM = Tabla.getColumnModel();
        CM.setColumnIdentifiers(new Object[]{"Jugador", "Equipo", "G", "P", "PCTE"});
        conectar();
        String query = "SELECT TOP 10 " +
                            "j.j_nombre AS Jugador, " +
                            "e.e_nombre AS Equipo, " +
                            "sum(jj.jp_gano) AS Ganados, " +
                            "sum(jj.jp_perdio) AS Perdidos, " +
                        "CASE " +
                            "WHEN SUM(jj.jp_gano) + SUM(jj.jp_perdio) = 0 THEN 0 " +
                            "ELSE CAST(SUM(jj.jp_gano) AS FLOAT) / (SUM(jj.jp_gano) + SUM(jj.jp_perdio)) " +
                        "END AS Porcentaje " +
                        "FROM " +
                            "JPicher jj " +
                        "INNER JOIN " +
                            "Jugador j ON jj.jugador = j.id_jugador " +
                        "INNER JOIN " +
                            "Equipo e ON j.equipo = e.id_equipo " +
                        "WHERE " +
                            "e.categoria = " + claveCategoria(categoria) + " and e.temporada = " + claveTemporada(temporada) + " " +
                        "GROUP BY " +
                            "j.j_nombre, e.e_nombre " +
                        "ORDER BY " +
                            "Porcentaje DESC, " +
                            "Ganados DESC, " +
                            "Perdidos DESC;";

        try (PreparedStatement PS = oConexion.prepareStatement(query)) {

            //PS.setString(1, categoria);

            try (ResultSet rs = PS.executeQuery()) {
                // Clear existing data
                CM.setRowCount(0);
                CM.setColumnCount(5);
                    
                while (rs.next()) {
                    String jugador = rs.getString("Jugador");
                    String equipo = rs.getString("Equipo");
                    int ganados = rs.getInt("Ganados");
                    int perdidos = rs.getInt("Perdidos");
                    double porcentaje = rs.getDouble("Porcentaje");

                    // Add the row to the table model
                    TCM.getColumn(0).setPreferredWidth(150);
                    TCM.getColumn(1).setPreferredWidth(150);
                    TCM.getColumn(2).setPreferredWidth(79);
                    TCM.getColumn(3).setPreferredWidth(79);
                    TCM.getColumn(4).setPreferredWidth(78);
                    CM.addRow(new Object[]{jugador, equipo, ganados, perdidos, df.format(porcentaje)});
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error mostrando los lideres", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }

    public void lideresExB(JTable Tabla, String categoria, String temporada){
        DefaultTableModel CM = (DefaultTableModel)Tabla.getModel();
        TableColumnModel TCM = Tabla.getColumnModel();
        CM.setColumnIdentifiers(new Object[]{"Jugador", "Equipo", "ExtraBases"});
        conectar();
        //Consulta que muestra los datos solicitados
        String query = "SELECT TOP 10 " +
                            "j.j_nombre AS Jugador, " +
                            "e.e_nombre AS Equipo, " +
                            "sum(jj.jb_dobles) + sum(jj.jb_triples) + sum(jj.jb_hr) AS ExtraBases " +
                        "FROM " +
                            "JBateador jj " +
                        "INNER JOIN " +
                            "Jugador j ON jj.jugador = j.id_jugador " +
                        "INNER JOIN " +
                            "Equipo e ON j.equipo = e.id_equipo " +
                        "WHERE " +
                            "e.categoria = " + claveCategoria(categoria) + " and e.temporada = " + claveTemporada(temporada) + " " +
                        " GROUP BY " +
                            "j.j_nombre, e.e_nombre " +
                        "ORDER BY " +
                            "ExtraBases DESC;";
        
        try(PreparedStatement PS = oConexion.prepareStatement(query)){
            
            //PS.setString(1, categoria);
            
            try(ResultSet RS = PS.executeQuery()){
                CM.setRowCount(0);
                CM.setColumnCount(3);
            
                TCM.getColumn(0).setPreferredWidth(200);
                TCM.getColumn(1).setPreferredWidth(200);
                TCM.getColumn(2).setPreferredWidth(136);
                
                //Guardar la información por renglón
                while(RS.next()){
                    String jugador = RS.getString("Jugador");
                    String equipo = RS.getString("Equipo");
                    int eb = RS.getInt("ExtraBases");
                    
                    //Ageragrlo a la tabla
                    CM.addRow(new Object[]{jugador, equipo, eb});
                }
            }
            
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los Lideres", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    public void lideresOBP(JTable Tabla, String categoria, String temporada, double minimo){
        DefaultTableModel CM = (DefaultTableModel)Tabla.getModel();
        TableColumnModel TCM = Tabla.getColumnModel();
        CM.setColumnIdentifiers(new Object[]{"Jugador", "Equipo", "OBP"});
        conectar();
        //Consulta que muestra los datos solicitados
        String query = "SELECT TOP 10 " +
                            "j.j_nombre AS Jugador, " +
                            "e.e_nombre AS Equipo, " +
                        "CASE " +
                            "WHEN (SUM(jb_tl) + SUM(jb_bb) + SUM(jb_bg) + SUM(jb_sacF)) = 0 THEN 0 " +
                        "ELSE (SUM(jb_hits) + SUM(jb_bb) + SUM(jb_bg)) / " +
                            "(SUM(jb_tl) + SUM(jb_bb) + SUM(jb_bg) + SUM(jb_sacF)) " +
                        "END AS OBP " +
                        "FROM " +
                            "JBateador jj " +
                        "INNER JOIN " +
                            "Jugador j ON jj.jugador = j.id_jugador " +
                        "INNER JOIN " +
                            "Equipo e ON j.equipo = e.id_equipo " +
                        "WHERE " +
                            "e.categoria = " + claveCategoria(categoria) + " and e.temporada = " + claveTemporada(temporada) + " " +
                        " GROUP BY " +
                            "j.j_nombre, e.e_nombre " +
                        "HAVING " +
                            "sum(jb_ap) >= " + minimo + " " +
                        "ORDER BY " +
                            "OBP DESC";
        
        try(PreparedStatement PS = oConexion.prepareStatement(query)){
            
            //PS.setString(1, categoria);
            
            try(ResultSet RS = PS.executeQuery()){
                CM.setRowCount(0);
                CM.setColumnCount(3);
            
                TCM.getColumn(0).setPreferredWidth(200);
                TCM.getColumn(1).setPreferredWidth(200);
                TCM.getColumn(2).setPreferredWidth(136);
                
                //Guardar la información por renglón
                while(RS.next()){
                    String jugador = RS.getString("Jugador");
                    String equipo = RS.getString("Equipo");
                    double obp = RS.getDouble("OBP");
                    
                    //Ageragrlo a la tabla
                    CM.addRow(new Object[]{jugador, equipo, df.format(obp)});
                }
            }
            
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los Lideres", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    public void lideresSLG(JTable Tabla, String categoria, String temporada, double minimo){
        DefaultTableModel CM = (DefaultTableModel)Tabla.getModel();
        TableColumnModel TCM = Tabla.getColumnModel();
        CM.setColumnIdentifiers(new Object[]{"Jugador", "Equipo", "SLG"});
        conectar();
        //Consulta que muestra los datos solicitados
        String query = "SELECT TOP 10 " +
                            "j.j_nombre AS Jugador, " +
                            "e.e_nombre AS Equipo, " +
                        "CASE " +
                            "WHEN SUM(jb_tl) = 0 THEN 0 " +
                        "ELSE (SUM(jb_hits) - SUM(jb_dobles) - SUM(jb_triples) - SUM(jb_hr) + " +
                            "(2 * SUM(jb_dobles)) + (3 * SUM(jb_triples)) + (4 * SUM(jb_hr))) / SUM(jb_tl) " +
                        "END AS SLG " +
                        "FROM " +
                            "JBateador jj " +
                        "INNER JOIN " +
                            "Jugador j ON jj.jugador = j.id_jugador " +
                        "INNER JOIN " +
                            "Equipo e ON j.equipo = e.id_equipo " +
                        "WHERE " +
                            "e.categoria = " + claveCategoria(categoria) + " and e.temporada = " + claveTemporada(temporada) + " " + 
                       "GROUP BY " +
                            "j.j_nombre, e.e_nombre " +
                        "HAVING " +
                            "sum(jb_ap) >= " + minimo + " " +
                        "ORDER BY " +
                            "SLG DESC";
        
        try(PreparedStatement PS = oConexion.prepareStatement(query)){
            
            //PS.setString(1, categoria);
            
            try(ResultSet RS = PS.executeQuery()){
                CM.setRowCount(0);
                CM.setColumnCount(3);
            
                TCM.getColumn(0).setPreferredWidth(200);
                TCM.getColumn(1).setPreferredWidth(200);
                TCM.getColumn(2).setPreferredWidth(136);
                
                //Guardar la información por renglón
                while(RS.next()){
                    String jugador = RS.getString("Jugador");
                    String equipo = RS.getString("Equipo");
                    double slg = RS.getDouble("SLG");
                    
                    //Ageragrlo a la tabla
                    CM.addRow(new Object[]{jugador, equipo, df.format(slg)});
                }
            }
            
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los Lideres", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    public void lideresOPS(JTable Tabla, String categoria, String temporada, double minimo){
        DefaultTableModel CM = (DefaultTableModel)Tabla.getModel();
        TableColumnModel TCM = Tabla.getColumnModel();
        CM.setColumnIdentifiers(new Object[]{"Jugador", "Equipo", "OPS"});
        conectar();
        //Consulta que muestra los datos solicitados
        String query = "SELECT TOP 10 " +
                            "j.j_nombre AS Jugador, " +
                            "e.e_nombre AS Equipo, " +
                        "CASE " +
                            "WHEN SUM(jb_tl) = 0 THEN 0 " +
                        "ELSE " +
                            "(SUM(jb_hits) - SUM(jb_dobles) - SUM(jb_triples) - SUM(jb_hr) + " +
                            "(2 * SUM(jb_dobles)) + (3 * SUM(jb_triples)) + (4 * SUM(jb_hr))) / SUM(jb_tl) + " +
                            "(SUM(jb_hits) + SUM(jb_bb) + SUM(jb_bg)) / " +
                            "(SUM(jb_tl) + SUM(jb_bb) + SUM(jb_bg) + SUM(jb_sacF)) " +
                        "END AS OPS " +
                        "FROM " +
                            "JBateador jj " +
                        "INNER JOIN " +
                            "Jugador j ON jj.jugador = j.id_jugador " +
                        "INNER JOIN " +
                            "Equipo e ON j.equipo = e.id_equipo " +
                        "WHERE " +
                            "e.categoria = " + claveCategoria(categoria) + " and e.temporada = " + claveTemporada(temporada) + " " +
                        "GROUP BY " +
                            "j.j_nombre, e.e_nombre " +
                        "HAVING " +
                            "sum(jb_ap) >= " + minimo + " " +
                        "ORDER BY " +
                            "OPS DESC";
        
        try(PreparedStatement PS = oConexion.prepareStatement(query)){
            
            //PS.setString(1, categoria);
            
            try(ResultSet RS = PS.executeQuery()){
                CM.setRowCount(0);
                CM.setColumnCount(3);
            
                TCM.getColumn(0).setPreferredWidth(200);
                TCM.getColumn(1).setPreferredWidth(200);
                TCM.getColumn(2).setPreferredWidth(136);
                
                //Guardar la información por renglón
                while(RS.next()){
                    String jugador = RS.getString("Jugador");
                    String equipo = RS.getString("Equipo");
                    double ops = RS.getDouble("OPS");
                    
                    //Ageragrlo a la tabla
                    CM.addRow(new Object[]{jugador, equipo, df.format(ops)});
                }
            }
            
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los Lideres", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    public void lideresHits(JTable Tabla, String categoria, String temporada){
        DefaultTableModel CM = (DefaultTableModel)Tabla.getModel();
        TableColumnModel TCM = Tabla.getColumnModel();
        CM.setColumnIdentifiers(new Object[]{"Jugador", "Equipo", "Hits"});
        conectar();
        //Consulta que muestra los datos solicitados
        String query = "SELECT TOP 10 " +
                            "j.j_nombre AS Jugador, " +
                            "e.e_nombre AS Equipo, " +
                            "sum(jj.jb_hits) AS Hits " +
                        "FROM " +
                            "JBateador jj " +
                        "INNER JOIN " +
                            "Jugador j ON jj.jugador = j.id_jugador " +
                        "INNER JOIN " +
                            "Equipo e ON j.equipo = e.id_equipo " +
                        "WHERE " +
                            "e.categoria = " + claveCategoria(categoria) + " and e.temporada = " + claveTemporada(temporada) + " " +
                        "GROUP BY " +
                            "j.j_nombre, e.e_nombre " +
                        "ORDER BY " +
                            "Hits DESC;";
        
        try(PreparedStatement PS = oConexion.prepareStatement(query)){
            
            //PS.setString(1, categoria);
            
            try(ResultSet RS = PS.executeQuery()){
                CM.setRowCount(0);
                CM.setColumnCount(3);
            
                TCM.getColumn(0).setPreferredWidth(200);
                TCM.getColumn(1).setPreferredWidth(200);
                TCM.getColumn(2).setPreferredWidth(136);
                
                //Guardar la información por renglón
                while(RS.next()){
                    String jugador = RS.getString("Jugador");
                    String equipo = RS.getString("Equipo");
                    int hits = RS.getInt("Hits");
                    
                    //Ageragrlo a la tabla
                    CM.addRow(new Object[]{jugador, equipo, hits});
                }
            }
            
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los Lideres", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    public void lideresDobles(JTable Tabla, String categoria, String temporada){
        DefaultTableModel CM = (DefaultTableModel)Tabla.getModel();
        TableColumnModel TCM = Tabla.getColumnModel();
        CM.setColumnIdentifiers(new Object[]{"Jugador", "Equipo", "Dobles"});
        conectar();
        //Consulta que muestra los datos solicitados
        String query = "SELECT TOP 10 " +
                            "j.j_nombre AS Jugador, " +
                            "e.e_nombre AS Equipo, " +
                            "sum(jj.jb_dobles) AS Dobles " +
                        "FROM " +
                            "JBateador jj " +
                        "INNER JOIN " +
                            "Jugador j ON jj.jugador = j.id_jugador " +
                        "INNER JOIN " +
                            "Equipo e ON j.equipo = e.id_equipo " +
                        "WHERE " +
                            "e.categoria = " + claveCategoria(categoria) + " and e.temporada = " + claveTemporada(temporada) + " " +
                        "GROUP BY " +
                            "j.j_nombre, e.e_nombre " +
                        "ORDER BY " +
                            "Dobles DESC;";
        
        try(PreparedStatement PS = oConexion.prepareStatement(query)){
            
            //PS.setString(1, categoria);
            
            try(ResultSet RS = PS.executeQuery()){
                CM.setRowCount(0);
                CM.setColumnCount(3);
            
                TCM.getColumn(0).setPreferredWidth(200);
                TCM.getColumn(1).setPreferredWidth(200);
                TCM.getColumn(2).setPreferredWidth(136);
                
                //Guardar la información por renglón
                while(RS.next()){
                    String jugador = RS.getString("Jugador");
                    String equipo = RS.getString("Equipo");
                    int dobles = RS.getInt("Dobles");
                    
                    //Ageragrlo a la tabla
                    CM.addRow(new Object[]{jugador, equipo, dobles});
                }
            }
            
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los Lideres", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    public void lideresTriples(JTable Tabla, String categoria, String temporada){
        DefaultTableModel CM = (DefaultTableModel)Tabla.getModel();
        TableColumnModel TCM = Tabla.getColumnModel();
        CM.setColumnIdentifiers(new Object[]{"Jugador", "Equipo", "Triples"});
        conectar();
        //Consulta que muestra los datos solicitados
        String query = "SELECT TOP 10 " +
                            "j.j_nombre AS Jugador, " +
                            "e.e_nombre AS Equipo, " +
                            "sum(jj.jb_triples) AS Triples " +
                        "FROM " +
                            "JBateador jj " +
                        "INNER JOIN " +
                            "Jugador j ON jj.jugador = j.id_jugador " +
                        "INNER JOIN " +
                            "Equipo e ON j.equipo = e.id_equipo " +
                        "WHERE " +
                            "e.categoria = " + claveCategoria(categoria) + " and e.temporada = " + claveTemporada(temporada) + " " +
                        "GROUP BY " +
                            "j.j_nombre, e.e_nombre " +
                        "ORDER BY " +
                            "Triples DESC;";
        
        try(PreparedStatement PS = oConexion.prepareStatement(query)){
            
            //PS.setString(1, categoria);
            
            try(ResultSet RS = PS.executeQuery()){
                CM.setRowCount(0);
                CM.setColumnCount(3);
            
                TCM.getColumn(0).setPreferredWidth(200);
                TCM.getColumn(1).setPreferredWidth(200);
                TCM.getColumn(2).setPreferredWidth(136);
                
                //Guardar la información por renglón
                while(RS.next()){
                    String jugador = RS.getString("Jugador");
                    String equipo = RS.getString("Equipo");
                    int triples = RS.getInt("Triples");
                    
                    //Ageragrlo a la tabla
                    CM.addRow(new Object[]{jugador, equipo, triples});
                }
            }
            
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los Lideres", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    public void lideresERA(JTable Tabla, String categoria, String temporada, double min){
        DefaultTableModel CM = (DefaultTableModel)Tabla.getModel();
        TableColumnModel TCM = Tabla.getColumnModel();
        CM.setColumnIdentifiers(new Object[]{"Jugador", "Equipo", "CL", "IL","ERA"});
        conectar();
        //Consulta que muestra los datos solicitados
        String query = "SELECT TOP 10 " +
                            "j.j_nombre AS Jugador, " +
                            "e.e_nombre AS Equipo, " +
                            "sum(jj.jp_carrerasLimpias) AS CL, " +
                            "sum(jj.jp_innings) AS IL, " +
                        "CASE " +
                            "WHEN sum(jj.jp_innings) = 0 THEN 0 " +
                        "ELSE sum(jj.jp_carrerasLimpias) / sum(jj.jp_innings) * 9 " +
                        "END AS ERA " +
                        "FROM " +
                            "JPicher jj " +
                        "INNER JOIN " +
                            "Jugador j ON jj.jugador = j.id_jugador " +
                        "INNER JOIN " +
                            "Equipo e ON j.equipo = e.id_equipo " +
                        "WHERE " +
                            "e.categoria = " + claveCategoria(categoria) + " and e.temporada = " + claveTemporada(temporada) + " " +
                        "GROUP BY " +
                            "j.j_nombre, e.e_nombre " +
                        "HAVING " +
                            "sum(jj.jp_innings) >= " + min + " " +
                        "ORDER BY " +
                            "ERA ASC;";
        
        try(PreparedStatement PS = oConexion.prepareStatement(query)){
            
            //PS.setString(1, categoria);
            
            try(ResultSet RS = PS.executeQuery()){
                CM.setRowCount(0);
                CM.setColumnCount(5);
            
                TCM.getColumn(0).setPreferredWidth(107);
                TCM.getColumn(1).setPreferredWidth(107);
                TCM.getColumn(2).setPreferredWidth(107);
                TCM.getColumn(3).setPreferredWidth(107);
                TCM.getColumn(4).setPreferredWidth(108);
                
                //Guardar la información por renglón
                while(RS.next()){
                    String jugador = RS.getString("Jugador");
                    String equipo = RS.getString("Equipo");
                    int cl = RS.getInt("CL");
                    double il = RS.getDouble("IL");
                    float era = RS.getFloat("ERA");
                    
                    //Ageragrlo a la tabla
                    CM.addRow(new Object[]{jugador, equipo, cl, il, df.format(era)});
                }
            }
            
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los Lideres", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    public void lideresWHIP(JTable Tabla, String categoria, String temporada, double min){
        DefaultTableModel CM = (DefaultTableModel)Tabla.getModel();
        TableColumnModel TCM = Tabla.getColumnModel();
        CM.setColumnIdentifiers(new Object[]{"Jugador", "Equipo", "BB", "H", "IL", "WHIP"});
        conectar();
        //Consulta que muestra los datos solicitados
        String query = "SELECT TOP 10 " +
                            "j.j_nombre AS Jugador, " +
                            "e.e_nombre AS Equipo, " +
                            "sum(jj.jp_basesBola) AS BB, " +
                            "sum(jj.jp_hits) AS H, " +
                            "sum(jj.jp_innings) AS IL, " +
                        "CASE " +
                            "WHEN sum(jj.jp_innings) = 0 THEN 0 " +
                        "ELSE (sum(jj.jp_basesBola) + sum(jj.jp_hits)) / sum(jj.jp_innings) " +
                        "END AS WHIP " +
                        "FROM " +
                            "JPicher jj " +
                        "INNER JOIN " +
                            "Jugador j ON jj.jugador = j.id_jugador " +
                        "INNER JOIN " +
                            "Equipo e ON j.equipo = e.id_equipo " +
                        "WHERE " +
                            "e.categoria = " + claveCategoria(categoria) + " and e.temporada = " + claveTemporada(temporada) + " " +
                        "GROUP BY " +
                            "j.j_nombre, e.e_nombre " +
                        "HAVING " +
                            "sum(jj.jp_innings) >= " + min + " " +
                        "ORDER BY " +
                            "WHIP ASC;";
        
        try(PreparedStatement PS = oConexion.prepareStatement(query)){
            
            //PS.setString(1, categoria);
            
            try(ResultSet RS = PS.executeQuery()){
                CM.setRowCount(0);
                CM.setColumnCount(6);
            
                TCM.getColumn(0).setPreferredWidth(150);
                TCM.getColumn(1).setPreferredWidth(150);
                TCM.getColumn(2).setPreferredWidth(59);
                TCM.getColumn(3).setPreferredWidth(59);
                TCM.getColumn(4).setPreferredWidth(59);
                TCM.getColumn(5).setPreferredWidth(59);
                
                //Guardar la información por renglón
                while(RS.next()){
                    String jugador = RS.getString("Jugador");
                    String equipo = RS.getString("Equipo");
                    int bb = RS.getInt("BB");
                    int h = RS.getInt("H");
                    double il = RS.getDouble("IL");
                    double whip = RS.getDouble("WHIP");
                    
                    //Ageragrlo a la tabla
                    CM.addRow(new Object[]{jugador, equipo, bb, h, il, df.format(whip)});
                }
            }
            
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los Lideres", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    public void lideresOAA(JTable Tabla, String categoria, String temporada, double min){
        DefaultTableModel CM = (DefaultTableModel)Tabla.getModel();
        TableColumnModel TCM = Tabla.getColumnModel();
        CM.setColumnIdentifiers(new Object[]{"Jugador", "Equipo", "OAA"});
        conectar();
        //Consulta que muestra los datos solicitados
        String query = "SELECT TOP 10 " +
                            "j.j_nombre AS Jugador, " +
                            "e.e_nombre AS Equipo, " +
                        "CASE " +
                            "WHEN sum(jp_legalesEnfrentados) = 0 THEN 0 " +
                        "ELSE ((sum(jp_hits) / sum(jp_legalesEnfrentados))) " +
                        "END AS OAA " +
                        "FROM " +
                            "JPicher jj " +
                        "INNER JOIN " +
                            "Jugador j ON jj.jugador = j.id_jugador " +
                        "INNER JOIN " +
                            "Equipo e ON j.equipo = e.id_equipo " +
                        "WHERE " +
                            "e.categoria = " + claveCategoria(categoria) + " and e.temporada = " + claveTemporada(temporada) + " " +
                        "GROUP BY " +
                            "j.j_nombre, e.e_nombre " +
                        "HAVING " +
                            "sum(jj.jp_innings) >= " + min + " " +
                        "ORDER BY " +
                            "OAA ASC;";
        
        try(PreparedStatement PS = oConexion.prepareStatement(query)){
            
            //PS.setString(1, categoria);
            
            try(ResultSet RS = PS.executeQuery()){
                CM.setRowCount(0);
                CM.setColumnCount(3);
            
                TCM.getColumn(0).setPreferredWidth(200);
                TCM.getColumn(1).setPreferredWidth(200);
                TCM.getColumn(2).setPreferredWidth(136);
                
                //Guardar la información por renglón
                while(RS.next()){
                    String jugador = RS.getString("Jugador");
                    String equipo = RS.getString("Equipo");
                    float oaa = RS.getFloat("OAA");
                    
                    //Ageragrlo a la tabla
                    CM.addRow(new Object[]{jugador, equipo, df.format(oaa)});
                }
            }
            
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los Lideres", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    // Lideres en ponches
    public void LideresPonches(JTable Tabla, String categoria, String temporada) {
        DefaultTableModel CM = (DefaultTableModel)Tabla.getModel();
        TableColumnModel TCM = Tabla.getColumnModel();
        CM.setColumnIdentifiers(new Object[]{"Jugador", "Equipo", "K´s"});
        conectar();
        //Consulta que muestra los datos solicitados
        String query = "SELECT TOP 10 " +
                            "j.j_nombre AS Jugador, " +
                            "e.e_nombre AS Equipo, " +
                            "sum(jj.jp_ponches) AS Ponches " +
                        "FROM " +
                            "JPicher jj " +
                        "INNER JOIN " +
                            "Jugador j ON jj.jugador = j.id_jugador " +
                        "INNER JOIN " +
                            "Equipo e ON j.equipo = e.id_equipo " +
                        "WHERE " +
                            "e.categoria = " + claveCategoria(categoria) + " and e.temporada = " + claveTemporada(temporada) + " " +
                        "GROUP BY " +
                            "j.j_nombre, e.e_nombre " +
                        "ORDER BY " +
                            "Ponches DESC;";
        
        try(PreparedStatement PS = oConexion.prepareStatement(query)){
            
            //PS.setString(1, categoria);
            
            try(ResultSet RS = PS.executeQuery()){
                CM.setRowCount(0);
                CM.setColumnCount(3);
            
                TCM.getColumn(0).setPreferredWidth(200);
                TCM.getColumn(1).setPreferredWidth(200);
                TCM.getColumn(2).setPreferredWidth(136);
                
                //Guardar la información por renglón
                while(RS.next()){
                    String jugador = RS.getString("Jugador");
                    String equipo = RS.getString("Equipo");
                    int ponches = RS.getInt("Ponches");
                    
                    //Ageragrlo a la tabla
                    CM.addRow(new Object[]{jugador, equipo, ponches});
                }
            }
            
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los Lideres", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    //------------------------------------------------------------------------------------------
    
    //Mostrar los juegos que han jugado los jugadores
    public void JuegosJugadosBateadores(DefaultTableModel Tabla, int equipoId) {
        conectar();
        //Sacar los datos necesarios
        String query = "SELECT " +
                            "j.j_nombre AS Jugador, " +
                        "COUNT(jj.id_jbateador) AS Juegos_Jugados " +
                        "FROM " +
                            "Jugador j " +
                        "LEFT JOIN " +
                            "JBateador jj ON j.id_jugador = jj.jugador " +
                        "WHERE " +
                            "(j.equipo = ?)" +
                        "GROUP BY " +
                            "j.j_nombre " +
                        "ORDER BY Juegos_Jugados DESC";

        try (PreparedStatement PS = oConexion.prepareStatement(query)) {

            PS.setInt(1, equipoId);

            try (ResultSet rs = PS.executeQuery()) {
                
                Tabla.setRowCount(0);

                //Guardar los datos de cada renglón
                while (rs.next()) {
                    String jugador = rs.getString("Jugador");
                    int juegosJugados = rs.getInt("Juegos_Jugados");

                    //Agregarlos a la tabla
                    Tabla.addRow(new Object[]{jugador, juegosJugados});
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error con los Juegos Jugados", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    //Mostrar los juegos que han jugado los jugadores
    public void JuegosJugadosPichers(DefaultTableModel Tabla, int equipoId) {
        conectar();
        //Sacar los datos necesarios
        String query = "SELECT " +
                            "j.j_nombre AS Jugador, " +
                            "COUNT(jj.id_jpicher) AS Juegos_Jugados " +
                        "FROM " +
                            "Jugador j " +
                        "LEFT JOIN " +
                            "JPicher jj ON j.id_jugador = jj.jugador " +
                        "WHERE " +
                            "(j.equipo = ?)" +
                        "GROUP BY " +
                            "j.j_nombre" +
                        " ORDER BY Juegos_Jugados DESC ";

        try (PreparedStatement PS = oConexion.prepareStatement(query)) {

            PS.setInt(1, equipoId);

            try (ResultSet rs = PS.executeQuery()) {
                
                Tabla.setRowCount(0);

                //Guardar los datos de cada renglón
                while (rs.next()) {
                    String jugador = rs.getString("Jugador");
                    int juegosJugados = rs.getInt("Juegos_Jugados");

                    //Agregarlos a la tabla
                    Tabla.addRow(new Object[]{jugador, juegosJugados});
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error con los Juegos Jugados", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    //------------------------------------------------------------------------------------------
    
    //Mostrar la información jornada por jornada de los Equipos
    public void mostrarJEquipo(DefaultTableModel Tabla, int equipo){
        conectar();
        String query = "SELECT " +
                            "numJornada AS Jornada, je_gano AS Ganados, je_perdio AS Perdidos, " +
                            "je_carrarasAnotadas AS Anotadas, je_carrerasRecibidas AS Recibidas, (select e_nombre from Equipo where id_equipo = rival) AS Rival " +
                        "FROM " +
                            "JEquipo je " +
                        "JOIN " +
                            "Jornada j ON je.jornada = j.id_jornada " +
                        "WHERE " +
                            "equipo = ?";
        
        try (PreparedStatement PS = oConexion.prepareStatement(query)) {

            PS.setInt(1, equipo);

            try (ResultSet rs = PS.executeQuery()) {
                
                Tabla.setRowCount(0);

                //Guardar los datos de cada renglón
                while (rs.next()) {
                    String jornada = rs.getString("Jornada");
                    int gano = rs.getInt("Ganados");
                    int perdio = rs.getInt("Perdidos");
                    int anotadas = rs.getInt("Anotadas");
                    int recibidas = rs.getInt("Recibidas");
                    String rival = rs.getString("Rival");

                    //Agregarlos a la tabla
                    Tabla.addRow(new Object[]{jornada, gano, perdio, anotadas, recibidas, rival});
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error con la información del equipo", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        desconectar();
    }
    
    //------------------------------------------------------------------------------------------
    
    //Mostrar la información jornada por jornada de los Bateadores
    public void mostrarJBateador(DefaultTableModel Tabla, int jugador){
        conectar();
        String query = "SELECT " +
                            "numJornada AS Jornada, jb_ap AS Apariciones, jb_tl AS Turnos_Legales, " +
                            "jb_hits AS Hits, jb_dobles AS Dobles, jb_triples AS Triples, jb_hr AS HomeRuns, jb_cp AS Carreras_Producidas, " +
                            "jb_bb AS Bases, jb_bg AS Golpes, jb_br AS Robos, jb_sacF AS ElevadosSac, jb_toqueF AS ToquesSac " +
                        "FROM " +
                            "JBateador jj " +
                        "JOIN " +
                            "Jornada j ON jj.jornada = j.id_jornada " +
                        "WHERE " +
                            "jugador = ?";
        
        try (PreparedStatement PS = oConexion.prepareStatement(query)) {

            PS.setInt(1, jugador);

            try (ResultSet rs = PS.executeQuery()) {
                
                Tabla.setRowCount(0);

                //Guardar los datos de cada renglón
                while (rs.next()) {
                    String jornada = rs.getString("Jornada");
                    double ap = rs.getDouble("Apariciones");
                    double tl = rs.getDouble("Turnos_Legales");
                    int hits = rs.getInt("Hits");
                    int dobles = rs.getInt("Dobles");
                    int triples = rs.getInt("Triples");
                    int hr = rs.getInt("HomeRuns");
                    int cp = rs.getInt("Carreras_Producidas");
                    int bases = rs.getInt("Bases");
                    int golpes = rs.getInt("Golpes");
                    int br = rs.getInt("Robos");
                    int es = rs.getInt("ElevadosSac");
                    int ts = rs.getInt("ToquesSac");
                    

                    //Agregarlos a la tabla
                    Tabla.addRow(new Object[]{jornada, ap, tl, hits, dobles, triples, hr, cp, bases, golpes, br, es, ts});
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error con la informacion de los Jugadores", "ERROR", JOptionPane.ERROR_MESSAGE);
        }  
        desconectar();
    }
    
    //Mostrar la información jornada por jornada de los Pichers
    public void mostrarJPicher(DefaultTableModel Tabla, int jugador){
        conectar();
        String query = "SELECT " +
                            "numJornada AS Jornada, jp_innings AS Innings, jp_gano AS Gano, jp_perdio AS Perdio, jp_carrerasPermitidas AS CarrerasPermitidas, " +
                            "jp_carrerasLimpias AS CarrerasLimpias, jp_ponches AS Ponches, jp_hits AS Hits, jp_basesBola AS Bases, jp_basesGolpe AS Golpes, " +
                            "jp_sacrificios AS Sacrificios, jp_legalesEnfrentados AS LegalesEnfrentados " +
                        "FROM " +
                            "JPicher jj " +
                        "JOIN " +
                            "Jornada j ON jj.jornada = j.id_jornada " +
                        "WHERE " +
                            "jugador = ?";
        
        try (PreparedStatement PS = oConexion.prepareStatement(query)) {

            PS.setInt(1, jugador);

            try (ResultSet rs = PS.executeQuery()) {
                
                Tabla.setRowCount(0);

                //Guardar los datos de cada renglón
                while (rs.next()) {
                    String jornada = rs.getString("Jornada");
                    double il = rs.getDouble("Innings");
                    int gano = rs.getInt("Gano");
                    int perdio = rs.getInt("Perdio");
                    int cp = rs.getInt("CarrerasPermitidas");
                    int cl = rs.getInt("CarrerasLimpias");
                    int ponches = rs.getInt("Ponches");
                    int hits = rs.getInt("Hits");
                    int bb = rs.getInt("Bases");
                    int bg = rs.getInt("Golpes");
                    int sac = rs.getInt("Sacrificios");
                    int le = rs.getInt("LegalesEnfrentados");

                    //Agregarlos a la tabla
                    Tabla.addRow(new Object[]{jornada, il, gano, perdio, cp, cl, ponches, hits, bb, bg, sac, le});
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error con la informacion de los Jugadores", "ERROR", JOptionPane.ERROR_MESSAGE);
        }  
        desconectar();
    }
    
    //-----------------------------------------------------------------------------------------------------------------------
    
    //Mostrar información de la tabla Jornadas
    public void mostrarJornada(DefaultTableModel Tabla, String temporada){
        conectar();
        String query = "SELECT numJornada AS Jornada, fechaInicio AS Inicio, fechaFin AS Fin FROM Jornada WHERE temporada = " + claveTemporada(temporada);
        
        try (PreparedStatement PS = oConexion.prepareStatement(query)) {
            
            try (ResultSet rs = PS.executeQuery()) {
                
                Tabla.setRowCount(0);
                
                while(rs.next()){
                    String numJ = rs.getString("Jornada");
                    Date fechaI = rs.getDate("Inicio");
                    Date fechaF = rs.getDate("Fin");
                    
                    Tabla.addRow(new Object[]{numJ, fechaI, fechaF});
                }
            }
            
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la informacion de las Jornadas", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //-----------------------------------------------------------------------------------------------------------------------
    
    // Obtener la clave de la Liga
    public int claveLiga(String nombre) {
        conectar();
        int clave = -1;
        
        String query = 
        "SELECT " +
            "id_liga AS Clave " +
        "FROM " +
            "Liga " +
        "WHERE " +
            "liga_nombre like '" + nombre + "'";
        
        try {
            PreparedStatement PS = oConexion.prepareStatement(query);
            ResultSet RS = PS.executeQuery();
            
            if (RS.next()) {
                clave = RS.getInt("Clave");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error con la clave de la Liga", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        return clave;
    }
    
    // Obtener la clave de la temporada
    public int claveTemporada(String nombre) {
        conectar();
        int clave = -1;
        
        String query = 
        "SELECT " +
            "id_temporada AS Clave " +
        "FROM " +
            "Temporada " +
        "WHERE " +
            "temp_nombre like '" + nombre + "'";
        
        try {
            PreparedStatement PS = oConexion.prepareStatement(query);
            ResultSet RS = PS.executeQuery();
            
            if (RS.next()) {
                clave = RS.getInt("Clave");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error con la clave de la Temporada", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        return clave;
    }
    
    // Obtener la clave de la categoría
    public int claveCategoria(String nombre) {
        conectar();
        int clave = -1;
        
        String query = 
        "SELECT " +
            "id_categoria AS Clave " +
        "FROM " +
            "Categoria " +
        "WHERE " +
            "cat_nombre like '" + nombre + "'";
        
        try {
            PreparedStatement PS = oConexion.prepareStatement(query);
            ResultSet RS = PS.executeQuery();
            
            if (RS.next()) {
                clave = RS.getInt("Clave");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error con la clave de la Liga", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        return clave;
    }
    
    //Obtener la clave del Equipo
    public int claveEquipo(String nombre, String categoria, String temporada) {
        conectar();
        int clave = -1;

        String query = "SELECT id_equipo AS Clave FROM Equipo WHERE e_nombre = ? AND categoria = ? AND temporada = ?";

        try (PreparedStatement PS = oConexion.prepareStatement(query)) {

            PS.setString(1, nombre);
            PS.setInt(2, claveCategoria(categoria));
            PS.setInt(3, claveTemporada(temporada));

            ResultSet RS = PS.executeQuery();

            if (RS.next()) {
                clave = RS.getInt("Clave");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error con la clave del Equipo", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        desconectar();
        return clave;
    }
    
    //-----------------------------------------------------------------------------------------------------------------------
    
    //Obtener la clave de un Jugador
    public int claveJugador(String nombre, int equipo){
        conectar();
        int clave = -1;

        String query = "SELECT id_jugador AS Clave FROM Jugador WHERE j_nombre = ? AND equipo = ?";

        try (PreparedStatement PS = oConexion.prepareStatement(query)) {

            PS.setString(1, nombre);
            PS.setInt(2, equipo);

            ResultSet RS = PS.executeQuery();

            if (RS.next()) {
                clave = RS.getInt("Clave");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error con la clave del jugador", "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }

        desconectar();
        return clave;
    }
    
    //-----------------------------------------------------------------------------------------------------------------------
    
    //Obtener la clave de una Jornada
    public int claveJornada(String numJornada){
        conectar();
        int clave = -1;
        
        String query = "SELECT id_jornada AS Clave FROM Jornada WHERE (numJornada = ?)";
        
        try(PreparedStatement PS = oConexion.prepareStatement(query)){
            
            PS.setString(1, numJornada);
            
            ResultSet RS = PS.executeQuery();
            
            if (RS.next()) {
                clave = RS.getInt("Clave");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la clave de la Jornada", "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }
        
        desconectar();
        return clave;
    }
    
    //-----------------------------------------------------------------------------------------------------------------------
    
    //Obtener la clave de las Jornadas de los Equipos
    public int claveJEquipo(String jornada, int equipo){
        conectar();
        int clave = -1;
        
            String query = "SELECT id_jequipo AS Clave FROM JEquipo WHERE jornada = ? AND equipo = ?";
        
        try(PreparedStatement PS = oConexion.prepareStatement(query)){
            
            PS.setInt(1, claveJornada(jornada));
            PS.setInt(2, equipo);
            
            ResultSet RS = PS.executeQuery();
            
            if (RS.next()) {
                clave = RS.getInt("Clave");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la clave de la Jornada del Equipo", "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }
        
        desconectar();
        return clave;
    }
    
    //-----------------------------------------------------------------------------------------------------------------------
    
    //Obtener la clave de las Jornadas de los Bateadores
    public int claveJBateador(int jornada, int jugador){
        conectar();
        int clave = -1;
        
        String query = "SELECT id_jbateador AS Clave FROM JBateador WHERE (jornada = ? and jugador = ?)";
        
        try(PreparedStatement PS = oConexion.prepareStatement(query)){
            
            PS.setInt(1, jornada);
            PS.setInt(2, jugador);
            
            ResultSet RS = PS.executeQuery();
            
            if (RS.next()) {
                clave = RS.getInt("Clave");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la clave de la Jornada del Bateador", "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }
        
        desconectar();
        return clave;
    }
    
     //Obtener la clave de las Jornadas de los Bateadores
    public int claveJPicher(int jornada, int jugador){
        conectar();
        int clave = -1;
        
        String query = "SELECT id_jpicher AS Clave FROM JPicher WHERE (jornada = ? and jugador = ?)";
        
        try(PreparedStatement PS = oConexion.prepareStatement(query)){
            
            PS.setInt(1, jornada);
            PS.setInt(2, jugador);
            
            ResultSet RS = PS.executeQuery();
            
            if (RS.next()) {
                clave = RS.getInt("Clave");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la clave de la Jornada del Picher", "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }
        
        desconectar();
        return clave;
    }
    
    //-----------------------------------------------------------------------------------------------------------------------
    
    //Consulta que retorne los equipos por categoría
    public void Equipos(JComboBox<String> CB, String temporada, String categoria){
        CB.removeAllItems();
        String query = "SELECT e_nombre AS Nombre FROM Equipo WHERE temporada = ? and categoria = ?";
        conectar();
        
        try(PreparedStatement PS = oConexion.prepareStatement(query)){
            
            PS.setInt(1, claveTemporada(temporada));
            PS.setInt(2, claveCategoria(categoria));
            
            ResultSet RS = PS.executeQuery();
            
            while (RS.next()) {
                String equipo = RS.getString("Nombre");
                CB.addItem(equipo);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error mostrando los Equipos", "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }   
    }
    
    //-----------------------------------------------------------------------------------------------------------------------
    
    //Consulta que retorne los jugadores por equipo
    public void Jugadores(JComboBox<String> CB, String equipo, String categoria, String temporada){
        CB.removeAllItems();
        String query = "SELECT j_nombre AS Jugador FROM Jugador WHERE equipo = " + claveEquipo(equipo, categoria, temporada);
        conectar();
        
        try(PreparedStatement PS = oConexion.prepareStatement(query)){
            
            ResultSet RS = PS.executeQuery();
            
            while (RS.next()) {
                String jugador = RS.getString("Jugador");
                CB.addItem(jugador);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error mostrando los Jugadores", "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }  
    }
    
    // Consulta que retorne las ligas existentes
    public void Ligas(JComboBox<String> CB) {
        CB.removeAllItems();
        String query = "SELECT liga_nombre AS Ligas FROM Liga";
        conectar();
        
        try(PreparedStatement PS = oConexion.prepareStatement(query)){
            
            ResultSet RS = PS.executeQuery();
            
            while (RS.next()) {
                String liga = RS.getString("Ligas");
                CB.addItem(liga);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error mostrando las Ligas", "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    // Conulta que retorne las temporadas por liga
    public void Temporadas(JComboBox<String> CB, String liga) {
        CB.removeAllItems();
        
        String query = "SELECT temp_nombre AS Temporadas FROM Temporada WHERE liga = " + claveLiga(liga) + " ORDER BY Temporadas DESC";
        conectar();
        
        try(PreparedStatement PS = oConexion.prepareStatement(query)){
            
            ResultSet RS = PS.executeQuery();
            
            while (RS.next()) {
                String temp = RS.getString("Temporadas");
                CB.addItem(temp);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error mostrando las Temporadas", "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    // Consulta que retorne las categorias de las ligas
    public void Categorias(JComboBox<String> CB, String liga) {
        CB.removeAllItems();
        String query = "SELECT cat_nombre AS Categorias FROM Categoria WHERE liga = " + claveLiga(liga);
        conectar();
        
        try(PreparedStatement PS = oConexion.prepareStatement(query)){
            
            ResultSet RS = PS.executeQuery();
            
            while (RS.next()) {
                String ctg = RS.getString("Categorias");
                CB.addItem(ctg);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error mostrando las Categorias", "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void Jornadas(JComboBox<String> CB, String temp) {
        CB.removeAllItems();
        String query = "SELECT numJornada AS Jornada FROM Jornada WHERE temporada = " + claveTemporada(temp);
        conectar();
        
        try(PreparedStatement PS = oConexion.prepareStatement(query)){
            
            ResultSet RS = PS.executeQuery();
            
            while (RS.next()) {
                String jrn = RS.getString("Jornada");
                CB.addItem(jrn);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error mostrando las Categorias", "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    //-----------------------------------------------------------------------------------------------------------------------
    
    //Imprimir los datos de una tabla en archivos de texto
    public void Imprimir(JTable Tabla, String Liga, String archivo, String ruta){
        modeloColumna = Tabla.getColumnModel();
        // int x;
        FileWriter oFW = null;
        PrintWriter oPW = null;
        
        try {
            
            //Guardar el archivo en cierta dirección
            //Colocar el nombre según que sea lo que se imprime
            String guardar = "C:\\Users\\angel\\Desktop\\Liga " + Liga + "\\" + ruta + "\\" + archivo + ".txt";
            oFW = new FileWriter(guardar, false);
            oPW = new PrintWriter(oFW);
            
            //Recorrer los encabezados
            for(int i=0; i < Tabla.getColumnCount(); i++){
                String titulo = modeloColumna.getColumn(i).getIdentifier().toString();
                oPW.print(titulo + "\t");
            }
            
            //Brincar un renglón
            oPW.println();
            
            //Recorrer la tabla y guardar los datos en el archivo de texto
            /*if(Tabla.getRowCount()<10) x = Tabla.getRowCount();
            else x=10;*/
            
            for(int i=0; i < Tabla.getRowCount()/*x*/; i++){
                for(int j=0; j < Tabla.getColumnCount(); j++){
                    String parametro = Tabla.getValueAt(i, j).toString();
                    oPW.print(parametro + "\t");
                }
                oPW.println();
            }
            
            oFW.close();
            oPW.close();
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error de Impresión", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //------------------------------------------------------------------------------------------
}
