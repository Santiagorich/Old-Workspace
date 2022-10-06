package Clip;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JRootPane;

import java.awt.Window.Type;
import javax.swing.JTextField;
import java.awt.Dialog.ModalExclusionType;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class ClipBoard {

	private JFrame frmCli;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClipBoard window = new ClipBoard();
					window.frmCli.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClipBoard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws IOException
	 * @throws UnsupportedFlavorException
	 */
	private void initialize() {
		frmCli = new JFrame();
		frmCli.setType(Type.UTILITY);
		frmCli.setAlwaysOnTop(true);
		frmCli.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCli.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{frmCli.getContentPane()}));
		frmCli.setSize(526, 178);
		frmCli.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 606, 178);
		frmCli.getContentPane().add(scrollPane);
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		frmCli.setUndecorated(true);
		frmCli.getRootPane().setWindowDecorationStyle(JRootPane.NONE);


		try {
			int contador=0;
			double altura=0;
			int Int=0;
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Clipboard clipboard = toolkit.getSystemClipboard();
			String [] result;
			result = clipboard.getData(DataFlavor.stringFlavor).toString().split("\r\n");
			System.out.println(result.length);
			while (contador<=result.length){
			textArea.append(result[contador]);
			altura=altura+frmCli.getSize().getHeight();
			Int=(int) altura;
			frmCli.setSize(467, Int);
			}
			
		} catch (UnsupportedFlavorException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
