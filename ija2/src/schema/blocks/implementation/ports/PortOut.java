package schema.blocks.implementation.ports;

public class PortOut extends Port {
    public PortIn in;

    public PortOut() {
        super();
        this.in = null;
    }

    public boolean connect(PortIn in) {
        if (this.free) {
            this.free = false;
            this.in = in;
            return true;
        } else {
            return false;
        }
    }
}
