
public class TestTriangulo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Triangulo triangulo1= new Triangulo(2,3);
		System.out.println("Altura inicial:" + triangulo1.getAltura() + 
				" Base inicial:"+ triangulo1.getBase());
		//Modificamos los valores
		triangulo1.setAltura(5);
		triangulo1.setBase(6);
		
		System.out.println("Nuevos valores de triangulo 1: " + triangulo1.toString());
		
		Triangulo triangulo2= new Triangulo(5.2,3.1);
		System.out.println("Altura inicial:" + triangulo2.getAltura() + 
				" Base inicial:"+ triangulo2.getBase() + " Área: " + triangulo2.area());
		

	}

}
