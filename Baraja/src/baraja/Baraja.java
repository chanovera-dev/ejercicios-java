package baraja;

import java.util.ArrayList;
import java.util.Collections;

public class Baraja {

    private ArrayList<Carta> cartas;

    public Baraja() {
        cartas = new ArrayList<>();
        crearBaraja();
    }

    private void crearBaraja() {
        String[] palos = { "Oros", "Copas", "Espadas", "Bastos" };
        String[] valores = { "As", "2", "3", "4", "5", "6", "7" ,"8" , "9", "Sota", "Caballo", "Rey" };

        for (String palo : palos) {
            for (String valor : valores) {
                Carta carta = new Carta(palo, valor);
                cartas.add(carta);
            }
        }
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public ArrayList<ArrayList<Carta>> repartirCartas(int numJugadores) {
        ArrayList<ArrayList<Carta>> manosJugadores = new ArrayList<>();

        // Revolver las cartas antes de repartir
        Collections.shuffle(cartas);

        // Crear las manos de los jugadores
        for (int i = 0; i < numJugadores; i++) {
            manosJugadores.add(new ArrayList<Carta>());
        }

        // Repartir las cartas
        int cartasPorJugador = 5;

        for (int i = 0; i < cartasPorJugador; i++) {
            for (int j = 0; j < numJugadores; j++) {
                Carta carta = cartas.remove(0);
                manosJugadores.get(j).add(carta);
            }
        }

        return manosJugadores;
    }
}

