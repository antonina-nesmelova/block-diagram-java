package schema.blocks.implementation.type;

import schema.blocks.Type;

public class Energy implements Type {
	public double joule;
	
	public Energy() {

	}

	public void setJoule(double joule) {
		this.joule = joule;
	}

	@Override
	public boolean equals(Object otherType) {
		if (this == otherType) {
			return true;
		}
		if (otherType instanceof Energy) {
			return true;
		}
		return false;
	}
}
