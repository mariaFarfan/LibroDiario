
package com.unsch.ingsistemas.contabilidad.Clases;

public class Kardex {
    private int id;
    private String fecha;
    private String nombre;
    private String cantidad;
    private String costo;
    private String documento;
    private String tipo;

    public Kardex() {
    }

    public Kardex(int id, String fecha, String nombre, String cantidad, String costo, String documento, String tipo) {
        this.id = id;
        this.fecha = fecha;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costo = costo;
        this.documento = documento;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    @Override
    public String toString() {
        return id+ fecha +  nombre+cantidad+ costo +documento+ tipo; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
