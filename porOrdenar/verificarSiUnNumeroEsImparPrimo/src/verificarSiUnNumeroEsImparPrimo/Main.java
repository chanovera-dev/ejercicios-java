package verificarSiUnNumeroEsImparPrimo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
        Scanner input = new Scanner(System.in);
        
        System.out.println("Determinar si un número es par, impar y/o primo.\n");
        
        System.out.print("Ingrese un número entero positivo: ");
        int numero = input.nextInt();
        
        if (numero % 2 == 0) {
            System.out.println(numero + " es un número par.");
        } else {
            System.out.println(numero + " es un número impar.");
        }
        
        boolean esPrimo = true;
        if (numero < 2) {
            esPrimo = false;
        } else {
            for (int i = 2; i <= Math.sqrt(numero); i++) {
                if (numero % i == 0) {
                    esPrimo = false;
                    break;
                }
            }
        }
        
        if (esPrimo) {
            System.out.println(numero + " es un número primo.");
        } else {
            System.out.println(numero + " no es un número primo.");
        }
        
        input.close();
    }
	
}
