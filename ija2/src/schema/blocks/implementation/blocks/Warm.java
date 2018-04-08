package schema.blocks.implementation.blocks;

public class Warm extends Block {
	
	public Warm(int id) {
		super();
		this.id = id;
		this.createPort();
		this.createPort();
	}

	public void resolve() {  }
	
	/*public void resolve() {
		double delta = this.energy_in.joule / (this.material_in.thermal_c * this.material_in.kg);
		if(delta > this.material_in.t) {
			double Q = this.material_in.thermal_c * this.material_in.kg * this.material_in.t;
			
			if (Q == this.material_in.melt_const * this.material_in.kg) {	//Q=lambda*m
				this.material_out.t = 0;
				this.material_out.state = "liquid";
				return;
			}
			else if (Q > this.material_in.melt_const * this.material_in.kg) {
				Q = Q - this.material_in.melt_const * this.material_in.kg;
				delta = Q / (this.material_in.thermal_c * this.material_in.kg);
				this.material_out.t = delta;
				this.material_out.state = "liquid";
				return;
			}
			else {
				this.material_out.t = 0;
				return;
			}
		}
		
		this.material_out.kg = this.material_in.kg;
		this.material_out.thermal_c = this.material_in.thermal_c;
		
		this.material_out.t = this.material_in.t + delta;
	}*/
	
	public Block.Operation getOperation() {
		return Operation.WARM;
	}
	
}
