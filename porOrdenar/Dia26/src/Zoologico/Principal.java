package Zoologico;

public class Principal {

	public static void main(String[] args) {
		
		Perro perro = new Perro("Winiberto", "Pienso", 3, 26, "Pitbull");
		Tortuga tortuga = new Tortuga("Rafael", "Vegetariana", 2, 2, "Terrestre");
		
		perro.mostrar();
		tortuga.mostrar();

	}

}
