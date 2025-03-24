package tableros;

public class Tablero {
	private char[][] tablero;
	public final static char CASILLA_VACIA = ' ';
	
	public Tablero(int noFilas, int noColumnas) {
		tablero = new char[noFilas][noColumnas];	
		for (int i=0; i<noFilas; i++)
			for(int j=0; j<noColumnas; j++)
				tablero[i][j] = CASILLA_VACIA;	
	}
	
	public char getCasilla(int fila, int columna) {
		return tablero[fila][columna];
	}
	
	public void setCasilla(int fila, int columna, char ficha) {
		tablero[fila][columna] = ficha;
	}
	
	public String toString() {
		String salida = "";
		for (int i=0; i<tablero.length; i++) {
			salida += "|";
			for(int j=0; j<tablero[0].length; j++)
				salida += tablero[i][j] + "|";
			salida += "\n";
		}
		return salida;
	}
}
