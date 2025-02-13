
public class Punto {
	private double x, y;

	public Punto(double xo, double yo) {
		x = xo;
		y = yo;
	}
	
	public Punto(Punto po) {
		x = po.x;
		y = po.y;
	}

	public String toString() {
		return "(" + x + "," + y + ")" ;
	}	

	public boolean esIgual (Punto p) {
		return x == p.x && y == p.y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	public void setX(double x) {
		this.x=x;
	}

	public void setY(double y) {
		this.y=y;
	}


}
