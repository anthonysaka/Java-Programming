package backEnd;

public class Cliente {
	
	private String cedula;
	private String nombre;
	private String direccion;
	private String sexo;
	private int puntoAcumulados;

	/* ---------- Constructor  ---------- */
	
	public Cliente(String cedula, String nombre, String direccion, String sexo) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.direccion = direccion;
		this.sexo = sexo;
	    this.puntoAcumulados = puntoAcumulados;
			}

	/* ---------- Gets and Sets  ---------- */

	public String getCedula() {
		return cedula;
	}


	public String getNombre() {
		return nombre;
	}


	public String getDireccion() {
		return direccion;
	}


	public String getSexo() {
		return sexo;
	}


	public int getPuntoAcumulados() {
		return puntoAcumulados;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public void setPuntoAcumulados(int puntoAcumulados) {
		this.puntoAcumulados = puntoAcumulados;
	}

}
