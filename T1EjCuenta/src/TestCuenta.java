
public class TestCuenta {
	public static void main(String[] args) {
		// el atributo static existe antes de crear el primer objeto
		System.out.println(Cuenta.getGastosApertura()); // sale 10 
		Cuenta cuenta1, cuenta2;
		Persona cliente1 = new Persona("532147X", 20, "Pepe");
		Persona cliente2 = new Persona("732247X", 30, "Ana");
		
		cuenta1 = new Cuenta(23, cliente1);
		cuenta2 = new Cuenta(40, cliente2);
		
		System.out.println(cuenta1.esIgual(cuenta2)); // FALSE
		System.out.println(cuenta1.esIgual(new Cuenta(cuenta1))); // TRUE

		
		System.out.println(cuenta1);

		Cuenta.setGastosApertura(1.5);

		// Los gastos de apertura de cuenta1 son los mismos de 
		// cuenta2 y cuando un objeto los cambia se cambia en los dos 
		System.out.println(cuenta2);
		System.out.println(cuenta1);

		// Cambiamos el valor de los gastos de apertura para todas 
		// las cuentas usando el nombre de la clase
		Cuenta.setGastosApertura(0.75);
		System.out.println(cuenta2);
		System.out.println(cuenta1); 
	}

}
