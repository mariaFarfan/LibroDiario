package com.unsch.ingsistemas.contabilidad.bd;

import com.unsch.ingsistemas.contabilidad.Clases.Empleado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class EmpleadoCRUD {

    public EmpleadoCRUD() {
    }
    
    
    public Empleado select(String nombre) {
        String s = "SELECT Nombre,DNI,Cargo,NumHijos,TipoPension FROM empleado where nombre='"+nombre+"'";
        ConexionBD mysql = new ConexionBD();
        Connection cn = mysql.getConexion();
        Empleado empleadoRetorno = new Empleado();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(s);
            while (rs.next()) {

                Empleado empleado = new Empleado(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                empleadoRetorno =  empleado;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return empleadoRetorno;
    }
    
      
    //////////////////////////////////////
    
    public static void main(String[] args) {
        EmpleadoCRUD e =  new EmpleadoCRUD();
        System.out.println(  e.select("Jose MAldonado"));
    }

}
