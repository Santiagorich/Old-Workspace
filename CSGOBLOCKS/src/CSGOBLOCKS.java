import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CSGOBLOCKS {

	private JFrame frmBlockfaces;
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	public int ch=0;
	public String BlockFaces="";
	public String BlockSelector="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CSGOBLOCKS window = new CSGOBLOCKS();
					window.frmBlockfaces.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CSGOBLOCKS() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBlockfaces = new JFrame();
		frmBlockfaces.setBounds(100, 100, 450, 300);
		frmBlockfaces.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBlockfaces.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 434, 261);
		frmBlockfaces.getContentPane().add(tabbedPane);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Recopilar", null, panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Raw", null, panel_2, null);
		panel_2.setLayout(null);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Arial", Font.BOLD, 20));
		textArea_1.setEditable(false);
		textArea_1.setForeground(Color.BLACK);
		textArea_1.setBounds(0, 118, 429, 110);
		panel_2.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setFont(new Font("Arial", Font.BOLD, 20));
		textArea_2.setEditable(false);
		textArea_2.setForeground(Color.BLACK);
		textArea_2.setBounds(0, 2, 429, 110);
		panel_2.add(textArea_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setForeground(Color.BLACK);
		textArea.setBackground(null);
		textArea.setBounds(10, 11, 404, 25);
		panel_3.add(textArea);
		textArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

					if(ch==1){
					frmBlockfaces.setTitle("BlockFaces");
					textArea.setText(BlockFaces);
					ch=0;
					}
					else{
					frmBlockfaces.setTitle("BlockSelector");
					textArea.setText(BlockSelector);
					ch=1;
					}
					
			}
		});
		textArea.setFont(new Font("Arial", Font.BOLD, 20));
		textArea.setRows(1);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(217, 47, 197, 175);
		panel_3.add(panel);
		panel.setLayout(null);
		
		JButton btnPopface = new JButton("PopFace");
		btnPopface.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BlockFaces=" P"+BlockFaces;
				textArea.setText(BlockFaces);
				textArea_2.setText(BlockFaces);
				if(ch==1){
					textArea.setText(BlockSelector);
					}
			}
		});
		btnPopface.setForeground(Color.WHITE);
		btnPopface.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnPopface.setBounds(10, 11, 178, 42);
		panel.add(btnPopface);
		
		JButton btnHappyface = new JButton("HappyFace");
		btnHappyface.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BlockFaces=" H"+BlockFaces;
				textArea.setText(BlockFaces);
				textArea_2.setText(BlockFaces);
				if(ch==1){
					textArea.setText(BlockSelector);
					}
			}
		});
		btnHappyface.setForeground(Color.GREEN);
		btnHappyface.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnHappyface.setBounds(10, 65, 178, 42);
		panel.add(btnHappyface);
		
		JButton btnAngryface = new JButton("AngryFace");
		btnAngryface.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BlockFaces=" A"+BlockFaces;
				textArea.setText(BlockFaces);
				textArea_2.setText(BlockFaces);
				if(ch==1){
					textArea.setText(BlockSelector);
					}
			}
		});
		btnAngryface.setForeground(Color.RED);
		btnAngryface.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnAngryface.setBounds(10, 119, 178, 42);
		panel.add(btnAngryface);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 47, 198, 175);
		panel_3.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("2x");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BlockSelector=" 2x"+BlockSelector;
				textArea_1.setText(BlockSelector);
				if(ch!=1){
					textArea.setText(BlockSelector);
					}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setBounds(10, 16, 178, 23);
		panel_1.add(btnNewButton);
		
		JButton btnx = new JButton("3x");
		btnx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BlockSelector=" 3x"+BlockSelector;
				textArea_1.setText(BlockSelector);
				if(ch!=1){
				textArea.setText(BlockSelector);
				}
				}
		});
		btnx.setForeground(Color.YELLOW);
		btnx.setFont(new Font("Tahoma", Font.BOLD, 17));

		btnx.setBounds(10, 55, 178, 23);
		panel_1.add(btnx);
		
		JButton btnx_1 = new JButton("4x");
		btnx_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BlockSelector=" 4x"+BlockSelector;
				textArea_1.setText(BlockSelector);
				if(ch!=1){
					textArea.setText(BlockSelector);
					}
			}
		});
		btnx_1.setForeground(Color.ORANGE);
		btnx_1.setFont(new Font("Tahoma", Font.BOLD, 17));

		btnx_1.setBounds(10, 94, 178, 23);
		panel_1.add(btnx_1);
		
		JButton btnx_2 = new JButton("20x");
		btnx_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BlockSelector=" 20x"+BlockSelector;
				textArea_1.setText(BlockSelector);
				if(ch!=1){
					textArea.setText(BlockSelector);
					}
			}
		});
		btnx_2.setForeground(Color.RED);
		btnx_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnx_2.setBounds(10, 133, 178, 23);
		panel_1.add(btnx_2);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 114, 429, 2);
		panel_2.add(separator);
	}
}
