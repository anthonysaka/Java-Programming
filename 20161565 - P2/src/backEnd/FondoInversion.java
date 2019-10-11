package backEnd;

public class FondoInversion extends Cuenta {
	private float interesFijo;
	private float montoInversion;
	
	/* Constructor */
	
	public FondoInversion(String codigo, float saldo, int mesesApertura, int diaCorteMes, String estado, float interes,
			float comision, float interesFijo, float montoInversion) {
		super(codigo, saldo, mesesApertura, diaCorteMes, estado);
		this.interesFijo = interesFijo;
		this.montoInversion = montoInversion;
	}
	
	/* Gets and Sets */
	
	public float getInteresFijo() {
		return interesFijo;
	}
	public float getMontoInversion() {
		return montoInversion;
	}
	public void setInteresFijo(float interesFijo) {
		this.interesFijo = interesFijo;
	}
	public void setMontoInversion(float montoInversion) {
		this.montoInversion = montoInversion;
	}

	@Override
	float interes() {
		float cantInteres = 0.0f;
		
		cantInteres = (float) (interesFijo * montoInversion * mesesApertura);
		this.setInteres(cantInteres);
		
		return cantInteres;
	}
	
	

}
