package backEnd;

import java.util.ArrayList;

public class Banco {

	private ArrayList<Cuenta> listCuentas;
	private ArrayList<Cliente> listClientes;
	private static Banco banco;


	/* Constructor */

	private Banco() {
		super();
		this.listCuentas = new ArrayList<Cuenta>();
		this.listClientes = new ArrayList<Cliente>();
	}

	/* PATRON SINGLETON */
	public static Banco getInstance() {
		if(banco == null) {
			banco = new Banco();
		}
		return banco;
	}

	/* Gets and Sets */

	public ArrayList<Cuenta> getListCuentas() {
		return listCuentas;
	}
	public ArrayList<Cliente> getListClientes() {
		return listClientes;
	}
	public void setListCuentas(ArrayList<Cuenta> listCuentas) {
		this.listCuentas = listCuentas;
	}
	public void setListClientes(ArrayList<Cliente> listClientes) {
		this.listClientes = listClientes;
	}

	public void addClient (Cliente cliente) {
		listClientes.add(cliente);
	}
	public void addCuenta (Cuenta cuenta) {
		listCuentas.add(cuenta);
	}

	public Cliente searchClientByCedula(String cedulaClient) {
		Cliente auxClient = null;
		boolean found = false;
		int i = 0;

		while (!found && i < listClientes.size()) {
			if(listClientes.get(i).getCedula().equalsIgnoreCase(cedulaClient)) {
				found = true;
				auxClient = listClientes.get(i);
			}
			i++;
		}
		return auxClient; //Retorna el cliente de la cedula encontrada.
	}

	public float revisionMensualCuenta(String cedulaCliente) {

		Cliente auxCliente = searchClientByCedula(cedulaCliente);
		int i = 0;
		float saldo = 0;

		while( i < auxCliente.getListCuentaCliente().size()) {
			saldo = auxCliente.getListCuentaCliente().get(i).getSaldo() + (auxCliente.getListCuentaCliente().get(i).getInteres() - auxCliente.getListCuentaCliente().get(i).getComision());
			i++;
		}

		return saldo;	
	}

	public boolean retirarDinero (String codigoCuenta, float montoRetirar) {
		Boolean flag = false;

		for (Cuenta cuenta : listCuentas) {
			if (codigoCuenta.equalsIgnoreCase(cuenta.getCodigo())) {
				if (cuenta instanceof Corriente) {
					if (montoRetirar < cuenta.getSaldo()) {
						flag = true;
						System.out.println("Retiro CC");
					}
				}
				else if (cuenta instanceof FondoInversion) {
					if (montoRetirar > 500) {
						cuenta.saldo = (float) (cuenta.getSaldo() - (montoRetirar*0.01));
						System.out.println("El monto supera los 500, se ha cobrado 1% del monto solicitado");
					}
					flag = true;

				}
				else if (cuenta instanceof Vivienda) {
					flag = false;
					System.out.println("No se puede sacar dinero");
				}
			}

		}
		return flag;
	}


	public void ingresarSaldo (String codigoCuenta, float monto) {

		for (Cuenta cuenta : listCuentas) {
			if (codigoCuenta.equalsIgnoreCase(cuenta.getCodigo())) {
				cuenta.saldo = cuenta.getSaldo() + monto;
			}	
		}		
	}


	public ArrayList< Integer> puntoAcumulados (String cedulaCliente) {
		Cliente auxCliente = searchClientByCedula(cedulaCliente);
		ArrayList<Integer> puntosCuentas = new ArrayList<Integer>();
		int puntos = 0;
		int puntoCorriente = 0;
		int puntoVivienda = 0 ;
		int puntoFondoInversion = 0;


		for (Cuenta cuenta : auxCliente.getListCuentaCliente()) {
			if (cuenta instanceof Corriente) {
				puntoCorriente += (int) (cuenta.getSaldo() / 10.0);	
			}
			else if (cuenta instanceof Vivienda) {
				puntoVivienda += (int) (cuenta.getSaldo() / 10.0);	
			}
			else if (cuenta instanceof FondoInversion) {
				puntoFondoInversion += (int) (cuenta.getSaldo() / 10.0);	
			}
		}
		puntos = puntoCorriente + puntoVivienda + puntoFondoInversion;
		puntosCuentas.add(0,puntoCorriente);
		puntosCuentas.add(1,puntoVivienda);
		puntosCuentas.add(2,puntoFondoInversion);
		puntosCuentas.add(4,puntos);
		
		return puntosCuentas;
	}




}
