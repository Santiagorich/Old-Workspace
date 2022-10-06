package vrplog;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import vrplog.Metodos;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login {

	public static JFrame frame;
	public static JTextField textField;
	public static JPasswordField passwordField;
	public static String pass;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent a) {
				int op = JOptionPane.showConfirmDialog(null, "Esta seguro de que quiere salir?", "Salir",
						JOptionPane.YES_NO_OPTION);
				if (op == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		frame.setResizable(false);
		frame.setSize(202, 218);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(12, 11, 70, 14);
		frame.getContentPane().add(lblUsuario);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent a) {
				if(a.getKeyCode()==KeyEvent.VK_ENTER){
					pass = new String(passwordField.getPassword());
					Metodos.conectar(pass,textField.getText());
				}
			}
		});
		textField.setBounds(12, 36, 172, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(12, 67, 70, 14);
		frame.getContentPane().add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent a) {
				if(a.getKeyCode()==KeyEvent.VK_ENTER){
					pass = new String(passwordField.getPassword());
					Metodos.conectar(pass,textField.getText());
				}
			}
		});
		passwordField.setBounds(12, 92, 172, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				pass = new String(passwordField.getPassword());
				Metodos.conectar(pass,textField.getText());
			}
		});
		btnLogin.setBounds(53, 147, 89, 23);
		frame.getContentPane().add(btnLogin);

	}
}