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

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public int isMaterial() {
		return 1;
	}

	public void setValues(double kg, double t) {
		this.setMass(kg);
		this.setTemp(t);
		this.controlState();
	}

	public void setMass(double kg) {
		this.kg = kg;
	}

	public void setTemp(double t) {
		this.t = t;
	}

	public void setJoule(double joule) { this.joule = joule; }

	@Override
	public double getMass() {
		return this.kg;
	}

	@Override
	public double getTemp() {
		return this.t;
	}

	@Override
	public double getJoule() {
		return this.joule;
	}

	public AbstractMaterial.State getState() {
		return this.state;
	}

	public void controlState() {
		if (this.t < this.freeze_t)
			this.state = State.ICE;
		else if (this.t < this.gas_t)
			this.state = State.LIQUID;
		else
			this.state = State.GASS;
	}

	public double getFreezeTemp() {
		return this.freeze_t;
	}

	public double getGasTemp() {
		return gas_t;
	}

	public double getThermalConst() {
		return this.thermal_const;
	}

	public double getFusionConst() {
		return this.fusion_const;
	}

	public double getVaporisationConst() {
		return this.vaporisation_const;
	}
}
