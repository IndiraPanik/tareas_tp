package tareas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexion.ConexionBD;

public class GestorTareas {

    public void agregarTarea(int usuarioId, String descripcion) {
        String sql = "INSERT INTO tareas(usuario_id, descripcion, estado) VALUES (?, ?, 0)";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, usuarioId);
            pstmt.setString(2, descripcion);
            pstmt.executeUpdate();
            System.out.println("Tarea agregada correctamente");
        } catch (SQLException e) {
            System.out.println("Error al agregar tarea: " + e.getMessage());
        }
    }

    public void actualizarEstadoTarea(int idTarea, int nuevoEstado) {
        String sql = "UPDATE tareas SET estado = ? WHERE id = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, nuevoEstado);
            pstmt.setInt(2, idTarea);
            pstmt.executeUpdate();
            System.out.println("Estado de la tarea actualizado correctamente");
        } catch (SQLException e) {
            System.out.println("Error al actualizar estado de la tarea: " + e.getMessage());
        }
    }

    public void visualizarTareasPendientes(int usuarioId) {
        String sql = "SELECT * FROM tareas WHERE usuario_id = ? AND estado = 0";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, usuarioId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String descripcion = rs.getString("descripcion");
                boolean estado = rs.getInt("estado") == 1;
                String estadoTarea = estado ? "Resuelto" : "No resuelto";
                System.out.println("ID: " + id + ", Descripción: " + descripcion + ", Estado: " + estadoTarea);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener tareas pendientes: " + e.getMessage());
        }
    }
}