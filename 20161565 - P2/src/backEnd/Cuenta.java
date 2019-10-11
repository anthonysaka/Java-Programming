package backEnd;

public abstract class Cuenta {
	
	protected String codigo;
	protected float saldo;
	protected int mesesApertura;
	protected int diaCorteMes;
	protected String estado;
	protected float interes;
	protected float comision;
	
	/* Constructor */
	public Cuenta(String codigo, float saldo, int mesesApertura, int diaCorteMes, String estado) {
		super();
		this.codigo = codigo;
		this.saldo = saldo;
		this.mesesApertura = mesesApertura;
		this.diaCorteMes = diaCorteMes;
		this.estado = estado;
		this.comision = (float) (3.00 * mesesApertura);
	}
	
	/* Gets and Sets */

	public String getCodigo() {
		return codigo;
	}

	public float getSaldo() {
		return saldo;
	}

	public int getMesesApertura() {
		return mesesApertura;
	}

	public int getDiaCorteMes() {
		return diaCorteMes;
	}

	public String getEstado() {
		return estado;
	}

	public float getInteres() {
		return interes;
	}

	public float getComision() {
		return comision;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public void setMesesApertura(int mesesApertura) {
		this.mesesApertura = mesesApertura;
	}

	public void setDiaCorteMes(int diaCorteMes) {
		this.diaCorteMes = diaCorteMes;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setInteres(float interes) {
		this.interes = interes;
	}

	public void setComision(float comision) {
		this.comision = comision;
	}
	
	
	/* Metodos */
	
	abstract float interes();
	
	


	
	
	

}
