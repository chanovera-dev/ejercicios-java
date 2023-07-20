package mayorMenorArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Numeros {
	
	int[] numeros1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	int[] numeros2 = new int[10];
	int largo1 = 0;

	public int[] getNumeros1() {
		return numeros1;
	}

	public void setNumeros1(int[] numeros1) {
		this.numeros1 = numeros1;
	}

	public void ordenaNumeros1() {
		// ordena los numeros
		Arrays.sort(numeros1);
        largo1 = numeros1.length;
		
	}

	public void imprimeMayorMenor1() {
		// imprime los números del mayor al menor
        for (int i = largo1 - 1; i >= largo1 - 10; i--) {
            System.out.println("Imprime el " + numeros1[i]);
        }
		
	}

	public void capturaNumeros2() {
		Scanner input = new Scanner(System.in);
		// captura 10 números y los guarda en un array
        for (int i = 0; i < numeros2.length; i++) {
        	
            System.out.print("Ingrese el número " + (i + 1) + ": ");
            numeros2[i] = input.nextInt();
            
        }
        
        input.close();
		
	}

	public void imprimeNumeros2() {
		// imprime los números capturados
        for (int i = 0; i < numeros2.length; i++) {
        	
            System.out.println("Imprime el " + numeros2[i]);
            
        }
		
	}

	public void ordenaNumerosCapturados() {
		// ordena los números de mayor a menor
        for (int i = 0; i < numeros2.length - 1; i++) {
        	
            for (int j = 0; j < numeros2.length - i - 1; j++) {
            	
                if (numeros2[j] < numeros2[j + 1]) {
                	
                    int temp = numeros2[j];
                    numeros2[j] = numeros2[j + 1];
                    numeros2[j + 1] = temp;
                    
                }
                
            }
            
        }
		
	}
	
}
