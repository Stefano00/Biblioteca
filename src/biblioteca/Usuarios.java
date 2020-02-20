package biblioteca;

public class Usuarios {
	
	private String nombre;
	private double rut;
	private double clave;
	
	public Usuarios(String nombre, double rut, double clave) {
		super();
		this.nombre = nombre;
		this.rut = rut;
		this.clave = clave;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getRut() {
		return rut;
	}

	public void setRut(double rut) {
		this.rut = rut;
	}

	public double getClave() {
		return clave;
	}

	public void setClave(double clave) {
		this.clave = clave;
	}

	@Override
	public String toString() {
		return "Usuarios [nombre=" + nombre + ", rut=" + rut + ", clave=" + clave + "]";
	}
	
	

}
