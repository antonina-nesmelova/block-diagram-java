package schema.blocks.implementation.ports;

import schema.blocks.implementation.blocks.Block;
import schema.blocks.implementation.type.Type;

public class PortIn extends Port {
    public PortOut out;

    /**
     * Initialize of input port
     * @param block block of port
     * @param portId id of port
     */
    public PortIn(Block block, int portId) {
        super(block, portId);
        this.out = null;
    }

    /**
     * Create connection with output port, control if types are compatible and if port is not already connected
     * @param out output port
     * @return true if connecting was successful
     */
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
