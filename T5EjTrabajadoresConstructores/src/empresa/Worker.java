package empresa;

import persona.Persona;

public class Worker extends Persona {
	private String noSS; // número de la seguridad social
	
	/*
	 * Pre: edad >= 0
	 * Constructor de la clase Worker
	 */
	public Worker(String nombre, int edad, String noSS) {
		super(nombre, edad);
		this.noSS = noSS;
	}
}
