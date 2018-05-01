package schema.blocks.implementation.type;

public class Energy implements Type {
	public double joule;
	
	public Energy(double mass, double temp) {
		setJoule(mass);
	}

	@Override
	public int isMaterial() {
		return 2;
	}

	public type getType() {
		return type.ENERGY;
	}

	public void setJoule(double joule) {
		this.joule = joule;
	}

	@Override
	public double getJoule() { return this.joule; }

	@Override
	public double getMass() {
		return 0;
	}

	@Override
	public double getTemp() {
		return 0;
	}
	@Override
	public void setMass(double mass) {
		return;
	}

	@Override
	public void setTemp(double temp) {
		return;
	}

	public void setValues(double mass, double temp) {
		this.setJoule(mass);
		return;}

	public double getFreezeTemp() {
		return 0;
	}

	public double getGasTemp() {
		return 0;
	}

	public double getThermalConst() {
		return 0;
	}

	public double getFusionConst() {
		return 0;
	}

	public double getVaporisationConst() {
		return 0;
	}

	public AbstractMaterial.State getState() {return null;}

	@Override
	public void setState(AbstractMaterial.State state) {

	}
}
