package Backend;

import java.util.ArrayList;

public class Cliente {
	
	private String nombre;
	private ArrayList<Integer> misProductos;
	
	
	public Cliente(String nombre) {
		super();
		this.nombre = nombre;
		this.misProductos = new ArrayList<Integer>();
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public ArrayList<Integer> getMisProductos() {
		return misProductos;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setMisProductos(ArrayList<Integer> misProductos) {
		this.misProductos = misProductos;
	}
	
	

}
