package Anime;
import org.jsoup.*;
import org.jsoup.select.*;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import org.jsoup.nodes.*;
import java.util.Scanner;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;

import javax.swing.JButton;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import javafx.application.Application;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
public class Anime extends Application {
	
	static int Contador2=3786;
	static int Contador=14;
	static String url = "http://player.animeid.io/?id="+Contador2+"&ep_id="+Contador2+"&anime=sword-art-online-ii-2014&episode=episodio-"+Contador+"/";
   @Override
   public void start(final Stage stage) {
       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
       double width = screenSize.getWidth();
       double height = screenSize.getHeight();
       final WebView browser = new WebView();
       final WebEngine webEngine = browser.getEngine();
       browser.setMaxSize(width, height);
       browser.setMinSize(width, height);
       webEngine.load(url);
      
         
              
       VBox root = new VBox();
       root.getChildren().add(browser);
       Scene scene = new Scene(root);
       stage.setTitle("Anime");
       stage.setScene(scene);
       stage.setWidth(width);
       stage.setHeight(height);
       stage.show();
       scene.setOnKeyPressed(e -> {
    	    if (e.getCode() == KeyCode.PLUS) {
    	    	Contador++;
    	    	Contador2++;
    	    	//
    	    	url = "http://player.animeid.io/?id="+Contador2+"&ep_id="+Contador2+"&anime=sword-art-online-ii-2014&episode=episodio-"+Contador+"/";
                webEngine.load(url);
    	    }
    	    else if (e.getCode() == KeyCode.MINUS) {
    	    	Contador--;
    	    	Contador2--;
    	    	url = "http://player.animeid.io/?id="+Contador2+"&ep_id="+Contador2+"&anime=sword-art-online-ii-2014&episode=episodio-"+Contador+"/";
                webEngine.load(url);
    	    }
    	    else if (e.getCode() == KeyCode.SCROLL_LOCK) {
    	    	 try {
              	   DOMSource domSource = new DOMSource(webEngine.getDocument());
                     StringWriter writer = new StringWriter();
                     StreamResult result = new StreamResult(writer);
                     TransformerFactory tf = TransformerFactory.newInstance();
                     Transformer transformer = tf.newTransformer();
                     transformer.transform(domSource, result);
                     String html = writer.toString();

                     Document doc = Jsoup.parse(html);
     
              	   	url=doc.select("center >  iframe").attr("src");
              	   	webEngine.load(url);
              	   	
              	   } catch (FailingHttpStatusCodeException z) {
							// TODO Auto-generated catch block
							z.printStackTrace();
						} catch (TransformerException x) {
						// TODO Auto-generated catch block
						x.printStackTrace();
					}
    	    }
    	  });
       }
   public static void main(String[] args) {
       launch(args);
       
   }
 
}
 
