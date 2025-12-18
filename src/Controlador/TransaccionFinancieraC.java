package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Conector.Conector;
import Modelo.TransaccionFinanciera;
import javax.swing.JComboBox;
import java.sql.CallableStatement;
import oracle.jdbc.OracleTypes;

//Clase controller para transaccion financiera
public class TransaccionFinancieraC {

    //Conector a la BD
    Conector cn = new Conector();
    Connection con;
    //Este es para poder llamar o enviar los stored procedures
    CallableStatement cs;
    ResultSet rs;

    
    /*
    ESTE METODO SE CAMBIO POR OTRO ABAJO CON VALIDACIONES
    */
    // Registrar Transaccion Financiera usando un stored procedure
    public boolean RegistrarTransaccionFinanciera(TransaccionFinanciera tf) {
        //Stored procedure para insertar transaccion financiera
        String sql = "{ call InsertarTransaccionFinanciera(?, ?, ?, ?, ?, ?, ?, ?) }";

        try {
            //Coneccion a DB
            con = cn.getConnection();
            //Para llamar el procedure
            cs = con.prepareCall(sql);

            cs.setInt(1, tf.getIdTransaccion());
            cs.setInt(2, tf.getIdAsociado());
            cs.setInt(3, tf.getTipoTransaccion());
            cs.setInt(4, tf.getIdCuentaBancaria());
            cs.setBigDecimal(5, tf.getMonto());
            cs.setDate(6, new java.sql.Date(tf.getFechaTransaccion().getTime()));
            cs.setString(7, tf.getDetalleTransaccion());
            cs.setInt(8, tf.getIdMetodoPago());

            cs.execute();
            return true;

            //Manejo de errores    
        } catch (SQLException e) {
            System.out.println("Error al registrar transacción: " + e.getMessage());
            return false;

        } finally {
            cerrarConexion();
        }
    }
    
    // MÉTODOS CON VALIDACIONES USANDO EXPRESIONES REGULARES
    /**
     * Registrar Transacción Financiera CON VALIDACIÓN
     * Usa stored procedure que valida el formato del detalle usando expresión regular
     * Validación aplicada:
     * - Formato del detalle: entre 5 y 100 caracteres
     * - Solo permite letras, números, espacios y caracteres básicos
     * 
     * @param tf Objeto TransaccionFinanciera con los datos a registrar
     * @return true si se registró correctamente, false si hubo error o validación falló
     */
    public boolean RegistrarTransaccionFinancieraValidada(TransaccionFinanciera tf) {
        String sql = "{ call InsertarTransaccionFinancieraValidada(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        
        try {
            con = cn.getConnection();
            cs = con.prepareCall(sql);
            
            // Parámetros de entrada
            cs.setInt(1, tf.getIdTransaccion());
            cs.setInt(2, tf.getIdAsociado());
            cs.setInt(3, tf.getTipoTransaccion());
            cs.setInt(4, tf.getIdCuentaBancaria());
            cs.setBigDecimal(5, tf.getMonto());
            cs.setDate(6, new java.sql.Date(tf.getFechaTransaccion().getTime()));
            cs.setString(7, tf.getDetalleTransaccion());
            cs.setInt(8, tf.getIdMetodoPago());
            
            // Parámetros de salida
            cs.registerOutParameter(9, java.sql.Types.NUMERIC); // resultado
            cs.registerOutParameter(10, java.sql.Types.VARCHAR); // mensaje
            
            cs.execute();
            
            int resultado = cs.getInt(9);
            String mensaje = cs.getString(10);
            
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, mensaje, "Error de Validación", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
        } catch (SQLException e) {
            System.out.println("Error al registrar transacción validada: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            cerrarConexion();
        }
    }

    
    /*
    ESTE METODO SE CAMBIO POR UNO ABAJO CON VALIDACIONES
    */
    // Actualizar Transaccion Financiera usando un stored procedure
    public boolean ActualizarTransaccionFinanciera(TransaccionFinanciera tf) {

        //Stored procedure que se manda a llamar par actualizar transaccion financiera
        String sql = "{ call ActualizarTransaccionFinanciera(?, ?, ?, ?, ?, ?, ?, ?) }";

        try {
            //Coneccion a DB
            con = cn.getConnection();
            //Para llamar el procedure
            cs = con.prepareCall(sql);

            cs.setInt(1, tf.getIdTransaccion());
            cs.setInt(2, tf.getIdAsociado());
            cs.setInt(3, tf.getTipoTransaccion());
            cs.setInt(4, tf.getIdCuentaBancaria());
            cs.setBigDecimal(5, tf.getMonto());
            cs.setDate(6, new java.sql.Date(tf.getFechaTransaccion().getTime()));
            cs.setString(7, tf.getDetalleTransaccion());
            cs.setInt(8, tf.getIdMetodoPago());

            cs.execute();
            return true;

            //Manejo de errores
        } catch (SQLException e) {
            System.out.println("Error al actualizar transacción: " + e.getMessage());
            return false;

        } finally {
            cerrarConexion();
        }
    }

       /**
     * Actualizar Transacción Financiera CON VALIDACIÓN
     * Usa stored procedure que valida el formato del detalle usando expresión regular
     * Validación aplicada:
     * - Formato del detalle: entre 5 y 100 caracteres
     * - Solo permite letras, números, espacios y caracteres básicos
     * 
     * @param tf Objeto TransaccionFinanciera con los datos actualizados
     * @return true si se actualizó correctamente, false si hubo error o validación falló
     */
    public boolean ActualizarTransaccionFinancieraValidada(TransaccionFinanciera tf) {
        String sql = "{ call ActualizarTransaccionFinancieraValidada(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        
        try {
            con = cn.getConnection();
            cs = con.prepareCall(sql);
            
            // Parámetros de entrada
            cs.setInt(1, tf.getIdTransaccion());
            cs.setInt(2, tf.getIdAsociado());
            cs.setInt(3, tf.getTipoTransaccion());
            cs.setInt(4, tf.getIdCuentaBancaria());
            cs.setBigDecimal(5, tf.getMonto());
            cs.setDate(6, new java.sql.Date(tf.getFechaTransaccion().getTime()));
            cs.setString(7, tf.getDetalleTransaccion());
            cs.setInt(8, tf.getIdMetodoPago());
            
            // Parámetros de salida
            cs.registerOutParameter(9, java.sql.Types.NUMERIC); // resultado
            cs.registerOutParameter(10, java.sql.Types.VARCHAR); // mensaje
            
            cs.execute();
            
            int resultado = cs.getInt(9);
            String mensaje = cs.getString(10);
            
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, mensaje, "Error de Validación", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
        } catch (SQLException e) {
            System.out.println("Error al actualizar transacción validada: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            cerrarConexion();
        }
    }
    
    // Eliminar Transaccion Financiera usando un stored procedure
    public boolean EliminarTransaccionFinanciera(int idTrans) {

        //Stored procedure que se manda a llamr para eliminar transaccion financiera
        String sql = "{ call EliminarTransaccionFinanciera(?) }";

        try {
            //Coneccion a DB
            con = cn.getConnection();
            //Para llamar el procedure
            cs = con.prepareCall(sql);

            cs.setInt(1, idTrans);
            cs.execute();

            return true;

            //Manejo de errores    
        } catch (SQLException e) {
            System.out.println("Error al eliminar transacción: " + e.getMessage());
            return false;

        } finally {
            cerrarConexion();
        }
    }

    // Obtener lista de Transacciones Financieras usando un stored procedure
    public List<TransaccionFinanciera> ListaTransaccionesFinancieras() {
        //Array list donde se guarda la lista de transacciones financieras
        List<TransaccionFinanciera> lista = new ArrayList<>();

        //Metodo que se llamara para obtener transaccion financiera con el cursor
        String sql = "{ call ObtenerTransaccionesFinancieras(?) }";

        try {
            //Coneccion a DB
            con = cn.getConnection();
            //Para llamar el procedure
            cs = con.prepareCall(sql);

            cs.registerOutParameter(1, OracleTypes.CURSOR); // registrar parámetro OUT
            cs.execute();

            rs = (ResultSet) cs.getObject(1);

            //Este es para recorrer
            while (rs.next()) {
                TransaccionFinanciera tf = new TransaccionFinanciera();

                tf.setIdTransaccion(rs.getInt("ID_Transaccion"));
                tf.setIdAsociado(rs.getInt("ID_Asociados"));
                tf.setTipoTransaccion(rs.getInt("Tipo_Transaccion"));
                tf.setIdCuentaBancaria(rs.getInt("ID_CuentaBancaria"));
                tf.setMonto(rs.getBigDecimal("Monto"));
                tf.setFechaTransaccion(rs.getDate("Fecha_Transaccion"));
                tf.setDetalleTransaccion(rs.getString("Detalle_Transaccion"));
                tf.setIdMetodoPago(rs.getInt("ID_MetodoPago"));

                lista.add(tf);
            }
            //Manejo de errores
        } catch (SQLException e) {
            System.out.println("Error al listar transacciones: " + e.getMessage());

        } finally {
            cerrarConexion();
        }

        return lista;
    }

    // Buscar Transaccion Financiera por ID usando un stored procedure
    public TransaccionFinanciera BuscarTransaccionFinanciera(int id) {
        //Transaccion financiera que se va a retornar
        TransaccionFinanciera tf = null;

        //Stored procedure para buscar la transaccion por ID
        String sql = "{ call BuscarTransaccionFinanciera(?, ?) }";

        try {
            //Coneccion a DB
            con = cn.getConnection();
            //Para llamar el procedure
            cs = con.prepareCall(sql);

            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR); // registrar parámetro OUT

            cs.execute();

            rs = (ResultSet) cs.getObject(2);

            if (rs.next()) {
                tf = new TransaccionFinanciera();

                tf.setIdTransaccion(rs.getInt("ID_Transaccion"));
                tf.setIdAsociado(rs.getInt("ID_Asociados"));
                tf.setTipoTransaccion(rs.getInt("Tipo_Transaccion"));
                tf.setIdCuentaBancaria(rs.getInt("ID_CuentaBancaria"));
                tf.setMonto(rs.getBigDecimal("Monto"));
                tf.setFechaTransaccion(rs.getDate("Fecha_Transaccion"));
                tf.setDetalleTransaccion(rs.getString("Detalle_Transaccion"));
                tf.setIdMetodoPago(rs.getInt("ID_MetodoPago"));
            }

            //Manejo de errores
        } catch (SQLException e) {
            System.out.println("Error al buscar transacción: " + e.getMessage());

        } finally {
            cerrarConexion();
        }

        return tf;
    }

    // Método para llenar varios JComboBox Tipo Transaccion
    public void llenarComboBoxTipoTransaccion(JComboBox<String> combo) {

        String sql = "{ call ObtenerIdsTipoTransaccion(?) }";

        try {
            //Coneccion a DB
            con = cn.getConnection();
            //Para llamar el procedure
            cs = con.prepareCall(sql);

            cs.registerOutParameter(1, OracleTypes.CURSOR);// registrar parámetro OUT
            cs.execute();

            rs = (ResultSet) cs.getObject(1);

            combo.removeAllItems();

            while (rs.next()) {
                combo.addItem(String.valueOf(rs.getInt("Tipo_Transaccion")));
            }

        } catch (SQLException e) {
            System.out.println("Error al llenar combo tipo transacción: " + e.getMessage());

        } finally {
            cerrarConexion();
        }
    }

    //Para llenar el array de cuentas bancarias ID para poder verlas en el box
    public void llenarComboBoxCuentasBancarias(JComboBox<String> combo) {

        String sql = "{ call ObtenerIdsCuentasBancarias(?) }";

        try {
            //Coneccion a DB
            con = cn.getConnection();
            //Para llamar el procedure
            cs = con.prepareCall(sql);

            cs.registerOutParameter(1, OracleTypes.CURSOR); // registrar parámetro OUT
            cs.execute();

            rs = (ResultSet) cs.getObject(1);

            combo.removeAllItems();  //Metodo para eliminar todos los items

            while (rs.next()) {
                combo.addItem(String.valueOf(rs.getInt("ID_CuentaBancaria")));
            }

            //Manejo de errores
        } catch (SQLException e) {
            System.out.println("Error al llenar combo cuentas bancarias: " + e.getMessage());

        } finally {
            cerrarConexion();
        }
    }

// Método para llenar JComboBox con IDs de Métodos de Pago
    public void llenarComboBoxMetodoPago(JComboBox<String> combo) {

        String sql = "{ call ObtenerIdsMetodoPago(?) }";

        try {
            con = cn.getConnection();
            cs = con.prepareCall(sql);

            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();

            rs = (ResultSet) cs.getObject(1);

            combo.removeAllItems();

            while (rs.next()) {
                combo.addItem(String.valueOf(rs.getInt("ID_MetodoPago")));
            }

        } catch (SQLException e) {
            System.out.println("Error al llenar combo método de pago: " + e.getMessage());

        } finally {
            cerrarConexion();
        }
    }

// Método para llenar JComboBox con IDs de Transacciones
public void llenarComboBoxTransacciones(JComboBox<String> combo) {

    String sql = "{ call ObtenerTodosIDsTransacciones(?) }";

    try {
        con = cn.getConnection();
        cs = con.prepareCall(sql);

        cs.registerOutParameter(1, OracleTypes.CURSOR);
        cs.execute();

        rs = (ResultSet) cs.getObject(1);

        combo.removeAllItems();

        while (rs.next()) {
            combo.addItem(String.valueOf(rs.getInt("ID_Transaccion")));
        }

    } catch (SQLException e) {
        System.out.println("Error al llenar combo transacciones: " + e.getMessage());

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
