package calculadora;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class CalculadoraBase extends JFrame implements ActionListener {
    
    private static final long serialVersionUID = 1L; // no sé que hace pero quita una advertencia
	private JTextField campoNumeros; // Pantalla donde se verán las operaciones
    private List<Double> numeros; // Lista de números ingresados
    private List<String> operaciones; // Lista de operaciones ingresadas
    
    public CalculadoraBase() {
        setTitle("Calculadora base"); // título de la ventana
        setSize(300, 400); // proporción de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // método de cierre
        setLocationRelativeTo(null); // ubicación relativa
        setLayout(new BorderLayout());
        
        campoNumeros = new JTextField();
        campoNumeros.setEditable(false); // evita que se pueda editar la pantalla de números, solo recibe datos desde los botones
        add(campoNumeros, BorderLayout.NORTH);
        
        JPanel panel = new JPanel(); // genera un contenedor para los botones
        panel.setLayout(new GridLayout(5, 5)); // marca el tamaño de la rejilla
        
        String[] botones = { // contenido de la rejilla (botones)
                "AC", "C", " ", "÷",
                "7" , "8", "9", "x",
                "4" , "5", "6", "-",
                "1" , "2", "3", "+",
                " " , "0", ".", "="
        };
        
        for (String boton : botones) {
            if (boton.equals("C")) {
                JButton button = new JButton("C");
                button.addActionListener(this);
                panel.add(button);
            } else {
                JButton button = new JButton(boton);
                button.addActionListener(this);
                if (boton.trim().isEmpty()) { // si el botón está en blanco se deshabilita
                    button.setEnabled(false);
                }
                panel.add(button);
            }
        }
        
        add(panel, BorderLayout.CENTER); // ajusta la ubicación del panel
        
        numeros = new ArrayList<>();
        operaciones = new ArrayList<>();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // eventos de los botones
        String contenidoBoton = ((JButton) e.getSource()).getText();
        
        if (contenidoBoton.matches("[0-9.]")) { // agrega el contenido a la pantalla de números si este es un número del 0 al 9, también si es un decimal
            campoNumeros.setText(campoNumeros.getText() + contenidoBoton);
        } else if (contenidoBoton.matches("[+\\-x÷]")) { // si el botón es un operando almacena el número actual y la operación
            double numero = Double.parseDouble(campoNumeros.getText());
            numeros.add(numero);
            operaciones.add(contenidoBoton);
            campoNumeros.setText("");
        } else if (contenidoBoton.equals("=")) { // si es el símbolo "=", realiza todas las operaciones y muestra el resultado
            double numero = Double.parseDouble(campoNumeros.getText());
            numeros.add(numero);
            double resultado = calcularResultado();
            campoNumeros.setText(String.valueOf(resultado));
            numeros.clear();
            operaciones.clear();
        } else if (contenidoBoton.equals("AC")) { // borra el contenido la pantalla y reinicia los números y operaciones
            campoNumeros.setText("");
            numeros.clear();
            operaciones.clear();
        } else if (contenidoBoton.equals("C")) {
            String campoNumerosActualizado = campoNumeros.getText();
            if (!campoNumerosActualizado.isEmpty()) {
                campoNumeros.setText(campoNumerosActualizado.substring(0, campoNumerosActualizado.length() - 1));
            }
        }
    }
    
    private double calcularResultado() {
        double resultado = numeros.get(0);
        
        for (int i = 0; i < operaciones.size(); i++) {
            String operacion = operaciones.get(i);
            double numero = numeros.get(i + 1);
            
            switch (operacion) {
                case "+":
                    resultado += numero;
                    break;
                case "-":
                    resultado -= numero;
                    break;
                case "x":
                    resultado *= numero;
                    break;
                case "÷":
                    resultado /= numero;
                    break;
                default:
                    break;
            }
        }
        
        return resultado;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculadoraBase calculadora = new CalculadoraBase();
            calculadora.setResizable(false); // evita maximizar la ventana
            calculadora.setVisible(true); // muestra la calculadora
        });
    }
}
