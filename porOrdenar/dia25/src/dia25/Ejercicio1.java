package dia25;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio1 {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);
        numeros.add(6);
        numeros.add(7);
        numeros.add(8);
        numeros.add(9);
        numeros.add(10);
        
        System.out.println("Separa los números pares del 1 al 10 con for-each y con stream.");

        // Filtrar y mostrar solo los números pares usando foreach
        System.out.print("\nNúmeros pares (for-each):");
        for (Integer numero : numeros) {
            if (numero % 2 == 0) {
                System.out.print(" " + numero);
            }
        }

        // Filtrar y mostrar solo los números pares usando streams
        System.out.print("\nNúmeros pares (streams):  ");
        String numerosPares = numeros.stream()
                .filter(numero -> numero % 2 == 0)
                .map(Object::toString)
                .collect(Collectors.joining(" "));
        System.out.println(numerosPares);
    }
}

