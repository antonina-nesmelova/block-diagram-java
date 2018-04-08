package schema.blocks.implementation.type;

import schema.blocks.AbstractMaterial;

public class Water extends AbstractMaterial{
	public Water(double masse, double t) {
		this.masse = masse;
		this.t = t;
		this.thermal_c = 4220;
	}
}
