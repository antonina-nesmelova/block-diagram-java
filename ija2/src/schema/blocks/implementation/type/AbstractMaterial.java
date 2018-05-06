package schema.blocks.implementation.type;

public abstract class AbstractMaterial extends AbstractType {
	public double kg;
	public double t;
	public AbstractMaterial.State state;
	public double freeze_t;
	public double gas_t;
	public double thermal_const;
	public double vaporisation_const;
	public double fusion_const;

	public double joule;

	/**
	 * Possible states of material
	 */
	public enum State {
		GASS,
		LIQUID,
		ICE;

		@Override
		public String toString() {
			switch (this) {
				case GASS:    return "gass";
				case LIQUID: return "liquid";
				case ICE:   return "ice";
			}

			throw new AssertionError("Unknown type: " + this);
		}
	}

	public AbstractMaterial() {

	}

	/**
	 * Set state of material
	 * @return
	 */
	public void setState(State state) {
		this.state = state;
	}

	/**
	 * That is material - returns 1
	 * @return
	 */
	public int isMaterial() {
		return 1;
	}

	/**
	 * Set mass and temperature of material
	 * @param kg mass
	 * @param t temperature
	 */
	public void setValues(double kg, double t) {
		this.setMass(kg);
		this.setTemp(t);
		this.controlState();
	}
	/**
	 * Set mass of material
	 * @return
	 */
	public void setMass(double kg) {
		this.kg = kg;
	}
	/**
	 * Set temperature of material
	 * @return
	 */
	public void setTemp(double t) {
		this.t = t;
	}
	/**
	 * Set energy that material contains
	 * @return
	 */
	public void setJoule(double joule) { this.joule = joule; }

	/**
	 * Returns mass
	 * @return mass
	 */
	public double getMass() {
		return this.kg;
	}

	/**
	 * Returns temperature
	 * @return temperature
	 */
	public double getTemp() {
		return this.t;
	}

	/**
	 * Returns energy
	 * @return energy
	 */
	public double getJoule() {
		return this.joule;
	}
	/**
	 * Set state of material
	 * @return
	 */
	public AbstractMaterial.State getState() {
		return this.state;
	}

	/**
	 * Change state depends on temperature
	 */
	public void controlState() {
		if (this.t < this.freeze_t)
			this.state = State.ICE;
		else if (this.t < this.gas_t)
			this.state = State.LIQUID;
		else
			this.state = State.GASS;
	}
	/**
	 * Returns temperature between ice and liquid states
	 * @return
	 */
	public double getFreezeTemp() {
		return this.freeze_t;
	}
	/**
	 * Returns temperature between gas and liquid states
	 * @return
	 */
	public double getGasTemp() {
		return gas_t;
	}
	/**
	 * Returns thermal constant of type
	 * @return
	 */
	public double getThermalConst() {
		return this.thermal_const;
	}
	/**
	 * Returns fusion constant of type
	 * @return
	 */
	public double getFusionConst() {
		return this.fusion_const;
	}
	/**
	 * Returns vaporization constant of type
	 * @return
	 */
	public double getVaporisationConst() {
		return this.vaporisation_const;
	}
}
