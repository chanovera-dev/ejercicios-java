package ejemplosCiclos;

public class EjemplosCiclos {

	public static void main(String[] args) {
		
		int numero = 0;
		int suma = 0;
		
		String[] tendre = {"iPad Pro 14\"", "Macbook Pro M2 16\"", "iPhone 15 Pro Max", "Mac Studio Ultra"};
		
		for (int i = 0; i < tendre.length; i++) {
			String productos = tendre[i];
			
			System.out.println("Tendré un " + productos);
		}
		
	}
	
}
