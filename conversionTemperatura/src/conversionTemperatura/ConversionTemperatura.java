package conversionTemperatura;

import java.util.Scanner;

public class ConversionTemperatura {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Bienvenido a nuestro programa de conversión de grados.\n\nIngresa los grados centigrados a convertir:");
		float gradosCentigrados = input.nextFloat();
		
		float gradosFahrenheit = (float) ((gradosCentigrados * 1.8) + 32);
		
		float gradosKelvin = (float) (gradosCentigrados + 273.15);
		
		System.out.println(gradosCentigrados + "° Centigrados es igual a " + gradosFahrenheit + "° Fahrenheit.\n" + gradosCentigrados + "° Centigrados es igual a " + gradosKelvin + "° Kelvin.");
		
	}
	
}
