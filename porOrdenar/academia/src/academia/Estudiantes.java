package academia;

import java.util.Scanner;

public class Estudiantes {
	
	private Scanner scanner;
	String[] nombres;
    double[] calificaciones;
    int n = 0;
	
	public Estudiantes() {
		this.scanner = new Scanner(System.in);
		this.nombres = new String[100];
		this.calificaciones = new double[100];
	}
	
	public double[] getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(double[] calificaciones) {
		this.calificaciones = calificaciones;
	}

	public String[] getNombres() {
		return nombres;
	}

	public void setNombres(String[] nombres) {
		this.nombres = nombres;
	}

	public void ingreso() {
		boolean valido = false;
		
		while (!valido) {
			
			System.out.print("\nIngrese el número de estudiantes: ");
			if (scanner.hasNextInt()) {
	            n = scanner.nextInt();
	            valido = true;
	        } else {
	            System.out.println("\nNo es un número, intenta de nuevo.\n");
	            scanner.next();
	        }
			
			String[] nombres = new String[n];
			double[] calificaciones = new double[n];
		        
			for (int i = 0; i < n; i++) {
			    System.out.println("\nEstudiante " + (i+1));
			    
			    System.out.print("\nIngrese el nombre: ");
			    scanner.nextLine();
			    String nombre = scanner.nextLine();
			    nombres[i] = nombre;
			    setNombres(nombres);
			    
			    boolean valido2 = false;
			    while (!valido2) {
			    	System.out.print("Ingrese la calificación: ");
					if (scanner.hasNextDouble()) {
						double calificacion = scanner.nextDouble();
						if (calificacion >= 0 && calificacion <= 10) {
					        calificaciones[i] = calificacion;
					        setCalificaciones(calificaciones);
					        valido2 = true;
					    } else {
					        System.out.println("\nEl número debe estar entre 0 y 10, intenta de nuevo.\n");
					    }
			        } else {
			            System.out.println("\nNo es un número, intenta de nuevo.\n");
			            scanner.next();
			        }
			    }
			    
			}
		}
		
		System.out.println("\n¡Estudiantes ingresados correctamente!");
		 
	}
	
	public void lectura() {
		System.out.println("\nDatos de los estudiantes:\n");
        for (int i = 0; i < n; i++) {
            System.out.println("Estudiante " + (i+1) + ": " + nombres[i] + ", Calificación: " + calificaciones[i]);
        }
        
        
	}
	
}
