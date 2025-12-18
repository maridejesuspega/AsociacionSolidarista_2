/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

//Clase Asociado
public class Asociado {
    
    //Atributos de Asociado
    private int idAsociado;
    private int cedulaAsociado;
    private String nombreAsociado;
    private String apellidoAsociado;
    private String correoAsociado;
    private Date fechaIngreso;
    private int codigoPostal;

    
    //Contructor vacio
    public Asociado() {
    }

    
    //Constructor
    public Asociado(int idAsociado, int cedulaAsociado, String nombreAsociado, String apellidoAsociado, String correoAsociado, Date fechaIngreso, int codigoPostal) {
        this.idAsociado = idAsociado;
        this.cedulaAsociado = cedulaAsociado;
        this.nombreAsociado = nombreAsociado;
        this.apellidoAsociado = apellidoAsociado;
        this.correoAsociado = correoAsociado;
        this.fechaIngreso = fechaIngreso;
        this.codigoPostal = codigoPostal;
    }

    //Getters y Setters
    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    
    
    public int getIdAsociado() {
        return idAsociado;
    }

    public void setIdAsociado(int idAsociado) {
        this.idAsociado = idAsociado;
    }

    public int getCedulaAsociado() {
        return cedulaAsociado;
    }

    public void setCedulaAsociado(int cedulaAsociado) {
        this.cedulaAsociado = cedulaAsociado;
    }

    public String getNombreAsociado() {
        return nombreAsociado;
    }

    public void setNombreAsociado(String nombreAsociado) {
        this.nombreAsociado = nombreAsociado;
    }

    public String getApellidoAsociado() {
        return apellidoAsociado;
    }

    public void setApellidoAsociado(String apellidoAsociado) {
        this.apellidoAsociado = apellidoAsociado;
    }

    public String getCorreoAsociado() {
        return correoAsociado;
    }

    public void setCorreoAsociado(String correoAsociado) {
        this.correoAsociado = correoAsociado;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    //To String para mostrar el asociado en tipo STRING
    @Override
    public String toString() {
        return "Asociado{" 
                + "idAsociado=" + idAsociado + 
                ", cedulaAsociado=" + cedulaAsociado + 
                ", nombreAsociado=" + nombreAsociado + 
                ", apellidoAsociado=" + apellidoAsociado + 
                ", correoAsociado=" + correoAsociado + 
                ", fechaIngreso=" + fechaIngreso +
                ", " + super.toString() +
                + '}';
    }

 
    
    
    
}
