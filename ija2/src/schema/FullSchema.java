package schema;

import java.io.Serializable;

public class FullSchema implements Serializable {
    public SchemaShape shape;
    public Schema schema;
    public int schemaid;

    /**
     * Constructor of schema with schema of logic blocks and view of blocks
     * @param schema schema with logic blocks
     * @param shape view of blocks
     */
    public FullSchema(Schema schema, SchemaShape shape){
        this.schema = schema;
        this.shape = shape;
    }
}
