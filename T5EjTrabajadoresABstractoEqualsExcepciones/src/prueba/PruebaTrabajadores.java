/**
 * 
 */
package prueba;

import persona.Persona;
import list.ArrayList;

import java.util.NoSuchElementException;
import java.util.Scanner;

import empresa.*;
import excepcion.ErrorBonusInvalido;
import excepcion.ErrorEdadInvalida;
import excepcion.ErrorSalarioIncorrecto;

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
	
	public static void leerDatos(Scanner lector, String [] preguntas,
			ArrayList<String> respuestas) {
		int pos = respuestas.size(); //Tenemos el tamaño y añadimos al final
		int pregunta = 0;
		while (pregunta < preguntas.length) {//W
			try {
				System.out.print("\n" + preguntas[pregunta]);
				String respuesta = lector.next();
				respuestas.add(pos, respuesta);
				pregunta++;
				pos ++;
			}
			catch (NoSuchElementException|IllegalStateException  e){
				System.out.println("\n Error al leer inténtelo de nuevo");
			}
				
		}//W
	}

	private static void pedirDatosTrabajador(Scanner lector, ArrayList<String> datos){
		String[] preguntar = {"nombre: ", "edad (debe tener al menos "+Empleado.EDAD_MINIMA+"): ",
				"noSS: "};
		PruebaTrabajadores.leerDatos(lector, preguntar, datos);
	}
	
	private static void pedirDatosEmpleado(Scanner lector, ArrayList<String> datos){
		String[] preguntar = {"salario bruto anual (debe ser de al menos "+
	                         Empleado.getSMI()+"): "};
		//Primero pedimos los datos del padre
		PruebaTrabajadores.pedirDatosTrabajador(lector,datos);
		//Ahora los completamos con los de empleado
		PruebaTrabajadores.leerDatos(lector, preguntar, datos);
	}
	
	private static void pedirDatosManager(Scanner lector, ArrayList<String> datos) {
		String[] preguntar = {"bonus: (ha de ser al menos " + Manager.getBonusMinimo() + "): "};
		PruebaTrabajadores.pedirDatosEmpleado(lector, datos);
		PruebaTrabajadores.leerDatos(lector, preguntar, datos);
	}
	
	public static Empleado leerEmpelado(Scanner lector) {
		Empleado empleado = null;
		while (empleado == null) {//W
			try {//try
				ArrayList<String> datosEmpleado = new ArrayList<>();
				System.out.println("Dame los datos del empleado");
				PruebaTrabajadores.pedirDatosEmpleado(lector, datosEmpleado);
				empleado = new Empleado(datosEmpleado.get(0), //Nombre
												 Integer.parseInt(datosEmpleado.get(1)), //Edad
												 datosEmpleado.get(2), //noSS
												 Double.parseDouble(datosEmpleado.get(3)) //Salario bruto anual
												 );
			}//try
			catch (NumberFormatException e) {
				System.out.println ("La edad o el salario introducidos tienen un formato incorrecto: " + e.getMessage());
				System.out.println("Vuelva a intentarlo");
			} catch (IndexOutOfBoundsException e) {
				// Este error no debería pasar
				e.printStackTrace();
			} catch (ErrorEdadInvalida e) {
				System.out.println("La edad introducida no es válida: "+ e.getMessage());
				System.out.println("Vuelva a intentarlo");
			} catch (ErrorSalarioIncorrecto e) {
				System.out.println("El salario introducido no es válido: "+ e.getMessage());
				System.out.println("Vuelva a intentarlo");
			}	
		}//W
		
		return empleado;
	}

	public static Manager leerManager(Scanner lector) {//leerManager
		Manager manager = null;
		while(manager == null) {//W
			try {
				ArrayList<String> datosManager = new ArrayList<>();
				System.out.println("Dame los datos del manager");
				PruebaTrabajadores.pedirDatosManager(lector, datosManager);
				manager = new Manager(datosManager.get(0), //nombre
						Integer.parseInt(datosManager.get(1)), //edad
						datosManager.get(2), //noSS
						Double.parseDouble(datosManager.get(3)), //salairo bruto anual
						Double.parseDouble(datosManager.get(4))); //bonus
			}//try
			catch (NumberFormatException e) {
				System.out.println ("La edad o el salario introducidos tienen un formato incorrecto: " + e.getMessage());
				System.out.println("Vuelva a intentarlo");
			} catch (IndexOutOfBoundsException e) {
				// Este error no debería pasar
				e.printStackTrace();
			} catch (ErrorEdadInvalida e) {
				System.out.println("La edad introducida no es válida: "+ e.getMessage());
				System.out.println("Vuelva a intentarlo");
			} catch (ErrorSalarioIncorrecto e) {
				System.out.println("El salario introducido no es válido: "+ e.getMessage());
				System.out.println("Vuelva a intentarlo");
			}	
			catch(ErrorBonusInvalido e) {
				System.out.println("El bonus introducido no es válido: "+ e.getMessage());
				System.out.println("Vuelva a intentarlo");
			}
		}//W
		return manager;
	}//leerManager
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		Worker [] listadoTrabajadores = new Worker[2];
		/*listadoTrabajadores[0] = new Manager("Persona2", 30, "23KQ12233", 60000, 320);
		listadoTrabajadores[1] = new Empleado("Persona3", 30, "34KQ12233", 20000);
		listadoTrabajadores[2] = new OutsideConsultant("Persona4", 30, "55KQ12233",
				20, 10.33, "Trabajos");
		listadoTrabajadores[3] = new Manager("Manager", 30, "75KQ12233", 40000, 250);
		*/
		listadoTrabajadores[0] = PruebaTrabajadores.leerEmpelado(lector);
		listadoTrabajadores[1] = PruebaTrabajadores.leerManager(lector);
		listarDatosPersonas(listadoTrabajadores);
		double costeTotal = costeMensualPlantilla(listadoTrabajadores);
		System.out.println("El coste total es de: " + costeTotal + "€");
	}
	
/*	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		Empleado empleado =  PruebaTrabajadores.leerEmpelado(lector);
		System.out.println("Empleado leido: " + empleado);
		
	}*/
}
