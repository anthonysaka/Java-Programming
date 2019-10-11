package backEnd;

public class CylindriCheese extends Cheese {
	
	protected float longitud;
	protected float radio;
	
	/* Constructor*/
	
	public CylindriCheese(String codigo, float precioBase, float precioUnit, int cantidad, float longitud, float radio) {
		super(codigo, precioBase, precioUnit, cantidad);
		this.longitud = longitud;
		this.radio = radio;
	}
	

	/* Gets and Sets */
	
	public float getLongitud() {
		return longitud;
	}
	public float getRadio() {
		return radio;
	}
	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}
	public void setRadio(float radio) {
		this.radio = radio;
	}

	@Override
	double volumen() { // Retorna el voumen del cilindrico.
		double vol = 0.0f;
		
		vol = (double)(Math.PI)*(Math.pow(radio, 2))*(longitud);
		
		return vol;	
	}

	
	

}
