package schema.blocks.implementation.type;

public class Energy extends AbstractType {
	public double joule;

	/**
	 * Initialize energy, set joules from mass
	 * @param mass set as joules
	 * @param temp ignored
	 */
	public Energy(double mass, double temp) {
		setJoule(mass);
	}

	/**
	 * Energy is not material - returns 2
	 * @return
	 */
	public int isMaterial() {
		return 2;
	}
	/**
	 * Returnes type energy
	 * @return
	 */
	public type getType() {
		return type.ENERGY;
	}
	/**
	 * Returns joules
	 * @return joules
	 */
	public void setJoule(double joule) {
		this.joule = joule;
	}

	/**
	 * Set joules
	 * @return joules
	 */
	public double getJoule() { return this.joule; }

	@Override
	public double getMass() {
		return 0;
	}

	@Override
	public double getTemp() {
		return 0;
	}
	@Override
	public void setMass(double mass) {
		return;
	}

	@Override
	public void setTemp(double temp) {
		return;
	}

	/**
	 * Set joules from mass
	 * @param mass set as joules
	 * @param temp ignored
	 */
	public void setValues(double mass, double temp) {
		this.setJoule(mass);
		return;}

	public double getFreezeTemp() {
		return 0;
	}

	public double getGasTemp() {
		return 0;
	}

	public double getThermalConst() {
		return 0;
	}

	public double getFusionConst() {
		return 0;
	}

	public double getVaporisationConst() {
		return 0;
	}

	public AbstractMaterial.State getState() {return null;}

	@Override
	public void setState(AbstractMaterial.State state) {

	}
}
