package backEnd;

import java.util.ArrayList;

public class Team {

	private String id;
	private String name;
	private String trainer;
	private int rankingWorld;
	private ArrayList<Player> listPlayer;

	/* Constructor */

	public Team(String id, String name, String trainer, int rankingWorld) {
		super();
		this.id = id;
		this.name = name;
		this.trainer = trainer;
		this.rankingWorld = rankingWorld;
		this.listPlayer = new ArrayList<Player>();
	}

	/* Gets and Sets */
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getTrainer() {
		return trainer;
	}

	public int getRankingWorld() {
		return rankingWorld;
	}

	public ArrayList<Player> getListPlayer() {
		return listPlayer;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public void setRankingWorld(int rankingWorld) {
		this.rankingWorld = rankingWorld;
	}

	public void setListPlayer(ArrayList<Player> listPlayer) {
		this.listPlayer = listPlayer;
	}

	public void addPlayer (Player player) { // Agregar jugadores.
		listPlayer.add(player);
	}


}
