package schema.blocks.implementation.type;

public class Water extends AbstractMaterial{
	public Water(double mass, double temp) {
		super();
		this.freeze_t = 0;
		this.gas_t = 100;
		this.thermal_const = 4220;
		this.vaporisation_const = 2256000;
		this.fusion_const = 330000;
		this.setValues(mass, temp);
		this.setJoule(0);
	}

	public type getType() {
		return type.WATER;
	}
}
