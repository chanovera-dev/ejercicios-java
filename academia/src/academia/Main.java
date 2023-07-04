package academia;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Operaciones operaciones = new Operaciones();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Bienvenido a la academia.");
		
		boolean valido = false;
		
		while (!valido) {
           operaciones.menu();
           operaciones.escogerOpcion();
           valido = false;
        }
		
		operaciones.escogerOpcion();

	}

}
