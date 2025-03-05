import java.time.LocalDate;
import java.time.Period;

/**
 * Esta clase represneta a una persona.
 * En este caso la persona tiene un nombre, unos apellidos, una edad y un email
 * @author agonzalez
 *
 */
public class Contacto {
	/**
	 * Este atributo contiene el nombre de la peronsa
	 */
	private String nombre; //Nombre de la persona
	/**
	 * Este atributo contiene los apellidos de la persona
	 */
	private String apellidos; //Apellidos de la persona
	/**
	 * número de teléfono del conctaco
	 */
	private String telefono; //Teléfono del contacto
	/**
	 * Este atributo contiene el email de la persona
	 */
	private String email; //Email de la persona
//	/**
//	 * Este atibuto contiene la edad de la perosna. Sería mejor usar java.util.Calendar o java.util.GregorianCalendar
//	 *  y calcular la edad
//	 */
//	private int edad; //Edad de la persona -> Lo ideal sería tener la fecha de nacimiento para poder calcular la edad (java.util.Calendar o java.util.GregorianCalendar)
	private LocalDate fechaNacimiento;
	/**
	 * Constructor 
	 * @param nombre nombre de la persona
	 * @param apellidos apellido o apellidos de la persoma separados por coma
	 * @param email dirección de correo electrónico
	 * @param telefono número de teléfono del contacto
	 * @param dia entero que representa el día en el que nace la persona
	 * @param mes entero que represnta el mes en el que nace la persona
	 * @param anio entero que represnta el año en el que nace la persona
	 */
	public Contacto(String nombre, String apellidos, String email, String telefono, int dia, int mes, int anio) {
		this(nombre,apellidos,email, telefono);
		this.fechaNacimiento =  LocalDate.of(anio, mes, dia);
	}

	/**
	 * Construcotr que solo requiere nombre y apellidos. (sobrecarga de constructores)
	 * @param nombre nombre de la persona
	 * @param apellidos apellidos del contacto separados por coma
	 * @param email dirección de correo electrónico
	 * @param telefono número de teléfono del contacto
	 */
	public Contacto(String nombre, String apellidos, String email, String telefono) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.telefono = telefono;
	}

	/**
	 * Constructor copia
	 * @param contacto contaco a copiar
	 */
	public Contacto (Contacto contacto) {
		this (contacto.nombre,contacto.apellidos, contacto.email, contacto.telefono);
		if (contacto.fechaNacimiento !=null)
		{
			this.fechaNacimiento =  LocalDate.of(contacto.fechaNacimiento.getYear(),
									contacto.fechaNacimiento.getMonth(),
									contacto.fechaNacimiento.getDayOfMonth());
		}
			
	}
	/**
	 * Retorna el nombre de la persona
	 * @return retorna el nombre del contacto
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Retorna los apellidos de la persona
	 * @return  Retorna los apellidos de la persona
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Retorna el email de la persona
	 * @return  Retorna el email de la persona
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Retorna la edad de la persona. Si no se especificó la fecha de nacimiento se retorna -1;
	 * @return Retorna la edad de la persona. Si no se especificó la fecha de nacimiento se retorna -1;
	 */
	public int getEdad() {
		int edad = -1;
		if (this.fechaNacimiento != null) {	//No se ha especifacido fecha de nacimiento
			Period age = Period.between(this.fechaNacimiento, LocalDate.now());
			edad = age.getYears();
		}
		return edad;
		
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Este método retorna cierto cuando un contacto es igual a otro. Dos contactos son iguales cuando coincide el nombre, los apellidos y la edad.
	 * @param contacto con el que se quiere comarar
	 * @return retorna cierto si los dos contactos son iguales falso en caso contrario
	 */
	public boolean esIgual (Contacto contacto) {
		return this.getEdad() == contacto.getEdad() &&
				this.esIgualNombreApellido(contacto);
	}
	
	/**
	 * Retorna cierto si el contacto pasado como parámetro tiene el mismo nombre y apellido que el contacto 
	 * recibido como parámetro
	 * @param contacto contacto con el que se compara
	 * @return retorna cierot si coincide nombre y apellidos
	 */
	public boolean esIgualNombreApellido(Contacto contacto) {
      return 	this.nombre.equalsIgnoreCase(contacto.nombre) &&
				this.apellidos.equalsIgnoreCase(contacto.apellidos);
		
	}
	
	public String toString() {
		return String.format("Nombre: %s; Apellidos: %s, edad: %d", this.nombre, this.apellidos, this.getEdad());
	}

	}
