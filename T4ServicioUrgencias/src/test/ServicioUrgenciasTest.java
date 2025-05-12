package test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import urgencias.Informe;
import urgencias.Paciente;
import urgencias.ServicioUrgencias;

public class ServicioUrgenciasTest {
	ServicioUrgencias servicio;
	Paciente [] pacientes = {new Paciente("A1"), new Paciente("A2"),
			new Paciente("B1"),	new Paciente("B2")};
	
	@Before
	public void setUp()  {
		servicio = new ServicioUrgencias();
	}

	@Test
	public void testServicioUrgencias() {
		assertFalse ("Inicialmente no hay pacientes esperando!!!", servicio.hayPacienteEsperando());
	}

	/**
	 * Esta prueba registra un paciente urgente
	 */
	@Test
	public void testRegistrarPaciente1() {
		String expected = "Consulta:null"+ System.lineSeparator()  + 
				"---"+ System.lineSeparator()  + 
				"B1 []"+ System.lineSeparator()  + 
				"Atendidos:[]"+ System.lineSeparator();
		servicio.registrarPaciente(pacientes[2], false);
		assertTrue ("Debería haber pacientes esperando tras insertar un paciente urgente", servicio.hayPacienteEsperando());
		assertEquals("El contenido del servicio de urgencias no coincide",expected, servicio.toString());
	}
	
	/**
	 * Esta prueba registra un paciente muy urgente
	 */
	@Test
	public void testRegistrarPaciente2() {
		String expected = "Consulta:null"+ System.lineSeparator()  + 
				"A1 []"+ System.lineSeparator()  + 
				"---"+ System.lineSeparator()  + 
				"Atendidos:[]"+ System.lineSeparator();
		servicio.registrarPaciente(pacientes[0], true);
		assertTrue ("Debería haber pacientes esperando tras insertar un paciente muy urgente", servicio.hayPacienteEsperando());
		assertEquals("El contenido del servicio de urgencias no coincide",expected, servicio.toString());
	}
	
	/**
	 * Esta prueba registra dos pacientes muy urgentes y dos pacientes urgentes
	 */
	@Test
	public void testRegistrarPaciente3() {
		String expected = "Consulta:null"+ System.lineSeparator()  +
						"A1 []"+ System.lineSeparator()  +
						"A2 []"+ System.lineSeparator()  +
						"---"+ System.lineSeparator()  +
						"B1 []"+ System.lineSeparator()  +
						"B2 []"+ System.lineSeparator()  +
						"Atendidos:[]" + System.lineSeparator();
		insertarPacientes(pacientes,new boolean[]{true,true,false,false});
		assertEquals("El contenido del servicio de urgencias no coincide",expected, servicio.toString());
	}
	
	/**
	 * Esta prueba consiste en llamar al primer paciente esperando cuando se tienen dos pacientes muy urgentes y dos urgentes
	 */
	@Test
	public void testLlamarPaciente() {
		String expected = "Consulta:A1 []"+ System.lineSeparator()  +
				"A2 []"+ System.lineSeparator()  +
				"---"+ System.lineSeparator()  +
				"B1 []"+ System.lineSeparator()  +
				"B2 []"+ System.lineSeparator()  +
				"Atendidos:[]" + System.lineSeparator();
		insertarPacientes(pacientes,new boolean[]{true,true,false,false});
		servicio.llamarPaciente();
		assertEquals("El contenido del servicio de urgencias no coincide",expected, servicio.toString());
	}
	
	/**
	 * Esta prueba consiste en llamar a un paciente cuando ya hay otro en consulta 
	 */
	@Test
	public void testLlamarPaciente2() {
		String expected = "Consulta:A1 []"+ System.lineSeparator()  +
				"A2 []"+ System.lineSeparator()  +
				"---"+ System.lineSeparator()  +
				"B1 []"+ System.lineSeparator()  +
				"B2 []"+ System.lineSeparator()  +
				"Atendidos:[]" + System.lineSeparator();
		insertarPacientes(pacientes,new boolean[]{true,true,false,false});
		servicio.llamarPaciente();
		assertEquals("El contenido del servicio de urgencias no coincide",expected, servicio.toString());
		servicio.llamarPaciente();
		assertEquals("Se modifica la lista de espera cuando se intenta llamar a un paciente y ya hay otro en consulta",expected, servicio.toString());
		
	}

	@Test
	public void testPasarConsulta() {
		String expected = "Consulta:null"+ System.lineSeparator()  +
				"A2 []"+ System.lineSeparator()  +
				"---"+ System.lineSeparator()  +
				"B1 []"+ System.lineSeparator()  +
				"B2 []"+ System.lineSeparator()  +
				"Atendidos:[A1 [IA1 "+LocalDate.now()+"]]" + System.lineSeparator();
		insertarPacientes(pacientes,new boolean[]{true,true,false,false});
		servicio.llamarPaciente();
		servicio.pasarConsulta("IA1"); //pasa A1 a consulta
		assertEquals("El contenido del servicio de urgencias no coincide",expected, servicio.toString());
	}

	/**
	 * Prueba que se ordenan bien los informes cuando un paciente pasa más de una vez por consulta
	 */
	@Test
	public void testPasarConsulta2() {
		String expected = "Consulta:null"+ System.lineSeparator()  +
				"---"+ System.lineSeparator()  +
				"A2 []"+ System.lineSeparator()  +
				"B1 []"+ System.lineSeparator()  +
				"B2 []"+ System.lineSeparator()  +
				"Atendidos:[A1 [IA2 "+LocalDate.now()+",\n" +
				"IA1 "+LocalDate.now()+"]]" + System.lineSeparator();
		insertarPacientes(pacientes,new boolean[]{true,false,false,false});
		servicio.llamarPaciente();
		servicio.pasarConsulta("IA1"); //pasa A1 a consulta
		servicio.registrarPaciente(pacientes[0], true); //Vuelve a entrar
		servicio.llamarPaciente();
		servicio.pasarConsulta("IA2");
		assertEquals("El contenido del servicio de urgencias no coincide",expected, servicio.toString());
	}
	
	/**
	 * Prueba que se ordenen bien los informes cuando un paciente pasa más de una vez por consulta
	 * Se añaden informes anteriores y posteriores a un paciente para verificar que todo se ordena bien
	 */
	@Test
	public void testPasarConsulta3() {
		LocalDate dateOld = LocalDate.of(2019, 03, 22);
		LocalDate dateFuture = LocalDate.now().plusDays(5);
		String expected = "Consulta:null"+ System.lineSeparator()  +
				"---"+ System.lineSeparator()  +
				"A2 []"+ System.lineSeparator()  +
				"B1 []"+ System.lineSeparator()  +
				"B2 []"+ System.lineSeparator()  +
				"Atendidos:[A1 [IA3 "+dateFuture+",\n"+
				"IA2 "+LocalDate.now()+",\n" +
				"IA1 "+LocalDate.now()+",\n"+
				"IA0 "+dateOld+ "]]" +
				System.lineSeparator();
		//Se cargan informes en paciente para verificar que todo se ordena bien
		pacientes[0].guardarInforme(new InformeHack("IA0", dateOld));
		pacientes[0].guardarInforme(new InformeHack("IA3", dateFuture));
		insertarPacientes(pacientes,new boolean[]{true,false,false,false});
		servicio.llamarPaciente();
		servicio.pasarConsulta("IA1"); //pasa A1 a consulta
		servicio.registrarPaciente(pacientes[0], true); //Vuelve a entrar
		servicio.llamarPaciente();
		servicio.pasarConsulta("IA2");
		assertEquals("El contenido del servicio de urgencias no coincide",expected, servicio.toString());
	}
	
	@Test
	public void testReclasificarPacienteUrgente() {
		String expected = "Consulta:null"+ System.lineSeparator()  +
				"A1 []"+ System.lineSeparator()  +
				"A2 []"+ System.lineSeparator()  +
				"B1 []"+ System.lineSeparator()  +
				"---"+ System.lineSeparator()  +
				"B2 []"+ System.lineSeparator()  +
				"Atendidos:[]" + System.lineSeparator();
		insertarPacientes(pacientes,new boolean[]{true,true,false,false});
		servicio.reclasificarPacienteUrgente();
		assertEquals("El contenido del servicio de urgencias no coincide",expected, servicio.toString());
	}

	@Test
	public void testHayPacienteEsperando() {
		insertarPacientes(pacientes,new boolean[]{true,false,false,false});
		assertTrue ("Debería haber un paciente muy urgente y tres ugrentes", servicio.hayPacienteEsperando());
		for (int i= 0; i< pacientes.length-1;i++) {
			servicio.llamarPaciente();
			servicio.pasarConsulta("IA-"+i);
			assertTrue ("Aún debería haber pacientes", servicio.hayPacienteEsperando());
		}
		servicio.llamarPaciente();
		servicio.pasarConsulta("IA-"+pacientes.length);
		assertFalse ("Inicialmente no hay pacientes esperando!!!", servicio.hayPacienteEsperando());
		
	}
	
	/**
	 * Este método auxiliar registra los pacientes en el serevicio de urgencia para hacer las pruebas
	 * Ambos arrays deben tener el mismo número de elementos
	 * @param pacientes 
	 * @param muyUrgentes
	 */
	private void insertarPacientes(Paciente []pacientes, boolean [] muyUrgentes) {
		
		for (int i = 0; i< pacientes.length; i++) {
			servicio.registrarPaciente(pacientes[i], muyUrgentes[i]);
		}
	}
	
	//Calse auxiliar
	class InformeHack extends Informe{//InformeHack
		LocalDate dateHack;
		public InformeHack(String contenido, LocalDate date) {
			super(contenido);
			this.dateHack = date;
		}
		
		@Override
		public LocalDate getFecha() {
		 return dateHack;	
		}
		
		@Override
		public String toString() {
			//DateFormat formatter = new SimpleDateFormat("yyyy-MMM-dd");
			return this.getContenido() + " " + dateHack;
		}
		
	}//InformeHack
}
