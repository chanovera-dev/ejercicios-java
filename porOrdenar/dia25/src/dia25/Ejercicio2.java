package dia25;

import java.util.Arrays;
import java.util.List;

public class Ejercicio2 {

    public static void main(String[] args) {
        List<String> palabras = Arrays.asList("Aprendiendo", "Java", "con", "FUNVAL", "desde", "cero");
        
        System.out.print("Texto original: ");
        StringBuilder sb = new StringBuilder();
        for (String palabra : palabras) {
            sb.append(palabra).append(" ");
        }
        String resultado = sb.toString().trim();
        System.out.println(resultado);

        // Usando bucle foreach
        int contador = 0;
        for (String palabra : palabras) {
            if (palabra.length() > 4) {
                contador++;
            }
        }
        System.out.println("\nCantidad de palabras con más de cuatro caracteres (foreach): " + contador);

        // Usando streams
        long cantidad = palabras.stream()
                .filter(palabra -> palabra.length() > 4)
                .count();
        System.out.println("\nCantidad de palabras con más de cuatro caracteres (streams): " + cantidad);
    }
}

