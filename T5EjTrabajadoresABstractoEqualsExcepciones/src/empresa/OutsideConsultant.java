package empresa;

import excepcion.ErrorDatoInvalido;
import excepcion.ErrorEdadInvalida;

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
	 * @throws ErrorEdadInvalida 
	 * @throws ErrorDatoInvalido 
	 */
	public OutsideConsultant(String nombre, int edad, String noSS, double tarifa,
			double horas, String empresa) throws ErrorEdadInvalida,
			ErrorDatoInvalido {
		super(nombre, edad, noSS);
		this.setHoras(horas);
		this.setTarifa(tarifa);
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
	
	public void setTarifa(double tarifa) throws ErrorDatoInvalido {
		if (tarifa < 0) {
			throw new ErrorDatoInvalido("La tarifa debe ser mayor o igual que cero");
		}
		this.tarifa = tarifa;
	}
	
	public void setHoras(double horas) throws ErrorDatoInvalido {
		if (horas < 0) {
			throw new ErrorDatoInvalido("Las horas deben ser mayor o igual que cero");
		}
		this.horas = horas;
	}

}
