package areaCirculo;

import java.util.Scanner;

public class AreaCirculo {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Binvenido al programa de cálculo del área de un círculo.\n\nIngresa el radio de tu círculo en centímetros:");
		float radio = input.nextFloat();
		
		float areaCirculo = (float) Math.PI * (float) Math.pow(radio, 2);
		
		System.out.println("El área de tu círculo es de " + areaCirculo + " cm\u00B2");
	}
	
}
