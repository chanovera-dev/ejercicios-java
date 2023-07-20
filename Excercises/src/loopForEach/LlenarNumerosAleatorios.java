package loopForEach;

public class LlenarNumerosAleatorios {
	public static void main(String[] args) {
		int[] matriz = new int[15];
		
		for(int i = 0; i < matriz.length; i++) {
			matriz[i] = (int) Math.round(Math.random()*100);
		}
		
		for(int numero : matriz) {
			System.out.print(numero + " ");
		}
	}
}
