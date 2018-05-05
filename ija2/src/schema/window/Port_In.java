package schema.window;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import schema.Schema;
import schema.SchemaShape;
import schema.blocks.implementation.blocks.Block;

public class Port_In implements MouseListener {
	 private SchemaShape schemaShape;
	
	 public Port_In(SchemaShape schemaShape) {
	        this.schemaShape = schemaShape;  
	    }
public static JButton port(String NAME) {
	JButton port = new JButton(NAME);
    port.setToolTipText("Insert Values");
    port.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 15));
    port.setBorder(new EmptyBorder(0, 0, 0, 0));
    port.setBorder(new LineBorder(Color.BLACK));
	return port;
}

public void mousePressed(MouseEvent e) {
   
}

public void mouseReleased(MouseEvent e) {
	if (e.getModifiers() == MouseEvent.BUTTON3_MASK) {
		System.out.println("Mouse released; # of clicks: "+ e.getClickCount());
	}
}

public void mouseEntered(MouseEvent e) {
   
}

public void mouseExited(MouseEvent e) {
   
}

public void mouseClicked(MouseEvent e) {
	if (e.getModifiers() == MouseEvent.BUTTON3_MASK) {
	   System.out.println("Mouse clicked (# of clicks: " + e.getClickCount() + ")");
	}
}
}
