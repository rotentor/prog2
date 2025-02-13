
public class Segmento {
	private Punto a, b;
	
	public Segmento(Punto a, Punto b) {
		this.a = a;
		this.b = b;		
	}
	
	public String toString() {
		return "a: " + a.toString() + " b: " + b.toString();		
	}

	public double longitud() {
		return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) +
				Math.pow(a.getY(), 2));
	}

	public void desplazar(double dx, double dy) {
		a.setX(a.getX())
	}

	public Punto puntoMedio() { //devuelve el punto medio del segmento

	}

	public boolean esIgual(Segmento s) {
		return a.esIgual(s.a) && b.esIgual(s.b);
	}

	public Segmento(Segmento s) { //constructor de copia

	}

	public double longitud() {

	}

}
