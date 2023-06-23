package calculadoraInteres;

import java.util.Scanner;

public class CalculadoraInteres {
	
	public static double calcularInteresSimple(double principal, double tasaInteres, double tiempo) {
		double interes = (principal * tasaInteres * tiempo) / 10;
		return interes;
	}

	public static double calcularInteresCompuesto(double principal, double tasaInteres, double tiempo) {
		double interes = principal * Math.pow(1 + (tasaInteres / 100), tiempo) - principal;
		return interes;
	}
	
	public static void main(String[] args) {
		
		double principal, tasaInteres = 0, tiempo = 0;
		String texto;
		boolean validacion = false;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Ingresa la inversión inicial: ");
		principal = input.nextDouble();
		
		System.out.println("Ingresa la tasa de interés convenida: ");
		while (!validacion) {
            if (input.hasNextDouble()) {
            	tasaInteres = input.nextDouble();
            	validacion = true;
                if(tasaInteres > 5) {
                	System.out.println("La duración de tu plazo debe ser mayor a 10 años");
                	validacion = true;
                }
            } else {
                texto = input.next();
                System.out.println("Has ingresado un texto, por favor, ingresa un número.");
            }
        }
		
		System.out.println("Ingresa el plazo: ");
		tiempo = input.nextDouble();
		
		
		double interesSimple = calcularInteresSimple(principal, tasaInteres, tiempo);
		double interesCompuesto = calcularInteresCompuesto(principal, tasaInteres, tiempo);
		
		System.out.println("El interés simple es de $" + interesSimple + " y el interés compuesto es de $" + interesCompuesto + ".");
		
		
		
	}
}
