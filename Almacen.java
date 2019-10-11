package backEnd;

public class Almacen {

	public static int generateCode = 1;
	private String codigo;
	private String ciudad;
	private String municipio;
	private int capacidad;
	private int areaTerreno;
	private int cantProducto;
	private Producto[] listProducto;


	/* ---------- Constructor  ---------- */

	public Almacen(String codigo, String ciudad, String municipio, int capacidad, int areaTerreno) {
		super();
		this.codigo = codigo;
		this.ciudad = ciudad;
		this.municipio = municipio;
		this.capacidad = capacidad;
		this.areaTerreno = areaTerreno;
		cantProducto = 0;
		this.listProducto = new Producto[50];
	}

	/* ---------- Gets and Sets  ---------- */

	public String getCodigo() {
		return codigo;
	}

	public String getCiudad() {
		return ciudad;
	}

	public String getMunicipio() {
		return municipio;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public int getAreaTerreno() {
		return areaTerreno;
	}

	public int getCantProducto() {
		return cantProducto;
	}

	public Producto[] getListProducto() {
		return listProducto;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public void setAreaTerreno(int areaTerreno) {
		this.areaTerreno = areaTerreno;
	}

	public void setCantProducto(int cantProducto) {
		this.cantProducto = cantProducto;
	}


	public void setListProducto(Producto[] listProducto) {
		this.listProducto = listProducto;
	}

	/******** Methods - Functions *******/

	public void addProduct(Producto producto) {
		listProducto[cantProducto] = producto;
		cantProducto++;
		Producto.generateCode++;
	}

	public void updateProduct(Producto myProduct) {
		int index = searchIndexProductoByCode(myProduct.getCodigo());
		listProducto[index]=myProduct;

	}

	private int searchIndexProductoByCode(String codeProduct) {
		int indexProduct = -1;
		boolean found = false;
		int i = 0;

		while (!found && (i < cantProducto)) {
			if (listProducto[i].getCodigo().equalsIgnoreCase(codeProduct)) {
				found = true;
				indexProduct = i;
			}
			i++;
		}
		return indexProduct; //Retorna el valor del index, o sea la posicion del producto.
	}

	public void deleteProduct(String codeProducto) {

		int indexProduct = searchIndexProductoByCode(codeProducto); //Guarda la posicion del producto, retornado por la funcion searchIndexProductoByCode.
		if (indexProduct >= 0) {
			while ( indexProduct < (cantProducto - 1)) {
				listProducto[indexProduct] = listProducto[indexProduct + 1];
				indexProduct++;
			}
			cantProducto--;
		}

	}

	public Producto searchProductoByCode(String codeProducto) {
		Producto auxProduct = null;
		boolean found = false;
		int i = 0;

		while (!found && i < cantProducto) {
			if(listProducto[i].getCodigo().equalsIgnoreCase(codeProducto)) {
				found = true;
				auxProduct = listProducto[i];
			}
			i++;
		}
		return auxProduct; //Retorna el producto del codigo encontrado.
	}


}
