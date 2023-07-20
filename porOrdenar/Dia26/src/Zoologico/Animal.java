package Zoologico;

public class Animal {

	private String nombre, tipo_alimentacion;
	private int edad;
	private double peso;
	
	public Animal(String nombre, String tipo_alimentacion, int edad, double peso) {
		this.nombre = nombre;
		this.tipo_alimentacion = tipo_alimentacion;
		this.edad = edad;
		this.peso = peso;
	}
	
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo_alimentacion() {
		return tipo_alimentacion;
	}

	public void setTipo_alimentacion(String tipo_alimentacion) {
		this.tipo_alimentacion = tipo_alimentacion;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	
}