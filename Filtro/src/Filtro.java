import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import org.apache.commons.lang3.StringUtils;

public class Filtro {
	static int contador=1;
	public static String src="";
	public static String title="";
	public static String texto="";
	public static void main(String[] args) {
		while(contador<3080){
		try {
			try (BufferedReader br = new BufferedReader(new FileReader("index ("+contador+").html"))) {
			    String line;
			    while ((line = br.readLine()) != null) {
				        if(line.contains("<iframe class=\"metaframe rptss\" src=") && StringUtils.substringBetween(line, "<iframe class=\"metaframe rptss\" src=", "frameborder=")!=null){
				            src = StringUtils.substringBetween(line, "<iframe class=\"metaframe rptss\" src=", "frameborder=");
				        }
				        else if (line.contains("<h1 class=\"epih1\">") && StringUtils.substringBetween(line,"<h1 class=\"epih1\">","<")!=null) {
				            title = StringUtils.substringBetween(line,"<h1 class=\"epih1\">","<");
				            System.out.println(title);
				        }
				        }
			    br.close();
			}
			

		       
		   
		    texto=texto+"\n"+title+":"+src;
		    
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		contador++;
		} 
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(
	              new FileOutputStream("series.txt"), "ISO-8859-1"))) {
	   writer.write(texto);
	   writer.close();
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		}

}
