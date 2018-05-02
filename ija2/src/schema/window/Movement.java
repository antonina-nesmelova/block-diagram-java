package schema.window;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;


public class Movement extends JPanel implements MouseMotionListener, MouseListener {
    private int blockX;
    private int blockY;
    private int dst_X;
    private int dst_Y;

    public Movement(Component... pns) {
        for(Component frame : pns) {
            frame.addMouseListener(this);
            frame.addMouseMotionListener(this);
        }
    }

    public void mouseMoved(MouseEvent evt) {

    }
    public void mouseDragged(MouseEvent evt) {
        getCoordinates(evt);
        dst_X = blockX+evt.getComponent().getX();
        dst_Y = blockY+evt.getComponent().getY();
        evt.getComponent().setLocation(dst_X, dst_Y);
    }
    /**
     * Funkce získává souřadnice kurzoru myši.
     * @param mouseEvent    děj myši
     */
    private void getCoordinates(MouseEvent mouseEvent) {
        blockX = mouseEvent.getX();
        blockY = mouseEvent.getY();
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }
}
