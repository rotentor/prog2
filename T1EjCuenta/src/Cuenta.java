
public class Cuenta {
	/**
	 * Los gastos de apertura son comunes para todas las cuentas 
	 * abiertas en el banco
	 */
	private static double gastosApertura = 10; 
	private double saldo;
	private Persona cliente;

	public Cuenta (double saldoInicial, Persona persona){
		saldo=saldoInicial - gastosApertura;
		this.cliente = persona;
	}
	
	public Cuenta(Cuenta obj) {
		saldo = obj.saldo;
		cliente = new Persona(obj.cliente);
	}
	
	
	public void setSaldo (double saldo){
		this.saldo=saldo;
	}	
	public static void setGastosApertura (double gastosA){
		Cuenta.gastosApertura = gastosA;
	}
	public static double getGastosApertura (){
		return Cuenta.gastosApertura;
	}
	public String toString(){
		return gastosApertura + " " + saldo + " " + cliente;
	}
	
	public boolean esIgual(Cuenta cu) {
		return saldo == cu.saldo && cliente.esIgual(cu.cliente);
	}

}
