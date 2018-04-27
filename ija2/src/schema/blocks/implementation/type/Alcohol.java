package schema.blocks.implementation.type;

public class Alcohol extends AbstractMaterial {
	public Alcohol(double mass, double temp) {
		super(mass, temp);
		this.thermal_c = 2500;
	}
}
