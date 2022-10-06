import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;

public class Ayuda {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblPeso;
	private JLabel lblDireccion;
	private double precio=0;
	private JLabel lbprecio;
	private JLabel lbiva;
	private JLabel lbtotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ayuda window = new Ayuda();
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
	public Ayuda() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\santiago\\Downloads\\ADUANA\\calculation-icon_31858.png"));
		frame.getContentPane().setBackground(new Color(160, 82, 45));
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 451, 145);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBackground(Color.YELLOW);
		textField.setForeground(Color.BLACK);
		textField.setBounds(10, 42, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(Color.YELLOW);
		textField_1.setBounds(106, 42, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBackground(Color.YELLOW);
		textField_2.setBounds(202, 42, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 17, 86, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\santiago\\Downloads\\ADUANA\\calculation-icon_31858.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Double.parseDouble(textField_2.getText());
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "El peso debe ser un numero");
				}
				try{
					Double.parseDouble(textField.getText());
				}catch(NumberFormatException b){
					if (Double.parseDouble(textField_2.getText())<=2 && Double.parseDouble(textField_2.getText())>90){
						JOptionPane.showMessageDialog(null, "El peso debe estar entre 2 gramos - 90 kilos");
						textField_2.setText("");
					}else{
					if (textField_1.getText().length()<1){
						JOptionPane.showMessageDialog(null, "El campo de Direccion no puede estar vacio");
						textField_1.setText("");
					}else{
					if (textField.getText().length()<1){
						JOptionPane.showMessageDialog(null, "El campo de Nombre no puede estar vacio");
						textField.setText("");
					}else{
						lbprecio.setText(String.valueOf((Double.parseDouble(textField_2.getText())*28)));
						lbiva.setText(String.valueOf((Double.parseDouble(textField_2.getText())*28)*0.22));
						lbtotal.setText(String.valueOf((Double.parseDouble(textField_2.getText())*28))+String.valueOf((Double.parseDouble(textField_2.getText())*28)*0.22));
					}
					}
					}
				}
				}
				
			}
		});
		btnNewButton.setBounds(338, 17, 86, 47);
		frame.getContentPane().add(btnNewButton);
		
		lblPeso = new JLabel("Peso (kg)");
		lblPeso.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		lblPeso.setBounds(202, 17, 86, 14);
		frame.getContentPane().add(lblPeso);
		
		lblDireccion = new JLabel("Direccion");
		lblDireccion.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		lblDireccion.setBounds(106, 17, 86, 14);
		frame.getContentPane().add(lblDireccion);
		
		lbprecio = new JLabel("");
		lbprecio.setBounds(20, 73, 46, 14);
		frame.getContentPane().add(lbprecio);
		
		lbiva = new JLabel("");
		lbiva.setBounds(106, 73, 46, 14);
		frame.getContentPane().add(lbiva);
		
		lbtotal = new JLabel("");
		lbtotal.setBounds(202, 73, 46, 14);
		frame.getContentPane().add(lbtotal);
	}
}
