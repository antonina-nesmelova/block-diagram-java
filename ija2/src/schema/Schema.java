package schema;

import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.*;

import schema.blocks.implementation.blocks.*;
import schema.blocks.implementation.type.Type;
import schema.blocks.implementation.ports.PortIn;
import schema.blocks.implementation.ports.PortOut;

import javax.swing.event.SwingPropertyChangeSupport;

public class Schema implements Serializable {

    //private SwingPropertyChangeSupport propChange;

	public List<Block> blocks = new ArrayList<Block>();
	public int number;

	public Schema() {
	    //propChange = new SwingPropertyChangeSupport(this);
        this.number = 0;
	}

	/*public void addListener(PropertyChangeListener prop) {
	    propChange.addPropertyChangeListener(prop);
    }*/
	
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
			case MKICE: {
				b = new MakeIce(number);
				blocks.add(b);
				break;
			}
			case MKLIQUID: {
				b = new MakeLiquid(number);
				blocks.add(b);
				break;
			}
			case MKGASS: {
				b = new MakeGas(number);
				blocks.add(b);
				break;
			}
			default: {
				b = new Warm(number);
				blocks.add(b);
				break;
			}
		}
		this.number += 1;
		System.out.println("Block created " + b.getId());
		return b;
	}
	
	public boolean setPortValue(Block block, Type.type type, int pId, double mass, double temp) {
		if(block.setPortInType(pId, type)) {
			block.setPortInValue(pId, mass, temp);
			return true;
		}
		return false;
	}

	public boolean createRelation(PortIn in, PortOut out) {
		if (!findLoop(out.getBlock().getId(), in.getBlock().getId())) {
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
				else if (findLoop(out, outPort.in.getBlock().getId())) return true;
			}
		}
		return false;
	}

	public boolean resolveSchema() {
	    boolean finish = true;
	    for (Block block : this.blocks) {
	        if (!block.isResolved()) {
                if (block.isFull()) {
                    block.resolve();
                } else if (!block.isEmpty()){
                    finish = false;
                }
            }
        }
        if(finish) return true;
	    else return resolveSchema();
    }

    public boolean stepOfResolve() {
		boolean finish = true;
		for (Block block : this.blocks) {
			if (block.isResolved() | block.isEmpty()) {
				continue;
			} else if (block.isFull()) {
				block.resolve();
				finish = false;
				return finish;
			}
		}
		return finish;
	}

    public void removeBlock(int id) {
        boolean removed = this.blocks.removeIf(block -> (block.getId() == id));
        if (removed) System.out.println("Removed block " + id);
	}
}
