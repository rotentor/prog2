package personas;
import fecha.FechaComparable;


public class Persona implements Comparable<Persona>{
	private String nombre; 
	private FechaComparable fechaNacimiento;
	
	public Persona(String nombre, FechaComparable fechaNacimiento){
		this.nombre = nombre; 
		this.fechaNacimiento = new FechaComparable(fechaNacimiento);
	}
	
	public String toString(){
		return "Nombre: " + nombre + " fecha nacimiento: " + fechaNacimiento;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public int compareTo(Persona persona) {
		// TODO Auto-generated method stub
		return fechaNacimiento.compareTo(persona.fechaNacimiento);
	}
	
		
	
}









