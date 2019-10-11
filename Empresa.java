/**
 * 
 */
package backEnd;

import com.sun.media.sound.AlawCodec;

/**
 * @author Anthony Sakamoto
 *
 */
public class Empresa {

	private Almacen[] listAlmacen;
	public static int cantAlmacen = 0;

	/* ---------- Constructor  ---------- */

	public Empresa() {
		super();
		this.listAlmacen =  new Almacen[3];
	}


	/* ---------- Gets and Sets  ---------- */

	public Almacen[] getListAlmacen() {
		return listAlmacen;
	}

	public void setListAlmacen(Almacen[] listAlmacen) {
		this.listAlmacen = listAlmacen;
	}


	public static int getCantAlmacen() {
		return cantAlmacen;
	}


	public static void setCantAlmacen(int cantAlmacen) {
		Empresa.cantAlmacen = cantAlmacen;
	}


	/******** Methods - Functions *******/

	// 1. Para registrar almacenes 
	public void addAlmacen(Almacen almacen) {
			listAlmacen[cantAlmacen] = almacen;
			if (cantAlmacen < 3) {
				cantAlmacen++;
			   Almacen.generateCode++;
			}
		}

	/******/

	public Almacen searchAlmacenByCode(String codeAlmacen) {
		Almacen auxAlma = null;
		boolean found = false;
		int i = 0;

		while (!found && i < cantAlmacen) {
			if(listAlmacen[i].getCodigo().equalsIgnoreCase(codeAlmacen)) {
				found = true;
				auxAlma = listAlmacen[i];
			}
			i++;
		}
		return auxAlma; //Retorna el almacen del codigo encontrado.
	}


	private int searchIndexAlmacenByCode(String codeAlma) {
		int indexWare = -1;
		boolean found = false;
		int i = 0;

		while (!found && (i < cantAlmacen)) {
			if (listAlmacen[i].getCodigo().equalsIgnoreCase(codeAlma)) {
				found = true;
				indexWare = i;
			}
			i++;
		}
		return indexWare; //Retorna el valor del index, o sea la posicion del almacen.
	}


	public int StockRealProductoByTipoAllAlmacenes(String tipoProducto) {
		int i = 0;
		int k = 0;
		int cantStockRealTotal = 0;

		while (i < cantAlmacen) {
			while(k < listAlmacen[i].getCantProducto()) {

				if(listAlmacen[i].getListProducto()[k].getTipo().equalsIgnoreCase(tipoProducto)) {
					cantStockRealTotal += listAlmacen[i].getListProducto()[k].getStockReal();
				}
				k++;
			}
			k=0;
			i++;
		}
		return (cantStockRealTotal); // Retorna la cantidad de un tipo de producto de la empresa (o sea de todos los almacenes el stock real disponible).
	}
	
	public int cantProductoByTipoAllAlmacenes(String tipoProducto) {
		int i = 0;
		int k = 0;
		int cantTipoProduct = 0;

		while (i < cantAlmacen) {
			while(k < listAlmacen[i].getCantProducto()) {

				if(listAlmacen[i].getListProducto()[k].getTipo().equalsIgnoreCase(tipoProducto)) {
					cantTipoProduct++;
				}
				k++;
			}
			k=0;
			i++;
		}
		return (cantTipoProduct); // Retorna la cantidad de un tipo de producto de la empresa (o sea de todos los almacenes cantidad de productos de ese tipo).
	}



	public float estimateGrossProfitPerWarehouse(String codeAlma) {  // GrossProfit -> GananciaBruta.
		float gananciaBruta = 0.00f;                                    // --> GananciaBruta futura a partir del momento de consulta.
		float precioCompra = 0.00f;
		float precioVenta = 0.00f;
		int stockReal = 0;
		int i = 0;
		Almacen auxAlmacen =  searchAlmacenByCode(codeAlma);

		while (i < auxAlmacen.getCantProducto()) {
			precioCompra =  auxAlmacen.getListProducto()[i].getPrecioCompra();
			precioVenta =  auxAlmacen.getListProducto()[i].getPrecioVenta();
			stockReal = auxAlmacen.getListProducto()[i].getStockReal();

			if ((precioVenta - precioCompra) > 0) {
				gananciaBruta += (float)((precioVenta - precioCompra)*(stockReal));
			}
			i++;
		}


		return gananciaBruta; // Retorna ganacia bruta del almacen consultado. gananciaBruta = (precioVenta - precioCompra)*stockReal
	}


	public float estimateActualNetProfitPerWarehouse(String codeAlma) {

		/* DESCUENTOS:
		 * Comestibles - 50% - 60 dias
		 * Atuendos - 35% - 75 dias
		 * Electronicos - 20% - 90 dias
		 */

		int i = 0;
		int stockRealTotal = 0;
		float precioDescuentoTotal = 0.00f;
		float precioCompraTotal = 0.00f;
		float gananciaNetaActual = 0.00f;
		float perdidasPorDescu = 0.00f;

		Almacen auxAlmacen =  searchAlmacenByCode(codeAlma);

		while(i < auxAlmacen.getCantProducto()) {
			String tipoProdu = auxAlmacen.getListProducto()[i].getTipo();
			int diasVencimiento = auxAlmacen.getListProducto()[i].getDiasCadu();

			if (tipoProdu.equalsIgnoreCase("Comestibles") && diasVencimiento <= 60) {
				precioDescuentoTotal = ((auxAlmacen.getListProducto()[i].getPrecioVenta()) - (auxAlmacen.getListProducto()[i].getPrecioVenta())*(0.50f));

			}
			else if (tipoProdu.equalsIgnoreCase("Atuendos") && diasVencimiento <= 75) {
				precioDescuentoTotal = ((auxAlmacen.getListProducto()[i].getPrecioVenta()) - (auxAlmacen.getListProducto()[i].getPrecioVenta())*(0.35f));

			}
			else if (tipoProdu.equalsIgnoreCase("Electronicos") && diasVencimiento <= 90) {
				precioDescuentoTotal = ((auxAlmacen.getListProducto()[i].getPrecioVenta()) - (auxAlmacen.getListProducto()[i].getPrecioVenta())*(0.20f));

			}
			else {
				precioDescuentoTotal = ((auxAlmacen.getListProducto()[i].getPrecioVenta()));

			}
			precioCompraTotal = auxAlmacen.getListProducto()[i].getPrecioCompra();
			stockRealTotal = auxAlmacen.getListProducto()[i].getStockReal();

			if (precioDescuentoTotal-precioCompraTotal > 0) {
				gananciaNetaActual += (precioDescuentoTotal - precioCompraTotal)*stockRealTotal;
			}

			i++;
		}
		return gananciaNetaActual;
	}


	public float estimateActualLossProfitCompany() {
		int i = 0;
		float gananciaPerdida = 0.00f;

		while (i < cantAlmacen) {
			gananciaPerdida += estimateGrossProfitPerWarehouse(listAlmacen[i].getCodigo()) - estimateActualNetProfitPerWarehouse(listAlmacen[i].getCodigo());
			i++;

		}
		return gananciaPerdida;  // Busca en todos los almacenes, y devuelve la perdida de ganancia de la compañia.
	}

	public String dispatchProduct (String codeProdu, int cantProdu) {

		int i = 0;
		int k = 0;
		Boolean flagFound = false;
		String codeAlmaProductFound = null;

		while ( !flagFound && i < cantAlmacen) {
			while (!flagFound && k < listAlmacen[i].getCantProducto()) {
				if ((listAlmacen[i].getListProducto()[k].getCodigo().equalsIgnoreCase(codeProdu)) && (listAlmacen[i].getListProducto()[k].getStockReal() > cantProdu)) {
					if ((listAlmacen[i].getListProducto()[k].getStockReal() > (listAlmacen[i].getListProducto()[k].getStockIni()*0.10)) && ((listAlmacen[i].getListProducto()[k].getStockReal() - cantProdu)>= listAlmacen[i].getListProducto()[k].getStockIni()*0.10)) {
						flagFound = true;
						codeAlmaProductFound = listAlmacen[i].getCodigo();
					}
					else {
						codeAlmaProductFound = null;
					}
				}
				k++;		
			}
			k=0;
			i++;
		}
		return codeAlmaProductFound;  //Retorna el codigo del primer almacen donde se pueda despachar el producto.
	}


	public void deleteWarehouse(String codeAlma) {

		int indexWarehouse = searchIndexAlmacenByCode(codeAlma); //Guarda la posicion del almacen, retornado por la funcion searchIndexAlmacenByCode.
		if (indexWarehouse >= 0) {
			while ( indexWarehouse < (cantAlmacen - 1)) {
				listAlmacen[indexWarehouse] = listAlmacen[indexWarehouse + 1];
				indexWarehouse++;
			}
			cantAlmacen--;
		}
	}


	public void updateWarehouse(Almacen myWarehouse) {
		int index = searchIndexAlmacenByCode(myWarehouse.getCodigo());
		listAlmacen[index]=myWarehouse;
		
	}




}



