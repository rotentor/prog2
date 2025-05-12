package personas;
import fecha.FechaComparable;


public class Persona {
	private String nombre; 
	private FechaComparable fechaNacimiento;
	
	public Persona(String nombre, FechaComparable fechaNacimiento){
		this.nombre = nombre; 
		this.fechaNacimiento = new FechaComparable(fechaNacimiento);
	}
	
	public String toString(){
		return "Nombre: " + nombre + " fecha nacimiento: " + fechaNacimiento;
	}
	
		
	
}









