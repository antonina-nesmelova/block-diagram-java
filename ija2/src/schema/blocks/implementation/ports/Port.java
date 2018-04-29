package schema.blocks.implementation.ports;

import schema.blocks.Type;
import schema.blocks.implementation.type.Alcohol;
import schema.blocks.implementation.type.Energy;
import schema.blocks.implementation.type.Water;

public abstract class Port {
    public Type value;
    private boolean free;
    private int block;

    protected Port(int blockId) {
        this.free = true;
        this.value = null;
        this.block = blockId;
    }

    public void setType(Type.type type, double mass, double temp) {
        switch (type) {
            case WATER: {
                value = new Water(mass, temp);
                break;
            }
            case ALCOHOL: {
                value = new Alcohol(mass, temp);
                break;
            }
            case ENERGY: {
                value = new Energy(mass, temp);
                break;
            }
        }
        this.free = false;

    }

    public int getBlock() {
        return block;
    }

    public boolean isFree() {
        return free;
    }
}
