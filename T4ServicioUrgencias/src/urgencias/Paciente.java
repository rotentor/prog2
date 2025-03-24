package urgencias;
import java.time.LocalDate;

import list.ArrayList;

public class Paciente {
	private String noSS;
	
	//historial ordenado crecientemente por fecha
	private ArrayList<Informe> historial;
	
	/**
	 * PRE: noSS != null
	 * @param noSS
	 */
	public Paciente(String noSS) {
		this.noSS = noSS;
		historial = new ArrayList<Informe>();
	}
	
	/**
	 * PRE: cierto
	 * POST: añade ordenadamente el informe al historial 
	 * @param informe
	 */
	public void guardarInforme(Informe informe) {
		LocalDate fecha = informe.getFecha();
		int i;
		for(i=0; i<historial.size() &&
				fecha.compareTo(historial.get(i).getFecha()) < 0; i++);
		historial.add(i, informe);
	}
	
	public String toString() {
		return noSS + " " + historial;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((noSS == null) ? 0 : noSS.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		boolean noIguales= (obj == null) || !(obj instanceof Paciente); 
		Paciente other = (Paciente) obj;
		return !noIguales && noSS.equals(other.noSS);
	}
}
