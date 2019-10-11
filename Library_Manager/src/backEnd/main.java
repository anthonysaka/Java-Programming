package backEnd;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javafx.util.converter.LocalDateStringConverter;

public class main {

	public static void main(String[] args) {
		
		Library myLibrary = new Library();
		
		Book book1 = new Book("B-001", "LA POO", "Programación", 69,"Pablo Rodríguez", "PP Edition");
		Book book2 = new Book("B-002", "LA PO1", "Biologia", 1,"Pablo Rodríguez", "PP2 Edition");
		Magazine magazine1 = new Magazine("M-001", "Top Model", "Modelaje", 50, 2016, 1);
		Article article1 = new Article("A-001", "La vida", "Biologia", 25, "Juan vasquez", "Niel Sheazl");
		
		Client client1 = new Client("C-001", "Anthony Sakamoto", "Santiago");
		Client client2 = new Client("C-002", "Anthony Sakamoto", "Santiago");
		
	//	Loan loan1 = new Loan("L-001","C-001", "B-002");
	//	Loan loan2 = new Loan("L-002","C-001", "A-001");
		
		myLibrary.addClient(client1);
		myLibrary.addClient(client2);
		
		myLibrary.addPublication(book1);
		myLibrary.addPublication(book2);
		myLibrary.addPublication(magazine1);
		myLibrary.addPublication(article1);
		
		
		System.out.println("****** PRUEBA DEL BACKEND ******\n");	
		System.out.println("- El numero de publicaciones es: "+ myLibrary.getListPublication().size());
		System.out.println("- El titulo de la publicación consultada es: "+ myLibrary.searchTitlePublication("A-001"));
		System.out.println("- La cantidad de documentos de la materia consultada es: "+ myLibrary.amountPublicationByMateria("Modelaje"));
		
		myLibrary.solicitarLoan("C-001", "B-001");
		//myLibrary.solicitarLoan(loan2);
		myLibrary.devolverLoan("L-001");
	    
	//	System.out.println(myLibrary.getListLoan().get(0).getDateSoli());
	//	System.out.println(myLibrary.getListLoan().get(0).getDateDevo());
	//  System.out.println(myLibrary.getListLoan().get(1).getClientCode());
		
		System.out.println("\n* La cantidad de libros prestados: "+myLibrary.amountLoanByTypeOfClient("C-001")[0]);
		System.out.println("* La cantidad de articulos prestados: "+myLibrary.amountLoanByTypeOfClient("C-001")[1]);
		System.out.println("* La cantidad de revista prestadas: "+myLibrary.amountLoanByTypeOfClient("C-001")[2]);
		System.out.println("\n~ La cantidad de revista de la materia consultada es: "+myLibrary.amountMagazineLibrary("Modelaje"));
		System.out.println("\n~ Disponibilidad de ejemplares de libro o articulo: "+myLibrary.checkAvailableBookOrArticle("B-002"));
		System.out.println(client1.getAmountLoanActive());

		
		
		
		


	}

}
