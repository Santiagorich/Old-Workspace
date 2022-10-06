import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Gui {

	private JFrame frame;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
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
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 579, 455);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(140, 11, 413, 394);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Ebrou", null, panel, null);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Santander", null, panel_1, null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Prex", null, panel_2, null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_2.add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		
		JButton btnNewButton = new JButton("Refresh");
		btnNewButton.setBounds(10, 13, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Ebrou");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 47, 89, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Santander");
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 97, 89, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Prex");
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 147, 89, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("-");
		lblNewLabel_3.setBounds(10, 72, 89, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("-");
		lblNewLabel_4.setBounds(10, 122, 89, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("-");
		lblNewLabel_5.setBounds(10, 172, 89, 14);
		frame.getContentPane().add(lblNewLabel_5);
	}
}
