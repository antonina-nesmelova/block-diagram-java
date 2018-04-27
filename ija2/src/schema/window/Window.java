package schema.window;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Window {

    private JFrame frame;
    public static String NAME = "Block diagrams modeling physical processes";
    //private JTextField txtMass;
    //private JTextField txtTemperature;
    private JDesktopPane desktopPane;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int width = (int) screenSize.getWidth();
	int height = (int) screenSize.getHeight();
	
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

    public JPanel Data(int width, int height) {
    	JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(230, 200, 140)));
        panel.setBackground(new Color(245, 222, 179));
        desktopPane.setLayer(panel, 2);
        panel.setBounds(width, height, 125, 86);
        desktopPane.add(panel);
        panel.setLayout(null);

        Choice choice_1 = new Choice();
        choice_1.setBounds(14, 10, 85, 20);
        panel.add(choice_1);
        choice_1.add("Water");
        choice_1.add("Alkohol");
        choice_1.add("Energy");

        JFormattedTextField MassField = new JFormattedTextField();
        MassField.setToolTipText("Mass");
        MassField.setValue(0);
        MassField.setBounds(14, 40, 85, 20);
        panel.add(MassField);
        frame.setVisible(true);

        JFormattedTextField TemperatureField = new JFormattedTextField();
        TemperatureField.setToolTipText("Temperature");
        MassField.setValue(0);
        TemperatureField.setBounds(14, 60, 85, 20);
        panel.add(TemperatureField);
        frame.setVisible(true);
        
        return panel;
    }
    
    private void block_creator(int t) {    	
    	Random rand = new Random();
		int x = rand.nextInt(width - 500) + 100;
		int y = rand.nextInt(height - 500) + 100;
		JPanel block = new JPanel();
		block.setBackground(new Color(255, 250, 240));
        block.setBounds(x, y, 130, 115);
        desktopPane.add(block);
        frame.setVisible(true);
		
    		if(t == 0) {  
                JLabel jlabel = new JLabel("Warm");
                jlabel.setFont(new Font("Verdana",1,18));
                block.add(jlabel);
                block.setBorder(new LineBorder(Color.BLACK)); 
    		}
    		else if(t == 1) {
                JLabel jlabel = new JLabel("Freeze");
                jlabel.setFont(new Font("Verdana",1,18));
                block.add(jlabel);
                block.setBorder(new LineBorder(Color.BLACK)); 
    		}
    		else if(t == 2) {
                JLabel jlabel = new JLabel("Make Ice");
                jlabel.setFont(new Font("Verdana",1,18));
                block.add(jlabel);
                block.setBorder(new LineBorder(Color.BLACK)); 
    		}
    		else if(t == 3) {
                JLabel jlabel = new JLabel("Make Liquid");
                jlabel.setFont(new Font("Verdana",1,18));
                block.add(jlabel);
                block.setBorder(new LineBorder(Color.BLACK)); 
    		}
    		else if(t == 4) {
                JLabel jlabel = new JLabel("Make Gas");
                jlabel.setFont(new Font("Verdana",1,18));
                block.add(jlabel);
                block.setBorder(new LineBorder(Color.BLACK)); 
    		}
                
    		JButton del_block = new JButton("Delete");
                desktopPane.setLayer(del_block, 1);
                del_block.setBounds((x + 27), (y + 75), 75, 23);
                del_block.setToolTipText("Delete Block");
                desktopPane.add(del_block);
                frame.setVisible(true);
                
    			JButton details = new JButton("X");
    			desktopPane.setLayer(details, 1);
                details.setBounds((x + 113), y, 17, 17);
                details.setToolTipText("Details");
                desktopPane.add(details);
                frame.setVisible(true);
                
    			details.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                    	JPanel panel = Data((x + 120), (y - 70));
                    	JButton pnl_cls = new JButton("X");
                        desktopPane.setLayer(pnl_cls, 3);
                        pnl_cls.setBounds((x + 230), (y - 70), 15, 15);
                        pnl_cls.setToolTipText("Close");
                        desktopPane.add(pnl_cls);
                        frame.setVisible(true);
                        
                    	if (panel != null) {
                    		del_block.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent arg0) {
                                	desktopPane.remove(block);
                                    desktopPane.remove(del_block);
                                    desktopPane.remove(details);
                                    desktopPane.remove(panel);
                                    desktopPane.remove(pnl_cls);
                                    desktopPane.revalidate();
                                    desktopPane.repaint();
                                }
                            });
                    	}
                        
                        pnl_cls.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent arg0) {
                            	desktopPane.remove(panel);
                                desktopPane.remove(pnl_cls);
                                desktopPane.revalidate();
                                desktopPane.repaint();
                            }
                        });
                    }
                });
    			
    			del_block.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                    	desktopPane.remove(block);
                        desktopPane.remove(del_block);
                        desktopPane.remove(details);
                        desktopPane.revalidate();
                        desktopPane.repaint();
                    }
                });
 }

                    	/*JPanel panel = Data(x, y);
                    	Movement mv = new Movement(panel);
                    	
                    	
                    	if(panel != null) {
                    		details.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent arg0) {
                                	desktopPane.remove(panel);
                                	desktopPane.remove(warmblock);
                                    desktopPane.remove(details);
                                    desktopPane.revalidate();
                                    desktopPane.repaint();
                                }
                            });
                    	} */
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
    	
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

        /*	Button Warm	 */        
        JButton btnWarm = new JButton("Warm");
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
        JButton btnFreeze = new JButton("Freeze");
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
        btnMakeGas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {     	
            	block_creator(4);
            }
        });
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
