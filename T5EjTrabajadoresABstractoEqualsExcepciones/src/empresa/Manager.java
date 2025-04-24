package empresa;

import excepcion.ErrorBonusInvalido;
import excepcion.ErrorEdadInvalida;
import excepcion.ErrorSalarioIncorrecto;

public class Manager extends Empleado {
	
	private double bonus;//bonus mensual
	private static double bonusMinimo = 100;
	
	/**
	 * PRE: >= EDAD_MINIMA , salario>=s.m.i , bonus>=100
	 * @param nombre
	 * @param edad
	 * @param noSS
	 * @param salario
	 * @throws ErrorSalarioIncorrecto 
	 * @throws ErrorEdadInvalida 
	 * @throws ErrorBonusInvalido 
	 */

	public Manager(String nombre, int edad, String noSS, double salario,
			double bonus) throws ErrorEdadInvalida, ErrorSalarioIncorrecto,
	       ErrorBonusInvalido {
		super(nombre, edad, noSS, salario);
		this.setBonus(bonus);
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
	
	public void setBonus(double bonus) throws ErrorBonusInvalido {
		if(bonus<Manager.bonusMinimo) {
			throw new ErrorBonusInvalido("Bonus menor que el bonus mínimo es de: "+
					Manager.bonusMinimo);
		}
		this.bonus=bonus;
	}
	
	public static double getBonusMinimo() {
		return bonusMinimo;
	}
}
