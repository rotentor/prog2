package urgencias;
import list.ArrayList;
import queues.NaiveQueue;

/**
 * Modela la gestión de un servicio de urgencias antenido por un sólo médico con dos colas 
 * de espera según la urgencia del paciente
 *
 */
public class ServicioUrgencias {
	// 2 colas de pacientes esperando para ser atendidos
	// para 2 tipos de pacientes: muy urgentes y urgentes	
	private NaiveQueue<Paciente> pacientesEsperandoMuyUrgentes;
	private NaiveQueue<Paciente> pacientesEsperandoUrgentes;	
	
	// lista de pacientes que ya han sido atendidos por el médico
	private ArrayList<Paciente> pacientesAtendidos;
	
	// paciente dentro de la consulta del médico y que está siendo atendido
	private Paciente pacienteEnConsulta; // null => no hay nadie en consulta
	
	/**
	 * Constructor que se encarga de incializar todas las estructuras
	 */
	public ServicioUrgencias() {
		pacientesEsperandoMuyUrgentes = new NaiveQueue<>();
		pacientesEsperandoUrgentes = new NaiveQueue<>();
		pacientesAtendidos = new ArrayList<>();
	}
	
	/**
	 * PRE: cierto
	 * POST: se añade el paciente a la cola asociada a su tipo. Se guarda la referencia
	 */
	public void registrarPaciente(Paciente paciente, boolean muyUrgente) {
		if (muyUrgente) pacientesEsperandoMuyUrgentes.add(paciente);
		else pacientesEsperandoUrgentes.add(paciente);
	}
	
	
	/**
	 * PRE: Cierto
	 * POST: Si no hay ningún paciente esperando O en la consulta hay alguien, no hace nada. 
	 * e.o.c, el paciente de mayor prioridad que lleva más tiempo 
	 * esperando pasa a la consulta.
	 */
	public void llamarPaciente() {
		if (hayPacienteEsperando() && pacienteEnConsulta == null) {
			if (pacientesEsperandoMuyUrgentes.isEmpty())
				pacienteEnConsulta = pacientesEsperandoUrgentes.poll();
			else
				pacienteEnConsulta = pacientesEsperandoMuyUrgentes.poll();
		}


	}
	
	/**
	 * PRE: hay un paciente en consulta
	 * POST: el paciente en consulta es atendido, se redacta un informe médico
	 * que se guarda en el historial del paciente, y el paciente abandona la consulta. 
	 * Si es la primera visita, se añade al final de la 
	 * lista de pacientes atendidos; en caso contrario no se añade a la lista.
	 */
	public void pasarConsulta(String contenidoInforme) {
		Informe informe = new Informe(contenidoInforme);
		pacienteEnConsulta.guardarInforme(informe);
		if (pacientesAtendidos.indexOf(pacienteEnConsulta) == -1)
			pacientesAtendidos.add(pacientesAtendidos.size(), pacienteEnConsulta);
		pacienteEnConsulta = null;
	}
	
	/**
	 * PRE: cierto
	 * POST: el primer paciente esperando urgente, si existe, pasa a ser el 
	 * último de los muy urgentes. Si no hay ninguno urgente, no se hace nada.
	 */
	public void reclasificarPacienteUrgente() {
		if (!pacientesEsperandoUrgentes.isEmpty())
			pacientesEsperandoMuyUrgentes.add(pacientesEsperandoUrgentes.poll());
	}
	
	/**
	 * PRE: cierto
	 * POST: se indica si hay algún paciente esperando	
	 */
	public boolean hayPacienteEsperando() {		
		return !(pacientesEsperandoUrgentes.isEmpty() && pacientesEsperandoMuyUrgentes.isEmpty());
	}
	
	
	private String getColaPacientes(NaiveQueue<Paciente> cola) {
		String salida = "";
		NaiveQueue<Paciente> aux = new NaiveQueue<>();
		
		while(!cola.isEmpty()) {
			Paciente elem = cola.poll();
			salida += elem + System.lineSeparator();
			aux.add(elem);
		}
		
		while(!aux.isEmpty()) {			
			cola.add(aux.poll());
		}
		
		return salida;
	}
	
	public String toString() {
		return "Consulta:" + pacienteEnConsulta + System.lineSeparator() + 
				getColaPacientes(pacientesEsperandoMuyUrgentes) + "---" + System.lineSeparator() + 
				getColaPacientes(pacientesEsperandoUrgentes) + "Atendidos:" + pacientesAtendidos
				+ System.lineSeparator();
	}
	
}
