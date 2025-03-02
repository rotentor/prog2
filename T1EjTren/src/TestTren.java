
public class TestTren {

    public static void main(String[] args) {
    	// Se crea un tren con capacidad 4 y vagones con nombres A y B        
        Tren tren = new Tren(4, "A", "B");    
        // ocupamos 2 asientos no consecutivos en el vagon A    
        tren.ocuparVagon(0, "A");
        tren.ocuparVagon(2, "A");
        // mostramos el tren en la pantalla
        System.out.println(tren);
        // mostramos en la pantalla si hay dos asientos libres consecutivos (true)      
        System.out.println(tren.hayDosLibresConsecutivos());
        // ocupamos 2 asientos no consecutivos en el vagón B       
        tren.ocuparVagon(0, "B");
        tren.ocuparVagon(2, "B");
        // mostramos el tren en la pantalla
        System.out.println(tren);
        // mostramos en la pantalla si hay dos asientos libres consecutivos (false)       
        System.out.println(tren.hayDosLibresConsecutivos());
        // desocupamos un asiento en el vagón B
        tren.desocuparVagon(2, "B");
        // mostramos el tren en la pantalla
        System.out.println(tren);
        // mostramos en la pantalla si hay dos asientos libres consecutivos (true)       
        System.out.println(tren.hayDosLibresConsecutivos());

        // cambiamos el vagón por un nuevo vagón con nombre C (sale el A)       
        tren.cambiarVagon(new Vagon("C", 4));        
        // mostramos el tren en la pantalla
        System.out.println(tren);

        // mostramos en la pantalla si hay dos asientos libres consecutivos (true)       
        System.out.println(tren.hayDosLibresConsecutivos());

    }

}
