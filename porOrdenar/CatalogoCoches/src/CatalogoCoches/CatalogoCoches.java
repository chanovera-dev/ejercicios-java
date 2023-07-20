package CatalogoCoches;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CatalogoCoches {
	
	private static Scanner scanner;
    private static int opcion;
    private static String mensajeError;
	
    public static void main(String[] args) {
    	scanner = new Scanner(System.in);
		opcion = opcion;
		mensajeError = "Ingresa una opción válida";
    	
        // Crear la lista de automóviles
        List<Automovil> automoviles = new ArrayList<>();
        automoviles.add(new Sedan("Toyota Camry", "toyota_camry.jpg"));
        automoviles.add(new SUV("Ford Explorer", "ford_explorer.jpg"));
        automoviles.add(new Sedan("Honda Civic", "honda_civic.jpg"));

        // Ciclo principal del programa
        do {
            System.out.println(
            		"\n1. Mostrar todos los automóviles\n"
            		+ "2. Filtrar por nombre\n"
            		+ "3. Filtrar por tipo\n"
            		+ "4. Salir\n");
            System.out.print("Escoge una opción: ");
            
            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\n" + mensajeError);
                scanner.next(); // Limpiar el buffer de entrada
                continue;
            }

            switch (opcion) {
                case 1:
                	mostrarAutomoviles(automoviles);
                    break;
                case 2:
                	System.out.print("\nIngrese el nombre a buscar: ");
                    String nombre = scanner.next();
                    filtrarPorNombre(automoviles, nombre);
                    break;
                case 3:
                	System.out.print("\nIngrese el tipo a buscar: ");
                    String tipo = scanner.next();
                    filtrarPorTipo(automoviles, tipo);
                    break;
                case 4:
                    System.out.println("\n¡Hasta luego!");
                    break;
                default:
                    System.out.println("\n" + mensajeError);
                    break;
            }
            
        } while (opcion != 4);

    }

    public static void mostrarAutomoviles(List<Automovil> automoviles) {
    	System.out.printf("\n%-20s %-10s %-15s\n", "Nombre", "Tipo", "Imagen");
        System.out.println("---------------------------------------------------");
    	for (Automovil automovil : automoviles) {
            automovil.mostrarDetalles();
        }
    }

    public static void filtrarPorNombre(List<Automovil> automoviles, String nombre) {
    	System.out.printf("\n%-20s %-10s %-15s\n", "Nombre", "Tipo", "Imagen");
        System.out.println("---------------------------------------------------");
        for (Automovil automovil : automoviles) {
            if (automovil.getNombre().equalsIgnoreCase(nombre)) {
                automovil.mostrarDetalles();
            }
        }
    }

    public static void filtrarPorTipo(List<Automovil> automoviles, String tipo) {
    	System.out.printf("\n%-20s %-10s %-15s\n", "Nombre", "Tipo", "Imagen");
        System.out.println("---------------------------------------------------");
        for (Automovil automovil : automoviles) {
            if (automovil.getTipo().equalsIgnoreCase(tipo)) {
                automovil.mostrarDetalles();
            }
        }
    }
}

//Clase abstracta Automovil
abstract class Automovil {
	
	private String nombre;
	private String tipo;
	private String imagen;

	public Automovil(String nombre, String tipo, String imagen) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.imagen = imagen;
	}

	public String getNombre() {
	    return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public String getImagen() {
	    return imagen;
	}

	public abstract void mostrarDetalles();
	
}

//Clase derivada de Automovil para un tipo específico (por ejemplo, Sedán)
class Sedan extends Automovil {
	
	public Sedan(String nombre, String imagen) {
		super(nombre, "Sedán", imagen);
	}

	@Override
	public void mostrarDetalles() {
		System.out.printf("%-20s %-10s %-15s\n", getNombre(), getTipo(), getImagen());
		System.out.println("---------------------------------------------------");
	}
}

//Clase derivada de Automovil para otro tipo (por ejemplo, SUV)
class SUV extends Automovil {
	
	public SUV(String nombre, String imagen) {
		super(nombre, "SUV", imagen);
	}

	@Override
	public void mostrarDetalles() {
		System.out.printf("%-20s %-10s %-15s\n", getNombre(), getTipo(), getImagen());
		System.out.println("---------------------------------------------------");
	}
	
}


