package Controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Conector.Conector;
import Modelo.ComunicacionMiembro;
import javax.swing.JComboBox;
import java.sql.CallableStatement;
import oracle.jdbc.OracleTypes;

//Clase controller para comunicacion miembro
public class ComunicacionMiembroC {

    //Coneccion a la DB
    Conector cn = new Conector();
    Connection con;
    //Este es para poder llamar o enviar los stored procedures
    CallableStatement cs;
    ResultSet rs;

    //Registrar Comunicacion Miembro
    // NOTA: El formato de fecha e ID numérico ya se validan en la capa de Vista (Java)
    // El procedimiento solo valida reglas de negocio adicionales (longitud mínima notas, fecha futura)
    public boolean RegistrarComunicacionMiembro(ComunicacionMiembro cm) {

        //Stored procedure que se va a llamar para insertar la comunicacion
        String sql = "{ call InsertarComunicacionMiembro(?, ?, ?, ?, ?) }";

        try {
            //Coneccion a DB
            con = cn.getConnection();
            //Para llamar el procedure
            cs = con.prepareCall(sql);

            // Parámetros: ahora el procedimiento espera NUMBER y DATE directamente
            // (ya vienen validados desde Java)
            cs.setInt(1, cm.getIdComunicacion());
            cs.setInt(2, cm.getIdAsociado());
            cs.setInt(3, cm.getIdTipoComunicacion());
            cs.setDate(4, new java.sql.Date(cm.getFechaComunicacion().getTime()));
            cs.setString(5, cm.getNotas());

            cs.execute();
            JOptionPane.showMessageDialog(null, "Comunicación registrada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            return true;

            //Manejo de Errores    
        } catch (SQLException e) {
            // Mostrar el mensaje de error de la base de datos (incluye validaciones de SQL)
            String mensaje = e.getMessage();
            if (mensaje != null && mensaje.contains("ORA-200")) {
                // Es un error de validación personalizado de Oracle
                JOptionPane.showMessageDialog(null, mensaje, "Error de Validación", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar comunicación: " + mensaje, "Error", JOptionPane.ERROR_MESSAGE);
            }
            System.out.println(e.toString());
            return false;
        } finally {
            cerrarConexion();
        }
    }

    //Actualizar comunicacion miembro
    // NOTA: El formato de fecha e ID numérico ya se validan en la capa de Vista (Java)
    // El procedimiento solo valida reglas de negocio adicionales (longitud mínima notas, fecha futura)
    public boolean ActualizarComunicacionMiembro(ComunicacionMiembro cm) {
        //Stored procedure que se va llamar
        String sql = "{ call ActualizarComunicacionMiembro(?, ?, ?, ?, ?) }";

        try {
            //Coneccion a DB
            con = cn.getConnection();
            //Para llamar el procedure
            cs = con.prepareCall(sql);

            // Parámetros: ahora el procedimiento espera NUMBER y DATE directamente
            cs.setInt(1, cm.getIdComunicacion());
            cs.setInt(2, cm.getIdAsociado());
            cs.setInt(3, cm.getIdTipoComunicacion());
            cs.setDate(4, new java.sql.Date(cm.getFechaComunicacion().getTime()));
            cs.setString(5, cm.getNotas());

            cs.execute();
            JOptionPane.showMessageDialog(null, "Comunicación actualizada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            return true;

            //Manejo de errores
        } catch (SQLException e) {
            // Mostrar el mensaje de error de la base de datos (incluye validaciones de SQL)
            String mensaje = e.getMessage();
            if (mensaje != null && mensaje.contains("ORA-200")) {
                // Es un error de validación personalizado de Oracle
                JOptionPane.showMessageDialog(null, mensaje, "Error de Validación", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar comunicación: " + mensaje, "Error", JOptionPane.ERROR_MESSAGE);
            }
            System.out.println(e.toString());
            return false;

        } finally {
            cerrarConexion();
        }
    }

    // Eliminar ComunicacionMiembro usando un stored procedure
    // El procedimiento valida que la comunicación exista y se pueda eliminar
    public boolean EliminarComunicacionMiembro(int id) {
        //Stored procedure para eliminar comunicacion miembro
        String sql = "{ call EliminarComunicacionMiembro(?) }";

        //Manejo de errores
        try {
            //Coneccion a DB
            con = cn.getConnection();
            //Para llamar el procedure
            cs = con.prepareCall(sql);

            //Lo encuentra por ID
            cs.setInt(1, id);
            cs.execute();
            JOptionPane.showMessageDialog(null, "Comunicación eliminada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            return true;

            //Catch si hay errores    
        } catch (SQLException e) {
            // Mostrar el mensaje de error de la base de datos
            String mensaje = e.getMessage();
            if (mensaje != null && mensaje.contains("ORA-200")) {
                // Es un error de validación personalizado de Oracle
                JOptionPane.showMessageDialog(null, mensaje, "Error de Validación", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar comunicación: " + mensaje, "Error", JOptionPane.ERROR_MESSAGE);
            }
            System.out.println(e.toString());
            return false;

        } finally {
            cerrarConexion();
        }
    }

    // Obtener lista de ComunicacionMiembro usando un stored procedure
    public List<ComunicacionMiembro> ListaComunicacionMiembro() {

        //Array list donde se va a guardar la lista de comunicacion
        List<ComunicacionMiembro> lista = new ArrayList<>();
        //Stored prodecure para obtener la comunicacion de miembros
        String sql = "{ call ObtenerComunicacionesMiembro(?) }";

        try {
            //Coneccion a DB
            con = cn.getConnection();
            //Para llamar el procedure
            cs = con.prepareCall(sql);

            cs.registerOutParameter(1, OracleTypes.CURSOR);   //Cursor para que pase los miembros
            cs.execute();

            rs = (ResultSet) cs.getObject(1);

            while (rs.next()) {
                ComunicacionMiembro cm = new ComunicacionMiembro();
                cm.setIdComunicacion(rs.getInt("ID_Comunicacion"));
                cm.setIdAsociado(rs.getInt("ID_Asociados"));
                cm.setIdTipoComunicacion(rs.getInt("ID_TipoComunicacion"));
                cm.setFechaComunicacion(rs.getDate("Fecha_Comunicacion"));
                cm.setNotas(rs.getString("Notas"));
                lista.add(cm);
            }
            //Manejo de errores
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            cerrarConexion();
        }

        return lista;
    }

    // Buscar ComunicacionMiembro por ID usando un stored procedure
    public ComunicacionMiembro BuscarComunicacionMiembro(int idComunicacion) {
        //Comunicacion miembro que va retornar
        ComunicacionMiembro cm = null;
        //Stored procedure para buscar la comunicacion miembro
        String sql = "{ call BuscarComunicacionMiembro(?, ?) }"; // ? es el REF CURSOR

        try {
            //Coneccion a DB
            con = cn.getConnection();
            //Para llamar el procedure
            cs = con.prepareCall(sql);

            cs.setInt(1, idComunicacion);
            cs.registerOutParameter(2, OracleTypes.CURSOR); // registrar parámetro OUT

            cs.execute();
            rs = (ResultSet) cs.getObject(2);

            if (rs.next()) {
                cm = new ComunicacionMiembro();
                cm.setIdComunicacion(rs.getInt("ID_Comunicacion"));
                cm.setIdAsociado(rs.getInt("ID_Asociados"));
                cm.setIdTipoComunicacion(rs.getInt("ID_TipoComunicacion"));
                cm.setFechaComunicacion(rs.getDate("Fecha_Comunicacion"));
                cm.setNotas(rs.getString("Notas"));
            }
        //Manejo de errores
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            cerrarConexion();
        }

        return cm;
    }

    // Método para llenar el JComboBox con tipos de comunicación
    public void LlenarComboBoxIdsTipoComunicacion(JComboBox<String> combo) {
        //Stored procedure para obtener ids tipo comunicacion
        String sql = "{ call ObtenerIdsTipoComunicacion(?) }";

        try {
            //Coneccion a DB
            con = cn.getConnection();
            //Para llamar el procedure
            cs = con.prepareCall(sql);


            cs.registerOutParameter(1, OracleTypes.CURSOR); // registrar parámetro OUT
            cs.execute();

            rs = (ResultSet) cs.getObject(1);

            combo.removeAllItems(); //Remueve los items

            while (rs.next()) {
                combo.addItem(String.valueOf(rs.getInt("ID_TipoComunicacion")));
            }
        //Manejo de errores
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            cerrarConexion();
        }
    }

    //Metodo para cerrar la conexion a la BD
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
            System.out.println("Error al cerrar conexión: " + e.getMessage());
        }
    }
}
