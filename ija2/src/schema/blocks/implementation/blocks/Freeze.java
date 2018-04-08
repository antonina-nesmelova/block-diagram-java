package schema.blocks.implementation.blocks;

public class Freeze extends Block{
    public Freeze(int id) {
        super();
        this.id = id;
        this.createPort();
        this.createPort();
    }

    public void resolve() { }/* TODO
        double delta = this.energy_in.joule / (this.material_in.thermal_c * this.material_in.kg);
        if(delta*(-1) > this.material_in.t) {
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

        this.material_out = this.material_in;
        this.material_out = this.material_in;

        this.material_out.t = this.material_in.t + delta;
    }
*/
    public Block.Operation getOperation() {
        return Operation.FREEZE;
    }
}
