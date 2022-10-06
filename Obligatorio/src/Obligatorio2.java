import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class Obligatorio2 {

	private JFrame frame7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Obligatorio2 window = new Obligatorio2();
					window.frame7.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Obligatorio2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame7 = new JFrame();
		frame7.setTitle("Obligatorio");
		frame7.setBounds(100, 100, 463, 190);
		frame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame7.getContentPane().setLayout(null);
	}
}
