package singleton;

public class Configurador {

	//Variable encapsulada y estática donde se almacenará la instancia.
	private static Configurador config;

	//Constructor privado
	private Configurador() {}

	//Método estático encapsulador para acceder a la instancia única	
	public static Configurador getConfig() {
		 if (config == null) {
		 synchronized(Configurador.class) {
		 if (config == null) {
		 config = new Configurador();
		 System.out.println("Instancia creada");
		 					}
		 			}
		 	}
		 System.out.println("Llamada al Configurador");
		 return config;
		}
	
}
