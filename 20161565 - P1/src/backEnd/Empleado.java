package backEnd;

public class Empleado {
	
	private String cedula;
	private String nombre;
	private int sueldoBase;
	private int pagoExtra;
	private int horaExtraMes;
	private float servicioSocial;
	private String estadoCivil;
	private int cantHijo;
	
	/* ---------- Constructor  ---------- */
	
	public Empleado(String cedula, String nombre, int sueldoBase, int pagoExtra, int horaExtraMes, float servicioSocial,
			String estadoCivil, int cantHijo) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.sueldoBase = sueldoBase;
		this.pagoExtra = pagoExtra;
		this.horaExtraMes = horaExtraMes;
		this.servicioSocial = servicioSocial;
		this.estadoCivil = estadoCivil;
		this.cantHijo = cantHijo;
	}
	
	/* ---------- Gets and Sets  ---------- */
	
	public String getCedula() {
		return cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public int getSueldoBase() {
		return sueldoBase;
	}
	public int getPagoExtra() {
		return pagoExtra;
	}
	public int getHoraExtraMes() {
		return horaExtraMes;
	}
	public float getServicioSocial() {
		return servicioSocial;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public int getCantHijo() {
		return cantHijo;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setSueldoBase(int sueldoBase) {
		this.sueldoBase = sueldoBase;
	}
	public void setPagoExtra(int pagoExtra) {
		this.pagoExtra = pagoExtra;
	}
	public void setHoraExtraMes(int horaExtraMes) {
		this.horaExtraMes = horaExtraMes;
	}
	public void setServicioSocial(float servicioSocial) {
		this.servicioSocial = servicioSocial;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public void setCantHijo(int cantHijo) {
		this.cantHijo = cantHijo;
	}
	
	

}
