package schema.window;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;


public class Movement extends JPanel implements MouseMotionListener, MouseListener { 
	private int X;
	private int Y;
	
	public Movement(Component... pns) {
    	for(Component frame : pns) {
    		frame.addMouseListener(this);
    		frame.addMouseMotionListener(this);
    	}
    }
    
    public void mouseMoved(MouseEvent evt) {
      }
    public void mouseDragged(MouseEvent evt) {
        evt.getComponent().setLocation((evt.getX()+evt.getComponent().getX())-X, (evt.getY()+evt.getComponent().getY())-Y);
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
