/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.Carrera;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author deleo
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CarreraDAO {

    // INSERT
    public void insertar(Carrera carrera) {
 String sql = "INSERT INTO carreras (car_codigo, car_nombre, car_estatus) VALUES (?, ?, ?)";

    try (Connection conn = Conexion.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, carrera.getCodigo());
        stmt.setString(2, carrera.getNombre());
        stmt.setString(3, carrera.getEstatus());

        stmt.executeUpdate();

        JOptionPane.showMessageDialog(null, "Carrera insertada correctamente");

    } catch (SQLException e) {

        // 🔥 Error 1062 = clave duplicada
        if (e.getErrorCode() == 1062) {
            JOptionPane.showMessageDialog(null,
                    "Error: El código ya existe",
                    "Dato duplicado",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Error al insertar",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    }

    // SELECT
    public List<Carrera> listar() {
        List<Carrera> lista = new ArrayList<>();
        String sql = "SELECT * FROM carreras";

        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Carrera c = new Carrera(
                        rs.getInt("car_codigo"),
                        rs.getString("car_nombre"),
                        rs.getString("car_estatus")
                );
                lista.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // UPDATE
    public void actualizar(Carrera carrera) {
        String sql = "UPDATE carreras SET car_nombre=?, car_estatus=? WHERE car_codigo=?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, carrera.getNombre());
            stmt.setString(2, carrera.getEstatus());
            stmt.setInt(3, carrera.getCodigo());

            stmt.executeUpdate();
            System.out.println("Carrera actualizada");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void eliminar(int codigo) {
        String sql = "DELETE FROM carreras WHERE car_codigo=?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, codigo);
            stmt.executeUpdate();
            System.out.println("Carrera eliminada");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    public Carrera buscar(int codigo) {

    String sql = "SELECT * FROM carreras WHERE car_codigo = ?";
    Carrera carrera = null;

    try (Connection conn = Conexion.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, codigo);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            carrera = new Carrera(
                    rs.getInt("car_codigo"),
                    rs.getString("car_nombre"),
                    rs.getString("car_estatus")
            );
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return carrera;
}

}

