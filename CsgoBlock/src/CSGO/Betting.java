package CSGO;

import java.awt.Dimension;
import java.awt.Toolkit;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
public class Betting extends Application {
	
	static String url = "https://steamcommunity.com/openid/login?openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.mode=checkid_setup&openid.return_to=http%3A%2F%2FLoginToBlocks.Com%2Fapi%2Fv1%2Fcalls%2FLoginSteam%3Flogin&openid.realm=http%3A%2F%2FLoginToBlocks.Com&openid.ns.sreg=http%3A%2F%2Fopenid.net%2Fextensions%2Fsreg%2F1.1&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select#loginForm";
   @Override
   public void start(final Stage stage) {
       double width = 300;
       double height = 300;
       final WebView browser = new WebView();
       final WebEngine webEngine = browser.getEngine();
       browser.setMaxSize(width, height);
       browser.setMinSize(width, height);
       webEngine.load(url);
      
         
              
       VBox root = new VBox();
       root.getChildren().add(browser);
       Scene scene = new Scene(root);
       stage.setTitle("Login");
       stage.setScene(scene);
       stage.setWidth(width);
       stage.setHeight(height);
       stage.show();
       }
   public static void main(String[] args) {
       launch(args);
       
   }
 
}
 