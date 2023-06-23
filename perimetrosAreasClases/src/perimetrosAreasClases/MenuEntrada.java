package perimetrosAreasClases;

import java.util.Scanner;

public class MenuEntrada {

	public void opcion() {
		int caso = 0;
        boolean validacion = false;

        Scanner input = new Scanner(System.in);

        System.out.println(
                "Bienvenido al programa que realiza el perimetro y el area de triangulos y rectangulos.\n\n"
                        + "Escoge 1 si quieres el área de un rectángulo.\n"
                        + "Escoge 2 si quieres el perimetro de un rectángulo.\n"
                        + "Escoge 3 si quieres el área de un triángulo.\n"
                        + "Escoge 4 si quieres el perimetro de un triángulo.\n\n");

        caso = input.nextInt();

        while (!validacion) {
            switch (caso) {
                case 1:
                    CalcularArea.rectangulo();
                    validacion = true;
                    break;
                case 2:
                	CalcularPerimetro.rectangulo();
                    validacion = true;
                    break;
                case 3:
                	CalcularArea.triangulo();
                    validacion = true;
                    break;
                case 4:
                    CalcularPerimetro.triangulo();
                    validacion = true;
                    break;
                default:
                    System.out.println("La opción que escogiste no es válida, vuelve a escoger otra vez.\n\n");
                    caso = input.nextInt();
                    break;
            }
        }

        input.close();
	}
	
}
