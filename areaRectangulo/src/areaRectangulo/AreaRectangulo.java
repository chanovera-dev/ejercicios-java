package areaRectangulo;

import java.util.Scanner;

public class AreaRectangulo {
	
	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		
		System.out.println("Bienvenido a nuestro programa de cálculo de área de un rectángulo.\n\nIngrese el largo en centimetros de su rectángulo:");
		float largo = input.nextFloat();
		
		System.out.println("Ingresa el ancho de tu rectángulo en centimetros:");
		float ancho = input.nextFloat();
		
		float areaRectangulo = largo * ancho;
		
		System.out.println("El área de tu rectángulo es de " + areaRectangulo + " cm\u00B2.");
		
	}
	
}
