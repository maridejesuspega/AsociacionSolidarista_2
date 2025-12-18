package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Conector.Conector;
import Modelo.Prestamo;
import java.sql.CallableStatement;
import javax.swing.JComboBox;
import oracle.jdbc.OracleTypes;

//Clase controller de prestamo
public class PrestamoC {

    //Coneccion a la DB
    Conector cn = new Conector();
    Connection con;
    //Este es para poder llamar o enviar los stored procedures
    CallableStatement cs;
    ResultSet rs;

    /*
    ESTE METODO SE CAMBIO POR UNO CON VALIDACIONES QUE ESTA ABAJO
    */
    // Registrar Prestamo usando un stored procedure
    public boolean RegistrarPrestamo(Prestamo p) {
        String sql = "{ call InsertarPrestamo(?, ?, ?, ?, ?, ?, ?, ?) }";

        try {
            //Coneccion a la BD
            con = cn.getConnection();
            //Esto es para mandar por decirlo asi a llamar el stored procedure
            CallableStatement cs = con.prepareCall(sql);

            cs.setInt(1, p.getIdPrestamo());
            cs.setInt(2, p.getIdAsociado());
            cs.setDouble(3, p.getMonto());
            cs.setDate(4, new java.sql.Date(p.getFechaDesembolso().getTime()));
            cs.setDate(5, new java.sql.Date(p.getFechaVencimiento().getTime()));
            cs.setDouble(6, p.getTasaInteres());
            cs.setInt(7, p.getIdEstadoPrestamo());
            cs.setInt(8, p.getIdTransaccion());

            cs.execute();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;

        } finally {
            cerrarConexion();
        }
    }
    
    /**
     * Registrar Préstamo CON VALIDACIONES
     * Usa stored procedure que valida datos con expresiones regulares antes de insertar
     * Validaciones aplicadas:
     * - Formato de monto (número positivo, máximo 2 decimales)
     * - Formato de tasa de interés (0-100, máximo 2 decimales)
     * - Relación entre fechas (fecha vencimiento > fecha desembolso)
     * - ID de préstamo (número positivo entre 1 y 999999)
     * 
     * @param p Objeto Prestamo con los datos a registrar
     * @return true si se registró correctamente, false si hubo error o validación falló
     */
    public boolean RegistrarPrestamoValidado(Prestamo p) {
        String sql = "{ call InsertarPrestamoValidado(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        
        try {
            con = cn.getConnection();
            if (con == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo establecer conexión con la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            CallableStatement cs = con.prepareCall(sql);
            
            // Parámetros de entrada
            cs.setInt(1, p.getIdPrestamo());
            cs.setInt(2, p.getIdAsociado());
            cs.setDouble(3, p.getMonto());
            cs.setDate(4, new java.sql.Date(p.getFechaDesembolso().getTime()));
            cs.setDate(5, new java.sql.Date(p.getFechaVencimiento().getTime()));
            cs.setDouble(6, p.getTasaInteres());
            cs.setInt(7, p.getIdEstadoPrestamo());
            cs.setInt(8, p.getIdTransaccion());
            
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
            System.out.println("Error al registrar préstamo validado: " + e.toString());
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    /*
    ESTE METODO SE CAMBIO POR UNO CON VALIDACIONES QUE ESTA ABAJO
    */
    // Actualizar Prestamo usando un stored procedure
    public boolean ActualizarPrestamo(Prestamo p) {
        String sql = "{ call ActualizarPrestamo(?, ?, ?, ?, ?, ?, ?, ?) }";

        try {
            con = cn.getConnection();
            cs = con.prepareCall(sql);

            cs.setInt(1, p.getIdPrestamo());
            cs.setInt(2, p.getIdAsociado());
            cs.setDouble(3, p.getMonto());
            cs.setDate(4, new java.sql.Date(p.getFechaDesembolso().getTime()));
            cs.setDate(5, new java.sql.Date(p.getFechaVencimiento().getTime()));
            cs.setDouble(6, p.getTasaInteres());
            cs.setInt(7, p.getIdEstadoPrestamo());
            cs.setInt(8, p.getIdTransaccion());

            cs.execute();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;

        } finally {
            cerrarConexion();
        }
    }
    
    /**
     * Actualizar Préstamo CON VALIDACIONES
     * Usa stored procedure que valida datos con expresiones regulares antes de actualizar
     * Validaciones aplicadas:
     * - Formato de monto (número positivo, máximo 2 decimales)
     * - Formato de tasa de interés (0-100, máximo 2 decimales)
     * - Relación entre fechas (fecha vencimiento > fecha desembolso)
     * 
     * @param p Objeto Prestamo con los datos actualizados
     * @return true si se actualizó correctamente, false si hubo error o validación falló
     */
    public boolean ActualizarPrestamoValidado(Prestamo p) {
        String sql = "{ call ActualizarPrestamoValidado(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        
        try {
            con = cn.getConnection();
            if (con == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo establecer conexión con la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            CallableStatement cs = con.prepareCall(sql);
            
            // Parámetros de entrada
            cs.setInt(1, p.getIdPrestamo());
            cs.setInt(2, p.getIdAsociado());
            cs.setDouble(3, p.getMonto());
            cs.setDate(4, new java.sql.Date(p.getFechaDesembolso().getTime()));
            cs.setDate(5, new java.sql.Date(p.getFechaVencimiento().getTime()));
            cs.setDouble(6, p.getTasaInteres());
            cs.setInt(7, p.getIdEstadoPrestamo());
            cs.setInt(8, p.getIdTransaccion());
            
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
            System.out.println("Error al actualizar préstamo validado: " + e.toString());
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    /*
    ESTE METODO SE CAMBIO POR UNO CON VALIDACIONES QUE ESTA ABAJO
    */
    // Eliminar Prestamo usando un stored procedure
    public boolean EliminarPrestamo(int id) {
        String sql = "{ call EliminarPrestamo(?) }";

        try {
            con = cn.getConnection();
            cs = con.prepareCall(sql);

            cs.setInt(1, id);
            cs.execute();

            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;

        } finally {
            cerrarConexion();
        }
    }
    
    /**
     * Eliminar Préstamo CON VALIDACIONES
     * Usa stored procedure que valida que el préstamo exista antes de eliminar
     * 
     * @param id ID del préstamo a eliminar
     * @return true si se eliminó correctamente, false si hubo error o validación falló
     */
    public boolean EliminarPrestamoValidado(int id) {
        String sql = "{ call EliminarPrestamoValidado(?, ?, ?) }";
        
        try {
            con = cn.getConnection();
            if (con == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo establecer conexión con la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            CallableStatement cs = con.prepareCall(sql);
            
            // Parámetros de entrada
            cs.setInt(1, id);
            
            // Parámetros de salida
            cs.registerOutParameter(2, java.sql.Types.NUMERIC); // resultado
            cs.registerOutParameter(3, java.sql.Types.VARCHAR); // mensaje
            
            cs.execute();
            
            int resultado = cs.getInt(2);
            String mensaje = cs.getString(3);
            
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, mensaje, "Error de Validación", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
        } catch (SQLException e) {
            System.out.println("Error al eliminar préstamo validado: " + e.toString());
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    // Obtener lista de Prestamos usando un stored procedure
    public List<Prestamo> ListaPrestamos() {
        List<Prestamo> lista = new ArrayList<>();
        String sql = "{ call ObtenerPrestamos(?) }";

        try {
            con = cn.getConnection();
            cs = con.prepareCall(sql);

            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();

            rs = (ResultSet) cs.getObject(1);

            while (rs.next()) {
                Prestamo p = new Prestamo();
                p.setIdPrestamo(rs.getInt("ID_Prestamo"));
                p.setIdAsociado(rs.getInt("ID_Asociado"));
                p.setMonto(rs.getDouble("Monto"));
                p.setFechaDesembolso(rs.getDate("Fecha_Desembolso"));
                p.setFechaVencimiento(rs.getDate("Fecha_Vencimiento"));
                p.setTasaInteres(rs.getDouble("Tasa_Interes"));
                p.setIdEstadoPrestamo(rs.getInt("ID_EstadoPrestamo"));
                p.setIdTransaccion(rs.getInt("ID_Transaccion"));

                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            cerrarConexion();
        }

        return lista;
    }

    // Buscar Prestamo por ID usando un stored procedure
    public Prestamo BuscarPrestamo(int idPrestamo) {

        Prestamo p = null;
        String sql = "{ call BuscarPrestamo(?, ?) }";

        try {
            con = cn.getConnection();
            cs = con.prepareCall(sql);

            cs.setInt(1, idPrestamo);
            cs.registerOutParameter(2, OracleTypes.CURSOR);

            cs.execute();

            rs = (ResultSet) cs.getObject(2);

            if (rs.next()) {
                p = new Prestamo();

                p.setIdPrestamo(rs.getInt("ID_Prestamo"));
                p.setIdAsociado(rs.getInt("ID_Asociado"));
                p.setMonto(rs.getDouble("Monto"));
                p.setFechaDesembolso(rs.getDate("Fecha_Desembolso"));
                p.setFechaVencimiento(rs.getDate("Fecha_Vencimiento"));
                p.setTasaInteres(rs.getDouble("Tasa_Interes"));
                p.setIdEstadoPrestamo(rs.getInt("ID_EstadoPrestamo"));
                p.setIdTransaccion(rs.getInt("ID_Transaccion"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            cerrarConexion();
        }

        return p;
    }

    //Metodo para dropdown de estado prestamos
    public void llenarComboBoxEstadoPrestamo(JComboBox<String> combo) {

        String sql = "{ call ObtenerEstadoPrestamos(?) }";

        try {
            con = cn.getConnection();
            cs = con.prepareCall(sql);

            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();

            rs = (ResultSet) cs.getObject(1);

            combo.removeAllItems();

            while (rs.next()) {
                combo.addItem(String.valueOf(rs.getInt("ID_EstadoPrestamo")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            cerrarConexion();
        }
    }

    //Metodo para cerrar conexion a la BD
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
            System.out.println("ERROR cerrando conexión: " + e.getMessage());
        }
    }

}
