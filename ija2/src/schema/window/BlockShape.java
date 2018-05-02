package schema.window;

import static interfaces.Constants.BLOCK_HEIGHT;
import static interfaces.Constants.BLOCK_WIDTH;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import schema.blocks.implementation.blocks.Block;

public class BlockShape {
	private int id;
	public Block block;
	public BlockShape(int t, int x, int y, int id, Block block) {
		this.Data(x, y);
		this.id = id;
		this.block = block;
	}
	
	public JPanel Data(int x, int y) {      	
    	JPanel panel = new JPanel();
		panel.setBounds(0, 0, 125, 86);
		panel.setBackground(new Color(245, 222, 179));
		//desktopPane.add(panel);
		panel.setLayout(null);
		
        JFormattedTextField MassField = new JFormattedTextField();
        MassField.setToolTipText("Mass");
        //MassField.setValue(0);
        MassField.setBounds(14, 40, 85, 20);
        panel.add(MassField);
        
        MassField.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent event) {
    	        System.out.println("The entered text is: " + MassField.getText());
    	    }
    	});
        
        JFormattedTextField TemperatureField = new JFormattedTextField();
        TemperatureField.setToolTipText("Temperature");
        TemperatureField.setValue(MassField.getValue());
        TemperatureField.setBounds(14, 60, 85, 20);
        panel.add(TemperatureField);
        
        TemperatureField.setValue(MassField.getText());
        TemperatureField.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent event) {
    	        System.out.println("The entered text is: " + MassField.getText());
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
        
        
        /*	Choice Type 
        Choice choice_1 = new Choice();
        block.add(choice_1, BorderLayout.CENTER);
        choice_1.setBounds(25, 50, 85, 25);
        choice_1.add("Water");
        choice_1.add("Alkohol");
        choice_1.add("Energy");*/
        
        /*	Delete Button */
        JButton delete = new JButton("Delete");
        DelPan.setToolTipText("Delete Block");
        DelPan.setLayout(new BorderLayout());
        DelPan.add(delete);
        
    	/*delete.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			Window.desktopPane.remove(block);
    			Window.desktopPane.revalidate();
    			Window.desktopPane.repaint();
            }
    	});*/
        
        /*	In1 Button */
        JButton In1 = new JButton("In1");
        In1.setToolTipText("Insert Mass");
        blockData.add(In1);
        In1.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 15));
        In1.setBorder(new EmptyBorder(0, 0, 0, 0));
        In1.setBorder(new LineBorder(Color.BLACK));
        In1.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			JPanel panel = Data(x, y);
    		}
        });	
        /*	In2 Button */
        JButton In2 = new JButton("In2");
        In2.setToolTipText("Insert Mass");
        blockData.add(In2);
        In2.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 15));
        In2.setBorder(new EmptyBorder(0, 0, 0, 0));
        In2.setBorder(new LineBorder(Color.BLACK));
        In2.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			JPanel panel = Data(x, y);
    		}
        });	
        /*	Out Button */
        JButton Out = new JButton("Out");
        Out.setToolTipText("Insert Mass");
        blockData.add(Out);
        Out.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 15));
        Out.setBorder(new EmptyBorder(0, 0, 0, 0));
        Out.setBorder(new LineBorder(Color.BLACK));
        Out.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			JPanel panel = Data(x, y);
    		}
        });	    	

      Movement drag = new Movement(block);
      
      return block;
 }
	
}
