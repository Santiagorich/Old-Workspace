package Practico13;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Window.Type;

public class Tarea2 {
	static double subtotal;
	static double total;
	static double iva;
	private JFrame frmCompra;
	private JTextField nombre;
	private JTextField precio;
	private JTextField cantidad;
	private JTextPane textPane = new JTextPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tarea2 window = new Tarea2();
					window.frmCompra.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tarea2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCompra = new JFrame();
		frmCompra.setResizable(false);
		frmCompra.setTitle("Compra");
		frmCompra.setBounds(100, 100, 330, 131);
		frmCompra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCompra.getContentPane().setLayout(null);
		
		nombre = new JTextField();
		nombre.setBounds(85, 11, 86, 20);
		frmCompra.getContentPane().add(nombre);
		nombre.setColumns(10);
		
		precio = new JTextField();
		precio.setBounds(85, 42, 86, 20);
		frmCompra.getContentPane().add(precio);
		precio.setColumns(10);
		
		JCheckBox frecuente = new JCheckBox("Cliente frecuente");
		frecuente.setBounds(177, 10, 127, 23);
		frmCompra.getContentPane().add(frecuente);
		
		cantidad = new JTextField();
		cantidad.setBounds(85, 73, 86, 20);
		frmCompra.getContentPane().add(cantidad);
		cantidad.setColumns(10);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Double.parseDouble(precio.getText());
				}
				catch(Exception NumberFormatException){
					JOptionPane.showMessageDialog(null, "Error en el ingreso del precio");
					precio.setText("");
					
				}
				
				try{
					Double.parseDouble(cantidad.getText());
				}
				catch(Exception NumberFormatException){
					JOptionPane.showMessageDialog(null, "Error en el ingreso de la cantidad");
					cantidad.setText("");
				}
				if (nombre.getText().length()!=0){
				if ((Double.parseDouble(cantidad.getText())>0)){
					
				}
				else{
					JOptionPane.showMessageDialog(null, "La cantidad no puede ser menor o igual a 0");
				}
				if ((Double.parseDouble(precio.getText())>0)){
					if(frecuente.isSelected()==true){
						frmCompra.setBounds(100, 100, 330, 300);
						textPane.setEditable(false);
						textPane.setFont(new Font("Tahoma", Font.BOLD, 11));
						textPane.setForeground(Color.BLACK);
						textPane.setBackground(null);
						textPane.setBounds(10, 101, 294, 150);
						frmCompra.getContentPane().add(textPane);
						subtotal=(Double.parseDouble(precio.getText())*(Double.parseDouble(cantidad.getText()))-subtotal*10/100);
						iva=subtotal*22/100;
						total=(subtotal+iva);
						textPane.setText("Nombre de producto: " + nombre.getText() + "\nPrecio por cada " +nombre.getText()+ ": " +precio.getText()+ "\nCantidad: "+ cantidad.getText() + "\n----------------------------------------------------------------------------------------------------\nPor ser cliente frecuente recibe un 10% de descuento sobre el subtotal!\n----------------------------------------------------------------------------------------------------" + "\nSubtotal: "+ subtotal +"\nIVA: " + iva  + "\nTotal: " + total);
					}
					
					else{
						frmCompra.setBounds(100, 100, 330, 300);
						textPane.setEditable(false);
						textPane.setFont(new Font("Tahoma", Font.BOLD, 15));
						textPane.setForeground(Color.BLACK);
						textPane.setBackground(null);
						textPane.setBounds(10, 101, 294, 150);
						frmCompra.getContentPane().add(textPane);
						subtotal=(Double.parseDouble(precio.getText())*(Double.parseDouble(cantidad.getText())));
						iva=subtotal*22/100;
						total=(subtotal+iva);
						textPane.setText("Nombre de producto: " + nombre.getText() + "\nPrecio por cada " +nombre.getText()+ ": " +precio.getText()+ "\nCantidad: "+ cantidad.getText() +"\n\nSubtotal: "+ subtotal +"\nIVA: " + iva + "\nTotal: " + total);
					}
					
				}
				else{
					JOptionPane.showMessageDialog(null, "El precio no puede ser menor o igual a 0");
				}
				}
				else{
					JOptionPane.showMessageDialog(null, "Ingrese el nombre del producto");
				}
				
				

				
			}
		});
		btnNewButton.setBounds(181, 72, 123, 23);
		frmCompra.getContentPane().add(btnNewButton);
		
		JLabel lblMercaderia = new JLabel("Nombre");
		lblMercaderia.setBounds(10, 14, 71, 14);
		frmCompra.getContentPane().add(lblMercaderia);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 45, 46, 14);
		frmCompra.getContentPane().add(lblPrecio);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 76, 65, 14);
		frmCompra.getContentPane().add(lblCantidad);
		
		
		
	}
}
