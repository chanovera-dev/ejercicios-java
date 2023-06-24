package calcularNomina;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Nomina1 {
	
	//DecimalFormat decimalFormat = new DecimalFormat("#.##########");
	//DecimalFormat formatoMoneda = new DecimalFormat("#,###.00");
	Scanner input = new Scanner(System.in);
	
	double horasNomina = 0, horasExtras = 0, nominaNormal = 0, nominaExtra = 0, nomina = 0, pagoHoraNomina = 72.87, pagoHoraExtra = 72.87, impuestos = 0, nominaNeta = 0;

	public void obtenerDatos() {
		//DecimalFormat decimalFormat = new DecimalFormat("#.##########");
		Nomina1 datosNomina = new Nomina1();
		
		System.out.print("Ingrese sus horas trabajadas: ");
		horasNomina = input.nextDouble();
		datosNomina.setHorasNomina(horasNomina);
		
		//String horasNominaFormat = decimalFormat.format(horasNomina);
		
		//if (!horasNominaFormat.endsWith(".0000000000")) {
		//	horasNominaFormat = decimalFormat.format(horasNomina);
        //}
		
		
		System.out.print("Ingrese sus horas extras: ");
		horasExtras = input.nextDouble();
		datosNomina.setHorasExtras(horasExtras);
		
		//String horasExtrasFormat = decimalFormat.format(horasExtras);
		
		//if (!horasExtrasFormat.endsWith(".0000000000")) {
		//	horasExtrasFormat = decimalFormat.format(horasExtras);
        //}
	}

	public void operaciones() {
		Nomina1 datosNomina = new Nomina1();
		
		nominaNormal = horasNomina * pagoHoraNomina;
		nominaExtra = horasExtras * pagoHoraExtra;
		nomina = nominaNormal + nominaExtra;
		datosNomina.setNomina(nomina);
		
		//String nominaFormat = formatoMoneda.format(nomina);
		
		if(nomina <= 2000) {
			impuestos = nomina * 0.18;
			datosNomina.setImpuestos(impuestos);
		} else {
			impuestos = nomina * 0.2;
			datosNomina.setImpuestos(impuestos);
		}
		
		//String impuestosFormat = formatoMoneda.format(impuestos); 
		
		nominaNeta = nomina - impuestos;
		datosNomina.setNominaNeta(nominaNeta);
		
		//String nominaNetaFormat = formatoMoneda.format(nominaNeta);
	}
	
	// método get
	public double getHorasNomina() {
		return horasNomina;
	}
	
	public double getHorasExtras() {
		return horasExtras;
	}
	
	public double getNomina() {
		return nomina;
	}
	
	public double getImpuestos() {
		return impuestos;
	}
	
	public double getNominaNeta() {
		return nominaNeta;
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
