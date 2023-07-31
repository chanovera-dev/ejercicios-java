package com.chanovera.galeriaAutos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/GaleriaAutos";
    private static final String USER = "root";
    private static final String PASSWORD = "attend-Renata-archway";
    
    private Connection conexion;

    public ConexionBD() {
        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void crearTablas(Connection conexion) {
		try (Statement stmt = conexion.createStatement()) {
	        // Verificar si la tabla "tipo" existe
	        String consultaExisteTablaTipo = "SHOW TABLES LIKE 'tipo'";
	        if (!stmt.executeQuery(consultaExisteTablaTipo).next()) {
	            // Si la tabla "tipo" no existe, crearla con las columnas especificadas
	            String crearTablaTipo = "CREATE TABLE tipo ("
	                    + "id INT PRIMARY KEY AUTO_INCREMENT,"
	                    + "tipo VARCHAR(50)"
	                    + ")";
	            stmt.executeUpdate(crearTablaTipo);
	        }

	        // Verificar si la tabla "color" existe
	        String consultaExisteTablaColor = "SHOW TABLES LIKE 'color'";
	        if (!stmt.executeQuery(consultaExisteTablaColor).next()) {
	            // Si la tabla "color" no existe, crearla con las columnas especificadas
	            String crearTablaColor = "CREATE TABLE color ("
	                    + "id INT PRIMARY KEY AUTO_INCREMENT,"
	                    + "color VARCHAR(50)"
	                    + ")";
	            stmt.executeUpdate(crearTablaColor);
	        }
	        // Verificar si la tabla "autos" existe
	        String consultaExisteTablaAutos = "SHOW TABLES LIKE 'autos'";
	        if (!stmt.executeQuery(consultaExisteTablaAutos).next()) {
	            // Si la tabla "autos" no existe, crearla con las columnas especificadas
	            String crearTablaAutos = "CREATE TABLE autos ("
	                    + "id INT PRIMARY KEY AUTO_INCREMENT,"
	                    + "marca VARCHAR(50),"
	                    + "nombre VARCHAR(50),"
	                    + "year INT,"
	                    + "tipo INT,"
	                    + "imagen VARCHAR(100),"
	                    + "color INT,"
	                    + "precio DECIMAL(9, 2),"
	                    + "FOREIGN KEY (tipo) REFERENCES tipo(id),"
	                    + "FOREIGN KEY (color) REFERENCES color(id)"
	                    + ")";
	            stmt.executeUpdate(crearTablaAutos);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error al crear las tablas", "Error", JOptionPane.ERROR_MESSAGE);
	    }
		
	}
    
    public void insertarAuto(String marca, String nombre, int year, int tipoId, String imagen, int colorId, double precio) {
        String consulta = "INSERT INTO autos (marca, nombre, year, tipo, imagen, color, precio) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conexion.prepareStatement(consulta)) {
            pstmt.setString(1, marca);
            pstmt.setString(2, nombre);
            pstmt.setInt(3, year);
            pstmt.setInt(4, tipoId);
            pstmt.setString(5, imagen);
            pstmt.setInt(6, colorId);
            pstmt.setDouble(7, precio);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se puede insertar el auto", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void insertarTipo(String tipo) {
        String consulta = "INSERT INTO tipo (tipo) VALUES (?)";
        try (PreparedStatement pstmt = conexion.prepareStatement(consulta)) {
            pstmt.setString(1, tipo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se puede insertar el tipo", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void insertarColor(String color) {
        String consulta = "INSERT INTO color (color) VALUES (?)";
        try (PreparedStatement pstmt = conexion.prepareStatement(consulta)) {
            pstmt.setString(1, color);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se puede insertar el color", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Integer obtenerColorId(String color) {
        // Comprobar si el color existe en la tabla "color"
        String consulta = "SELECT id FROM color WHERE color = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(consulta)) {
            pstmt.setString(1, color);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // El color ya existe, devolver su ID
                    return rs.getInt("id");
                } else {
                    // El color no existe
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se puede obtener el ID del color", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public Integer obtenerTipoId(String tipo) {
        // Comprobar si el tipo existe en la tabla "tipo"
        String consulta = "SELECT id FROM tipo WHERE tipo = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(consulta)) {
            pstmt.setString(1, tipo);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // El tipo ya existe, devolver su ID
                    return rs.getInt("id");
                } else {
                    // El tipo no existe
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se puede obtener el ID del tipo", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
