package vajilla;

public class Vaso {
	
	private double capacidadMax;
	private double contenido = 0.0;
	
	public Vaso (double capacidadMax){
		this.capacidadMax = capacidadMax;
	}
	
	public void llenar (double cantidad){
		if (contenido+cantidad <= capacidadMax){
			contenido+= cantidad;
		}
		else
			System.err.println("No se puede llenar");
		
	}
	
	public void prepararDesayuno (double leche, double azucar, double colacao){
		llenar(leche);
		llenar(azucar);
		llenar(colacao);
	}
	
	public String toString() {
		return "Vaso [contenido=" + contenido + "]\n";
	}
	
	

}
