package app;

import vajilla.Vaso;
import vajilla.exception.ErrorPrepararDesayuno;
import vajilla.exception.ErrorVasoLLeno;

import java.util.Scanner;

public class PruebaVaso {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		Vaso vaso = new Vaso(10.0);
		boolean terminado = false;
		while(!terminado) { // w
			try {
				System.out.print("Cantidad de leche: ");
				int leche = lector.nextInt();
				System.out.print("Cantidad de azucar: ");
				int azucar = lector.nextInt();
				System.out.print("Cantidad de cacao: ");
				int cacao = lector.nextInt();
				System.out.println(vaso);
				vaso.prepararDesayuno(leche, azucar, cacao);
				terminado = true;
				System.out.println("Ya tiene su baso de dasyuno preparado!!");
			} catch (ErrorPrepararDesayuno e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Has sobrepasado la cantidad la cantidad"
						+ " máxima es:" + vaso.getCapacidadMax());
			}
		} // fin while

		lector.close();

	}

}
