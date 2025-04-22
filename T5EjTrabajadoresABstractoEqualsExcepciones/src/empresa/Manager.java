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
	}

	@Override
	public String toString() {
		return super.toString() + " bonus memsual: " + this.bonus;
	}
	
	public double monthlyPayment() {
		return super.monthlyPaynent()+bonus;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Manager))
		{
			return false;
		}
		Manager manager = (Manager)obj;
		return this.bonus == manager.bonus && super.equals(manager);
	}
}
