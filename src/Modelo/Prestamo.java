
package Modelo;

import java.util.Date;


//Clase Prestamo
public class Prestamo {
    
    //Atributos
    private int idPrestamo;
    private int idAsociado;
    private double monto;
    private Date fechaDesembolso;
    private Date fechaVencimiento;
    private double tasaInteres;
    private int idEstadoPrestamo;
    private int idTransaccion;

    
    //Constructor Vacio
    public Prestamo() {
    }

    
    //Constructor
    public Prestamo(int idPrestamo, int idAsociado, double monto, Date fechaDesembolso, Date fechaVencimiento, double tasaInteres, int idEstadoPrestamo, int idTransaccion) {
        this.idPrestamo = idPrestamo;
        this.idAsociado = idAsociado;
        this.monto = monto;
        this.fechaDesembolso = fechaDesembolso;
        this.fechaVencimiento = fechaVencimiento;
        this.tasaInteres = tasaInteres;
        this.idEstadoPrestamo = idEstadoPrestamo;
        this.idTransaccion = idTransaccion;
    }

    
    //Getters y Setters
    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
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

    public Date getFechaDesembolso() {
        return fechaDesembolso;
    }

    public void setFechaDesembolso(Date fechaDesembolso) {
        this.fechaDesembolso = fechaDesembolso;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public int getIdEstadoPrestamo() {
        return idEstadoPrestamo;
    }

    public void setIdEstadoPrestamo(int idEstadoPrestamo) {
        this.idEstadoPrestamo = idEstadoPrestamo;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }
}

