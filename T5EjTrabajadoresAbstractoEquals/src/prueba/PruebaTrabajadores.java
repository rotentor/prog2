/**
 * 
 */
package prueba;

import persona.Persona;
import empresa.*;

/**
 * 
 */
public class PruebaTrabajadores {
	
	public static void listarDatosPersonas(Persona [] personas) {
		for(int i=0;i<personas.length;i++){
			System.out.println("Datos persona["+i+"]: "+personas[i]);
		}
		
	}
	
	public static double costeMensualPlantilla(Worker [] trabajadores) {
		double total = 0.0;
		for (Worker trabajador : trabajadores) {
			total += trabajador.monthlyPaynent();
		}
		
		return total;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Worker [] listadoTrabajadores = new Worker[4];
		listadoTrabajadores[0] = new Manager("Persona2", 30, "23KQ12233", 60000, 320);
		listadoTrabajadores[1] = new Empleado("Persona3", 30, "34KQ12233", 20000);
		listadoTrabajadores[2] = new OutsideConsultant("Persona4", 30, "55KQ12233",
				20, 10.33, "Trabajos");
		listadoTrabajadores[3] = new Manager("Manager", 30, "75KQ12233", 40000, 250);
		// TODO Auto-generated method stub
		listarDatosPersonas(listadoTrabajadores);
		double costeTotal = costeMensualPlantilla(listadoTrabajadores);
		System.out.println("El coste total es de: " + costeTotal + "€");
	}

}
