package backEnd;

public class Producto {
	public static int generateCode = 1;
	private String codigo;
	private String codigoAlmacen;
	private String nombre;
	private String tipo;
	private float precioCompra;
	private float precioVenta;
	private int stockReal;
	private int stockIni;
	private int diasCadu;

	
	/* ---------- Constructor  ---------- */
	
	public Producto(String codigo, String codigoAlmacen, String nombre, String tipo, float precioCompra, float precioVenta,
			int stockReal, int stockIni, int diasCadu) {
		super();
		this.codigo = codigo;
		this.codigoAlmacen = codigoAlmacen;
		this.nombre = nombre;
		this.tipo = tipo;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.stockReal = stockReal;
		this.stockIni = stockIni;
		this.diasCadu = diasCadu;
	}

	/* ---------- Gets and Sets  ---------- */

	public String getCodigo() {
		return codigo;
	}


	public String getCodigoAlmacen() {
		return codigoAlmacen;
	}


	public String getNombre() {
		return nombre;
	}


	public String getTipo() {
		return tipo;
	}


	public float getPrecioCompra() {
		return precioCompra;
	}


	public float getPrecioVenta() {
		return precioVenta;
	}


	public int getStockReal() {
		return stockReal;
	}


	public int getStockIni() {
		return stockIni;
	}


	public int getDiasCadu() {
		return diasCadu;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public void setCodigoAlmacen(String codigoAlmacen) {
		this.codigoAlmacen = codigoAlmacen;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public void setPrecioCompra(float precioCompra) {
		this.precioCompra = precioCompra;
	}


	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}


	public void setStockReal(int stockReal) {
		this.stockReal = stockReal;
	}


	public void setStockIni(int stockIni) {
		this.stockIni = stockIni;
	}


	public void setDiasCadu(int diasCadu) {
		this.diasCadu = diasCadu;
	}
	
	

	
	

}
