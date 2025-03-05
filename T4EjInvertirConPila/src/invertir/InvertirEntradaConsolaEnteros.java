package invertir;
import java.util.Scanner;


import stacks.exceptions.EmptyStackException;
import stacks.StackInteger;


public class InvertirEntradaConsolaEnteros {

	/* Este programa invierte una secuencia de n�meros
	 * enteros dada por el teclado, y la muestra en la
	 * consola.
	 * Debe haber un entero en cada l�nea, si el n�mero leido es el 0 se termina.
	 * Si se pone m�s de un n�mero en una l�nea el programa no funciona.
	 */
	public static void main(String[] args) throws EmptyStackException {
		StackInteger pilaEnteros;
		int datoLeido;
		
		pilaEnteros = new StackInteger();
		Scanner scanner = new Scanner(System.in);
		
		// apilamos los enteros dados por el teclado
		System.out.print("Introduzca un n�mero, para terminar introduzca el n�mero 0: ");
		datoLeido = scanner.nextInt();
		while (datoLeido != 0){
			pilaEnteros.push(datoLeido);
			System.out.print("Introduzca un n�mero, para terminar introduzca el n�mero 0: ");
			datoLeido = scanner.nextInt();
		}
		scanner.close();
		// desapilamos los enteros y los
		// escribimos en la consola
		while (!pilaEnteros.isEmpty()){			
				datoLeido = pilaEnteros.pop();
				System.out.print(datoLeido + " ");			
		}

	}

}
