package promedioCalificaciones;

import java.util.Scanner;

public class Calificaciones {
	
	double[] calificaciones = new double[15];
	double suma = 0, promedio= 0;

	public void captura() {
		Scanner input = new Scanner(System.in);
		// captura 15 números y los guarda en un array
        for (int i = 0; i < calificaciones.length; i++) {
        	double calificacion;
            boolean valido = false;
            
            while (!valido) {
                System.out.print("Ingrese la calificacion " + (i + 1) + " de 15: ");
                calificacion = input.nextDouble();
                
                if (calificacion >= 0 && calificacion <= 10) {
                    calificaciones[i] = calificacion;
                    valido = true;
                } else {
                    System.out.println("La calificacion debe estar entre 0 y 10. Intente nuevamente.");
                }
            }
            
            
            suma += calificaciones[i];
            promedio = suma / calificaciones.length;
            
        }
        
        input.close();
		
	}
	
	public void promedio() {
		if (promedio >= 9) {
        	System.out.printf("El promedio es %5.2f, sobresaliente.", promedio);
        } else if (promedio >=8) {
    		System.out.printf("El promedio es %5.2f, es un buen grupo.", promedio);
    	} else if (promedio >= 6) {
			System.out.printf("El promedio es %5.2f, estudiar.", promedio);
		} else {
			System.out.printf("El promedio es %5.2f, reprobados.", promedio);
		}
	}

}
