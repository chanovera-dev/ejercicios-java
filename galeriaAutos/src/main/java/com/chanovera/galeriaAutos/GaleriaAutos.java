package com.chanovera.galeriaAutos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GaleriaAutos extends JFrame  implements ActionListener {
	
	private Connection conexion;
	ConexionBD conexionBD;
	
	private JButton botonAgregarAuto;
    //private JTextField campoFiltrado;

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ConexionBD conexionBD = new ConexionBD();
				try {	
					GaleriaAutos frame = new GaleriaAutos(conexionBD.getConexion());
					conexionBD.crearTablas(conexionBD.getConexion());
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
	public GaleriaAutos(Connection conexion) {
		this.conexion = conexion;
		
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
            Operacion.agregarAuto();
        }
	}

}
