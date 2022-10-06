package Farmingp;
import org.jsoup.*;
import org.jsoup.select.*;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;


import org.jsoup.nodes.*;

import java.util.Random;
import java.util.Scanner;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
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

public class Farming extends Application {
	String url = "https://www.sliver.tv/";


   @Override
   public void start(final Stage stage) {

	   WebClient webClient = new WebClient();
       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
       double width = screenSize.getWidth();
       double height = screenSize.getHeight();
       final WebView browser = new WebView();
       final WebEngine webEngine = browser.getEngine();
       webEngine.setJavaScriptEnabled(true);
       browser.setMaxSize(width, height);
       browser.setMinSize(width, height);
       webEngine.setUserAgent("Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36");
       webEngine.load(url);
       String username="";
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 7; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}

       webEngine.getLoadWorker().stateProperty().addListener(
    		    new ChangeListener<State>() {
    		        public void changed(ObservableValue ov, State oldState, State newState) {
    		            if (newState == Worker.State.SUCCEEDED) { 	
    		            	 webEngine.executeScript("document.getElementsByTagName('a')[10].click();this.updater2 = setInterval(function(){"+"var response=grecaptcha.getResponse();if(response.length==0){}else{alert('Hi');document.getElementsByClassName('input')[0].value='"+sb.toString()+"@yopmail.com';document.getElementsByClassName('input')[1].value='"+sb.toString()+"';"+"document.getElementsByClassName('input')[1].value='"+sb.toString()+"';document.getElementsByClassName('input')[2].value='Santiago1'}}, 200);");
    		            }
    		        }
    		    });
      
         
              
       VBox root = new VBox();
       root.getChildren().add(browser);
       Scene scene = new Scene(root);
       stage.setTitle("Anime");
       stage.setScene(scene);
       stage.setWidth(width);
       stage.setHeight(height);
       stage.show();
       scene.setOnKeyPressed(e -> {
   	    if (e.getCode() == KeyCode.D) {

   	    }});
       }
   public static void main(String[] args) {
       launch(args);
       
   }
 
}
 
