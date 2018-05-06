package schema;

import schema.window.BlockShape;
import schema.window.PortInShape;
import schema.window.PortOutShape;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SchemaShape implements Serializable {
    public  List<BlockShape> blocksShape = new ArrayList<BlockShape>();
    public  List<PortInShape> portsInShape = new ArrayList<PortInShape>();
    public  List<PortOutShape> portsOutShape = new ArrayList<PortOutShape>();

    public SchemaShape() {

    }

    /**
     * Add shape to list of shapes
     * @param shape shape of blocks
     */
    public void addShape(BlockShape shape) {
        this.blocksShape.add(shape);
    }

    /**
     * Remove shape with the same id
     * @param id id of shape to remove
     */
    public void removeShape(int id) {
        boolean removed = this.blocksShape.removeIf(block -> (block.getId() == id));
        if (removed) System.out.println("Removed shape " + id);
    }

    /**
     * Return shape with the same id
     * @param id
     * @return
     */
    public BlockShape getShape(int id) {
        for (BlockShape shape : blocksShape) {
            if (shape.getId() == id) return shape;
        }
        return null;
    }
}
