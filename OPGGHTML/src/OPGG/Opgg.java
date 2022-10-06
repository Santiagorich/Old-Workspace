package OPGG;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;


public class Opgg {
  public static void main(String[] args) throws Exception {
	  System.out.println("ok");
	  java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(java.util.logging.Level.OFF);
System.out.println("ok");
	  final WebClient webClient = new WebClient();
	  webClient.getOptions().setJavaScriptEnabled(true);
	  webClient.getOptions().setThrowExceptionOnScriptError(false);
	  final HtmlPage page = webClient.getPage("https://las.op.gg/summoner/userName=RedAndBlack");
	    System.out.println(page.getTitleText());

  }
}