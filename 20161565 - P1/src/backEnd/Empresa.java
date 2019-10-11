package backEnd;

public class Empresa {

	private Empleado[] listEmpleado;
	private Cliente[] listCliente;
	private Venta[] listVenta;
//	private static Empresa miEmpresa;
	private int cantEmpleado;
	private int cantCliente;
	private int CantVenta;

	/* ---------- Constructor  ---------- */

	public Empresa() {
		super();
		this.listEmpleado = new Empleado [50];
		this.listCliente = new Cliente [100];
		this.listVenta = new Venta [200];
	}

	/* ---------- Gets and Sets  ---------- */

	public Empleado[] getListEmpleado() {
		return listEmpleado;
	}

	public Cliente[] getListCliente() {
		return listCliente;
	}

	public Venta[] getListVenta() {
		return listVenta;
	}

	public void setListEmpleado(Empleado[] listEmpleado) {
		this.listEmpleado = listEmpleado;
	}

	public void setListCliente(Cliente[] listCliente) {
		this.listCliente = listCliente;
	}

	public void setListVenta(Venta[] listVenta) {
		this.listVenta = listVenta;
	}

	/******** Methods - Functions *******/
	
//	public static Empresa getinstance() {
//		if(miEmpresa == null) {
//			miEmpresa = new Empresa();
//		}
//		
//		return miEmpresa;
//	}


	public void addEmpleado(Empleado empleado) {
		listEmpleado[cantEmpleado] = empleado;
		cantEmpleado++;
	} // Agrega emppleado.


	public void addCliente(Cliente cliente) {
		listCliente[cantCliente] = cliente;
		cantCliente++;
	} // Agrega cliente.
	
	////despues del examen
	public void addVenta(Venta venta) {
		listVenta[CantVenta] = venta;
		CantVenta++;
	} // Agrega cliente.
	
	////


	public Empleado searchEmpleadoBycode(String cedulaEmpleado) {
		Empleado auxEmpleado = null;
		boolean found = false;
		int i = 0;

		while (!found && i < cantEmpleado) {
			if (listEmpleado[i].getCedula().equalsIgnoreCase(cedulaEmpleado)) {
				found =true;
				auxEmpleado = listEmpleado[i];
			}
			i++;
		}
		return auxEmpleado; // Retorna el empleado de la cedula encontrada.
	}

	public Cliente searchClienteBycode(String cedulaCliente) {
		Cliente auxCliente = null;
		boolean found = false;
		int i = 0;

		while (!found && i < cantCliente) {
			if (listCliente[i].getCedula().equalsIgnoreCase(cedulaCliente)) {
				found =true;
				auxCliente = listCliente[i];
			}
			i++;
		}
		return auxCliente; // Retorna el cliente de la cedula encontrada.
	}


	public int calculateSalaryEmpleado(String ceduEmpleado) {
		int sueldoBase = 0;
		int sueldoExtra = 0;
		int sueldoBruto = 0;

		Empleado auxEmpleado = searchEmpleadoBycode(ceduEmpleado);
		sueldoBase = auxEmpleado.getSueldoBase();
		sueldoExtra = (auxEmpleado.getPagoExtra())*(auxEmpleado.getHoraExtraMes());
		sueldoBruto = sueldoBase + sueldoExtra;

		return sueldoBruto; // Retorna el sueldo bruto del empleado.
	}

	public float calculateMoneyServicioSocialEmpleado(String ceduEmpleado) {
		float retencion = 0.0f;
		float retencionDinero = 0.0f;
		Empleado auxEmpleado = searchEmpleadoBycode(ceduEmpleado);
		String estadoCivil = auxEmpleado.getEstadoCivil();
		float tipo = auxEmpleado.getServicioSocial();

		if (estadoCivil.equalsIgnoreCase("Casado")) {
			retencion = (float)(tipo - 0.02f) - (0.01f)*(auxEmpleado.getCantHijo());
		}
		else {
			retencion = auxEmpleado.getServicioSocial();
		}

		retencionDinero = (float)(auxEmpleado.getSueldoBase())*retencion;
		return retencionDinero; // Retorna el monto de retencion del empleado, segun tu estado civil.
	}
	
	public void puntosacumulado() {
		int i =0;
		int k = 0;
		int acumulados =0;
		while ( k < cantCliente) {
			while (i < CantVenta) {
				if (listVenta[i].getClientePertenece().equalsIgnoreCase(listCliente[k].getCedula())) {
					acumulados+= listVenta[i].getCantPunto();
					listCliente[k].setPuntoAcumulados(acumulados);
				}
				
			}	
		}

	}

	public String calculateMayorPuntoAcumulados() {
		int i = 0;
		int k = 0;
		int mayor = 0;
		int puntosAcumulados = 0;
		int [] puntosCliente = new int[cantCliente];


		while (i < cantCliente) {
			while(k < CantVenta) {
				if (listVenta[k].getClientePertenece().equalsIgnoreCase(listCliente[i].getCedula())) {
					puntosAcumulados += listCliente[i].getPuntoAcumulados();
				}
				k++;
			}
			puntosCliente[i] = puntosAcumulados;
			k=0;
			puntosAcumulados = 0;
			i++;
			}
		int m = 0;

		for (int j = 0; j < cantCliente - 1; j++) {
			if (puntosCliente[j] >= mayor ) {
				mayor = puntosCliente[j];
				m++;
			}
			//m=j;
			
		}
		return listCliente[m].getCedula(); //Retonar al cedula del cliente con mayor cantidad de punto.
	}


	public int ventasRealizadasPorEmpleado (String ceduEmpleado) {

		Empleado auxEmpleado = searchEmpleadoBycode(ceduEmpleado);
		int i = 0;
		int ventasReali = 0;

		while(i < CantVenta) {
			if (auxEmpleado.getCedula().equalsIgnoreCase(listVenta[i].getVendedor())) {
				ventasReali++;
			}
			i++;

		}
		return ventasReali; // Retorna la cantidad de ventas realizadas por un empleados.
	}
}
