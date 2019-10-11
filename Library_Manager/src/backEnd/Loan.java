package backEnd;

public class Loan {
	
	private String id;
	private String dateSoli;
	private String dateDevo;
	private String dateDevoReal;
	private String clientCode;
	private String publicationCode;
	private Boolean status;
	
	/** Constructor **/
	
	public Loan(String id, String clientCode, String publicationCode) {
		super();
		this.id = id;
		this.dateSoli = null;
		this.dateDevo = null;
		this.dateDevoReal = null;
		this.clientCode = clientCode;
		this.publicationCode = publicationCode;
		this.status = true;
	}
	
	/** Gets and Sets **/
	
	public String getId() {
		return id;
	}
	public String getDateSoli() {
		return dateSoli;
	}
	public String getDateDevo() {
		return dateDevo;
	}
	public String getDateDevoReal() {
		return dateDevoReal;
	}
	public String getClientCode() {
		return clientCode;
	}
	public String getPublicationCode() {
		return publicationCode;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setDateSoli(String dateSoli) {
		this.dateSoli = dateSoli;
	}
	public void setDateDevo(String dateDevo) {
		this.dateDevo = dateDevo;
	}
	public void setDateDevoReal(String dateDevoReal) {
		this.dateDevoReal = dateDevoReal;
	}
	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	public void setPublicationCode(String publicationCode) {
		this.publicationCode = publicationCode;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
	
	

}
