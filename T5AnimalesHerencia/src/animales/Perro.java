/**
 * 
 */
package animales;

/**
 * 
 */
public class Perro extends Animal {
	private String amo;
	
	public Perro(String nombre, int edad, String amo) {
		super(nombre, edad, "GuaGua");
		this.amo = amo;
	}
	
	public void lamerHueso() {
		System.out.printf("Lamiendo un hueso\n");
	}
	
	public String getAmo() {
		return this.amo;
	}
}
