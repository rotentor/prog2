package empresa;

public class Manager extends Empleado {
	
	private double bonus;//bonus mensual
	
	/**
	 * PRE: edad>=0 , salario>=s.m.i , bonus>=100
	 * @param nombre
	 * @param edad
	 * @param noSS
	 * @param salario
	 */

	public Manager(String nombre, int edad, String noSS, double salario,
			double bonus) {
		
		super(nombre, edad, noSS, salario);
		this.bonus=bonus;
		// TODO Auto-generated constructor stub
	}

}
