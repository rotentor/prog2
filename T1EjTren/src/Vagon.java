
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
    	int i;
    	for(i=0; i < asientos.length-1 && 
    			(asientos[i] || asientos[i+1]); i++);
    		
    	return i < asientos.length-1;
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
