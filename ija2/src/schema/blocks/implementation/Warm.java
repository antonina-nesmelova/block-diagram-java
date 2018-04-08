package schema.blocks.implementation;
import schema.blocks.Block;

public class Warm extends Block {
	
	public Warm(int id) {
		super();
		this.id = id;
	}
	
	public void resolve() {
		double delta = this.energy_in.joule / (this.material_in.thermal_c * this.material_in.masse);
		if(delta > this.material_in.t) {
			double Q = this.material_in.thermal_c * this.material_in.masse * this.material_in.t; 
			
			if (Q == this.material_in.melt_const * this.material_in.masse) {	//Q=lambda*m
				this.material_out.t = 0;
				this.material_out.state = "liquid";
				return;
			}
			else if (Q > this.material_in.melt_const * this.material_in.masse) {
				Q = Q - this.material_in.melt_const * this.material_in.masse;
				delta = Q / (this.material_in.thermal_c * this.material_in.masse);
				this.material_out.t = delta;
				this.material_out.state = "liquid";
				return;
			}
			else {
				this.material_out.t = 0;
				return;
			}
		}
		
		this.material_out.masse = this.material_in.masse;
		this.material_out.thermal_c = this.material_in.thermal_c;
		
		this.material_out.t = this.material_in.t + delta;
	}
	
	public Block.Operation getOperation() {
		return this.getOperation();
	}
	
}
