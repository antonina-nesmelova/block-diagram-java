package schema.blocks;

public interface Type {
    public enum type {
        WATER,
        ALCOHOL,
        ENERGY;

        @Override
        public String toString() {
            switch (this) {
                case WATER:    return "water";
                case ALCOHOL: return "alcohol";
                case ENERGY:   return "energy";
            }

            throw new AssertionError("Unknown type: " + this);
        }
    }

}
