package schema.blocks.implementation.ports;

public class PortIn extends Port {
    public PortOut out;

    public PortIn(int blockId, int portId) {
        super(blockId, portId);
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
