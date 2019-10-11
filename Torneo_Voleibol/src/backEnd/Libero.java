package backEnd;

public class Libero extends Player {
	
	private int recibosEfectivos;

	/* Constructor */
	
	public Libero(String id, String name, int errores, int aces, int totalService, int recibosEfectivos) {
		super(id, name, errores, aces, totalService);
		this.recibosEfectivos = recibosEfectivos;
	}
	
	/* Gets and sets */
	public int getRecibosEfectivos() {
		return recibosEfectivos;
	}

	public void setRecibosEfectivos(int recibosEfectivos) {
		this.recibosEfectivos = recibosEfectivos;
	}
	
	/* Methods */
	
	public float efectividad() {
		float efectividad = 0.0f;
		
		efectividad = (((recibosEfectivos - errores)*100) / recibosEfectivos + errores) + super.efectividad();
		return efectividad;
	}

	
	
	

}
