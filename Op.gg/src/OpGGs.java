import org.jsoup.*;
import org.jsoup.select.*;
import org.jsoup.nodes.*;
import java.util.Scanner;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
public class OpGGs {
public static void main(String[] args) throws IOException {
		final WebView browser = new WebView();
	       final WebEngine webEngine = browser.getEngine();
	       Worker<Void> worker = webEngine.getLoadWorker();
	               String url = "https://las.op.gg/summoner/userName=RedAndBlack";
	               webEngine.load(url);
	               worker.stateProperty().addListener(new ChangeListener<State>() {
	            	   
	                   @Override
	                   public void changed(ObservableValue<? extends State> observable, State oldValue, State newValue) {
	                       if (newValue == Worker.State.SUCCEEDED) {
	                           webEngine.executeScript("$.OP.GG.summoner.openMMR('redandblack', '#ExtraView')");  
	                       }
				
	               }});
	    		Document document;
				try {
					document = Jsoup.connect(url).followRedirects(false).timeout(60000).get();
					Elements elo = document.getElementsByClass("tierRank");
	    		System.out.println(elo.get(0).text());
	    		Elements wins = document.getElementsByClass("wins");
	    		System.out.println(wins.get(0).text());
	    		Elements losses = document.getElementsByClass("losses");
	    		System.out.println(losses.get(0).text());
	    		Elements pl = document.getElementsByClass("LeaguePoints");
	    		System.out.println(pl.get(0).text());
				} catch (IOException e) {
					e.printStackTrace();
				}
	    	    
	}

}
