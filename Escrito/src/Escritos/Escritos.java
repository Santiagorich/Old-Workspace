package Escritos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;

public class Escritos {
	static boolean error=false;
	static double sub=0;
	static int op=0;
	static String texto="";
	private JFrame frame;
	private JTextField nombre;
	private JTextField cantidad;
	private JTextField precio;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JComboBox pagob;
	private JLabel lblMetodoDePago;
	private JLabel lblIva;
	private JLabel lblEntrega;
	private JComboBox entregab;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Escritos window = new Escritos();
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
	public Escritos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 476, 158);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		nombre = new JTextField();
		nombre.setBounds(84, 11, 86, 20);
		frame.getContentPane().add(nombre);
		nombre.setColumns(10);
		
		JComboBox ivab = new JComboBox();
		ivab.setModel(new DefaultComboBoxModel(new String[] {"Extento", "Canasta Familiar", "Comun"}));
		ivab.setBounds(280, 11, 172, 20);
		frame.getContentPane().add(ivab);
		
		cantidad = new JTextField();
		cantidad.setBounds(84, 37, 86, 20);
		frame.getContentPane().add(cantidad);
		cantidad.setColumns(10);
		
		JCheckBox freq = new JCheckBox("Cliente Frequente");
		freq.setBounds(280, 92, 172, 23);
		frame.getContentPane().add(freq);
		
		precio = new JTextField();
		precio.setBounds(84, 62, 86, 20);
		frame.getContentPane().add(precio);
		precio.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 11, 64, 14);
		frame.getContentPane().add(lblNombre);
		
		lblNewLabel = new JLabel("Cantidad:");
		lblNewLabel.setBounds(10, 37, 64, 14);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Precio:");
		lblNewLabel_1.setBounds(10, 62, 64, 14);
		frame.getContentPane().add(lblNewLabel_1);
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Double.parseDouble(precio.getText());
					error=false;
				}catch(Exception NumberFormatException){
					JOptionPane.showMessageDialog(null, "Error en el ingreso del precio", "Error", JOptionPane.ERROR_MESSAGE);
					precio.setText("");
					error=true;
				}
				try{
					Double.parseDouble(cantidad.getText());
					error=false;
				}catch(Exception NumberFormatException){
					JOptionPane.showMessageDialog(null, "Error en el ingreso de la cantidad", "Error", JOptionPane.ERROR_MESSAGE);
					cantidad.setText("");
					error=true;
				}
				if (error!=true){
				if(nombre.getText().equals("")){
					JOptionPane.showMessageDialog(null, "El nombre no puede estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else{
					if (Double.parseDouble(precio.getText())<0){
						JOptionPane.showMessageDialog(null, "El precio no puede ser menor o igual a 0", "Error", JOptionPane.ERROR_MESSAGE);
						precio.setText("");
					}
					else{
						if (Double.parseDouble(cantidad.getText())<0){
							JOptionPane.showMessageDialog(null, "La cantidad no puede ser menor o igual a 0", "Error", JOptionPane.ERROR_MESSAGE);
						cantidad.setText("");
						}
						else{
							sub=Double.parseDouble(precio.getText())*Double.parseDouble(cantidad.getText());
							texto="Subtotal: " + sub;
							if (freq.isSelected()==true){
								sub=sub-sub*0.10;
								texto= texto + "\nDescuento por ser un cliente frequente: " + Math.round(sub*0.10);
							}
							op=ivab.getSelectedIndex();
							switch (op){
							case 0: //Extento
								sub=sub;
								texto=texto+"\nIVA : 0";
								break;
							case 1: //Canasta Familiar
								sub=sub+sub*0.14;
								texto=texto+"\nIVA : " + Math.round(sub*0.14);
								break;
							case 2: //Comun
								sub=sub+sub*0.22;	
								texto=texto+"\nIVA : " + Math.round(sub*0.22);
								break;
							}
							op=pagob.getSelectedIndex();
							switch (op){
							case 0: //Efectivo
								sub=sub-sub*0.03;
								texto=texto+"\nDescuento por pagar "+pagob.getSelectedItem() +" : " + Math.round(sub*0.03);
								break;
							case 1: //Tarjeta
								sub=sub+sub*0.03;
								texto=texto+"\nRecargo por pagar "+pagob.getSelectedItem() +" : " + Math.round(sub*0.03);
								break;
							case 2: //Cheque al portador
								sub=sub-sub*0.02;
								texto=texto+"\nDescuento por pagar "+pagob.getSelectedItem() +" : " + Math.round(sub*0.02);
								break;
							case 3: //Cheque a 30 días
								sub=sub+sub*0.045;
								texto=texto+"\nRecargo por pagar "+pagob.getSelectedItem() +" : " + Math.round(sub*0.045);
								break;
							}
							
							op=entregab.getSelectedIndex();
							switch (op){
							case 0: //Dentro de montevideo
								sub=sub-sub*0.10;
								texto=texto+"\nCosto de entrega: " + Math.round(sub*0.10);
								break;
							case 1:	//Zona metropolitana
								sub=sub+sub*0.13;
								texto=texto+"\nCosto de entrega: " + Math.round(sub*0.13);
								break;
							case 2: //Fuera de montevideo
								sub=sub+sub*0.15;
								texto=texto+"\nCosto de entrega: " + Math.round(sub*0.15);
								break;
							case 3: //Mostrador
								texto=texto+"\nCosto de entrega: 0";
								break;
							}
							JOptionPane.showMessageDialog(null, texto + "\nTotal: " + Math.round(sub), "Resultado", JOptionPane.INFORMATION_MESSAGE);
							}
							
						}
					}
				}
			}
		});
		btnNewButton.setBounds(20, 93, 238, 20);
		frame.getContentPane().add(btnNewButton);
		
		pagob = new JComboBox();
		pagob.setModel(new DefaultComboBoxModel(new String[] {"En efectivo", "Con tarjeta", "Con cheque al portador", "Con cheque a 30 d\u00EDas"}));
		pagob.setBounds(280, 37, 172, 20);
		frame.getContentPane().add(pagob);
		
		lblMetodoDePago = new JLabel("Metodo de pago:");
		lblMetodoDePago.setBounds(180, 40, 128, 14);
		frame.getContentPane().add(lblMetodoDePago);
		
		lblIva = new JLabel("IVA:");
		lblIva.setBounds(180, 14, 86, 14);
		frame.getContentPane().add(lblIva);
		
		lblEntrega = new JLabel("Entrega:");
		lblEntrega.setBounds(180, 65, 86, 14);
		frame.getContentPane().add(lblEntrega);
		
		entregab = new JComboBox();
		entregab.setModel(new DefaultComboBoxModel(new String[] {"Dentro de montevideo", "Zona metropolitana", "Fuera de montevideo", "Mostrador"}));
		entregab.setBounds(280, 62, 172, 20);
		frame.getContentPane().add(entregab);
	}
}
