package schema.window;

import schema.Schema;
import schema.blocks.implementation.blocks.Block;
import schema.blocks.implementation.type.Type;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.text.DecimalFormat;

import static java.lang.Math.abs;
import static schema.window.Constants.BLOCK_HEIGHT;
import static schema.window.Constants.BLOCK_WIDTH;

public class PortInShape implements Serializable {
    public boolean active = false;
    private JButton shape;
    private JButton delete;
    private int x;
    private int y;
    private Schema schema;
    private Block block;
    private int blockId;

    public PortInShape(String name, JButton delete, int x, int y, Schema schema, Block block, int id) {
        this.delete = delete;
        this.x = x;
        this.y = y;
        this.schema = schema;
        this.block = block;
        this.blockId = block.getId();
        JButton port = new JButton(name);
        port.setToolTipText("Insert Values");
        port.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 15));
        port.setBorder(new EmptyBorder(0, 0, 0, 0));
        port.setBorder(new LineBorder(Color.BLACK));
        port.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JPanel panel = Data(1, x, y, id, block);
                delete.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        Window.desktopPane.remove(panel);
                        Window.desktopPane.repaint();
                    }
                });
            }
        });
        this.shape = port;
    }

    public JButton getShape() {
        return this.shape;
    }

    public JPanel Data(int p_t, int x, int y, int idOfPort, Block block) {
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.BLACK));
        panel.setBackground(new Color(245, 222, 179));
        panel.setLayout(null);
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
                if (!schema.setPortValue(schema.getBlock(blockId), Type.type.valueOf(type), idOfPort, mass, temp)) {
                    JOptionPane.showMessageDialog(Window.frame, "This type can't be chosen");
                }
            }
        });
        /*	Close Button	*/
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
        return panel;
    }
}
