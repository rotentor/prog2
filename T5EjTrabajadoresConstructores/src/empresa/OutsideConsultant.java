package empresa;

public class OutsideConsultant extends Worker {

	private double tarifa;
	private double horas;
	private String empresa;
	
	//Pre: edad>=0, tarifa>=0, horas>=0
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
		// TODO Auto-generated constructor stub
		this.tarifa=tarifa;
		this.horas=horas;
		this.empresa=empresa;
	}

}
