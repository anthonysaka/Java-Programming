package backEnd;

public class Empresa {
	
	private Cine misCine;
	private Pelicula misPelis;

	
	
	public Empresa(Cine misCine, Pelicula misPelis) {
		super();
		this.misCine = misCine;
		this.misPelis = misPelis;
	}


	/* ---------- Gets and Sets  ---------- */
	
	/* ---------- Gets ---------- */
	public Cine getMisCine() {
		return misCine;
	}

	public Pelicula getMisPelis() {
		return misPelis;
	}
	
	/* ---------- Sets  ---------- */
	public void setMisCine(Cine misCine) {
		this.misCine = misCine;
	}

	public void setMisPelis(Pelicula misPelis) {
		this.misPelis = misPelis;
	}
	
	
	

}
