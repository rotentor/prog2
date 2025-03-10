import list.ArrayList;

public class TestArrayList {

	public static void main(String[] args) {
		ArrayList<Integer> lista;
		lista = new ArrayList<>();
		lista.add(0, 1);
		lista.add(0, 2);
		lista.add(lista.size(), 10);
		
		System.out.println(lista); // [2, 1, 10]
		
		System.out.println("pos:" + lista.indexOf(10)); // 2
		System.out.println("pos:" + lista.indexOf(11)); // -1

		lista.remove(2);
		
		System.out.println(lista);
		

	}

}
