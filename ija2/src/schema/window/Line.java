package schema.window;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Line extends JFrame implements MouseMotionListener, MouseListener {
	Point start;
	int x, y;
	int start_X, start_Y;
	
	public Line(Component... pns) {
    	for(Component frame : pns) {
    		frame.addMouseListener(this);
    		frame.addMouseMotionListener(this);
    	}    	
    }
	
	@Override
	public void mouseClicked(MouseEvent e) {
		  if(e.getButton() == MouseEvent.BUTTON3) {
			  start_X = e.getX();
			  start_Y = e.getY();
			  System.out.println(start_X);
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
		 x = end.x - start.x + p.x;
		 y = end.y - start.y + p.y;
		 setLocation(x, y);
		 System.out.println(x);
	 }
	 public void paint(Graphics g) {
		 g.drawLine(start_X,x,start_Y,y);
	}

}
