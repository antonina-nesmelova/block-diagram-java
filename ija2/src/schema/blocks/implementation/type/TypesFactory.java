package schema.blocks.implementation.type;

public class TypesFactory {

    public TypesFactory() {

    }

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
