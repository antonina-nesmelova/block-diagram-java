package schema.blocks.implementation.type;

public interface Type {
    /**
     * Possible types
     */
    public enum type {
        WATER,
        ALCOHOL,
        ENERGY;

        @Override
        public String toString() {
            switch (this) {
                case WATER:    return "WATER";
                case ALCOHOL: return "ALCOHOL";
                case ENERGY:   return "ENERGY";
            }

            throw new AssertionError("Unknown type: " + this);
        }
    }

    /**
     * Returns 1 if this is some material and 2 if this is energy
     * @return 0, 1 or 2
     */
    public int isMaterial();
    /**
     * Returns type
     * @return type
     */
    public type getType();
    /**
     * Returns mass
     * @return mass
     */
    public double getMass();
    /**
     * Returns temperature
     * @return temperature
     */
    public double getTemp();
    /**
     * Returns joules
     * @return joules
     */
    public double getJoule();

    /**
     * Returns temperature between ice and liquid states
     * @return
     */
    public double getFreezeTemp();
    /**
     * Returns temperature between gas and liquid states
     * @return
     */
    public double getGasTemp() ;
    /**
     * Returns thermal constant of type
     * @return
     */
    public double getThermalConst();
    /**
     * Returns fusion constant of type
     * @return
     */
    public double getFusionConst();
    /**
     * Returns vaporization constant of type
     * @return
     */
    public double getVaporisationConst();
    /**
     * Returns state of type
     * @return
     */
    public AbstractMaterial.State getState();
    /**
     * Set state of type
     * @return
     */
    public void setState(AbstractMaterial.State state);
    /**
     * Set temperature of type
     * @return
     */
    public void setTemp(double temp);
    /**
     * Set mass of type
     * @return
     */
    public void setMass(double mass);
    /**
     * Set energy that type contains
     * @return
     */
    public void setJoule(double joule);
    /**
     * Set values of type. Mass and temperature in material and joule from mass variable in energy
     * @return
     */
    public void setValues(double mass, double temp);

}
