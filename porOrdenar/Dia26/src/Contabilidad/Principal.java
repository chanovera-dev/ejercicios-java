package Contabilidad;

public class Principal {

	public static void main(String[] args) {
		
		Factura factura = new Factura(19826, 3173, "Macbok Air M1", "Apple Inc", "Cristian Vera");

		factura.imprimir_factura();
	}

}
