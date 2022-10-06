import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.sql.Timestamp;

import org.apache.commons.lang3.time.DateUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import javafx.stage.Screen;

import javax.swing.JFrame;
import javax.swing.JLabel;



public class Overlay {
    public static JLabel textf = new JLabel();
    public static String url = "https://warframe.guru/api/cetus";
    public static int tam = 20;
    public static Instant instant;
    public static long act;
    public static Date d1 = null;
    public static Date d2 = null;
    public static long time = 0;
    public static long otime = 0;
    public static int d = 0;
    public static JFrame frame = new JFrame("Cetus");
    public static long timestamp = 0;
    public static GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    public static GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
    public static Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
    public static int x = (int) rect.getMaxX() - 155;
    public static int y = (int) rect.getMaxY() - 26;
    
    
    public static void main(String[] args) {
        textf.setText("0h 0m 0s - Noche");
        textf.setForeground(Color.CYAN);
        textf.setFont(new Font("Dialog", Font.PLAIN, 20));
        frame.setUndecorated(true);
        frame.setBackground(new Color(0, 0, 0, 0));
        frame.setAlwaysOnTop(true);
        frame.getRootPane().putClientProperty("apple.awt.draggableWindowBackground", false);
        frame.getContentPane().setLayout(new java.awt.BorderLayout());
        frame.getContentPane().add(textf, java.awt.BorderLayout.NORTH);
        frame.setVisible(true);
        frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				System.out.println(arg0.getKeyCode());
				if (arg0.getKeyCode()==38 || arg0.getKeyCode()==104){
			        textf.setForeground(Color.RED);
				}
				if (arg0.getKeyCode()==38 || arg0.getKeyCode()==104){
			        textf.setForeground(Color.RED);
				}
				if (arg0.getKeyCode()==39 || arg0.getKeyCode()==102){
			        textf.setForeground(Color.GREEN);
				}
				if (arg0.getKeyCode()==40 || arg0.getKeyCode()==98){
			        textf.setForeground(Color.YELLOW);
				}
				if (arg0.getKeyCode()==37 || arg0.getKeyCode()==100){
			        textf.setForeground(Color.CYAN);
				}
				if (arg0.getKeyCode()==12 || arg0.getKeyCode()==101){
			        textf.setForeground(Color.ORANGE);
				}
				if (arg0.getKeyCode()==35 || arg0.getKeyCode()==97){
			        frame.setLocation(0, y);
				}
				if (arg0.getKeyCode()==34 || arg0.getKeyCode()==98){
			        frame.setLocation(x, y);
				}
				if (arg0.getKeyCode()==36 || arg0.getKeyCode()==103){
			        frame.setLocation(0, 0);
				}
				if (arg0.getKeyCode()==33 || arg0.getKeyCode()==105){
			        frame.setLocation(x, 0);
				}
				if (arg0.getKeyCode()==155 || arg0.getKeyCode()==96){
			        frame.setLocation(x/2, 0);
				}
				if (arg0.getKeyCode()==82){
					time=0;
					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        carga(url,timestamp,act);
				}
				if (arg0.getKeyCode()==107){
					if (tam<20){
					tam++;
			        textf.setFont(new Font("Dialog", Font.PLAIN, tam));
					}
				}
				else if (arg0.getKeyCode()==109){
					tam--;
					
			        textf.setFont(new Font("Dialog", Font.PLAIN, tam));
				}
			}
		});
        
        frame.pack();
        frame.setLocation(0, 0);
        frame.setVisible(true);
        carga(url,timestamp,act);
    }
    public static void count (){
    	
		while (time > 1) {
            if (time > 3000){
            	textf.setText(TimeFormatted(String.valueOf(time-3000),"Dia"));
            }else{
            	textf.setText(TimeFormatted(String.valueOf(time),"Noche"));
                
            }
            time = time - 1;            
            try {
    			Thread.sleep(1000);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
            
        } 
		return;

		
	}
	
	public static void carga (String url,long timestamp,long act){
		try {
			instant = Instant.now();
			act = instant.toEpochMilli();
			otime=time;
			act=act;
	        WebClient webClient = new WebClient(BrowserVersion.CHROME);
			HtmlPage currentPage;
			webClient.getOptions().setJavaScriptEnabled(false);
			currentPage = webClient.getPage(url);
			DOMSource domSource = new DOMSource(currentPage.getDocumentElement());
			StringWriter writer = new StringWriter();
			StreamResult result = new StreamResult(writer);
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.transform(domSource, result);
			String html = writer.toString();
			Document doc = Jsoup.parse(html);
			Document document = doc;
			timestamp=Long.valueOf(document.getElementsByTag("body").text().toString());
			time = timestamp - act;
            time = Math.round(time/1000) % 9000;
            d=0;
            System.out.println("time " + time);
            System.out.println("otime " + otime);
            if (otime==time){
            	System.out.println("retry");
                carga(url,timestamp,act);
            }else{
            	System.out.println("counting");
            	count();
            }
		
    
		} catch (Exception e) {
		} 
	}
	public static String TimeFormatted (String time,String tiempo) {
        int sec_num = Integer.parseInt(time, 10); // don't forget the second param
        double hours   = Math.floor(sec_num / 3600);
        double minutes = Math.floor((sec_num - (hours * 3600)) / 60);
        double seconds = sec_num - (hours * 3600) - (minutes * 60);
        Double h = new Double(hours);
        Double m = new Double(minutes);
        Double s = new Double(seconds);

        if (hours   < 10) {hours   = hours;}
        if (minutes < 10) {minutes = minutes;}
        if (seconds < 10) {seconds = seconds;}
        if (m == 0 && h == 0) {return s.intValue()+"s - "+tiempo;}
        else if (h == 0) {return m.intValue()+"m "+s.intValue()+"s - "+tiempo;}
        else{
        return h.intValue()+"h "+m.intValue()+"m "+s.intValue()+"s - "+tiempo;
        }
    }
}