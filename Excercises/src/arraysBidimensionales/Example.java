package arraysBidimensionales;

public class Example {

	public static void main(String[] args) {
		//declarada la matriz
		int [][] matrizBidimensional = new int [4][5];
		
		// llenado de la matriz
		matrizBidimensional[0][0] = 1;
		matrizBidimensional[0][1] = 2;
		matrizBidimensional[0][2] = 3;
		matrizBidimensional[0][3] = 4;
		matrizBidimensional[0][4] = 5;
		
		matrizBidimensional[1][0] = 6;
		matrizBidimensional[1][1] = 7;
		matrizBidimensional[1][2] = 8;
		matrizBidimensional[1][3] = 9;
		matrizBidimensional[1][4] = 10;
		
		matrizBidimensional[2][0] = 11;
		matrizBidimensional[2][1] = 12;
		matrizBidimensional[2][2] = 13;
		matrizBidimensional[2][3] = 14;
		matrizBidimensional[2][4] = 15;
		
		matrizBidimensional[3][0] = 16;
		matrizBidimensional[3][1] = 17;
		matrizBidimensional[3][2] = 18;
		matrizBidimensional[3][3] = 19;
		matrizBidimensional[3][4] = 20;
		
		// recorrer el array
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print(matrizBidimensional[i][j] + " ");
			}
			System.out.println();
		}
		
		// declarada y llenada
		int [][] matrixBidimensional2 = {
				{1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15},
				{16,17,18,19,20}
		};
		
		// con ciclo for
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print(matrixBidimensional2[i][j] + " ");
			}
			System.out.println();
		}
		
		// con ciclo for eaach
		for(int[]fila : matrizBidimensional) {
			for(int columna : fila) {
				System.out.print(columna + " ");
			}
			System.out.println();
		}
	}

}
