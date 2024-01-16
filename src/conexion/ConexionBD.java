package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:sqlite:db/TareasDB.db";

    public static Connection obtenerConexion() {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(URL);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al obtener la conexión: " + e.getMessage());
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }
}