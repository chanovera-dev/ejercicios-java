package perimetrosAreasClases;

import java.util.Scanner;

public class CalcularPerimetro {
	
	public static double rectangulo() {
		double base = 0, altura = 0, perimetro = 0;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Has escogido la opción 2, calcular el perímetro de un rectángulo, ingresa la base del rectángulo:");
		base = input.nextDouble();
		System.out.println("Ingresa la altura del rectángulo:");
		altura = input.nextDouble();
		
		perimetro = (base + altura) * 2;
		
		System.out.println("El área de tu rectángulo es de " + perimetro);
		
		return perimetro;
		
	}
	
	public static double triangulo() {
		double lado1 = 0, lado2 = 0, lado3 = 0, perimetro = 0;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Has escogido la opción 4, calcular el perímetro de un triángulo, ingresa el lado 1 del triángulo:");
		lado1 = input.nextDouble();
		System.out.println("Ingresa el lado 2 del rectángulo:");
		lado2 = input.nextDouble();
		System.out.println("Ingresa el lado 3 del rectángulo:");
		lado3 = input.nextDouble();
		
		perimetro = lado1 + lado2 + lado3;
		
		System.out.println("El perímetro de tu triángulo es de " + perimetro);
		
		return perimetro;
		
	}

}
