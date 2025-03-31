/**
 * 
 */
package animales;

/**
 * 
 */
public class Animal {
	private String sonido;
	private String nombre;
	private int edad;
	
	public Animal(String nombre, int edad, String sonido) {
		this.nombre = nombre;
		this.edad = edad;
		this.sonido = sonido;
	}
	
	public int getEdad() {
		return this.edad;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void emitirSonido() {
		System.out.println(this.sonido);
	}

}
