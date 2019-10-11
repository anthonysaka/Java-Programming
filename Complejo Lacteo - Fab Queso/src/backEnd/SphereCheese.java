package backEnd;

public class SphereCheese extends Cheese {
	
	private float radio;

	/* Constructor */

	public SphereCheese(String codigo, float precioBase, float precioUnit, int cantidad, float radio) {
		super(codigo, precioBase, precioUnit, cantidad);
		this.radio = radio;
	}

	public float getRadio() {
		return radio;
	}

	public void setRadio(float radio) {
		this.radio = radio;
	}

	@Override
	double volumen() {
		double vol = 0;
		vol = (((Math.PI)*(Math.pow(radio, 3))*4) / 3);
		return vol;
	}
	
	
	
	

}
