package com.chanovera.galeriaAutos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GaleriaAutos extends JFrame  implements ActionListener {
	
	private JButton botonAgregarAuto;
    private JTextField campoFiltrado;

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GaleriaAutos frame = new GaleriaAutos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GaleriaAutos() {
		
		// ventana principal
        setTitle("Catálogo de autos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cierra la aplicación desde los controles de la ventana
        setSize(960, 960); // establece el tamaño de la ventana
        setLayout(new BorderLayout()); // establece el administrador de diseño en un BorderLayout
        
     // panel de controles
        JPanel panelControles = new JPanel(); // crea e inicializa un objeto JPanel para ubicar los controles
        panelControles.setLayout(new FlowLayout(FlowLayout.RIGHT)); // alínea los objetos dentro de sí a la izquierda

        //campoFiltrado = new JTextField(); // inicializa un objeto de campo de texto
        //campoFiltrado.setPreferredSize(new Dimension(150, 25)); // establece su tamaño
        //panelControles.add(campoFiltrado); // lo agrega al panel de controles

        botonAgregarAuto = new JButton("Agregar auto"); // inicializa un objeto botón para agregar automoviles
        botonAgregarAuto.addActionListener(this); // agrega el actionListener de este objeto
        panelControles.add(botonAgregarAuto); // lo agrega al panel de controles

        add(panelControles, BorderLayout.NORTH); // ubica este panel al norte de la ventana
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonAgregarAuto) {
            agregarAuto();
        }
	}

	private void agregarAuto() {
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
        int option = JOptionPane.showOptionDialog(this, formularioAutoNuevo, "Agregar Automóvil", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
		
	}

}
