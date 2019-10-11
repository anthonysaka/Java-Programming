package backEnd;

public class Client {
	
	private String id;
	private String name;
	private String address;
	private String telephone;
	private float credito;
	
	
	/* Constructor */
	
	public Client(String id, String name, String address, String telephone, float credito) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.telephone = telephone;
		this.credito = credito;
	}
	
	/* Gets and Sets */
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getTelephone() {
		return telephone;
	}
	public float getCredito() {
		return credito;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public void setCredito(float credito) {
		this.credito = credito;
	}
	
	

}
