import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Servidor {
	static int contador = 1;
	public static void main(String[] args) {
		while (contador<=151){
		String url = "https://lolzteam.net/threads/63073/page-"+contador;

		try {
			WebClient webClient = new WebClient();
			HtmlPage currentPage = webClient.getPage(url);
			DOMSource domSource = new DOMSource(currentPage.getDocumentElement());
			StringWriter writer = new StringWriter();
			StreamResult result = new StreamResult(writer);
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.transform(domSource, result);
			String html = writer.toString();
			Document doc = Jsoup.parse(html);
			Document document = doc;
			String out = doc.toString();
			
			File file = new File("Steam-"+contador+".txt");
	        if (file.exists()) {
	          file.delete();
	        }
	        FileWriter archivo = null;
	        boolean bool = file.createNewFile();
	          archivo = new FileWriter("Steam-"+contador+".txt", true);
	          archivo.write(contador+"\r\n"+out);
	          if (archivo != null) {
	              archivo.close();
	            }
	          
} catch (Exception ex) {
}
		
		contador++;
		}
	          
		
	}	
	
}	

