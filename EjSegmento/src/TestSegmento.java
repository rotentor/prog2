public class TestSegmento {
    public static void main (String[] args) {
        Punto am = new Punto(1,2);
        Punto bm = new Punto(2,3);
        Segmento segmento = new Segmento(am, bm);

        System.out.println(segmento.toString());
        segmento.desplazar(1, -1);
        System.out.println(segmento.toString());
    }
}
