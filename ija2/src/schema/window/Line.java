package schema.window;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Line extends JFrame implements MouseMotionListener, MouseListener {
	Point start;
	
	public Line(Component... pns) {
    	for(Component frame : pns) {
    		frame.addMouseListener(this);
    		frame.addMouseMotionListener(this);
    	}    	
    }
	
	@Override
	public void mouseClicked(MouseEvent e) {
		  if(e.getButton() == MouseEvent.BUTTON3) {
			  start = e.getPoint();
			  System.out.println(start);
			  //rg.add(this);
			  //getParent().repaint();
		  }
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
	public void mouseMoved(MouseEvent e)	{
		 start = e.getPoint();
	 }
	 public void mouseDragged(MouseEvent e)		{
		 Point end = e.getPoint();
		 Point p = getLocation();
		 setLocation(end.x - start.x + p.x, end.y - start.y + p.y);
		 getParent().repaint();
	 }

}
