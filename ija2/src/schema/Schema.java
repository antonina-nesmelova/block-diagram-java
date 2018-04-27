package schema;

import java.util.*;

import schema.blocks.implementation.blocks.Block;
import schema.blocks.Type;
import schema.blocks.implementation.blocks.Freeze;
import schema.blocks.implementation.blocks.Warm;

//import static schema.blocks.Type.type.WATER;

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
	
	public boolean setPortValue(Block block, Type.type type, int pId, double mass, double temp) {
		
		return block.setPortValue(pId, type);
	}
}
