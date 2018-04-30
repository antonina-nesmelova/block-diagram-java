package schema.blocks.implementation.ports;

import schema.blocks.implementation.type.Type;

public abstract class Port {
    public Type value;
    public Type.type type;
    private boolean free;
    private int block;
    private int id;

    protected Port(int blockId, int portId) {
        this.free = true;
        this.value = null;
        this.block = blockId;
        this.id = portId;
    }

    public void setType(Type value) {
        this.value = value;
        this.free = false;
        this.type = this.value.getType();

    }

    public int getId() { return this.id; }

    public int getBlock() {
        return block;
    }

    public boolean isFree() {
        return free;
    }

    public boolean hasValue() {
        if (this.value == null) return false;
        else return true;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public Type.type getType() {
        return this.type;
    }

    public double getMass() { return  this.value.getMass();}

    public double getTemp() { return  this.value.getTemp();}
}
