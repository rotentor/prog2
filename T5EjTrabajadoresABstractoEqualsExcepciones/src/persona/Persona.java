/**
 * 
 */
package persona;

import excepcion.ErrorEdadInvalida;

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
	 * @throws ErrorEdadInvalida 
	 */
	public Persona(String nombre, int edad) throws ErrorEdadInvalida {
//		if(edad < 0) {
//			throw new ErrorEdadInvalida("La edad es menor a 0, edad: " + edad);
//		}
		this.setEdad(edad);
		this.nombre = nombre;
//		this.edad = edad;
	}

	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) throws ErrorEdadInvalida {
		if(edad < 0) {
			throw new ErrorEdadInvalida("La edad es menor a 0, edad: " + edad);
		}
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}
	
	@Override
	public String toString() {
		return "Nombre: " + nombre + ", Edad: " + edad;
	}
	
	@Override
	public boolean equals(Object o) {
		/*if(o instanceof Persona) {
			Persona oPersona = (Persona) o;
			return oPersona.edad==this.edad && oPersona.nombre.equals(nombre);
		}else {
			return false;
		}*/
		/*if(! (o instanceof Persona)) {
			return false;
		}
		Persona oPersona = (Persona) o;
		return oPersona.edad==this.edad && oPersona.nombre.equals(nombre);*/
		//Solución más dificil de leer es mejor la anterior
		return (o instanceof Persona) && ((Persona)o).edad == this.edad &&
				((Persona)o).nombre.equals(this.nombre);
		
	}
}
