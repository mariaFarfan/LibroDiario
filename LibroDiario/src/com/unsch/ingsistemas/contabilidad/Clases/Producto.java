/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.ingsistemas.contabilidad.Clases;

/**
 *
 * @author USUARIO
 */
public class Producto {

    private int id;
    private String Nombre;
    private String Descripcion;
    private int cantidad_existencia;
    private double PrecioVenta;
    private double PrecioCompra;

    public Producto() {
    }

    public Producto(int id, String Nombre, String Descripcion, int cantidad_existencia, double PrecioVenta, double PrecioCompra) {
        this.id = id;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.cantidad_existencia = cantidad_existencia;
        this.PrecioVenta = PrecioVenta;
        this.PrecioCompra = PrecioCompra;
    }

    public double getPrecioCompra() {
        return PrecioCompra;
    }

    public void setPrecioCompra(double PrecioCompra) {
        this.PrecioCompra = PrecioCompra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getCantidad_existencia() {
        return cantidad_existencia;
    }

    public void setCantidad_existencia(int cantidad_existencia) {
        this.cantidad_existencia = cantidad_existencia;
    }

    public double getPrecioVenta() {
        return PrecioVenta;
    }

    public void setPrecioVenta(double PrecioVenta) {
        this.PrecioVenta = PrecioVenta;
    }

    @Override
    public String toString() {
        return id + Nombre + Descripcion + cantidad_existencia + PrecioVenta + PrecioCompra;
    }

}
