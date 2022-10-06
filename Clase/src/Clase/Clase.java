package Clase;
import javax.swing.*;
public class Clase {

	public static void main(String[] args) {
		ImageIcon icon = new ImageIcon(Clase.class.getResource("a1.png"));
		JOptionPane Panel=new JOptionPane();
		Panel.showMessageDialog(null, "Hello darkness my old friend", "I hate my life",JOptionPane.PLAIN_MESSAGE,	icon);


	}

}
