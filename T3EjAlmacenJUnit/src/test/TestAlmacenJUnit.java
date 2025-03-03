package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tienda.Almacen;

public class TestAlmacenJUnit {
	private Almacen almacen;

	@Before
	public void setUp() throws Exception {
		almacen = new Almacen(3);
	}

	@Test
	public void test0Constructor() {
		assertEquals("pos 0 incorrectamente inicializada", 
				0, almacen.get(0));
		assertEquals("pos 1 incorrectamente inicializada", 
				0, almacen.get(1));
		assertEquals("pos 2 incorrectamente inicializada", 
				0, almacen.get(2));	
	}
	
	@Test
	public void testRecibirProductos() {
			
			almacen.recibirProductos(0, 2);
			assertEquals("pos 0 debería tener 2 productos", 
					2, almacen.get(0));
			
			almacen.recibirProductos(1, 3);
			assertEquals("pos 1 debería tener 3 productos", 
					3, almacen.get(1));
			
			almacen.recibirProductos(1, 1);
			assertEquals("pos 1 debería tener 4 productos", 
					4, almacen.get(1));
	}
	
	@Test
	public void testToString() {
		assertEquals("El toString falla con el almacen vacío", 
				"[0, 0, 0]", almacen.toString());	
		almacen.recibirProductos(0, 2);
		almacen.recibirProductos(1, 3);
		almacen.recibirProductos(2, 4);
		assertEquals("El toString falla con contenido", 
				"[2, 3, 4]", almacen.toString());			
	}

}
