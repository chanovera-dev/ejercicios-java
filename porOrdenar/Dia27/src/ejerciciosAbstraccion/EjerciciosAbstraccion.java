package ejerciciosAbstraccion;

public class EjerciciosAbstraccion {
	
	public static void main(String[] args) {
		
		Libro libroReal = new LibroReal("Libro de Mormón", "José Smith", 1880, 642);
		libroReal.mostrarInformacion();
		
		Libro libroDigital = new LibroDigital("La Biblia", "Diversos autores", 400, "ePub");
		libroDigital.mostrarInformacion();
		
	}
}

abstract class Libro {
	
	protected String titulo, autor;
	protected int anoPublicacion;
	
	public Libro(String titulo, String autor, int anoPublicacion) {
		this.titulo = titulo;
		this.autor = autor;
		this.anoPublicacion = anoPublicacion;
	}
	
	public abstract void mostrarInformacion();
	
}

class LibroReal extends Libro {
	
	private int numeroPaginas;

	public LibroReal(String titulo, String autor, int anoPublicacion, int numeroPaginas) {
		super(titulo, autor, anoPublicacion);
		this.numeroPaginas = numeroPaginas;
	}

	@Override
	public void mostrarInformacion() {
		System.out.println(
				  "\nEl libro es: \n"
				+ "Título: " + titulo + "\n"
				+ "Autor: " + autor + "\n"
				+ "Año de publicación: " + anoPublicacion + "\n"
				+ "Número de páginas: " + numeroPaginas);	
	}
	
}

class LibroDigital extends Libro {
	
	private String formato;

	public LibroDigital(String titulo, String autor, int anoPublicacion, String formato) {
		super(titulo, autor, anoPublicacion);
		this.formato = formato;
	}
	
	@Override
	public void mostrarInformacion() {
		System.out.println(
				  "\nEl libro es: \n"
				+ "Título: " + titulo + "\n"
				+ "Autor: " + autor + "\n"
				+ "Año de publicación: " + anoPublicacion + "\n"
				+ "Formato: " + formato);	
	}
	
}