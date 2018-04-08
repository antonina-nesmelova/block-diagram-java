package schema.blocks.implementation.blocks;

import schema.blocks.implementation.type.AbstractMaterial;
import schema.blocks.implementation.type.Energy;

public class Warm extends Block {
	
	public Warm(int id) {
		super();
		this.id = id;
		this.createPort();
		this.createPort();
	}
	
	public void resolve() { 

    	if (this.portsIn.get(0).value instanceof Energy) {
    		this.portsIn.get(0).value = Energy.setJoule();
    	}	
			
		else if (this.portsIn.get(0).value instanceof AbstractMaterial) {
			this.portsIn.get(0).value = AbstractMaterial.setValues();
		}
    	
    	double delta = this.portsIn.joule / (this.portsIn.AbstractMaterial.thermal_c * this.portsIn.AbstractMaterial.kg);
		if(delta > this.portsIn.AbstractMaterial.t) {
			double Q = this.portsIn.AbstractMaterial.thermal_c * this.portsIn.AbstractMaterial.kg * this.portsIn.AbstractMaterial.t;
			
			if (Q == this.portsIn.AbstractMaterial.melt_const * this.portsIn.AbstractMaterial.kg) {	//Q=lambda*m
				this.portsOut.AbstractMaterial.t = 0;
				this.portsOut.AbstractMaterial.state = "liquid";
				return;
			}
			else if (Q > this.portsIn.AbstractMaterial.melt_const * this.portsIn.AbstractMaterial.kg) {
				Q = Q - this.portsIn.AbstractMaterial.melt_const * this.portsIn.AbstractMaterial.kg;
				delta = Q / (this.portsIn.AbstractMaterial.thermal_c * this.portsIn.AbstractMaterial.kg);
				this.portsOut.AbstractMaterial.t = delta;
				this.portsOut.AbstractMaterial.state = "liquid";
				return;
			}
			else {
				this.portsOut.AbstractMaterial.t = 0;
				return;
			}
		}
		
		this.portsOut.AbstractMaterial.kg = this.portsIn.AbstractMaterial.kg;
		this.portsOut.AbstractMaterial.thermal_c = this.portsIn.AbstractMaterial.thermal_c;
		
		this.portsOut.AbstractMaterial.t = this.portsIn.AbstractMaterial.t + delta;
    }
	
	public Block.Operation getOperation() {
		return Operation.WARM;
	}
	
}
