package com.chanovera.galeriaAutos;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
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
	        String imagen = botonSeleccionarImagen.getText();
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
	        conexionBD.insertarAuto(marca, nombre, year, tipoId, imagen, colorId, precio);

	        // Mostrar mensaje de éxito
	        JOptionPane.showMessageDialog(null, "Auto agregado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	        
	        mostrarAutos(conexionBD.getConexion(), GaleriaAutos.panelAutos);
	    }
	}
	
	public static void mostrarAutos(Connection conexion, JPanel panelAutos) {
	    try (Statement stmt = conexion.createStatement()) {
	        // Obtener todos los autos de la base de datos
	        String consulta = "SELECT nombre, marca, imagen FROM autos";
	        ResultSet rs = stmt.executeQuery(consulta);

	        // Limpiar el panel antes de agregar los paneles de auto
	        panelAutos.removeAll();

	        panelAutos.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));

	        // Crear un JPanel por cada auto y agregar las etiquetas del nombre y la marca al panel
	        while (rs.next()) {

	            // Crear un panel para el contenedor del automóvil
	            JPanel contenedorPanel = new JPanel();
	            contenedorPanel.setLayout(new GridBagLayout());
	            contenedorPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Delimitar el tamaño del contenedor

	            String nombreAuto = rs.getString("nombre");
	            String marcaAuto = rs.getString("marca");
	            String rutaImagen = rs.getString("imagen");

	            JPanel panelContenedorAuto = new JPanel(); // crea un JPanel para contener la información del auto
	            panelContenedorAuto.setLayout(new BoxLayout(panelContenedorAuto, BoxLayout.Y_AXIS)); // Establecer el BoxLayout para el panel del auto

	            JPanel panelCabeceraAuto = new JPanel(); // Crea un JPanel para contener la cabecera del auto
	            panelCabeceraAuto.setLayout(new FlowLayout(FlowLayout.LEFT)); // Establecer la alineación izquierda

	            JPanel panelContenedorImagen = new JPanel(new GridBagLayout()); // crea un panel para contener la foto del auto
	            panelContenedorImagen.setPreferredSize(new Dimension(200, 200));

	            JLabel etiquetaMarca = new JLabel(marcaAuto.toUpperCase()); // Etiqueta para mostrar la marca en mayúsculas
	            etiquetaMarca.setFont(etiquetaMarca.getFont().deriveFont(Font.BOLD)); // Establecer fuente en negrita
	            panelCabeceraAuto.add(etiquetaMarca); // Agrega la etiqueta de la marca del auto al JPanel del auto

	            JLabel etiquetaNombre = new JLabel(nombreAuto.toUpperCase()); // Etiqueta para mostrar el nombre en mayúsculas
	            etiquetaNombre.setFont(etiquetaNombre.getFont().deriveFont(Font.BOLD)); // Establecer fuente en negrita
	            panelCabeceraAuto.add(etiquetaNombre); // Agrega la etiqueta del nombre del auto al JPanel del auto

	            final JLabel verMas = new JLabel("Ver más +");
	            verMas.setForeground(Color.BLUE); // Cambiar el color del texto a azul
	            panelCabeceraAuto.add(verMas);

	            verMas.addMouseListener(new MouseAdapter() {
	                @Override
	                public void mouseClicked(MouseEvent e) {
	                    mostrarDetallesAuto(); // Método para mostrar los detalles del automóvil
	                }

	                @Override
	                public void mouseEntered(MouseEvent e) {
	                    // Cambiar el cursor a "clickeable"
	                    verMas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	                }

	                @Override
	                public void mouseExited(MouseEvent e) {
	                    // Cambiar el cursor al cursor predeterminado
	                    verMas.setCursor(Cursor.getDefaultCursor());
	                }
	            });

	            panelContenedorAuto.add(panelCabeceraAuto); // Agrega el JPanel del título al panel del auto

	            // Cargar la imagen y mostrarla en un JLabel dentro del panelContenedorImagen
	            ImageIcon imagenAuto = new ImageIcon(rutaImagen);
	            int maxWidth = 200; // Ancho máximo deseado para la imagen
	            int newHeight = imagenAuto.getIconHeight() * maxWidth / imagenAuto.getIconWidth(); // Calcular el nuevo alto manteniendo la proporción

	            // Escalar la imagen al tamaño deseado
	            Image scaledImage = imagenAuto.getImage().getScaledInstance(maxWidth, newHeight, Image.SCALE_SMOOTH);
	            ImageIcon scaledIcon = new ImageIcon(scaledImage);
	            JLabel etiquetaImagen = new JLabel(scaledIcon);

	            // Configurar restricciones para centrar la imagen en el panelContenedorImagen
	            GridBagConstraints gbcImagen = new GridBagConstraints();
	            gbcImagen.anchor = GridBagConstraints.CENTER;
	            panelContenedorImagen.add(etiquetaImagen, gbcImagen);

	            panelContenedorAuto.add(panelContenedorImagen); // Agrega el JPanel de la imagen al panel del auto

	            // Agregar el panel del automóvil al panel interno
	            GridBagConstraints gbcPanelAutos = new GridBagConstraints();
	            gbcPanelAutos.anchor = GridBagConstraints.WEST;
	            gbcPanelAutos.fill = GridBagConstraints.NONE;
	            gbcPanelAutos.weightx = 1.0;
	            gbcPanelAutos.weighty = 1.0;
	            gbcPanelAutos.gridx = 0;
	            gbcPanelAutos.gridy = 0;
	            contenedorPanel.add(panelContenedorAuto, gbcPanelAutos);

	            // Agregar el panel del contenedor al panel principal
	            panelAutos.add(contenedorPanel);
	        }

	        // Actualizar la visualización del panel
	        panelAutos.revalidate();
	        panelAutos.repaint();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error al mostrar los autos", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	public static void mostrarDetallesAuto() {
		JPanel panelEdicion = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // crea un contenedor para los botones editar y borrar
		JButton botonEditar = new JButton("Editar");
		JButton botonBorrar = new JButton("Borrar");
		panelEdicion.add(botonEditar);
		panelEdicion.add(botonBorrar);
		
		// Agregar ActionListener al botón de edición
        botonEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //editarAuto());
               
            }
        });
        
        // Agregar ActionListener al botón de borrar
        botonBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //borrarAuto(); // Llamar al método para borrar el automóvil
            }
        });
		
        // Crear el componente personalizado para el JOptionPane
        Object[] ventanaDetalles = { panelEdicion };
        
        // Crear el diálogo personalizado
        JOptionPane pane = new JOptionPane(ventanaDetalles, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[] {}, null);
        JDialog dialog = pane.createDialog(null, "Detalles del Auto");
        dialog.setVisible(true);
		
	}

}
