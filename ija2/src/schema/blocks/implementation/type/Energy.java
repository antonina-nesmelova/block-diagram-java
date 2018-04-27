package schema.blocks.implementation.type;

import schema.blocks.Type;

public class Energy implements Type {
	public double joule;
	
	public Energy(double mass, double temp) {
		setJoule(mass);
	}

	public void setJoule(double joule) {
		this.joule = joule;
	}

	public double getJoule() { return this.joule; }

}
