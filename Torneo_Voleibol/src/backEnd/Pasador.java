package backEnd;

public class Pasador extends Player {
	
	private int pases;
	private int fintasEfectivas;
	
	/* Constructor */
	
	public Pasador(String id, String name, int errores, int aces, int totalService, int pases, int fintasEfectivas) {
		super(id, name, errores, aces, totalService);
		this.pases = pases;
		this.fintasEfectivas = fintasEfectivas;
	}
	
	/* Gets and Sets */
	public int getPases() {
		return pases;
	}

	public int getFintasEfectivas() {
		return fintasEfectivas;
	}

	public void setPases(int pases) {
		this.pases = pases;
	}

	public void setFintasEfectivas(int fintasEfectivas) {
		this.fintasEfectivas = fintasEfectivas;
	}
	
	
	/* Methods */ 
	
	public float efectividad() {
		float efectividad = 0.0f;
		
		efectividad = (((pases + fintasEfectivas - errores)*100) / (pases + fintasEfectivas + errores))+ super.efectividad();
		return efectividad;
	}
	
	
	

}
