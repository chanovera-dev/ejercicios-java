package switchExcercises;

import java.util.Scanner;

public class Main {
	
	static double calificacion = 0;
	static int diaSemana = 0;
	
	public static void main(String[] args) {
		Operaciones operaciones = new Operaciones();
		
		//AcademiaDeEstudiantes();
		
		operaciones.diaSemana();
		
		operaciones.calculadora();

		operaciones.comida();
		
	}

	private static void AcademiaDeEstudiantes() {
		Scanner scanner = new Scanner(System.in);
		Operaciones operaciones = new Operaciones();
		boolean valido = false;
        
        while (!valido) {
            System.out.print("Ingrese la calificación: ");
            if (scanner.hasNextDouble()) {
                calificacion = scanner.nextDouble();
                valido = true;
            } else {
                System.out.println("\nNo es un número válido, intenta de nuevo.\n");
                scanner.next();
            }
        }
		operaciones.setCalificacion(calificacion);
		
		operaciones.escogerRespuesta();
		
	}

}
