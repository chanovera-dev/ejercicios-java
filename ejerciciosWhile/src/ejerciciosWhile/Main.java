package ejerciciosWhile;

public class Main {
	
	static double buscarNumero = 0;
	
	public static void main(String[] args) {
		
		Numeros numeros = new Numeros();
		
		numeros.obtenerDatos();
		
		numeros.ordenaNumerosCapturados();
		
		System.out.println("\n");
		
		numeros.imprimeNumeros();
		
		System.out.println("\n");
		
		numeros.imprimirMenorMayor();
		
		System.out.println("\n");
		
		numeros.buscarNumero();
	}
	
}
