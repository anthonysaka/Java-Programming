package backEnd;

public class Cine {
	

	/* ---------- Attributes ---------- */

	private String codigo;
	private String nombre;
	private String provincias;
	private int cantSalas;
	private Boleta[] boletasVendidas;
	private Pelicula[] listPelicula;
	
	
	/* ---------- Constructor  ---------- */
	
	public Cine(String codigo, String nombre, String provincias, int cantSalas) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.provincias = provincias;
		this.cantSalas = cantSalas;
	}
	
	/* ---------- Gets and Sets  ---------- */
	
	/* ---------- Gets ---------- */
	public String getCodigo() {
		return codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getProvincias() {
		return provincias;
	}
	
	public int getCantSalas() {
		return cantSalas;
	}
	
	public Boleta[] getBoletasVendidas() {
		return boletasVendidas;
	}
	
	public Pelicula[] getListPelicula() {
		return listPelicula;
	}
	
	/* ---------- Sets  ---------- */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setProvincias(String provincias) {
		this.provincias = provincias;
	}
	
	public void setCantSalas(int cantSalas) {
		this.cantSalas = cantSalas;
	}
	
	public void setBoletasVendidas(Boleta[] boletasVendidas) {
		this.boletasVendidas = boletasVendidas;
	}
	
	public void setListPelicula(Pelicula[] listPelicula) {
		this.listPelicula = listPelicula;
	}
	
	
	
	
	
	
	
	
	
	
}
