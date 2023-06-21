package menorMayor;

import java.util.Scanner;

public class MenorMayor {
	
	/*
	public byte CalculoNumeroMayor(int num1, int num2, int num3) {
		byte numeroMayor;
		
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
	
	public byte CalculoNumeroMenor(byte num1, byte num2, byte num3) {
		byte numeroMenor;
		
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
	*/
	
	public void entradaNumeros() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Bienvenido al programa que identifica el mayor y el menor de tres números.\n\nA continuación ingresa tres números:");
		byte num1 = input.nextByte();
		byte num2 = input.nextByte();
		byte num3 = input.nextByte();
		
		byte numeroMayor, numeroMenor;
		
		// numeroMayor = CalculoNumeroMayor(num1, num2, num3);
		// numeroMenor = CalculoNumeroMenor(num1, num2, num3);
		
		numeroMayor = (byte) Math.max(num1, Math.max(num2, num3));
		numeroMenor = (byte) Math.min(num1, Math.min(num2, num3));
		
		System.out.println("El número mayor es " + numeroMayor + " y el número menor es " + numeroMenor + ".");
	}
	
	
	
	public static void main(String[] args) {
		
		MenorMayor resultado = new MenorMayor();
		resultado.entradaNumeros();
		
	}

}
