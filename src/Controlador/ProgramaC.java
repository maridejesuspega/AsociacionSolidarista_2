package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Conector.Conector;
import Modelo.Programa;
import javax.swing.JComboBox;
import java.sql.CallableStatement;

//Clase para controlador de programa
public class ProgramaC {

    //Coneccion a la base de datos 
    Conector cn = new Conector();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    /*
    ESTE METODO SE CAMBIO POR UNO CON VALIDACIONES QUE ESTA ABAJO
    */
    
    // Registrar Programa usando un stored procedure
    public boolean RegistrarPrograma(Programa prog) {
        String sql = "{ call InsertarPrograma(?, ?, ?, ?) }";
        try {

            //Coneccion a la base de datos
            con = cn.getConnection();

            //Esto es para mandar por decirlo asi a llamar el stored procedure
            CallableStatement cs = con.prepareCall(sql);

            cs.setInt(1, prog.getIdPrograma());
            cs.setInt(2, prog.getIdcalendarizacion());
            cs.setString(3, prog.getNombrePrograma());
            cs.setString(4, prog.getDescripcionPrograma());

            cs.execute();
            return true;

            //Manejo de errores    
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;

        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
            }
        }
    }
    /**
     * Registrar Programa CON VALIDACIONES
     * Usa stored procedure que valida datos con expresiones regulares antes de insertar
     * Validaciones aplicadas:
     * - Formato de nombre del programa (mayúscula inicial, 3-50 caracteres, solo letras, espacios y acentos)
     * - Formato de descripción (10-200 caracteres, letras, números, espacios y caracteres básicos)
     * 
     * @param prog Objeto Programa con los datos a registrar
     * @return true si se registró correctamente, false si hubo error o validación falló
     */
    public boolean RegistrarProgramaValidado(Programa prog) {
        String sql = "{ call InsertarProgramaValidado(?, ?, ?, ?, ?, ?) }";
        
        try {
            con = cn.getConnection();
            CallableStatement cs = con.prepareCall(sql);
            
            // Parámetros de entrada
            cs.setInt(1, prog.getIdPrograma());
            cs.setInt(2, prog.getIdcalendarizacion());
            cs.setString(3, prog.getNombrePrograma());
            cs.setString(4, prog.getDescripcionPrograma());
            
            // Parámetros de salida
            cs.registerOutParameter(5, java.sql.Types.NUMERIC); // resultado
            cs.registerOutParameter(6, java.sql.Types.VARCHAR); // mensaje
            
            cs.execute();
            
            int resultado = cs.getInt(5);
            String mensaje = cs.getString(6);
            
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, mensaje, "Error de Validación", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
        } catch (SQLException e) {
            System.out.println("Error al registrar programa validado: " + e.toString());
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

    // Actualizar Programa usando un stored procedure
    public boolean ActualizarPrograma(Programa prog) {
        //Stored procedure que se va a llamar
        String sql = "{ call ActualizarPrograma(?, ?, ?, ?) }";
        try {
            //Coneccion a la DB
            con = cn.getConnection();
            //Esto es para mandar por decirlo asi a llamar el stored procedure
            CallableStatement cs = con.prepareCall(sql);

            cs.setInt(1, prog.getIdPrograma());
            cs.setInt(2, prog.getIdcalendarizacion());
            cs.setString(3, prog.getNombrePrograma());
            cs.setString(4, prog.getDescripcionPrograma());

            cs.execute();
            return true;

            //Manejo de errores    
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;

        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
            }
        }
    }
    
    /**
     * Actualizar Programa CON VALIDACIONES
     * Usa stored procedure que valida datos con expresiones regulares antes de actualizar
     * Validaciones aplicadas:
     * - Formato de nombre del programa (mayúscula inicial, 3-50 caracteres, solo letras, espacios y acentos)
     * - Formato de descripción (10-200 caracteres, letras, números, espacios y caracteres básicos)
     * 
     * @param prog Objeto Programa con los datos actualizados
     * @return true si se actualizó correctamente, false si hubo error o validación falló
     */
    public boolean ActualizarProgramaValidado(Programa prog) {
        String sql = "{ call ActualizarProgramaValidado(?, ?, ?, ?, ?, ?) }";
        
        try {
            con = cn.getConnection();
            CallableStatement cs = con.prepareCall(sql);
            
            // Parámetros de entrada
            cs.setInt(1, prog.getIdPrograma());
            cs.setInt(2, prog.getIdcalendarizacion());
            cs.setString(3, prog.getNombrePrograma());
            cs.setString(4, prog.getDescripcionPrograma());
            
            // Parámetros de salida
            cs.registerOutParameter(5, java.sql.Types.NUMERIC); // resultado
            cs.registerOutParameter(6, java.sql.Types.VARCHAR); // mensaje
            
            cs.execute();
            
            int resultado = cs.getInt(5);
            String mensaje = cs.getString(6);
            
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, mensaje, "Error de Validación", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
        } catch (SQLException e) {
            System.out.println("Error al actualizar programa validado: " + e.toString());
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


    // Eliminar Programa usando un stored procedure, elimina por ID
    public boolean EliminarPrograma(int id) {
        //Prodecure que se va a llamar
        String sql = "{ call EliminarPrograma(?) }";
        try {
            //Coneccion a la BD
            con = cn.getConnection();
            //Esto es para mandar por decirlo asi a llamar el stored procedure
            CallableStatement cs = con.prepareCall(sql);

            cs.setInt(1, id);
            cs.execute();
            return true;

            //Manejo de errores
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;

        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
            }
        }
    }
    
    /*
    ESTE METODO SE CAMBIO POR UNO CON VALIDACIONES QUE ESTA ABAJO
    */

    // Obtener lista de Programas usando un stored procedure, devuelve un array list para poder verlo en la interfaz
    public List<Programa> ListaProgramas() {
        //Lista que va  a devolver
        List<Programa> listaProg = new ArrayList<>();

        //Prodecure que va a llamar
        String sql = "{ call ObtenerProgramas(?) }";

        try {
            //Coneccion a la DB
            con = cn.getConnection();
            //Esto es para mandar por decirlo asi a llamar el stored procedure
            CallableStatement cs = con.prepareCall(sql);

            cs.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);  //El procedure es por cursor 
            cs.execute();

            ResultSet rs = (ResultSet) cs.getObject(1);

            while (rs.next()) {
                Programa p = new Programa();
                p.setIdPrograma(rs.getInt("ID_Programa"));
                p.setIdcalendarizacion(rs.getInt("ID_Calendarizacion"));
                p.setNombrePrograma(rs.getString("Nombre_Programa"));
                p.setDescripcionPrograma(rs.getString("Descripcion_Programa"));

                listaProg.add(p);
            }

            //Manejo de errores
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return listaProg;
    }
    
    /**
     * Obtener lista de Programas VALIDADOS usando un stored procedure
     * Solo devuelve programas que cumplan con las validaciones:
     * - Formato de nombre del programa (mayúscula inicial, 3-50 caracteres, solo letras, espacios y acentos)
     * - Formato de descripción (10-200 caracteres, letras, números, espacios y caracteres básicos)
     * 
     * @return Lista de programas que cumplen con las validaciones
     */
    public List<Programa> ListaProgramasValidados() {
        List<Programa> listaProg = new ArrayList<>();
        String sql = "{ call ObtenerProgramasValidados(?) }";
        
        try {
            con = cn.getConnection();
            if (con == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo establecer conexión con la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
                return listaProg;
            }
            CallableStatement cs = con.prepareCall(sql);
            
            cs.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            cs.execute();
            
            ResultSet rs = (ResultSet) cs.getObject(1);
            
            while (rs.next()) {
                Programa p = new Programa();
                p.setIdPrograma(rs.getInt("ID_Programa"));
                p.setIdcalendarizacion(rs.getInt("ID_Calendarizacion"));
                p.setNombrePrograma(rs.getString("Nombre_Programa"));
                p.setDescripcionPrograma(rs.getString("Descripcion_Programa"));
                listaProg.add(p);
            }
            
            rs.close();
            cs.close();
            
        } catch (SQLException e) {
            System.out.println("Error al listar programas validados: " + e.toString());
            JOptionPane.showMessageDialog(null, "Error al obtener programas validados: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        
        return listaProg;
    }

    // Buscar Programa por nombre usando un stored procedure, pero con cursor
    public Programa BuscarPrograma(String nombrePrograma) {
        //Programa que va a devolver
        Programa prog = null;

        //Stored procedureq que va a llamar
        String sql = "{ call BuscarPrograma(?, ?) }";

        try {
            //Coneccion a la BD
            con = cn.getConnection();
            //Esto es para mandar por decirlo asi a llamar el stored procedure
            CallableStatement cs = con.prepareCall(sql);

            cs.setString(1, nombrePrograma);
            cs.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR); //El procedure es por cursor 

            cs.execute();

            ResultSet rs = (ResultSet) cs.getObject(2);

            if (rs.next()) {
                prog = new Programa();
                prog.setIdPrograma(rs.getInt("ID_Programa"));
                prog.setIdcalendarizacion(rs.getInt("ID_Calendarizacion"));
                prog.setNombrePrograma(rs.getString("Nombre_Programa"));
                prog.setDescripcionPrograma(rs.getString("Descripcion_Programa"));
            }

            //Manejo de errores
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return prog;
    }

    // Método para obtener la lista de IDs de programas (ESTE NO SE UTILIZA)
    public List<Integer> obtenerListaIdProgramas() {
        List<Integer> listaIds = new ArrayList<>();
        String sql = "SELECT ID_Programa FROM FIDE_Programa_TB";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                listaIds.add(rs.getInt("ID_Programa"));
            }

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
        return listaIds;
    }

    //Metodo para llenar lox combobox de progrmas
    public void llenarComboBoxProgramas(JComboBox<String> boxIDProgramaP) {
        
        //Metodo que se va llamar
        String sql = "{ call ObtenerIDsProgramas(?) }";

        try {
            
            //Coneccion a la BD
            con = cn.getConnection();
            //Esto es para mandar por decirlo asi a llamar el stored procedure
            CallableStatement cs = con.prepareCall(sql);

            cs.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR); //Cursor del sistema
            cs.execute();

            ResultSet rs = (ResultSet) cs.getObject(1);

            boxIDProgramaP.removeAllItems(); //Metodo para borrar los items

            while (rs.next()) {
                boxIDProgramaP.addItem(rs.getString("ID_Programa"));
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
            }
        }
    }

}
