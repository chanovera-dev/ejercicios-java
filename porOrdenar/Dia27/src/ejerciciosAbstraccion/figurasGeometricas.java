package ejerciciosAbstraccion;

public class figurasGeometricas {
	
	public static void main(String[] args) {
		Figura circulo = new Circulo("círculo", 7);
		Figura cuadrado = new Cuadrado("cuadrado", 7);
		Figura rectangulo = new Rectangulo("rectángulo", 7, 3.5);
		Figura triangulo = new Triangulo("triangulo", 7, 3.5);
		
		circulo.obtenerArea();
		circulo.obtenerPerimetro();
		System.out.println();
		cuadrado.obtenerArea();
		cuadrado.obtenerPerimetro();
		System.out.println();
		rectangulo.obtenerArea();
		rectangulo.obtenerPerimetro();
		System.out.println();
		triangulo.obtenerArea();
		triangulo.obtenerPerimetro();
	}

}

abstract class Figura {
	
	protected String nombreFigura;
	
	public Figura(String nombreFigura) {
		this.nombreFigura = nombreFigura;
	}
	
	public abstract void obtenerPerimetro();
	public abstract void obtenerArea();
	
	protected void imprimirPerimetro(double perimetro) {
        System.out.printf("El perimetro de este %s es: %.2f cm.\n", nombreFigura, perimetro);
    }
	
	protected void imprimirArea(double area) {
		System.out.printf("El área de este %s es: %.2f cm².\n", nombreFigura, area);
    }
}

class Circulo extends Figura {
	
	private double radio;

	public Circulo(String nombreFigura, double radio) {
		super(nombreFigura);
		this.radio = radio;
	}

	@Override
	public void obtenerPerimetro() {
		double perimetro = (2*(Math.PI)) * radio;
		imprimirPerimetro(perimetro);
		
	}

	@Override
	public void obtenerArea() {
		double area = Math.PI * (Math.pow(radio, 2));
		imprimirArea(area);
	}
	
}

class Cuadrado extends Figura {
	
	private double lado;

	public Cuadrado(String nombreFigura, double lado) {
		super(nombreFigura);
		this.lado = lado;
	}

	@Override
	public void obtenerPerimetro() {
		double perimetro = lado * 4;
		imprimirPerimetro(perimetro);
		
	}

	@Override
	public void obtenerArea() {
		double area = lado * lado;
		imprimirArea(area);
	}
	
}

class Rectangulo extends Figura {
	private double base;
	private double altura;

	public Rectangulo(String nombreFigura, double base, double altura) {
		super(nombreFigura);
		this.base = base;
		this.altura = altura;
	}

	@Override
	public void obtenerPerimetro() {
		double perimetro = Math.pow(base, 2) + Math.pow(altura, 2);
		imprimirPerimetro(perimetro);
	}

	@Override
	public void obtenerArea() {
		double area = base * altura;
		imprimirArea(area);
	}
	
}

class Triangulo extends Figura {
	private double base;
	private double altura;

	public Triangulo(String nombreFigura, double base, double altura) {
		super(nombreFigura);
		this.base = base;
		this.altura = altura;
	}

	@Override
	public void obtenerPerimetro() {
		double hipotenusa = Math.sqrt(Math.pow(base, 2) + Math.pow(altura, 2));
		double perimetro = base + altura + hipotenusa;
		imprimirPerimetro(perimetro);
	}

	@Override
	public void obtenerArea() {
		double area = (base * altura)/2;
		imprimirArea(area);
	}
	
}
