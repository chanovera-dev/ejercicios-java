package puntoFlotante;

public class PuntoFlotante {

	private float numero;
	
	public void NumFlotante(float numero) {
		this.numero = numero;
	}
	
	public int obtenerParte() {
		return (int) this.numero;
	}
	
	public float redondear(int decimal) {
		float factor = (float) Math.pow(10, decimal);
		return Math.round(this.numero * factor) / factor;
	}
	
	public static void main(String[] args) {
		PuntoFlotante num = new PuntoFlotante();
		num.NumFlotante(3.141592f);
		
		System.out.println("Parte entera es: " + num.obtenerParte());
		System.out.println("Redondeo a dos decimales: " + num.redondear(2));
	}
}
