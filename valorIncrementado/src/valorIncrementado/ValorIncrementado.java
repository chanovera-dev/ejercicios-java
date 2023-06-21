package valorIncrementado;

import java.util.Scanner;

public class ValorIncrementado {
	
	private int numero;
	
	public void incremenarNumero() {
		numero++;
	}
		
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		ValorIncrementado nuevoNumero = new ValorIncrementado(); 
		
		System.out.println("Binvenido al programa de incremento de número de 1 en 1.\nAgrega tu número a incrementar:");
		nuevoNumero.numero = input.nextInt();
		
		System.out.println("Tu número inicial fue: " + nuevoNumero.numero);
		
		nuevoNumero.incremenarNumero();
		
		System.out.println("Tu número incrementado es: " + nuevoNumero.numero);
		
		
	}
	
}
