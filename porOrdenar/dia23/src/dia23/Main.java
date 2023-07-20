package dia23;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(40);
        numeros.add(33);
        numeros.add(2);
        
        double promedio = calcularPromedio(numeros);
        System.out.println("El promedio es: " + promedio);
    }
    
    public static <T extends Number> double calcularPromedio(List<T> numeros) {
        return numeros.stream()
                      .mapToDouble(Number::doubleValue)
                      .average()
                      .orElse(0);
    }
}