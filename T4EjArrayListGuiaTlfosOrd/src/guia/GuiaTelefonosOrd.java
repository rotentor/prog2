// Colecci�n de contactos, asumiendo que no
// se repiten nombres ni n�meros de tel�fono
package guia;

import list.ArrayList;

public class GuiaTelefonosOrd {
	private ArrayList<Contacto> guia;
	//private int numContactos;

	// Constructor
	public GuiaTelefonosOrd() {
		guia = new ArrayList<Contacto>();
	}

	// A�adir contacto
	public void poner(Contacto contacto) {
		String nombre = contacto.getNombre();
		int i;
		for(i=guia.size()-1; 
				i >=0 && 
						guia.get(i).getNombre().compareTo(nombre) > 0 
						; i--);
		
		guia.add(i+1, contacto);
	}

	// Eliminar contacto
	public void quitar(Contacto contacto) {
		int pos = buscarPos(contacto.getNombre());
		if (pos >= 0) {
			guia.removeElementAt(pos);
		}
	}

	// Presentar con formato
	public String toString() {
		return guia.toString();
	}


	private int buscarPos(String nombre) {
		int primero = 0;
		int ultimo = guia.size() - 1;
		while (primero < ultimo) {
			int centro = (primero + ultimo)/2;
			String nombreC = guia.get(centro).getNombre();
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
				guia.get(primero).getNombre().equals(nombre))) ? primero : -1);

		/*if ((primero==ultimo) && 
				(guia[primero].getNombre().equals(nombre)))
			return primero;
		else
			return -1;*/


	}

	// B�squedas
	public Contacto buscarNombre(String nombre) {
		int pos = buscarPos(nombre);
		return (pos == -1? null : guia.get(pos));
	}

	public Contacto buscarNumero(long numero) {
		Contacto con = null;
		for (int k = 0; k < guia.size() && con == null; k++) {
			if (guia.get(k).igualNumero(numero)) con = guia.get(k);
		}
		return con;
	}

	public int contarTelefonosMadrid() {
		int res=0;
		for(int i=0;i<guia.size();i++) {
			if(guia.get(i).contieneTtlfoMadrid())
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
			if(guia.get(k).contieneTtlfoMadrid()) {
				guiaMadrid[cont]=guia.get(k);
				cont++;
			}
		}
		return guiaMadrid;
	}

}
