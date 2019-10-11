package backEnd;

public class Vivienda extends Cuenta {
	private int mesesAhorro;
	private float montoMensual;
	
	
	/* Constructor */

	public Vivienda(String codigo, float saldo, int mesesApertura, int diaCorteMes, String estado, float interes,
			float comision, int mesesAhorro, float montoMensual) {
		super(codigo, saldo, mesesApertura, diaCorteMes, estado);
		this.mesesAhorro = mesesAhorro;
		this.montoMensual = montoMensual;
	}

	/* Gets and Sets */
	
	public int getMesesAhorro() {
		return mesesAhorro;
	}

	public float getMontoMensual() {
		return montoMensual;
	}
	public void setMesesAhorro(int mesesAhorro) {
		this.mesesAhorro = mesesAhorro;
	}
	public void setMontoMensual(float montoMensual) {
		this.montoMensual = montoMensual;
	}

	@Override
	float interes() {
		float cantInteres = 0.0f;
		
		cantInteres = (float) (0.03 * montoMensual * mesesApertura);
		this.setInteres(cantInteres);
		
		return cantInteres;
	}
	
	 

}
