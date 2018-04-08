package schema.blocks;

public interface Type {
    public enum type {
        WATER,
        ALKOHOL,
        ENERGY;

        @Override
        public String toString() {
            switch (this) {
                case WATER:    return "water";
                case ALKOHOL: return "alkohol";
                case ENERGY:   return "energy";
            }

            throw new AssertionError("Unknown type: " + this);
        }
    }

}
