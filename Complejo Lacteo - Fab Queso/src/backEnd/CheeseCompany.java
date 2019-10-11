package backEnd;

import java.util.ArrayList;

public class CheeseCompany {

	private ArrayList<Cheese> listCheese;
	private ArrayList<Client> listClient;
	private ArrayList<Invoice> listInvoice;

	private static CheeseCompany cheeseCompany;
	public static int generateCodeCheese = 1;
	public static int generateCodeInvoice = 0;
	/* Constructor */
	private CheeseCompany() {
		super();
		this.listCheese = new ArrayList<Cheese>();
		this.listClient = new ArrayList<Client>();
		this.listInvoice = new ArrayList<Invoice>();
	}

	/* SINGLETON */
	public static CheeseCompany getInstance() {
		if(cheeseCompany == null) {
			cheeseCompany = new CheeseCompany();
		}
		return cheeseCompany;
	}

	/* Gets and Sets*/

	public ArrayList<Cheese> getListCheese() {
		return listCheese;
	}

	public ArrayList<Client> getListClient() {
		return listClient;
	}

	public ArrayList<Invoice> getListInvoice() {
		return listInvoice;
	}

	public void setListCheese(ArrayList<Cheese> listCheese) {
		this.listCheese = listCheese;
	}

	public void setListClient(ArrayList<Client> listClient) {
		this.listClient = listClient;
	}

	public void setListInvoice(ArrayList<Invoice> listInvoice) {
		this.listInvoice = listInvoice;
	}


	/* Methods */

	public void addCheese(Cheese cheese) {
		listCheese.add(cheese);
		generateCodeCheese++;
	}

	public void addClient(Client client) {
		listClient.add(client);
	}

	public void addInvoice(Invoice invoice) {
		listInvoice.add(invoice);
		generateCodeInvoice++;
	}


	public Client searchClientByID(String idClient) {
		Client auxClient = null;
		boolean found = false;
		int i = 0;

		while (!found && i < listClient.size()) {
			if(listClient.get(i).getId().equalsIgnoreCase(idClient)) {
				found = true;
				auxClient = listClient.get(i);
			}
			i++;
		}
		return auxClient; //Retorna el cliente del ID encontrado.
	}

	public Cheese searchCheeseByCode(String codeCheese) {
		Cheese auxCheese = null;
		boolean found = false;
		int i = 0;

		while (!found && i < listCheese.size()) {
			if(listCheese.get(i).getCodigo().equalsIgnoreCase(codeCheese)) {
				found = true;
				auxCheese = listCheese.get(i);
			}
			i++;
		}
		return auxCheese; //Retorna el queso del codigo encontrado.
	}

	public String typeCheese(Cheese myCheese) {
		String type = null;

		for (Cheese cheese : listCheese) {
			if (cheese.equals(myCheese)) {

				if (cheese instanceof SphereCheese) {
					type = "Esferico";

				}
				else if (cheese instanceof CylindriCheese) {
					type = "Cilindrico";

				}
				else if (cheese instanceof HoleCheese) {
					type =  "Cilindrico Hueco";

				}
			}
		}
		return type;
	}

	public Boolean checkAmountCheese(Cheese cloneCheese) {
		boolean found = false;
		boolean available = false;
		int i=0;

		while(!found && i < listCheese.size()) {
			if(listCheese.get(i).getCodigo().equalsIgnoreCase(cloneCheese.getCodigo())) {
				found = true;
				if((listCheese.get(i).getCantidad() >= cloneCheese.getCantidad()) && listCheese.get(i).getCantidad() !=0) {
					available = true;
				}
			}
			i++;
		}
		return available;
	}
	
	public Boolean checkCreditPayment(String idClient, String codeFactura) {
		boolean found = false;
		boolean available = false;
		int i=0;

		while(!found && i < listInvoice.size()) {
			if(listInvoice.get(i).getCodigo().equalsIgnoreCase(codeFactura)) {
				found = true;
				if((listInvoice.get(i).getClient().getId().equalsIgnoreCase(idClient)) && listInvoice.get(i).getClient().getCredito() >= listInvoice.get(i).getPrecioTotal()) {
					
					available = true;
				}
			}
			i++;
		}
		return available;
	}
	

}
