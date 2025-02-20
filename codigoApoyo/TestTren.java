public class TestTren {

    private static void testCheckConsecutivos(Tren tren) {
        String consecutivos = tren.hayDosLibresConsecutivos()? "Sí":"No";
        System.out.println(consecutivos + " hay dos asientos consecutivos");
    }

    public static void main(String[] args) {
    	// Se crea un tren con capacidad 4 y vagones con nombres A y B        
        Tren tren = new Tren(4, "A", "B");
        // ocupamos 2 asientos no consecutivos en el vagón A
        tren.ocuparVagon(0, "A");
        tren.ocuparVagon(2, "A");
        // mostramos el tren en la pantalla
        System.out.println(tren);
        // mostramos en la pantalla si hay dos asientos libres consecutivos (true)      
        testCheckConsecutivos(tren);
        // ocupamos 2 asientos no consecutivos en el vagón B       
        tren.ocuparVagon(0, "B");
        tren.ocuparVagon(2, "B");
        // mostramos el tren en la pantalla
        System.out.println(tren);
        // mostramos en la pantalla si hay dos asientos libres consecutivos (false)       
        testCheckConsecutivos(tren);
        // desocupamos un asiento en el vagón B
        tren.desocuparVagon(2, "B");
        // mostramos el tren en la pantalla
        System.out.println(tren);
        // mostramos en la pantalla si hay dos asientos libres consecutivos (true)       
        testCheckConsecutivos(tren);
        // cambiamos el vagón por un nuevo vagón con nombre C (sale el A)       
        tren.cambiarVagon(new Vagon("C", 4));
        // mostramos el tren en la pantalla
        System.out.println(tren);
        // mostramos en la pantalla si hay dos asientos libres consecutivos (true)       
        testCheckConsecutivos(tren);
    }

}

/*
**************************************************
OUTPUT GENERADO (Oracle OpenJDK 11.0.26 - aarch64)
**************************************************
A true false true false
B false false false false
Sí hay dos asientos consecutivos
A true false true false
B true false true false
No hay dos asientos consecutivos
A true false true false
B true false false false
Sí hay dos asientos consecutivos
B true false false false
C false false false false
Sí hay dos asientos consecutivos
 */