package backEnd;

import java.util.ArrayList;

public class Invoice {
	
	private String codigo;
	private Client client;
	private ArrayList<Cheese> listCheeseBuy;
	private float precioTotal;
	
	/* Constructor */
	public Invoice( Client client, ArrayList<Cheese> listCheeseBuy ) {
		super();
		this.client = client;
		this.listCheeseBuy = listCheeseBuy;
	}
	
	/* Gets and Sets*/
	
	public String getCodigo() {
		return codigo;
	}
	public Client getClient() {
		return client;
	}
	public ArrayList<Cheese> getListCheeseBuy() {
		return listCheeseBuy;
	}
	public float getPrecioTotal() {
		return precioTotal;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public void setListCheeseBuy(ArrayList<Cheese> listCheese) {
		this.listCheeseBuy = listCheese;
	}
	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	/* Methods */
	
	public void addCheeseBuy(Cheese buyCheese) {
		this.listCheeseBuy.add(buyCheese);
	}
	

	public float totalPrice() {
		float precioTotal = 0.0f;
		
		for (Cheese cheese : listCheeseBuy) {
			precioTotal += cheese.priceCheese()*cheese.cantidad;		
		}
		this.setPrecioTotal(precioTotal);
		
		return precioTotal;
	}
	
	
	
	

}
