package dia23;

import java.util.ArrayList;
import java.util.List;

class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}	

public class FiltroPersonas {
    public static void main(String[] args) {
        // Definir la lista de personas
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Cristian", 40));
        personas.add(new Persona("Karla", 33));
        personas.add(new Persona("Renata", 2));

        // Filtrar y mostrar los nombres de las personas mayores de 30 años
        List<String> nombresMayores30 = filtrarPersonas(personas, p -> p.getEdad() > 30);
        for (String nombre : nombresMayores30) {
            System.out.println(nombre);
        }
    }

    public static List<String> filtrarPersonas(List<Persona> personas, Filtro<Persona> filtro) {
        List<String> nombresFiltrados = new ArrayList<>();
        for (Persona persona : personas) {
            if (filtro.evaluar(persona)) {
                nombresFiltrados.add(persona.getNombre());
            }
        }
        return nombresFiltrados;
    }

    interface Filtro<T> {
        boolean evaluar(T elemento);
    }
}
