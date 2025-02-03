
public class TestRectangulo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangulo rectangulo, rectangulo1;
		
		rectangulo = new Rectangulo(2, 3);
		rectangulo1 = new Rectangulo(1, 2);
		
		double area = rectangulo1.area();
		
		System.out.println("El area es: " + area);
		
		System.out.println(rectangulo.getLado1());
		
		System.out.println("antes:" + rectangulo.toString());
		
		rectangulo.setLado1(5);
		
		System.out.println("después:" + rectangulo.toString());

	}

}
