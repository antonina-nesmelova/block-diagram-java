package schema.window;

import schema.SchemaShape;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Listener implements MouseListener {
    private int blockId;
    private int portId;
    private boolean in;
    private SchemaShape schemaShape;

    public Listener(int blockId, int id, boolean in, SchemaShape schemaShape) {
        this.blockId = blockId;
        this.portId = id;
        this.in = in;
        this.schemaShape = schemaShape;
    }
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getModifiers() == MouseEvent.BUTTON3_MASK) {
            System.out.println("Mouse clicked (# of clicks: " + mouseEvent.getClickCount() + ")"
            + " block " + this.blockId + " port " + this.portId + " in " + this.in);
            schemaShape.clickPort(blockId, portId, in);
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
