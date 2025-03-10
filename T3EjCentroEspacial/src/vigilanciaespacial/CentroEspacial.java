package vigilanciaespacial;

public class CentroEspacial {
	private String identificador;
	private SateliteArtificial[] satelitesSupervisados;
	
	public CentroEspacial(String identificador, 
			SateliteArtificial[] satelites) {
		this.identificador = identificador;
		this.satelitesSupervisados = satelites;
	}
	
	public String getIdentificador() {
		return identificador;
	}
	
	public String informacionEstrellas(){
		String res = "";
		for (int i = 0; i < satelitesSupervisados.length; i++) {
			if (!satelitesSupervisados[i].hayAlertaTormentaMagnetica()) {
				res += satelitesSupervisados[i].getEstrella().getIdentificador() 
						+ " (" + satelitesSupervisados[i].darTemperatura() + ")\n";
			}
			else {
				res += satelitesSupervisados[i].getEstrella().getIdentificador()
						+ " (" + satelitesSupervisados[i].darTemperatura() 
						+ ") ALERTA!\n";
			}
		}
		return res;
	}
	
	public boolean comprobarSatelites() {
		boolean repetidos = false;
		for(int i=0; i<satelitesSupervisados.length - 1 && !repetidos; i++) {
			for(int j = i+1; j<satelitesSupervisados.length && !repetidos; j++) {
				repetidos = (satelitesSupervisados[i].esIgual(satelitesSupervisados[j]));
			}
		}
		return satelitesSupervisados.length > 0 && !repetidos;
	}
	
}
