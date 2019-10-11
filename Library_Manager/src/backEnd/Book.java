package backEnd;

public class Book extends Publication {
	
	private String autor;
	private String editorial;
	
	/** Constructor **/
	
	public Book(String id, String title, String materia, int amountCopies, String autor,
			String editorial) {
		super(id, title, materia, amountCopies);
		this.autor = autor;
		this.editorial = editorial;
	}
	/** Gets and Sets **/
	
	public String getAutor() {
		return autor;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	
	

}
