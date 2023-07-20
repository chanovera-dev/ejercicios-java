package arrays;

public class Example {

	public static void main(String[] args) {
		int[] matriz1 = new int[5];
      //int matriz1[] = new int[5];
		
		matriz1[0] = 1;
		matriz1[1] = 2;
		matriz1[2] = 3;
		matriz1[3] = 4;
		matriz1[4] = 5;
		
		System.out.println(matriz1[0] + ", " + matriz1[1] + ", " + matriz1[2] + ", " + matriz1[3] + ", " + matriz1[4]);
		
		int[] matriz2 = {1, 2, 3, 4, 5};
	  //int matriz2[] = {1, 2, 3, 4, 5};                          	
		
		System.out.println(matriz2[0] + ", " + matriz2[1] + ", " + matriz2[2] + ", " + matriz2[3] + ", " + matriz2[4]);
		
		// recorrer una matriz con un ciclo for
		for(int i = 0; i < matriz1.length; i++) {
			System.out.println("Valor del índice " + i + ": " + matriz1[i]);
		}	
		
	}
	
}
