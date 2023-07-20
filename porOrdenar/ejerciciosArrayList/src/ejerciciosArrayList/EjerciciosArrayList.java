package ejerciciosArrayList;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class EjerciciosArrayList extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
	private JLabel nombreLabel;
    private JTextField nombreField;
    private JLabel calificacionLabel;
    private JTextField calificacionField;
    private JButton registrarButton;
    private JTable alumnosTable;
    private DefaultTableModel tableModel;

    private ArrayList<String> alumnos;
    private HashMap<String, Integer> calificacion;
    private HashMap<String, String> grupo;

    public EjerciciosArrayList() {
        // Configurar la ventana principal
        setTitle("Listado de alumnos");
        setSize(510, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Inicializar componentes
        nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField(18);
        calificacionLabel = new JLabel("Calificación:");
        calificacionField = new JTextField(3);
        registrarButton = new JButton("+");
        registrarButton.addActionListener(this);

        // Crear modelo de tabla y tabla
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Calificación");
        tableModel.addColumn("Grupo");
        alumnosTable = new JTable(tableModel);
         
        // Ajustar el ancho de la columna "nombre"
        TableColumn column = alumnosTable.getColumnModel().getColumn(0);
        column.setPreferredWidth(230); // Ajusta el valor según tus necesidades

        // Agregar componentes a la ventana
        JPanel panel = new JPanel();
        panel.add(nombreLabel);
        panel.add(nombreField);
        panel.add(calificacionLabel);
        panel.add(calificacionField);
        panel.add(registrarButton);

        add(panel);
        add(new JScrollPane(alumnosTable));

        // Inicializar variables
        alumnos = new ArrayList<>();
        calificacion = new HashMap<>();
        grupo = new HashMap<>();
    }

    public static void main(String[] args) {
    	EventQueue.invokeLater(new Runnable() {
            public void run() {
                EjerciciosArrayList ventana = new EjerciciosArrayList();
                ventana.setVisible(true);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registrarButton) {
            registrarAlumno();
        }
    }

    private void registrarAlumno() {
        String nombre = nombreField.getText();
        String calificacionText = calificacionField.getText();
        int calificacionAlumno = 0;

        try {
            calificacionAlumno = Integer.parseInt(calificacionText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La calificación debe ser un número entero", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (calificacionAlumno < 0 || calificacionAlumno > 100) {
            JOptionPane.showMessageDialog(this, "La calificación debe estar entre 0 y 100", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String grupoAlumno = obtenerGrupo(calificacionAlumno);

        alumnos.add(nombre);
        calificacion.put(nombre, calificacionAlumno);
        grupo.put(nombre, grupoAlumno);

        Object[] rowData = { nombre, calificacionAlumno, grupoAlumno };
        tableModel.addRow(rowData);

        JOptionPane.showMessageDialog(this, "Alumno registrado correctamente", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);

        nombreField.setText("");
        calificacionField.setText("");
    }

    private String obtenerGrupo(int calificacion) {
        if (calificacion >= 95) {
            return "A";
        } else if (calificacion >= 80){
            return "B";
        } else {
            return "C";
        }
    }
}