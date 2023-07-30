package com.chanovera.galeriaAutos;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Operacion {
	
	static ConexionBD conexionBD;

	public static void agregarAuto() {
		conexionBD = new ConexionBD();
		
	    JPanel formularioAutoNuevo = new JPanel(new GridLayout(0, 1, 0, 0));// crea un JPanel para contener el formulario

	    // campos de entrada
	    JTextField campoMarca = new JTextField(); // crea e inicializa un JTextField para contener la marca del auto
	    formularioAutoNuevo.add(new JLabel("Marca")); // Agrega una etiqueta
	    formularioAutoNuevo.add(campoMarca);

	    JTextField campoNombre = new JTextField(); // crea e inicializa un JTextField para contener el nombre del auto
	    formularioAutoNuevo.add(new JLabel("Nombre")); // Agrega una etiqueta
	    formularioAutoNuevo.add(campoNombre); // lo agrega al panel de formulario auto nuevo

	    JTextField campoYear = new JTextField();
	    formularioAutoNuevo.add(new JLabel("Año:"));
	    formularioAutoNuevo.add(campoYear);

	    JTextField campoTipo = new JTextField();
	    formularioAutoNuevo.add(new JLabel("Tipo:"));
	    formularioAutoNuevo.add(campoTipo);

	    formularioAutoNuevo.add(new JLabel("Imagen:"));
	    final JButton botonSeleccionarImagen = new JButton("Seleccionar imagen");
	    formularioAutoNuevo.add(botonSeleccionarImagen);
	    botonSeleccionarImagen.addActionListener(new ActionListener() {
	    	@Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser escogerImagen = new JFileChooser();
                int resultado = escogerImagen.showOpenDialog(null);
                if (resultado == JFileChooser.APPROVE_OPTION) {
                    File imagenSeleccionada = escogerImagen.getSelectedFile();
                    String rutaImagen = imagenSeleccionada.getAbsolutePath();

                    // copia la imagen a la carpeta imágenes dentro del proyecto
                    String carpetaImagenes = "imagenes/";
                    File carpeta = new File(carpetaImagenes);
                    if (!carpeta.exists()) {
                        carpeta.mkdirs();
                    }

                    String nombreImagen = imagenSeleccionada.getName();
                    String rutaDestino = carpetaImagenes + nombreImagen;

                    File destino = new File(rutaDestino);

                    try {
                        Files.copy(imagenSeleccionada.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        botonSeleccionarImagen.setText(rutaDestino); // Guardar la ruta de la imagen copiada
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error al copiar la imagen", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
	    });

	    JTextField campoColor = new JTextField();
	    formularioAutoNuevo.add(new JLabel("Color:"));
	    formularioAutoNuevo.add(campoColor);

	    JTextField campoPrecio = new JTextField();
	    formularioAutoNuevo.add(new JLabel("Precio:"));
	    formularioAutoNuevo.add(campoPrecio);

	    // Mostrar el JOptionPane con el formulario personalizado
	    int option = JOptionPane.showOptionDialog(null, formularioAutoNuevo, "Agregar Automóvil", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

	    // Verificar si el usuario ha presionado el botón "Aceptar"
	    if (option == JOptionPane.OK_OPTION) {
	        // Obtener los valores ingresados en el formulario
	        String marca = campoMarca.getText();
	        String nombre = campoNombre.getText();
	        String tipo = campoTipo.getText();
	        String color = campoColor.getText();

	        // Validar campos obligatorios no vacíos
	        if (marca.isEmpty() || nombre.isEmpty() || tipo.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
	            return; // Salir del método si hay campos obligatorios vacíos
	        }

	        // Obtener los valores de año y precio (con manejo de campos vacíos)
	        int year = 0;
	        try {
	            if (!campoYear.getText().isEmpty()) {
	                year = Integer.parseInt(campoYear.getText());
	            }
	        } catch (NumberFormatException ignored) {
	            // Ignorar la excepción si ocurre al convertir el año
	        }

	        double precio = 0.0;
	        try {
	            if (!campoPrecio.getText().isEmpty()) {
	                precio = Double.parseDouble(campoPrecio.getText());
	            }
	        } catch (NumberFormatException ignored) {
	            // Ignorar la excepción si ocurre al convertir el precio
	        }

	        // Insertar el tipo y el color en sus respectivas tablas si no existen
	        Integer tipoId = conexionBD.obtenerTipoId(tipo);
	        if (tipoId == null) {
	            conexionBD.insertarTipo(tipo);
	            tipoId = conexionBD.obtenerTipoId(tipo);
	        }

	        Integer colorId = conexionBD.obtenerColorId(color);
	        if (colorId == null) {
	            conexionBD.insertarColor(color);
	            colorId = conexionBD.obtenerColorId(color);
	        }

	        // Insertar el auto en la tabla "autos"
	        conexionBD.insertarAuto(marca, nombre, year, tipoId, colorId, precio);

	        // Mostrar mensaje de éxito
	        JOptionPane.showMessageDialog(null, "Auto agregado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	    }
	}
}
