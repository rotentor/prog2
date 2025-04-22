/**
 * 
 */
package animales;

/**
 * 
 */
public class Gato extends Animal {

	/**
	 * @param sonido
	 */
	public Gato(String nombre, int edad) {
		super(nombre, edad, "Miau");
		// TODO Auto-generated constructor stub
	}
	
	public void jugarOvillo() {
		System.out.printf("Jugando\n");
	}

}
