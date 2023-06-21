package nombreEdadSaludar;

import java.util.Scanner;

public class NombreEdadSaludar {
	
	public void obtenerDatos() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Hola, ingresas tu nombre, y los años que tienes:");
		String nombre = input.next();
		int edad = input.nextInt();
		
		System.out.println("Hola " + nombre + ", espero te encuentres muy bien, me he enterado que tienes " + edad + " años y pienso que eso hay que celebrarlo.");
	}
	
	public static void main(String[] args) {
		NombreEdadSaludar salida = new NombreEdadSaludar();
		
		salida.obtenerDatos();
	}

}
