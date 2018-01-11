package com.unsch.ingsistemas.contabilidad.Clases;

public class Empleado {

    private String nombre;
    private String dni;
    private String cargo;
    private String hijo;
    private String pension;

    public Empleado(String nombre, String dni, String cargo, String hijo, String pension) {
        this.nombre = nombre;
        this.dni = dni;
        this.cargo = cargo;
        this.hijo = hijo;
        this.pension = pension;
    }

    public Empleado() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getHijo() {
        return hijo;
    }

    public void setHijo(String hijo) {
        this.hijo = hijo;
    }

    public String getPension() {
        return pension;
    }

    public void setPension(String pension) {
        this.pension = pension;
    }

    @Override
    public String toString() {
        return nombre + dni + cargo + hijo; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
}
