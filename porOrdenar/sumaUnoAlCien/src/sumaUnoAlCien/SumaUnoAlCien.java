package sumaUnoAlCien;

public class SumaUnoAlCien {

	public static void main(String[] args) {
        int suma = 1;
        
        for (int i = 2; i <= 100; i++) {
            suma += i;
            System.out.println("La suma de " + (suma - i) + " más " + i + " es " + suma + ".");
        }
        
        System.out.println("\nLa suma total de los números del 1 al 100 números es " + suma + ".");
    }
	
}
