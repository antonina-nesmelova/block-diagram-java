package schema.blocks.implementation.ports;

import schema.blocks.implementation.blocks.Block;

public class PortIn extends Port {
    public PortOut out;

    public PortIn(Block block, int portId) {
        super(block, portId);
        this.out = null;
    }

    public boolean connect(PortOut out) {
        if (this.isFree()) {
            this.setFree(false);
            this.out = out;
            return true;
        } else {
            return false;
        }
    }
}
