package baraja;

import java.util.ArrayList;

public class Jugador {
	private ArrayList<Carta> mano;

    public Jugador() {
        mano = new ArrayList<>();
    }

    public void recibirCarta(Carta carta) {
        mano.add(carta);
    }

    public ArrayList<Carta> getMano() {
        return mano;
    }
}
