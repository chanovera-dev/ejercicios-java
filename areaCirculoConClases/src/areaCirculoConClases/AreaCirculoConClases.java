package areaCirculoConClases;

import java.util.Scanner;

public class AreaCirculoConClases {
	
	public static void main(String[] args) {
		
		double radio;
		double areaCirculo;
		
		Scanner input = new Scanner(System.in);
		AreaCirculoConClases resultado = new AreaCirculoConClases();
		
		System.out.println("Binvenido al programa de cálculo del área de un círculo.\n\nIngresa el radio de tu círculo en centímetros:");
		radio = input.nextDouble();
		
		areaCirculo = resultado.calcularAreaCirculo(radio);
		
		System.out.println("El área de tu círculo es de " + areaCirculo + " cm\u00B2");
		
	}

	private double calcularAreaCirculo(double radio) {
		double areaCirculo = (float) Math.PI * (float) Math.pow(radio, 2);
		return areaCirculo; 
		
	}

}
