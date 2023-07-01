package sistemaDeGestionDeEmpleados;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
	
	public static void main(String[] args) {
		
		ArrayList<String> empleados = new ArrayList<>();
        HashMap<String, Integer> edades = new HashMap<>();
        HashMap<String, Double> salarios = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(Locale.getDefault());
        
        System.out.println("Bienvenido a su programa de gestion de empleados.\n");
        
        do {
            System.out.println(
            		  "C̲ontratar empleado (1)\n"
            		+ "Despedir empleado (2)\n"
            		+ "Aumentar salario (3)\n"
            		+ "Mostrar todos los empleados (4)\n"
            		+ "Salir del programa (5)\n");
            
            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nPor favor, ingrese una opción válida.\n");
                scanner.next(); // Limpiar el buffer de entrada
                continue;
            }

            switch (opcion) {
                case 1:
                	System.out.print("\nIngrese el nombre: ");
                    scanner.nextLine(); // Consumir el salto de línea pendiente
                    String empleadoContratado = scanner.nextLine();
                    System.out.print("Edad: ");
                    int edadEmpleado = scanner.nextInt();
                    System.out.print("Salario: ");
                    double salarioEmpleado = scanner.nextDouble();
                    empleados.add(empleadoContratado);
                    edades.put(empleadoContratado, edadEmpleado);
                    salarios.put(empleadoContratado, salarioEmpleado);
                    System.out.println("\nEmpleado contratado: " + empleadoContratado);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del empleado a despedir: ");
                    scanner.nextLine();
                    String empleadoDespedido = scanner.nextLine();
                    if (empleados.contains(empleadoDespedido)) {
                        empleados.remove(empleadoDespedido);
                        System.out.println(empleadoDespedido + " ha sido despedido.");
                    } else {
                        System.out.println("No se encontró al empleado en nómina.");
                    }
                    break;
                case 3:
                	System.out.print("\nIngrese el nombre del empleado al que desea aumentar el salario: ");
                	scanner.nextLine();
                    String empleadoAumento = scanner.nextLine();
                    if (empleados.contains(empleadoAumento)) {
                        System.out.print("Ingrese el porcentaje de aumento: ");
                        double porcentajeAumento = scanner.nextDouble();
                        double salarioActual = salarios.get(empleadoAumento);
                        double aumento = salarioActual * porcentajeAumento / 100;
                        double nuevoSalario = salarioActual + aumento;
                        salarios.put(empleadoAumento, nuevoSalario);
                        System.out.println("\nSe aumentó el salario de " + empleadoAumento + " en " + porcentajeAumento + "%");
                        System.out.println("Monto del aumento: " + formatoMoneda.format(aumento));
                        System.out.println("Nuevo salario: " + formatoMoneda.format(nuevoSalario));
                    } else {
                        System.out.println("No se encontró al empleado: " + empleadoAumento);
                    }
                    break;
                case 4:
                    System.out.printf("\n%-35s %-10s %-10s\n", "Nombre", "Edad", "Salario");
                    System.out.println("---------------------------------------------------------");
                    for (String empleado : empleados) {
                        int edad = edades.get(empleado);
                        double salario = salarios.get(empleado);
                        System.out.printf("%-35s %-10s %-15s\n", empleado, edad + " años", formatoMoneda.format(salario));
                        System.out.println("---------------------------------------------------------");
                    }
                    break;
                case 5:
                    System.out.println("\n¡Hasta luego!");
                    break;
                default:
                    System.out.println("\nPor favor, ingrese una opción válida.");
                    break;
            }
            System.out.println();
        } while (opcion != 5);
		
	}

}
