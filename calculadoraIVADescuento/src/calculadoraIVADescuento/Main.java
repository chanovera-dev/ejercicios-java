package calculadoraIVADescuento;

public class Main {
	
	public static void main(String[] args) {
		Dinero dinero = new Dinero();
		System.out.println("Bienvenido a la calculadora que te agrega un impuesto según tu cantidad.\n");
		
		dinero.obtenerDato();
		
		dinero.revisarDato();
		
		dinero.aplicarImpuesto();
		
		System.out.println("\nTe toca pagar $" + dinero.getImpuesto() + " por concepto de IVA, así que te quedan $" + (dinero.getCantidad() - dinero.getImpuesto()));
	} 

}
