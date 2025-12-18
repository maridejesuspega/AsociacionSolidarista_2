package Modelo;

import java.util.Date;


//Clase Dividendo
public class Dividendo {
    
    //Atributos
    private int idDividendo;
    private int idAsociado;
    private double monto;
    private Date fechaPago;
    private int idTransaccion;

    //Constructo vacio
    public Dividendo() {
    }

    //Contructor
    public Dividendo(int idDividendo, int idAsociado, double monto, Date fechaPago, int idTransaccion) {
        this.idDividendo = idDividendo;
        this.idAsociado = idAsociado;
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.idTransaccion = idTransaccion;
    }

    
    //Getters y Setters
    
    public int getIdDividendo() {
        return idDividendo;
    }

    public void setIdDividendo(int idDividendo) {
        this.idDividendo = idDividendo;
    }

    public int getIdAsociado() {
        return idAsociado;
    }

    public void setIdAsociado(int idAsociado) {
        this.idAsociado = idAsociado;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }
}

