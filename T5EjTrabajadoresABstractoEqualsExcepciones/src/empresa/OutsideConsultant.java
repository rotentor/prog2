package empresa;

public class OutsideConsultant extends Worker {

	private double tarifa;
	private double horas;
	private String empresa;
	
	//Pre: edad >= EDAD_MINIMA, tarifa>=0, horas>=0
	/**
	 * 
	 * @param nombre
	 * @param edad
	 * @param noSS
	 * @param tarifa
	 * @param horas
	 * @param empresa
	 */
	public OutsideConsultant(String nombre, int edad, String noSS, double tarifa,
			double horas, String empresa) {
		super(nombre, edad, noSS);
		this.tarifa=tarifa;
		this.horas=horas;
		this.empresa=empresa;
	}
	
	@Override
	public String toString() {
		return super.toString() + "  Tarifa del autónomo: " + tarifa + "  Horas mensuales: " + horas + " Empresa en la que trabaja: " + empresa;
	}
	


	@Override
	public double monthlyPaynent() {
		return tarifa*horas;
	}

}
