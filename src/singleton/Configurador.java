package singleton;

public class Configurador {

	//Variable encapsulada y est�tica donde se almacenar� la instancia.
	private static Configurador config;

	//Constructor privado
	private Configurador() {}

	//M�todo est�tico encapsulador para acceder a la instancia �nica	
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
