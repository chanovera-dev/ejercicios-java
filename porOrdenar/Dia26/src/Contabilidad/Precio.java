package Contabilidad;

public class Precio {
	
	private double costo, impuesto;
	private String producto;

	public Precio(double costo, double impuesto, String producto) {
		
		this.costo = costo;
		this.impuesto = impuesto;
		this.producto = producto;
		
	}
	
	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public double getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}
	
}
