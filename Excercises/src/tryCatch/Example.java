package tryCatch;

import java.util.Scanner;

public class Example {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Ingresa el numerador");
		int numerador = scanner.nextInt();
		
		System.out.println("Ingresa el denominador");
		int denominador = scanner.nextInt();
		
		try {
			int resultado = numerador / denominador;
			System.out.println("El resultado es " + resultado);
		} catch(ArithmeticException e) {
			System.out.println("No se puede dividir entre cero.");
		}
		
		scanner.close();
	}

}
