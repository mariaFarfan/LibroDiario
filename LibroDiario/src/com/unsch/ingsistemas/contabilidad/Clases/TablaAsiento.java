/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.ingsistemas.contabilidad.Clases;

/**
 *
 * @author José Maldonado <josephcand at gmail.com>
 */
public class TablaAsiento {

    private String numeroAsiento;
    private String codigo;
    private String descripcion;
    private String debe;
    private String haber;

    public String getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(String numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDebe() {
        return debe;
    }

    public void setDebe(String debe) {
        this.debe = debe;
    }

    public String getHaber() {
        return haber;
    }

    public void setHaber(String haber) {
        this.haber = haber;
    }

    public TablaAsiento(String numeroAsiento, String codigo, String descripcion, String debe, String haber) {
        this.numeroAsiento = numeroAsiento;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.debe = debe;
        this.haber = haber;
    }

    public TablaAsiento() {
    }

    @Override
    public String toString() {
        return numeroAsiento + codigo + descripcion + haber + debe;//To change body of generated methods, choose Tools | Templates.
    }

}
