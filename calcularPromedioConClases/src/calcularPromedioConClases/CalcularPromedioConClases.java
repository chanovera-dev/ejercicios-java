package calcularPromedioConClases;

import java.util.Scanner;

public class CalcularPromedioConClases {
	
	public static void man(String[] args) {
		
		
        int contador = 1; // Comenzamos en 1 para indicar el primer dato
        int suma = 0;

        CalcularPromedioConClases calcular = new CalcularPromedioConClases();
        
        calcular.promedio(suma, contador);
        
        
		
	}

	public void promedio(int suma, int contador) {
		Scanner scanner = new Scanner(System.in);
		
		while (contador <= 5) {
            System.out.print("Ingresa el dato #" + contador + ": ");
            int numero = scanner.nextInt();
            suma += numero;
            contador++;
        }

        double promedio = suma / 5.0;
        System.out.println("El promedio de los datos ingresados es: " + promedio);

        scanner.close();
		
	}

}
