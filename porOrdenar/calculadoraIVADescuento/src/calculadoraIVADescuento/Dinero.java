package calculadoraIVADescuento;

import java.util.Scanner;

public class Dinero {
	
	double cantidad = 0, impuesto = 0;
	
	public void obtenerDato() {
		
		Dinero dinero = new Dinero();
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Ingresa tu cantidad de dinero: ");
		cantidad = input.nextDouble();
		dinero.setCantidad(cantidad);
		
		input.close();
		
	}
	
	public void revisarDato() {
		
		if(cantidad >= 50) {
			System.out.println("\nChico, $" + cantidad + " es mucho dinero, te toca un impuesto del 10%.");
		} else {
			System.out.println("\nMi pana, $" + cantidad + " es muy poquito, te toca un impuesto del 5%.");
		}
	}
	
	public void aplicarImpuesto() {
		
		Dinero dinero = new Dinero();
		
		if(cantidad >= 50) {
			impuesto = cantidad * .1;
			dinero.setImpuesto(impuesto);
		} else {
			impuesto = cantidad * .05;
			dinero.setImpuesto(impuesto);
		}
		
	}
	
	// método set
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}
	
	// método get
	public double getCantidad() {
		return cantidad;
	}
	
	public double getImpuesto() {
		return impuesto;
	}
	
}
