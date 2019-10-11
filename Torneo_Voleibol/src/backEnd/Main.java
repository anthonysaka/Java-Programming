package backEnd;

public class Main {

	public static void main(String[] args) {
		
		Champion torneo = Champion.getInstance();
		
		Team teamPrueba = new Team("T-001","Metros", "Juan Marichal", 3);
		Team teamPrueba2 = new Team("T-002","Metros2", "Juan Marichal", 3);
		Team teamPrueba3 = new Team("T-003","Metros3", "Juan Marichal", 3);
		Team teamPrueba4 = new Team("T-004","Metros4", "Juan Marichal", 3);
		
		
		torneo.addTeam(teamPrueba);
		torneo.addTeam(teamPrueba2);
		torneo.addTeam(teamPrueba3);
		torneo.addTeam(teamPrueba4);
		
		
		Player playerPrueba = new Libero("P-001","Jugador1", 20, 50, 10, 15);
		Player playerPrueba2 = new Libero("P-002","Jugador2", 10, 5, 10, 9);
		Player playerPrueba3 = new Libero("P-003","Jugador3", 10, 5, 10, 15);
		Player playerPrueba4 = new Libero("P-004","Jugador4", 1, 5000, 1, 1500);
		
		Player pasadorPrueba = new Pasador("P-005","Pasador1", 0, 50, 10, 10, 20);
		Player pasadorPrueba2 = new Pasador("P-006","Pasador2", 1, 500, 10, 100, 200);
		Player pasadorPrueba3 = new Pasador("P-007","Pasador3", 100, 50, 10, 10, 400);
		Player pasadorPrueba4 = new Pasador("P-008","Pasador4", 10, 5, 10, 10, 20);
		
		Player auxiliarPrueba = new Opuesto("P-009","Auxiliar1", 100, 10, 100, 1, 100, 20);
		Player auxiliarPrueba2= new Opuesto("P-010","Auxiliar2", 1, 100, 10, 100, 10, 200);
		Player auxiliarPrueba3 = new Opuesto("P-011","Auxiliar3", 100, 10, 100, 1, 100, 20);
		Player auxiliarPrueba4 = new Opuesto("P-012","Auxiliar4", 1, 1000, 10, 100, 10, 200);
		
		teamPrueba.addPlayer(auxiliarPrueba);
		teamPrueba2.addPlayer(auxiliarPrueba2);
		teamPrueba3.addPlayer(auxiliarPrueba3);
		teamPrueba4.addPlayer(auxiliarPrueba4);
		
		teamPrueba.addPlayer(playerPrueba);
		teamPrueba.addPlayer(playerPrueba2);
		teamPrueba2.addPlayer(playerPrueba3);
		teamPrueba2.addPlayer(playerPrueba4);
		
		teamPrueba3.addPlayer(pasadorPrueba);
		teamPrueba3.addPlayer(pasadorPrueba2);
		teamPrueba4.addPlayer(pasadorPrueba3);
		teamPrueba4.addPlayer(pasadorPrueba4);
		
		System.out.println("El jugador mas valioso: "+ torneo.playerMVP());
		
		System.out.println("Jugadores opuestos con mayor efectividad: "+ torneo.playerOpuestoSuperiorEfectivity(30.0f));
		
		
		System.out.println("La cantidad de jugadores liberos con mas errores que recibos efectivos: "+ torneo.playerLiberosMostErrorThanRecibos());
		
		System.out.println("El jugador pasador con mayor fintas efectivas: "+torneo.playerPasadorMostFintasThan());
		
		System.out.println("El jugador opuesto/auxiliar con mayor efectividad: "+torneo.playerOpuestoMostEfectivity());
		
		System.out.println("Cantidad de bloqueos efectivos del opuesto/auxiliar: "+ torneo.playerOpuestoEfectiveBlock("Auxiliar3"));
		
		System.out.println("Jugadores que no tienen errores: "+ torneo.playerNotErrores());

		


	}

}
