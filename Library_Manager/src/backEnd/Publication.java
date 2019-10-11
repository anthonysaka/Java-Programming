package backEnd;

public class Publication {
	
	protected String id;
	protected String title;
	protected String materia;
	protected int amountCopies;
	protected Boolean status;
	
	
    /** Constructor **/
	
	public Publication(String id, String title, String materia, int amountCopies) {
		super();
		this.id = id;
		this.title = title;
		this.materia = materia;
		this.amountCopies = amountCopies;
		this.status = true;
	}
	
	/** Gets and Sets **/
	
	public String getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getMateria() {
		return materia;
	}
	public int getAmountCopies() {
		return amountCopies;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public void setAmountCopies(int amountCopies) {
		this.amountCopies = amountCopies;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	

}
