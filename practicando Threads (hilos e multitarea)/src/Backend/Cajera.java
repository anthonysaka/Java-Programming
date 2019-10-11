package Backend;

import java.util.ArrayList;

public class Cajera extends Thread {
	
	private String nombre;
	private ArrayList<Cliente> client;
	private long time;
	
	
	public Cajera(String nombre) {
		super();
		this.nombre = nombre;
		this.client = new ArrayList<Cliente>();
		//this.time = time;
	}


	public String getNombre() {
		return nombre;
	}


	public ArrayList<Cliente> getClient() {
		return client;
	}


	public long getTime() {
		return time;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setClient(ArrayList<Cliente> client) {
		this.client = client;
	}


	public void setTime(long time) {
		this.time = time;
	}
	
	
	/* Metodos */
	
    @Override
	public void run() {
		 int i = 0;
		 for (Cliente cliente : client) {
			 System.out.println("La cajera: " + this.nombre + "Ha comenzado ha procesar al cliente: " + cliente.getNombre() + " En el tiempo " + (System.currentTimeMillis() - time)/1000 + "Seg");
			 
			 for (Integer prod: cliente.getMisProductos()) {
				 this.esperarSegundos(prod);
				 System.out.println("Cajera :" + this.nombre + "Procesando el prodcuto: " +  ++i + "-> Tiempo" + (System.currentTimeMillis()-time)/1000 + "Seg");
				
			}
			 
			 System.out.println("La cajera: " + this.nombre + "Ha terminado de procesar el cliente: " + cliente.getNombre() + " En el tiempo: " + (System.currentTimeMillis()-time)/1000 + "Seg");
		
		}
	}
	


	private void esperarSegundos (Integer prod) {
		try {
			Thread.sleep(prod*1000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	

}
