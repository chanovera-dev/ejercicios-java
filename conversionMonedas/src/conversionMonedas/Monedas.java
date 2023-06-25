package conversionMonedas;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Monedas {
	
	int tipoMoneda1 = 0, tipoMoneda2 = 0;
	String moneda1 = "moneda1", moneda2 = "moneda2";
	double cantidadConvertir = 0, paso1 = 0, resultado = 0;
	boolean validacion = false, validacion2 = false;
	private DecimalFormat resultadoMoneda, cantidadConvertirMoneda;
	
	public void obtenerDatos() {
		
		Scanner input = new Scanner(System.in);
		Monedas monedas = new Monedas();
	
		System.out.println(
				  "Escoja el tipo de moneda que desee convertir:\n\n"
				+ "1 para soles.\n"
				+ "2 para pesos.\n"
				+ "3 para dólares.\n"
				+ "4 para quetzales.\n");
		tipoMoneda1 = input.nextInt();
		monedas.setTipoMoneda1(tipoMoneda1);
		
		while (!validacion) {
			switch (tipoMoneda1) {
				case 1:
					System.out.println("\nHas escogido el tipo de moneda soles.\n");
					moneda1 = "soles";
					monedas.setMoneda1(moneda1);
					validacion = true;
					break;
				case 2:
					System.out.println("\nHas escogido el tipo de moneda pesos.\n");
					moneda1 ="pesos";
					monedas.setMoneda1(moneda1);
					validacion = true;
					break;
				case 3:
					System.out.println("\nHas escogido el tipo de moneda dólares.\n");
					moneda1 = "dólares";
					monedas.setMoneda1(moneda1);
					validacion = true;
					break;
				case 4:
					System.out.println("\nHas escogido el tipo de moneda quetzales.\n");
					validacion = true;
					moneda1 = "quetzales";
					monedas.setMoneda1(moneda1);
					break;
				default:
					System.out.print("\nHas escogido un número no válido, intenta de nuevo: ");
					tipoMoneda1 = input.nextInt();
					break;
			}
		}
		
		System.out.print("Ingrese el tipo de moneda al que desee convertir:\n\n"
				+ "1 para soles.\n"
				+ "2 para pesos.\n"
				+ "3 para dólares.\n"
				+ "4 para quetzales.\n\n");
		tipoMoneda2 = input.nextInt();
		monedas.setTipoMoneda2(tipoMoneda2);
		
		while (!validacion2) {
			switch (tipoMoneda2) {
				case 1:
					System.out.println("\nHas escogido el tipo de moneda soles.\n");
					moneda2 = "soles";
					monedas.setMoneda2(moneda2);
					validacion2 = true;
					break;
				case 2:
					System.out.println("\nHas escogido el tipo de moneda pesos.\n");
					moneda2 ="pesos";
					monedas.setMoneda2(moneda2);
					validacion2 = true;
					break;
				case 3:
					System.out.println("\nHas escogido el tipo de moneda dólares.\n");
					moneda2 = "dólares";
					monedas.setMoneda2(moneda2);
					validacion2 = true;					
					break;
				case 4:
					System.out.println("\nHas escogido el tipo de moneda quetzales.\n");
					moneda2 = "quetzales";
					monedas.setMoneda2(moneda2);
					validacion2 = true;
					break;
				default:
					System.out.print("\nHas escogido un número no válido, intenta de nuevo: ");
					tipoMoneda2 = input.nextInt();
					break;
			}
		}
		
		System.out.print("¿Cuántos " + moneda1 + " tienes? ");
		cantidadConvertir = input.nextDouble();
		monedas.setCantidadConvertir(cantidadConvertir);
		
		switch (tipoMoneda1) {
			case 1:
				paso1 = cantidadConvertir * 0.28;
				monedas.setPaso1(paso1);
				break;
			case 2:
				paso1 = cantidadConvertir * 0.058;
				monedas.setPaso1(paso1);
				break;
			case 3:
				paso1 = cantidadConvertir * 1;
				monedas.setPaso1(paso1);
				break;
			case 4:
				paso1 = cantidadConvertir * 0.13;
				monedas.setPaso1(paso1);
				break;
		}
		
		input.close();
		
	}
	
	public void operaciones() {
		resultadoMoneda = new DecimalFormat("#,##0.00");
		cantidadConvertirMoneda = new DecimalFormat("#,##0.00");
		Monedas monedas = new Monedas();
		
		switch (tipoMoneda2) {
			case 1:
				resultado = paso1 * 3.61;
				monedas.setResultado(resultado);
				break;
			case 2:
				resultado = paso1 * 17.16;
				monedas.setResultado(resultado);
				break;
			case 3:
				resultado = paso1 * 1;
				monedas.setResultado(resultado);
				break;
			case 4:
				resultado = paso1 * 7.79;
				monedas.setResultado(resultado);
				break;
		}
	}

	// método get
	public int getTipoMoneda1() {
		return tipoMoneda1;
	}
	
	public int getTipoMoneda2() {
		return tipoMoneda2;
	}
	
	public String getMoneda1() {
		return moneda1;
	}
	
	public String getMoneda2() {
		return moneda2;
	}
	
	public double getCantidadConvertir() {
		return cantidadConvertir;
	}
	
	public double getPaso1() {
		return paso1;
	}
	
	public double getResultado() {
		return resultado;
	}
	
	// método set
	private void setTipoMoneda1(int tipoMoneda1) {
		this.tipoMoneda1 = tipoMoneda1;
	}
	
	private void setTipoMoneda2(int tipoMoneda2) {
		this.tipoMoneda2 = tipoMoneda2;
	}
	
	private void setMoneda1(String moneda1) {
		this.moneda1 = moneda1;
	}
	
	private void setMoneda2(String moneda2) {
		this.moneda2 = moneda2;
	}
	
	private void setCantidadConvertir(double cantidadConvertir) {
		this.cantidadConvertir = cantidadConvertir; 
	}
	
	public String getCantidadConvertirMoneda() {
        return cantidadConvertirMoneda.format(cantidadConvertir);
    }
	
	private void setPaso1(double paso1) {
		this.paso1 = paso1;
	}
	
	private void setResultado(double resultado) {
		this.resultado = resultado;
	}
	
	public String getResultadoMoneda() {
        return resultadoMoneda.format(resultado);
    }
}
