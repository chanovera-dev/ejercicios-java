package CardGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class CardGameGUI extends JFrame {
    private static final long serialVersionUID = 1L;
    //private JTextArea textArea;
    private JLabel numPlayersLabel;
    private JTextField numPlayersField;
    private JButton startButton;
    private JPanel cardPanel;
    private List<JPanel> playerPanels; // Lista de paneles para mostrar las cargas de cada jugador

    public CardGameGUI() {
        setTitle("Card Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        //textArea = new JTextArea();
        //getContentPane().add(textArea, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        numPlayersLabel = new JLabel("Jugadores:");
        numPlayersField = new JTextField(2);
        inputPanel.add(numPlayersLabel);
        inputPanel.add(numPlayersField);
        startButton = new JButton("Repartir");
        startButton.addActionListener(new StartButtonListener());

        inputPanel.add(startButton);

        getContentPane().add(inputPanel, BorderLayout.SOUTH);

        cardPanel = new JPanel(new GridLayout(6, 0, 0, 15)); // 1 columna para los paneles de los jugadores, 5 filas para las cargas
        getContentPane().add(cardPanel, BorderLayout.NORTH);

        setSize(800, 450); // Establecer el tamaño inicial de la ventana
        setVisible(true);
    }

    private class StartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int numPlayers;
            try {
                numPlayers = Integer.parseInt(numPlayersField.getText());
                if (numPlayers < 1 || numPlayers > 6) {
                    JOptionPane.showMessageDialog(null, "El número de jugadores debe estar entre 1 y 6.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    clearScreen();
                    playCardGame(numPlayers);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "El número de jugadores ingresado no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void clearScreen() {
        cardPanel.removeAll(); // Limpiar el panel de cargas
        //textArea.setText(""); // Limpiar el área de texto
        playerPanels = new ArrayList<>(); // Reiniciar la lista de paneles de jugador
        
        cardPanel.removeAll(); // Limpiar el panel de cargas
        revalidate(); // Actualizar la interfaz
        repaint(); // Volver a pintar la interfaz
    }

    public void playCardGame(int numPlayers) {
        CardGame game = new CardGame();

        // Agregar cartas al juego (Baraja española)
        String[] suits = { "Espadas", "Copas", "Oros", "Bastos" };
        String[] values = { "As", "2", "3", "4", "5", "6", "7", "Sota", "Caballo", "Rey" };

        for (String suit : suits) {
            for (String value : values) {
                game.addCard(new Card(suit, value));
            }
        }

        // Mezclar las cartas
        game.shuffleCards();

        // Crear jugadores
        for (int i = 1; i <= numPlayers; i++) {
            game.addPlayer(new Player("Jugador " + i));
        }

        // Repartir cartas
        int numCardsPerPlayer = 5; // Número de cartas por jugador
        game.dealCards(numCardsPerPlayer);

        // Mostrar las cartas en la interfaz gráfica
        cardPanel.removeAll(); // Limpiar el panel antes de mostrar las cartas
        playerPanels = new ArrayList<>(); // Inicializar la lista de paneles de jugador

        for (Player player : game.getPlayers()) {
            JPanel playerPanel = new JPanel(new GridLayout(1, 0, 15, 0)); // Utilizar GridLayout para distribuir de manera uniforme los cardLabel
            playerPanel.setBorder(BorderFactory.createTitledBorder(player.getName()));
            playerPanels.add(playerPanel);

            int maxWidth = 0; // Ancho máximo encontrado hasta el momento

            for (Card card : player.getCards()) {
                JLabel cardLabel = new JLabel(card.getValue() + " de " + card.getSuit());

                Border border = BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.gray),
                    BorderFactory.createEmptyBorder(5, 5, 5, 5)
                );
                cardLabel.setBorder(border);

                playerPanel.add(cardLabel);

                // Actualizar el ancho máximo si es necesario
                int labelWidth = cardLabel.getPreferredSize().width;
                if (labelWidth > maxWidth) {
                    maxWidth = labelWidth;
                }
            }

            // Establecer el ancho máximo a todos los cardLabel
            for (Component component : playerPanel.getComponents()) {
                if (component instanceof JLabel) {
                    JLabel cardLabel = (JLabel) component;
                    cardLabel.setPreferredSize(new Dimension(maxWidth, cardLabel.getPreferredSize().height));
                }
            }

            cardPanel.add(playerPanel);
        }

        //textArea.setVisible(false); // Ocultar el textArea

        revalidate(); // Actualizar la interfaz
    }

    public static void main(String[] args) {
        CardGameGUI gui = new CardGameGUI();
    }
}
