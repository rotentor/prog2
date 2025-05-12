/**
 * 
 */

import animales.Animal;
import animales.Gato;
import animales.Oveja;
import animales.Perro;

/**
 * 
 */
public class PruebaAnimnales {
	
	public static void listarSonidos(Animal animales[]) {
		for (int i = 0; i < animales.length; i++)
		{
			animales[i].emitirSonido();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Animal animales [] = new Animal[4];
		animales [0] = new Animal("Pato1", 1,"Cuack");
		animales[1] = new Perro("Perro1", 2, "Amo1");
		animales[2] = new Gato("Gato1", 3);
        animales[3] = new Oveja("Ovjea1", 2, "Pastor1");
        listarSonidos(animales);
	}

}
