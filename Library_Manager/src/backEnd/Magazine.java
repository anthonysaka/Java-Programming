package backEnd;

public class Magazine extends Publication{
	
	private int year;
	private int number;
	
	/** Constructor **/
	
	public Magazine(String id, String title, String materia, int amountCopies, int year, int number) {
		super(id, title, materia, amountCopies);
		this.year = year;
		this.number = number;
	}
	/** Gets and Sets **/
	
	public int getYear() {
		return year;
	}
	public int getNumber() {
		return number;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	

}
