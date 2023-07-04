package arbolNavidad;

public class ArbolNavidad {
	
	public static void main(String[] args) {
        int alturaArbol = 14;
        int alturaTronco = 6;
        int grosorTronco = 7;

        // Imprimir el pino
        for (int i = 0; i < alturaArbol; i++) {
            for (int j = 0; j < alturaArbol - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i * 1 + 1; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Imprimir el tronco
        for (int i = 0; i < alturaTronco; i++) {
            for (int j = 0; j < alturaArbol - 3; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < grosorTronco; k++) {
                System.out.print("+");
            }
            System.out.println();
        }
    }
	
}
