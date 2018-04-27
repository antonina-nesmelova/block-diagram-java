package schema.blocks.implementation.blocks;

import schema.blocks.Type;
import schema.blocks.implementation.ports.PortIn;
import schema.blocks.implementation.ports.PortOut;

import java.util.ArrayList;
import java.util.List;

public abstract class Block {

	public int id;

	public List<PortIn> portsIn = new ArrayList<PortIn>();
	public List<PortOut> portsOut = new ArrayList<PortOut>();
	public int maxInPorts;
    public int maxOutPorts;

	protected Block() {
		this.number = 0;
		for (int i = 0; i < maxInPorts; i++){
			PortIn port = new PortIn();
		}
		PortOut port = new PortOut();
		this.portsOut.add(port);
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

	public abstract void resolve();

	public int createPortIn() {
		if (this.number < 2) {
			PortIn port = new PortIn();
			this.portsIn.add(port);
			this.number += 1;
			return (number-1);
		} else {
			return -1;
		}
	}

    public int createPortOut() {
        if (this.number < 2) {
            PortOut port = new PortOut();
            this.portsOut.add(port);
            this.number += 1;
            return (number-1);
        } else {
            return -1;
        }
    }

	public boolean setPortValue(int id, Type value) {

		if (!portsIn.contains(value)) {
			this.portsIn.get(id).value = value;
			return true;
		} else {
			return false;
		}
	}

	public Type getPortValue(int id) {
		return this.portsIn.get(id).value;
	}
}
