package arraysBidimensionales;

public class InteresBancario {

	public static void main(String[] args) {
		double interes = .10;
		double acumulado;
		double [][] saldo = new double[6][5];
		
		for (int i = 0; i < 6; i ++) {
			
			saldo[i][0] = 10000;
			acumulado = 10000;
			
			for (int j = 1; j < 5; j++) {
				
				acumulado = acumulado + (acumulado * interes);
				saldo[i][j] = acumulado; 
			}
			
			interes = interes + 0.01;
		}
		
		for (int k = 0; k < 6; k++) {
			for (int l = 0; l < 5; l++) {
				System.out.printf("$%,1.2f  ", saldo[k][l]);
			}
			System.out.println();
		}
		

	}

}
