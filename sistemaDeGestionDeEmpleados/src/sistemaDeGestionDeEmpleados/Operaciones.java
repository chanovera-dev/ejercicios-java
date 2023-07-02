package sistemaDeGestionDeEmpleados;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class Operaciones {
	
	private Scanner scanner;
	private ArrayList<String> empleados;
    private HashMap<String, Integer> edades;
    private HashMap<String, Double> salarios;
    private NumberFormat formatoMoneda;
    private String empleadoContratado;
    private int edadEmpleado;
    private double salarioEmpleado;
    private double porcentajeAumento;
    private double salarioActual;
    private double aumento;
    private double nuevoSalario;
    private int edad;
    private double salario;
    private String mensajeSalir;

	public Operaciones() {
		this.scanner = new Scanner(System.in);
		this.empleados = new ArrayList<>();
		this.edades = new HashMap<>();
		this.salarios = new HashMap<>();
		this.formatoMoneda = NumberFormat.getCurrencyInstance(Locale.getDefault());
		this.empleadoContratado = empleadoContratado;
		this.edadEmpleado = edadEmpleado;
		this.salarioEmpleado = salarioEmpleado;
		this.porcentajeAumento = porcentajeAumento;
		this.salarioActual = salarioActual;
		this.aumento = aumento;
		this.nuevoSalario = nuevoSalario;
		this.edad = edad;
		this.salario = salario;
		this.mensajeSalir = "Presiona Enter para salir.\n";
	}

	public void contratarEmpleado() {
		// nombre del nuevo empleado
		System.out.print("\nIngrese el nombre: ");
        empleadoContratado = scanner.nextLine();
        
        // edad del nuevo empleado
        System.out.print("Edad: ");
        edadEmpleado = scanner.nextInt();
        
        // salario del nuevo empleado
        System.out.print("Salario: ");
        salarioEmpleado = scanner.nextDouble();
        
        empleados.add(empleadoContratado);
        edades.put(empleadoContratado, edadEmpleado);
        salarios.put(empleadoContratado, salarioEmpleado);
        System.out.println("\nHas contratado a " + empleadoContratado + ".\n");
		
        scanner.nextLine(); // arreglo para poder escribir el nombre del nuevo empleado con espacios. Se pone aquí para que no sea necesario un enter al ingresarlo
	}

	public void despedirEmpleado() {
		System.out.print("Ingrese el nombre del empleado a despedir: ");
        String empleadoDespedido = scanner.nextLine();
        if (empleados.contains(empleadoDespedido)) {
            empleados.remove(empleadoDespedido);
            System.out.println(empleadoDespedido + " ha sido despedido.");
            System.out.println("Presiona Enter para salir.\n");
        } else {
            System.out.println("No se encontró al empleado en nómina.");
            System.out.println(mensajeSalir);
        }
        scanner.nextLine(); // arreglo para poder escribir el nombre del empleado con espacios. Se pone aquí para que no sea necesario un enter al ingresarlo
	}

	public void aumentarSalario() {
		System.out.print("\nIngrese el nombre del empleado al que desea aumentar el salario: ");
        String empleadoAumento = scanner.nextLine();
        if (empleados.contains(empleadoAumento)) {
            System.out.print("Ingrese el porcentaje de aumento: ");
            porcentajeAumento = scanner.nextDouble();
            salarioActual = salarios.get(empleadoAumento);
            aumento = salarioActual * porcentajeAumento / 100;
            nuevoSalario = salarioActual + aumento;
            salarios.put(empleadoAumento, nuevoSalario);
            System.out.println("\nSe aumentó el salario de " + empleadoAumento + " en " + porcentajeAumento + "%");
            System.out.println("Monto del aumento: " + formatoMoneda.format(aumento));
            System.out.println("Nuevo salario: " + formatoMoneda.format(nuevoSalario) + "\n");
        } else {
            System.out.println("No se encontró al empleado: " + empleadoAumento);
            System.out.println(mensajeSalir);
        }
        scanner.nextLine(); // arreglo para poder escribir el nombre del empleado con espacios. Se pone aquí para que no sea necesario un enter al ingresarlo
	}

	public void mostrarEmpleados() {
		System.out.printf("\n%-35s %-10s %-10s\n", "Nombre", "Edad", "Salario");
        System.out.println("-------------------------------------------------------------------");
        for (String empleado : empleados) {
            edad = edades.get(empleado);
            salario = salarios.get(empleado);
            System.out.printf("%-35s %-10s %-15s\n", empleado, edad + " años", formatoMoneda.format(salario) + " mensuales");
            System.out.println("-------------------------------------------------------------------");
        }
        System.out.println("\n");
	}
	
}
