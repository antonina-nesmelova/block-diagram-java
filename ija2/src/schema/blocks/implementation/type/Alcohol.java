package schema.blocks.implementation.type;

public class Alcohol extends AbstractMaterial {
	public Alcohol(double mass, double temp) {
		super();
		this.gas_t = 78.33;
		this.freeze_t = -114.1;
		this.thermal_const = 2500;
		this.vaporisation_const = 840000;
		this.fusion_const = 105000;
		this.setJoule(mass);
	}

	public type getType() {
		return type.ALCOHOL;
	}
}
