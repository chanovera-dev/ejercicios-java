package conversionMonedas;

public class Main {
	
	public static void main(String[] args) {
		
		Monedas monedas = new Monedas();
		
		System.out.println("\"Bienvenido a su programa de conversión de monedas, puede convertir entre soles, pesos, dólares y quetzales.\\n\\n\"");
		
		monedas.obtenerDatos();
		
		monedas.operaciones();
		
		System.out.println("\nTus $" + monedas.getCantidadConvertirMoneda() + " " + monedas.getMoneda1() + " enquivalen a $" + monedas.getResultadoMoneda() + " " + monedas.getMoneda2() + ".");
		
		
	}

}
