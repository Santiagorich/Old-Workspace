package Escritos;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Steam {
	public static String username="";
	public static String password="";

	public static void main(String[] args) throws FileNotFoundException, IOException {
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 7; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		username = sb.toString();
		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i < 7; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb2.append(c);
		}
		password = sb2.toString();
		try (BufferedReader br = new BufferedReader(new FileReader("account_creator.js"))) {
			String code = "";
		    String line= "";
		    int contador=1;
		    while ((line = br.readLine()) != null) {
		    	if (contador==36){
		    		line="  username = '"+username+"'";
		    	}if (contador==37){
		    		line="  password = '"+password+"'";
		    	}
		    	code=code+line+"\n";
		    	contador++;
		    }
		    PrintWriter writer = new PrintWriter("account_creator.js");
		    writer.print(code);
		    writer.close();
		}
		StringSelection stringSelection = new StringSelection(username + "|" + password);
		Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
		clpbrd.setContents(stringSelection, null);
        Runtime.getRuntime().exec("cmd /c node account_creator.js");
	}

}
