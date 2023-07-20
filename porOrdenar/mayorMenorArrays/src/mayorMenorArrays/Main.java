package mayorMenorArrays;

// crear un array de 10 números, imprimir de mayor a menor.
// ingresar 10 números, imprimir una vez y después de mayor a menor.

public class Main {

	public static void main(String[] args) {
		
		Numeros operaciones = new Numeros();
		
		operaciones.ordenaNumeros1();
		
		operaciones.imprimeMayorMenor1();
		
        // espaciado
        System.out.println("\n");
        
        operaciones.capturaNumeros2();
        
        // espaciado
        System.out.println("\n");
        
        operaciones.imprimeNumeros2();
        
        // espaciado
        System.out.println("\n");
        
        operaciones.ordenaNumerosCapturados();
        
        operaciones.imprimeNumeros2();
		
	}
	
}
