package appNotas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class Main extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JList<String> noteList;
    private DefaultListModel<String> listModel;
    private JButton createButton;
    private JButton viewButton;
    private JButton editButton;
    private JButton deleteButton;

    private ArrayList<String> noteFiles;

    public Main() {
        // Configurar la ventana principal
        setTitle("Notepad App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear el área de texto
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // Crear la lista de notas
        noteList = new JList<>();
        listModel = new DefaultListModel<>();
        noteList.setModel(listModel);
        JScrollPane listScrollPane = new JScrollPane(noteList);
        add(listScrollPane, BorderLayout.WEST);

        // Crear los botones
        createButton = new JButton("Crear Nota");
        createButton.addActionListener(this);

        viewButton = new JButton("Ver Nota");
        viewButton.addActionListener(this);

        editButton = new JButton("Editar Nota");
        editButton.addActionListener(this);

        deleteButton = new JButton("Eliminar Nota");
        deleteButton.addActionListener(this);

        // Crear el panel de botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1));
        buttonPanel.add(createButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.EAST);

        // Inicializar la lista de archivos de notas
        noteFiles = new ArrayList<>();

        // Cargar las notas existentes
        loadNotes();

        // Mostrar la ventana principal
        pack();
        setVisible(true);
    }

    private void loadNotes() {
        File folder = new File("notas");
        if (!folder.exists()) {
            folder.mkdir();
        }

        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                String fileName = file.getName();
                noteFiles.add(fileName);
                listModel.addElement(fileName);
            }
        }
    }

    private void createNote() {
        String fileName = JOptionPane.showInputDialog(this, "Ingrese el nombre de la nota:");
        if (fileName != null && !fileName.isEmpty()) {
            try {
                File noteFile = new File("notas/" + fileName + ".txt");
                if (noteFile.createNewFile()) {
                    noteFiles.add(fileName);
                    listModel.addElement(fileName);
                    JOptionPane.showMessageDialog(this, "La nota se creó correctamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "Ya existe una nota con ese nombre.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void viewNote() {
        String selectedNote = noteList.getSelectedValue();
        if (selectedNote != null && !selectedNote.isEmpty()) {
            try {
                File noteFile = new File("notas/" + selectedNote + ".txt");
                BufferedReader reader = new BufferedReader(new FileReader(noteFile));
                String line;
                StringBuilder content = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                reader.close();
                textArea.setText(content.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una nota de la lista.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editNote() {
        String selectedNote = noteList.getSelectedValue();
        if (selectedNote != null && !selectedNote.isEmpty()) {
            try {
                File noteFile = new File("notas/" + selectedNote + ".txt");
                BufferedWriter writer = new BufferedWriter(new FileWriter(noteFile));
                writer.write(textArea.getText());
                writer.close();
                JOptionPane.showMessageDialog(this, "La nota se guardó correctamente.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una nota de la lista.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteNote() {
        String selectedNote = noteList.getSelectedValue();
        if (selectedNote != null && !selectedNote.isEmpty()) {
            int option = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar esta nota?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                File noteFile = new File("notas/" + selectedNote + ".txt");
                if (noteFile.delete()) {
                    noteFiles.remove(selectedNote);
                    listModel.removeElement(selectedNote);
                    textArea.setText("");
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
        if (e.getSource() == createButton) {
            createNote();
        } else if (e.getSource() == viewButton) {
            viewNote();
        } else if (e.getSource() == editButton) {
            editNote();
        } else if (e.getSource() == deleteButton) {
            deleteNote();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
}
