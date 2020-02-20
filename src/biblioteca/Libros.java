package biblioteca;

public class Libros extends Articulos  {
	
	private double paginas;
	private String imprenta;
	
	public Libros(String nombre, boolean reserva, double codigo, double plazo, double paginas, String imprenta) {
		super(nombre, reserva, codigo, plazo);
		this.paginas = paginas;
		this.imprenta = imprenta;
	}

	public double getPaginas() {
		return paginas;
	}

	public void setPaginas(double paginas) {
		this.paginas = paginas;
	}

	public String getImprenta() {
		return imprenta;
	}

	public void setImprenta(String imprenta) {
		this.imprenta = imprenta;
	}

	@Override
	public String toString() {
		return "Libros [paginas=" + paginas + ", imprenta=" + imprenta + ", nombre=" + nombre + ", reserva=" + reserva
				+ ", codigo=" + codigo + ", plazo=" + plazo + "]";
	}
	
	
}
