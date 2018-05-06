package schema.blocks.implementation.ports;

import schema.blocks.implementation.blocks.Block;
import schema.blocks.implementation.type.AbstractMaterial;
import schema.blocks.implementation.type.Type;

import java.io.Serializable;

public abstract class Port implements Serializable {
    public Type value;
    public Type.type type;
    private boolean free;
    private Block block;
    private int id;

    /**
     * Initialize ports
     * @param block block with this port
     * @param portId id of port
     */
    protected Port(Block block, int portId) {
        this.free = true;
        this.value = null;
        this.block = block;
        this.id = portId;
    }

    /**
     * Set type and value of port
     * @param value type with values to be set
     */
    public void setType(Type value) {
        this.value = value;
        //this.free = false;
        this.type = this.value.getType();

    }

    /**
     * Returns id of port
     * @return id of port
     */
    public int getId() { return this.id; }

    /**
     * Returns block of this port
     * @return block
     */
    public Block getBlock() {
        return this.block;
    }

    /**
     * Returns true if port isn't connected and has no value
     * @return
     */
    public boolean isFree() {
        return free;
    }

    /**
     * Returns true if value of port is set
     * @return
     */
    public boolean hasValue() {
        if (this.value == null) return false;
        else return true;
    }

    /**
     * Set state of port (free or not)
     * @param free
     */
    public void setFree(boolean free) {
        this.free = free;
    }

    /**
     * Returns type of value on port
     * @return type
     */
    public Type.type getType() {
        return this.type;
    }

    /**
     * Returns mass of value on port
     * @return mass
     */
    public double getMass() { return  this.value.getMass();}
    /**
     * Returns temperature of value on port
     * @return temperature
     */
    public double getTemp() { return  this.value.getTemp();}
    /**
     * Returns joules of value on port
     * @return joules
     */
    public double getJoule() { return  this.value.getJoule();}
    /**
     * Returns state of value on port
     * @return state
     */
    public AbstractMaterial.State getState() { return  this.value.getState();}

    /**
     * Returns 0 if there is no value on port, 1 if there is some material and 2 if there is energy
     * @return 0, 1 or 2
     */
    public int isMaterial() {
        if (this.value == null) return 0;
        else return this.value.isMaterial();
    }
}
