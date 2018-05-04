package schema.blocks.implementation.ports;

import schema.blocks.implementation.blocks.Block;
import schema.blocks.implementation.type.Type;

public class PortOut extends Port {
    public PortIn in;

    public PortOut(Block block, int portId) {
        super(block, portId);
        this.in = null;
    }

    public boolean connect(PortIn in) {
        if (this.isFree()) {
            this.setFree(false);
            this.in = in;
            return true;
        } else {
            return false;
        }
    }

    @Override

    public void setType(Type value) {
        this.value = value;
        this.type = this.value.getType();
    }
}
