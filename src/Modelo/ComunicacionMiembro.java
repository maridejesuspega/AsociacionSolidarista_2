
package Modelo;

import java.util.Date;


//Clase Comunicacion Miembro
public class ComunicacionMiembro{
    
    //Atributos de Comunicacion miembro
    private int idComunicacion;
    private int idAsociado;
    private int idTipoComunicacion;
    private Date fechaComunicacion;
    private String notas;

    //Constructor vacio
    public ComunicacionMiembro() {
    }

    
    //Constructor
    public ComunicacionMiembro(int idComunicacion, int idAsociado, int idTipoComunicacion, Date fechaComunicacion, String notas) {
        this.idComunicacion = idComunicacion;
        this.idAsociado = idAsociado;
        this.idTipoComunicacion = idTipoComunicacion;
        this.fechaComunicacion = fechaComunicacion;
        this.notas = notas;
    }

    
    //Getters y Setters
    public int getIdTipoComunicacion() {
        return idTipoComunicacion;
    }

    public void setIdTipoComunicacion(int idTipoComunicacion) {
        this.idTipoComunicacion = idTipoComunicacion;
    }
    
    
    

    public int getIdComunicacion() {
        return idComunicacion;
    }

    public void setIdComunicacion(int idComunicacion) {
        this.idComunicacion = idComunicacion;
    }

    public int getIdAsociado() {
        return idAsociado;
    }

    public void setIdAsociado(int idAsociado) {
        this.idAsociado = idAsociado;
    }

    public Date getFechaComunicacion() {
        return fechaComunicacion;
    }

    public void setFechaComunicacion(Date fechaComunicacion) {
        this.fechaComunicacion = fechaComunicacion;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    //To String para mostrar el la comunicacion de miembro en tipo STRING
    @Override
    public String toString() {
        return "ComunicacionMiembro{" + 
                "idComunicacion=" + idComunicacion + 
                ", idAsociado=" + idAsociado + 
                ", fechaComunicacion=" + fechaComunicacion +
                ", " + super.toString() +
                ", notas=" + notas + '}';
    }
    
    
    
    
    
    
    
    
}
