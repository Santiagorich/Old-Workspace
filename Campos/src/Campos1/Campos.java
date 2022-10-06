package Campos1;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.*;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.net.URL;
import java.net.MalformedURLException;

public class Campos {

	private JFrame frame;
	private JTextField Titulo;
	private JTextField ID;
	private JTextField Autor;
	private JTextField URL;
	private JTextField Imagen;
	private JLabel lblAutor;
	private JLabel lblUrl;
	private JLabel lblImagen;
	private JButton btnNewButton;
	private JButton button;
	private JButton button_1;
	private JButton btnNewButton_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Campos window = new Campos();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Campos() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 452, 337);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Titulo = new JTextField();
		Titulo.setBounds(123, 11, 301, 20);
		frame.getContentPane().add(Titulo);
		Titulo.setColumns(10);

	    ID = new JTextField();
	    ID.setEditable(false);
		ID.setHorizontalAlignment(SwingConstants.CENTER);
		ID.setBounds(123, 45, 86, 20);
		frame.getContentPane().add(ID);
		ID.setColumns(10);
		
		JTextArea Contenido = new JTextArea();
		Contenido.setLineWrap(true);
		Contenido.setBounds(123, 76, 301, 123);
		frame.getContentPane().add(Contenido);
		
		Autor = new JTextField();
		Autor.setBounds(29, 230, 114, 20);
		frame.getContentPane().add(Autor);
		Autor.setColumns(10);
		
		URL = new JTextField();
		URL.setBounds(171, 230, 115, 20);
		frame.getContentPane().add(URL);
		URL.setColumns(10);
		
		Imagen = new JTextField();
		Imagen.setBounds(310, 230, 114, 20);
		frame.getContentPane().add(Imagen);
		Imagen.setColumns(10);
		
		JLabel lblTitulo = new JLabel("T\u00EDtulo:");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitulo.setBounds(75, 12, 38, 14);
		frame.getContentPane().add(lblTitulo);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(92, 46, 21, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contenido:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(44, 130, 69, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblAutor = new JLabel("Autor");
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAutor.setBounds(63, 210, 38, 14);
		frame.getContentPane().add(lblAutor);
		
		lblUrl = new JLabel("URL");
		lblUrl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUrl.setBounds(214, 210, 31, 14);
		frame.getContentPane().add(lblUrl);
		
		lblImagen = new JLabel("Imagen");
		lblImagen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblImagen.setBounds(347, 207, 51, 20);
		frame.getContentPane().add(lblImagen);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(12, 261, 199, 23);
		frame.getContentPane().add(btnConfirmar);
		
		btnNewButton = new JButton("<li>");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Lip=Contenido.getText().replaceAll("<li>", "");
				String Lip2=Lip.replaceAll("</li>", "");
				String Li=Lip2.replaceAll("<p>", "");
				String L=Li.replaceAll("</p>", "");
				String li="<li>"+L+"</li>";
				Contenido.setText(li);
				
			}
		});
		btnNewButton.setBounds(221, 42, 55, 23);
		frame.getContentPane().add(btnNewButton);
		
		button = new JButton("<p>");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Pli=Contenido.getText().replaceAll("<li>", "");
				String Pli2=Pli.replaceAll("</li>", "");
				String P=Pli2.replaceAll("<p>", "");
				String P2=P.replaceAll("</p>", "");
					String p="<p>"+P2+"</p>";
					Contenido.setText(p);			
			}
		});
		button.setBounds(296, 42, 55, 23);
		frame.getContentPane().add(button);
		
		button_1 = new JButton("<a>");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				        String s = Contenido.getText();
				        String [] parts = s.split("\\s+");

				        for( String item : parts ) try {
				            URL url = new URL(item);
				            Contenido.setText("<a href=\"" + url + "\">"+" "+"</a> " );    
				        } catch (MalformedURLException n) {
				        }				    
				
			}
		});
		button_1.setBounds(371, 42, 55, 23);
		frame.getContentPane().add(button_1);
		
		btnNewButton_1 = new JButton("Limpiar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent s) {
		        Titulo.setText("");
		        Autor.setText("");
		        Imagen.setText("");
		        URL.setText("");
		        Contenido.setText("");
			}
		});
		btnNewButton_1.setBounds(223, 261, 199, 23);
		frame.getContentPane().add(btnNewButton_1);
		BufferedReader in;
		
		File file = new File("db.js");
		
		try {
		    boolean bool = file.createNewFile();
			in = new BufferedReader(new FileReader("db.js"));
			int wordCount = 0;
			String line;
			while((line = in.readLine()) != null){
		        if (line.contains("\"id\":")) wordCount++;
		    }

			ID.setText(Integer.toString(wordCount+1));
			
			}
		

		 catch (IOException e) {
			e.printStackTrace();
		}
		
		btnConfirmar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent n) {
			FileWriter archivo = null;
			BufferedReader in;
	        try
	        {
	    		in = new BufferedReader(new FileReader("db.js"));
				int wordCount = 0;
				String line;
	            archivo = new FileWriter("db.js",true);
	            while((line = in.readLine()) != null){
			        if (line.contains("\"id\":")) wordCount++;
			    }
	            System.out.println(wordCount);
	            if(wordCount==0){
	            archivo.write("{");
	            }
	            else {
	            archivo.write(","+"{");
	            }
	            wordCount++;
	            archivo.write("\r\n");
	            archivo.write("\"id\":"+ID.getText()+",");
	            archivo.write("\r\n");
	            archivo.write("\"title\":\""+Titulo.getText()+"\""+",");
	            archivo.write("\r\n");
	            archivo.write("\"content\":\""+Contenido.getText()+"\""+",");
	            archivo.write("\r\n");
	            archivo.write("\"author\":\""+Autor.getText()+"\""+",");
	            archivo.write("\r\n");
	            archivo.write("\"url\":\""+URL.getText()+"\""+",");
	            archivo.write("\r\n");
	            archivo.write("\"image\":\""+Imagen.getText()+"\""+",");
	            archivo.write("\r\n");
	            archivo.write("}");
				ID.setText(Integer.toString(wordCount+1));


	        } 
			 catch (FileNotFoundException e) {
			 }
				   catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           try {
	           if (null != archivo)
	              archivo.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	        }

		}
	});
		
	}
}
