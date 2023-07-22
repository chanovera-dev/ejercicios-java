package catalogoAutos;

public abstract class Auto {

	private String marca;
	private String nombre;
	private String year;
	private String tipo;
	private String imagen;
	private String color;
	private String precio;

	public Auto(String marca, String nombre, String year, String tipo, String imagen, String color, String precio) {
		this.marca = marca;
		this.nombre = nombre;
		this.year = year;
		this.tipo = tipo;
		this.imagen = imagen;
		this.color = color;
		this.precio = precio;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public void setColor(String color) {
		this.color = color;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	
	public String getMarca() {
		return marca;
	}
	public String getNombre() {
		return nombre;
	}
	public String getYear() {
		return year;
	}
	public String getTipo() {
		return tipo;
	}
	public String getImagen() {
		return imagen;
	}
	public String getColor() {
		return color;
	}
	public String getPrecio() {
		return precio;
	}
	
	public abstract String getDetalles();
	
	
}

class Sedan extends Auto {
	
	public Sedan(String marca, String nombre, String year, String tipo, String imagen, String color, String precio) {
		super(marca, nombre, year, tipo, imagen, color, precio);
	}

	@Override
	public String getDetalles() {
		StringBuilder detalles = new StringBuilder();
		detalles.append("Marca: ").append(getMarca()).append("\n");
        detalles.append("Nombre: ").append(getNombre()).append("\n");
        detalles.append("Año: ").append(getYear()).append("\n");
        detalles.append("Tipo: ").append(getTipo()).append("\n");
        detalles.append("Color: ").append(getColor()).append("\n");
        //detalles.append("Precio: ").append(getPrecio()).append("\n");
        return detalles.toString();
	}
	
}

class SUV extends Auto {
	
	public SUV(String marca, String nombre, String year, String tipo, String imagen, String color, String precio) {
		super(marca, nombre, year, tipo, imagen, color, precio);
	}

	@Override
	public String getDetalles() {
		StringBuilder detalles = new StringBuilder();
		detalles.append("Marca: ").append(getMarca()).append("\n");
        detalles.append("Nombre: ").append(getNombre()).append("\n");
        detalles.append("Año: ").append(getYear()).append("\n");
        detalles.append("Tipo: ").append(getTipo()).append("\n");
        detalles.append("Color: ").append(getColor()).append("\n");
        //detalles.append("Precio: ").append(getPrecio()).append("\n");
        return detalles.toString();
	}
	
}

class Deportivo extends Auto {
	
	public Deportivo(String marca, String nombre, String year, String tipo, String imagen, String color, String precio) {
		super(marca, nombre, year, tipo, imagen, color, precio);
	}

	@Override
	public String getDetalles() {
		StringBuilder detalles = new StringBuilder();
		detalles.append("Marca: ").append(getMarca()).append("\n");
        detalles.append("Nombre: ").append(getNombre()).append("\n");
        detalles.append("Año: ").append(getYear()).append("\n");
        detalles.append("Tipo: ").append(getTipo()).append("\n");
        detalles.append("Color: ").append(getColor()).append("\n");
        //detalles.append("Precio: ").append(getPrecio()).append("\n");
        return detalles.toString();
	}
	
}
