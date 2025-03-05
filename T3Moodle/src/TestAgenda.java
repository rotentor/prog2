/**
 * 
 */

/**
 * @author angel
 *
 */
public class TestAgenda {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int CAPACIDAD_AGENDA = 8;
		{//Test1
			//Esta prueba inserta los datos en orden
			Contacto[] contactosOrdenados = new Contacto[]{
			 new Contacto("A1", "Ap1, Ap1.2","", "", 22, 02, 2000),
			 new Contacto("A1", "Ap1, Ap2","", "", 23, 02, 2001),
			 new Contacto("A1", "Ap1, Ap2","", "", 22, 02, 2000),
			 new Contacto("B1", "Ap1, Ap3","", "", 25, 05, 2010)
			};
			SortedAgenda agenda = new SortedAgenda (CAPACIDAD_AGENDA);
			boolean bOK = true;
			//Se añaden los contactos
			for (int i = 0; i< contactosOrdenados.length && bOK; i++) {//FOR
			 bOK= agenda.aniadirContacto(contactosOrdenados[i]);
			}//FOR
			if (bOK){//IF
			 System.out.println ("Insercción OK");
			}//IF
			if (contactosOrdenados.length == agenda.ocupacionAgenda()){//IF
			 System.out.println ("Ocupación OK");
			}//IF
			else{//ELSE
			 System.out.println ("La ocupación debe ser "+contactosOrdenados.length);
			}//ELSE	
			//Método auxiliar que verifica que la solución respete el orden	 
			verificarOrden(" cuando se han insertado los contactos ordenados ", agenda, contactosOrdenados);
		}
		
		{//Test2
			//Esta prueba inserta los datos en orden inverso
			Contacto[] contactosOrdenados = new Contacto[]{
			 new Contacto("A1", "Ap1, Ap1.2","", "", 22, 02, 2000),
			 new Contacto("A1", "Ap1, Ap2","", "", 23, 02, 2001),
			 new Contacto("A1", "Ap1, Ap2","", "", 22, 02, 2000),
			 new Contacto("B1", "Ap1, Ap3","", "", 25, 05, 2010)
			};
			SortedAgenda agenda = new SortedAgenda (CAPACIDAD_AGENDA);
			boolean bOK = true;
			for (int i = contactosOrdenados.length-1; i >=0 && bOK;i--) {
				bOK = agenda.aniadirContacto(contactosOrdenados[i]);
			}
			if (bOK){//IF
			 System.out.println ("Insercción OK");
			}//IF

			if (contactosOrdenados.length == agenda.ocupacionAgenda()){//IF
			 System.out.println ("Ocupación OK");
			}//IF
			else{//ELSE
			 System.out.println ("La ocupación debe ser "+contactosOrdenados.length);
			}//ELSE	
			//Método auxiliar que verifica que la solución respete el orden	 
			verificarOrden(" cuando se han insertado los contactos ordenados en orden inverso ", agenda,contactosOrdenados );
		}

		{
			//Borra el primer elemento de la agenda
			//Inicialización de la agenda
			Contacto[] contactosOrdenados = new Contacto[]{
					new Contacto("A1", "Ap1, Ap1.2","", "", 22, 02, 2000),
					new Contacto("A1", "Ap1, Ap2","", "", 23, 02, 2001),
					new Contacto("A1", "Ap1, Ap2","", "", 22, 02, 2000),
					new Contacto("B1", "Ap1, Ap3","", "", 25, 05, 2010)
			};
			SortedAgenda agenda = new SortedAgenda (CAPACIDAD_AGENDA);

			for (Contacto contacto : contactosOrdenados) {
				agenda.aniadirContacto(contacto);
			}
			//Se crea una copia exacta del contacto
			Contacto buscado = new Contacto (contactosOrdenados[0]);
			//Se borra
			boolean bOK = agenda.borrarContacto(buscado);
			if (!bOK || agenda.buscarContacto(buscado) != null
					|| (contactosOrdenados.length-1) != agenda.ocupacionAgenda()){
				System.out.println ("Error al intentar borrar: "+ buscado);
			}
			else
			{
				System.out.println ("Se borra correctamente el primer elemento de la agenda");
			}
		}

		{

//Esta prueba inserta los datos en cualquier orden
			Contacto[] contactosOrdenados = new Contacto[]{
					new Contacto("A1", "Ap1, Ap1.2","", "", 22, 8, 2000),
					new Contacto("A1", "Ap1, Ap2","", "", 23, 8, 2001),
					new Contacto("A1", "Ap1, Ap2","", "", 22, 8, 2000),
					new Contacto("B1", "Ap1, Ap3","", "", 25, 7, 2010)
			};
			SortedAgenda agenda = new SortedAgenda (CAPACIDAD_AGENDA);

			agenda.aniadirContacto(contactosOrdenados[2]);
			agenda.aniadirContacto(contactosOrdenados[1]);
			agenda.aniadirContacto(contactosOrdenados[3]);
			agenda.aniadirContacto(contactosOrdenados[0]);
			verificarOrden(" cuando se han insertado los contactos ordenados están desordenados ", agenda, contactosOrdenados);
			for (int i= 1; i <= agenda.ocupacionAgenda(); i++) {
				System.out.println("Contaco ("+i+") "+agenda.darContactoPos(i));
			}
		}
	}

	private static void verificarOrden(String info, SortedAgenda agenda, Contacto [] contactosOrdenados) {//Verificar
		//Se procede a verificar
		for (int i = 0; i < contactosOrdenados.length && i < agenda.ocupacionAgenda(); i++) {//FOR
			Contacto aux = agenda.darContactoPos(i+1);
			 if (aux==null || aux != contactosOrdenados[i]){//IF
			     System.out.println ("Error verificando el contacto "+(i+1)+info+aux+"!="+ contactosOrdenados[i]); //Se verifica que se la misma instancia. Agenda no saca copia ni retorna una copia
			 }//IF
		}//FOR
			
	}//Verificar

}
