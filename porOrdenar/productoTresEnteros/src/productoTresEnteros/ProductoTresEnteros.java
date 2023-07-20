package productoTresEnteros;

import java.util.Scanner;

public class ProductoTresEnteros {
	
	public void producto() {
		
		int entero1, entero2, entero3, product;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Bienvenido al programa que multiplica tres enteros.\n\nIngresa tres números enteros:");
		entero1 = input.nextInt();
		entero2 = input.nextInt();
		entero3 = input.nextInt();
		
		product = Math.multiplyExact(entero1, Math.multiplyExact(entero2, entero3));
		
		System.out.println("El producto de " + entero1 + ", " + entero2 + " y " + entero3 + " es igual a " + product);
	}
	
	public static void main(String[] args) {
		ProductoTresEnteros salida = new ProductoTresEnteros();
		salida.producto();
	}

}
