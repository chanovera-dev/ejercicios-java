package loopForEach;

public class Example {

	public static void main(String[] args) {
		
		String [] paises = {"España","México","Colombia","Perú","Chile","Argentina","Ecuador","Venezuela"};
		
		// bucle for
		for(int i = 0; i < paises.length; i++) {
			System.out.println("Pais " + (i + 1) + ": " + paises[i]);
		}
		
		//bucle for each
		int numeroPais = 1;
		for(String pais : paises) {
			System.out.println("Pais "+ (numeroPais++) + ": " + pais);
		}
	}

}
