package schema.window;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Font;
import javax.swing.JToolBar;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Window {

	private JFrame frame;

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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 725, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Warm");
		btnNewButton.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 11));
		btnNewButton.setForeground(new Color(128, 0, 128));
		btnNewButton.setBackground(new Color(211, 211, 211));
		btnNewButton.setBounds(12, 42, 109, 56);
		frame.getContentPane().add(btnNewButton);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(142, 28, 545, 364);
		frame.getContentPane().add(desktopPane);
		
		JButton btnFreeze = new JButton("Freeze");
		btnFreeze.setForeground(new Color(128, 0, 128));
		btnFreeze.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 11));
		btnFreeze.setBackground(new Color(211, 211, 211));
		btnFreeze.setBounds(12, 109, 109, 56);
		frame.getContentPane().add(btnFreeze);
		
		JButton btnMakeIce = new JButton("Make Ice");
		btnMakeIce.setForeground(new Color(128, 0, 128));
		btnMakeIce.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 11));
		btnMakeIce.setBackground(new Color(211, 211, 211));
		btnMakeIce.setBounds(12, 176, 109, 56);
		frame.getContentPane().add(btnMakeIce);
		
		JButton btnMakeLiquid = new JButton("Make Liquid");
		btnMakeLiquid.setForeground(new Color(128, 0, 128));
		btnMakeLiquid.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 10));
		btnMakeLiquid.setBackground(new Color(211, 211, 211));
		btnMakeLiquid.setBounds(12, 243, 109, 56);
		frame.getContentPane().add(btnMakeLiquid);
		
		JButton btnMakeGas = new JButton("Make Gas");
		btnMakeGas.setForeground(new Color(128, 0, 128));
		btnMakeGas.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 11));
		btnMakeGas.setBackground(new Color(211, 211, 211));
		btnMakeGas.setBounds(12, 314, 109, 56);
		frame.getContentPane().add(btnMakeGas);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		menuBar.setBackground(new Color(211, 211, 211));
		//menuBar.setBounds(0, 0, 709, 31);
		frame.setVisible(true);		
		
		JMenu Save = new JMenu("Save");
		Save.setForeground(new Color(128, 0, 128));
		menuBar.add(Save);
		
		JMenu menu = new JMenu("Save");
		menu.setHorizontalAlignment(SwingConstants.LEFT);
		menu.setForeground(new Color(128, 0, 128));
		Save.add(menu);
		
		JMenu mnSaveAs = new JMenu("Save as...");
		mnSaveAs.setHorizontalAlignment(SwingConstants.LEFT);
		mnSaveAs.setForeground(new Color(128, 0, 128));
		Save.add(mnSaveAs);
		
		JMenu Download = new JMenu("Download");
		Download.setForeground(new Color(128, 0, 128));
		menuBar.add(Download);
		
		JMenu Execute = new JMenu("Execute");
		Execute.setForeground(new Color(128, 0, 128));
		menuBar.add(Execute);
	}
}
