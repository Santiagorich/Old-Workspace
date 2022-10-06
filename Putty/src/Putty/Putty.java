package Putty;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Putty {
	static String ip ="10.0.29.6";
	private JFrame frame;
	private JTextField Nombre;
	private JTextField Contraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Putty window = new Putty();
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
	public Putty() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 193, 145);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Nombre = new JTextField();
		Nombre.setBounds(81, 11, 86, 20);
		frame.getContentPane().add(Nombre);
		Nombre.setColumns(10);
		
		Contraseña = new JTextField();
		Contraseña.setBounds(81, 42, 86, 20);
		frame.getContentPane().add(Contraseña);
		Contraseña.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		          try {
					Runtime.getRuntime().exec("cmd /c echo putty.exe "+ Nombre.getText() +"@" + ip + " "+ "-pw " + Contraseña.getText() + ">>Putty.bat");
			        Runtime.getRuntime().exec("cmd /c Bat_To_Exe_Converter.exe - bat Putty.bat -save Putty.exe -invisible ");
				} catch (IOException e1) {
				}
			}
		});
		btnNewButton.setBounds(43, 73, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(10, 14, 61, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setBounds(10, 45, 61, 14);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
