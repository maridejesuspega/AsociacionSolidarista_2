package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Conector.Conector;
import Modelo.Asociado;
import javax.swing.JComboBox;
import oracle.jdbc.OracleTypes;
import java.sql.CallableStatement;


/*
 Clase AsociadoC donde realmente se llamara a los metodos por decirlo asi de la base de datos,
y se le pasara los datos de la interfaz o que si ingrese
 */
public class AsociadoC {

    //Conectortores de la base de base de datos
    Conector cn = new Conector();
    Connection con;
    //Este es para poder llamar o enviar los stored procedures
    PreparedStatement ps;
    ResultSet rs;

    /*
    ESTE METODO SE CAMBIO POR UNO CON VALIDACIONES QUE ESTA ABAJO
     */
    // Registrar Asociado usando un stored procedure
    public boolean RegistrarAsociado(Asociado as) {
        //Manda a llamar al procedimiento Insertar Asociado y le pasa las variables que obtenga
        String sql = "{CALL InsertarAsociado(?, ?, ?, ?, ?, ?, ?)}";
        try {
            //Coneccion a la BD
            con = cn.getConnection();
            //Esto es para mandar por decirlo asi a llamar el stored procedure
            CallableStatement cs = con.prepareCall(sql);
            ps.setInt(1, as.getIdAsociado());
            ps.setInt(2, as.getCedulaAsociado());
            ps.setString(3, as.getNombreAsociado());
            ps.setString(4, as.getApellidoAsociado());
            ps.setInt(5, as.getCodigoPostal());
            ps.setString(6, as.getCorreoAsociado());
            ps.setDate(7, new java.sql.Date(as.getFechaIngreso().getTime()));
            ps.execute();
            return true;
            //Excepciones para no botar el interfaz   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    /**
     * Registrar Asociado CON VALIDACIONES Usa stored procedure que valida datos
     * con expresiones regulares antes de insertar Validaciones aplicadas: -
     * Formato de cédula (9 dígitos, primer dígito 1-7) - Formato de nombre
     * (mayúscula inicial, solo letras) - Formato de apellido (mayúscula
     * inicial, solo letras) - Formato de email (formato estándar de email)
     *
     * @param as Objeto Asociado con los datos a registrar
     * @return true si se registró correctamente, false si hubo error o
     * validación falló
     */
    public boolean RegistrarAsociadoValidado(Asociado as) {
        String sql = "{ call InsertarAsociadoValidado(?, ?, ?, ?, ?, ?, ?, ?, ?) }";

        try {
            con = cn.getConnection();
            CallableStatement cs = con.prepareCall(sql);

            // Parámetros de entrada
            // Nota: La cédula en la BD es NUMBER (int), pasar directamente
            cs.setInt(1, as.getIdAsociado());
            cs.setInt(2, as.getCedulaAsociado()); // Cédula es NUMBER en la tabla
            cs.setString(3, as.getNombreAsociado());
            cs.setString(4, as.getApellidoAsociado());
            cs.setInt(5, as.getCodigoPostal());
            cs.setString(6, as.getCorreoAsociado());
            cs.setDate(7, new java.sql.Date(as.getFechaIngreso().getTime()));

            // Parámetros de salida
            cs.registerOutParameter(8, java.sql.Types.NUMERIC); // resultado
            cs.registerOutParameter(9, java.sql.Types.VARCHAR); // mensaje

            cs.execute();

            int resultado = cs.getInt(8);
            String mensaje = cs.getString(9);

            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, mensaje, "Error de Validación", JOptionPane.ERROR_MESSAGE);
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Error al registrar asociado validado: " + e.toString());
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
    ESTE METODO ACTUALIZAR SE CAMBIO POR UNO DE VALIDACIONES ABAJO
    */
    // Actualizar Asociado usando un stored procedure
    public boolean ActualizarAsociado(Asociado as) {
        //Stored Procedure que va a llamar para actualizar asociado
        String sql = "{ call ActualizarAsociado(?, ?, ?, ?, ?, ?, ?) }";

        //Try para que no bote el proyecto
        try {
            //Coneccion a la BD
            con = cn.getConnection();
            //Esto es para mandar por decirlo asi a llamar el stored procedure
            CallableStatement cs = con.prepareCall(sql);

            cs.setInt(1, as.getIdAsociado());
            cs.setInt(2, as.getCedulaAsociado());
            cs.setString(3, as.getNombreAsociado());
            cs.setString(4, as.getApellidoAsociado());
            cs.setInt(5, as.getCodigoPostal());
            cs.setString(6, as.getCorreoAsociado());
            cs.setDate(7, new java.sql.Date(as.getFechaIngreso().getTime()));

            cs.execute();
            return true;

            // Catch de errores
        } catch (SQLException e) {
            System.out.println(e.toString());
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
    /**
     * Actualizar Asociado CON VALIDACIONES
     * Usa stored procedure que valida datos con expresiones regulares antes de actualizar
     * Validaciones aplicadas:
     * - Formato de cédula (9 dígitos, primer dígito 1-7)
     * - Formato de nombre (mayúscula inicial, solo letras)
     * - Formato de apellido (mayúscula inicial, solo letras)
     * - Formato de email (formato estándar de email)
     * 
     * @param as Objeto Asociado con los datos actualizados
     * @return true si se actualizó correctamente, false si hubo error o validación falló
     */
    public boolean ActualizarAsociadoValidado(Asociado as) {
        String sql = "{ call ActualizarAsociadoValidado(?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        
        try {
            con = cn.getConnection();
            CallableStatement cs = con.prepareCall(sql);
            
            // Parámetros de entrada
            // Nota: La cédula en la BD es NUMBER (int), pasar directamente
            cs.setInt(1, as.getIdAsociado());
            cs.setInt(2, as.getCedulaAsociado()); // Cédula es NUMBER en la tabla
            cs.setString(3, as.getNombreAsociado());
            cs.setString(4, as.getApellidoAsociado());
            cs.setInt(5, as.getCodigoPostal());
            cs.setString(6, as.getCorreoAsociado());
            cs.setDate(7, new java.sql.Date(as.getFechaIngreso().getTime()));
            
            // Parámetros de salida
            cs.registerOutParameter(8, java.sql.Types.NUMERIC); // resultado
            cs.registerOutParameter(9, java.sql.Types.VARCHAR); // mensaje
            
            cs.execute();
            
            int resultado = cs.getInt(8);
            String mensaje = cs.getString(9);
            
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, mensaje, "Error de Validación", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
        } catch (SQLException e) {
            System.out.println("Error al actualizar asociado validado: " + e.toString());
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

    
    

// Eliminar Asociado usando un stored procedure, con cursor del sistema
    public boolean EliminarAsociado(int id) {
        //Stored procedure Eliminar Asociado
        String sql = "{ call EliminarAsociado(?) }";

        try {
            //Coneccion a la bd
            con = cn.getConnection();
            //Para llamar a stored procedure
            CallableStatement cs = con.prepareCall(sql);

            cs.setInt(1, id);
            cs.execute();

            return true;

            //Manejo de error
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }

    /*
    ESTE METODO SE CAMBIO POR OTRO ABAJO CON VALIDACIONES
    */
    //Para obtener a lista de asociados
    public List<Asociado> ListaAsociados() {
        //Se crea la lista 
        List<Asociado> listaAs = new ArrayList<>();
        //Para mandar a llamar el procedure
        String sql = "{CALL ObtenerAsociados(?)}"; // ? es el REF CURSOR
        try {
            //Coneccion a la DB
            con = cn.getConnection();
            //Para llamar el procedure
            CallableStatement cs = con.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.CURSOR); // registrar parámetro OUT
            cs.execute();

            ResultSet rs = (ResultSet) cs.getObject(1); // obtener el cursor como ResultSet

            while (rs.next()) {
                Asociado as = new Asociado();
                as.setIdAsociado(rs.getInt("ID_Asociados"));
                as.setCedulaAsociado(rs.getInt("Cedula_Asociado"));
                as.setNombreAsociado(rs.getString("Nombre_Asociado"));
                as.setApellidoAsociado(rs.getString("Apellido_Asociado"));
                as.setCodigoPostal(rs.getInt("Codigo_Postal"));
                as.setCorreoAsociado(rs.getString("Correo_Asociado"));
                as.setFechaIngreso(rs.getDate("Fecha_Ingreso"));
                listaAs.add(as);
            }

            rs.close();
            cs.close();
            con.close();

            //Manejo de errores 
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return listaAs;
    }

/**
     * Obtener Asociados con Datos Inválidos
     * Encuentra asociados cuyos datos no cumplen con las validaciones de formato
     * usando expresiones regulares. Útil para limpieza de datos.
     * 
     * @return Lista de asociados con datos inválidos (cédula, nombre, apellido o email)
     */
    public List<Asociado> ObtenerAsociadosConDatosInvalidos() {
        List<Asociado> listaAs = new ArrayList<>();
        String sql = "{ call ObtenerAsociadosConDatosInvalidos(?) }";
        
        try {
            con = cn.getConnection();
            CallableStatement cs = con.prepareCall(sql);
            
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            
            ResultSet rs = (ResultSet) cs.getObject(1);
            
            while (rs.next()) {
                Asociado as = new Asociado();
                as.setIdAsociado(rs.getInt("ID_Asociados"));
                // La cédula es NUMBER en la BD, leer directamente como int
                as.setCedulaAsociado(rs.getInt("Cedula_Asociado"));
                as.setNombreAsociado(rs.getString("Nombre_Asociado"));
                as.setApellidoAsociado(rs.getString("Apellido_Asociado"));
                as.setCodigoPostal(rs.getInt("Codigo_Postal"));
                as.setCorreoAsociado(rs.getString("Correo_Asociado"));
                as.setFechaIngreso(rs.getDate("Fecha_Ingreso"));
                
                // Obtener el motivo de invalidación si está disponible
                String motivo = rs.getString("Motivo_Invalidacion");
                System.out.println("Asociado " + as.getNombreAsociado() + " - " + motivo);
                
                listaAs.add(as);
            }
            
            rs.close();
            cs.close();
            
        } catch (SQLException e) {
            System.out.println("Error al obtener asociados con datos inválidos: " + e.toString());
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        
        return listaAs;
    }
    
    
// Buscar Asociado por cédula usando un stored procedure
    public Asociado BuscarAsociado(int cedulaAsociado) {
        //Aca almanenara el asociado 
        Asociado as = null;
        //El stored procedure que llamara
        String sql = "{ call BuscarAsociado(?, ?) }";

        try {
            //Coneccion a la DB
            con = cn.getConnection();
            //Para llamar el stored procedure
            CallableStatement cs = con.prepareCall(sql);

            cs.setInt(1, cedulaAsociado);
            cs.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);  // registrar parámetro OUT

            cs.execute();

            ResultSet rs = (ResultSet) cs.getObject(2);

            if (rs.next()) {
                as = new Asociado();
                as.setIdAsociado(rs.getInt("ID_Asociados"));
                as.setCedulaAsociado(rs.getInt("Cedula_Asociado"));
                as.setNombreAsociado(rs.getString("Nombre_Asociado"));
                as.setApellidoAsociado(rs.getString("Apellido_Asociado"));
                as.setCodigoPostal(rs.getInt("Codigo_Postal"));
                as.setCorreoAsociado(rs.getString("Correo_Asociado"));
                as.setFechaIngreso(rs.getDate("Fecha_Ingreso"));
            }

            //Manejo de errores
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }

        return as;
    }

// Método para llenar varios JComboBox con los IDs de los asociados
    public void llenarComboBoxAsociados(JComboBox<String> boxIDAsociadoP,
            //JComboxes
            JComboBox<String> boxIDAsociadoTran,
            JComboBox<String> boxIDAsociadoPrestamo,
            JComboBox<String> boxIDAsociadoDividendo,
            JComboBox<String> boxIDAsocComunicacion) {

        String sql = "{ call ObtenerIDsAsociados(?) }";

        try {
            con = cn.getConnection();
            CallableStatement cs = con.prepareCall(sql);

            cs.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR); // Cursor del sistema
            cs.execute();

            ResultSet rs = (ResultSet) cs.getObject(1);

            boxIDAsociadoP.removeAllItems();
            boxIDAsociadoTran.removeAllItems();
            boxIDAsociadoPrestamo.removeAllItems();
            boxIDAsociadoDividendo.removeAllItems();
            boxIDAsocComunicacion.removeAllItems();

            while (rs.next()) {
                String idAsociado = String.valueOf(rs.getInt("ID_Asociados"));

                boxIDAsociadoP.addItem(idAsociado);
                boxIDAsociadoTran.addItem(idAsociado);
                boxIDAsociadoPrestamo.addItem(idAsociado);
                boxIDAsociadoDividendo.addItem(idAsociado);
                boxIDAsocComunicacion.addItem(idAsociado);
            }

            //Manejo de errores
        } catch (SQLException e) {
            System.out.println(e.toString());
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

}
