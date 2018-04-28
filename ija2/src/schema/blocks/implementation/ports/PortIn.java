package schema.blocks.implementation.ports;

public class PortIn extends Port {
    public PortOut out;

    public PortIn() {
        super();
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
