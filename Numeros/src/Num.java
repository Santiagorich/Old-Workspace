 
import java.io.File;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import javafx.application.Application;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
 
public class Num extends Application {
 
    @Override
    public void start(final Stage stage) {
 
        Button buttonURL = new Button("Load Page https://eclipse.org");
        
        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();
 
        webEngine.setJavaScriptEnabled(true);
        webEngine.getLoadWorker().stateProperty()
        .addListener((obs, oldValue, newValue) -> {
          if (newValue == State.SUCCEEDED) {
        	  
            System.out.println("finished loading");
            
            try {
                TransformerFactory transformerFactory = TransformerFactory
                    .newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                StringWriter stringWriter = new StringWriter();
                transformer.transform(new DOMSource(webEngine.getDocument()),
                    new StreamResult(stringWriter));
                String xml = stringWriter.getBuffer().toString();
                System.out.println(xml);
              } catch (Exception e) {
                e.printStackTrace();
              }
          }
        }); // addListener()
        buttonURL.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                String url = "https://warframe.guru/cetus";
                webEngine.load(url);
            	
            }
        });
 
 
        VBox root = new VBox();
        root.setPadding(new Insets(5));
        root.setSpacing(5);
        root.getChildren().addAll(buttonURL, browser);
 
        Scene scene = new Scene(root);
 
        stage.setTitle("JavaFX WebView (o7planning.org)");
        stage.setScene(scene);
        stage.setWidth(450);
        stage.setHeight(300);
 
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
 
}