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

	public List<Block> blocks = new ArrayList<Block>();
	public int number;

	/**
	 * Constructor of schema with logic blocks, initializing number of blocks to zero
	 */
	public Schema() {
        this.number = 0;
	}

	/**
	 * Create a block of some type
	 * @param type type of block
	 * @return block
	 */
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

	/**
	 * Set type and value of input port
	 * @param block the block containing input port
	 * @param type type to be set
	 * @param pId id of input port
	 * @param mass mass to be set
	 * @param temp temperature to be set
	 * @return if setting was successful
	 */
	public boolean setPortValue(Block block, Type.type type, int pId, double mass, double temp) {
		if(block.setPortInType(pId, type)) {
			block.setPortInValue(pId, mass, temp);
			return true;
		}
		return false;
	}

	/**
	 * Create connection between ports
	 * @param in input port
	 * @param out output port
	 * @return if connecting was successful
	 */
	public boolean createRelation(PortIn in, PortOut out) {
		if (!findLoop(out.getBlock().getId(), in.getBlock().getId())) {
            in.connect(out);
            out.connect(in);
            return true;
		} else return false;
    }

	/**
	 * Finding loop while connecting ports
	 * @param out output port
	 * @param in input port
	 * @return if loop was find
	 */

    public boolean findLoop(int out, int in) {
		if (out == in) return true;
		else {
			for (Block block : blocks) {
				if (block.getId() == in) {
					for (PortOut outPort : block.portsOut) {
						if (outPort.isFree()) continue;
						else if (findLoop(out, outPort.in.getBlock().getId())) return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Calculate all output values in schema if it is possible
	 * @return true
	 */

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

	/**
	 * Calculate the output of one block
	 * @return block that was resolved
	 */

	public Block stepOfResolve() {
		//boolean finish = true;
		for (Block block : this.blocks) {
			if (block.isResolved() | block.isEmpty()) {
				continue;
			} else if (block.isFull()) {
				block.resolve();
				//finish = false;
				return block;
			}
		}
		return null;
	}

	/**
	 * Delete a block from schema
	 * @param id id of block
	 */

    public void removeBlock(int id) {
        boolean removed = this.blocks.removeIf(block -> (block.getId() == id));
        if (removed) System.out.println("Removed block " + id);
	}

	public Block getBlock(int id) {
    	for (Block block : blocks) {
    		if (block.getId() == id) {
    			return block;
			}
		}
		return null;
	}
}
