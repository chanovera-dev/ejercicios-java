package listaAlumnos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class ListaAlumnos extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	// declaración de variables
	private JLabel nombreLabel;
	private JTextField nombreField;
	private JLabel edadLabel;
	private JTextField edadField;
	private JLabel calificacionLabel;
	private JTextField calificacionField;
	private JLabel grupoLabel;
	private JTextField grupoField;
	private JButton registrarButton;
	private JButton mayorButton;
	private JButton menorButton;
	private JButton sobresalienteButton;
	private JButton promedioButton;
	private DefaultTableModel tableModel;
	private JTable alumnosTable;
	private ArrayList<String> alumnos;
	private HashMap<String, Integer> edades;
    private HashMap<String, Integer> calificacion;
    private HashMap<String, String> grupo;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaAlumnos frame = new ListaAlumnos();
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
	public ListaAlumnos() {
		// configurar la ventana principal
        setTitle("Listado de alumnos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        // Establecer layout del contentPane
        contentPane.setLayout(new BorderLayout());

        // inicializar componentes
        nombreLabel = new JLabel("Nombre");
        nombreField = new JTextField(18);
        edadLabel = new JLabel("Edad: ");
        edadField = new JTextField(2);
        calificacionLabel = new JLabel("Calificación: ");
        calificacionField = new JTextField(3);
        grupoLabel = new JLabel("Grupo: ");
        grupoField = new JTextField(1);
        registrarButton = new JButton("+");
        registrarButton.addActionListener(this);
        mayorButton = new JButton("+ edad");
        mayorButton.addActionListener(this);
        menorButton = new JButton("- edad");
        menorButton.addActionListener(this);
        sobresalienteButton = new JButton("+ sobresaliente");
        sobresalienteButton.addActionListener(this);
        promedioButton = new JButton("Grupo más sobresaliente");
        promedioButton.addActionListener(this);

        // modelo de la tabla
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Edad");
        tableModel.addColumn("Calificación");
        tableModel.addColumn("Grupo");
        alumnosTable = new JTable(tableModel);

        // Ajustar el ancho de la columna "nombre"
        TableColumn column = alumnosTable.getColumnModel().getColumn(0);
        column.setPreferredWidth(230); // Ajusta el valor según tus necesidades

        // Agregar panel 1
        JPanel panel1 = new JPanel();
        panel1.add(nombreLabel);
        panel1.add(nombreField);
        panel1.add(edadLabel);
        panel1.add(edadField);
        panel1.add(calificacionLabel);
        panel1.add(calificacionField);
        panel1.add(grupoLabel);
        panel1.add(grupoField);
        panel1.add(registrarButton);
        contentPane.add(panel1, BorderLayout.NORTH);

        JPanel panel2 = new JPanel();
        contentPane.add(panel2, BorderLayout.CENTER);
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel2.add(mayorButton);
        panel2.add(menorButton);
        panel2.add(sobresalienteButton);
        panel2.add(promedioButton);

        JScrollPane scrollPane = new JScrollPane(alumnosTable);
        contentPane.add(scrollPane, BorderLayout.SOUTH);

        // Inicializar variables
        alumnos = new ArrayList<>();
        edades = new HashMap<>();
        calificacion = new HashMap<>();
        grupo = new HashMap<>();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == registrarButton) {
	        registrarAlumno();
	    } else if (e.getSource() == mayorButton) {
	        ordenarMayorMenor();
	    } else if (e.getSource() == menorButton) {
	        ordenarMenorMayor();
	    } else if (e.getSource() == sobresalienteButton) {
	        ordenarSobresaliente();
	    } else if (e.getSource() == promedioButton) {
	        ordenarPromedio();
	    }
	}

	private void ordenarPromedio() {
		Collections.sort(alumnos, new Comparator<String>() {
	        @Override
	        public int compare(String alumno1, String alumno2) {
	            String grupo1 = grupo.get(alumno1);
	            String grupo2 = grupo.get(alumno2);
	            
	            double promedioGrupo1 = calcularPromedioGrupo(grupo1);
	            double promedioGrupo2 = calcularPromedioGrupo(grupo2);
	            
	            return Double.compare(promedioGrupo2, promedioGrupo1);
	        }
	    });
	    
	    actualizarTabla();
		
	}
	
	private double calcularPromedioGrupo(String grupo) {
	    double totalCalificaciones = 0;
	    int cantidadAlumnos = 0;
	    
	    for (String alumno : alumnos) {
	        if (grupo.equals(this.grupo.get(alumno))) {
	            totalCalificaciones += calificacion.get(alumno);
	            cantidadAlumnos++;
	        }
	    }
	    
	    if (cantidadAlumnos > 0) {
	        return totalCalificaciones / cantidadAlumnos;
	    } else {
	        return 0;
	    }
	}

	private void ordenarSobresaliente() {
		Collections.sort(alumnos, new Comparator<String>() {
	        @Override
	        public int compare(String alumno1, String alumno2) {
	            int calif1 = calificacion.get(alumno1);
	            int calif2 = calificacion.get(alumno2);
	            return Integer.compare(calif2, calif1);
	        }
	    });
	    
	    actualizarTabla();
		
	}

	private void ordenarMenorMayor() {
		Collections.sort(alumnos, new Comparator<String>() {
	        @Override
	        public int compare(String alumno1, String alumno2) {
	            int edad1 = edades.get(alumno1);
	            int edad2 = edades.get(alumno2);
	            return Integer.compare(edad1, edad2);
	        }
	    });

	    actualizarTabla();
	}

	private void ordenarMayorMenor() {
		Collections.sort(alumnos, new Comparator<String>() {
	        @Override
	        public int compare(String alumno1, String alumno2) {
	            int edad1 = edades.get(alumno1);
	            int edad2 = edades.get(alumno2);
	            return Integer.compare(edad2, edad1);
	        }
	    });

	    actualizarTabla();
	}

	private void actualizarTabla() {
		tableModel.setRowCount(0); // Limpiar la tabla
	    
	    for (String alumno : alumnos) {
	        int edad = edades.get(alumno);
	        int calif = calificacion.get(alumno);
	        String grupoAlumno = grupo.get(alumno);
	        
	        Object[] rowData = { alumno, edad, calif, grupoAlumno };
	        tableModel.addRow(rowData);
	    }
		
	}

	private void registrarAlumno() {
	    String nombre = nombreField.getText();
	    String edadText = edadField.getText();
	    int edadAlumno = 0;
	    String calificacionText = calificacionField.getText();
	    int calificacionAlumno = 0;
	    String grupoAlumno = grupoField.getText();

	    try {
	        edadAlumno = Integer.parseInt(edadText); // Convertir texto a entero
	        calificacionAlumno = Integer.parseInt(calificacionText);
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "La edad y la calificación deben ser números enteros", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    if (calificacionAlumno < 0 || calificacionAlumno > 100) {
	        JOptionPane.showMessageDialog(this, "La calificación debe estar entre 0 y 100", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    alumnos.add(nombre);
	    edades.put(nombre, edadAlumno);
	    calificacion.put(nombre, calificacionAlumno);
	    grupo.put(nombre, grupoAlumno);

	    Object[] rowData = { nombre, edadAlumno, calificacionAlumno, grupoAlumno };
	    tableModel.addRow(rowData);

	    nombreField.setText("");
	    edadField.setText("");
	    calificacionField.setText("");
	    grupoField.setText("");
	}

}
