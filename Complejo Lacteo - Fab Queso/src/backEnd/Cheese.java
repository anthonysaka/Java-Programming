package backEnd;

public abstract class Cheese {

	protected String codigo;
	protected float precioBase;
	protected float precioUnit;
	protected  int cantidad;
	protected float precio;

	/* Constructor */
	public Cheese(String codigo, float precioBase, float precioUnit, int cantidad) {
		super();
		this.codigo = codigo;
		this.precioBase = precioBase;
		this.precioUnit = precioUnit;
		this.cantidad = cantidad;
	}

	/* Gets and Sets */
	public String getCodigo() {
		return codigo;
	}
	public float getPrecioBase() {
		return precioBase;
	}
	public float getPrecioUnit() {
		return precioUnit;
	}
	public int getCantidad() {
		return cantidad;
	}
	public float getPrecio() {
		return precio;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public void setPrecioBase(float precioBase) {
		this.precioBase = precioBase;
	}
	public void setPrecioUnit(float precioUnit) {
		this.precioUnit = precioUnit;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	/* Methods*/

	abstract double volumen();

	public float priceCheese() {
		float price = (float) (precioBase + (precioUnit * volumen()));
		this.setPrecio(price);
		return price;
	}

}
