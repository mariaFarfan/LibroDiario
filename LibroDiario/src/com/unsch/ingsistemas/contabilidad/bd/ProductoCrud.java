/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.ingsistemas.contabilidad.bd;

import com.unsch.ingsistemas.contabilidad.Clases.Producto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class ProductoCrud {

    public ProductoCrud() {
    }
    
    public ArrayList<Producto> listaProductos(){
        ArrayList<Producto> lista= new ArrayList<>();
        
        
        String s = "SELECT * FROM productoinicial ";
        ConexionBD mysql = new ConexionBD();
        Connection cn = mysql.getConexion();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(s);
            while (rs.next()) {

                Producto producto = new Producto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getDouble(6));
                lista.add(producto);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return lista;
    } 
    
     public Producto select(String nombre) {
        String s = "SELECT * FROM productoinicial where nombre='"+nombre+"'";
        ConexionBD mysql = new ConexionBD();
        Connection cn = mysql.getConexion();
        Producto productoRetorno = new Producto();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(s);
            while (rs.next()) {

                Producto producto = new Producto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getDouble(6));
                productoRetorno =  producto;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return productoRetorno;
    }
     
      public Producto select2(String nombre) {
        String s = "SELECT * FROM producto where nombre='"+nombre+"'";
        ConexionBD mysql = new ConexionBD();
        Connection cn = mysql.getConexion();
        Producto productoRetorno = new Producto();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(s);
            while (rs.next()) {

                Producto producto = new Producto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getDouble(6));
                productoRetorno =  producto;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return productoRetorno;
    }
     
    
    
    
    public static void main(String[] args) {
        ProductoCrud p =  new ProductoCrud();
        System.out.println(p.listaProductos());
        System.out.println(p.select("uiuoiuio"));
    }
}
