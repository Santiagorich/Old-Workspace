import java.io.File;
import java.io.FileWriter;
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

	public static void main(String[] args) {
		String url = "http://its.edu.uy/its/modulos/inasistencias_docentes/inasistencias_mostrar_web.php";

		try {
			String Desde = "";
			String Hasta = "";
			String Just = "";
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			int contador = 1;
			WebClient webClient = new WebClient();
			HtmlPage currentPage = webClient.getPage(url);
			DOMSource domSource = new DOMSource(currentPage.getDocumentElement());
			StringWriter writer = new StringWriter();
			StreamResult result = new StreamResult(writer);
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.transform(domSource, result);
			String html = writer.toString();
			String Texto = "";
			Document doc = Jsoup.parse(html);
			Document document = doc;

			while (contador <= document.getElementsByClass("TablaPar").size()
					+ document.getElementsByClass("TablaImPar").size()) {
				Date Date3 = (dateFormat.parse(
						document.select("#the-table > tbody > tr:nth-child(" + contador + ")> td:nth-child(3)")
								.text()));
				Date Date2 = (dateFormat.parse(
						document.select("#the-table > tbody > tr:nth-child(" + contador + ")> td:nth-child(2)")
								.text()));
				Just = document.select("#the-table > tbody > tr:nth-child(" + contador + ")> td:nth-child(1)")
						.text();
				String out = new String(Just.getBytes("ISO-8859-1"), "UTF-8").substring(1);
				Desde = "Desde:" + document
						.select("#the-table > tbody > tr:nth-child(" + contador + ")> td:nth-child(2)").text();
				Hasta = "Hasta:" + document
						.select("#the-table > tbody > tr:nth-child(" + contador + ")> td:nth-child(3)").text();
				Texto = Texto + out.toUpperCase() + "\r\n"+ Desde + Hasta + "\r\n"+"---------------------------------"+ "\r\n";
				contador++;
	}
			File file = new File("Inasistencias.txt");
	        if (file.exists()) {
	          file.delete();
	        }
	        FileWriter archivo = null;
	        boolean bool = file.createNewFile();
	          archivo = new FileWriter("Inasistencias.txt", true);
	          archivo.write(Texto + "\r\n");
	          archivo.write("Actualizado: "+dateFormat.format(date));
	          if (archivo != null) {
	              archivo.close();
	            }
	          
} catch (Exception ex) {
}
		
	}
	}	
