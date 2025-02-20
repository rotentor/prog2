public class Vagon {
	// estado de ocupación de los asientos (false = libre)
    private boolean[] asientos; 
    private String nombre;
    
    //PRE: capacidad > 0
    public Vagon(String nombre, int capacidad){
        this.nombre = nombre;
        this.asientos = new boolean[capacidad];
    }
    
    //PRE: 0 <= i < asientos.length
    public void ocupar(int i){
    	asientos[i] = true;
    }
    
    //PRE: 0 <= i < asientos.length
    public void desocupar(int i){
    	asientos[i] = false;
    }
    
    public boolean hayDosLibresConsecutivos(){
    	for (int i=0; i<asientos.length-1; i++) { //El último es comprobado por el penúltimo
            if (!asientos[i]) {
                i++; //No reevaluar i+1 si fuera true
                if (!asientos[i]) return true;
            }
        }
    	return false;
    }   
    
    public String toString(){
        String s = nombre;
        for(int i=0; i<asientos.length; i++)
            s += " " + asientos[i];
        return s;
    }

    public String getNombre() {
        // TODO Auto-generated method stub
        return nombre;
    }

  
    
}
