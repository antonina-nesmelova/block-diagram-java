package schema.blocks.implementation.type;

import schema.blocks.AbstractMaterial;

public class Alkohol extends AbstractMaterial {
	public Alkohol(double masse, double t) {
		this.masse = masse;
		this.t = t;
		this.thermal_c = 2500;
	}
}
