package com.chanovera.galeriaAutos;

import java.sql.Connection;
import java.sql.DriverManager;
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
}
