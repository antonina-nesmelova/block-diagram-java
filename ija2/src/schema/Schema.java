package schema;

import java.util.*;

import schema.blocks.implementation.blocks.Block;
import schema.blocks.Type;
import schema.blocks.implementation.blocks.Freeze;
import schema.blocks.implementation.blocks.Warm;
import schema.blocks.implementation.ports.PortIn;
import schema.blocks.implementation.ports.PortOut;

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
		
		return block.setPortValue(pId, type, mass, temp);
	}

	public boolean createRelation(PortIn in, PortOut out) {
		if (!findLoop(out.getBlock(), in.getBlock())) {
			in.connect(out);
			out.connect(in);
			return true;
		} else return false;
    }

    public boolean findLoop(int out, int in) {
		if (out == in) return true;
		else {
			for (PortOut outPort : this.blocks.get(in).portsOut) {
				if (outPort.isFree()) continue;
				else if (findLoop(out, outPort.getBlock())) return true;
			}
		}
		return false;
	}
}
