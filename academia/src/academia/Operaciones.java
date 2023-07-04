package academia;

import java.util.Scanner;

public class Operaciones {
	
	private int opcion = 0;
	private Scanner scanner;
	private Estudiantes estudiantes;
	
	public Operaciones() {
		this.scanner = new Scanner(System.in);
		this.estudiantes = new Estudiantes();
	}

	public int getOpcion() {
		return opcion;
	}

	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}
	
	public void menu() {
		System.out.println(
				  "\n1 para agregar alumnos.\n"
				+ "2 para ver alumnos.\n"
				+ "3 para salir del programa.\n");
	}
	
	public void escogerOpcion() {
		boolean valido = false;
		int opcion = scanner.nextInt();
		
		while (!valido) {
            if (opcion >= 1 && opcion <= 3) {
            	
            	switch (opcion) {
				case 1:
					estudiantes.ingreso();
					break;
				case 2:
					estudiantes.lectura();
					break;
				case 3:
					System.out.println("\nHasta luego.\n");
					System.exit(0);
			}
                valido = true;
            } else {
                System.out.println("\nNo es un número válido, intenta de nuevo.\n");
                opcion = scanner.nextInt();
            }
        }
	}
	

	
}
