package dia22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		ArrayList<String> palabras = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[5];

        System.out.println("Ingrese la lista de palabras, presione \'q\' para terminar.\n");
        String palabra = scanner.nextLine();
        while (!palabra.equalsIgnoreCase("q")) {
            palabras.add(palabra);
            palabra = scanner.nextLine();
        }
		
        ArrayList<String> palabrasSinDuplicado = new ArrayList<>();
        for (String palabra1 : palabras) {
            if (!palabrasSinDuplicado.contains(palabra1)) {
                palabrasSinDuplicado.add(palabra1);
            }
        }
        
        System.out.println("\nLista de palabras:\n");
        for (String p : palabrasSinDuplicado) {
            System.out.println(p);
        }
        
        System.out.println("\nIngrese 5 números:\n");
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = scanner.nextInt();
        }

        Arrays.sort(numeros);
        
        System.out.println("\nNúmeros en orden ascendente:\n");
        for (int numero : numeros) {
            System.out.println(numero);
        }
	}
	
}
