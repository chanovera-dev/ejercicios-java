package dia21;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.BoxLayout;

import javax.swing.UIManager;

public class Notepad extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultListModel<JCheckBox> modeloLista;
    private JList<JCheckBox> listaTareas;
    private JButton btnAgregar;
    private JButton btnBorrar;
    private JTextField txtNuevaTarea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Notepad frame = new Notepad();
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
	public Notepad() {
		// ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("Notas de Chano");

		setContentPane(contentPane);
		
		// componentes
        modeloLista = new DefaultListModel<>();
        listaTareas = new JList<>(modeloLista);
        JScrollPane scrollPane = new JScrollPane(listaTareas);
        btnAgregar = new JButton("+");
        btnBorrar = new JButton("-");
        txtNuevaTarea = new JTextField(25);
		
        // diseño
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.X_AXIS));
        panelInferior.add(txtNuevaTarea);
        panelInferior.add(btnAgregar);
        panelInferior.add(btnBorrar);

        getContentPane().add(panelInferior, BorderLayout.SOUTH);
        
        // listeners de los botones
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nuevaTareaTexto = txtNuevaTarea.getText();
                if (!nuevaTareaTexto.isEmpty()) {
                    JCheckBox nuevaTareaCheckbox = new JCheckBox(nuevaTareaTexto);
                    modeloLista.addElement(nuevaTareaCheckbox);
                    txtNuevaTarea.setText("");
                }
            }
        });
        
        btnBorrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = listaTareas.getSelectedIndex();
				if (selectedIndex != -1) {
					modeloLista.removeElementAt(selectedIndex);
					listaTareas.repaint();
				}
			}
		});
        
        // Configuración del renderizado de la lista de tareas
        listaTareas.setCellRenderer(new TareaRenderer());

        // Configuración dellistener de selección de la lista
        listaTareas.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedIndex = listaTareas.getSelectedIndex();
                    if (selectedIndex != -1) {
                        JCheckBox tareaCheckbox = modeloLista.getElementAt(selectedIndex);
                        boolean isChecked = tareaCheckbox.isSelected();
                        tareaCheckbox.setSelected(!isChecked);
                        listaTareas.repaint();
                    }
                }
            }
        });
        
        cargarNotas();
    }
    
    private void guardarNotas() {
    	
    }
    
    private void cargarNotas() {
    	
    }

    // Clase interna para renderizar las tareas en la lista
    private class TareaRenderer extends JCheckBox implements ListCellRenderer<JCheckBox> {
        private static final long serialVersionUID = 1L;

        @Override
        public Component getListCellRendererComponent(JList<? extends JCheckBox> list, JCheckBox value, int index, boolean isSelected, boolean cellHasFocus) {
            setSelected(value.isSelected());

            String labelText = value.isSelected() ? "<html><s>" + value.getText() + "</s></html>" : value.getText();
            setText(labelText);

            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }

            return this;
        }
    }
}