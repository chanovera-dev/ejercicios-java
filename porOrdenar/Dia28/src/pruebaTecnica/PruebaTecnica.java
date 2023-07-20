package pruebaTecnica;

public class PruebaTecnica {

	public static void main(String[] args) {
		int[] vector = {2, 4, 6, 8, 3};
		boolean validacion = false;
		
		for(int i = 0; i < vector.length; i++) {
			for(int j = i + 1; j < vector.length; j++) {
				if (vector[i] + vector[j] == 10) {
					System.out.println("Sí hay elementos que al sumarse den 10.");
					validacion = true;
					break;
				}
			}
			
			if(validacion) { break; }
		}
		
		if(!validacion) {
			System.out.println("No hay elementos que al sumarse den 10.");
		}

	}

}
