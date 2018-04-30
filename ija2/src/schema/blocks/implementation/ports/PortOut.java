package schema.blocks.implementation.ports;

public class PortOut extends Port {
    public PortIn in;

    public PortOut(int blockId, int portId) {
        super(blockId, portId);
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
}
