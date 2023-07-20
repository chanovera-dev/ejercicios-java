package listaTareas;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaDeTareas extends JFrame {

    private static final long serialVersionUID = 1L;
	private DefaultListModel<JCheckBox> modeloLista;
    private JList<JCheckBox> listaTareas;
    private JButton btnAgregar;
    private JTextField txtNuevaTarea;

    public ListaDeTareas() {
        // Configuración de la ventana principal
        setTitle("Lista de Tareas");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Creación de componentes
        modeloLista = new DefaultListModel<>();
        listaTareas = new JList<>(modeloLista);
        JScrollPane scrollPane = new JScrollPane(listaTareas);
        btnAgregar = new JButton("Agregar");
        txtNuevaTarea = new JTextField(20);

        // Configuración del diseño de la ventana
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new FlowLayout());
        panelInferior.add(txtNuevaTarea);
        panelInferior.add(btnAgregar);

        add(panelInferior, BorderLayout.SOUTH);

        // Configuración de los listeners de los botones
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

        // Configuración del renderizado de la lista de tareas
        listaTareas.setCellRenderer(new TareaRenderer());

        // Configuración del listener de selección de la lista
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
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ListaDeTareas listaDeTareas = new ListaDeTareas();
                listaDeTareas.setVisible(true);
            }
        });
    }

    // Clase interna para renderizar las tareas en la lista
    private class TareaRenderer extends JCheckBox implements ListCellRenderer<JCheckBox> {
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
