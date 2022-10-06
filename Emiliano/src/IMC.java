import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class IMC {
	static double a = 0;
	static double p = 0;
	static double imc = 0;
	static boolean r = true;
	private JFrame frmCalcular;
	private JTextField tfp;
	private JTextField tfa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IMC window = new IMC();
					window.frmCalcular.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IMC() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalcular = new JFrame();
		frmCalcular.setTitle("Calcular IMC");
		frmCalcular.setType(Type.UTILITY);
		frmCalcular.setBounds(100, 100, 114, 146);
		frmCalcular.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalcular.getContentPane().setLayout(null);
		
		tfp = new JTextField();
		tfp.setBounds(53, 11, 46, 20);
		frmCalcular.getContentPane().add(tfp);
		tfp.setColumns(10);
		
		tfa = new JTextField();
		tfa.setBounds(53, 42, 46, 20);
		frmCalcular.getContentPane().add(tfa);
		tfa.setColumns(10);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(10, 14, 46, 14);
		frmCalcular.getContentPane().add(lblPeso);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setBounds(10, 45, 46, 14);
		frmCalcular.getContentPane().add(lblAltura);
		
		JButton btnNewButton = new JButton("IMC");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do{
					while(r==true){
				try {
					a=Double.parseDouble(tfa.getText());
					if (a>0.17&&a<2.72){
						break;
					}
					else{
					JOptionPane.showMessageDialog(null, "La altura no puede ser menor a 0,17mts o mayor a 2,72mts","Error",JOptionPane.ERROR_MESSAGE);
					tfa.setText("");
					tfp.setText("");
					}
					
					
				
					
					p=Double.parseDouble(tfp.getText());
					if (p>0.200&&p>600){
						r=false;
						break;
					}
					else{
					JOptionPane.showMessageDialog(null, "El peso no puede ser menor a 200grs o mayor a 600Kgs","Error",JOptionPane.ERROR_MESSAGE);
					tfa.setText("");
					tfp.setText("");
					}
				}
				
					
					
				catch (Exception NumberFormatException){
					JOptionPane.showMessageDialog(null, "Error en el ingreso de los datos","Error",JOptionPane.ERROR_MESSAGE);
					tfa.setText("");
					tfp.setText("");
					
				}
					}
				if(r==false){
				imc=(p/(a*a));
				if (imc<20){
					JOptionPane.showMessageDialog(null, "Estado Nutricional: Bajo peso\n IMC= " + String.format("%.2f", imc) );
				}
				else if (imc>=20&&imc<=25){
					JOptionPane.showMessageDialog(null, "Estado Nutricional: Normal\n IMC= " + String.format("%.2f", imc) );
				}
				else if (imc>=25&&imc<=27.5){
					JOptionPane.showMessageDialog(null, "Estado Nutricional: Sobrepeso\n IMC= " + String.format("%.2f", imc) );
				}
				else if (imc>=27.5&&imc<=29.9){
					JOptionPane.showMessageDialog(null, "Estado Nutricional: Obesidad Leve (Tipo I)\n IMC= " + String.format("%.2f", imc) );
				}
				else if (imc>=29.9&&imc<=39.9){
					JOptionPane.showMessageDialog(null, "Estado Nutricional: Obesidad Moderada (Tipo II)\n IMC= " + String.format("%.2f", imc) );
				}
				else {
					JOptionPane.showMessageDialog(null, "Estado Nutricional: Obesidad Severa (Tipo III)\n IMC= " + String.format("%.2f", imc) );
				}
				}
			}
				while(r=true);}
		});
		
		
		btnNewButton.setBounds(31, 73, 61, 23);
		frmCalcular.getContentPane().add(btnNewButton);
	}
}
