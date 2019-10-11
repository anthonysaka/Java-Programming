package backEnd;

import java.util.ArrayList;

public class Cliente {
	private String cedula;
	private String nombre;
	private String apellidos;
	private String direccion;
	private String telefono;
	private ArrayList<Cuenta> listCuentaCliente;
	
	
	/* Constructor */
	public Cliente(String cedula, String nombre, String apellidos, String direccion, String telefono) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.listCuentaCliente = new ArrayList<Cuenta>();
	}

     /* Gets and Sets */
	
	public String getCedula() {
		return cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public ArrayList<Cuenta> getListCuentaCliente() {
		return listCuentaCliente;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setListCuentaCliente(ArrayList<Cuenta> listCuentaCliente) {
		this.listCuentaCliente = listCuentaCliente;
	}
	
	
	public void addCuentaAtCliente(Cuenta cuentadelcliente) {
		listCuentaCliente.add(cuentadelcliente);
	}
	
	
	
	
	
	

}
