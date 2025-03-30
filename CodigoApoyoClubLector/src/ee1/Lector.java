package ee1;

import list.ArrayList;

/**
 * 
 */


public class Lector {
	private final int nSocio;
	private String nombre;
	private ArrayList<Libro> historicoLectura;

	public Lector (int nSocio, String nombre) {
		this.nombre = nombre;
		this.nSocio = nSocio;
		historicoLectura = new ArrayList<>();
	}

	public Libro getLibroLeido (int n) {
		if (historicoLectura.size()>0 && historicoLectura.size() >= n)
			return historicoLectura.get(n-1);
		return null;
	}

	public void leerLibro (Libro libro) {
		libro.prestado();
		if (historicoLectura.size()<10)
			historicoLectura.add(historicoLectura.size(), libro);
		else {
			historicoLectura.removeElementAt(0);
			historicoLectura.add(historicoLectura.size(), libro);
		}
	}

	public boolean esIgual (Lector lector) {
		return this.nSocio == lector.nSocio &&
				this.historicoLectura.equals(lector.getHistoricoLectura());
	}
	//GETTERS
	public int getNSocio() {
		return nSocio;
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Libro> getHistoricoLectura() {
		return historicoLectura;
	}

	/**
	 * Indica si este libro es igual a otro
	 * PRE: Cierto
	 * Retorna cierto si los libros coincide: 
	 * el título, el autor y la fecha de publicación. 
	 * En otro caso retorna falso 
	 * @param otro libro con el que se compara
	 * @return cierto si son iguales falso en otro caso
	 */
	@Override
	public boolean equals (Object otro) {
		
		if (!(otro instanceof Lector))
		{
		 return false;
		}
		
		Lector comparar = (Lector) otro;
		return this.esIgual(comparar);
	}
  
}
