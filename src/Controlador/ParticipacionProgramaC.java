package Controlador;

import Conector.Conector;
import Modelo.ParticipacionPrograma;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import java.sql.CallableStatement;
import oracle.jdbc.OracleTypes;

//Clase Participacion programa controller
public class ParticipacionProgramaC {
    
    //Coneccion a la BD
    private Conector cn = new Conector();
    private Connection con;
    
    //Este es para poder llamar o enviar los stored procedures
    CallableStatement cs;
    private ResultSet rs;

    // Registrar Participación de Programa usando un stored procedure
    public boolean RegistrarParticipacionPrograma(ParticipacionPrograma pp) {
        //Stored procedure que se mandara a llamar
        String sql = "{ call InsertarParticipacionPrograma(?, ?, ?) }";

        try {
            //Coneccion a DB
            con = cn.getConnection();
            //Para llamar el procedure
            cs = con.prepareCall(sql);

            cs.setInt(1, pp.getIdAsociado());
            cs.setInt(2, pp.getNumeroInscripcion());
            cs.setInt(3, pp.getIdEstado());

            cs.execute();
            return true;

        //Manejo de errores    
        } catch (SQLException e) {
            System.out.println("Error al registrar participación: " + e.getMessage());
            return false;

        } finally {
            cerrarConexion();
        }
    }

    // Actualizar Participación de Programa usando un stored procedure
    public boolean ActualizarParticipacionPrograma(ParticipacionPrograma pp) {
        //Stored procedure que se va llamar para actualizar participacion programa
        String sql = "{ call ActualizarParticipacionPrograma(?, ?, ?) }";

        try {
            //Coneccion a DB
            con = cn.getConnection();
            //Para llamar el procedure
            cs = con.prepareCall(sql);

            cs.setInt(1, pp.getIdAsociado());
            cs.setInt(2, pp.getNumeroInscripcion());
            cs.setInt(3, pp.getIdEstado());

            cs.execute();
            return true;

            
        //Manejo de errores    
        } catch (SQLException e) {
            System.out.println("Error al actualizar participación: " + e.getMessage());
            return false;

        } finally {
            cerrarConexion();
        }
    }

    
    //Eliminar praticipacion de programa 
    public boolean EliminarParticipacionPrograma(int numeroInscripcion) {
        //Stored procedure que se llamara para eliminar 
        String sql = "{ call EliminarParticipacionPrograma(?) }";

        try {
            //Coneccion a DB
            con = cn.getConnection();
            //Para llamar el procedure
            cs = con.prepareCall(sql);
            cs.setInt(1, numeroInscripcion);
            cs.execute();

            return true;
        //Manejo de errores
        } catch (SQLException e) {
            System.out.println("Error al eliminar participación: " + e.getMessage());
            return false;

        } finally {
            cerrarConexion();
        }
    }

    // Obtener lista de Participaciones de Programa usando un stored procedure
    public List<ParticipacionPrograma> ListaParticipacionPrograma() {
        //Array list donde se va a guardar la lista de participacion de programa 
        List<ParticipacionPrograma> lista = new ArrayList<>();

        //Stored procedure para obtener parcitipacion de programa
        String sql = "{ call ObtenerParticipacionesPrograma(?) }";

        try {
            //Coneccion a DB
            con = cn.getConnection();
            //Para llamar el procedure
            cs = con.prepareCall(sql);

            cs.registerOutParameter(1, OracleTypes.CURSOR);// registrar parámetro OUT
            cs.execute();

            rs = (ResultSet) cs.getObject(1);

            while (rs.next()) {
                ParticipacionPrograma pp = new ParticipacionPrograma();
                pp.setIdAsociado(rs.getInt("ID_Asociados"));
                pp.setNumeroInscripcion(rs.getInt("Numero_Inscripcion"));
                pp.setIdEstado(rs.getInt("ID_Estado"));
                lista.add(pp);
            }
        //Manejo de errores
        } catch (SQLException e) {
            System.out.println("Error al listar participaciones: " + e.getMessage());

        } finally {
            cerrarConexion();
        }

        return lista;
    }

    // Buscar Participación de Programa usando un stored procedure
    public ParticipacionPrograma BuscarParticipacionPrograma(int idAsociado, int numeroInscripcion) {
        //Participacion programa que se va retornar
        ParticipacionPrograma pp = null;
        //Stored procedure que se llamara para buscar la participacion programa
        String sql = "{ call BuscarParticipacionPrograma(?, ?, ?) }";

        try {
            //Coneccion a DB
            con = cn.getConnection();
            //Para llamar el procedure
            cs = con.prepareCall(sql);

            cs.setInt(1, idAsociado);
            cs.setInt(2, numeroInscripcion);
            cs.registerOutParameter(3, OracleTypes.CURSOR);// registrar parámetro OUT

            cs.execute();

            rs = (ResultSet) cs.getObject(3);

            if (rs.next()) {
                pp = new ParticipacionPrograma();
                pp.setIdAsociado(rs.getInt("ID_Asociados"));
                pp.setNumeroInscripcion(rs.getInt("Numero_Inscripcion"));
                pp.setIdEstado(rs.getInt("ID_Estado"));
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar participación: " + e.getMessage());

        } finally {
            cerrarConexion();
        }

        return pp;
    }

    // Llenar JComboBox con todos los ID de estados de participación
     public void llenarComboBoxEstados(JComboBox<String> combo) {
        //Stored procedure para obtener todos los estados
        String sql = "{ call ObtenerTodosLosEstados(?) }";

        try {
            //Coneccion a DB
            con = cn.getConnection();
            //Para llamar el procedure
            cs = con.prepareCall(sql);

            cs.registerOutParameter(1, OracleTypes.CURSOR); // registrar parámetro OUT
            cs.execute();

            rs = (ResultSet) cs.getObject(1);

            combo.removeAllItems(); //Para remover todos los items

            while (rs.next()) {
                combo.addItem(String.valueOf(rs.getInt("ID_Estado")));
            }

        } catch (SQLException e) {
            System.out.println("Error al llenar combo estados: " + e.getMessage());

        } finally {
            cerrarConexion();
        }
    }
    //Metodo para cerrar la conexion a la BD
    private void cerrarConexion() {
        try {
            if (rs != null) rs.close();
            if (cs != null) cs.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar conexión: " + e.getMessage());
        }
    }
}