package schema.window;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.LineBorder;

import static interfaces.Constants.*;

public class Window {

    private JFrame frame;
    public static String NAME = "Block diagrams modeling physical processes";
    private JDesktopPane desktopPane;
	
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
        //MassField.setValue(0);
        MassField.setBounds(14, 40, 85, 20);
        panel.add(MassField);
        frame.setVisible(true);
        
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
        frame.setVisible(true);
        
        TemperatureField.setValue(MassField.getText());
        TemperatureField.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent event) {
    	        System.out.println("The entered text is: " + MassField.getText());
    	    }
    	});
        
        return panel;
    }
    
    private void block_creator(int t, int x, int y) {    			
		JPanel block = new JPanel();
		block.setBackground(new Color(255, 250, 240));
        block.setBounds(x, y, BLOCK_WIDTH, BLOCK_HEIGHT);
        desktopPane.add(block);
        frame.setVisible(true);
        JLabel jlabel = null;
            
    		if(t == 0) {  
                jlabel = new JLabel("Warm");   
    		}
    		else if(t == 1) {
                jlabel = new JLabel("Freeze"); 
    		}
    		else if(t == 2) {
                jlabel = new JLabel("Make Ice"); 
    		}
    		else if(t == 3) {
                jlabel = new JLabel("Make Liquid");
    		}
    		else if(t == 4) {
                jlabel = new JLabel("Make Gas"); 
    		}
    	
    	jlabel.setFont(new Font("Verdana",1,18));
        block.add(jlabel);
        block.setBorder(new LineBorder(Color.BLACK));
            
    		/*	Details Button */
    		JButton details = new JButton("Details");
    		desktopPane.setLayer(details, 1);
            details.setBounds((x + 1), y, 17, 17);
            details.setToolTipText("Details");
            block.add(details);
            frame.setVisible(true);
            
            /*	Delete Block Button */
    		JButton delete = new JButton("Delete");
            delete.setBounds(x, y, 75, 23);
            delete.setToolTipText("Delete Block");
            block.add(delete);
            frame.setVisible(true);
      
    			details.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                    	JPanel panel = Data((x + 120), (y - 70));
                    	JButton pnl_cls = new JButton("X");
                        pnl_cls.setBounds((x + 230), (y - 70), 15, 15);
                        pnl_cls.setToolTipText("Close");
                        desktopPane.add(pnl_cls);
                        frame.setVisible(true);
                        
                    	if (panel != null) {
                    		delete.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent arg0) {
                                	desktopPane.remove(block);
                                    desktopPane.remove(delete);
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
    			
    			delete.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                    	desktopPane.remove(block);
                        desktopPane.remove(delete);
                        desktopPane.remove(details);
                        desktopPane.revalidate();
                        desktopPane.repaint();
                    }
    			 });

      Movement drag = new Movement(block);
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
            	block_creator(0, x, y);
        	}
        });
        btnWarm.setForeground(new Color(128, 0, 128));
        btnWarm.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 11));
        btnWarm.setBackground(new Color(211, 211, 211));
        btnWarm.setBounds(17, 80, BUTTON_WIDTH,BUTTON_HEIGHT);
        frame.getContentPane().add(btnWarm);

        /*	Button Freeze	 */
        JButton btnFreeze = new JButton("Freeze");
        btnFreeze.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {     	
            	int x = rand.nextInt(SCREEN_WIDTH - 500) + 100;
        		int y = rand.nextInt(SCREEN_HEIGHT - 500) + 100;
            	block_creator(1, x, y);
            }
        });
        btnFreeze.setForeground(new Color(128, 0, 128));
        btnFreeze.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 11));
        btnFreeze.setBackground(new Color(211, 211, 211));
        btnFreeze.setBounds(17, 158, BUTTON_WIDTH,BUTTON_HEIGHT);
        frame.getContentPane().add(btnFreeze);
        
        /*	Button Make Ice	 */
        JButton btnMakeIce = new JButton("Make Ice");
        btnMakeIce.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {     	
            	int x = rand.nextInt(SCREEN_WIDTH - 500) + 100;
        		int y = rand.nextInt(SCREEN_HEIGHT - 500) + 100;
            	block_creator(2, x, y);
            }
        });
        btnMakeIce.setForeground(new Color(128, 0, 128));
        btnMakeIce.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 11));
        btnMakeIce.setBackground(new Color(211, 211, 211));
        btnMakeIce.setBounds(17, 240, BUTTON_WIDTH,BUTTON_HEIGHT);
        frame.getContentPane().add(btnMakeIce);
        
        /*	Button Make Liquid	 */
        JButton btnMakeLiquid = new JButton("Make Liquid");
        btnMakeLiquid.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {     	
            	int x = rand.nextInt(SCREEN_WIDTH - 500) + 100;
        		int y = rand.nextInt(SCREEN_HEIGHT - 500) + 100;
            	block_creator(3, x, y);
            }
        });
        btnMakeLiquid.setForeground(new Color(128, 0, 128));
        btnMakeLiquid.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 10));
        btnMakeLiquid.setBackground(new Color(211, 211, 211));
        btnMakeLiquid.setBounds(17, 327, BUTTON_WIDTH,BUTTON_HEIGHT);
        frame.getContentPane().add(btnMakeLiquid);

        JButton btnMakeGas = new JButton("Make Gas");
        btnMakeGas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {     	
            	int x = rand.nextInt(SCREEN_WIDTH - 500) + 100;
        		int y = rand.nextInt(SCREEN_HEIGHT - 500) + 100;
            	block_creator(4, x, y);
            }
        });
        btnMakeGas.setForeground(new Color(128, 0, 128));
        btnMakeGas.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 11));
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
