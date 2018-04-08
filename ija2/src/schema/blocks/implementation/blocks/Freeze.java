package schema.blocks.implementation.blocks;

import schema.blocks.implementation.type.AbstractMaterial;
import schema.blocks.implementation.type.Energy;

public class Freeze extends Block {
    public Freeze(int id) {
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
    	
        double delta = this.portsIn.joule / (this.portsIn.thermal_c * this.portsIn.kg);
        if(delta*(-1) > this.portsIn.t) {
            double Q = this.portsIn.thermal_c * this.portsIn.kg * this.portsIn.t;
            if (Q == this.portsIn.melt_const * this.portsIn.kg) {	//Q=lambda*m
                this.portsIn.t = 0;
                this.portsIn.state = "liquid";
                return;
            }
            else if (Q > this.portsIn.melt_const * this.portsIn.kg) {
                Q = Q - this.portsIn.melt_const * this.portsIn.kg;
                delta = Q / (this.portsIn.hermal_c * this.portsIn.kg);
                this.portsIn.t = delta;
                this.portsIn.state = "liquid";
                return;
            }
            else {
                this.portsOut.t = 0;
                return;
            }
        }
        this.portsOut = this.portsIn;
        this.portsOut = this.portsIn;
        this.portsOut.t = this.portsIn.t + delta;
    }

    public Block.Operation getOperation() {
        return Operation.FREEZE;
    }
}
