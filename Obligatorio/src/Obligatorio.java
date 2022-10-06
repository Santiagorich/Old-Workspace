import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Obligatorio {

	public static String nombres[] = new String[1000];
	public static String pass[] = new String[1000];
	public static int contador = 2;
	public static int intentos = 0;
	private JFrame frame;
	private JFrame frame2;
	private JFrame frame3;
	private JFrame frame4;
	private JFrame frame5;
	private JFrame frame6;
	private JPasswordField passwordField_1;
	private JTextField textField;
	private JTextField textFieldnm;
	private JPasswordField passwordField;
	private JButton btncrcuenta;
	private JLabel lblPorfavorLlameAl;
	private JLabel lblCel;
	private JLabel lblCuentaCreadaCon;
	private JButton btnAceptar2;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Obligatorio window = new Obligatorio();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @return
	 */

	public Obligatorio() {
		ventana4 vent = new ventana4();
		initialize();
		initialize2();
		initialize3();
		initialize5();
		initialize6();
		vent.initialize4();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize6() {
		frame6 = new JFrame();
		frame6.setTitle("Cuenta creada con exito!");
		frame6.setBounds(100, 100, 463, 190);
		frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame6.getContentPane().setLayout(null);
		
		lblCuentaCreadaCon = new JLabel("Cuenta creada con exito!");
		lblCuentaCreadaCon.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuentaCreadaCon.setFont(new Font("Stencil", Font.PLAIN, 24));
		lblCuentaCreadaCon.setBounds(10, 11, 427, 105);
		frame6.getContentPane().add(lblCuentaCreadaCon);
		
		btnAceptar2 = new JButton("Aceptar");
		btnAceptar2.setBounds(172, 117, 89, 23);
		frame6.getContentPane().add(btnAceptar2);
		btnAceptar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent n) {
				frame6.setVisible(false);
				frame4.setVisible(false);
			}});
	}
	public class ventana4 {
//Crear Cuenta
		public void initialize4() {

			frame4 = new JFrame();
			frame4.setBounds(100, 100, 463, 174);
			frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame4.getContentPane().setLayout(null);

			JLabel lblNombreDeUsuariocr = new JLabel("Nombre de usuario:");
			lblNombreDeUsuariocr.setBounds(10, 11, 147, 14);
			frame4.getContentPane().add(lblNombreDeUsuariocr);

			JLabel lblContraseacr = new JLabel("Contrase\u00F1a:");
			lblContraseacr.setBounds(10, 72, 147, 14);
			frame4.getContentPane().add(lblContraseacr);

			textFieldnm = new JTextField();
			textFieldnm.setBounds(10, 36, 204, 20);
			frame4.getContentPane().add(textFieldnm);
			textFieldnm.setColumns(10);

			passwordField = new JPasswordField();
			passwordField.setBounds(10, 97, 204, 20);
			frame4.getContentPane().add(passwordField);
			passwordField.setColumns(10);

			btncrcuenta = new JButton("Crear cuenta!");
			btncrcuenta.setFont(new Font("Stencil", Font.PLAIN, 16));
			btncrcuenta.setBounds(263, 36, 174, 60);
			btncrcuenta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent n) {
					nombres[contador] = textFieldnm.getText();
					pass[contador] = (String.valueOf(passwordField.getPassword()));
					contador++;
					frame6.setVisible(true);

				}
			});
			frame4.getContentPane().add(btncrcuenta);
		}
	}
	//Intentos
		private void initialize5() {
			frame5 = new JFrame();
			frame5.setTitle("Limite de intentos alcanzado!");
			frame5.setBounds(100, 100, 463, 190);
			frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame5.getContentPane().setLayout(null);
			
			lblPorfavorLlameAl = new JLabel("Porfavor llame al servicio tecnico");
			lblPorfavorLlameAl.setHorizontalAlignment(SwingConstants.CENTER);
			lblPorfavorLlameAl.setFont(new Font("Stencil", Font.PLAIN, 16));
			lblPorfavorLlameAl.setBounds(10, 11, 427, 56);
			frame5.getContentPane().add(lblPorfavorLlameAl);
			
			lblCel = new JLabel("Cel: 094418518");
			lblCel.setFont(new Font("Stencil", Font.PLAIN, 23));
			lblCel.setHorizontalAlignment(SwingConstants.CENTER);
			lblCel.setBounds(10, 78, 427, 43);
			frame5.getContentPane().add(lblCel);
		}
		//Incorrecto
	private void initialize3() {
		frame3 = new JFrame();
		frame3.setBounds(100, 100, 284, 137);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.getContentPane().setLayout(null);

		JLabel lblIncorrecto = new JLabel("Nombre de usuario o contrase\u00F1a incorrecto");
		lblIncorrecto.setFont(new Font("Stencil", Font.PLAIN, 10));
		lblIncorrecto.setBounds(10, 11, 268, 55);
		frame3.getContentPane().add(lblIncorrecto);

		JButton btnReintentar = new JButton("Reintentar");
		btnReintentar.setBounds(74, 64, 118, 23);
		frame3.getContentPane().add(btnReintentar);
		btnReintentar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent r) {
				frame3.setVisible(false);
			}
		});
	}
//Exito
	private void initialize2() {
		frame2 = new JFrame();
		frame2.setBounds(100, 100, 284, 137);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		frame2.setTitle("Usted ha ingresado con exito!");
		JLabel lblUstedHaIngresado = new JLabel("Usted ha ingresado con exito!");
		lblUstedHaIngresado.setFont(new Font("Stencil", Font.PLAIN, 13));
		lblUstedHaIngresado.setBounds(25, 11, 268, 55);
		frame2.getContentPane().add(lblUstedHaIngresado);

		JButton btnAceptar = new JButton("Continuar");
		btnAceptar.setBounds(81, 64, 89, 23);
		frame2.getContentPane().add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent n) {

			}
		});
	}
		//Login
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 326, 270);
		frame.setTitle("Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(38, 127, 236, 28);
		frame.getContentPane().add(passwordField_1);

		JLabel lblUsuario = DefaultComponentFactory.getInstance().createLabel("Usuario:");
		lblUsuario.setBounds(38, 38, 92, 14);
		frame.getContentPane().add(lblUsuario);

		JLabel lblContrasea = DefaultComponentFactory.getInstance().createLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(38, 102, 92, 14);
		frame.getContentPane().add(lblContrasea);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char clave[] = passwordField_1.getPassword();

				String clavedef = new String(clave);
				if (clavedef=="123" && textField.getText()=="admin"){
					Obligatorio ventana = new Obligatorio();
					ventana.frame2.setVisible(true);
				}
					else{
				if (Arrays.asList (nombres).contains(textField.getText()) && Arrays.asList(pass).contains(clavedef)) {

					Obligatorio ventana = new Obligatorio();
					ventana.frame2.setVisible(true);
					
				
				} else {
					if (intentos==2){
						frame5.setVisible(true);
					}
					else{
					Obligatorio ventana2 = new Obligatorio();
					ventana2.frame3.setVisible(true);
					intentos++;
				}}}
			}}
		);

		btnNewButton.setBounds(106, 188, 89, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnCuentaNueva = new JButton("Cuenta nueva");
		btnCuentaNueva.setBounds(152, 11, 122, 28);
		btnCuentaNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent n) {
				Obligatorio ventana3 = new Obligatorio();
				ventana3.frame4.setVisible(true);
			}
		});
		frame.getContentPane().add(btnCuentaNueva);

		textField = new JTextField();
		textField.setBounds(38, 63, 236, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
