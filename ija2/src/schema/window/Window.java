package schema.window;

import javax.imageio.ImageIO;
import javax.swing.*;

import schema.window.Panel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Window {

    public static String NAME = "Block Schema's editor";     //name of window
    public static boolean splitted;

    public static void main(String[] args) {

        JFrame frame = new JFrame(NAME);
        splitted = false;

        frame.getContentPane().setLayout(new GridBagLayout());
        frame.getContentPane().add(new Panel(frame));


        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
