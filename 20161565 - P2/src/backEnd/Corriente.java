package backEnd;

public class Corriente extends Cuenta {
	
	private float montoMaxDia;

	/* Constructor */
	
	public Corriente(String codigo, float saldo, int mesesApertura, int diaCorteMes, String estado, float interes,
			float comision, float montoMaxDia) {
		super(codigo, saldo, mesesApertura, diaCorteMes, estado);
		this.montoMaxDia = montoMaxDia;
	}

	
	/* Gets and Sets */

	public float getMontoMaxDia() {
		return montoMaxDia;
	}

	public void setMontoMaxDia(float montoMaxDia) {
		this.montoMaxDia = montoMaxDia;
	}


	@Override
	float interes() {
		
		float cantInteres = 0.0f;
		
		cantInteres = (float) (0.10 * montoMaxDia * mesesApertura);
		this.setInteres(cantInteres);
		
		return cantInteres;
	}
	

	
	
	
	

}
