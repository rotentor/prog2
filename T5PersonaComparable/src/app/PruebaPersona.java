/**
 * 
 */
package app;

import java.util.Arrays;

import fecha.FechaComparable;
import fecha.excepciones.FechaIncorrecta;
import personas.Persona;

/**
 * 
 */
public class PruebaPersona {

	/**
	 * @param args
	 * @throws FechaIncorrecta 
	 */
	public static void main(String[] args) throws FechaIncorrecta {
		Persona [] personas = new Persona[4];
		personas[0] = new Persona("José Guerra", new FechaComparable(12,1,1980));
		personas[1] = new Persona("José García", new FechaComparable(14,1,1980));
		personas[2] = new Persona("Jaime García", new FechaComparable(14,1,1990));
		personas[3] = new Persona("María José García", new FechaComparable(12,2,1979));
		System.out.println("Antes de ordenar");
		for (Persona persona : personas)
		{
			System.out.println("Datos: " + persona);
		}
		
		Arrays.sort(personas);
		System.out.println("Después de ordenar por fecha");
		for (Persona persona : personas)
		{
			System.out.println("Datos: " + persona);
		}
		
		Arrays.sort(personas, (x,y) -> x.getNombre().compareTo(y.getNombre()));
		System.out.println("Después de ordenar por nombre");
		for (Persona persona : personas)
		{
			System.out.println("Datos: " + persona);
		}
		

	}

}
