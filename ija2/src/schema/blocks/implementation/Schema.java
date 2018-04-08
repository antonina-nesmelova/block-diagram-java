package schema.blocks.implementation;

import java.util.*;

import schema.blocks.AbstractMaterial;
import schema.blocks.Block;
import schema.blocks.Type;
import schema.blocks.implementation.type.Energy;

public class Schema {
	
	//public List<Block> blocks = new ArrayList();
	public List<Block> blocks = new ArrayList<Block>();
	public int number;
	
	public int createBlock(String type) {
		
		Block b;
		switch (type) {
			case "warm": {
				b = new Warm(number);
				blocks.add(b);
				break;
			}
			case "freeze": {
				break;
			}
			default: break;
		}
		return number;
	}
	
	public boolean setMaterial(int blockId, AbstractMaterial material) {
		Block bl = this.blocks.get(blockId);
		bl.material_in = material;
		return true;
	}
	
	public void setEnergy(int blockId, Energy energy) {
		Block bl = this.blocks.get(blockId);
		bl.energy_in = energy;
	}
	
	public Type getValue(int blockId, boolean in, boolean material) {
		if (in) {
			if (material) return this.blocks.get(blockId).material_in;
			else return this.blocks.get(blockId).energy_in;
		} else {
			if (material) return this.blocks.get(blockId).material_out;
			else return this.blocks.get(blockId).energy_out;
		}
	}
	
	public void makeRelation(int idIn, int idOut, boolean material) {
		if (material) {
			if ((this.blocks.get(idIn).is_free_m_in < 0) && this.blocks.get(idOut).is_free_m_out) {
				this.blocks.get(idOut).is_free_m_out) = false;
				this.blocks.get(idIn).is_free_m_in = idOut;
			}
		} else {
			if ((this.blocks.get(idIn).is_free_e_in < 0) && this.blocks.get(idOut).is_free_e_out) {
				this.blocks.get(idOut).is_free_e_out) = false;
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
	}
}
