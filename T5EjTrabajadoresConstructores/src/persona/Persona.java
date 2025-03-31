/**
 * 
 */
package persona;

/**
 * 
 */
public class Persona {
	private int edad; // Edad de la persona
	private String nombre; // Nombre de la persona
	
	/**
	 * PRE: la edad debe ser >= 0
	 * @param nombre Nombre de la persona
	 * @param edad edad de la persona
	 */
	public Persona(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	public int getEdad() {
		return edad;
	}

	public String getNombre() {
		return nombre;
	}

}
