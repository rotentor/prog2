
public class Triangulo {
	private double base, altura;

	public Triangulo(double base1,double altura1) {
		base=base1;
		altura=altura1;
	}

	public double getBase(){
		return base;	
	}

	public double getAltura(){
		return altura;		
	}

	public void setBase(double nuevaBase) {
		base=nuevaBase;
	}

	public void setAltura(double nuevaAltura) {
		altura=nuevaAltura;
	}
	
	
	public double area() {
		return ((base*altura)/2);
	}
	
	public String toString() {
		return "["+ base + "-" + altura + "]";
	}
	
	public Triangulo(Triangulo obj) {
		this.altura = obj.altura;
		this.base = obj.base;	
	}
	
	public boolean esIgual(Triangulo obj) {
		return this.base == obj.base &&
					this.altura == obj.altura;		
	}
}





