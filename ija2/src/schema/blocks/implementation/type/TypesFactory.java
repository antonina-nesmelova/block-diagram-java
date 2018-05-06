package schema.blocks.implementation.type;

public class TypesFactory {

    public TypesFactory() {

    }

    /**
     * Creating instance of type and setting values
     * @param type type
     * @param mass mass
     * @param temp temperature
     * @return
     */
    public Type createMaterial(Type.type type, double mass, double temp) {
        switch (type) {
            case WATER: {
               return new Water(mass, temp);
            }
            case ALCOHOL: {
                return new Alcohol(mass, temp);
            }
            case ENERGY: {
                return new Energy(mass, temp);
            }
            default: {
                return new Energy(mass, temp);
            }
        }
    }
}
