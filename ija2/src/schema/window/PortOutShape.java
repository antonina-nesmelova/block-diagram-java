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

public class PortOutShape implements Serializable {
    public boolean active = false;
    private JButton shape;
    private JButton delete;
    private int x;
    private int y;
    private Schema schema;
    private Block block;

    public PortOutShape(String name, JButton delete, int x, int y, Schema schema, Block block, int id) {
        this.delete = delete;
        this.x = x;
        this.y = y;
        this.schema = schema;
        this.block = block;
        JButton port = new JButton(name);
        port.setToolTipText("Insert Values");
        port.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 15));
        port.setBorder(new EmptyBorder(0, 0, 0, 0));
        port.setBorder(new LineBorder(Color.BLACK));
        port.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JPanel panel = Data(0, x, y, id);
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

    public JPanel Data(int p_t, int x, int y, int idOfPort) {
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.BLACK));
        panel.setBackground(new Color(245, 222, 179));
        panel.setLayout(null);
        if (block.portsOut.get(idOfPort).hasValue()) {
            String info;
            if(block.portsOut.get(idOfPort).isMaterial() == 1) {
                info = "<html>"  + "Type: " + block.portsOut.get(idOfPort).getType().toString() +  "<br/>"
                        + "Mass of out: " + block.portsOut.get(idOfPort).getMass() + "<br/>"
                        +  "Out temp: " + block.portsOut.get(idOfPort).getTemp() + "<br/>"
                        + "State: " + block.portsOut.get(idOfPort).getState().toString() + "<br/>"
                        + "Joules: " + block.portsOut.get(idOfPort).getJoule() + "</html>";
            } else {
                info = "<html>"  + "Type: " + block.portsOut.get(idOfPort).getType().toString() +  "<br/>"
                        + "Joules: " + block.portsOut.get(idOfPort).getJoule() + "</html>";
            }
            JLabel label = new JLabel(info);
            label.setBounds(10, -5, BLOCK_WIDTH, BLOCK_HEIGHT);
            label.setFont(new Font("Courier New", Font.ITALIC, 11));
            panel.add(label);
            panel.setBounds((x+125), (y-BLOCK_HEIGHT+55), 125, 105);
            Window.desktopPane.add(panel);
        }
        /*	Close Button	*/
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
        return panel;
    }
}
