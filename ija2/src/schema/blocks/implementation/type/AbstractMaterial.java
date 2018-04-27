package schema.blocks.implementation.type;

import schema.blocks.Material;
import schema.blocks.Type;

public abstract class AbstractMaterial implements Material {
	public double kg;
	public double t;
	public AbstractMaterial.State state;
	public double thermal_c;
	public double freeze_t;
	public double gass_t;
	public double gass_const;
	public double melt_const;

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

	public AbstractMaterial(double mass, double temp) {
		setValues(mass, temp);
	}

	public void setValues(double kg, double t) {
		this.setMass(kg);
		this.setTemp(t);
	}

	public void setMass(double kg) {
		this.kg = kg;
	}

	public void setTemp(double t) {
		this.t = t;
		this.controlState();
	}

	public double getMass() {
		return this.kg;
	}

	public double getTemp() {
		return this.t;
	}

	public AbstractMaterial.State getState() {
		return this.state;
	}

	public void controlState() {
		if (this.t < this.freeze_t)
			this.state = State.ICE;
		else if (this.t < this.gass_t)
			this.state = State.LIQUID;
		else
			this.state = State.GASS;
	}
}
