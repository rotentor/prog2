// Colecci�n de contactos, asumiendo que no
// se repiten nombres ni n�meros de tel�fono
public class GuiaTelefonosOrd {
	private Contacto[] guia;
	private int numContactos;

	// Constructor
	public GuiaTelefonosOrd(int capacidad) {
		guia = new Contacto[capacidad];
		numContactos = 0;
	}

	// A�adir contacto
	public void poner(Contacto contacto) {
		if (numContactos < guia.length) {     // hay sitio
			String nombre = contacto.getNombre();
			int i;
			for(i=numContactos-1; 
					i >=0 && 
							guia[i].getNombre().compareTo(nombre) > 0 
							; i--) {
				guia[i+1] = guia[i];
			}
			guia[i+1] = contacto;
			numContactos++;
		}
	}

	// Eliminar contacto
	public void quitar(Contacto contacto) {
		int pos = buscarPos(contacto.getNombre());
		if (pos >= 0) {
			for(int i=pos+1; i<numContactos; i++)
				guia[i-1] = guia[i];
			numContactos--;
		}
	}

	// Presentar con formato
	public String toString() {
		String texto = "";
		for (int k = 0; k < numContactos; k++) {  // procesar todos
			texto = texto + guia[k] + "\n";       // un contacto por l�nea
		}
		return texto;
	}

	
	private int buscarPos(String nombre) {
		int primero = 0;
		int ultimo = numContactos - 1;
		while (primero < ultimo) {
			int centro = (primero + ultimo)/2;
			String nombreC = guia[centro].getNombre();
			int comp = nombreC.compareTo(nombre);
			if (comp > 0) { 
				ultimo = centro - 1;
			} else if (comp < 0) {
				primero = centro + 1;
			} else {
				primero = ultimo = centro;
			}			
		}
		
		return (((primero==ultimo && 
				guia[primero].getNombre().equals(nombre))) ? primero : -1);
				
		/*if ((primero==ultimo) && 
				(guia[primero].getNombre().equals(nombre)))
			return primero;
		else
			return -1;*/
		
		
	}
	
	// B�squedas
	public Contacto buscarNombre(String nombre) {
		int pos = buscarPos(nombre);
		return (pos == -1? null : guia[pos]);
	}
	
	public Contacto buscarNumero(long numero) {
		Contacto con = null;
		for (int k = 0; k < numContactos && con == null; k++) {
			if (guia[k].igualNumero(numero)) con = guia[k];
		}
		return con;
	}
	
	public int contarTelefonosMadrid() {
		int res=0;
		for(int i=0;i<numContactos;i++) {
			if(guia[i].contieneTtlfoMadrid())
				res++;
		}
		return res;
	}
	
	public void reemplazar(String nombre, long numero) {		
		Contacto contacto = this.buscarNombre(nombre);		
		if (contacto != null)
			contacto.setNumero(numero);		
	}
	
	public Contacto[] getTelefonosMadrid() {
		int numTlfosMadrid = contarTelefonosMadrid();
		Contacto[] guiaMadrid=new Contacto[numTlfosMadrid];
		int cont=0;
		for(int k=0;cont < numTlfosMadrid;k++) {
			if(guia[k].contieneTtlfoMadrid()) {
				guiaMadrid[cont]=guia[k];
				cont++;
			}
		}
		return guiaMadrid;
	}

}
