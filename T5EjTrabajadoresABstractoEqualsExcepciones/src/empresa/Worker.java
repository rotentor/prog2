package empresa;

import excepcion.ErrorEdadInvalida;
import persona.Persona;

public abstract class Worker extends Persona {
	private String noSS; // número de la seguridad social
	public final static int EDAD_MINIMA = 16;
	
	/*
	 * Pre: edad >= EDAD_MINIMA
	 * Constructor de la clase Worker
	 */
	public Worker(String nombre, int edad, String noSS) throws ErrorEdadInvalida {
		super(nombre, edad);
		this.setEdad(edad);
		this.noSS = noSS;
	}
	
	public abstract double monthlyPaynent();
	
	@Override
	public String toString() {
		return super.toString() + " tiene numero de la SS: " + this.noSS;
	}
	
	@Override
	public boolean equals(Object object) {
		Worker trabajador;
		if (!(object instanceof Worker))
			return false;
		trabajador = (Worker) object;
		
		return (super.equals(trabajador)
				&& trabajador.noSS.equals(noSS));
		
	}
	//sets
	@Override
	public void setEdad(int edad) throws ErrorEdadInvalida{
		if(edad<EDAD_MINIMA) {
			throw new ErrorEdadInvalida("La edad del trabajador es menor qe la dead minima"
					+ ", Edad: "+edad+", Edad minima: "+EDAD_MINIMA);
		}
		super.setEdad(edad);
	}
}
