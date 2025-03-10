package vigilanciaespacial;

import vigilanciaespacial.estrellas.Estrella;

public class SateliteArtificial {
	private static int contador = 0;
	private String identificador;
	private Estrella estrellaMonitorizada;
	
	public SateliteArtificial(Estrella estrella) {
		contador++;
		this.identificador="Sat"+contador;
		this.estrellaMonitorizada=estrella;		
	}
	
	public String getIdentificador(){
		return identificador;
	}
	
	public Estrella getEstrella () {
		return estrellaMonitorizada;
	}
	
	public void setEstrella(Estrella e) {
		estrellaMonitorizada = e;
	}
	
	public double darTemperatura() {
		return estrellaMonitorizada.getIndiceColor() * 2.1;
	}
	
	public boolean hayAlertaTormentaMagnetica(){
		return estrellaMonitorizada.getCampoMagnetico()>=1000;
	}
	
	public boolean esIgual(SateliteArtificial satelite) {
		return this.estrellaMonitorizada.esIgual
				(satelite.estrellaMonitorizada);
	}
}
