package Conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {

    // Cambia "XE" por tu SID si es distinto
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER = "ASOEMP"; // Usuario Oracle
    private static final String PASS = "123"; // Tu contraseña
    private static final String DRIVER = "oracle.jdbc.OracleDriver";

    public static Connection getConnection() {
        Connection con = null;
        try {
            // Cargar driver de Oracle
            Class.forName(DRIVER);

            // Establecer conexión
            con = DriverManager.getConnection(URL, USER, PASS);
            if (con != null) {
                System.out.println("Conexión establecida exitosamente a Oracle 21c.");
            } else {
                System.out.println("No se pudo establecer la conexión.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Driver Oracle no encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
        return con;
    }

    public static void main(String[] args) {
    Connection con = Conector.getConnection(); // llamada única
    // aquí puedes usar 'con' para consultas
    if (con != null) {
        System.out.println("Conexión verificada correctamente.");
    }

    }
}
