package backEnd;

public class Client {
	
	private String id;
	private String name;
	private String address;
	private int amountLoanActive;
	 
	
   /** Constructor **/
	
	public Client(String id, String name, String address) {
		super();
		this.id = id;
		this.address = address;
		this.amountLoanActive = 0;
	}
	
	/** Gets and Sets **/
	
	public String getID() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public int getAmountLoanActive() {
		return amountLoanActive;
	}
	public void setID(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setAmountLoanActive(int amountLoan) {
		this.amountLoanActive = amountLoan;
	}
	
	
	

}
