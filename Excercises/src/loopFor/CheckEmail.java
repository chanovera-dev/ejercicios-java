package loopFor;

import java.util.Scanner;

public class CheckEmail {

    public static void main(String[] args) {
    	
    	Scanner scanner = new Scanner(System.in);
    	String email = "";
    	String error = "No tiene el formato de un correo electrónico.";
    	int at = 0;
    	boolean dot = false;
    	
    	System.out.println("Bienvenido al programa de revisar email.\n");
    	System.out.print("Ingresa tu email para comprobar si es correcto: ");
    	email = scanner.nextLine();
    	
    	for(int i = 0; i < email.length(); i++) {
    		if(email.charAt(i) == '@') {
    			at++;
    		}
    		
    		if(email.charAt(i) == '.') {
    			dot = true;
    		}
    	}
    	
    	if(email.length() >= 5 && at == 1 && dot == true) {
    		System.out.println("Parece un correo electrónico.");
    	}  else if (at == 1 && dot == true) {
    		System.out.printf("En este correo hay %d @ y un punto, pero no es un correo.", at);
    	} else if (at == 1 && dot == false) {
    		System.out.println(error);
    	} else {
    		System.out.println(error);
    	}
    	
    	scanner.close();
       
    }

}
