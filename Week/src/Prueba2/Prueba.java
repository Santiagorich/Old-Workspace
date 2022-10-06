package Prueba2;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;






public class Prueba
{
  private static JFrame frame;
  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Prueba window = new Prueba();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
  


  public Prueba()
  {
    initialize();
  }
  


  private void initialize()
  {
    frame = new JFrame();
    frame.setBounds(100, 100, 331, 308);
    frame.setDefaultCloseOperation(3);
    frame.getContentPane().setLayout(null);
    
    JLabel lblTexto = new JLabel("Texto:");
    lblTexto.setBounds(141, 11, 47, 14);
    frame.getContentPane().add(lblTexto);
    JTextArea textField = new JTextArea();
    textField.setBounds(10, 31, 295, 193);
    frame.getContentPane().add(textField);
    JButton btnAhk = new JButton("AHK!");
    btnAhk.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent a) {
        String Text = textField.getText();
        int contador=0;
        Text = Text.replaceAll("\"", "'");
        System.out.println(Text);        
        String letra="" ;
        int Count=0;
        String[] lines = Text.split("\r\n|\r|\n");
       
        File file = new File("Spam.ahk");
        if (file.exists()) {
          file.delete();
        }
        FileWriter archivo = null;
        try {
          boolean bool = file.createNewFile();
          archivo = new FileWriter("Spam.ahk", true);
          archivo.write("Loop");
          archivo.write("{\r\n");

          while (contador<lines.length){
        	  Text=lines[contador];
        	  Count = Text.length();
          for (int i = 0; i < Count; i++) {
	       
            letra = Text.substring(i, i+1);
            System.out.println(letra);
            if (letra.trim().length() == 0) {
              archivo.write("send {space} \r\n");
            } else {
              archivo.write("send {" + letra + "} \r\n");
            }
          }
          archivo.write("send {enter} \r\n");
          contador++;
          archivo.write("Sleep,10000 \r\n");
          }
          archivo.write("}");
          archivo.write("#p::Pause,Toggle");
          if (archivo != null) {
            archivo.close();
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
        
        String command = file.getAbsolutePath();
        String command2 = command.replaceAll("\\\\Spam.ahk", "");
        try {
          Runtime.getRuntime().exec("cmd /c cd " + command2);
          Runtime.getRuntime().exec("cmd /c Spam.ahk");
        } catch (IOException e) {
          e.printStackTrace();
        }
        System.exit(0);
      }
    });
    btnAhk.setBounds(111, 235, 89, 23);
    frame.getContentPane().add(btnAhk);
    

  }
}