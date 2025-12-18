package Modelo;
import java.util.Date;

//Clase Inscripcion Programa
public class InscripcionPrograma {
    private int numeroInscripcion;
    private int idPrograma;
    private Date fechaInscripcion;

    //Constructor Vacio
    public InscripcionPrograma() {
    }
    
    
    //Constructor
    public InscripcionPrograma(int numeroInscripcion, int idPrograma, Date fechaInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
        this.idPrograma = idPrograma;
        this.fechaInscripcion = fechaInscripcion;
    }

    
    //Getters y Setters
    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }

    public void setNumeroInscripcion(int numeroInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
    }

    public int getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(int idPrograma) {
        this.idPrograma = idPrograma;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
}
