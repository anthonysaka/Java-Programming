package backEnd;

public class Opuesto extends Player {
	
	private int ataques;
	private int bloqueosEfectivos;
	private int bloqueosFallidos;
	
	/* Constructor */
	
	public Opuesto(String id, String name, int errores, int aces, int totalService, int ataques, int bloqueosEfectivos,
			int bloqueosFallidos) {
		super(id, name, errores, aces, totalService);
		this.ataques = ataques;
		this.bloqueosEfectivos = bloqueosEfectivos;
		this.bloqueosFallidos = bloqueosFallidos;
	}
	
	/* Gets and Sets */
	public int getAtaques() {
		return ataques;
	}

	public int getBloqueosEfectivos() {
		return bloqueosEfectivos;
	}

	public int getBloqueosFallidos() {
		return bloqueosFallidos;
	}

	public void setAtaques(int ataques) {
		this.ataques = ataques;
	}

	public void setBloqueosEfectivos(int bloqueosEfectivos) {
		this.bloqueosEfectivos = bloqueosEfectivos;
	}

	public void setBloqueosFallidos(int bloqueosFallidos) {
		this.bloqueosFallidos = bloqueosFallidos;
	}
	

	/* Methods */ 
	
	public float efectividad() {
		float efectividad = 0.0f;
		
		efectividad = (((ataques+bloqueosEfectivos - bloqueosFallidos - errores)*100) / (ataques + bloqueosEfectivos + bloqueosFallidos + errores)) + super.efectividad();
		return efectividad;
	}
	
	

}
