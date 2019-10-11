package Backend;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		Cliente cliente1 = new Cliente("Anthony");
		Cliente cliente2 = new Cliente("Carolyn");
		
		ArrayList<Integer> prodCliente1 = new ArrayList<>();
		prodCliente1.add(2);
		prodCliente1.add(2);
		prodCliente1.add(3);
		prodCliente1.add(5);
		prodCliente1.add(3);
		
		cliente1.setMisProductos(prodCliente1);
		
		ArrayList<Integer>prodCLiente2 = new ArrayList<>();
		prodCLiente2.add(1);
		prodCLiente2.add(3);
		prodCLiente2.add(5);
		prodCLiente2.add(1);
		prodCLiente2.add(1);
		
		cliente2.setMisProductos(prodCLiente2);
		
		long time = System.currentTimeMillis();
		
		Cajera cajera1 = new Cajera("Maria");
		cajera1.getClient().add(cliente1);
		
		Cajera cajera2 = new Cajera("Juana");
		cajera2.getClient().add(cliente2);
		
		cajera1.setTime(time);
		cajera2.setTime(time);
		
		cajera1.start();
		cajera2.start();
		
		
		
		
				
	

	}

}
