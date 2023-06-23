// Cálculo del promedio de números flotantes usando clases

package promedioClases;

import java.util.Scanner;

public class PromedioClases {
	
	public static void main(String[] args) {
        PromedioClases promedio = new PromedioClases();
        
        promedio.obtenerDatos();
   
    }
	
	public double obtenerDatos() {
		
		Scanner input = new Scanner(System.in);
		int contador = 1;
		double suma = 0;
		
		while (contador <= 5) {
            System.out.print("Ingresa el dato #" + contador + ": ");
            int numero = input.nextInt();
            suma += numero;
            contador++;
        }

        double promedio = suma / 5.0;
        System.out.println("El promedio de los datos ingresados es: " + promedio);
        return promedio;
	}

}
