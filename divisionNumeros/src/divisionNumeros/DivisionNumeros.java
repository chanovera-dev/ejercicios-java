package divisionNumeros;

import java.util.Scanner;
import java.text.DecimalFormat;

public class DivisionNumeros {

	float num1, num2, cociente, residuo;
	int residuo2;
	double numeroReal;
	String texto;
	boolean validacion1 = false;
	boolean validacion2 = false;
	
	public void obtenerDatos() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Ingresa dos números entre 17 y 3, te entregaré el cociente, el residuo y su número real.\n\nIngresa el primer número:");
		
		while (!validacion1) {
            if (input.hasNextFloat()) {
                num1 = input.nextFloat();
                validacion1 = true;
            } else {
                texto = input.next();
                System.out.println("Has ingresado un texto, por favor, ingresa un número.");
            }
        }
		
		System.out.println("Ingresa el segundo número:");

		while (!validacion2) {
            if (input.hasNextFloat()) {
                num2 = input.nextFloat();
                validacion2 = true;
            } else {
                texto = input.next();
                System.out.println("Has ingresado un texto, por favor, ingresa un número.");
            }
        }
		
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
		
		DecimalFormat decimalFormat = new DecimalFormat("#.##########");
		
		String num1Formateado = decimalFormat.format(operacion.num1);
		String num2Formateado = decimalFormat.format(operacion.num2);
        String cocienteFormateado = decimalFormat.format(operacion.cociente);
        String residuoFormateado = decimalFormat.format(operacion.residuo);
        String realFormateado = decimalFormat.format(operacion.numeroReal);
        
        if (!num1Formateado.endsWith(".0000000000")) {
        	num1Formateado = decimalFormat.format(operacion.num1);
        }
        
        if (!num2Formateado.endsWith(".0000000000")) {
        	num2Formateado = decimalFormat.format(operacion.num2);
        }
        
        if (!cocienteFormateado.endsWith(".0000000000")) {
        	cocienteFormateado = decimalFormat.format(operacion.cociente);
        }
        
        if (!residuoFormateado.endsWith(".0000000000")) {
        	residuoFormateado = decimalFormat.format(operacion.residuo);
        }
        
        if (!realFormateado.endsWith(".0000000000")) {
        	realFormateado = decimalFormat.format(operacion.numeroReal);
        }
        
		
		System.out.println("El cociente de " + num1Formateado + " entre " + num2Formateado + " es " + cocienteFormateado + ".\nSu residuo es " + residuoFormateado + ".\nSu número real es " + realFormateado);
	}
}