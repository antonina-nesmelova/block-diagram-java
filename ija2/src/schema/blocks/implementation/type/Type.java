package schema.blocks.implementation.type;

public interface Type {
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

    public int isMaterial();

    public type getType();

    public double getMass();

    public double getTemp();

    public double getJoule();

    public double getFreezeTemp();

    public double getGasTemp() ;

    public double getThermalConst();

    public double getFusionConst();

    public double getVaporisationConst();

    public AbstractMaterial.State getState();

    public void setState(AbstractMaterial.State state);

    public void setTemp(double temp);

    public void setMass(double mass);

    public void setJoule(double joule);

    public void setValues(double mass, double temp);

}
