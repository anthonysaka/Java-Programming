package backEnd;

public class Pelicula {
	

	/* ---------- Attributes ---------- */

	private String codigo;
	private String nombre;
	private String genero;
	private int duracion;

	
	public Pelicula(String codigo, String nombre, String genero, int duracion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.genero = genero;
		this.duracion = duracion;
	}


	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getGenero() {
		return genero;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	
	
	
	
	

}

