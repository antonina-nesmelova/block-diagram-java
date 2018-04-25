package schema.window;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import javax.swing.JMenuBar;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.Scrollbar;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Choice;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class Window {

    private JFrame frame;
    public static String NAME = "Block diagrams modeling physical processes";
    private JTextField txtMass;
    private JTextField txtTemperature;
    private JDesktopPane desktopPane;
    private JButton btnWarm;
    private JButton btnFreeze;
    private JPanel panel;
    //Component[] componentList = desktopPane.getComponents();

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
        initialize();
    }

    /*public void Dots(int lh, int rh, int ld, int rd) {
    	
    }*/
    public JPanel Data(int width, int height) {
    	JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(230, 200, 140)));
        panel.setBackground(new Color(245, 222, 179));
        desktopPane.setLayer(panel, 1);
        panel.setBounds(width, height, 120, 86);
        desktopPane.add(panel);
        panel.setLayout(null);

        Choice choice_1 = new Choice();
        choice_1.setBounds(14, 10, 85, 20);
        panel.add(choice_1);
        choice_1.add("Water");
        choice_1.add("Alkohol");
        choice_1.add("Energy");

        txtMass = new JTextField();
        panel.add(txtMass);
        txtMass.setColumns(5);

        txtTemperature = new JTextField();
        panel.add(txtTemperature);
        txtTemperature.setColumns(5);
        frame.setVisible(true);

        JFormattedTextField MassField = new JFormattedTextField();
        MassField.setToolTipText("Mass");
        MassField.setBounds(14, 40, 85, 20);
        panel.add(MassField);
        frame.setVisible(true);

        JFormattedTextField TemperatureField = new JFormattedTextField();
        TemperatureField.setToolTipText("Temperature");
        TemperatureField.setBounds(14, 60, 85, 20);
        panel.add(TemperatureField);
        frame.setVisible(true);
        
        return panel;
    }
    
    private void block_creator(int t) {
    		if(t == 0) {
    			JButton warmblock = new JButton("Warm");
                JButton clsbtn = new JButton("Close");
                warmblock.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                    	JPanel wrmpnl = Data(165, 11);
                    	if(wrmpnl != null) {
                    		clsbtn.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent arg0) {
                                	desktopPane.remove(wrmpnl);
                                }
                            });
                    	}
                    }
                });
                warmblock.setBackground(new Color(255, 250, 240));
                warmblock.setFont(new Font("Tahoma", Font.PLAIN, 13));
                warmblock.setBounds(55, 40, 130, 115);
                desktopPane.add(warmblock);
                frame.setVisible(true);

                clsbtn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        desktopPane.remove(warmblock);
                        desktopPane.remove(clsbtn);
                        desktopPane.revalidate();
                        desktopPane.repaint();
                    }
                });
                desktopPane.setLayer(clsbtn, 1);
                clsbtn.setBounds(163, 131, 22, 23);
                clsbtn.setToolTipText("Close");
                desktopPane.add(clsbtn);
                frame.setVisible(true);
    		}
    		
    		if(t == 1) {
    			JButton freezeblock = new JButton("Freeze");
    			JButton clsbtn = new JButton("Close");
                freezeblock.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                    	JPanel frzpnl = Data(435, 11);
                    	if(frzpnl != null) {
                    		clsbtn.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent arg0) {
                                	desktopPane.remove(frzpnl);
                                }
                            });
                    	}
                    }
                });
                freezeblock.setBackground(new Color(255, 250, 240));
                freezeblock.setFont(new Font("Tahoma", Font.PLAIN, 13));
                freezeblock.setBounds(325, 40, 130, 115);
                desktopPane.add(freezeblock);
                frame.setVisible(true);
                clsbtn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        desktopPane.remove(freezeblock);
                        desktopPane.remove(clsbtn);
                        desktopPane.revalidate();
                        desktopPane.repaint();
                    }
                });
                desktopPane.setLayer(clsbtn, 1);
                clsbtn.setBounds(432, 131, 22, 23);
                clsbtn.setToolTipText("Close");
                desktopPane.add(clsbtn);
                frame.setVisible(true);               
    		}
    		
    		if(t == 2) {
    			JButton iceblock = new JButton("Make Ice");
    			JButton clsbtn = new JButton("Close");
    			iceblock.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                    	JPanel inepnl = Data(685, 11);
                    	if(inepnl != null) {
                    		clsbtn.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent arg0) {
                                	desktopPane.remove(inepnl);
                                }
                            });
                    	}
                    }
                });
    			iceblock.setBackground(new Color(255, 250, 240));
    			iceblock.setFont(new Font("Tahoma", Font.PLAIN, 13));
    			iceblock.setBounds(575, 40, 130, 115);
                desktopPane.add(iceblock);
                frame.setVisible(true);
                clsbtn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        desktopPane.remove(iceblock);
                        desktopPane.remove(clsbtn);
                        desktopPane.revalidate();
                        desktopPane.repaint();
                    }
                });
                desktopPane.setLayer(clsbtn, 1);
                clsbtn.setBounds(684, 131, 22, 23);
                clsbtn.setToolTipText("Close");
                desktopPane.add(clsbtn);
                frame.setVisible(true); 
    		}
    		if(t == 3) {
    			JButton iceblock = new JButton("Make Liquid");
    			JButton clsbtn = new JButton("Close");
    			iceblock.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                    	JPanel inepnl = Data(965, 11);
                    	if(inepnl != null) {
                    		clsbtn.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent arg0) {
                                	desktopPane.remove(inepnl);
                                }
                            });
                    	}
                    }
                });
    			iceblock.setBackground(new Color(255, 250, 240));
    			iceblock.setFont(new Font("Tahoma", Font.PLAIN, 13));
    			iceblock.setBounds(850, 40, 130, 115);
                desktopPane.add(iceblock);
                frame.setVisible(true);
                clsbtn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        desktopPane.remove(iceblock);
                        desktopPane.remove(clsbtn);
                        desktopPane.revalidate();
                        desktopPane.repaint();
                    }
                });
                desktopPane.setLayer(clsbtn, 1);
                clsbtn.setBounds(959, 131, 22, 23);
                clsbtn.setToolTipText("Close");
                desktopPane.add(clsbtn);
                frame.setVisible(true); 
    		}
   }
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	int width = (int) screenSize.getWidth();
    	int height = (int) screenSize.getHeight();
    	
    	/*	Window	*/
        frame = new JFrame(NAME);
        frame.setBounds(0, 0, width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        /*	Working area	*/
        desktopPane = new JDesktopPane();
        desktopPane.setBackground(new Color(171, 171, 171));
        desktopPane.setBounds(155, 28, (width - 200), (height - 150));
        frame.getContentPane().add(desktopPane);
        Scrollbar scrollbar_1 = new Scrollbar();
        scrollbar_1.setOrientation(Scrollbar.HORIZONTAL);
        scrollbar_1.setBounds(0, (height - 167), (width - 200), 17);
        desktopPane.add(scrollbar_1);
        Scrollbar scrollbar_2 = new Scrollbar();
        scrollbar_2.setOrientation(Scrollbar.VERTICAL);
        scrollbar_2.setBounds((width - 217), 0, 17, (height - 167));
        desktopPane.add(scrollbar_2);

        /*	Button Warm	 */
        btnWarm = new JButton("Warm");
    	btnWarm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	block_creator(0);
            }
        });
        btnWarm.setForeground(new Color(128, 0, 128));
        btnWarm.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 11));
        btnWarm.setBackground(new Color(211, 211, 211));
        btnWarm.setBounds(12, 80, 109, 56);
        frame.getContentPane().add(btnWarm);

        /*	Button Freeze	 */
        btnFreeze = new JButton("Freeze");
        btnFreeze.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {     	
            	block_creator(1);
            }
        });
        btnFreeze.setForeground(new Color(128, 0, 128));
        btnFreeze.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 11));
        btnFreeze.setBackground(new Color(211, 211, 211));
        btnFreeze.setBounds(12, 158, 109, 56);
        frame.getContentPane().add(btnFreeze);
        
        /*	Button Make Ice	 */
        JButton btnMakeIce = new JButton("Make Ice");
        btnMakeIce.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {     	
            	block_creator(2);
            }
        });
        btnMakeIce.setForeground(new Color(128, 0, 128));
        btnMakeIce.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 11));
        btnMakeIce.setBackground(new Color(211, 211, 211));
        btnMakeIce.setBounds(12, 240, 109, 56);
        frame.getContentPane().add(btnMakeIce);
        
        /*	Button Make Liquid	 */
        JButton btnMakeLiquid = new JButton("Make Liquid");
        btnMakeLiquid.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {     	
            	block_creator(3);
            }
        });
        btnMakeLiquid.setForeground(new Color(128, 0, 128));
        btnMakeLiquid.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 10));
        btnMakeLiquid.setBackground(new Color(211, 211, 211));
        btnMakeLiquid.setBounds(12, 327, 109, 56);
        frame.getContentPane().add(btnMakeLiquid);

        JButton btnMakeGas = new JButton("Make Gas");
        btnMakeGas.setForeground(new Color(128, 0, 128));
        btnMakeGas.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 11));
        btnMakeGas.setBackground(new Color(211, 211, 211));
        btnMakeGas.setBounds(12, 416, 109, 56);
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

        JMenuItem saveas = new JMenuItem("Save As...");
        saveas.setHorizontalAlignment(SwingConstants.LEFT);
        saveas.setForeground(new Color(128, 0, 128));
        Save.add(saveas);

        JMenu Download = new JMenu("Download");
        Download.setForeground(new Color(128, 0, 128));
        menuBar.add(Download);

        JMenu Execute = new JMenu("Execute");
        Execute.setForeground(new Color(128, 0, 128));
        menuBar.add(Execute);
    }
}
