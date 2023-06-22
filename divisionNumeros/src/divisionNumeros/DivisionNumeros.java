package divisionNumeros;

import java.util.Scanner;

public class DivisionNumeros {

	float num1, num2, cociente, residuo;
	int residuo2;
	double numeroReal;
	
	public void obtenerDatos() {
		Scanner input = new Scanner(System.in);
		System.out.println("Ingresa dos números entre 17 y 3, te entregaré el cociente, el residuo y su número real.\n\nIngresa los números:");
		num1 = input.nextFloat();
		num2 = input.nextFloat();
	}
	
	public void cociente() {
		cociente = num1/num2;
	}
	
	public void residuo() {
		residuo = num1%num2;
	}
	
	public void real() {
		numeroReal = (double) num1/ (double) num2;
	}
	
	public static void main(String[] args) {
		DivisionNumeros operacion = new DivisionNumeros();
		
		operacion.obtenerDatos();
		operacion.cociente();
		operacion.residuo();
		operacion.real();
		
		System.out.println("El cociente de " + operacion.num1 + " entre " + operacion.num2 + " es " + operacion.cociente + ".\nSu residuo es " + operacion.residuo + ".\nSu número real es " + operacion.numeroReal);
	}
}
