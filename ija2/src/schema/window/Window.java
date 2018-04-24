package schema.window;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;

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
		btnNewButton.setBounds(12, 95, 98, 39);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Freeze");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(12, 156, 98, 39);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnMakeIce = new JButton("Make Ice");
		btnMakeIce.setBounds(10, 216, 100, 39);
		frame.getContentPane().add(btnMakeIce);
		
		JButton btnMakeLiquid = new JButton("Make liquid");
		btnMakeLiquid.setBounds(10, 274, 100, 39);
		frame.getContentPane().add(btnMakeLiquid);
		
		JButton btnMakeGas = new JButton("Make gas");
		btnMakeGas.setBounds(12, 336, 98, 39);
		frame.getContentPane().add(btnMakeGas);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(131, 75, 545, 329);
		frame.getContentPane().add(desktopPane);
	}
}
