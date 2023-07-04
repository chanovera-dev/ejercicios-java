package ejerciciosWhile;

import java.util.Scanner;

public class Numeros {
	
	private Scanner scanner;
	
	private double[] numeros;
	
	public Numeros() {
		this.scanner = new Scanner(System.in);
		this.numeros = new double[10];
	}

	public void obtenerDatos() {
		
		
		// captura 10 números y los guarda en un array
        for (int i = 0; i < numeros.length; i++) {
        	double numero;
            boolean valido = false;
            
            while (!valido) {
                System.out.print("Ingrese el numero " + (i + 1) + " de 10: ");
                if (scanner.hasNextDouble()) {
                    numero = scanner.nextDouble();
                    numeros[i] = numero;
                    valido = true;
                } else {
                    System.out.println("\nNo es un número, intenta de nuevo.\n");
                    scanner.next(); // Descarta el valor no válido del escáner
                }
            }
		
		}
        
        //scanner.close();
	
	}
	
	public void ordenaNumerosCapturados() {
	    // Ordena los números de menor a mayor
	    for (int i = 0; i < numeros.length - 1; i++) {
	    	
	        for (int j = 0; j < numeros.length - i - 1; j++) {
	        	
	            if (numeros[j] > numeros[j + 1]) {
	            	
	                double temp = numeros[j];
	                numeros[j] = numeros[j + 1];
	                numeros[j + 1] = temp;
	                
	            }
	            
	        }
	        
	    }
	    
	}
	
	public void imprimeNumeros() {
		// imprime los números capturados
        for (int i = 0; i < numeros.length; i++) {
        	
            System.out.println("Imprime el " + numeros[i]);
            
        }
		
	}
	
	public void imprimirMenorMayor() {
		System.out.println("Imprime el número menor: " + numeros[0]);
		System.out.println("Imprime el número mayor: " + numeros[9]);
		
    }
	
	public void buscarNumero() {

		double blablabla = 0;
		int indice = 0;
		boolean valido = false;
		
		System.out.print("Buscar un número en el array: ");
		blablabla = scanner.nextDouble();
		
		for (int i = 0; i < numeros.length; i++) {
			if (blablabla == numeros[i]) {
				indice = i;
				valido = true;
			}
		}
		
		if (valido == true) {
			System.out.println("Número encontrado en la posición " + indice);
		} else {
			System.out.println("Número no encontrado.");
		}
	}

}
