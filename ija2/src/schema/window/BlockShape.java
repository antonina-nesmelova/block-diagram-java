package schema.window;

import static interfaces.Constants.BLOCK_HEIGHT;
import static interfaces.Constants.BLOCK_WIDTH;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import schema.Schema;
import schema.blocks.implementation.blocks.Block;

public class BlockShape {
	private int id;
	public Block block;
	public Schema schema;
	protected static JPanel panel;
	private int mass = 0;
	private int temp = 0;
	protected static String sel_ch;
	
	public BlockShape(int t, int x, int y, int id, Schema schema) {
		this.id = id;
		this.schema = schema;
	}
	
	public JPanel Data(int p_t, int x, int y) {    
		panel = new JPanel();
        
		/*	Output Button	*/
		if(p_t == 0) {
        	panel.setBounds((x+125), (y-BLOCK_HEIGHT+55), 100, 85);
        	panel.setBackground(new Color(245, 222, 179));
			Window.desktopPane.add(panel);
			panel.setLayout(null);
			panel.setBorder(new LineBorder(Color.BLACK));
	        
			/* Output */
            JFormattedTextField Type = new JFormattedTextField();
            Type.setToolTipText("Type");
            Type.setText(sel_ch);
            Type.setBounds(14, 15, 70, 20);
            panel.add(Type);
			
			/* Mass */
            JFormattedTextField FirstField = new JFormattedTextField();
            FirstField.setToolTipText("Mass");
            FirstField.setBounds(14, 35, 70, 20);
            FirstField.setValue(mass);
            panel.add(FirstField);
            
            /* Temperature */
            JFormattedTextField SecondField = new JFormattedTextField();
            SecondField.setToolTipText("Temperature");
            SecondField.setBounds(14, 55, 70, 20);
            SecondField.setValue(temp);
            panel.add(SecondField); 
	        
        }
		/*	Input Buttons	*/
        else {
    		panel.setBounds((x-BLOCK_WIDTH+35), (y-BLOCK_HEIGHT+55), 100, 100);
    		panel.setBackground(new Color(245, 222, 179));
    		Window.desktopPane.add(panel);
    		panel.setLayout(null);
            panel.setBorder(new LineBorder(Color.BLACK));
    		
            JButton enter = new JButton("Enter");
            enter.setBorder(new EmptyBorder(0, 0, 0, 0));
            enter.setBorder(new LineBorder(Color.BLACK));
            enter.setBounds(13, 72, 70, 18);
            panel.add(enter);
            
    		/*	Choice Type */
            Choice ch = new Choice();
    	
            /* Mass */
            JTextField FirstField = new JTextField();
            FirstField.setToolTipText("Mass");
            FirstField.setBounds(13, 33, 70, 20);
            panel.add(FirstField);
	        
            enter.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent ae){
	            	mass = Integer.parseInt(FirstField.getText());
	            }
	        });
            
            /* Temperature */
            JFormattedTextField SecondField = new JFormattedTextField();
            SecondField.setToolTipText("Temperature");
            SecondField.setBounds(13, 52, 70, 20);
            panel.add(SecondField); 
            
            enter.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent ae){
	            	temp = Integer.parseInt(SecondField.getText());
	            }
	        });
        }    
		/*	Close Button	*/
        JButton close = new JButton("X");
        close.setBorder(new EmptyBorder(0, 0, 0, 0));
        close.setToolTipText("Close");
        close.setBounds(87, 1, 12, 12);
        panel.add(close);
        
        close.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			Window.desktopPane.remove(panel);
    			Window.desktopPane.revalidate();
    			Window.desktopPane.repaint();
            }
    	});
        
        return panel; 
}	
	JPanel block_creator(int t, int x, int y) {   
		JPanel block;
		JLabel blockType = null;
        JPanel blockData;
        JPanel DelPan;
        GridLayout layout;
        
        block  = new JPanel(); 
		block.setBackground(new Color(255, 250, 240));
        block.setBounds(x, y, BLOCK_WIDTH, BLOCK_HEIGHT);

        blockData = new JPanel();
        layout = new GridLayout(0,3);
        blockData.setLayout(layout); 
        
        DelPan = new JPanel();
        DelPan.setLayout(layout);

    		switch (t) {  
    			case 0: {
    				blockType = new JLabel("Warm", JLabel.CENTER );
    				break;
    			}
    			case 1: { 
    				blockType = new JLabel("Freeze", JLabel.CENTER );
    				break;
    			}
    			case 2: {
	    			blockType = new JLabel("Make Ice", JLabel.CENTER ); 
	    			break;
	    		}
    			case 3: {
	    			blockType = new JLabel("Make Liquid", JLabel.CENTER );
	    			break;
	    		}
    			case 4 : {
	    			blockType = new JLabel("Make Gas", JLabel.CENTER ); 
	    			break;
	    		}
    		}
            block.add(blockType);
            block.add(blockData);
            block.add(DelPan);
            block.setVisible(true); 
    		
    	/*	Name of the block	*/
        blockType.setFont(new Font("Verdana", 1, 14));
        blockType.setSize(BLOCK_WIDTH,BLOCK_HEIGHT);
        block.add(blockType);
        block.setBorder(new LineBorder(Color.BLACK));
        block.setLayout(new GridLayout(3, 1));
        
        /*	Delete Button */
        JButton delete = new JButton("Delete");
        DelPan.setToolTipText("Delete Block");
        DelPan.setLayout(new BorderLayout());
        DelPan.add(delete);
        
    	delete.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			Window.desktopPane.remove(block);
    			Window.desktopPane.revalidate();
    			Window.desktopPane.repaint();
    			schema.removeBlock(id);
            }
    	});
        
        /*	In1 Button */
        JButton In1 = new JButton("In1");
        blockData.add(In1);
        In1.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 15));
        In1.setBorder(new EmptyBorder(0, 0, 0, 0));
        In1.setBorder(new LineBorder(Color.BLACK));
        
        In1.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			JPanel panel = Data(1, x, y);
    			
    		}
        });	
        /*	In2 Button */
        JButton In2 = new JButton("In2");
        blockData.add(In2);
        In2.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 15));
        In2.setBorder(new EmptyBorder(0, 0, 0, 0));
        In2.setBorder(new LineBorder(Color.BLACK));
                
        In2.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			JPanel panel = Data(1, x+110, y-35);
    			
    		}
        });	
        /*	Out Button */
        JButton Out = new JButton("Out");
        blockData.add(Out);
        Out.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 15));
        Out.setBorder(new EmptyBorder(0, 0, 0, 0));
        Out.setBorder(new LineBorder(Color.BLACK));
        Out.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		JPanel panel = Data(0, x, y);
    		}
        });	    	
        
        //Line l1 = new Line(In1);
        //Line l2 = new Line(Out); 
        
        Movement drag = new Movement(block);
      
      return block;
 }	
}
