package schema;

import schema.window.BlockShape;

import java.util.ArrayList;
import java.util.List;

public class SchemaShape {
    private  List<BlockShape> blocksShape = new ArrayList<BlockShape>();

    public SchemaShape() {

    }

    public void addShape(BlockShape shape) {
        this.blocksShape.add(shape);
    }

    public void removeShape(int id) {
        boolean removed = this.blocksShape.removeIf(block -> (block.getId() == id));
        if (removed) System.out.println("Removed shape " + id);
    }
    public BlockShape getShape(int id) {
        for (BlockShape shape : blocksShape) {
            if (shape.getId() == id) return shape;
        }
        return null;
    }
}
