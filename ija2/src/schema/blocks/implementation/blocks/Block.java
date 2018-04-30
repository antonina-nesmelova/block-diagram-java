package schema.blocks.implementation.blocks;

import schema.blocks.implementation.type.Type;
import schema.blocks.implementation.ports.PortIn;
import schema.blocks.implementation.ports.PortOut;
import schema.blocks.implementation.type.Alcohol;
import schema.blocks.implementation.type.Energy;
import schema.blocks.implementation.type.Water;

import java.util.ArrayList;
import java.util.List;

public abstract class Block {

	protected int id;

	public List<PortIn> portsIn = new ArrayList<PortIn>();
	public List<PortOut> portsOut = new ArrayList<PortOut>();
	public int maxInPorts;
	public int maxOutPorts;
	protected boolean resolved;

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

	protected Block(Block.Operation op) {
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
            this.createPortIn();
        }

        for (int i = 0; i < this.maxOutPorts; i++) {
            this.createPortOut();
        }

	}

	public abstract Block.Operation getOperation();

	public abstract Type calculate(Type material, Type energy);

	public void createPortIn() {

		PortIn port = new PortIn(this.id);
		this.portsIn.add(port);
	}

	public void createPortOut() {

		PortOut port = new PortOut(this.id);
		this.portsOut.add(port);
	}

	public boolean setPortInValue(int inPortId, Type.type type, double mass, double temp) {
        Type value;
	    switch (type) {
            case WATER: {
                value = new Water(mass, temp);
                break;
            }
            case ALCOHOL: {
                value = new Alcohol(mass, temp);
                break;
            }
            case ENERGY: {
                value = new Energy(mass, temp);
                break;
            }
            default:  {
                value = new Energy(mass, temp);
                break;
            }
        }
        // control if ports have different types
	    for (int i = 0; i < maxInPorts; i++) {
            if (i != inPortId & (this.portsIn.get(i).value.isMaterial() == value.isMaterial())) {
                return false;
            }
        }
	    this.portsIn.get(inPortId).setType(value);
        return true;
	}

	public boolean resolve() {
	    this.resolved = true;
	    Type material = null;
	    Type energy = null;
	    for (PortIn port : this.portsIn) {
	        if (port.value.isMaterial()) {
	            material = port.value;
            } else {
                energy = port.value;
            }
        }
	    this.calculate(material, energy);
	    return true;
    }

	public Type getPortValue(int portId) {
		return this.portsIn.get(portId).value;
	}

	public int getId() {
		return this.id;
	}

	public boolean isFull() {
	    for (PortIn port : this.portsIn) {
	        if (!port.hasValue()) return false;
        }
        return true;
    }

    public boolean isEmpty() {
	    boolean empty = false;
	    for (PortIn port : portsIn) {
	        if (port.isFree()) empty = true;
        }
        return empty;
    }

    public boolean isResolved() {
        return resolved;
    }
}

