import java.util.Scanner;

import partidas.PartidaTresEnRaya;
import partidas.TEstadoPartida;

public class JugarTresEnRaya {

	private static int fila, columna;

	private static Scanner teclado = new Scanner(System.in);
	private static PartidaTresEnRaya partida;

	private static void pedirMovimiento() {
		do {
			System.out.print("Introduce la fila:");
			fila = teclado.nextInt();
			System.out.print("Introduce la columna:");
			columna = teclado.nextInt();
		} while(!partida.esMovimientoValido(fila, columna)); // movimiento no válido
	}

	public static void main(String[] args) {
		partida = new PartidaTresEnRaya();
		TEstadoPartida estado;
		do {
			//pedir un movimiento al jugador que tenga el turno
			pedirMovimiento();			
			//realizar el movimiento (actualiza el estado de la partida)
			partida.realizarMovimiento(fila, columna);
			//mostramos en la pantalla el estado de la partida
			System.out.print(partida);
			estado = partida.getEstado();
		} while (estado == TEstadoPartida.JUEGA_J1 ||
				estado == TEstadoPartida.JUEGA_J2); // no es fin de partida
		
		switch(estado) {
			case EMPATE:
				System.out.println("Habéis empatado");
				break;
			case GANA_J1:
				System.out.println("Ha ganado el jugador 1");
				break;
			default:
				System.out.println("Ha ganado el jugador 2");
		}

	}

}
