public class SortedAgenda {
	private Contacto [] contactos;
	private int nContactos = 0;
	/**
	 * PRE: maxContactos &gt; 0
	 * Constructor que inicializa la agenda para un n�mero m�ximo de contactos
	 * @param maxContactos n�mero m�ximo de contactos que va a haber
	 */
	public SortedAgenda(int maxContactos) {
		this.contactos = new Contacto [maxContactos];
	}

	/**
	 * PRE: El contacto no est� ya en la agenda y ocupacionAgenda() &lt; capacidadAgenda()
	 * M�todo que a�ade un contacto nuevo a la agenda siguiendo el orden establecido. La agenda no saca copia del contacto dado. 
	 * Es decir la agenda se queda con una copia de la referencia al contacto que se le pasa como par�metro
	 * @param contacto Referenica del conctaco que se a�ade.
	 * @return cierto si se inserta faslo si no se ha podido insertar
	 */

	private int findPos (Contacto contacto) {
		int primero = 0;
		int ultimo = ocupacionAgenda();
		while (primero < ultimo) {
			int mitad = (primero+ultimo) / 2;
			if (contactos[mitad] == null) {
				ultimo --;
			} else if (enOrden(contacto, contactos[mitad])) { //contacto < mitad
				ultimo = mitad - 1;
			} else if (enOrden(contactos[mitad], contacto)) { //contacto > mitad
				primero = mitad + 1;
			} else {
				primero = mitad;
				ultimo = mitad;
			}
		}
		return primero;
	}
	 
	public boolean aniadirContacto (Contacto contacto) {// throws  ErrorAgendaLlena{
		boolean success = false;
		//Verificar la PRE. Si la pre no se cumple retornar falso
		if (buscarContacto(contacto) == null && ocupacionAgenda() < tamanioAgenda()) {
			//TODO: Implementar el m�todo
			int pos = findPos(contacto); //pos en la que colocar
			if (contactos[pos] != null) {
				contactos[nContactos] = contactos[nContactos-1];
				for (int i=nContactos; i>pos; i--) {
					contactos[i] = contactos[i-1];
				}
			}
			contactos[pos] = contacto;
			nContactos ++;
			success = true;
		}
		return success;
		
	
	}
	
	/**
	 * Este m�todo borra la primera ocurrencia de un contacto de la agenda que tenga el nombre y apellidos dados
	 * @param contacto que se queire borrar
	 * @return cierto si el conctacto se encuentra y se borra. Falso en caso contrario
	 */
	public boolean borrarContacto (Contacto contacto) {
		//TODO
		int pos = findPos(contacto);
		boolean success = false;
		if (contactos[pos]!=null && contacto.esIgual(contactos[pos])) {
			for (int i=pos; i<nContactos; i++) {
				contactos[i] = contactos[i+1];
			}
			contactos[nContactos] = null;
			nContactos--;
			success = true;
		}
		return success;

	}
	
	/**
	 * M�todo que retorna la referenica del primer contacto que hay en la agenda que tiene 
	 * el mismo nombre y apellido que el dado. Si el contacto no se encuentra se retorna null.
	 * @param contacto contacto que se busca
	 * @return retorna la referencia al primer conctacto con el nombre y apellidos dados o null si el contacto no se encuentra.
	 */
	public Contacto buscarContacto (Contacto contacto) {
		int pos = posCambioOrden (contacto);
		if (pos == nContactos || !contactos[pos].esIgual(contacto)) {//IF
			return null; //No est� el concacto
		}//IF
		return contactos[pos];
	}
	
	
	/**
	 * PRE: pos est� entre uno y n donde n es la ocupaci�n actual de la agenda
	 * @param pos posici�n de la que se quiere el contacto
	 * @return retoran una referencia al concato de la posici�n indicada
	 * @throws IndexOutOfBoundsException Excpeci�n que se genera si la posici�n no cumple la precondici�n
	 */
	public Contacto darContactoPos(int pos) throws IndexOutOfBoundsException{
		//Verificar PRE y si no se cumple lanzar excepci�n
		if (pos <=0 || pos > this.ocupacionAgenda()) {
			//No se cumple la PRE
			throw new IndexOutOfBoundsException ("La posici�n "+pos+ " esta fuera del rango v�lido ["+1+", "+ this.ocupacionAgenda()+"]");
		}

		return this.contactos[pos-1]; //DUMMY
		
	}
	
	/**
	 * Este m�todo retorna cierto si la agenda est� llena y falso en otro caso
	 * @return cierto si la agenda est� llena y no admite m�s contactos
	 */
	public boolean estaLlena() {
		return this.ocupacionAgenda() == this.tamanioAgenda();
	}
	
	/**
	 * Este m�todo retorna el n�mro de contactos que hay en la agenda
	 * @return retorna la ocupaci�n de la agenda
	 */
	public int ocupacionAgenda() {
		return nContactos; //DUMMY
	}
	
	/**
	 * Este m�todo retorna cuantas entradas puede albergar como m�ximo la agenda
	 * @return n�mero m�ximo de entradas que puede tener la agenda.
	 */
	public int tamanioAgenda() {
		return contactos.length; 	
	}
	

	
	//M�todos auxiliares
	
	
	/**
	 * Este m�todo retorna la posici�n del primer contacto que no sigue el orden con el contato dado. Esto puede deberse a que sea
	 * igual al contacto dado o a que el contatco dado ya no respeta el orden establecido con el contado de esa posici�n
	 * Si el contacto no existe se retorna nContacos.
	 * @param contacto para el que se busca en que posici�n del array est� o se ha producido el cambio de orden
	 * @return retorna la posici�n en la que se deja de respetar el orden establecido.
	 */
	private int posCambioOrden (Contacto contacto) {
		int pos = -1;
		for (int i = 0; i < nContactos && pos == -1; i++)
		{
			if (!enOrden(contactos[i], contacto)) {
				pos = i; //Se encontr� un cambio de orden
			}
		}
		return (pos != -1)? pos : nContactos;
	}
	
	/**
	 * Este m�todo retorna cierto si contacto1 y contacto2 est�n en el orden establecido. En este
	 * caso que contacto1 sea menor que contacto2
	 * @param contacto1 contacto con el que se compara contacto2
	 * @param contacto2 contaco con el que se compara contacto1
	 * @return cierto si contacto1 es menor que contacto2
	 */
	private boolean enOrden (Contacto contacto1, Contacto contacto2) {
		int compApellidos = contacto1.getApellidos().compareTo(contacto2.getApellidos());
		if (compApellidos != 0 )
			return compApellidos < 0; // Es menor si es negativo si es mayor que cero es mayor
		int compNombre = contacto1.getNombre().compareTo(contacto2.getNombre());
		if ( compNombre != 0)
			return compNombre < 0;// Es menor si es negativo si es mayor que cero es mayor
	
		return contacto1.getEdad() < contacto2.getEdad();  
	}
}