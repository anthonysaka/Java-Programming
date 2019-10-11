package backEnd;

public class Article extends Publication {
	
	private String arbitro;
	private String autor;
	
	/** Constructor **/

	public Article(String id, String title, String materia, int amountCopies, String arbitro,
			String autor) {
		super(id, title, materia, amountCopies);
		this.arbitro = arbitro;
		this.autor = autor;
	}
	
	/** Gets and Sets **/
	
	public String getArbitro() {
		return arbitro;
	}
	public String getAutor() {
		return autor;
	}
	public void setArbitro(String arbitro) {
		this.arbitro = arbitro;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	
	
	

}
