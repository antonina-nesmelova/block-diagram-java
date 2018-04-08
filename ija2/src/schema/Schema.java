package schema;

import java.util.*;

import schema.blocks.Block;
import schema.blocks.Type;
import schema.blocks.implementation.blocks.Freeze;
import schema.blocks.implementation.blocks.Warm;
import schema.blocks.implementation.type.Energy;

public class Schema {
	
	//public List<Block> blocks = new ArrayList();
	public List<Block> blocks = new ArrayList<Block>();
	public int number;

	public Schema() {

	}
	
	public Block createBlock(Block.Operation type) {
		
		Block b;
		switch (type) {
			case WARM: {
				b = new Warm(number);
				blocks.add(b);
				break;
			}
			case FREEZE: {
				b = new Freeze(number);
				blocks.add(b);
				break;
			}
			default: {
				b = new Warm(number);
				blocks.add(b);
				break;
			}
		}
		return b;
	}
	
	public boolean setPortType(Block block, Type type, int pId) { /* TODO */
		if ((block instanceof Warm || block instanceof Freeze)) //prvni ports techto bloku je typu Energy
			/* ... */
		else {
		/* ... */
		}
	}
	
	/*public Type getValue(int blockId, boolean in, boolean material) {
		if (in) {
			if (material) return this.blocks.get(blockId).material_in;
			else return this.blocks.get(blockId).energy_in;
		} else {
			if (material) return this.blocks.get(blockId).material_out;
			else return this.blocks.get(blockId).energy_out;
		}
	}
	
	public void makeRelation(Type in, Type free_out, int idIn, int idOut) {
		if (in instanceof AbstractMaterial && free_out instanceof AbstractMaterial) {
			if ((this.blocks.get(idIn).is_free_m_in < 0) && this.blocks.get(idOut).is_free_m_out) {
				this.blocks.get(idOut).is_free_m_out = false;
				this.blocks.get(idIn).is_free_m_in = idOut;
			}
		} else {
			if ((this.blocks.get(idIn).is_free_e_in < 0) && this.blocks.get(idOut).is_free_e_out) {
				this.blocks.get(idOut).is_free_e_out = false;
				this.blocks.get(idIn).is_free_e_in = idOut;
			}
		}
	}

	public void deleteRelation(int idIn, boolean material) {
		if (material) {
			this.blocks.get(this.blocks.get(idIn).is_free_m_in).is_free_m_out = true;
			this.blocks.get(idIn).is_free_m_in = -1;
		} else {
			this.blocks.get(this.blocks.get(idIn).is_free_e_in).is_free_e_out = true;
			this.blocks.get(idIn).is_free_e_in = -1;
		}
	}*/
}
