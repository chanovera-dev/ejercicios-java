/*
 
 Programa donde el usuario ingrese un año y determinar si el año es bisiesto o no
 Un año bisiesto es divisible entre 4, excepto los años que son divisibles entre 100,
 pero no entre 400.
 
 */
package leapYear;

public class Main {

	public static void main(String[] args) {
		Years years = new Years();
		
		System.out.println("Bienvenido a su programa de determinación de año bisiesto.\n");
		
		years.obtenerDatos();
		
		if ((years.getYear() % 4 == 0 && years.getYear() % 100 != 0) || years.getYear() % 400 == 0) {
	        System.out.println("\n" + years.getYear() + " es un año bisiesto.");
	    } else {
	    	System.out.println("\n" + years.getYear() + " no es un año bisiesto.");
	    }
		
	}
	
}
