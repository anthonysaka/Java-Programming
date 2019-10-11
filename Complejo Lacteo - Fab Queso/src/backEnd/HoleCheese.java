package backEnd;

public class HoleCheese extends CylindriCheese {
	
	private float radioInterior;

	/* Constructor */
	public HoleCheese(String codigo, float precioBase, float precioUnit, int cantidad, float longitud, float radio, float radioInterior) {
		super(codigo, precioBase, precioUnit, cantidad, longitud, radio);
		this.radioInterior = radioInterior;
	}

	/* Gets and Sets*/
	
	public float getRadioInterior() {
		return radioInterior;
	}
	
	public void setRadioInterior(float radioInterior) {
		this.radioInterior = radioInterior;
	}
	
	double volumen() { // Retorna el volumen del queso cilindrovacio
		double vol = 0;
		
		vol = (Math.PI)*((Math.pow(radio, 2))-(Math.pow(radioInterior, 2)))*(longitud);
		return vol;
	}

}
