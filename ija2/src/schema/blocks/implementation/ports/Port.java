package schema.blocks.implementation.ports;

import schema.blocks.Type;
import schema.blocks.implementation.type.Alcohol;
import schema.blocks.implementation.type.Energy;
import schema.blocks.implementation.type.Water;

public abstract class Port {
    public Type value;
    public boolean free;

    protected Port() {
        free = true;
    }

    public void setType(Type.type type) {
        switch (type) {
            case WATER: {
                value = new Water();
                break;
            }
            case ALKOHOL: {
                value = new Alcohol();
                break;
            }
            case ENERGY: {
                value = new Energy();
                break;
            }
        }

    }
}
