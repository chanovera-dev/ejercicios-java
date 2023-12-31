package calcularNomina;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Nomina1 {
	
	Scanner input = new Scanner(System.in);
	
	double horasNomina = 0, horasExtras = 0, nominaNormal = 0, nominaExtra = 0, nomina = 0, pagoHoraNomina = 72.87, pagoHoraExtra = 72.87, impuestos = 0, nominaNeta = 0;
	private DecimalFormat nominaNetaMoneda, impuestosDecimal, nominaMoneda, horasNominaDecimal, horasExtrasDecimal;
	 
	public void obtenerDatos() {
		Nomina1 datosNomina = new Nomina1();
		
		System.out.print("Ingrese sus horas trabajadas: ");
		horasNomina = input.nextDouble();
		datosNomina.setHorasNomina(horasNomina);
		
		System.out.print("Ingrese sus horas extras: ");
		horasExtras = input.nextDouble();
		datosNomina.setHorasExtras(horasExtras);
	}

	public void operaciones() {
		nominaNetaMoneda = new DecimalFormat("#,##0.00"); // este es formato de moneda
		impuestosDecimal = new DecimalFormat("#,##0.00");
		nominaMoneda = new DecimalFormat("#,##0.00");
		horasNominaDecimal = new DecimalFormat("#.##########"); // formato de referencia
		horasExtrasDecimal = new DecimalFormat("#.##########"); // borra el .0 en el double
		Nomina1 datosNomina = new Nomina1();
		
		nominaNormal = horasNomina * pagoHoraNomina;
		nominaExtra = horasExtras * pagoHoraExtra;
		nomina = nominaNormal + nominaExtra;
		datosNomina.setNomina(nomina);
		
		if(nomina <= 2000) {
			impuestos = nomina * 0.18;
			datosNomina.setImpuestos(impuestos);
		} else {
			impuestos = nomina * 0.2;
			datosNomina.setImpuestos(impuestos);
		}
		
		nominaNeta = nomina - impuestos;
		datosNomina.setNominaNeta(nominaNeta);
	}
	
	// método get
	public double getHorasNomina() {
		return horasNomina;
	}
	
	public String getHorasNominaDecimal() {					// convierte el número double
        return horasNominaDecimal.format(horasNomina);		// al formato indicado en la clase
    }
	
	public double getHorasExtras() {
		return horasExtras;
	}
	
	public String getHorasExtrasDecimal() {
        return horasExtrasDecimal.format(horasExtras);
    }
	
	public double getNomina() {
		return nomina;
	}
	
	public String getNominaMoneda() {
        return nominaMoneda.format(nomina);
    }
	
	public double getImpuestos() {
		return impuestos;
	}
	
	public String getImpuestosMoneda() {
        return impuestosDecimal.format(impuestos);
    }
	
	public double getNominaNeta() {
		return nominaNeta;
	}
	
	public String getNominaNetaMoneda() {
        return nominaNetaMoneda.format(nominaNeta);
    }
	
	// método set
	private void setHorasNomina(double horasNomina) {
		this.horasNomina = horasNomina;
	}
	
	
	private void setHorasExtras(double horasExtras) {
		this.horasExtras = horasExtras;
	}
	
	private void setNomina(double nomina) {
		this.nomina = nomina;
	}
	
	private void setImpuestos(double impuestos) {
		this.impuestos = impuestos;
	}
	
	private void setNominaNeta(double nominaNeta) {
		this.nominaNeta = nominaNeta;
	}
	
}
