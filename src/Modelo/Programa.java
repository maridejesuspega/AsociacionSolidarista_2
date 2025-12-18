package Modelo;



//Clase Programa
public class Programa {
    
    //Atributos
    private int idPrograma;
    private int idcalendarizacion;
    private String nombrePrograma;
    private String descripcionPrograma;
    

    //Construtor Vacio
    public Programa() {
    }

    
    //Constructor
    public Programa(int idPrograma, int idcalendarizacion, String nombrePrograma, String descripcionPrograma) {
        this.idPrograma = idPrograma;
        this.idcalendarizacion = idcalendarizacion;
        this.nombrePrograma = nombrePrograma;
        this.descripcionPrograma = descripcionPrograma;
    }

    
    //Getters y Setters
    public int getIdcalendarizacion() {
        return idcalendarizacion;
    }

    public void setIdcalendarizacion(int idcalendarizacion) {
        this.idcalendarizacion = idcalendarizacion;
    }
    
    
    

    public int getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(int idPrograma) {
        this.idPrograma = idPrograma;
    }

    public String getNombrePrograma() {
        return nombrePrograma;
    }

    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }

    public String getDescripcionPrograma() {
        return descripcionPrograma;
    }

    public void setDescripcionPrograma(String descripcionPrograma) {
        this.descripcionPrograma = descripcionPrograma;
    }

    
    //To String para ver programa en tipo String
    @Override
    public String toString() {
        return "Programa{" + 
                "idPrograma=" + idPrograma + 
                ", nombrePrograma=" + nombrePrograma + 
                ", descripcionPrograma=" + descripcionPrograma 
                + '}';
    }

    
    
    
    
}
