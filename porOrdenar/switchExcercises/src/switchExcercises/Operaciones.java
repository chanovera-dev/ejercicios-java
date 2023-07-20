package switchExcercises;

import java.util.Scanner;

public class Operaciones {
	
	private double calificacion;
	boolean validacionEstudiante = false;
	boolean validacionDia = false;
	boolean validacionCalculadora = false;
	boolean validacionComida = false;
	private int tipoEstudiante;
	private Scanner scanner;
	private int numeroDia = 0;
	
	public Operaciones() {
		this.scanner = new Scanner(System.in);
	}
	
	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}
	
	public void escogerRespuesta() {
		if (calificacion >= 9) {
			tipoEstudiante = 1;
		} else if (calificacion >= 8) {
			tipoEstudiante = 2;
		} else if (calificacion >= 6) {
			tipoEstudiante = 3;
		} else {
			tipoEstudiante = 4;
		}
		
		while (!validacionEstudiante) {
			switch (tipoEstudiante) {
				case 1:
					System.out.println("\nEres un excelente estudiante.\n");
					validacionEstudiante = true;
					break;
				case 2:
					System.out.println("\nEres un estudiante promedio.\n");
					validacionEstudiante = true;
					break;
				case 3:
					System.out.println("\nPuedes mejorar como estudiante.\n");
					validacionEstudiante = true;
					break;
				default:
					System.out.println("\n¿Te interesa una carrera técnica?\n");
					validacionEstudiante = true;
					break;
			}
		}
	}
	
	public void diaSemana() {
		while (!validacionDia) {
	    	System.out.print("Ingrese un número del uno al siete para saber que día de la semana es: ");
			if (scanner.hasNextInt()) {
				numeroDia = scanner.nextInt();
				if (numeroDia >= 1 && numeroDia <= 7) {
			        validacionDia = true;
			    } else {
			        System.out.println("\nEl número debe estar entre 0 y 7, intenta de nuevo.\n");
			    }
	        } else {
	            System.out.println("\nNo es un número, intenta de nuevo.\n");
	            scanner.next();
	        }
	    }
		

		switch (numeroDia) {
			case 1:
				System.out.println("\nEs Lunes.\n");
				break;
			case 2:
				System.out.println("\nEs martes.\n");
				break;
			case 3:
				System.out.println("\nEs miercoles.\n");
				break;
			case 4:
				System.out.println("\nEs jueves.\n");
				break;
			case 5:
				System.out.println("\nEs viernes.\n");
				break;
			case 6:
				System.out.println("\nEs sábado.\n");
				break;
			case 7:
				System.out.println("\nEs domingo.\n");
				break;
		}
	}
	
	public void calculadora() {
		while (!validacionCalculadora) {
	    	System.out.println(""
	    			+ "Escoja que tipo de número ingresará hoy: \n\n"
	    			+ "1 para byte.\n"
	    			+ "2 para short.\n"
	    			+ "3 para int.\n"
	    			+ "4 para long. \n"
	    			+ "5 para float.\n"
	    			+ "6 para double.\n");
			if (scanner.hasNextInt()) {
				numeroDia = scanner.nextInt();
				validacionCalculadora = true;
	        } else {
	            System.out.println("\nNo es un número, intenta de nuevo.\n");
	            scanner.next();
	        }
	    }
		

		switch (numeroDia) {
			case 1:
				System.out.println("\nHa escogido un tipo de número byte.");
				System.out.println("El tipo byte emplea un solo byte (8 bits) de almacenamiento. Esto permite almacenar valores en el rango [-128, 127]. Ingresa tu número:\n\n");
				byte numeroByte = scanner.nextByte();
				System.out.println(numeroByte + " es un ahora número tipo byte.");
				break;
			case 2:
				System.out.println("\nHa escogido un tipo de número short.");
				System.out.println("El tipo short usa el doble de almacenamiento que el anterior, lo cual hace posible representar cualquier valor en el rango [-32.768, 32.767]. Ingresa tu número:\n\n");
				short numeroShort = scanner.nextShort();
				System.out.println(numeroShort + " es ahora un número tipo short.");
				break;
			case 3:
				System.out.println("\nHa escogido un tipo de número int.");
				System.out.println("El tipo int emplea 4 bytes de almacenamiento y es el tipo de dato entero más empleado. El rango de valores que puede representar va de -2\u00B3\u00B9 a 2\u00B3\u00B9-1. Ingresa tu número:\n\n");
				int numeroInt = scanner.nextInt();
				System.out.println(numeroInt + " es ahora un número tipo int.");
				break;
			case 4:
				System.out.println("\nHa escogido un tipo de número long.");
				System.out.println("El tipo long es el tipo entero de mayor tamaño, 8 bytes (64 bits), con un rango de valores desde -2\u2076\u00B3 a 2\u2076\u00B3-1. Ingresa tu número:\n\n");
				long numeroLong = scanner.nextLong();
				System.out.println(numeroLong + " es ahora un número tipo long.");
				break;
			case 5:
				System.out.println("\nHa escogido un tipo de número float.");
				System.out.println("conocido como tipo de precisión simple, emplea un total de 32 bits. Con este tipo de datos es posible representar números en el rango de 1.4x10\u207B\u2074\u2075 a 3.4028235x10\u00B3\u2078.");
				float numeroFloat = scanner.nextFloat();
				System.out.println(numeroFloat + " es ahora un número tipo float.");
				break;
			case 6:
				System.out.println("\nHa escogido un tipo de número double.\n");
				System.out.println("sigue un esquema de almacenamiento similar al anterior, pero usando 64 bits en lugar de 32. Esto le permite representar valores en el rango de 4.9x10\u207B\u00B3\u00B2\u2074 a 1.7976931348623157x10\u00b3\u2070\u2078");
				double numeroDouble = scanner.nextDouble();
				System.out.println(numeroDouble + " es ahora un número tipo double.");
				break;
		}
	}
	
	public void comida() {
		while (!validacionComida) {
	    	System.out.println(""
	    			+ "\\n\\nEscoja que comerá hoy: \n\n"
	    			+ "1 para enchiladas.\n"
	    			+ "2 para empanadas.\n"
	    			+ "3 para memelas.\n"
	    			+ "4 para panuchos. \n"
	    			+ "5 para pollo asado.\n");
			if (scanner.hasNextInt()) {
				numeroDia = scanner.nextInt();
				if (numeroDia >= 1 && numeroDia <= 5) {
			        validacionComida = true;
			    } else {
			        System.out.println("\nEl número debe estar entre 0 y 5, intenta de nuevo.\n");
			    }
	        } else {
	            System.out.println("\nNo es un número, intenta de nuevo.\n");
	            scanner.next();
	        }
	    }
		

		switch (numeroDia) {
			case 1:
				System.out.println("\nHa escogido comer enchiladas.\n");
				break;
			case 2:
				System.out.println("\nHa escogido comer empanadas.\n");
				break;
			case 3:
				System.out.println("\nHa escogido comer memelas.\n");
				break;
			case 4:
				System.out.println("\nHa escogido comer panuchos.\n");
				break;
			case 5:
				System.out.println("\nHa escogido comer pollo asado.\n");
				break;
		}
	}
	
}
