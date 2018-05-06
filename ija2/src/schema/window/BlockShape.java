package schema.window;

import static java.lang.Math.abs;
import static schema.window.Constants.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Point2D;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import schema.Schema;
import schema.SchemaShape;
import schema.blocks.implementation.blocks.Block;
import schema.blocks.implementation.type.Type;

public class BlockShape extends JPanel implements Serializable {
    private int id;
    public static Block block;
    public Schema schema;
    public SchemaShape schemaShape;
    public int x;
    public int y;
    public int type;
    public JPanel shape;
    public List<Block> blocks;
    public Point2D offset;

    public BlockShape(int t, int x, int y, int id, Schema schema, SchemaShape schemaShape, Block block) {
        this.block = block;
        this.id = id;
        this.schema = schema;
        this.schemaShape = schemaShape;
        this.x = x;
        this.y = y;
        this.type = t;
        blocks = new ArrayList<>();  // Stores the block names & coords
    }

    public int getId() {
        return this.id;
    }

    JPanel block_creator() {
        JPanel block;
        JLabel blockType = null;
        JPanel blockData;
        JPanel DelPan;
        GridLayout layout;

        block  = new JPanel();
        block.setBackground(new Color(255, 250, 240));
        block.setBounds(x, y, BLOCK_WIDTH, BLOCK_HEIGHT);
        this.shape = block;
        blockData = new JPanel();
        layout = new GridLayout(0,3);
        blockData.setLayout(layout);

        DelPan = new JPanel();
        DelPan.setLayout(layout);

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
                Window.desktopPane.repaint();
                schema.removeBlock(id);
                schemaShape.removeShape(id);
            }
        });
        if (this.type == 0 |this.type == 1) {
            /*	In1 Button */
            PortInShape in1 = new PortInShape("In1", delete, x ,y, schema, this.block, 0);
            blockData.add(in1.getShape());
            schemaShape.portsInShape.add(in1);
            /*	In2 Button */
            PortInShape in2 = new PortInShape("In2", delete, x+105 ,y-35, schema, this.block, 1);
            blockData.add(in2.getShape());
            schemaShape.portsInShape.add(in2);

            PortOutShape out = new PortOutShape("Out", delete, x+105 ,y-35, schema, this.block, 0);
            blockData.add(out.getShape());
            schemaShape.portsOutShape.add(out);
        } else {
            /*	In1 Button */
            PortInShape in1 = new PortInShape("In", delete, x ,y, schema, this.block, 0);
            blockData.add(in1.getShape());
            schemaShape.portsInShape.add(in1);
            /*	Out1 Button */
            PortOutShape out1 = new PortOutShape("Out1", delete, x+105 ,y-25, schema, this.block, 0);
            blockData.add(out1.getShape());
            schemaShape.portsOutShape.add(out1);
            /*	Out2 Button */
            PortOutShape out2 = new PortOutShape("Out2", delete, x ,y, schema, this.block, 1);
            blockData.add(out2.getShape());
            schemaShape.portsOutShape.add(out2);
        }

        Movement drag = new Movement(this, block);
        return block;
    }

    /* public JPanel Data(int p_t, int x, int y, int idOfPort) {
         JPanel panel = new JPanel();
         panel.setBorder(new LineBorder(Color.BLACK));
         panel.setBackground(new Color(245, 222, 179));
         panel.setLayout(null);
         /* 		Out panel
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
             /*	Close Button
             JButton close = new JButton("X");
             close.setBorder(new EmptyBorder(0, 0, 0, 0));
             close.setToolTipText("Close");
             close.setBounds(113, 1, 12, 12);
             panel.add(close);
             close.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent arg0) {
                     Window.desktopPane.remove(panel);
                     Window.desktopPane.repaint();
                 }
             });
         }
         else {
             panel.setBounds((x-BLOCK_WIDTH+35), (y-BLOCK_HEIGHT+55), 100, 100);
             Window.desktopPane.add(panel);

             /*	Choice Type
             Choice type_choice = new Choice();
             panel.add(type_choice);
             type_choice.setBounds(13, 11, 69, 25);
             type_choice.add(Type.type.WATER.toString());
             type_choice.add(Type.type.ALCOHOL.toString());
             type_choice.add(Type.type.ENERGY.toString());
             panel.setVisible(true);

             /* Input 1
             JFormattedTextField FirstField = new JFormattedTextField(new DecimalFormat("####.##"));
             FirstField.setToolTipText("Mass, kg");
             FirstField.setValue(0);
             FirstField.setBounds(13, 33, 70, 20);
             panel.add(FirstField);

             /* Input 2
             JFormattedTextField SecondField = new JFormattedTextField(new DecimalFormat("####.##"));
             SecondField.setToolTipText("Temperature, C");
             SecondField.setValue(0);
             SecondField.setBounds(13, 50, 70, 20);
             panel.add(SecondField);

             /*	Button Set
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
             /*	Close Button
             JButton close = new JButton("X");
             close.setBorder(new EmptyBorder(0, 0, 0, 0));
             close.setToolTipText("Close");
             close.setBounds(87, 1, 12, 12);
             panel.add(close);
             close.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent arg0) {
                     Window.desktopPane.remove(panel);
                     Window.desktopPane.repaint();
                 }
             });
         }

         return panel;
     }*/
}
