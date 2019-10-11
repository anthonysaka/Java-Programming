package backEnd;

import java.util.ArrayList;

public class Champion {

	private ArrayList<Team> listTeam;
	private static Champion champion;

	/* Constructor */ 
	private Champion() {
		super();
		this.listTeam = new ArrayList<Team>();
	}

	/* SINGLETON */
	public static Champion getInstance() {
		if(champion == null) {
			champion = new Champion();
		}
		return champion;
	}

	/* Gets and Sets */
	public ArrayList<Team> getListTeam() {
		return listTeam;
	}

	public void setListTeam(ArrayList<Team> listTeam) {
		this.listTeam = listTeam;
	}

	/* Methods */

	public void addTeam (Team team) { // Agregar equipos
		listTeam.add(team);

	}




	public String playerMVP() { // Retorna el nombre del jugador mas valioso.
		float mayor = 0.0f;
		String name = null;

		for (Team team : listTeam) {
			for (Player player : team.getListPlayer()) {

				if (player.efectividad() > mayor) {
					mayor = player.efectividad();
					name = player.getName();
				}		
			}	
		}
		return name;
	}

	public ArrayList<String> playerOpuestoSuperiorEfectivity(Float valor){ // Retorna los jugadores auxiliares con mayor efectividad del valor dado.
		ArrayList<String> listPlayer = new ArrayList<String>();


		for (Team team : listTeam) {
			for (Player player : team.getListPlayer()) {
				if (player instanceof Opuesto && player.efectividad() > valor) {
					listPlayer.add(player.getName());		
				}	
			}	
		}
		return listPlayer;
	}

	public int playerLiberosMostErrorThanRecibos() { //Retorna la cantidad de libero mas errors que recibos efectivos.
		int amount = 0;

		for (Team team : listTeam) {
			for (Player player : team.getListPlayer()) {

				if (player instanceof Libero ) {
					if (player.errores > ((Libero)player).getRecibosEfectivos()) {
						amount++;			
					}				
				}
			}
		}	
		return amount;
	}

	public String playerPasadorMostFintasThan() { //Retorna el  pasador con mas fintas.
		int mayor = 0;
		String name = null;

		for (Team team : listTeam) {
			for (Player player : team.getListPlayer()) {
				if (player instanceof Pasador) {
					if (((Pasador)player).getFintasEfectivas() > mayor) {

						mayor = ((Pasador)player).getFintasEfectivas();
						name = player.getName();
					}
				}
			}
		}
		return name;
	}

	public String playerOpuestoMostEfectivity() { // Retorna el opuesto/ auxiliar con mas efectividad.
		float mayor = 0.0f;
		String name = null;

		for (Team team : listTeam) {
			for (Player player : team.getListPlayer()) {
				if (player instanceof Opuesto ) {
					if (player.efectividad() > mayor) {
						mayor = player.efectividad();
						name = player.getName();			
					}		
				}		
			}		
		}
		return name;
	}
	
	public int playerOpuestoEfectiveBlock(String nameOpuesto) { // Retorna opuesto mas bloqueos efectivos.
		int amount = 0;
		
		for (Team team : listTeam) {
			for (Player player : team.getListPlayer()) {
				if (player instanceof Opuesto) {
					if (player.getName().equalsIgnoreCase(nameOpuesto)) {
						amount = ((Opuesto) player).getBloqueosEfectivos();			
					}	
				}	
			}	
		}
		return amount;
	}
	
	public ArrayList<String> playerNotErrores (){ // Retorna con los jugadores que no cometieron errores.
		ArrayList<String> listPlayer = new ArrayList<String>();
		
		for (Team team : listTeam) {
			for (Player player : team.getListPlayer()) {
				if (player.getErrores() == 0) {
					listPlayer.add(player.getName());	
				}	
			}	
		}	
		return listPlayer;
	}
	
	
	
}
