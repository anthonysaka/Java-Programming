package backEnd;

public abstract class Player {
	
	protected String id;
	protected String name;
	protected int errores;
	protected int aces;
	protected int totalService;
	
	/* Constructor */
	
	public Player(String id, String name, int errores, int aces, int totalService) {
		super();
		this.id = id;
		this.name = name;
		this.errores = errores;
		this.aces = aces;
		this.totalService = totalService;
	}

	/* Gets and Sets */
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getErrores() {
		return errores;
	}

	public int getAces() {
		return aces;
	}

	public int getTotalService() {
		return totalService;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setErrores(int errores) {
		this.errores = errores;
	}

	public void setAces(int aces) {
		this.aces = aces;
	}

	public void setTotalService(int totalService) {
		this.totalService = totalService;
	}
	
	
	/* Methods */
	
	public float efectividad() { // Retorna la parte comun de la efectividad.
		float cEfect = 0.0f;
		cEfect = (float) ((aces*100.00)/totalService); // aces*100 / servicios

		return cEfect;
	}
	
	
	
	

}
