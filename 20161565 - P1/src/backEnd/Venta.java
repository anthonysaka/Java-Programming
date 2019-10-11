package backEnd;

public class Venta {
	private int cantArticulo;
	private int montoTotal;
	private int cantPunto;
	private String vendedor;
	private String clientePertenece;

	/* ---------- Constructor  ---------- */
	
	public Venta(int cantArticulo, int montoTotal, String vendedor, String clientePertenece) {
		super();
		this.cantArticulo = cantArticulo;
		this.montoTotal = montoTotal;
		this.cantPunto = (int)(montoTotal / 100);
		this.vendedor = vendedor;
		this.clientePertenece = clientePertenece;
	}

	/* ---------- Gets and Sets  ---------- */
	
	public int getCantArticulo() {
		return cantArticulo;
	}

	public int getMontoTotal() {
		return montoTotal;
	}

	public int getCantPunto() {
		return cantPunto;
	}

	public String getVendedor() {
		return vendedor;
	}

	public String getClientePertenece() {
		return clientePertenece;
	}

	public void setCantArticulo(int cantArticulo) {
		this.cantArticulo = cantArticulo;
	}

	public void setMontoTotal(int montoTotal) {
		this.montoTotal = montoTotal;
	}

	public void setCantPunto(int cantPunto) {
		this.cantPunto = cantPunto;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public void setClientePertenece(String clientePertenece) {
		this.clientePertenece = clientePertenece;
	}
	
	
}
