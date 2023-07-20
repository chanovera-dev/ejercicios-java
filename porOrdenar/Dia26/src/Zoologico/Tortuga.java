package Zoologico;

public class Tortuga extends Animal {

	private String tipo_habitat;
	
	public Tortuga(String nombre, String tipo_alimentacion, int edad, double peso, String tipo_habitat) {
		super(nombre, tipo_alimentacion, edad, peso);
		this.tipo_habitat = tipo_habitat;
	}

	public String getTipo_habitat() {
		return tipo_habitat;
	}

	public void setTipo_habitat(String tipo_habitat) {
		this.tipo_habitat = tipo_habitat;
	}
	
	public void mostrar() {
		System.out.println(getNombre() + " - " + getTipo_alimentacion() + " - " + getEdad() + " - " + getPeso() + " - " + getTipo_habitat());
	}

}
