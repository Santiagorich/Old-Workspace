import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Separador {
	static int contador=0;
	static String[] linea;
	static String[] texto;
	private JFrame frame;
	private JTextField textField;
	private JTextField txtProgramas;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Separador window = new Separador();
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
	public Separador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(100, 100, 398, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setText("-->");
		textField.setBounds(82, 8, 62, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 158, 80);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(178, 36, 194, 80);
		frame.getContentPane().add(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		
		txtProgramas = new JTextField();
		txtProgramas.setText("Programas");
		txtProgramas.setBounds(234, 8, 86, 20);
		frame.getContentPane().add(txtProgramas);
		txtProgramas.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(234, 127, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblSeparador = new JLabel("Separador:");
		lblSeparador.setBounds(10, 11, 62, 14);
		frame.getContentPane().add(lblSeparador);
		
		JButton btnNewButton = new JButton("Separar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String separador=textField.getText();
				linea=textArea.getText().split("\\n");
				while(contador<linea.length){
					if(linea[contador].contains("[Not found]")==true){
						texto=linea[contador].split(separador);
						textArea_1.append(" Not Found");
						contador++;	
					}else{
						texto=linea[contador].split(separador);
						textArea_1.append(texto[1]);
						contador++;	
						System.out.println(texto.length);
					}
					
				
				}
				contador=0;
			}
		});
		btnNewButton.setBounds(10, 127, 158, 23);
		frame.getContentPane().add(btnNewButton);
		JLabel lblCarpeta = new JLabel("Carpeta:");
		lblCarpeta.setBounds(178, 11, 46, 14);
		frame.getContentPane().add(lblCarpeta);
		
		JLabel lblSub = new JLabel("Sub:");
		lblSub.setBounds(178, 131, 46, 14);
		frame.getContentPane().add(lblSub);
	}
}
