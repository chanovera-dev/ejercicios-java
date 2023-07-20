package perimetrosAreasClases;

import java.util.Scanner;

public class CalcularArea {
	
	public static double rectangulo() {
		double base = 0, altura = 0, area = 0;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Has escogido la opción 1, calcular el área de un rectángulo, ingresa la base del rectángulo:");
		base = input.nextDouble();
		System.out.println("Ingresa la altura del rectángulo:");
		altura = input.nextDouble();
		
		area = base * altura;
		
		System.out.println("El área de tu rectángulo es de " + area);
		return area;
		
	}
	
	public static double triangulo() {
		double base = 0, altura = 0, area = 0;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Has escogido la opción 3, calcular el área de un triángulo, ingresa la base del triángulo:");
		base = input.nextDouble();
		System.out.println("Ingresa la altura del triángulo:");
		altura = input.nextDouble();
		
		area = (base * altura) / 2;
		
		System.out.println("El área de tu triángulo es de " + area);
		return area;
		
	}

}
