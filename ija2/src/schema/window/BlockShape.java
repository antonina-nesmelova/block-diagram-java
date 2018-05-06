package schema.window;

import static java.lang.Math.abs;
import static schema.window.Constants.*;

import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.border.*;

import schema.Schema;
import schema.SchemaShape;
import schema.blocks.implementation.blocks.Block;
import schema.blocks.implementation.type.Type;

public class BlockShape extends JPanel implements Serializable {
	private int id;
    public static Block block;
    public Schema schema;
    public SchemaShape schemaShape;
    public int x, y, type;
    public JPanel shape;
    public static JButton In1;
    public static JButton In2;
    public static JButton Out;
    public static JButton In;
    public static JButton Out1;
    public static JButton Out2;
    public static int p_in_count = 0;
    public static int p_out_count = 0;

    /**
     * Constructor for shape of the block
     * @param t    			type of the block
     * @param x				x-coordinate of the block
     * @param y				y-coordinate of the block	 
     * @param schema		instance of the schema class	
     * @param schemaShape	instance of the schemaShape class	
     * @param block			instance of the block class
     */
    public BlockShape(int t, int x, int y, int id, Schema schema, SchemaShape schemaShape, Block block) {
        this.block = block;
        this.id = id;
        this.schema = schema;
        this.schemaShape = schemaShape;
        this.x = x;
        this.y = y;
        this.type = t;   
    }
    /**
     * Function for block's date
     * @param p_t    		type of the information panel(input/output)
     * @param x				x-coordinate of the information panel
     * @param y				y-coordinate of the information panel	 
     * @param idOfPort		id of port	
     */
    public JPanel Data(int p_t, int x, int y, int idOfPort) {
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.BLACK));
        panel.setBackground(new Color(245, 222, 179));
        panel.setLayout(null);   
        /*	Close Button	*/
        JButton close = new JButton("X");
        close.setBorder(new EmptyBorder(0, 0, 0, 0));
        close.setToolTipText("Close");
        panel.add(close);
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Window.desktopPane.remove(panel);
                Window.desktopPane.repaint();
            }
        });     
        /* 		Output panel	*/
        if(p_t == 0) {
            if (block.portsOut.get(idOfPort).hasValue()) {
                JLabel label = new JLabel("<html>"  + "Type: " + block.portsOut.get(idOfPort).getType().toString() +  "<br/>"
                        + "Mass of out: " + block.portsOut.get(idOfPort).getMass() + "<br/>"
                        +  "Out temp: " + block.portsOut.get(idOfPort).getTemp() + "<br/>"
                        + "State: " + block.portsOut.get(idOfPort).getState().toString() + "<br/>"
                        + "Joules: " + block.portsOut.get(idOfPort).getJoule() + "</html>");
                label.setBounds(10, -5, BLOCK_WIDTH, BLOCK_HEIGHT);
                label.setFont(new Font("Courier New", Font.ITALIC, 11));
                panel.add(label);
                panel.setBounds((x+125), (y-BLOCK_HEIGHT+55), 125, 105);
                Window.desktopPane.add(panel);
            }
            close.setBounds(113, 1, 12, 12);   
        }
        else {
            panel.setBounds((x-BLOCK_WIDTH+35), (y-BLOCK_HEIGHT+55), 100, 100);
            Window.desktopPane.add(panel);
            /*	Choice Type */
            Choice type_choice = new Choice();
            panel.add(type_choice);
            type_choice.setBounds(13, 11, 69, 25);
            type_choice.add(Type.type.WATER.toString());
            type_choice.add(Type.type.ALCOHOL.toString());
            type_choice.add(Type.type.ENERGY.toString());
            panel.setVisible(true);
            /* Input 1 */
            JFormattedTextField FirstField = new JFormattedTextField(new DecimalFormat("####.##"));
            FirstField.setToolTipText("Mass, kg");
            FirstField.setValue(0);
            FirstField.setBounds(13, 33, 70, 20);
            panel.add(FirstField);
            /* Input 2 */
            JFormattedTextField SecondField = new JFormattedTextField(new DecimalFormat("####.##"));
            SecondField.setToolTipText("Temperature, C");
            SecondField.setValue(0);
            SecondField.setBounds(13, 50, 70, 20);
            panel.add(SecondField);
            /*	Button Set	*/
            JButton set = new JButton("Set");
            set.setBorder(new EmptyBorder(0, 0, 0, 0));
            panel.setToolTipText("Add values");
            set.setBounds(13, 72, 70, 18);
            set.setBorder(new LineBorder(Color.BLACK));
            panel.setLayout(new BorderLayout());
            panel.add(set);
            set.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    String type = type_choice.getSelectedItem();
                    double mass = abs(Double.parseDouble(FirstField.getText()));
                    double temp = Double.parseDouble(SecondField.getText());
                    System.out.println("In set, mass " + mass + ", temp " + temp + ", type " + type);
                    if (!schema.setPortValue(block, Type.type.valueOf(type), idOfPort, mass, temp)) {
                        JOptionPane.showMessageDialog(Window.frame, "This type can't be chosen");
                    }
                }
            });
            close.setBounds(87, 1, 12, 12);       
        }
        return panel;
    }
    /**
     * Function for creating blocks 
     */
    JPanel block_creator() {
        GridLayout layout;
        /*	Block	*/
        JPanel block;
        block  = new JPanel();
        block.setBackground(new Color(255, 250, 240));
        block.setBounds(x, y, BLOCK_WIDTH, BLOCK_HEIGHT);
        this.shape = block;
        /*	Top Buttons Area */
        JPanel blockData;
        blockData = new JPanel();
        layout = new GridLayout(0,3);
        blockData.setLayout(layout);
        /*	Delete Button Area 	*/
        JPanel DelPan;
        DelPan = new JPanel();
        DelPan.setLayout(layout);
        /*	Name of the block	*/
        JLabel blockType = null;
        switch (this.type) {
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
        blockType.setFont(new Font("Verdana", 1, 14));
        blockType.setSize(BLOCK_WIDTH,BLOCK_HEIGHT);
        block.setBorder(new LineBorder(Color.BLACK));
        block.setLayout(new GridLayout(3, 1));
        /*	Delete Button */
        JButton delete = new JButton("Delete");
        DelPan.setToolTipText("Delete Block");
        DelPan.setLayout(new BorderLayout());
        /* 	Adding all components to block	*/
        block.add(blockType);
        block.add(blockData);
        block.add(DelPan);
        DelPan.add(delete);
        block.add(blockType);
        block.setVisible(true);
        /*	Delete block	*/
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Window.desktopPane.remove(block);
                Window.desktopPane.repaint();
                schema.removeBlock(id);
                schemaShape.removeShape(id);
            }
        });
        /*	Block has two in ports and one out port	*/
        if (this.type == 0 |this.type == 1) {
        	Port Port = new Port(schemaShape);
            In1 = Port.port_bttn("In1");  
            In2 = Port.port_bttn("In2");
            Out = Port.port_bttn("Out");
            blockData.add(In1);    			//In1 Button
            blockData.add(In2); 			//In2 Button
            blockData.add(Out); 			//Out Button
            /*  Right Clicks */
            In1.addMouseListener(new Port(schemaShape));
            In2.addMouseListener(new Port(schemaShape));
            Out.addMouseListener(new Port(schemaShape));
            /*	Left Clicks	 */
            In1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                	JPanel panel = Data(1, x, y, 0);
                    delete.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                            Window.desktopPane.remove(panel);
                            Window.desktopPane.repaint();
                        }
                    });
                }
            });
            In2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    JPanel panel = Data(1, x+105, y-35, 1);
                    delete.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                            Window.desktopPane.remove(panel);
                            Window.desktopPane.repaint();
                        }
                    });
                }
            });
            Out.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    JPanel panel = Data(0, x, y, 0);
                    delete.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                            Window.desktopPane.remove(panel);
                            Window.desktopPane.repaint();
                        }
                    });
                }
            });
        } 
        /*  One in port, two outs port  */
        else {
        	Port Port = new Port(schemaShape);
            In = Port.port_bttn("In");  
            Out1 = Port.port_bttn("Out1");
            Out2 = Port.port_bttn("Out2"); 
            blockData.add(In);    			//In1 Button
            blockData.add(Out1); 			//In2 Button
            blockData.add(Out2); 			//Out Button	
            /*  Right Clicks */
            In.addMouseListener(new Port(schemaShape));
            Out1.addMouseListener(new Port(schemaShape));
            Out2.addMouseListener(new Port(schemaShape));
            /*	Left Clicks	 */
            In.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    JPanel panel = Data(1, x, y, 0);
                    delete.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                            Window.desktopPane.remove(panel);
                            Window.desktopPane.repaint();
                        }
                    });
                }
            }); 
            Out1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    JPanel panel = Data(0, x-105, y-25, 0);
                    delete.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                            Window.desktopPane.remove(panel);
                            Window.desktopPane.repaint();
                        }
                    });
                }
            });
            Out2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    JPanel panel = Data(0, x, y, 1);
                    delete.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                            Window.desktopPane.remove(panel);
                            Window.desktopPane.repaint();
                        }
                    });
                }
            });
        }
        Movement drag = new Movement(this, block);
        
        return block;
    }
    public int getId() {
        return this.id;
    }    
}
