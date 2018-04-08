package schema.blocks;

import schema.blocks.implementation.ports.PortIn;
import schema.blocks.implementation.ports.PortOut;

public abstract class Block {

	public int id;
	
	/*public AbstractMaterial material_in;
	public AbstractMaterial material_out;
	
	public Energy energy_in;
	public Energy energy_out;

	public int is_free_m_in;
	public boolean is_free_m_out;
	public int is_free_e_in;
	public boolean is_free_e_out;*/

	public PortIn pIn1;
	public PortIn pIn2;
	public PortOut pOut1;
	public PortOut pOut2;

	protected Block() {
		/*this.is_free_m_in = -1;
		this.is_free_e_out = true;
		this.is_free_m_out = true;
		this.is_free_e_in = -1;*/
		pIn1 = new PortIn();
		pIn2 = new PortIn();
		pOut1 = new PortOut();
		pOut2 = new PortOut();
	}

	public enum Operation {
		WARM,
		FREEZE,
		MKICE,
		MKLIQUID,
		MKGASS;

		@Override
		public String toString() {
			switch (this) {
				case WARM:    return "w";
				case FREEZE: return "f";
				case MKICE:   return "-";
				case MKLIQUID:   return "*";
				case MKGASS:   return "/";
			}

			throw new AssertionError("Unknown type: " + this);
		}
	}

	public abstract Block.Operation getOperation();
	
	//int getOperation();
	public abstract void resolve();
	//boolean addBlock();
}
