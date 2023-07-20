package Zoologico;

public class Perro extends Animal {
	
	private String raza;

	public Perro(String nombre, String tipo_alimentacion, int edad, double peso, String raza) {
		super(nombre, tipo_alimentacion, edad, peso);
		this.raza = raza;
	}
	
	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}
	
	public void mostrar() {
		System.out.println(getNombre() + " - " + getTipo_alimentacion() + " - " + getEdad() + " - " + getPeso() + " - " + getRaza());
	}

}
