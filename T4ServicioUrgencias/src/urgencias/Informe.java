package urgencias;


import java.time.LocalDate;

/**
 * Esta clase contiene la información referente a un informe
 * 
 *
 */
public class Informe {
	private String contenido;
	private LocalDate fecha;
	
	public Informe(String contenido) {
		this.contenido = contenido;
		// inicializa el atributo fecha con la fecha actual
		this.fecha =LocalDate.now();
	}
	
	public String toString() {
		//DateFormat formatter = new SimpleDateFormat("yyyy-MMM-dd");
		return contenido + " " + fecha;
	}
	
	public String getContenido() {
		return contenido;
	}
	
	/**
	 * Método que retorna una referencia a la fecha del informe
	 * @return referecia a la fecha del informe
	 */
	public LocalDate getFecha() {
		return this.fecha;
	}

}
