import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Font;

public class BlackJack {
int sumaB;
int sumaS;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BlackJack window = new BlackJack();
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
	public BlackJack() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 617, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Arial", Font.BOLD, 40));
		frame.getContentPane().add(textArea, BorderLayout.CENTER);
        textArea.append("           Bautista:"+sumaB+"\n"+"\n"+"\n"+"           Santiago:"+sumaS);		
        JButton btnS = new JButton("Santiago");
        btnS.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sumaS=sumaS+1;
		        textArea.setText("           Bautista:"+sumaB+"\n"+"\n"+"\n"+"           Santiago:"+sumaS);			
			}
		});
		frame.getContentPane().add(btnS, BorderLayout.SOUTH);
		
		JButton btnB = new JButton("Bautista");
		btnB.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(btnB, BorderLayout.NORTH);
		
		
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				sumaB=sumaB+1;
		        textArea.setText("           Bautista:"+sumaB+"\n"+"\n"+"\n"+"           Santiago:"+sumaS);	
			}  
		});
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(btnReset, BorderLayout.WEST);
		btnReset.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent f) {
		sumaB=0;
		sumaS=0;
        textArea.setText("           Bautista:"+sumaB+"\n"+"\n"+"\n"+"           Santiago:"+sumaS);	
	}
		});
}
}
