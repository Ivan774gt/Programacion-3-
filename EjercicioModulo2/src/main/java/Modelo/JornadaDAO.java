/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.Jornadas;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class JornadaDAO {

    // INSERT
    public void insertar(Jornadas jornada) {

    String sql = "INSERT INTO jornadas (JorCodigo, JorNombre) VALUES (?, ?)";

    try (Connection conn = Conexion.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, jornada.getCodigo());
        stmt.setString(2, jornada.getNombre());

        stmt.executeUpdate();

        JOptionPane.showMessageDialog(null, "Jornada insertada correctamente");

    } catch (SQLException e) {

        if (e.getErrorCode() == 1062) {
            JOptionPane.showMessageDialog(null, "Error: Código duplicado");
        } else {
            e.printStackTrace();
        }
    }  
}


    // SELECT
    public List<Jornadas> listar() {

        List<Jornadas> lista = new ArrayList<>();
        String sql = "SELECT * FROM jornadas";

        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                Jornadas j = new Jornadas(
                        rs.getInt("JorCodigo"),
                        rs.getString("JorNombre")
                );

                lista.add(j);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // UPDATE
    public void actualizar(Jornadas jornada) {

        String sql = "UPDATE jornadas SET JorNombre=? WHERE JorCodigo=?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, jornada.getNombre());
            stmt.setInt(2, jornada.getCodigo());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Jornada actualizada");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void eliminar(int codigo) {

        String sql = "DELETE FROM jornadas WHERE JorCodigo=?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, codigo);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Jornada eliminada");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // BUSCAR
    public Jornadas buscar(int codigo) {

        String sql = "SELECT * FROM jornadas WHERE JorCodigo=?";
        Jornadas jornada = null;

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, codigo);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                jornada = new Jornadas(
                        rs.getInt("JorCodigo"),
                        rs.getString("JorNombre")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return jornada;
    }

}

