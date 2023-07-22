package baraja;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends JFrame {
	
	JPanel panelCartas;
	JPanel panelControles;
	JLabel EtiquetaCantidadJugadores;
	JTextField cantidadJugadores;
	JButton botonRepartirCartas;

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
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
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(900,800);
		setTitle("Baraja española");
		
		panelCartas = new JPanel(new GridLayout(0,1,0,10));
		panelCartas.setLayout(new BoxLayout(panelCartas, BoxLayout.Y_AXIS));
		getContentPane().add(panelCartas, BorderLayout.CENTER);
		
		panelControles = new JPanel();
		panelControles.setLayout(new FlowLayout(FlowLayout.CENTER));
		add(panelControles, BorderLayout.SOUTH);
		
		EtiquetaCantidadJugadores = new JLabel("Jugadores: ");
		panelControles.add(EtiquetaCantidadJugadores);
		
		cantidadJugadores = new JTextField(2);
		panelControles.add(cantidadJugadores);
		
		botonRepartirCartas = new JButton("Repartir");
		botonRepartirCartas.addActionListener(new botonRepartirCartasListener());
		panelControles.add(botonRepartirCartas);
		
	}
	
	private void repartirCartas() {
	    int numJugadores = Integer.parseInt(cantidadJugadores.getText());
	    Baraja baraja = new Baraja();
	    ArrayList<ArrayList<Carta>> manosJugadores = baraja.repartirCartas(numJugadores);

	    panelCartas.removeAll();

	    for (int i = 0; i < numJugadores; i++) {
	        ArrayList<Carta> mano = manosJugadores.get(i);
	        StringBuilder manoTexto = new StringBuilder("Jugador " + (i + 1));

	        JPanel panelJugador = new JPanel();
	        panelJugador.setLayout(new BoxLayout(panelJugador, BoxLayout.X_AXIS));

	        for (Carta carta : mano) {
	            String rutaImagen = carta.getRutaImagen();
	            ImageIcon imagenCarta = new ImageIcon(rutaImagen);
	            JLabel labelCarta = new JLabel(imagenCarta);
	            panelJugador.add(labelCarta);
	        }

	        JLabel etiquetaMano = new JLabel(manoTexto.toString());
	        panelCartas.add(etiquetaMano);
	        panelCartas.add(panelJugador);
	    }

	    panelCartas.revalidate();
	    panelCartas.repaint();
	}
	
	private class botonRepartirCartasListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int numeroJugadores;
            try {
                numeroJugadores = Integer.parseInt(cantidadJugadores.getText());
                if (numeroJugadores < 1 || numeroJugadores > 6) {
                    JOptionPane.showMessageDialog(null, "El número de jugadores debe estar entre 1 y 6.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    repartirCartas();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "El número de jugadores ingresado no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
			
		}
		
	}

}
