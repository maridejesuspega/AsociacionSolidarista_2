package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Conector.Conector;
import Modelo.Dividendo;
import java.sql.CallableStatement;
import oracle.jdbc.OracleTypes;

//Clase Dividendo controller
public class DividendoC {

    //Coneccion a la bd
    Conector cn = new Conector();
    Connection con;
    //Este es para llamar a los stored porcedures 
    CallableStatement cs;
    ResultSet rs;

    /*
    ESTE METODO SE CAMBIO POR UNO CON VALIDACIONES QUE ESTA ABAJO
     */
    // Registrar Dividendo usando un stored procedure
    public boolean RegistrarDividendo(Dividendo d) {

        String sql = "{ call InsertarDividendo(?, ?, ?, ?, ?) }";

        try {
            con = cn.getConnection();
            cs = con.prepareCall(sql);

            cs.setInt(1, d.getIdDividendo());
            cs.setInt(2, d.getIdAsociado());
            cs.setDouble(3, d.getMonto());
            cs.setDate(4, new java.sql.Date(d.getFechaPago().getTime()));
            cs.setInt(5, d.getIdTransaccion());

            cs.execute();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar dividendo: " + e.getMessage());
            return false;
        } finally {
            cerrarConexion();
        }
    }

    // Registrar Dividendo Validado
    public boolean RegistrarDividendoValidado(Dividendo d) {

        String sql = "{ call InsertarDividendoValidado(?, ?, ?, ?, ?, ?, ?) }";

        try {
            con = cn.getConnection();
            cs = con.prepareCall(sql);

            cs.setInt(1, d.getIdDividendo());
            cs.setInt(2, d.getIdAsociado());
            cs.setDouble(3, d.getMonto());
            cs.setDate(4, new java.sql.Date(d.getFechaPago().getTime()));
            cs.setInt(5, d.getIdTransaccion());

            cs.registerOutParameter(6, java.sql.Types.NUMERIC);
            cs.registerOutParameter(7, java.sql.Types.VARCHAR);

            cs.execute();

            int resultado = cs.getInt(6);
            String mensaje = cs.getString(7);

            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        } finally {
            cerrarConexion();
        }
    }

    /*
    ESTE METODO SE CAMBIO POR UNO CON VALIDACIONES QUE ESTA ABAJO
     */
    // Actualizar Dividendo usando un stored procedure
    public boolean ActualizarDividendo(Dividendo d) {

        String sql = "{ call ActualizarDividendo(?, ?, ?, ?, ?) }";

        try {
            con = cn.getConnection();
            cs = con.prepareCall(sql);

            cs.setInt(1, d.getIdDividendo());
            cs.setInt(2, d.getIdAsociado());
            cs.setDouble(3, d.getMonto());
            cs.setDate(4, new java.sql.Date(d.getFechaPago().getTime()));
            cs.setInt(5, d.getIdTransaccion());

            cs.execute();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar dividendo: " + e.getMessage());
            return false;

        } finally {
            cerrarConexion();
        }
    }

    //Actualizar Dividendo validado
    public boolean ActualizarDividendoValidado(Dividendo d) {

        String sql = "{ call ActualizarDividendoValidado(?, ?, ?, ?, ?, ?, ?) }";

        try {
            con = cn.getConnection();
            cs = con.prepareCall(sql);

            cs.setInt(1, d.getIdDividendo());
            cs.setInt(2, d.getIdAsociado());
            cs.setDouble(3, d.getMonto());
            cs.setDate(4, new java.sql.Date(d.getFechaPago().getTime()));
            cs.setInt(5, d.getIdTransaccion());

            cs.registerOutParameter(6, java.sql.Types.NUMERIC);
            cs.registerOutParameter(7, java.sql.Types.VARCHAR);

            cs.execute();

            int resultado = cs.getInt(6);
            String mensaje = cs.getString(7);

            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        } finally {
            cerrarConexion();
        }
    }

    // Eliminar Dividendo usando un stored procedure
    public boolean EliminarDividendo(int idDividendo) {

        String sql = "{ call EliminarDividendo(?) }";

        try {
            con = cn.getConnection();
            cs = con.prepareCall(sql);

            cs.setInt(1, idDividendo);

            cs.execute();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar dividendo: " + e.getMessage());
            return false;

        } finally {
            cerrarConexion();
        }
    }

    // Obtener lista de Dividendos usando un stored procedure
    public List<Dividendo> ListaDividendos() {

        List<Dividendo> lista = new ArrayList<>();
        String sql = "{ call ObtenerDividendos(?) }";

        try {
            con = cn.getConnection();
            cs = con.prepareCall(sql);

            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();

            rs = (ResultSet) cs.getObject(1);

            while (rs.next()) {
                Dividendo d = new Dividendo();

                d.setIdDividendo(rs.getInt("ID_Dividendo"));
                d.setIdAsociado(rs.getInt("ID_Asociado"));
                d.setMonto(rs.getDouble("Monto"));
                d.setFechaPago(rs.getDate("Fecha_Pago"));
                d.setIdTransaccion(rs.getInt("ID_Transaccion"));

                lista.add(d);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener dividendos: " + e.getMessage());

        } finally {
            cerrarConexion();
        }

        return lista;
    }

    // Buscar Dividendo por ID usando un stored procedure
    public Dividendo BuscarDividendo(int idDividendo) {

        Dividendo d = new Dividendo();
        String sql = "{ call BuscarDividendo(?, ?) }";

        try {
            con = cn.getConnection();
            cs = con.prepareCall(sql);

            cs.setInt(1, idDividendo);
            cs.registerOutParameter(2, OracleTypes.CURSOR);

            cs.execute();

            rs = (ResultSet) cs.getObject(2);

            if (rs.next()) {
                d.setIdDividendo(rs.getInt("ID_Dividendo"));
                d.setIdAsociado(rs.getInt("ID_Asociado"));
                d.setMonto(rs.getDouble("Monto"));
                d.setFechaPago(rs.getDate("Fecha_Pago"));
                d.setIdTransaccion(rs.getInt("ID_Transaccion"));
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar dividendo: " + e.getMessage());

        } finally {
            cerrarConexion();
        }

        return d;
    }

    //Metodo para cerrar conexion
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
