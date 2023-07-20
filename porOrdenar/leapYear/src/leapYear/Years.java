package leapYear;

import java.util.Scanner;

public class Years {
	
	int year = 0;
	
	public void obtenerDatos() {
		Scanner input = new Scanner(System.in);
		Years years = new Years();
		
		System.out.print("Ingrese su año para determinar si es bisiesto: ");
		year = input.nextInt();
		years.setYear(year);
		
		input.close();
	}

	private void setYear(int year) {
		this.year = year;
	}
	
	public int getYear() {
		return year;
	}
	
}
