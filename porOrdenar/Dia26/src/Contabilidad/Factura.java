package Contabilidad;

public class Factura extends Precio {

	private String emisor, cliente;
	
	public Factura(double costo, double impuesto, String producto, String emisor, String cliente) {
		super(costo, impuesto, producto);
		this.emisor = emisor;
		this.cliente = cliente;
	}
	
	public void imprimir_factura() {

		System.out.printf("Cliente: %s, Emisor: %s, Costo: $%,.2f, Impuesto: $%,.2f, Producto: %s.", getCliente(), getEmisor(), getCosto(), getImpuesto(), getProducto());

	}

	public String getEmisor() {
		return emisor;
	}

	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	
}
