package schema.blocks.implementation.type;

public class Water extends AbstractMaterial{
	public Water(double mass, double temp) {
		super(mass, temp);
		this.thermal_c = 4220;
		this.freeze_t = 0;
		this.gass_t = 100;
	}
}
