package calcularNomina;

public class CalcularNomina {
	
	public static void main(String[] args) {
		
		DatosEmpleado empleado1 = new DatosEmpleado();
		Nomina1 nomina1 = new Nomina1();
		
		empleado1.obtenerDatos();
		nomina1.obtenerDatos();
		nomina1.operaciones();
		
		System.out.println(
				"\nEl nombre del empleado es " + empleado1.getNombre() + ", su puesto es " + empleado1.getPuesto() + ", esta quincena tuvo " + nomina1.getHorasNominaDecimal() + " horas en nómina y " + nomina1.getHorasExtrasDecimal() + " horas extras.\n"
				+ "De acuerdo a sus horas trabajadas, su sueldo bruto es de $" + nomina1.getNominaMoneda() + " y le toca pagar $" + nomina1.getImpuestosMoneda() + " por concepto de impuestos.\n"
				+ "Su sueldo neto es de $" + nomina1.getNominaNetaMoneda() + ".");
	}

}
