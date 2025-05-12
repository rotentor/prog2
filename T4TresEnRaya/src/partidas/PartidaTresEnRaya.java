package partidas;

import tableros.Tablero;

public class PartidaTresEnRaya {

	private Tablero tablero;
	private TEstadoPartida estado;
	private int noMovimientos;

	private final static char FICHA_J1 = 'X';
	private final static char FICHA_J2 = 'O';

	public PartidaTresEnRaya() {
		tablero = new Tablero(3, 3);
		estado = TEstadoPartida.JUEGA_J1;
		noMovimientos = 0;
	}

	private boolean esCoordCorrecta(int x) {
		return x <= 2 && x >= 0;
	}

	public boolean esMovimientoValido(int fila, int columna) {
		return esCoordCorrecta(fila) && esCoordCorrecta(columna) &&
				tablero.getCasilla(fila, columna) == Tablero.CASILLA_VACIA ;
	}

	//PRE: el movimiento es válido Y no fin de partida antes del movimiento
	public void realizarMovimiento(int fila, int columna) {
		// colocamos la ficha
		if (estado == TEstadoPartida.JUEGA_J1)
			tablero.setCasilla(fila, columna, FICHA_J1);
		else
			tablero.setCasilla(fila, columna, FICHA_J2);

		noMovimientos++;
		// actualizar estado de la partida
		if (hayVictoria(fila, columna))
			if (estado == TEstadoPartida.JUEGA_J1)
				estado = TEstadoPartida.GANA_J1;
			else
				estado = TEstadoPartida.GANA_J2;		
		else if (hayEmpate())
			estado = TEstadoPartida.EMPATE;
		else
			estado = (estado == TEstadoPartida.JUEGA_J1? TEstadoPartida.JUEGA_J2 :
				TEstadoPartida.JUEGA_J1);
	}

	private boolean hayVictoria(int fila, int columna) {
		boolean resultado = false;
		char ficha = this.tablero.getCasilla(fila, columna);
		// Empezamos por la fila
		int j;
		for(j=0; j < 3 && ficha == tablero.getCasilla(fila, j); j++);
		if (j == 3) resultado = true;
		// Comprobamos la columna
		int i;
		for(i=0; i < 3 && ficha == tablero.getCasilla(i, columna); i++);
		if (i == 3) resultado = true;
		// Comprobamos las diagonales
		if(fila == columna) {
			//Comprobar la diagonal principal
			for(i=0; i < 3 && ficha == tablero.getCasilla(i, i); i++);
			if (i == 3) resultado = true;
		}
		if(fila + columna == 2) {
			//Comprobar la diagonal opuesta
			for(i=0; i < 3 && ficha == tablero.getCasilla(i, 2 - i); i++);
			if (i == 3) resultado = true;
		}
		return resultado;
	}

	private boolean hayEmpate() {
		// TODO Auto-generated method stub
		return noMovimientos == 9;
	}

	public TEstadoPartida getEstado() {
		// TODO Auto-generated method stub
		return estado;
	}
	
	public String toString() {
		return tablero + "" + estado + "\n";
	}

}
