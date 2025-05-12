package empresa;

import excepcion.ErrorEdadInvalida;
import excepcion.ErrorSalarioIncorrecto;

public class Empleado extends Worker {
	
	private double salario; //Salario anual del Empleado
	private static double SMI = 11800;
	
	
	/**
	 * PRE: edad >=0,salario >= SMI
	 * @param nombre
	 * @param edad >= EDAD_MINIMA
	 * @param noSS
	 * @param salario
	 * @throws ErrorEdadInvalida 
	 * @throws ErrorSalarioIncorrecto 
	 */
	public Empleado(String nombre, int edad, String noSS, double salario) throws ErrorEdadInvalida, ErrorSalarioIncorrecto {
		super(nombre, edad, noSS);
		this.setSalario(salario);
	}
	
	public void setSalario(double salario) throws ErrorSalarioIncorrecto {
		if(salario < Empleado.SMI) {
			throw new ErrorSalarioIncorrecto("El salario ha de ser "
					+ "mayor o igual que el SMI:"+ Empleado.SMI
					+" Salario = " + salario);
		}
		this.salario = salario;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Salario anual: " + this.salario;
	}

	@Override
	public double monthlyPaynent() {
		
		return this.salario/14;
	}

	@Override
	public boolean equals(Object obj) {
		Empleado empleado;
		if(!(obj instanceof Empleado)) {
			return false;
		}
		empleado = (Empleado)obj;
		return super.equals(empleado) && empleado.salario==salario;
	}
	
	public static double getSMI() {
		return Empleado.SMI;
	}
}
