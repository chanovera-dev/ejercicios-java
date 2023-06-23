package calculadoraConClases;

import java.text.DecimalFormat;

// Desarrolla una calculadora con suma, resta, multiplica y divide números flotantes usando clases

import java.util.Scanner;

public class CalculadoraConClases {
	

public static void main(String[] args) {
		
		double num1 = 0, num2 = 0, suma = 0, resta = 0, multiplicacion = 0, division = 0;
		
		Scanner numero = new Scanner(System.in);
		CalculadoraConClases resultado = new CalculadoraConClases();
		DecimalFormat decimalFormat = new DecimalFormat("#.##########");
		
		System.out.println("Ingresa el primer número:");
		num1 = numero.nextDouble();
		System.out.println("Ingresa el segundo número:");
		num2 = numero.nextDouble();
		
		suma = resultado.suma(num1, num2);
		resta = resultado.resta(num1, num2);
		multiplicacion = resultado.multiplicacion(num1, num2);
		division = resultado.division(num1, num2);
		
		String num1Format = decimalFormat.format(num1);
		String num2Format = decimalFormat.format(num2);
		String sumaFormat = decimalFormat.format(suma);
		String restaFormat = decimalFormat.format(resta);
		String multiplicacionFormat = decimalFormat.format(multiplicacion);
		String divisionFormat = decimalFormat.format(division);
		
		if (!num1Format.endsWith(".0000000000")) {
        	num1Format = decimalFormat.format(num1);
        }
		
		if (!num2Format.endsWith(".0000000000")) {
        	num2Format = decimalFormat.format(num2);
        }
		
		if (!sumaFormat.endsWith(".0000000000")) {
        	sumaFormat = decimalFormat.format(suma);
        }
		
		if (!restaFormat.endsWith(".0000000000")) {
        	restaFormat = decimalFormat.format(resta);
        }
		
		if (!multiplicacionFormat.endsWith(".0000000000")) {
        	multiplicacionFormat = decimalFormat.format(multiplicacion);
        }
		
		if (!divisionFormat.endsWith(".0000000000")) {
        	divisionFormat = decimalFormat.format(division);
        }
		
		System.out.println("La suma de " + num1Format + " más " + num2Format + " es " + sumaFormat + ".");
		System.out.println("La resta de " + num1Format + " menos " + num2Format + " es " + restaFormat + ".");
		System.out.println("La multiplicación de " + num1Format + " por " + num2Format + " es " + multiplicacionFormat + ".");
		System.out.println("La división de " + num1Format + " entre " + num2Format + " es " + divisionFormat + ".");
	}

	private double division(double num1, double num2) {
	double division = num1/num2;
	return division;
}

	private double multiplicacion(double num1, double num2) {
	double multiplicacion = num1 * num2;
	return multiplicacion;
}

	private double resta(double num1, double num2) {
	double resta = num1 - num2; 
	return resta;
}

	private double suma(double num1, double num2) {
		double suma = num1+num2;
		return suma;
	}

}
	
	


