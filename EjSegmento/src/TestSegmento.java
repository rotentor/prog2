
public class TestSegmento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Punto am = new Punto(1, 2);
		Punto bm = new Punto(2, 3);
		Segmento segmento = new Segmento(am, bm);
		
		System.out.println(segmento.toString());
		segmento.desplazar(1, -1);
		System.out.println(segmento.toString());
		
		Punto puntoMedio = segmento.puntoMedio();
		System.out.println(puntoMedio);
		
		Segmento segmento1 = new Segmento(segmento);
		
		System.out.println(segmento1.toString());
		
		System.out.println(segmento.esIgual(segmento1));

		
	}

}
