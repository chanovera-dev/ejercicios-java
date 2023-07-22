package baraja;

public class Carta {

	private String palo;
	private String valor;
	private String rutaImagen;
	
	public Carta(String palo, String valor) {
		this.palo = palo;
		this.valor = valor;
		this.rutaImagen = "imagenes/" + valor + palo + ".png";
	}
	
	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	@Override
    public String toString() {
        return valor + " de " + palo;
    }
	
	public String getPalo() {
		return palo;
	}

	public void setPalo(String palo) {
		this.palo = palo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}
