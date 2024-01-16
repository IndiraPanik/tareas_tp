package tareas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexion.ConexionBD;

public class GestorUsuarios {

    public boolean verificarCredenciales(String nombreUsuario, String contraseña) {
        String sql = "SELECT * FROM usuarios WHERE nombre_usuario = ? AND contraseña = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombreUsuario);
            pstmt.setString(2, contraseña);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Error al verificar credenciales: " + e.getMessage());
            return false;
        }
    }

    public int obtenerIdUsuario(String nombreUsuario) {
        String sql = "SELECT id FROM usuarios WHERE nombre_usuario = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombreUsuario);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            } else {
                System.out.println("No se encontró un usuario con el nombre proporcionado.");
                return -1; 
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener ID de usuario: " + e.getMessage());
            return -1;
        }
    }
    
    public void crearUsuario(String nombreUsuario, String contraseña) {
        String sql = "INSERT INTO usuarios(nombre_usuario, contraseña) VALUES (?, ?)";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombreUsuario);
            pstmt.setString(2, contraseña);
            pstmt.executeUpdate();
            System.out.println("Usuario creado correctamente");
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e.getMessage());
        }
    }
}