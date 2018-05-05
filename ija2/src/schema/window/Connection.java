package schema.window;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Connection extends JFrame implements MouseMotionListener, MouseListener {
    Point start;

    public Connection(Component... pns) {
        for(Component frame : pns) {
            frame.addMouseListener(this);
            frame.addMouseMotionListener(this);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse clicked");
        if(e.getButton() == MouseEvent.BUTTON3) {
            start = e.getPoint();
            System.out.println(start);
            //rg.add(this);
            //getParent().repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        System.out.println("Mouse entered");
        // TODO Auto-generated method stub

    }
    @Override
    public void mouseExited(MouseEvent arg0) {
        System.out.println("Mouse exited");
        // TODO Auto-generated method stub

    }
    @Override
    public void mousePressed(MouseEvent arg0) {
        System.out.println("Mouse pressed");
        // TODO Auto-generated method stub

    }
    @Override
    public void mouseReleased(MouseEvent arg0) {
        System.out.println("Mouse released");
        // TODO Auto-generated method stub

    }
    public void mouseMoved(MouseEvent e)	{
        System.out.println("Mouse moved");
        start = e.getPoint();
    }
    public void mouseDragged(MouseEvent e) {
        System.out.println("Mouse dragged");
        Point end = e.getPoint();
        Point p = getLocation();
        setLocation(end.x - start.x + p.x, end.y - start.y + p.y);
        getParent().repaint();
    }

}