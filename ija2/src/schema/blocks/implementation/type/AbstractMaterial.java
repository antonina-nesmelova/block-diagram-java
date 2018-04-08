package schema.blocks.implementation.type;

import schema.blocks.Material;
import schema.blocks.Type;

public abstract class AbstractMaterial implements Material {
	public double kg;
	public double t;
	public String state;
	public double thermal_c;
	public double freeze_t;
	public double gass_t;
	public double gass_const;
	public double melt_const;

	public AbstractMaterial() {

	}

	public void setValues(double kg, double t) {
		this.kg = kg;
		this.t = t;
	}

	@Override
	public boolean equals(Object otherType) {
		if (this == otherType) {
			return true;
		}
		if (otherType instanceof AbstractMaterial) {
			return true;
		}
		return false;
	}
}
