package schema.window;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Line extends JFrame implements MouseMotionListener, MouseListener {
	private int x,y,x2,y2,a=1;
    private int count=0;

	public Line(Component... pns) {
    	for(Component frame : pns) {
    		frame.addMouseListener(this);
    	}    	
    }
	public void paint(Graphics g){

        if(count==2){
            g.drawLine(x, y, x2, y2);

            count=0;
            x=0;
            y=0;
            x2=0;
            y2=0;
        }
    }
	public void mouseClicked(MouseEvent mouse){   

        count++;

        if(count==1){
            x=mouse.getX();
            y=mouse.getY();
        }

        if(count==2){
            x2 = mouse.getX();
            y2 = mouse.getY();
        }

        repaint();
        }

    public void mouseEntered(MouseEvent mouse){ }   
    public void mouseExited(MouseEvent mouse){ }
    public void mousePressed(MouseEvent mouse){ }
    public void mouseReleased(MouseEvent mouse){ }

    public static void main(String arg[]){
       
    }

    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub

    }
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
