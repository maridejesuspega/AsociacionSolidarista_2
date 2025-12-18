package Controlador;

import Conector.Conector;
import Modelo.InscripcionPrograma;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleTypes;
import java.sql.CallableStatement;

//Clase Inscripcion Programa controlador
public class InscripcionProgramaC {

    //Coneccion a la bd
    Conector cn = new Conector();
    Connection con;
    //Este es para llamar a los stored porcedures 
    CallableStatement cs;
    ResultSet rs;

    
    /*
    ESTE METODO SE CAMBIO POR UNO CON VALIDACIONES QUE ESTA ABAJO
     */
    
    // Registrar InscripcionPrograma usando un stored procedure
    public boolean RegistrarInscripcionPrograma(InscripcionPrograma ins) {
        //Stored procedure que se va llamar 
        String sql = "{ call InsertarInscripcionPrograma(?, ?, ?) }";
        try {
            //Coneccion a DB
            con = cn.getConnection();
            //Para llamar el procedure
            cs = con.prepareCall(sql);

            cs.setInt(1, ins.getNumeroInscripcion());
            cs.setInt(2, ins.getIdPrograma());
            cs.setDate(3, new java.sql.Date(ins.getFechaInscripcion().getTime()));

            cs.execute();
            return true;

            //Manejo de errores
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return false;

        } finally {
            cerrarConexion();
        }
    }
    
    /**
     * Registrar Inscripción de Programa CON VALIDACIONES
     * Usa stored procedure que valida datos (posiblemente con REGEX) antes de insertar.
     * * @param inscripcion Objeto InscripcionPrograma con los datos a registrar
     * @return true si se registró correctamente, false si hubo error o validación falló
     */
    public boolean RegistrarInscripcionProgramaValidada(InscripcionPrograma inscripcion) {
        String sql = "{ call InsertarInscripcionValidada(?, ?, ?, ?, ?) }";

        try {
            con = cn.getConnection();
            cs = con.prepareCall(sql);
            
            // Parámetros de entrada
            cs.setInt(1, inscripcion.getNumeroInscripcion());
            cs.setInt(2, inscripcion.getIdPrograma());
            cs.setDate(3, new java.sql.Date(inscripcion.getFechaInscripcion().getTime()));
            
            // Parámetros de salida
            // 4: Resultado (1 = Éxito, 0 = Fallo)
            // 5: Mensaje de error o éxito
            cs.registerOutParameter(4, java.sql.Types.NUMERIC); 
            cs.registerOutParameter(5, java.sql.Types.VARCHAR); 
            
            cs.execute();
            
            int resultado = cs.getInt(4);
            String mensaje = cs.getString(5);
            
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, mensaje, "Error de Validación", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
        } catch (SQLException e) {
            System.out.println("Error al registrar inscripción validada: " + e.toString());
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            try {
                if (cs != null) cs.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.toString());
            }
        }
    }


    /*
    ESTE METODO SE CAMBIO POR UNO CON VALIDACIONES QUE ESTA ABAJO
    */
    
    // Actualizar InscripcionPrograma usando un stored procedure
    public boolean ActualizarInscripcionPrograma(InscripcionPrograma ins) {

        //Metodo que va a llamar
        String sql = "{ call ActualizarInscripcionPrograma(?, ?, ?) }";
        try {
            //Coneccion a DB
            con = cn.getConnection();
            //Para llamar el procedure
            cs = con.prepareCall(sql);

            cs.setInt(1, ins.getNumeroInscripcion());
            cs.setInt(2, ins.getIdPrograma());
            cs.setDate(3, new java.sql.Date(ins.getFechaInscripcion().getTime()));

            cs.execute();
            return true;

            //Manejo de errores
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return false;

        } finally {
            cerrarConexion();
        }
    }
    
    /**
     * Actualizar Inscripción de Programa CON VALIDACIONES
     * Usa stored procedure que valida datos antes de actualizar.
     * * @param inscripcion Objeto InscripcionPrograma con los datos actualizados
     * @return true si se actualizó correctamente, false si hubo error o validación falló
     */
    public boolean ActualizarInscripcionProgramaValidada(InscripcionPrograma inscripcion) {
        String sql = "{ call ActualizarInscripcionValidada(?, ?, ?, ?, ?) }";
        java.sql.CallableStatement cs = null;

        try {
            con = cn.getConnection();
            cs = con.prepareCall(sql);
            
            // Parámetros de entrada
            cs.setInt(1, inscripcion.getNumeroInscripcion());
            cs.setInt(2, inscripcion.getIdPrograma());
            cs.setDate(3, new java.sql.Date(inscripcion.getFechaInscripcion().getTime()));
            
            // Parámetros de salida
            cs.registerOutParameter(4, java.sql.Types.NUMERIC); 
            cs.registerOutParameter(5, java.sql.Types.VARCHAR); 
            
            cs.execute();
            
            int resultado = cs.getInt(4);
            String mensaje = cs.getString(5);
            
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, mensaje, "Error de Validación", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
        } catch (SQLException e) {
            System.out.println("Error al actualizar inscripción validada: " + e.toString());
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            try {
                if (cs != null) cs.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.toString());
            }
        }
    }
    
    

    // Eliminar InscripcionPrograma usando un stored procedure
    public boolean EliminarInscripcionPrograma(int numeroInscripcion) {

        //Metodo que se va llamar para eliminar inscripcion de programa
        String sql = "{ call EliminarInscripcionPrograma(?) }";
        try {
            //Coneccion a DB
            con = cn.getConnection();
            //Para llamar el procedure
            cs = con.prepareCall(sql);

            cs.setInt(1, numeroInscripcion);
            cs.execute();

            return true;

            //Manejo de Erroes    
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return false;

        } finally {
            cerrarConexion();
        }
    }

    // Obtener lista de InscripcionesPrograma usando un stored procedure
    public List<InscripcionPrograma> ListaInscripcionesPrograma() {
        //Aca se guarda la lista de inscripcion programa en un array list
        List<InscripcionPrograma> lista = new ArrayList<>();
        
        //Metodo que se va a llamar para obtener la inscripcion de programa
        String sql = "{ call ObtenerInscripcionesPrograma(?) }";

        try {
            //Coneccion a DB
            con = cn.getConnection();
             //Para llamar el procedure
            cs = con.prepareCall(sql);

            cs.registerOutParameter(1, OracleTypes.CURSOR); //Cursor
            cs.execute();

            rs = (ResultSet) cs.getObject(1);

            while (rs.next()) {
                InscripcionPrograma ins = new InscripcionPrograma();
                ins.setNumeroInscripcion(rs.getInt("Numero_Inscripcion"));
                ins.setIdPrograma(rs.getInt("ID_Programa"));
                ins.setFechaInscripcion(rs.getDate("Fecha_Inscripcion"));
                lista.add(ins);
            }

            //Manejo de errores
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            cerrarConexion();
        }
        return lista;
    }

    // Buscar InscripcionPrograma por número de inscripción usando un stored procedure
    public InscripcionPrograma BuscarInscripcionPrograma(int numeroInscripcion) {
        //Inscripcion donde que se va a devolver
        InscripcionPrograma ins = null;
        
        //Metodo que va a llamar
        String sql = "{ call BuscarInscripcionPrograma(?, ?) }";

        try {
            //Coneccion a DB
            con = cn.getConnection();
             //Para llamar el procedure
            cs = con.prepareCall(sql);

            cs.setInt(1, numeroInscripcion);
            cs.registerOutParameter(2, OracleTypes.CURSOR);

            cs.execute();

            rs = (ResultSet) cs.getObject(2);

            if (rs.next()) {
                ins = new InscripcionPrograma();
                ins.setNumeroInscripcion(rs.getInt("Numero_Inscripcion"));
                ins.setIdPrograma(rs.getInt("ID_Programa"));
                ins.setFechaInscripcion(rs.getDate("Fecha_Inscripcion"));
            }

        //Manejo de errores     
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            cerrarConexion();
        }

        return ins;
    }

    // Método para llenar un JComboBox con todos los números de inscripcion
    public void llenarComboBoxNumerosInscripcion(JComboBox<String> combo) {
        //Stored procedure que se va a llamar
        String sql = "{ call ObtenerTodosLosNumerosInscripcion(?) }";

        try {
            //Coneccion a DB
            con = cn.getConnection();
             //Para llamar el procedure
            cs = con.prepareCall(sql);

            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();

            rs = (ResultSet) cs.getObject(1);

            combo.removeAllItems(); //Remover todos los itles de ese moment

            while (rs.next()) {
                combo.addItem(rs.getString("Numero_Inscripcion"));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            cerrarConexion();
        }
    }

    //Metodo para cerrar la conexion ya que se va a llamar varias veces
    private void cerrarConexion() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (cs != null) {
                cs.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("Error cerrando conexión: " + e.getMessage());
        }
    }
}
