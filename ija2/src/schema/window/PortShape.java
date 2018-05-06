package schema.window;

import java.io.Serializable;

public class PortShape implements Serializable {
    public int id;
    public int blockId;
    public boolean clicked;
    public boolean in;

    public PortShape(int blockId, int id, boolean in) {
        this.blockId = blockId;
        this.id = id;
        this.in = in;
        this.clicked = false;
    }
}
