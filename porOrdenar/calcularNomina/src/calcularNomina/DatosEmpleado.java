package calcularNomina;

import java.util.Scanner;

public class DatosEmpleado {
	private String nombre, puesto;
	
	Scanner input = new Scanner(System.in);
	
	public void Empleado(String nombre, String puesto) {
		this.nombre = nombre;
		this.puesto = puesto;
	}
	
	public void obtenerDatos() {
		DatosEmpleado datosEmpleado = new DatosEmpleado();
		
		System.out.print("Bienvenido al programa del cálculo de nómina, ingrese su nombre: ");
		nombre = input.nextLine();
		datosEmpleado.setNombre(nombre);
		
		System.out.print("Ingrese su puesto: ");
		puesto = input.nextLine();
		datosEmpleado.setPuesto(puesto);
	}
	
	// método get
	public String getNombre() {
		return nombre;
	}
	
	public String getPuesto() {
		return puesto;
	}
	
	// método set
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
}
