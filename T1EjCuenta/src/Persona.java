
public class Persona {
	private String dni;
	private int edad;
	private String nombre;
	
	public Persona(String dni, int edad, String nombre) {
		this.dni = dni;
		this.edad = edad;
		this.nombre = nombre;
	}
	
	public void setDNI(String newDNI) {
		dni = newDNI;
	}
	
	public String toString() {
		return dni + " " + edad + " " + nombre;
	}
	
	public boolean esIgual(Persona per) {
		return this.dni.equals(per.dni) && this.edad == per.edad &&
				this.nombre.equals(per.nombre);
	}
	
	public Persona(Persona per) {
		this.edad = per.edad;
		this.nombre = per.nombre;
		this.dni = per.dni;
	}
	
}
