import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Replacer {

	private JFrame frame;
	public String text;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Replacer window = new Replacer();
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
	public Replacer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 45, 414, 205);
		frame.getContentPane().add(textArea);
		
		JButton btnReplace = new JButton("Replace");
		btnReplace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				text=textArea.getText().replaceAll("A ","%F0%9F%87%A6"+"\r\n")
						.replaceAll("B ","%F0%9F%87%A7"+"\r\n")
						.replaceAll("C ","%F0%9F%87%A8"+"\r\n")
						.replaceAll("D ","%F0%9F%87%A9"+"\r\n")
						.replaceAll("E ","%F0%9F%87%AA"+"\r\n")
						.replaceAll("F ","%F0%9F%87%AB"+"\r\n")
						.replaceAll("G ","%F0%9F%87%AC"+"\r\n")
						.replaceAll("H ","%F0%9F%87%AD"+"\r\n")
						.replaceAll("I ","%F0%9F%87%AE"+"\r\n")
						.replaceAll("J ","%F0%9F%87%AF"+"\r\n")
						.replaceAll("K ","%F0%9F%87%B0"+"\r\n")
						.replaceAll("L ","%F0%9F%87%B1"+"\r\n")
						.replaceAll("M ","%F0%9F%87%B2"+"\r\n")
						.replaceAll("N ","%F0%9F%87%B3"+"\r\n")
						.replaceAll("O ","%F0%9F%87%B4"+"\r\n")
						.replaceAll("P ","%F0%9F%87%B5"+"\r\n")
						.replaceAll("Q ","%F0%9F%87%B6"+"\r\n")
						.replaceAll("R ","%F0%9F%87%B7"+"\r\n")
						.replaceAll("S ","%F0%9F%87%B8"+"\r\n")
						.replaceAll("T ","%F0%9F%87%B9"+"\r\n")
						.replaceAll("U ","%F0%9F%87%BA"+"\r\n")
						.replaceAll("V ","%F0%9F%87%BB"+"\r\n")
						.replaceAll("W ","%F0%9F%87%BC"+"\r\n")
						.replaceAll("X ","%F0%9F%87%BD"+"\r\n")
						.replaceAll("Y ","%F0%9F%87%BE"+"\r\n")
						.replaceAll("Z ","%F0%9F%87%BF"+"\r\n");
				System.out.println(text);
				textArea.setText(text);
			}
		});
		btnReplace.setBounds(10, 11, 414, 23);
		frame.getContentPane().add(btnReplace);
	}
}
