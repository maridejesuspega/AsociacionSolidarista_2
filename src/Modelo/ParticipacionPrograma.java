
package Modelo;

import java.util.Date;


//Clase participacion Programa
public class ParticipacionPrograma {
    private int idAsociado;
    private int numeroInscripcion;
    private int idEstado;

    
    //Contructor Vacio
    public ParticipacionPrograma() {
    }
    
    
    //Contructor 
    public ParticipacionPrograma(int idAsociado, int numeroInscripcion, int idEstado) {
        this.idAsociado = idAsociado;
        this.numeroInscripcion = numeroInscripcion;
        this.idEstado = idEstado;
    }

    
    //Getters y Setters
    public int getIdAsociado() {
        return idAsociado;
    }

    public void setIdAsociado(int idAsociado) {
        this.idAsociado = idAsociado;
    }

    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }

    public void setNumeroInscripcion(int numeroInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }
}