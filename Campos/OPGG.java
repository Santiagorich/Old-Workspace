import java.awt.Dimension;
import java.awt.Toolkit;
import javafx.application.Application;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
 
public class OPGG extends Application {
 
   @Override
   public void start(final Stage stage) {
       ProgressBar progressBar = new ProgressBar();
       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
       double width = screenSize.getWidth();
       double height = screenSize.getHeight();
       final WebView browser = new WebView();
       final WebEngine webEngine = browser.getEngine();
       browser.setMaxSize(width, height);
       browser.setMinSize(width, height);
       Worker<Void> worker = webEngine.getLoadWorker();
       progressBar.setMaxWidth(width);
       progressBar.setMinWidth(width);
       progressBar.progressProperty().bind(worker.progressProperty());
               String url = "https://las.op.gg/summoner/userName=RedAndBlack";
               webEngine.load(url);
              
 
       VBox root = new VBox();
       root.getChildren().addAll(progressBar, browser);
 
       Scene scene = new Scene(root);
       stage.setTitle("STATS");
       stage.setScene(scene);
       stage.setWidth(width);
       stage.setHeight(height);
 
       stage.show();
   }
 
   public static void main(String[] args) {
       launch(args);
   }
 
}