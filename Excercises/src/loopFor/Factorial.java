package loopFor;

import java.util.Scanner;

public class Factorial {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int numero = 0, factorial = 1;
		
		System.out.print("Programa para obtener el factorial de un número.\n\nIngresa un número: ");
		numero = scanner.nextInt();
		
		for(int i = numero; i > 0; i--) {
			factorial = factorial * i;
		}
		
		System.out.printf("El factorial de %d es %d.", numero, factorial);
		
		scanner.close();
	}

}
