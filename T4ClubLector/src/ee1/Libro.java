package ee1;
import anotacion.Programacion2;
import fecha.Fecha;



@Programacion2 (
        nombreAutor1 = "XXX",
		apellidoAutor1 = "XXX",
		emailUPMAutor1 = "XXX"
)

/**
 * @author ÁngelLucas
 *
 */
public class Libro {
	private String titulo;
	private String autor;
	private Fecha fechaPublicacion;
	private int nVecesPrestado;
	
	public Libro(String titulo, String autor, Fecha fechaPub){//Constructor
		this.titulo = titulo;
		this.autor = autor;
		//Se saca copia de la decha de publicación para
		//evitar que pueda ser modificada desde fuera
		this.fechaPublicacion = new Fecha (fechaPub);
	}//Constructor

	/**
	 * Construcotr copia
	 * @param copiar crea un nueva instancia tomando como referencia la que se pasa
	 */
   public Libro (Libro copiar) {
    /** en general, no es necesario sacar copias de los strings porque son inmutables, 
     * pero el enunciado indicaba que había que sacar copias de todos los atributos
     */
	   this.titulo = new String(copiar.titulo); 
	   this.autor = new String(copiar.autor);
	   this.nVecesPrestado = copiar.nVecesPrestado;
	   this.fechaPublicacion = new Fecha (copiar.fechaPublicacion);
   }
//Servicios que ofrecen las instancias
	/**
	 * Este servicio se utiliza apra actualziar
	 * la cuenta de las veces que ha sido prestado
	 * este libro
	 */
	public void prestado (){
		this.nVecesPrestado ++;
	}
	
	
	private boolean esIgual(Libro comparar) {
		return 	this.titulo.equals(comparar.titulo) &&
				this.autor.equals(comparar.autor) &&
				this.fechaPublicacion.esIgual(comparar.fechaPublicacion);
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
		
		if (!(otro instanceof Libro))
		{
		 return false;
		}
		
		Libro comparar = (Libro) otro;
		return this.esIgual(comparar);
	}
	
	/*public String toString(){//toString
		return this.titulo+", "+this.autor+", leído: "+this.nVecesPrestado;
	}*/
	
//Gets	
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @return the autor
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * @return una copia de fechaPublicacion
	 */
	public Fecha getFechaPublicacion() {
		return new Fecha(fechaPublicacion);
	}

	/**
	 * @return the nVecesPrestado
	 */
	public int getNVecesPrestado() {
		return nVecesPrestado;
	}

}
