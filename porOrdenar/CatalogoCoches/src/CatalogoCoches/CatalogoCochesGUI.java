package CatalogoCoches;

import java.awt.BorderLayout;
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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CatalogoCochesGUI extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JButton agregarBtn;
    private JPanel panelAutos;
    private JTextField campoBusqueda;
    private List<Automovil> automoviles;

    public CatalogoCochesGUI() {
        automoviles = new ArrayList<>();
        cargarAutomoviles(); // Cargar los automóviles desde el archivo

        setTitle("Catálogo de Coches");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(960, 900);
        setLayout(new BorderLayout());

        JPanel panelControles = new JPanel();
        panelControles.setLayout(new FlowLayout(FlowLayout.RIGHT)); // Alineación a la derecha
        panelControles.setBackground(Color.WHITE);

        campoBusqueda = new JTextField();
        campoBusqueda.setPreferredSize(new Dimension(150, 25)); // Establecer el tamaño preferido del campo de texto
        panelControles.add(campoBusqueda);
        agregarBtn = new JButton("Agregar coche");
        agregarBtn.addActionListener(this);
        panelControles.add(agregarBtn);

        add(panelControles, BorderLayout.NORTH);

        panelAutos = new JPanel(new GridLayout(1, 0, 0, 15));
        getContentPane().add(panelAutos, BorderLayout.CENTER);
        panelAutos.setBackground(Color.WHITE);

        campoBusqueda.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filtrarAutomoviles();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filtrarAutomoviles();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filtrarAutomoviles();
            }
        });

        filtrarAutomoviles();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == agregarBtn) {
            agregarAutomovil();
        }
    }

    public void mostrarAutomoviles() {
        panelAutos.removeAll();

        panelAutos.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));

        for (Automovil automovil : automoviles) {
            String nombre = automovil.getNombre().toUpperCase();
            String imagen = automovil.getImagen();

            // Crear un panel para el contenedor del automóvil
            JPanel contenedorPanel = new JPanel();
            contenedorPanel.setLayout(new GridBagLayout());
            contenedorPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Delimitar el tamaño del contenedor
            contenedorPanel.setBackground(Color.WHITE);

            // Crear un panel interno para mostrar cada automóvil
            JPanel automovilPanel = new JPanel(new BorderLayout());

            // Crear una etiqueta para mostrar el nombre del automóvil
            JLabel nombreLabel = new JLabel(nombre);
            nombreLabel.setFont(nombreLabel.getFont().deriveFont(Font.BOLD)); // Establecer fuente en negritas

            automovilPanel.add(nombreLabel, BorderLayout.NORTH);
            automovilPanel.setBackground(Color.WHITE);

            // Crear una etiqueta para mostrar la imagen del automóvil
            ImageIcon imagenIcon = new ImageIcon(imagen);
            // Redimensionar la imagen a 200 de ancho y alto automático
            Image img = imagenIcon.getImage().getScaledInstance(200, -1, Image.SCALE_SMOOTH);
            imagenIcon = new ImageIcon(img);
            JLabel imagenLabel = new JLabel(imagenIcon);

            // Crear el panel contenedor de la imagen
            JPanel imagenContainer = new JPanel(new BorderLayout());
            imagenContainer.setPreferredSize(new Dimension(200, 200));
            imagenContainer.setMaximumSize(new Dimension(200, 200));
            imagenContainer.add(imagenLabel, BorderLayout.CENTER);
            imagenContainer.setBackground(Color.WHITE);

            automovilPanel.add(imagenContainer, BorderLayout.CENTER);

            // Crear el JLabel "Mostrar más"
            JLabel mostrarMasLabel = new JLabel("Mostrar más");
            mostrarMasLabel.setHorizontalAlignment(SwingConstants.LEFT); // Alineación a la izquierda

            // Agregar el ActionListener al JLabel
            mostrarMasLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    mostrarDetallesAutomovil(automovil); // Método para mostrar los detalles del automóvil
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    // Cambiar el cursor a "clickeable"
                    mostrarMasLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    // Cambiar el cursor al cursor predeterminado
                    mostrarMasLabel.setCursor(Cursor.getDefaultCursor());
                }
            });

            automovilPanel.add(mostrarMasLabel, BorderLayout.SOUTH);

            // Agregar el panel del automóvil al panel interno
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.anchor = GridBagConstraints.WEST;
            gbc.fill = GridBagConstraints.NONE;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.gridx = 0;
            gbc.gridy = 0;
            contenedorPanel.add(automovilPanel, gbc);

            // Agregar el panel del contenedor al panel principal
            panelAutos.add(contenedorPanel);
        }

        // Actualizar la interfaz gráfica
        panelAutos.revalidate();
        panelAutos.repaint();
    }

    public void mostrarDetallesAutomovil(Automovil automovil) {
        String detalles = automovil.getDetalles();

        // Crear una etiqueta para mostrar la imagen del automóvil
        ImageIcon imagenIcon = new ImageIcon(automovil.getImagen());
        JLabel imagenLabel = new JLabel(imagenIcon);

        // Crear el componente personalizado para el JOptionPane
        Object[] message = { imagenLabel, detalles };

        // Mostrar el cuadro de diálogo con el componente personalizado
        JOptionPane.showMessageDialog(this, message, "Detalles del Automóvil", JOptionPane.PLAIN_MESSAGE);
    }

    public void filtrarAutomoviles() {
        String filtro = campoBusqueda.getText().trim();

        panelAutos.removeAll();

        if (filtro.isEmpty()) {
            mostrarAutomoviles();
        } else {
            panelAutos.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));

            for (Automovil automovil : automoviles) {
                String nombre = automovil.getNombre().toUpperCase();
                String imagen = automovil.getImagen();

                if (nombre.contains(filtro.toUpperCase())) {
                    // Crear un panel para el contenedor del automóvil
                    JPanel contenedorPanel = new JPanel();
                    contenedorPanel.setLayout(new GridBagLayout());
                    contenedorPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Delimitar el tamaño del contenedor
                    contenedorPanel.setBackground(Color.WHITE);

                    // Crear un panel interno para mostrar cada automóvil
                    JPanel automovilPanel = new JPanel(new BorderLayout());

                    // Crear una etiqueta para mostrar el nombre del automóvil
                    JLabel nombreLabel = new JLabel(nombre);
                    nombreLabel.setFont(nombreLabel.getFont().deriveFont(Font.BOLD)); // Establecer fuente en negritas

                    automovilPanel.add(nombreLabel, BorderLayout.NORTH);
                    automovilPanel.setBackground(Color.WHITE);

                    // Crear una etiqueta para mostrar la imagen del automóvil
                    ImageIcon imagenIcon = new ImageIcon(imagen);
                    // Redimensionar la imagen a 200 de ancho y alto automático
                    Image img = imagenIcon.getImage().getScaledInstance(200, -1, Image.SCALE_SMOOTH);
                    imagenIcon = new ImageIcon(img);
                    JLabel imagenLabel = new JLabel(imagenIcon);

                    // Crear el panel contenedor de la imagen
                    JPanel imagenContainer = new JPanel(new BorderLayout());
                    imagenContainer.setPreferredSize(new Dimension(200, 200));
                    imagenContainer.setMaximumSize(new Dimension(200, 200));
                    imagenContainer.add(imagenLabel, BorderLayout.CENTER);
                    imagenContainer.setBackground(Color.WHITE);

                    automovilPanel.add(imagenContainer, BorderLayout.CENTER);

                    // Crear el JLabel "Mostrar más"
                    JLabel mostrarMasLabel = new JLabel("Mostrar más");
                    mostrarMasLabel.setHorizontalAlignment(SwingConstants.LEFT); // Alineación a la izquierda

                    // Agregar el ActionListener al JLabel
                    mostrarMasLabel.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            mostrarDetallesAutomovil(automovil); // Método para mostrar los detalles del automóvil
                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {
                            // Cambiar el cursor a "clickeable"
                            mostrarMasLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
                            // Cambiar el cursor al cursor predeterminado
                            mostrarMasLabel.setCursor(Cursor.getDefaultCursor());
                        }
                    });

                    automovilPanel.add(mostrarMasLabel, BorderLayout.SOUTH);

                    // Agregar el panel del automóvil al panel interno
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.anchor = GridBagConstraints.WEST;
                    gbc.fill = GridBagConstraints.NONE;
                    gbc.weightx = 1.0;
                    gbc.weighty = 1.0;
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    contenedorPanel.add(automovilPanel, gbc);

                    // Agregar el panel del contenedor al panel principal
                    panelAutos.add(contenedorPanel);
                }
            }

            // Actualizar la interfaz gráfica
            panelAutos.revalidate();
            panelAutos.repaint();
        }
    }

    public void agregarAutomovil() {
        // Crear un JPanel para el formulario
        JPanel formPanel = new JPanel(new GridLayout(0, 1, 0, 0));

        // Campo de entrada para el nombre
        JTextField nombreField = new JTextField();
        formPanel.add(new JLabel("Nombre:"));
        formPanel.add(nombreField);

        // Campo de entrada para el tipo
        JTextField tipoField = new JTextField();
        formPanel.add(new JLabel("Tipo:"));
        formPanel.add(tipoField);

        // Campo de entrada para la imagen
        JTextField imagenField = new JTextField();
        formPanel.add(new JLabel("Imagen:"));
        formPanel.add(imagenField);
        imagenField.setVisible(false); // Ocultar el JTextField imagenField

        // Botón para seleccionar la imagen
        JButton seleccionarImagenBtn = new JButton("Seleccionar imagen");
        formPanel.add(seleccionarImagenBtn);

        // Acción del botón para seleccionar la imagen
        seleccionarImagenBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int resultado = fileChooser.showOpenDialog(null);
                if (resultado == JFileChooser.APPROVE_OPTION) {
                    File archivoSeleccionado = fileChooser.getSelectedFile();
                    String rutaImagen = archivoSeleccionado.getAbsolutePath();

                    // Copiar la imagen a la carpeta "imagenes"
                    String carpetaImagenes = "imagenes/";
                    File carpeta = new File(carpetaImagenes);
                    if (!carpeta.exists()) {
                        carpeta.mkdirs(); // Crear la carpeta si no existe
                    }

                    String nombreImagen = archivoSeleccionado.getName();
                    String rutaDestino = carpetaImagenes + nombreImagen;

                    File destino = new File(rutaDestino);

                    try {
                        Files.copy(archivoSeleccionado.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        imagenField.setText(rutaDestino); // Guardar la ruta de la imagen copiada
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error al copiar la imagen", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Campo de entrada para el color
        JTextField colorField = new JTextField();
        formPanel.add(new JLabel("Color:"));
        formPanel.add(colorField);

        // Mostrar el JOptionPane con el formulario personalizado
        int option = JOptionPane.showOptionDialog(this, formPanel, "Agregar Automóvil", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

        // Verificar si se hizo clic en "OK" (Aceptar)
        if (option == JOptionPane.OK_OPTION) {
            String nombre = nombreField.getText();
            String tipo = tipoField.getText();
            String imagen = imagenField.getText();
            String color = colorField.getText();

            Automovil automovil = new Sedan(nombre, tipo, imagen, color);

            automoviles.add(automovil);

            guardarAutomoviles();
            mostrarAutomoviles();
        }
    }


    public void guardarAutomoviles() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("autos.txt"))) {
            for (Automovil automovil : automoviles) {
                writer.write(automovil.getNombre() + "," + automovil.getTipo() + "," + automovil.getImagen() + "," + automovil.getColor());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar los automóviles", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cargarAutomoviles() {
        try (BufferedReader reader = new BufferedReader(new FileReader("autos.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");
                if (datos.length == 4) {
                    String nombre = datos[0];
                    String tipo = datos[1];
                    String imagen = datos[2];
                    String color = datos[3];

                    Automovil automovil = new Sedan(nombre, tipo, imagen, color);
                    automoviles.add(automovil);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los automóviles", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CatalogoCochesGUI catalogo = new CatalogoCochesGUI();
            catalogo.setVisible(true);
        });
    }

    abstract class Automovil {
        private String nombre;
        private String tipo;
        private String imagen;
        private String color;

        public Automovil(String nombre, String tipo, String imagen, String color) {
            this.nombre = nombre;
            this.tipo = tipo;
            this.imagen = imagen;
            this.color = color;
        }

        public String getNombre() {
            return nombre;
        }

        public String getTipo() {
            return tipo;
        }

        public String getImagen() {
            return imagen;
        }

        public String getColor() {
            return color;
        }

        public abstract String getDetalles();
    }

    class Sedan extends Automovil {
        public Sedan(String nombre, String tipo, String imagen, String color) {
            super(nombre, tipo, imagen, color);
        }

        @Override
        public String getDetalles() {
            StringBuilder detalles = new StringBuilder();
            detalles.append("Nombre: ").append(getNombre()).append("\n");
            detalles.append("Tipo: ").append(getTipo()).append("\n");
            detalles.append("Color: ").append(getColor()).append("\n");
            return detalles.toString();
        }
    }

    class SUV extends Automovil {
        public SUV(String nombre, String tipo, String imagen, String color) {
            super(nombre, tipo, imagen, color);
        }

        @Override
        public String getDetalles() {
            StringBuilder detalles = new StringBuilder();
            detalles.append("Nombre: ").append(getNombre()).append("\n");
            detalles.append("Tipo: ").append(getTipo()).append("\n");
            detalles.append("Color: ").append(getColor()).append("\n");
            return detalles.toString();
        }
    }

    class Deportivo extends Automovil {
        public Deportivo(String nombre, String tipo, String imagen, String color) {
            super(nombre, tipo, imagen, color);
        }

        @Override
        public String getDetalles() {
            StringBuilder detalles = new StringBuilder();
            detalles.append("Nombre: ").append(getNombre()).append("\n");
            detalles.append("Tipo: ").append(getTipo()).append("\n");
            detalles.append("Color: ").append(getColor()).append("\n");
            return detalles.toString();
        }
    }
}
