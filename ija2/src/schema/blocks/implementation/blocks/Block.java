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

	}

	public abstract Block.Operation getOperation();

	public abstract void resolve();

	public void createPortIn() {

		PortIn port = new PortIn();
		this.portsIn.add(port);
	}

	public void createPortOut() {

		PortOut port = new PortOut();
		this.portsOut.add(port);
	}

	public boolean setPortValue(int id, Type.type type, double mass, double temp) {

        this.portsIn.get(id).setType(type, mass, temp);
        return true;

	}

	public Type getPortValue(int id) {
		return this.portsIn.get(id).value;
	}
}

