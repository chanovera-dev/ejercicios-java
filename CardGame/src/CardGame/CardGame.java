package CardGame; 

import java.util.*;

public class CardGame {
    private Set<Card> cards; 
    private List<Player> players; 
    
    public CardGame() {
        cards = new HashSet<>(); //conjunto de cartas
        players = new ArrayList<>(); // lista de jugadores
    }
    
    public void addCard(Card card) { // agrega una carta y lo agrega al conjunto de cartas
        cards.add(card);
    }
    
    public void shuffleCards() { // mezcla las cartas
    	/*
    	 Primero se copian las cartas en una lista, 
    	 se mezcla esa lista utilizando Collections.shuffle, 
    	 y luego se crea un nuevo conjunto de cartas a partir de la lista mezclada. 
    	 */
        List<Card> shuffledCards = new ArrayList<>(cards);
        Collections.shuffle(shuffledCards);
        cards = new HashSet<>(shuffledCards);
    }
    
    public void addPlayer(Player player) { // agrega un jugador
        players.add(player);
    }
    
    public void dealCards(int numCards) { // reparte las cartas de acuerdo a la camtidad de jugadores escogidos
        List<Card> cardList = new ArrayList<>(cards);
        for (int i = 0; i < numCards; i++) {
            for (Player player : players) {
                if (!cardList.isEmpty()) {
                    Card card = cardList.remove(0);
                    player.addCard(card);
                }
            }
        }
    }
    
    public void displayCards() { // muestra las cartas repartidas a cada jugador
        for (Player player : players) {
            System.out.println("Player: " + player.getName());
            List<Card> playerCards = player.getCards();
            for (Card card : playerCards) {
                System.out.println("Card: " + card.getSuit() + " " + card.getValue());
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        CardGame game = new CardGame();
        
        // Agregar cartas al juego (Baraja española)
        String[] suits = {"Espadas", "Copas", "Oros", "Bastos"};
        String[] values = {"As", "2", "3", "4", "5", "6", "7", "Sota", "Caballo", "Rey"};
        
        for (String suit : suits) {
            for (String value : values) {
                game.addCard(new Card(suit, value));
            }
        }
        
        // Mezclar las cartas
        game.shuffleCards();
        
        // Solicitar el número de jugadores al usuario
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de jugadores: ");
        int numPlayers = scanner.nextInt();
        
        // Crear jugadores
        for (int i = 1; i <= numPlayers; i++) {
            game.addPlayer(new Player("Jugador " + i));
        }
        
        // Repartir cartas
        int numCardsPerPlayer = 5; // Número de cartas por jugador
        game.dealCards(numCardsPerPlayer);
        
        // Mostrar las cartas en la mesa
        game.displayCards();
        
        scanner.close();
    }
}

class Card {
    private String suit;
    private String value;
    
    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }
    
    public String getSuit() {
        return suit;
    }
    
    public String getValue() {
        return value;
    }
}

class Player {
    private String name;
    private List<Card> cards;
    
    public Player(String name) {
        this.name = name;
        cards = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public void addCard(Card card) {
        cards.add(card);
    }
    
    public List<Card> getCards() {
        return cards;
    }
}
