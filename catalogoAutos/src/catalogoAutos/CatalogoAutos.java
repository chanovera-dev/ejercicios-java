package catalogoAutos;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
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
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CatalogoAutos extends JFrame implements ActionListener {

    private JButton botonAgregarAuto;
    private JTextField campoFiltrado;
    private JPanel panelAutos;
    private List<Auto> autos;

    private static final long serialVersionUID = 1L;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CatalogoAutos frame = new CatalogoAutos();
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
    public CatalogoAutos() {
        autos = new ArrayList<>();
        cargarAutos(); // Cargar los automóviles desde el archivo

        // ventana principal
        setTitle("Catálogo de autos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cierra la aplicación desde los controles de la ventana
        setSize(960, 960); // establece el tamaño de la ventana
        setLayout(new BorderLayout()); // establece el administrador de diseño en un BorderLayout

        // panel de controles
        JPanel panelControles = new JPanel(); // crea e inicializa un objeto JPanel para ubicar los controles
        panelControles.setLayout(new FlowLayout(FlowLayout.RIGHT)); // alínea los objetos dentro de sí a la izquierda

        campoFiltrado = new JTextField(); // inicializa un objeto de campo de texto
        campoFiltrado.setPreferredSize(new Dimension(150, 25)); // establece su tamaño
        panelControles.add(campoFiltrado); // lo agrega al panel de controles

        botonAgregarAuto = new JButton("Agregar auto"); // inicializa un objeto botón para agregar automoviles
        botonAgregarAuto.addActionListener(this); // agrega el actionListener de este objeto
        panelControles.add(botonAgregarAuto); // lo agrega al panel de controles

        add(panelControles, BorderLayout.NORTH); // ubica este panel al norte de la ventana

        // panel de autos
        panelAutos = new JPanel(new GridLayout(1, 0, 0, 15)); // inicializa un objeto JPanel para ubicar los autos a mostrar
        getContentPane().add(panelAutos, BorderLayout.CENTER); // lo establece al centro de todo para que ocupe todo el espacio disponible

        // establece el comportamiento del campoFiltrado ante diferentes eventos
        campoFiltrado.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
            	filtrarAuto();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            	filtrarAuto();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            	filtrarAuto();
            }
        });

        filtrarAuto();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonAgregarAuto) {
            agregarAuto();
        }
    }

    public void agregarAuto() {
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
        JButton botonSeleccionarImagen = new JButton("Seleccionar imagen");
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

        // verificar si se guardó
        if (option == JOptionPane.OK_OPTION) {
            String marca = campoMarca.getText();
            String nombre = campoNombre.getText();
            String year = campoYear.getText();
            String tipo = campoTipo.getText();
            String imagen = botonSeleccionarImagen.getText();
            String color = campoColor.getText();
            String precio = campoPrecio.getText();

            Auto auto = new Sedan(marca, nombre, year, tipo, imagen, color, precio);

            autos.add(auto);

            guardarAutos();
            filtrarAuto(); // Filtrar los autos según la marca y el tipo
            mostrarAutos();
        }
    }


    public void mostrarAutos() {
        panelAutos.removeAll();

        panelAutos.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));

        for (Auto auto : autos) {
            String nombre = auto.getNombre().toUpperCase();
            String imagen = auto.getImagen();

            // Crear un panel para el contenedor del automóvil
            JPanel contenedorPanel = new JPanel();
            contenedorPanel.setLayout(new GridBagLayout());
            contenedorPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Delimitar el tamaño del contenedor

            // Crear un panel interno para mostrar cada automóvil
            JPanel automovilPanel = new JPanel(new BorderLayout());

            // Crear una etiqueta para mostrar el nombre del automóvil
            JLabel nombreLabel = new JLabel(nombre);
            nombreLabel.setFont(nombreLabel.getFont().deriveFont(Font.BOLD)); // Establecer fuente en negritas

            automovilPanel.add(nombreLabel, BorderLayout.NORTH);

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

            automovilPanel.add(imagenContainer, BorderLayout.CENTER);

            // Crear el JLabel "Mostrar más"
            JLabel mostrarMasLabel = new JLabel("Mostrar más");
            mostrarMasLabel.setHorizontalAlignment(SwingConstants.LEFT); // Alineación a la izquierda

            // Agregar el ActionListener al JLabel
            mostrarMasLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    mostrarDetallesAuto(auto); // Método para mostrar los detalles del automóvil
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

    public void mostrarDetallesAuto(Auto auto) {
        // obtiene el precio y lo convierte a formato moneda
        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance();
        String precioFormateado = formatoMoneda.format(Double.parseDouble(auto.getPrecio()));
        String detalles = auto.getDetalles() + "Precio: " + precioFormateado + "\n";
        
        // Crear el panel contenedor para el botón de edición
        JPanel panelBotonEditar = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        // Crear el botón de edición
        JButton botonEditar = new JButton("Editar");
         panelBotonEditar.add(botonEditar);

        // Crear una etiqueta para mostrar la imagen del automóvil
        ImageIcon imagenIcon = new ImageIcon(auto.getImagen());
        Image imagenOriginal = imagenIcon.getImage();
        int newWidth = Math.min(imagenOriginal.getWidth(null), 700);
        int newHeight = (int) ((double) newWidth / imagenOriginal.getWidth(null) * imagenOriginal.getHeight(null));
        Image imagenRedimensionada = imagenOriginal.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        imagenIcon = new ImageIcon(imagenRedimensionada);
        JLabel imagenLabel = new JLabel(imagenIcon);

        // Agregar ActionListener al botón de edición
        botonEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarAuto(auto);
               
            }
        });

        // Crear el componente personalizado para el JOptionPane
        Object[] message = { panelBotonEditar, imagenLabel, detalles };

        // Crear el diálogo personalizado
        JOptionPane pane = new JOptionPane(message, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[] {}, null);
        JDialog dialog = pane.createDialog(this, "Detalles del Auto");
        dialog.setVisible(true);
    }

    public void editarAuto(Auto auto) {
        // Crear el formulario de edición
        JPanel formularioEdicion = new JPanel(new GridLayout(0, 1, 0, 0));

        // Campos de entrada para la edición
        JTextField campoMarca = new JTextField(auto.getMarca());
        formularioEdicion.add(new JLabel("Marca"));
        formularioEdicion.add(campoMarca);

        JTextField campoNombre = new JTextField(auto.getNombre());
        formularioEdicion.add(new JLabel("Nombre"));
        formularioEdicion.add(campoNombre);

        JTextField campoYear = new JTextField(auto.getYear());
        formularioEdicion.add(new JLabel("Año"));
        formularioEdicion.add(campoYear);

        JTextField campoTipo = new JTextField(auto.getTipo());
        formularioEdicion.add(new JLabel("Tipo"));
        formularioEdicion.add(campoTipo);

        formularioEdicion.add(new JLabel("Imagen:"));
        JButton botonSeleccionarImagen = new JButton("Seleccionar imagen");
        formularioEdicion.add(botonSeleccionarImagen);
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
                        String rutaImagenTemp = rutaDestino; // Guardar la ruta de la imagen copiada
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error al copiar la imagen", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        JTextField campoColor = new JTextField(auto.getColor());
        formularioEdicion.add(new JLabel("Color"));
        formularioEdicion.add(campoColor);

        JTextField campoPrecio = new JTextField(auto.getPrecio());
        formularioEdicion.add(new JLabel("Precio"));
        formularioEdicion.add(campoPrecio);

        // Almacenar la ruta de la imagen actual
        String rutaImagenOriginal = auto.getImagen();
        String rutaImagenTemp = rutaImagenOriginal;

        // Mostrar el JOptionPane con el formulario de edición
        int option = JOptionPane.showOptionDialog(
                this,
                formularioEdicion,
                "Editar Automóvil",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                null
        );

        // Verificar si se guardaron los cambios
        if (option == JOptionPane.OK_OPTION) {
            // Obtener los valores editados
            String marca = campoMarca.getText();
            String nombre = campoNombre.getText();
            String year = campoYear.getText();
            String tipo = campoTipo.getText();
            String imagen = rutaImagenTemp;
            String color = campoColor.getText();
            String precio = campoPrecio.getText();

            // Actualizar los valores del automóvil
            auto.setMarca(marca);
            auto.setNombre(nombre);
            auto.setYear(year);
            auto.setTipo(tipo);
            auto.setImagen(imagen);
            auto.setColor(color);
            auto.setPrecio(precio);

            botonSeleccionarImagen.setText(imagen); // Actualizar el texto del botón con la nueva ruta de la imagen

            // Guardar los cambios en el archivo
            guardarAutos();
            mostrarAutos();
        } else {
            botonSeleccionarImagen.setText(rutaImagenOriginal); // Restaurar la ruta de la imagen original si se cancela la edición
        }
    }

    public void guardarAutos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("autos.txt"))) {
            for (Auto auto : autos) {
                writer.write(auto.getMarca() + "," + auto.getNombre() + "," + auto.getYear() + "," + auto.getTipo() + "," + auto.getImagen() + "," + auto.getColor() + "," + auto.getPrecio());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar los automóviles", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cargarAutos() {
        try (BufferedReader lector = new BufferedReader(new FileReader("autos.txt"))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 7) {
                    String marca = datos[0];
                    String nombre = datos[1];
                    String year = datos[2];
                    String tipo = datos[3];
                    String imagen = datos[4];
                    String color = datos[5];
                    String precio = datos[6];

                    Auto auto = new Sedan(marca, nombre, year, tipo, imagen, color, precio);
                    autos.add(auto);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los automóviles", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void filtrarAuto() {
    	String filtro = campoFiltrado.getText().trim();
    	String filtroMarca = filtro.trim().toUpperCase();
        String filtroTipo = filtro.trim().toUpperCase();
        String filtroColor = filtro.trim().toUpperCase();

        panelAutos.removeAll();

        if (filtro.isEmpty()) {
            mostrarAutos();
        } else {
            panelAutos.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));

            for (Auto auto : autos) {
            	
            	String nombre = auto.getNombre().toUpperCase();
            	String marcaAuto = auto.getMarca().toUpperCase();
            	String tipoAuto = auto.getTipo().toUpperCase();
            	String colorAuto = auto.getColor().toUpperCase();
            	
                if (nombre.contains(filtro) || marcaAuto.contains(filtroMarca) || tipoAuto.contains(filtroTipo) || colorAuto.contains(filtroColor)) {
                    String imagen = auto.getImagen();

                    // Crear un panel para el contenedor del automóvil
                    JPanel contenedorPanel = new JPanel();
                    contenedorPanel.setLayout(new GridBagLayout());
                    contenedorPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Delimitar el tamaño del contenedor

                    // Crear un panel interno para mostrar cada automóvil
                    JPanel automovilPanel = new JPanel(new BorderLayout());

                    // Crear una etiqueta para mostrar el nombre del automóvil
                    JLabel nombreLabel = new JLabel(nombre);
                    nombreLabel.setFont(nombreLabel.getFont().deriveFont(Font.BOLD)); // Establecer fuente en negritas

                    automovilPanel.add(nombreLabel, BorderLayout.NORTH);

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

                    automovilPanel.add(imagenContainer, BorderLayout.CENTER);

                    // Crear el JLabel "Mostrar más"
                    JLabel mostrarMasLabel = new JLabel("Mostrar más");
                    mostrarMasLabel.setHorizontalAlignment(SwingConstants.LEFT); // Alineación a la izquierda

                    // Agregar el ActionListener al JLabel
                    mostrarMasLabel.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            mostrarDetallesAuto(auto); // Método para mostrar los detalles del automóvil
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


	
	abstract class Auto {

		private String marca;
		private String nombre;
		private String year;
		private String tipo;
		private String imagen;
		private String color;
		private String precio;

		public Auto(String marca, String nombre, String year, String tipo, String imagen, String color, String precio) {
			this.marca = marca;
			this.nombre = nombre;
			this.year = year;
			this.tipo = tipo;
			this.imagen = imagen;
			this.color = color;
			this.precio = precio;
		}
		
		public void setMarca(String marca) {
			this.marca = marca;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public void setYear(String year) {
			this.year = year;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		public void setImagen(String imagen) {
			this.imagen = imagen;
		}

		public void setColor(String color) {
			this.color = color;
		}
		public void setPrecio(String precio) {
			this.precio = precio;
		}
		
		public String getMarca() {
			return marca;
		}
		public String getNombre() {
			return nombre;
		}
		public String getYear() {
			return year;
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
		public String getPrecio() {
			return precio;
		}
		
		public abstract String getDetalles();
		
		
	}
	
	class Sedan extends Auto {
		
		public Sedan(String marca, String nombre, String year, String tipo, String imagen, String color, String precio) {
			super(marca, nombre, year, tipo, imagen, color, precio);
		}

		@Override
		public String getDetalles() {
			StringBuilder detalles = new StringBuilder();
			detalles.append("Marca: ").append(getMarca()).append("\n");
            detalles.append("Nombre: ").append(getNombre()).append("\n");
            detalles.append("Año: ").append(getYear()).append("\n");
            detalles.append("Tipo: ").append(getTipo()).append("\n");
            detalles.append("Color: ").append(getColor()).append("\n");
            //detalles.append("Precio: ").append(getPrecio()).append("\n");
            return detalles.toString();
		}
		
	}
	
	class SUV extends Auto {
		
		public SUV(String marca, String nombre, String year, String tipo, String imagen, String color, String precio) {
			super(marca, nombre, year, tipo, imagen, color, precio);
		}

		@Override
		public String getDetalles() {
			StringBuilder detalles = new StringBuilder();
			detalles.append("Marca: ").append(getMarca()).append("\n");
            detalles.append("Nombre: ").append(getNombre()).append("\n");
            detalles.append("Año: ").append(getYear()).append("\n");
            detalles.append("Tipo: ").append(getTipo()).append("\n");
            detalles.append("Color: ").append(getColor()).append("\n");
            //detalles.append("Precio: ").append(getPrecio()).append("\n");
            return detalles.toString();
		}
		
	}
	
class Deportivo extends Auto {
		
		public Deportivo(String marca, String nombre, String year, String tipo, String imagen, String color, String precio) {
			super(marca, nombre, year, tipo, imagen, color, precio);
		}

		@Override
		public String getDetalles() {
			StringBuilder detalles = new StringBuilder();
			detalles.append("Marca: ").append(getMarca()).append("\n");
            detalles.append("Nombre: ").append(getNombre()).append("\n");
            detalles.append("Año: ").append(getYear()).append("\n");
            detalles.append("Tipo: ").append(getTipo()).append("\n");
            detalles.append("Color: ").append(getColor()).append("\n");
            //detalles.append("Precio: ").append(getPrecio()).append("\n");
            return detalles.toString();
		}
		
	}

}
