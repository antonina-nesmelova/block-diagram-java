package schema.window;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.*;

import javax.swing.*;

import schema.FullSchema;
import schema.Schema;
import schema.SchemaShape;
import schema.blocks.implementation.blocks.Block;
import schema.blocks.implementation.blocks.Block.Operation;
import schema.save.Saving;

import static schema.window.Constants.*;

public class Window {
	public static Schema schema;
    public static SchemaShape schemaShape;
    public static FullSchema full;
    private JFrame frame;
    public static String NAME = "Block diagrams modeling physical processes";
    protected static JDesktopPane desktopPane;
    private int number;
    private int schemaid;
    private static Saving saver;

	
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Window window = new Window();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
    }

	/**
     * Create the application.
     */
    public Window() {
    	this.number = 0;
    	this.schemaid = 1;
        initialize();
        schemaShape = new SchemaShape();
        schema = new Schema();
        this.full = new FullSchema(schema, schemaShape);
        Saving saver = new Saving();
        this.saver = saver;
    }
    
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
    	Random rand = new Random();
    	
    	/*	Window	*/
        frame = new JFrame(NAME);
        frame.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null); 
        
        /*	Working area	*/        
        desktopPane = new JDesktopPane();
        desktopPane.setBackground(new Color(171, 171, 171));
        desktopPane.setBounds(155, 28, WORKING_AREA_WIDTH, WORKING_AREA_HEIGHT);
        frame.getContentPane().add(desktopPane);

        /*	Button Warm	 */        
        JButton btnWarm = new JButton("Warm");
    	btnWarm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	int x = rand.nextInt(SCREEN_WIDTH - 500) + 100;
    			int y = rand.nextInt(SCREEN_HEIGHT - 500) + 100;
    			Block logicBlock = schema.createBlock(Operation.WARM);
            	BlockShape block = new BlockShape(0, x, y, number, schema, schemaShape);
                schemaShape.addShape(block);
            	number += 1;
                desktopPane.add(block.block_creator());
                frame.setVisible(true);
        	}
        });
    	
    	
        btnWarm.setForeground(new Color(128, 0, 128));
        btnWarm.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 12));
        btnWarm.setBackground(new Color(211, 211, 211));
        btnWarm.setBounds(17, 80, BUTTON_WIDTH,BUTTON_HEIGHT);
        frame.getContentPane().add(btnWarm);

        /*	Button Freeze	 */
        JButton btnFreeze = new JButton("Freeze");
        btnFreeze.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {     	
            	int x = rand.nextInt(SCREEN_WIDTH - 500) + 100;
        		int y = rand.nextInt(SCREEN_HEIGHT - 500) + 100;
        		Block logicBlock = schema.createBlock(Operation.FREEZE);
        		BlockShape block = new BlockShape(1, x, y, number, schema, schemaShape);
                schemaShape.addShape(block);
            	number += 1;
                desktopPane.add(block.block_creator());
                frame.setVisible(true);
        	}
        });
        btnFreeze.setForeground(new Color(128, 0, 128));
        btnFreeze.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 12));
        btnFreeze.setBackground(new Color(211, 211, 211));
        btnFreeze.setBounds(17, 158, BUTTON_WIDTH,BUTTON_HEIGHT);
        frame.getContentPane().add(btnFreeze);
        
        /*	Button Make Ice	 */
        JButton btnMakeIce = new JButton("Make Ice");
        btnMakeIce.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {     	
            	int x = rand.nextInt(SCREEN_WIDTH - 500) + 100;
        		int y = rand.nextInt(SCREEN_HEIGHT - 500) + 100;
        		Block logicBlock = schema.createBlock(Operation.MKICE);
        		BlockShape block = new BlockShape(2, x, y, number, schema, schemaShape);
                schemaShape.addShape(block);
                number += 1;
                desktopPane.add(block.block_creator());
                frame.setVisible(true);       		
            }
        });
        btnMakeIce.setForeground(new Color(128, 0, 128));
        btnMakeIce.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 12));
        btnMakeIce.setBackground(new Color(211, 211, 211));
        btnMakeIce.setBounds(17, 240, BUTTON_WIDTH,BUTTON_HEIGHT);
        frame.getContentPane().add(btnMakeIce);
        
        /*	Button Make Liquid	 */
        JButton btnMakeLiquid = new JButton("Make Liquid");
        btnMakeLiquid.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {     	
            	int x = rand.nextInt(SCREEN_WIDTH - 500) + 100;
        		int y = rand.nextInt(SCREEN_HEIGHT - 500) + 100;
        		Block logicBlock = schema.createBlock(Operation.MKLIQUID);
        		BlockShape block = new BlockShape(3, x, y, number, schema, schemaShape);
                schemaShape.addShape(block);
                number += 1;
                desktopPane.add(block.block_creator());
                frame.setVisible(true);
        	}
        });
        btnMakeLiquid.setForeground(new Color(128, 0, 128));
        btnMakeLiquid.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 12));
        btnMakeLiquid.setBackground(new Color(211, 211, 211));
        btnMakeLiquid.setBounds(17, 327, BUTTON_WIDTH,BUTTON_HEIGHT);
        frame.getContentPane().add(btnMakeLiquid);

        JButton btnMakeGas = new JButton("Make Gas");
        btnMakeGas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {     	
            	int x = rand.nextInt(SCREEN_WIDTH - 500) + 100;
        		int y = rand.nextInt(SCREEN_HEIGHT - 500) + 100;
        		Block logicBlock = schema.createBlock(Operation.MKGASS);
        		BlockShape block = new BlockShape(4, x, y, number, schema, schemaShape);
                schemaShape.addShape(block);
                number += 1;
                desktopPane.add(block.block_creator());
                frame.setVisible(true);
        	}
        });
        btnMakeGas.setForeground(new Color(128, 0, 128));
        btnMakeGas.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 12));
        btnMakeGas.setBackground(new Color(211, 211, 211));
        btnMakeGas.setBounds(17, 416, BUTTON_WIDTH,BUTTON_HEIGHT);
        frame.getContentPane().add(btnMakeGas);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        menuBar.setBackground(new Color(211, 211, 211));
        frame.setVisible(true);

        JMenu Save = new JMenu("Save");
        Save.setForeground(new Color(128, 0, 128));
        menuBar.add(Save);

        JMenu menu = new JMenu("Save");
        JMenuItem save = new JMenuItem("Save");
        save.setHorizontalAlignment(SwingConstants.LEFT);
        save.setForeground(new Color(128, 0, 128));
        Save.add(save);
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Want to save");
                saver.Save(schemaid, full);
                schemaid +=1;
            }
        });

        JMenuItem saveas = new JMenuItem("Save As...");
        saveas.setHorizontalAlignment(SwingConstants.LEFT);
        saveas.setForeground(new Color(128, 0, 128));
        Save.add(saveas);

        JMenu Download = new JMenu("Download");
        Download.setForeground(new Color(128, 0, 128));
        menuBar.add(Download);

        JMenuItem download = new JMenuItem("Download");
        download.setHorizontalAlignment(SwingConstants.LEFT);
        download.setForeground(new Color(128, 0, 128));
        Download.add(download);
        download.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                full = saver.Download("schema1.ser");
                /* TODO clean desctopPane */
                for (BlockShape shape : full.shape.blocksShape) {
                    desktopPane.add(shape.block_creator());
                }
                frame.setVisible(true);
            }
        });


        JMenu Execute = new JMenu("Execute");
        Execute.setForeground(new Color(128, 0, 128));
        menuBar.add(Execute);
    }
    public static void remove_block(int id) {
    	schema.removeBlock(id);
    }
}
