package primerProyecto;

import java.util.Scanner;

public class primeraPrueba {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Ingresa un número");
		float numero1 = input.nextFloat();
		
		System.out.println("Ingresa otro número");
		float numero2 = input.nextFloat();
		
		float suma = numero1 + numero2;
		float resta = numero1 - numero2;
		float multiplicacion = numero1 * numero2;
		float division = numero1  / numero2;
		
		System.out.println("La suma de " + numero1 + " más " + numero2 + " es igual a " + suma);
		System.out.println("La resta de " + numero1 + " menos " + numero2 + " es igual a " + resta);
		System.out.println("La multiplicación de " + numero1 + " por " + numero2 + " es igual a " + multiplicacion);
		System.out.println("La división de " + numero1 + " entre " + numero2 + " es igual a " + division);
	}
	
}
