package schema.blocks.implementation.blocks;

import schema.blocks.implementation.type.Type;
import schema.blocks.implementation.ports.PortIn;
import schema.blocks.implementation.ports.PortOut;
import schema.blocks.implementation.type.Alcohol;
import schema.blocks.implementation.type.Energy;
import schema.blocks.implementation.type.Water;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Block implements Serializable {

	protected int id;

	public List<PortIn> portsIn = new ArrayList<PortIn>();
	public List<PortOut> portsOut = new ArrayList<PortOut>();
	public int maxInPorts;
	public int maxOutPorts;
	protected boolean resolved;

	/**
	 * Types of blocks
	 */
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
				case MKICE:   return "i";
				case MKLIQUID:   return "l";
				case MKGASS:   return "g";
			}

			throw new AssertionError("Unknown type: " + this);
		}

	}

	/**
	 * Constructor of block, setting number of ports
	 * @param op operation that the block implements
	 * @param id id of block
	 */

	protected Block(Block.Operation op, int id) {
		this.id = id;
	    this.resolved = false;
		switch (op) {
			case WARM:
			case FREEZE:
				this.maxInPorts = 2;
				this.maxOutPorts = 1;
				break;
			case MKICE:
			case MKGASS:
			case MKLIQUID:
				this.maxInPorts = 1;
				this.maxOutPorts = 2;
				break;
		}

        for (int i = 0; i < this.maxInPorts; i++) {
            this.createPortIn(i);
        }

        for (int i = 0; i < this.maxOutPorts; i++) {
            this.createPortOut(i);
        }

        if (this.maxOutPorts == 1) {

		}

	}

	/**
	 * Return the operation that the block implements
	 * @return operation
	 */
	public abstract Block.Operation getOperation();

	/**
	 * Calculate a result for outputs
	 * @param material material for operation
	 * @param energy energy for operation
	 */
	public abstract void calculate(Type material, Type energy);

	/**
	 * Create input port
	 * @param id id of port
	 */
	public void createPortIn(int id) {

		PortIn port = new PortIn(this, id);
		this.portsIn.add(port);
	}
	/**
	 * Create output port
	 * @param id id of port
	 */
	public void createPortOut(int id) {
		PortOut port = new PortOut(this, id);
		this.portsOut.add(port);
	}

	/**
	 * Set type of input port
	 * @param inPortId id of port
	 * @param type type to be set
	 * @return successful of setting
	 */
	public boolean setPortInType(int inPortId, Type.type type) {
        Type value;
	    switch (type) {
            case WATER: {
                value = new Water(0, 0);
                break;
            }
            case ALCOHOL: {
                value = new Alcohol(0, 0);
                break;
            }
            case ENERGY: {
                value = new Energy(0, 0);
                break;
            }
            default:  {
                value = new Energy(0, 0);
                break;
            }
        }
        if (controlTypes(inPortId, value)){
			this.portsIn.get(inPortId).setType(value);
			return true;
		} else {
	    	return false;
		}
	}

	/**
	 * Control if ports have different types
	 * @param id id of port to e set
	 * @param value value to be set
	 * @return successful of setting
	 */
	public boolean controlTypes(int id, Type value) {
		for (int i = 0; i < maxInPorts; i++) {
			if (i != id & (this.portsIn.get(i).isMaterial() == value.isMaterial())) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Set port mass and temperature
	 * @param inPortId id of port
	 * @param mass mass
	 * @param temp temperature
	 */
	public void setPortInValue(int inPortId, double mass, double temp) {
		this.portsIn.get(inPortId).value.setValues(mass, temp);
	}

	/**
	 * Set type and value of output port if type is compatible
	 * @param outPortId id of port
	 * @param type type and values to be set
	 * @return successful of setting
	 */
	public boolean setPortOutValue(int outPortId, Type type) {
	    System.out.println("In setPortOutValue " + outPortId);
	    PortOut port = this.portsOut.get(outPortId);
        port.setType(type);
        if (!port.isFree()) {
            if (port.in.getBlock().setPortInType(port.in.getId(), type.getType())) {
                port.in.getBlock().setPortInValue(port.in.getId(), type.getMass(), type.getTemp());
                return true;
            } else {
                return false;
            }
        } else {
	        return true;
        }
    }

	/**
	 * Calculate output value
	 */
	public void resolve() {
	    this.resolved = true;
	    Type material = null;
	    Type energy = null;
	    for (PortIn port : this.portsIn) {
	        if (port.value.isMaterial() == 1) {
	            material = port.value;
            } else {
                energy = port.value;
            }
        }
	    this.calculate(material, energy);
    }

	/**
	 * Return id of block
	 * @return id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Control if all input ports have values
	 * @return if block is full of values
	 */
	public boolean isFull() {
	    for (PortIn port : this.portsIn) {
	        if (!port.hasValue()) return false;
        }
        return true;
    }

	/**
	 * Control if block need more values to be resolved
	 * @return if block has not enough values
	 */
    public boolean isEmpty() {
	    boolean empty = false;
	    for (PortIn port : portsIn) {
	        if (!port.hasValue()) empty = true;
        }
        return empty;
    }

	/**
	 * Return if block is already resolved
	 * @return resolved
	 */
    public boolean isResolved() {
        return resolved;
    }
}

