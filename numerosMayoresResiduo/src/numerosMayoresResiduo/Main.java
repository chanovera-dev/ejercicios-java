/*
 
 Ingresar tres números (por el usuario), verificar los dos más grandes,
 dividir los dos más grandes y si el residuo es cero, imprimir el mensaje (el residuo es cero),
 si no, imprimir el resultado.
 
 Sumar el residuo más el número inferior que quedó de los primeros tres.
 
 */

package numerosMayoresResiduo;

import java.util.Scanner;

public class Main {
	
	static double num1 = 0;
	static double num2 = 0;
	static double num3 = 0;

	public static void main(String[] args) {
		
		Numeros numeros = new Numeros();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Bienvenido al programa raro de instrucciones aparentemente aleatorias con tres números.\n");
		
		// Entrada de datos
		System.out.print("Ingresa el primer número: ");
		num1 = input.nextDouble();
		numeros.setNum1(num1);
		
		System.out.print("Ingresa el segundo número: ");
		num2 = input.nextDouble();
		numeros.setNum2(num2);
		
		System.out.print("Ingresa el tercer número: ");
		num3 = input.nextDouble();
		numeros.setNum3(num3);
		
		numeros.operaciones();
	     
	     System.out.println("\nEl número más grande es " + numeros.getNumeroMayor() + " y el segundo número más grande es: " + numeros.getNumeroMedio() + ". El número más pequeño es " + numeros.getNumeroMenor() + ".");
	     
	     if (numeros.getNumeroMayor() % numeros.getNumeroMedio() == 0) {
	    	 System.out.println("El residuo entre " + numeros.getNumeroMayor() + " y " + numeros.getNumeroMedio() + " es cero");
	     } else {
	    	 System.out.println(
	    			   "La división entre " + numeros.getNumeroMayor() + " y " + numeros.getNumeroMedio() + " es " + numeros.getDivision() + "."
	    			 + "\nLa suma del residuo más el numero menor anterior es " + (numeros.getDivision() + numeros.getNumeroMenor()) + ".");
	     }
	     
		input.close();
		
	}
	
}
