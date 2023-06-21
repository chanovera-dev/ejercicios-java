package personaMayor;

import java.util.Scanner;

public class PersonaMayor {

	public void obtenerDatos() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Hola, Vamos a ingresar el nombre y la edad de dos personas.\n\nIngresa ahora el nombre y la edad de la primera persona:");
		String nombre1 = input.next();
		byte edad1 = input.nextByte();
		
		System.out.println("Ingresa ahora el nombre y la edad de la segunda persona:");
		String nombre2 = input.next();
		byte edad2 = input.nextByte();
		
		if(edad1 == edad2) {
			System.out.println(nombre1 + " y " + nombre2 + " tienen la misma edad.");
		} else {
			if (edad1 > edad2) {
				System.out.println(nombre1 + " Es la persona de más edad.");
			} else { System.out.println(nombre2 + " Es la persona de más edad."); }
		}
	}
	
	public static void main(String[] args) {
		PersonaMayor salida = new PersonaMayor();
		
		salida.obtenerDatos();
	}
	
}
