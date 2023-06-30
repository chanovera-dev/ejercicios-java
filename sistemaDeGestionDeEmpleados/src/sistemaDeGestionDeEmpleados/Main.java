package sistemaDeGestionDeEmpleados;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Bienvenido a tu sistema de gestión de empleados.\n");
		
		boolean validarMenu = false;
		
		while (!validarMenu) {
			Menu();
			EscogerOpcion();
			validarMenu = false;
        }

	}

	private static void EscogerOpcion() {
		
		Empleado empleado = new Empleado();
		Scanner scanner = new Scanner(System.in);
		
		boolean valido = false;
		int opcion = scanner.nextInt();
		
		while (!valido) {
            if (opcion >= 1 && opcion <= 5) {
            	
            	switch (opcion) {
				case 1:
					empleado.contratar();
					break;
				case 2:
					empleado.despedir();
					break;
				case 3:
					empleado.aumentarSalario();
					break;
				case 4:
					empleado.mostrarTodos();
					break;
				case 5:
					System.out.println("¡Hasta luego!");
					System.exit(0);
            	}
            valido = true;
            } else {
                System.out.println("\nNo es un número válido, intenta de nuevo.\n");
                opcion = scanner.nextInt();
            }
        }
		
	}

	private static void Menu() {
		System.out.println(
				  "Contratar empleado (1).\n"
				+ "Despedir empleado (2).\n"
				+ "Aumentar sueldo (3).\n"
				+ "Mostrar empleados (4).\n"
				+ "Salir del programa (5).\n");
		
	}
	
}
