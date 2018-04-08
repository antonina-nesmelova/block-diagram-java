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
	public int number;

	protected Block() {
		this.number = 0;
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

	public int createPort() {
		if (this.number < 2) {
			PortIn port = new PortIn();
			this.portsIn.add(port);
			this.number++;
			return (number-1);
		} else {
			return -1;
		}
	}

	public boolean setPortValue(int id, Type value) {
		if (id == 0 || id == 1) {
			if (id == 0 && !this.portsIn.get(1).value.equals(value)) {
				this.portsIn.get(id).value = value;
				return true;
			} else if (id == 1 && !this.portsIn.get(0).value.equals(value)) {
				this.portsIn.get(id).value = value;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
