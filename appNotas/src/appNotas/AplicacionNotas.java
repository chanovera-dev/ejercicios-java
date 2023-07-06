package appNotas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AplicacionNotas extends JFrame implements ActionListener {
	
	private JTextArea areaTexto;
	private JList<String> listaNotas;
	private DefaultListModel<String> modeloLista;
	private JButton crearNota;
	private JButton verNota;
	private JButton editarNota;
	private JButton eliminarNota;
	private ArrayList<String> archivosNotas;

	
	public AplicacionNotas() {
		// ventana
		setTitle("Notas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// área de texto
		areaTexto = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(areaTexto);
		add(scrollPane, BorderLayout.CENTER);
		
		// botones
		crearNota = new JButton("Crear nota"); 			crearNota.addActionListener(this);
		verNota = new JButton("Ver nota");				verNota.addActionListener(this);
		editarNota = new JButton("Editar nota");		editarNota.addActionListener(this);
		eliminarNota = new JButton("Eliminar nota");	eliminarNota.addActionListener(this);
		
		// panel
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(4, 1));
		panelBotones.add(crearNota);
		panelBotones.add(verNota);
		panelBotones.add(editarNota);
		panelBotones.add(eliminarNota);
		add(panelBotones, BorderLayout.EAST);
		
		// inicializar la lista de notas
		archivosNotas = new ArrayList<>();
		
		// cargar notas guardadas
		cargarNotas();
		
		// mostrar la ventana
		pack();
		setVisible(true);
	}

	private void cargarNotas() {
		File carpeta = new File("notas");
		if (!carpeta.exists()) {
			carpeta.mkdir();
		}
		
		File[] archivos = carpeta.listFiles();
		if (archivos != null) {
			for (File archivo : archivos) {
				String nombreArchivo = archivo.getName();
				archivosNotas.add(nombreArchivo);
				modeloLista.addElement(nombreArchivo);
			}
		}
	}
	
	private void crearNota() {
		String nombreArchivo = JOptionPane.showInputDialog(this, "Escribe el título de la nota");
		if (nombreArchivo != null && nombreArchivo.isEmpty()) {
			try {
				File archivoNota = new File("notas/" + nombreArchivo + ".txt");
				if (archivoNota.createNewFile()) {
					archivosNotas.add(nombreArchivo);
					modeloLista.addElement(nombreArchivo);
					JOptionPane.showMessageDialog(this, "Nota creada");
				} else {
					JOptionPane.showMessageDialog(this, "Ese nombre de nota ya existe", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void verNota() {
		String notaSeleccionada = listaNotas.getSelectedValue();
		if (notaSeleccionada != null && !notaSeleccionada.isEmpty()) {
			try {
				File archivoNota = new File("notas/" + notaSeleccionada + ".txt");
				BufferedReader lector = new BufferedReader(new FileReader(archivoNota));
				String saltoLinea;
				StringBuilder contenido = new StringBuilder();
				while ((saltoLinea = lector.readLine()) != null) {
					contenido.append(saltoLinea).append("\n");
				}
				lector.close();
				areaTexto.setText(contenido.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(this, "Seleccione una nota", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void editarNota() {
		String notaSeleccionada = listaNotas.getSelectedValue();
		if (notaSeleccionada != null && !notaSeleccionada.isEmpty()) {
			try {
				File archivoNota = new File("notas/" + notaSeleccionada + ".txt");
                BufferedWriter escribir = new BufferedWriter(new FileWriter(archivoNota));
                escribir.write(areaTexto.getText());
                escribir.close();
                JOptionPane.showMessageDialog(this, "La nota se guardó correctamente.");
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else {
			JOptionPane.showMessageDialog(this, "Selecciona una nota");
		}
	}
	
	private void eliminarNota() {
		String notaSeleccionada = listaNotas.getSelectedValue();
        if (notaSeleccionada != null && !notaSeleccionada.isEmpty()) {
            int option = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar esta nota?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                File noteFile = new File("notas/" + notaSeleccionada + ".txt");
                if (noteFile.delete()) {
                    archivosNotas.remove(notaSeleccionada);
                    modeloLista.removeElement(notaSeleccionada);
                    areaTexto.setText("");
                    JOptionPane.showMessageDialog(this, "La nota se eliminó correctamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar la nota.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una nota de la lista.", "Error", JOptionPane.ERROR_MESSAGE);
        }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == crearNota) {
            crearNota();
        } else if (e.getSource() == verNota) {
            verNota();
        } else if (e.getSource() == editarNota) {
            editarNota();
        } else if (e.getSource() == eliminarNota) {
            eliminarNota();
        }
		
	}
	
}
