

public class Tren {    
    private Vagon vagon1;
    private Vagon vagon2;
    
    //PRE: capacidadVagon > 0 Y nombreVagon1 /= nombreVagon2
    public Tren(int capacidadVagon, String nombreVagon1, String nombreVagon2) {        
    	vagon1 = new Vagon(nombreVagon1, capacidadVagon);
    	vagon2 = new Vagon(nombreVagon2, capacidadVagon);
    }

    public boolean hayDosLibresConsecutivos(){
    	/*if (vagon1.hayDosLibresConsecutivos())
    		return true;
    	else
    		return vagon2.hayDosLibresConsecutivos();*/  	
    	
    	return vagon1.hayDosLibresConsecutivos() || 
    			vagon2.hayDosLibresConsecutivos();
    }   
    
    //PRE: vagon /= null Y vagon.nombre /= vagon2.nombre
    public void cambiarVagon(Vagon vagon){
    	vagon1 = vagon2;
    	vagon2 = vagon;
    }
    
    public String toString(){
        return vagon1 + "\n" + vagon2;
    }
    
    //PRE: 0 <= i < capacidad del vagon nombreVagon
    public void ocuparVagon(int i, String nombreVagon){
    	if (nombreVagon.equals(vagon1.getNombre()))
    		vagon1.ocupar(i);
    	else if (nombreVagon.equals(vagon2.getNombre()))
    				vagon2.ocupar(i);
    }
    
    //PRE: 0 <= i < capacidad del vagon nombreVagon
    public void desocuparVagon(int i, String nombreVagon){
    	if (nombreVagon.equals(vagon1.getNombre()))
    		vagon1.desocupar(i);
    	else if (nombreVagon.equals(vagon2.getNombre()))
    				vagon2.desocupar(i);
    }
    
    
}
