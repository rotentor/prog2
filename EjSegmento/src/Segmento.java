
public class Segmento {
	private Punto a, b;

	public Segmento(Punto a, Punto b) {
		this.a = a;
		this.b = b;		
	}

	public String toString() {
		return "a: " + a.toString() + " b: " + b.toString();		
	}

	public double longitud(){
		return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + 
				Math.pow(a.getY() - b.getY(), 2));
	}

	public void desplazar(double dx, double dy) {
		a.setX(a.getX()+dx);
		a.setY(a.getY()+dy);
		b.setX(b.getX()+dx);
		b.setY(b.getY()+dy);
	}
	public Punto puntoMedio(){
		Punto puntoMed = new Punto (0,0);
		puntoMed.setX((a.getX()+b.getX())/2);
		puntoMed.setY((a.getY()+b.getY())/2);
		return puntoMed;
	}

	public Punto puntoMedio1(){
		Punto puntoMed = new Punto ((a.getX()+b.getX())/2,
				(a.getY()+b.getY())/2);

		return puntoMed;

		// también así:
		//return new Punto ((a.getX()+b.getX())/2,
		//		(a.getY()+b.getY())/2);
	}

	public boolean esIgual(Segmento s) {
		return(a.esIgual(s.a) &&b.esIgual(s.b) || 
				a.esIgual(s.b) &&b.esIgual(s.a));
	}
	
	public Segmento (Segmento s) {
		a= new Punto(s.a);
		b= new Punto(s.b);
	}
	
	

}
