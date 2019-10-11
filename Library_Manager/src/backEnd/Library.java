package backEnd;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Library {

	private ArrayList<Client> listClient;
	private ArrayList<Publication> listPublication;
	private ArrayList<Loan> listLoan;
	
	public static int generateIdBook = 1;
	public static int generateIdArticle = 1;
	public static int generateIdMagazine = 1;
	

	/** Constructor **/

	public Library() {
		super();
		this.listClient = new ArrayList <Client>();
		this.listPublication = new ArrayList <Publication>();
		this.listLoan = new ArrayList<Loan>();

	}

	/** Gets and Sets **/

	public ArrayList<Client> getListClient() {
		return listClient;
	}

	public ArrayList<Publication> getListPublication() {
		return listPublication;
	}

	public ArrayList<Loan> getListLoan() {
		return listLoan;
	}

	public void setListClient(ArrayList<Client> listClient) {
		this.listClient = listClient;
	}

	public void setListPublication(ArrayList<Publication> listPublication) {
		this.listPublication = listPublication;
	}

	public void setListLoan(ArrayList<Loan> listLoan) {
		this.listLoan = listLoan;
	}



	/*** Methods ***/

	public void addPublication(Publication publication) {
		listPublication.add(publication); // Agrega a la arraylist de listPublication.
		if (publication instanceof Book) {
			generateIdBook++;
			
		}
		else if (publication instanceof Article) {
			generateIdArticle++;
		}
		else {
			generateIdMagazine++;
		}
	}

	public void addClient(Client cliente) {
		listClient.add(cliente);
	}

	public String searchTitlePublication(String idPublication) {
		Boolean found = false;
		String title = null;
		int i = 0;

		while (!found && i < listPublication.size()) {
			if (idPublication.equalsIgnoreCase(listPublication.get(i).getId())) {
				found = true;
				title = listPublication.get(i).getTitle();		
			}
			i++;
		}

		return title; // Retorna el titulo dado el codigo de una publicacion.
	}

	public int amountPublicationByMateria(String materia) {
		int i = 0;
		int amount = 0;

		while (i < listPublication.size()) {
			if (materia.equalsIgnoreCase(listPublication.get(i).getMateria())) {
				amount++;			
			}	
			i++;
		}
		return amount; // Retorna la cantidad de publicaciones de una misma materia.
	}

	public Client searchClientByCode(String idClient) {
		Client auxClient = null;
		boolean found = false;
		int i = 0;

		while (!found && i < listClient.size()) {
			if(listClient.get(i).getID().equalsIgnoreCase(idClient)) {
				found = true;
				auxClient = listClient.get(i);
			}
			i++;
		}
		return auxClient; //Retorna el cliente del codigo encontrado.
	}

	private Boolean checkClientForLoan(String idClient) {
		Client auxClient = searchClientByCode(idClient);
		Boolean available = false;

		if (auxClient.getAmountLoanActive() < 5) {
			available = true;
		}

		return  available; // Retorna TRUE si un cliente posee menos de 5 prestamos, osea si puede solicitar otro prestamo.
	}

	private String modifyDate(Date date, int day) { // Metodo auxiliar para modificar la fecha, sumar dias o restar dias.

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, day);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String dateString = formatter.format(calendar.getTime());

		return dateString;
	}

	
	public void solicitarLoan(String clientCode, String publicationCode) {
		Date dateSoli = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String dateString = formatter.format(dateSoli);

		Client auxClient = searchClientByCode(clientCode);
		Boolean available = checkClientForLoan(clientCode);

		if (available && checkAvailablePublication(publicationCode)) {
			Loan prestamo = new Loan("L-001", clientCode, publicationCode);
			prestamo.setDateSoli(dateString); // agrega la fecha en la se aprueba el prestamo.
			prestamo.setDateDevo(modifyDate(dateSoli, 14)); // establece la fecha de devolucion presvista 14 dias despues
			listLoan.add(prestamo); // agrega los prestamos solicitados.
			auxClient.setAmountLoanActive(auxClient.getAmountLoanActive() + 1); // aumenta la cantidad de prestamos tomados del cliente.
		}
	}
//	public void solicitarLoan(Loan prestamo) {
//		Date dateSoli = new Date();
//		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//		String dateString = formatter.format(dateSoli);
//
//		Client auxClient = searchClientByCode(prestamo.getClientCode());
//		Boolean available = checkClientForLoan(prestamo.getClientCode());
//
//		if (available && checkAvailablePublication(prestamo.getPublicationCode())) {
//			prestamo.setDateSoli(dateString); // agrega la fecha en la se aprueba el prestamo.
//			prestamo.setDateDevo(modifyDate(dateSoli, 14)); // establece la fecha de devolucion presvista 14 dias despues
//			listLoan.add(prestamo); // agrega los prestamos solicitados.
//			auxClient.setAmountLoan(auxClient.getAmountLoan() + 1); // aumenta la cantidad de prestamos tomados del cliente.
//		}
//	}

	public Loan searchLoanByCode(String idLoan) {
		Loan auxLoan = null;
		boolean found = false;
		int i = 0;

		while (!found && i < listLoan.size()) {
			if(listLoan.get(i).getId().equalsIgnoreCase(idLoan)) {
				found = true;
				auxLoan = listLoan.get(i);
			}
			i++;
		}
		return auxLoan; //Retorna el prestamo del codigo encontrado.
	}

	public void devolverLoan(String idLoan) {
		Loan auxLoan = searchLoanByCode(idLoan);
		auxLoan.setStatus(false); // Status = false, implica que esta devuelto.
		auxLoan.setDateDevoReal(LocalDate.now().toString());
		Client auxClient = searchClientByCode(auxLoan.getClientCode());
		auxClient.setAmountLoanActive(auxClient.getAmountLoanActive() - 1);

	}

	public Publication searchPublicationByCode(String idPublication) {
		Publication auxPublication = null;
		boolean found = false;
		int i = 0;

		while (!found && i < listPublication.size()) {
			if(listPublication.get(i).getId().equalsIgnoreCase(idPublication)) {
				found = true;
				auxPublication = listPublication.get(i);
			}
			i++;
		}
		return auxPublication; //Retorna la publicacion del codigo encontrado.
	}

	public Publication searchPublicationByMateria(String materia) {
		Publication auxPublication = null;
		boolean found = false;
		int i = 0;

		while (!found && i < listPublication.size()) {
			if(listPublication.get(i).getMateria().equalsIgnoreCase(materia)) {
				found = true;
				auxPublication = listPublication.get(i);
			}
			i++;
		}
		return auxPublication; //Retorna la publicacion de la materia encontrado.
	}

	public Boolean checkAvailablePublication(String idPublication) {
		Boolean check = null;
		Publication auxPubli = searchPublicationByCode(idPublication);
		
		if (amountAvailablePublication(idPublication) >= 1) {
			check = true;	
		}
		else {
			check = false;
		}
		
		auxPubli.setStatus(check);
		return check; // Retorna TRUE si una publicacion esta disponible y FALSE si no esta disponible o sea agotado.

	}

	public int amountAvailablePublication(String idPublication) {
		Publication auxPubli = searchPublicationByCode(idPublication);
		int i = 0;
		int amountPubliBorrowed = 0;
		while ( i < listLoan.size()) {
			if (listLoan.get(i).getPublicationCode().equalsIgnoreCase(idPublication) && listLoan.get(i).getStatus() == true) {
				amountPubliBorrowed++;	
			}
			i++;
		}
		return (auxPubli.getAmountCopies() - amountPubliBorrowed); // Retorna la cantidad de copias (ejemplares) disponible de la publicacion del id encontrado.
	}

	public int[] amountLoanByTypeOfClient(String idClient) {

		int [] amountType = new int [] {0,0,0}; // [0] Book, [1] Article, [2] Magazine.
		int i = 0;
		String codePubli = null;
		String codeClient = null;
		Boolean status = null;
		Publication auxPublication = null;

		while(i < listLoan.size()) {
			codePubli = listLoan.get(i).getPublicationCode();
			codeClient = listLoan.get(i).getClientCode();
			status = listLoan.get(i).getStatus();
			auxPublication = searchPublicationByCode(codePubli);

			if(codeClient.equalsIgnoreCase(idClient)) {
				if (auxPublication instanceof Book) {
					amountType[0]++;
				}
				else if (auxPublication instanceof Article) {
					amountType[1]++;
				}
				else if (auxPublication instanceof Magazine) {
					amountType[2]++;
				}
			}
			i++;
		}
		return amountType;
	}

	public int amountMagazineLibrary(String materia) {
		Publication auxPubli = searchPublicationByMateria(materia);
		int i = 0;
		int amountMateria = 0;

		while(i < listPublication.size()) {
			if (auxPubli instanceof Magazine) {
				if (listPublication.get(i).getMateria().equalsIgnoreCase(materia)) {
					amountMateria++;
				}
			}
			i++;	
		}
		return amountMateria; // Retornar la cantidad de una revista de la materia consultada.
	}

	public Boolean checkAvailableBookOrArticle(String idPublication) {
		Publication auxPubli = searchPublicationByCode(idPublication);
		int i = 0;
		int amountPubliBorrowed = 0;
		boolean check = false;
		
		if (auxPubli instanceof Book || auxPubli instanceof Article) {
			while ( i < listLoan.size()) {
				if (listLoan.get(i).getPublicationCode().equalsIgnoreCase(idPublication) && listLoan.get(i).getStatus() == true) {
					amountPubliBorrowed++;	
				}
				i++;
			}
			check = (auxPubli.getAmountCopies() - amountPubliBorrowed) >= 1;
			
		}
		return check ; //Retorna true si hay ejemplares disponible de libros o articles.
		}

}
