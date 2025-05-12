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
}
