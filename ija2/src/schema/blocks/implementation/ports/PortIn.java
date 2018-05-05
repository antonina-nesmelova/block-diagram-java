package schema.blocks.implementation.ports;

import schema.blocks.implementation.blocks.Block;
import schema.blocks.implementation.type.Type;

public class PortIn extends Port {
    public PortOut out;

    public PortIn(Block block, int portId) {
        super(block, portId);
        this.out = null;
    }

    public boolean connect(PortOut out) {
        if (this.isFree() & getBlock().controlTypes(getId(), out.value)) {
            this.setFree(false);
            this.out = out;
            return true;
        } else {
            return false;
        }
    }
}
