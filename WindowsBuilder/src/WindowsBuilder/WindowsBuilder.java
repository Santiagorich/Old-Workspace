package WindowsBuilder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WindowsBuilder extends JFrame {

	private JPanel contentPane;
	private JTextField mercaderia;
	private JTextField precio;
	private JTextField cantidad;
	private JLabel lblSubtotal;
	private JTextField subtotal;
	private JLabel lblIva;
	private JLabel lblDescuento;
	private JTextField iva;
	private JTextField descuento;
	private JLabel lblCostoDeEntrega;
	private JTextField entrega;
	private JLabel lblTotal;
	private JTextField total;
	private JLabel nombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowsBuilder frame = new WindowsBuilder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WindowsBuilder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nombre = new JLabel("");
		nombre.setHorizontalAlignment(SwingConstants.CENTER);
		nombre.setBounds(124, 129, 86, 14);
		contentPane.add(nombre);

		JLabel lblNombreMercadera = new JLabel("Nombre Mercader\u00EDa");
		lblNombreMercadera.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreMercadera.setBounds(32, 22, 124, 14);
		contentPane.add(lblNombreMercadera);

		mercaderia = new JTextField();
		mercaderia.setBounds(172, 19, 86, 20);
		contentPane.add(mercaderia);
		mercaderia.setColumns(10);

		JLabel lblPreciou = new JLabel("Precio (u)");
		lblPreciou.setHorizontalAlignment(SwingConstants.CENTER);
		lblPreciou.setBounds(53, 47, 79, 14);
		contentPane.add(lblPreciou);

		precio = new JTextField();
		precio.setBounds(172, 44, 86, 20);
		contentPane.add(precio);
		precio.setColumns(10);

		JLabel lblCantidad = new JLabel("Cantidad ");
		lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad.setBounds(63, 72, 69, 14);
		contentPane.add(lblCantidad);

		cantidad = new JTextField();
		cantidad.setBounds(172, 75, 86, 20);
		contentPane.add(cantidad);
		cantidad.setColumns(10);

		JButton btnSubtotal = new JButton("Subtotal");
		btnSubtotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				double c = 0, p = 0, opiva=0,frecuencia=0,op=0;
				boolean evento1 = false, evento2 = false;
				int respuesta=0,respuesta2=0,respuestamodalidad=0,respuestamodalidad2=0,respuestaenvio=0,respuestaenvio2=0;
				
				//_Nombre Mercaderia
				
				
				
				//_Precio
				try {

					p = Double.parseDouble(precio.getText());
					evento1 = true;
					
					if (p <= 0) {
						JOptionPane.showMessageDialog(null, "El precio debe ser mayor a 0", "Error...",
								JOptionPane.ERROR_MESSAGE);
						precio.setText("");

					
					}
				} catch (java.lang.NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Error en el ingreso del Precio", "Error",
							JOptionPane.ERROR_MESSAGE);
					precio.setText("");
					evento1 = false;

				}
				//_Cantidad
				try {

					c = Double.parseDouble(cantidad.getText());
					evento2 = true;
					if (c <= 0) {
						JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor a 0", "Error...",
								JOptionPane.ERROR_MESSAGE);
						cantidad.setText("");

					}
				} catch (java.lang.NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Error en el ingreso de la Cantidad", "Error",
							JOptionPane.ERROR_MESSAGE);
					cantidad.setText("");
					evento2 = false;

				}
				
				//Modalidad_IVA
				String iva[] = { "Exento", "Canasta Familiar", "Común" };
				do{
					respuesta = JOptionPane.showOptionDialog(null, "Seleccione la Opción...", "Seleccionar...", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, iva, null);
					System.out.println(respuesta);
					if(respuesta==-1){
						int salir=JOptionPane.showConfirmDialog(null, "¿Desea Salir?","Salir...",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					if(salir==0){
						System.exit(0);
						}
					}
					}while(respuesta2==-1);
				
				frecuencia=JOptionPane.showConfirmDialog(null, "¿Es frecuente?","Frecuencia...",JOptionPane.YES_NO_OPTION);
					nombre.setText(mercaderia.getText());
				
				
				//Modalidad_Pago	
				String modalidadpago[] = { "Efectivo", "Tarjeta", "Cheque","Cheque a 30 días" };
					do{
						respuesta = JOptionPane.showOptionDialog(null, "Seleccione modalidad de Pago...", "Seleccionar...", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,modalidadpago, null);
						if(respuestamodalidad==-1){
							int salir=JOptionPane.showConfirmDialog(null, "¿Desea Salir?","Salir...",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						if(salir==0){
							System.exit(0);
							}
						}
						}while(respuestamodalidad2==-1);
				
				//_Entrega
					
					String modalidadenvio[] = { "Dentro de Montevideo", "Zona Metropolitana", "Fuera de Montevideo","Mostrador" };
					do{
						respuestaenvio = JOptionPane.showOptionDialog(null, "Seleccione entrega de Mercaderia...", "Seleccionar...", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,modalidadenvio, null);
						if(respuestaenvio==-1){
							int salir=JOptionPane.showConfirmDialog(null, "¿Desea Salir?","Salir...",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						if(salir==0){
							System.exit(0);
							}
						}
						}while(respuestaenvio2==-1);
					
				
				
					
					
					
					
					//_Cuentas
					
					//if_Subtotal
					if(evento1 && evento2){
					
						op=c*p;
						subtotal.setText(String.valueOf(op));
					
					if(respuesta==1){
						respuesta=respuesta+(respuesta*0.14);
					subtotal.setText(String.valueOf(op));
						
					}
						
						
						
					
				}
				
				
				
				
				

			}
		});
		btnSubtotal.setBounds(303, 43, 89, 23);
		contentPane.add(btnSubtotal);
		
		lblSubtotal = new JLabel("Subtotal");
		lblSubtotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtotal.setBounds(53, 158, 46, 14);
		contentPane.add(lblSubtotal);
		
		subtotal = new JTextField();
		subtotal.setBounds(124, 152, 86, 20);
		contentPane.add(subtotal);
		subtotal.setColumns(10);
		
		lblIva = new JLabel("IVA");
		lblIva.setHorizontalAlignment(SwingConstants.CENTER);
		lblIva.setBounds(53, 183, 46, 14);
		contentPane.add(lblIva);
		
		lblDescuento = new JLabel("Descuento");
		lblDescuento.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescuento.setBounds(32, 208, 79, 14);
		contentPane.add(lblDescuento);
		
		iva = new JTextField();
		iva.setBounds(124, 180, 86, 20);
		contentPane.add(iva);
		iva.setColumns(10);
		
		descuento = new JTextField();
		descuento.setBounds(124, 205, 86, 20);
		contentPane.add(descuento);
		descuento.setColumns(10);
		
		lblCostoDeEntrega = new JLabel("Costo de Entrega");
		lblCostoDeEntrega.setHorizontalAlignment(SwingConstants.CENTER);
		lblCostoDeEntrega.setBounds(10, 233, 112, 14);
		contentPane.add(lblCostoDeEntrega);
		
		entrega = new JTextField();
		entrega.setBounds(124, 230, 86, 20);
		contentPane.add(entrega);
		entrega.setColumns(10);
		
		lblTotal = new JLabel("Total");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setBounds(256, 190, 46, 14);
		contentPane.add(lblTotal);
		
		total = new JTextField();
		total.setBounds(316, 187, 86, 20);
		contentPane.add(total);
		total.setColumns(10);
	}
}
