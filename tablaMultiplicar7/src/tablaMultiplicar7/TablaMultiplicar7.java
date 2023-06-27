
// Imprimir la tabla de multiplicar del 7 utilizando un ciclo for
package tablaMultiplicar7;

public class TablaMultiplicar7 {

	public static void main(String[] args) {
        int numero = 7;
        
        for (int i = 1; i <= 10; i++) {
            int resultado = numero * i;
            System.out.println(numero + " x " + i + " = " + resultado);
        }
    }
	
}
