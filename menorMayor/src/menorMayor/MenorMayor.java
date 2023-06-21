package menorMayor;

import java.util.Scanner;

public class MenorMayor {
	
	public int CalculoNumeroMayor(int num1, int num2, int num3) {
		int numeroMayor;
		
		if(num1 > num2 && num1 > num3) {
			numeroMayor = num1;
		} else {
			if (num2 > num3) {
				numeroMayor = num2;
			} else {
				numeroMayor = num3;
			}
		}
		
		return numeroMayor;
	}
	
	public int CalculoNumeroMenor(int num1, int num2, int num3) {
		int numeroMenor;
		
		if(num1 < num2 && num1 < num3) {
			numeroMenor = num1;
		} else {
			if (num2 < num3) {
				numeroMenor = num2;
			} else {
				numeroMenor = num3;
			}
		}
		
		return numeroMenor;
	}
	
	public void entradaNumeros() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Bienvenido al programa que identifica el mayor y el menor de tres números.\n\nA continuación ingresa tres números:");
		int num1 = input.nextInt();
		int num2 = input.nextInt();
		int num3 = input.nextInt();
		
		int numeroMayor, numeroMenor;
		
		numeroMayor = CalculoNumeroMayor(num1, num2, num3);
		numeroMenor = CalculoNumeroMenor(num1, num2, num3);
		
		System.out.println("El número mayor es " + numeroMayor + " y el número menor es " + numeroMenor + ".");
	}
	
	
	
	public static void main(String[] args) {
		
		MenorMayor resultado = new MenorMayor();
		resultado.entradaNumeros();
		
	}

}
