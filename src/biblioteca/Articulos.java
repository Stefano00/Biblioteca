package biblioteca;

public class Articulos {
	
	protected String nombre;
	protected boolean reserva;
	protected double codigo;
	protected double plazo;
	
	public Articulos(String nombre, boolean reserva, double codigo, double plazo) {
		super();
		this.nombre = nombre;
		this.reserva = reserva;
		this.codigo = codigo;
		this.plazo = plazo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isReserva() {
		return reserva;
	}

	public void setReserva(boolean reserva) {
		this.reserva = reserva;
	}

	public double getCodigo() {
		return codigo;
	}

	public void setCodigo(double codigo) {
		this.codigo = codigo;
	}

	public double getPlazo() {
		return plazo;
	}

	public void setPlazo(double plazo) {
		this.plazo = plazo;
	}

	@Override
	public String toString() {
		return "Articulos [nombre=" + nombre + ", reserva=" + reserva + ", codigo=" + codigo + ", plazo=" + plazo + "]";
	}
	

	
	

}
