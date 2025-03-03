package tienda;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlmacenTest {
    private Almacen almacen;

    @Before
    public void setUp() throws Exception{
        almacen = new Almacen(3);
    }

    @Test
    public void recibirProductos() {
        almacen.recibirProductos(1,3);
        assertEquals("pos 1 debería tener 3 productos",
                3, almacen.get(1));

        almacen.recibirProductos(1, 1);
        assertEquals("pos 1 debería tener 4 productos",
                4, almacen.get(1));
    }

    @Test
    public void testToString() {
        assertEquals("", "[0, 0, 0]", almacen.toString());
        almacen.recibirProductos(0,2);
        almacen.recibirProductos(1,3);
        almacen.recibirProductos(2,4);
        assertEquals("", "[2, 3, 4]", almacen.toString());
    }
}