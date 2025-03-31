/**
 * 
 */
package animales;

/**
 * 
 */
public class Oveja extends Animal {
    private String pastor;
	/**
	 * @param sonido
	 */
	public Oveja(String nombre, int edad, String pastor) {
		super(nombre, edad,"Beeee");
		this.pastor = pastor;
	}
	
	public void pastar() {
		System.out.printf("Pastando\n");
	}
	
	public String getPastor() {
		return this.pastor;
	}
	
	@Override
    public String toString() {
	    return super.toString() + " Pastor: " + this.pastor;
	  }

}
