package whileExcercises;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Operaciones {
	
	private Scanner scanner;
	ArrayList<Integer> numeros;
	int sumaDigitos = 0;
	
	public Operaciones() {
		this.scanner = new Scanner(System.in);
		this.numeros  = new ArrayList<>();
	}

	public void ingresaNumeros() {
		System.out.println("Ingresa números. El programa se detendrá cuando ingreses un número igual o menor a -5.\n");

		while (true) {
            System.out.print("Ingresa un número: ");
            try {
                int numero = scanner.nextInt();

                if (numero <= -5) {
                    break;
                }

                numeros.add(numero);
            } catch (InputMismatchException e) {
                System.out.print("\nEso no es un número, intenta de nuevo. ");
                scanner.nextLine();
            }
        }

        System.out.println("\nLos números ingresados fueron:\n");
        for (int num : numeros) {
            System.out.println(num);
        }
		
	}
	
	public void SumaDigitosIngresados() {
		System.out.println("\nIngresa números para ser sumados. El programa se detendrá cuando ingreses un número igual o menor a -5.\n");
		
		while (true) {
            System.out.print("Ingresa un número: ");
            try {
                int numero = scanner.nextInt();

                if (numero <= -5) {
                    break;
                }

                numeros.add(numero);

                int valorAbsoluto = Math.abs(numero);
                String numeroString = Integer.toString(valorAbsoluto);
                
                // con ciclo for
                /*
                int valorAbsoluto = Math.abs(numero);
                String numeroString = Integer.toString(valorAbsoluto);
                for (int i = 0; i < numeroString.length(); i++) {
                    char digitoChar = numeroString.charAt(i);
                    int digito = Character.getNumericValue(digitoChar);
                    sumaDigitos += digito;
                }
                */
                
                int i = 0;
                while (i < numeroString.length()) {
                    char digitoChar = numeroString.charAt(i);
                    int digito = Character.getNumericValue(digitoChar);
                    sumaDigitos += digito;
                    i++;
                }
            } catch (InputMismatchException e) {
                System.out.print("\nEso no es un número, intenta de nuevo. ");
                scanner.nextLine();
            }
        }

        System.out.println("\nLa suma de los dígitos ingresados es: " + sumaDigitos + ".");
	}
	
	public void calcularFactorial() {
		System.out.print("\nIngresa un número para obtener su factorial: ");
		try {
            int numero = scanner.nextInt();

            int factorial = 1;
            int contador = 1;

            do {
                factorial *= contador;
                contador++;
            } while (contador <= numero);

            System.out.println("\nEl factorial de " + numero + " es " + factorial + ".");
        } catch (InputMismatchException e) {
            System.out.println("\nEso no es un número, intenta de nuevo: ");
            scanner.nextLine();
        }
	}
}
