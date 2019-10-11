package backEnd;

public class Main {

	public static void main(String[] args) {
		Empresa myCompany = new Empresa();
		
		Empleado miEmpleado1 = new Empleado("402-505", "juan", 15500, 100, 10, 0.1f, "Casado", 2);
		Empleado miEmpleado2 = new Empleado("402-506", "jose", 15500, 100, 10, 0.1f, "Soltero", 2);
		
		Cliente miCliente1 = new Cliente("402-200", "maria", "santiago", "femenino");
		Cliente miCliente2 = new Cliente("402-202", "pedro", "puerto plata", "masculino");
		
		Venta miVenta1 = new Venta(10, 2550, miEmpleado1.getCedula(), miCliente1.getCedula());
		Venta miVenta2 = new Venta(10, 2000, miEmpleado1.getCedula(), miCliente2.getCedula());
		
		myCompany.addEmpleado(miEmpleado1);
		myCompany.addEmpleado(miEmpleado2);
		myCompany.addCliente(miCliente1);
		myCompany.addCliente(miCliente2);
		myCompany.addVenta(miVenta1);
		myCompany.addVenta(miVenta2);
		
		
		System.out.println(miVenta2.getCantPunto());
		System.out.println(myCompany.calculateSalaryEmpleado(miEmpleado1.getCedula()));
		System.out.println(myCompany.calculateMoneyServicioSocialEmpleado(miEmpleado1.getCedula()));
		System.out.println(myCompany.calculateMoneyServicioSocialEmpleado(miEmpleado2.getCedula()));
		
		
		System.out.println(myCompany.calculateMayorPuntoAcumulados());
		
		
		// NOTAL PROFESOR EL MAIN NO ESTA COMPLETO O SEA HAY QUE PROBAR LOS METODOS AQUI!
	}

}
