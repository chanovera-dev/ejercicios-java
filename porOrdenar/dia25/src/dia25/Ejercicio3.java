package dia25;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio3 {
    public static void main(String[] args) {
        List<String> listaCadenas = new ArrayList<>();
        listaCadenas.add("Aprendiendo");
        listaCadenas.add("Java");
        listaCadenas.add("con");
        listaCadenas.add("FUNVAL");
        listaCadenas.add("desde");
        listaCadenas.add("cero");

        System.out.println("Texto original:");
        StringBuilder originalForeach = new StringBuilder();
        for (String cadena : listaCadenas) {
           originalForeach.append(cadena).append(" ");
        }
        String resultado = originalForeach.toString().trim();
        System.out.println(resultado);
        
        
        // Usando un bucle foreach
        System.out.println("\nUsando un bucle foreach:");
        StringBuilder sbForeach = new StringBuilder();
        for (String cadena : listaCadenas) {
            sbForeach.append(cadena.toUpperCase()).append(" ");
        }
        String resultadoForeach = sbForeach.toString().trim();
        System.out.println(resultadoForeach);

        // Usando streams
        System.out.println("\nUsando streams:");
        String resultadoStreams = listaCadenas.stream()
                .map(String::toUpperCase)
                .reduce("", (a, b) -> a + b + " ")
                .trim();
        System.out.println(resultadoStreams);
    }
}
