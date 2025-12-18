
package Modelo;

import java.math.BigDecimal;
import java.util.Date;


//Clase Transaccion Financiera
public class TransaccionFinanciera {
    private int idTransaccion;
    private int idAsociado;
    private int tipoTransaccion;
    private int idCuentaBancaria;
    private BigDecimal monto;
    private Date fechaTransaccion;
    private String detalleTransaccion;
    private int idMetodoPago;

    
    //Constructor Vacio
    public TransaccionFinanciera() {
    }

    
    //Constructor
    public TransaccionFinanciera(int idTransaccion, int idAsociado, int tipoTransaccion, int idCuentaBancaria, BigDecimal monto, Date fechaTransaccion, String detalleTransaccion, int idMetodoPago) {
        this.idTransaccion = idTransaccion;
        this.idAsociado = idAsociado;
        this.tipoTransaccion = tipoTransaccion;
        this.idCuentaBancaria = idCuentaBancaria;
        this.monto = monto;
        this.fechaTransaccion = fechaTransaccion;
        this.detalleTransaccion = detalleTransaccion;
        this.idMetodoPago = idMetodoPago;
    }

    
    //Getters y Setters
    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public int getIdAsociado() {
        return idAsociado;
    }

    public void setIdAsociado(int idAsociado) {
        this.idAsociado = idAsociado;
    }

    public int getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(int tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public int getIdCuentaBancaria() {
        return idCuentaBancaria;
    }

    public void setIdCuentaBancaria(int idCuentaBancaria) {
        this.idCuentaBancaria = idCuentaBancaria;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public String getDetalleTransaccion() {
        return detalleTransaccion;
    }

    public void setDetalleTransaccion(String detalleTransaccion) {
        this.detalleTransaccion = detalleTransaccion;
    }

    public int getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(int idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }
}

    
   
    
    

