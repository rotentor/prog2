package test;

import urgencias.Paciente;
import urgencias.ServicioUrgencias;

public class TestServicioUrgencias {

	public static void main(String[] args) {
		ServicioUrgencias servicio = new ServicioUrgencias();
		
		System.out.println(servicio.hayPacienteEsperando()); // false
		
		Paciente paciente1 = new Paciente("A1");
		
		servicio.registrarPaciente(paciente1, true);
		servicio.registrarPaciente(new Paciente("A2"), true);
		servicio.registrarPaciente(new Paciente("B1"), false);
		servicio.registrarPaciente(new Paciente("B2"), false);
		
		System.out.println(servicio);
		
		servicio.llamarPaciente(); // entra A1
		
		System.out.println(servicio);
		
		servicio.pasarConsulta("IA1"); //pasa A1 a consulta
		
		System.out.println(servicio);
		
		servicio.llamarPaciente(); // entra A2
		servicio.pasarConsulta("IA2");
		servicio.llamarPaciente(); // entra B1
		servicio.pasarConsulta("IB1");
		
		System.out.println(servicio);
		
		servicio.reclasificarPacienteUrgente(); // B2 pasa a muy urgente
		servicio.registrarPaciente(paciente1, true); // paciente1 viene de nuevo
		
		System.out.println(servicio);
		
		System.out.println(servicio.hayPacienteEsperando()); // true
		
		servicio.llamarPaciente(); // entra B2
		servicio.pasarConsulta("IB2");
		servicio.llamarPaciente(); // entra A1 por segunda vez
		servicio.pasarConsulta("IA11"); // segundo informe para A1
		
		System.out.println(servicio); // todos atendidos
		
		

	}

}
