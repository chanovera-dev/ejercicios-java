package sistemaDeGestionDeEmpleados;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Mostrar {
	
	
    private Scanner scanner;
    private int opcion;
    private Operaciones operaciones;
    private String mensajeError;
	
	public Mostrar() {
		
		this.scanner = new Scanner(System.in);
		this.opcion = opcion;
		this.operaciones = new Operaciones();
		this.mensajeError = "Ingresa una opción válida";
	}

	public void menu() {
		
		do {
            System.out.println(
            		  "1. Contratar empleado\n"
            		+ "2. Despedir empleado\n"
            		+ "3. Aumentar salario\n"
            		+ "4. Mostrar todos los empleados\n"
            		+ "5. Salir del programa\n");
            
            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\n" + mensajeError + "\n");
                scanner.next(); // Limpiar el buffer de entrada
                continue;
            }

            switch (opcion) {
                case 1:
                	operaciones.contratarEmpleado();
                    break;
                case 2:
                    operaciones.despedirEmpleado();
                    break;
                case 3:
                	operaciones.aumentarSalario();
                    break;
                case 4:
                    operaciones.mostrarEmpleados();
                    break;
                case 5:
                    System.out.println("\n¡Hasta luego!");
                    break;
                default:
                    System.out.println("\n" + mensajeError);
                    break;
            }
            
        } while (opcion != 5);
		
	}
	
}
