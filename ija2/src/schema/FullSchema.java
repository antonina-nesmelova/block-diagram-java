package schema;

import java.io.Serializable;

public class FullSchema implements Serializable {
    public SchemaShape shape;
    public Schema schema;
    public int schemaid;

    public FullSchema(Schema schema, SchemaShape shape){
        this.schema = schema;
        this.shape = shape;
    }
}
