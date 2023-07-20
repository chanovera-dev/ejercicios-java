package verificarSiNumeroNegativoPositivoCero;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Verifica si un número es negativo, positivo o cero: ");
		double numero = input.nextInt();
		
		if (numero == 0) {
			System.out.println("El número es cero.");
		} else if (numero > 0) {
			System.out.println("El número es mayor que cero.");
		} else {
			System.out.println("El número menor que cero.");
		}
		
		input.close();
		
	}
	
}
