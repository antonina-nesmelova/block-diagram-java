package schema.blocks.implementation.ports;

import schema.blocks.implementation.blocks.Block;
import schema.blocks.implementation.type.Type;

public class PortOut extends Port {
    public PortIn in;

    /**
     * Initialize of output port
     * @param block block of port
     * @param portId id of port
     */
    public PortOut(Block block, int portId) {
        super(block, portId);
        this.in = null;
    }
    /**
     * Create connection with output port, control if port is not already connected
     * @param in input port
     * @return true if connecting was successful
     */
    public boolean connect(PortIn in) {
        if (this.isFree()) {
            this.setFree(false);
            this.in = in;
            return true;
        } else {
            return false;
        }
    }
}
