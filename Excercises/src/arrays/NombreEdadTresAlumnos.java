package arrays;

public class NombreEdadTresAlumnos {

	public static void main(String[] args) {
		String[][] alumnos = new String[3][2];
		
		alumnos[0][0] = "Cristian";
        alumnos[0][1] = "29";
        alumnos[1][0] = "Corazón";
        alumnos[1][1] = "45";
        alumnos[2][0] = "Juan Vicente";
        alumnos[2][1] = "42";

        for (int i = 0; i < alumnos.length; i++) {
            String nombre = alumnos[i][0];
            String edad = alumnos[i][1];
            System.out.println("El alumno " + nombre + " tiene " + Integer.parseInt(edad) + " años.");
        }
	}

}
