package schema.blocks.implementation.ports;

public class PortIn extends Port {
    public PortOut out;

    public PortIn(int blockId) {
        super(blockId);
        this.out = null;
    }

    public boolean connect(PortOut out) {
        if (this.free) {
            this.free = false;
            this.out = out;
            return true;
        } else {
            return false;
        }
    }
}
