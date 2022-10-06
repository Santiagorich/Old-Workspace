package Suma;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class En_clase {
	static 	ActionListener[] action;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					En_clase window = new En_clase();
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
	public En_clase() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		double Suma=0;
		String Texto="";
		frame = new JFrame();
		
		frame.setBounds(100, 100, 429, 79);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(22, 11, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(118, 11, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("+");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(90, 14, 46, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("=");
		label_1.setBounds(214, 14, 14, 14);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(238, 14, 46, 14);
		frame.getContentPane().add(label_2);
		
		JButton btnSumar = new JButton("Sumar");
		btnSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				label_2.setText(String.valueOf(Double.parseDouble((textField.getText())) + Double.parseDouble((textField_1.getText()))));
				}
				catch (Exception NumberFormatException){
					JOptionPane.showConfirmDialog(null, "Voh so tonto?");
				}

			}
		});
		btnSumar.setBounds(314, 10, 89, 23);

		frame.getContentPane().add(btnSumar);
	}
}
