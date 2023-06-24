/*
 * Calcular nómina, ingresar el nombre y puesto del empleado
 * ingresar sus horas de trabajo, se le debe de pagar 72.87
 * ingresar su tiempo extra y se va a pagar 25.96 la hora
 * mostrar el sueldo bruto
 * Si el sueldo bruto es inferior a 2000 hacer un descuento de 16% de impuestos
 * Si es mayor a 2000 aplicar un 18%
 * Mostrar el sueldo neto
 * 
 */
package calcularNomina;

public class CalcularNomina {
	
	public static void main(String[] args) {
		
		DatosEmpleado empleado1 = new DatosEmpleado();
		Nomina1 nomina1 = new Nomina1();
		
		empleado1.obtenerDatos();
		nomina1.obtenerDatos();
		nomina1.operaciones();
		
		System.out.println(
				"\nEl nombre del empleado es " + empleado1.getNombre() + ", su puesto es " + empleado1.getPuesto() + ", esta quincena tuvo " + nomina1.getHorasNomina() + " horas en nómina y " + nomina1.getHorasExtras() + " horas extras.\n"
				+ "De acuerdo a sus horas trabajadas, su sueldo bruto es de $" + nomina1.getNomina() + " y le toca pagar $" + nomina1.getImpuestos() + " por concepto de impuestos.\n"
				+ "Su sueldo neto es de $" + nomina1.getNominaNeta() + ".");
		
	}

}
