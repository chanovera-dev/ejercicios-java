package calcularNomina;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Nomina1 {
	
	DecimalFormat decimalFormat = new DecimalFormat("#.##########");
	DecimalFormat formatoMoneda = new DecimalFormat("#,###.00");
	Scanner input = new Scanner(System.in);
	
	double horasNomina = 0, horasExtras = 0, nominaNormal = 0, nominaExtra = 0, nomina = 0, pagoHoraNomina = 72.87, pagoHoraExtra = 72.87, impuestos = 0, nominaNeta = 0;

	public void obtenerDatos() {
		DecimalFormat decimalFormat = new DecimalFormat("#.##########");
		
		System.out.print("Ingrese sus horas trabajadas: ");
		horasNomina = input.nextDouble();
		
		String horasNominaFormat = decimalFormat.format(horasNomina);
		
		if (!horasNominaFormat.endsWith(".0000000000")) {
			horasNominaFormat = decimalFormat.format(horasNomina);
        }
		
		
		System.out.print("Ingrese sus horas extras: ");
		horasExtras = input.nextDouble();
		
		String horasExtrasFormat = decimalFormat.format(horasExtras);
		
		if (!horasExtrasFormat.endsWith(".0000000000")) {
			horasExtrasFormat = decimalFormat.format(horasExtras);
        }
	}
	
	public void operaciones() {
		DecimalFormat formatoMoneda = new DecimalFormat("#,###.00");
		
		nominaNormal = horasNomina * pagoHoraNomina;
		nominaExtra = horasExtras * pagoHoraExtra;
		nomina = nominaNormal + nominaExtra;
		
		String nominaFormat = formatoMoneda.format(nomina);
		
		if(nomina <= 2000) {
			impuestos = nomina * 0.18;
		} else {
			impuestos = nomina * 0.2;
		}
		
		String impuestosFormat = formatoMoneda.format(impuestos); 
		
		nominaNeta = nomina - impuestos;
		
		String nominaNetaFormat = formatoMoneda.format(nominaNeta);
	}
	
}
