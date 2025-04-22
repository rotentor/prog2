package ee1;
import list.ArrayList;
/**
 * 
 */

/**
 * @author ÁngelLucas
 *
 */
public class Lector {
  private int nSocio;
  private String nombre;
  private ArrayList<Libro> historicoLectura;
  private static final int TAMANIO_HISTORICO = 10;

  
  public Lector (int nSocio, String nombre){
	  this.nSocio = nSocio;
	  this.nombre = nombre;
	  //Se reserva memoria para el histórico creando un array de objetos
      this.historicoLectura = new ArrayList<>();	    
  }

  
  private boolean esIgual(Lector comparar) {
	  return this.nSocio == comparar.nSocio &&
				this.historicoLectura.size() == comparar.historicoLectura.size() &&
				this.historicoLectura.equals(comparar.historicoLectura);
  }
  
  /**
   * Indica si dos lectores son iguales. Dos lectores son iguales si:
   * coincide el número de socio y los libros leídos que hay en el histórico
   *  son los mismos y están en el mismo orden
   * @param otro
   * @return
   */ 
  @Override
  public boolean equals (Object other) {
	  if (!(other instanceof Lector)) {
		  return false;
	  }
	  Lector comparar = (Lector) other;
	  return this.esIgual(comparar);
  }
  
  /**
   * El lector ha cogido un libro para leerlo.
   * El libro se inserta en el histórico según se explica
   * en el enunciado 
   * @param leer
   */
  public void leerLibro (Libro leer){//leerLibro
	  int size = this.historicoLectura.size(); 
	if ( size < TAMANIO_HISTORICO)
	{//Hay sitio, por lo que se mete al final
		this.historicoLectura.add(size, leer);
	}
	else{//Está lleno hay que quitar el más antiguo
		for (int i= 1; i<size; i++){//for
			this.historicoLectura.set(i-1,
					this.historicoLectura.get(i));
		}//for
		this.historicoLectura.set(size-1, leer);
	}
	//Se le indica al libro que ha sido prestado
	leer.prestado();
  }//leerLibro
  
  
  //Gets

 /**
  * Este método permitr consultar un libro del histórico <br/>
  * <strong>PRE:</strong> pos debe ser un valor entre 1 y númmero de libros en el histórico
  * @param pos
  * @return si se  cumple la PRE se retorna el libro que está en el histórico en caso contrario se retorna null
  */
 public Libro getLibroLeido(int pos){
	if (pos > 0 && pos <= this.historicoLectura.size()){
		return this.historicoLectura.get(pos-1);
	}
	else
		return null;
 }
 
 /**
 * @return the nSocio
 */
public int getNSocio() {
	return nSocio;
}

/**
 * @return the nombre
 */
public String getNombre() {
	return nombre;
}
  
  
}
