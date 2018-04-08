package schema.blocks;

import schema.blocks.implementation.type.Energy;

public abstract class Block {

	
	public AbstractMaterial material_in;
	public AbstractMaterial material_out;
	
	public Energy energy_in;
	public Energy energy_out;

	public int is_free_m_in;
	public boolean is_free_m_out;
	public int is_free_e_in;
	public boolean is_free_e_out;

	protected Block() {
		this.is_free_m_in = -1;
		this.is_free_e_out = true;
		this.is_free_m_out = true;
		this.is_free_e_in = -1;
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
