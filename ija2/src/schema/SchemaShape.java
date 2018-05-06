package schema;

import schema.blocks.implementation.ports.PortIn;
import schema.blocks.implementation.ports.PortOut;
import schema.window.BlockShape;
import schema.window.PortShape;
import schema.window.Window;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SchemaShape implements Serializable {
    public  List<BlockShape> blocksShape = new ArrayList<BlockShape>();
    public  List<PortShape> portsShape = new ArrayList<PortShape>();
    private Schema schema;
    public SchemaShape(Schema schema) {
        this.schema = schema;
    }

    public void addShape(BlockShape shape) {
        this.blocksShape.add(shape);
    }

    public void addPortShape(PortShape shape) {
        this.portsShape.add(shape);
    }

    public void clickPort(int blockId, int portId, boolean in) {
        for (PortShape port : portsShape) {
            if (blockId == port.blockId & portId == port.id & in == port.in) {
                port.clicked = true;
            } else if (port.clicked == true) {
                if (blockId != port.blockId & port.in != in) {
                    PortIn portIn;
                    PortOut portOut;
                    if (in) {
                        portIn = schema.getBlock(blockId).getPortIn(portId);
                        portOut = schema.getBlock(port.blockId).getPortOut(port.id);
                    } else {
                        portIn = schema.getBlock(port.blockId).getPortIn(port.id);
                        portOut = schema.getBlock(blockId).getPortOut(portId);
                    }
                    if (!schema.createRelation(portIn, portOut)) {
                        JOptionPane.showMessageDialog(Window.frame, "Impossible to connect because of loop");
                    } else {
                        System.out.println("Relation created");
                    }
                } else {
                    port.clicked = false;
                }
            }
        }
    }

    public void removeShape(int id) {
        boolean removed = this.blocksShape.removeIf(block -> (block.getId() == id));
        this.portsShape.removeIf(port -> (port.blockId == id));
        if (removed) System.out.println("Removed shape " + id);
    }
    public BlockShape getShape(int id) {
        for (BlockShape shape : blocksShape) {
            if (shape.getId() == id) return shape;
        }
        return null;
    }
}
