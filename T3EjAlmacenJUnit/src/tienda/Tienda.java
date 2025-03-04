package tienda;


public class Tienda {
	private Almacen almacen1, almacen2;
	private double saldoCaja;
	// en pos i está el precio del producto con codigo i
	private double[] precios;

	//PRE: almacen1.size() = almacen2.size() y
	// saldoInicial >= 0
	public Tienda(double saldoInicial, Almacen almacen1,
			Almacen almacen2) {
		//TO-DO
		this.saldoCaja = saldoInicial;
		this.precios = new double[almacen1.size()];
		this.almacen1 = almacen1;
		this.almacen2 = almacen2;
	}

	//PRE: 0 <= codProducto < precios.length y precio > 0
	public void setPrecio(int codProducto, double precio) {
		precios[codProducto]=precio;
	}

	//PRE: 0 <= codProducto < precios.length y 
	// hay existencias del producto codProducto
	// preferimos utilizar el almacen mas cercano
	public void comprar(int codProducto) {
		if(almacen1.get(codProducto)!=0){
			almacen1.gastarProductos(codProducto, 1);
		}	else {
			almacen2.gastarProductos(codProducto, 1);
		}
		saldoCaja+=precios[codProducto];
	}

	//PRE: 0 <= codProducto < precios.length
	public void devolver(int codProducto) {
		almacen1.recibirProductos(codProducto, 1);
		saldoCaja -= precios[codProducto];
	}

	//PRE: 0 <= codProducto < precios.length
	public boolean quedaProducto(int codProducto){
		//TO-DO
		return almacen1.get(codProducto)>0 ||
				almacen2.get(codProducto)>0;
	}

	public int numProdAgotados() {
		int num=0;
		for(int i=0; i<almacen1.size() ;++i){
			if(almacen1.get(i)==0 && almacen2.get(i)==0) {
				++num;
			}
		}
		return num;
	}

	public String toString() {
		String resultado = "almacen1: " + almacen1 + 
				" | almacen2: " + almacen2 + " | saldocaja: " 
				+ saldoCaja + " | precios: ";
		for(int i = 0;i<precios.length-1;i++) {
			resultado += precios[i] +  " , " ; 
		}
		return resultado + precios[precios.length-1];		
	}
}
