package ee1;
import anotacion.Programacion2;
import fecha.Fecha;



@Programacion2 (
        nombreAutor1 = "Raul",
		apellidoAutor1 = "Martinez Ortega",
		emailUPMAutor1 = "raul.martinezo@alumnos.upm.es"
)


public class Libro {
	private String titulo;
	private String autor;
	private Fecha fechaPublicacion;
	private int nVecesPrestado;

	public Libro (String titulo, String author, Fecha fechaPublicacion) {
		this.titulo = titulo;
		this.autor = author;
		this.fechaPublicacion = fechaPublicacion;
	}

	public Libro (Libro libro) {
		this.titulo = new String(libro.getTitulo());
		this.autor = new String(libro.getAutor());
		this.fechaPublicacion = new Fecha(libro.getFechaPublicacion());
		this.nVecesPrestado = libro.getNVecesPrestado();
	}

	public void prestado() {
		nVecesPrestado++;
	}

	public boolean esIgual(Libro libro) {
		return this.titulo.equals(libro.getTitulo())
				&& this.autor.equals(libro.getAutor())
				&& this.fechaPublicacion.esIgual(libro.getFechaPublicacion());
	}

	//GETTERS
	public int getNVecesPrestado() {
		return nVecesPrestado;
	}

	public Fecha getFechaPublicacion() {
		return fechaPublicacion;
	}

	public String getAutor() {
		return autor;
	}

	public String getTitulo() {
		return titulo;
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


}
