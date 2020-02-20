package biblioteca;

public class Peliculas extends Articulos {
	
	private double duracion;
	private String calidad;
	
	public Peliculas(String nombre, boolean reserva, double codigo, double plazo, double duracion, String calidad) {
		super(nombre, reserva, codigo, plazo);
		this.duracion = duracion;
		this.calidad = calidad;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public String getCalidad() {
		return calidad;
	}

	public void setCalidad(String calidad) {
		this.calidad = calidad;
	}

	@Override
	public String toString() {
		return "Peliculas [duracion=" + duracion + ", calidad=" + calidad + ", nombre=" + nombre + ", reserva="
				+ reserva + ", codigo=" + codigo + ", plazo=" + plazo + "]";
	}
	

}
