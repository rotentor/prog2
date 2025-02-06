
public class Punto {
	private double x, y;

	public Punto(double xo, double yo) {
		x = xo;
		y = yo;
	}

	public String toString() {
		return "(" + x + "," + y + ")" ;
	}	

	public boolean esIgual (Punto p) {
		return x == p.x && y == p.y;
	}
}
