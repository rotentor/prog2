package empresa;

public class Empleado extends Worker {
	
	private double salario; //Salario anual del Empleado
	
	/**
	 * PRE: edad >=0,salario >= SMI
	 * @param nombre
	 * @param edad
	 * @param noSS
	 * @param salario
	 */
	public Empleado(String nombre, int edad, String noSS, double salario) {
		super(nombre, edad, noSS);
		this.salario=salario;
		
	}

}
