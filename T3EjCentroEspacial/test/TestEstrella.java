import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import vigilanciaespacial.estrellas.Estrella;

/**
 * Pruebas JUnit para Estrella.
 * 
 * @author Ra�l Garc�a Castro (c�digo original)
 * @author Manuel Collado Machuca (actualizaciones)
 */
public class TestEstrella {

	private static Estrella estrella1 = null; // com�n para todos los tests

	/** Inicializaci�n com�n para cada uno de los tests. */
	@Before
	public void setUp() {
		estrella1 = new Estrella("Sol", 23.4, 180);
	}
	
	// -------------------------------------------------------------------
	/** Prueba constructor (identificador) */
	@Test
	public void testGetIdentificador() {
		assertEquals("\nIdentificador incorrecto:\n", "Sol",
				estrella1.getIdentificador());
	}
	/** Prueba constructor (campo magn�tico) */
	@Test
	public void testGetCampoMagnetico() {
		assertEquals("\nCampo magn�tico incorrecto:\n", 23.4,
				estrella1.getCampoMagnetico(), 0.0);
	}
	/** Prueba constructor (�ndice de color) */
	@Test
	public void testGetIndiceColor() {
		assertEquals("\nIndice de color incorrecto:\n", 180,
				estrella1.getIndiceColor());
	}

	// -------------------------------------------------------------------
	/** Prueba equals: todo diferente */
	@Test
	public void testEquals1() {
		Estrella estrella2 = new Estrella("Alpha Centauri", 26.4, 4280);
		assertFalse("Problemas al comparar dos estrellas:",
				estrella1.esIgual(estrella2));
	}
	/** Prueba equals: mismo identificador, resto diferente */
	@Test
	public void testEquals2() {
		Estrella estrella2 = new Estrella(new String("Sol"), 21.3, 130);
		assertTrue("Problemas al comparar dos estrellas:",
				estrella1.esIgual(estrella2));
	}
	/** Prueba equals: distinto identificador, resto igual */
	@Test
	public void testEquals3() {
		Estrella estrella2 = new Estrella("Rigel", 23.4, 180);
		assertFalse("Problemas al comparar dos estrellas:",
				estrella1.esIgual(estrella2));
	}

	// -------------------------------------------------------------------
	/** Prueba desplazar */
	@Test
	public void testDesplazar() {
		estrella1.desplazar();
		assertEquals("\nCampo magn�tico incorrecto:\n", 17.9,
				estrella1.getCampoMagnetico(), 0.0);
		assertEquals("\nIndice de color incorrecto:\n", 179,
				estrella1.getIndiceColor());
	}

}
