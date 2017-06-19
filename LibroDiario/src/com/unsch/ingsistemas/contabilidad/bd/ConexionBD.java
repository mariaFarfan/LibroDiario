package com.unsch.ingsistemas.contabilidad.bd;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class ConexionBD {

    private Connection conexion = null;
    private String servidor = "localhost";
    private String database = "pcge2015";
    private String usuario = "root";
    private String password = "newlifefb94";
    private String url = "";

//    public ConexionBD(String servidor, String database, String usuario, String password) {
    public ConexionBD() {
        try {

            this.servidor = servidor;
            this.database = database;
            Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            url = "jdbc:mysql://" + servidor + "/" + database;
            conexion = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexion a Base de Datos " + url + " . . . . .Ok");
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public Connection cerrarConexion() {
        try {
            conexion.close();
            System.out.println("Cerrando conexion a " + url + " . . . . . Ok");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        conexion = null;
        return conexion;
    }

    /*
//    metodo para insertar en encuestado 
    public void insertar(String n, String ap, String ed, String tel, String em) throws SQLException {
        ConexionBD con = new ConexionBD();
        String sql = "insert into encuestado values(NULL,'" + n + "','" + ap + "','" + ed + "','" + tel + "','" + em + "')";
        Statement s = (Statement) con.getConexion().createStatement();
        s.executeUpdate(sql);
        con.cerrarConexion();
    }

    public int obtnerultimoRgtr() throws SQLException {
        ConexionBD con = new ConexionBD();
        Statement s = (Statement) con.getConexion().createStatement();
        ResultSet c = s.executeQuery("select MAX(idEncuestado) from encuestado ");
        int cx = 0;
        while (c.next()) {
            cx = c.getInt(1);
        }
        return cx;
    }

    public void insertResultado(String cS, String ca) throws SQLException {
        ConexionBD con = new ConexionBD();
        String sql = "insert into resultado values(" + obtnerultimoRgtr() + ",'" + cS + "','" + ca + "')";
        Statement s = (Statement) con.getConexion().createStatement();
        s.executeUpdate(sql);
        con.cerrarConexion();
    }

    public static LinkedList<Resultados> listaResultados() throws ClassNotFoundException, SQLException {
        LinkedList<Resultados> lista = new LinkedList<Resultados>();
        ConexionBD con = new ConexionBD();
        con.getConexion();
        java.sql.Statement st = con.getConexion().createStatement();
        ResultSet rs = st.executeQuery(" select concat_ws(' ,', encuestado.nombre, encuestado.apellido) as na , resultado.CienciaS as cs ,resultado.Carrera as ca  from encuestado  "
                + "inner join resultado on  resultado.idresultado = encuestado.idEncuestado");
        while (rs.next()) {
            Resultados resultados = new Resultados();
            resultados.setNombre(rs.getString("na"));
            resultados.setCiencia(rs.getString("cs"));
            resultados.setCarrera(rs.getString("ca"));
            lista.add(resultados);
        }
        return lista;
    }
    
    
     public static LinkedList<Resultados> lsiataEncuestados() throws ClassNotFoundException, SQLException {
        LinkedList<Resultados> lista = new LinkedList<Resultados>();
        ConexionBD con = new ConexionBD();
        con.getConexion();
        java.sql.Statement st = con.getConexion().createStatement();
        ResultSet rs = st.executeQuery(" select concat_ws(' ,', encuestado.nombre, encuestado.apellido) as na , resultado.CienciaS as cs ,resultado.Carrera as ca  from encuestado  "
                + "inner join resultado on  resultado.idresultado = encuestado.idEncuestado");
        while (rs.next()) {
            Resultados resultados = new Resultados();
            resultados.setNombre(rs.getString("na"));
            resultados.setCiencia(rs.getString("cs"));
            resultados.setCarrera(rs.getString("ca"));
            lista.add(resultados);
        }
        return lista;
    }
     
     
     
     
     
     */
    public static void main(String[] args) throws SQLException {
        ConexionBD con = new ConexionBD();
        con.getConexion();
        con.cerrarConexion();
//        con.insertar("jose", "Maldonado", "21", "70905469", "jose@gmail.com");
//        con.insertResultado("Ciencia de la Salud", "Medicina");
//        con.cerrarConexion();
    }
}
