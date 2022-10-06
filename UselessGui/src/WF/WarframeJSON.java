package WF;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.awt.event.ActionListener;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class WarframeJSON {
	String lines = "";
	String rolled = "";
	String compatibilityt = "";
	List<String> list2 = new ArrayList<String>();
	List<String> list = new ArrayList<String>();
	String resultado = "";
	
	private JFrame frmUselessJsonData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WarframeJSON window = new WarframeJSON();
					window.frmUselessJsonData.setVisible(true);
				} catch (Exception e) {
					//e.printStackTrace();
				}
			}
		});
	}
	
	public void fetch(String roll,String comp) {
		resultado="";
		try {
			lines="";
			JSONParser parser = new JSONParser();
		    JSONArray jsonArr = new JSONArray();
			JSONObject jsonobj = new JSONObject();
			URL url = new URL("http://n9e5v4d8.ssl.hwcdn.net/repos/weeklyRivensPC.json");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET"); 
			conn.connect(); 
			int responsecode = conn.getResponseCode();
			if(responsecode != 200)
			throw new RuntimeException("Response Code: " +responsecode);
			else
			{
				Scanner sc = new Scanner(url.openStream());
				while(sc.hasNext())
				{
				lines = lines + sc.nextLine();
				}
				sc.close();
				
				Object jobj = null;
				jobj = parser.parse(lines);

				jsonArr =(JSONArray) jobj;

				for(int i=0;i<jsonArr.size();i++){
					jsonobj = (JSONObject)jsonArr.get(i);

					try {
					if (jsonobj.get("rerolled").toString() == roll){
						if (jsonobj.get("compatibility").toString().contains(comp)){
								resultado =  "Riven type: "+jsonobj.get("itemType")+ "\n"+"Average price: "+jsonobj.get("avg")+ "\n" + "Minimum price: "+jsonobj.get("min")+ "\n"+ "Maximum price: "+jsonobj.get("max")+ "\n"+ "Price variation: "+jsonobj.get("stddev")+ "\n"+"Popularity: "+ jsonobj.get("pop")+ "\n"+ resultado ;
							
						}
					}
					
					} catch (Exception e) {
						//e.printStackTrace();
					} 
				}
		        

			}

		} catch (Exception e) {
			//e.printStackTrace();

		} 
	}
	
	public void fetchlist() {

		try {
			lines="";
			JSONParser parser=new JSONParser();
		    JSONArray jsonArr = new JSONArray();
			JSONObject jsonobj = new JSONObject();
			URL url = new URL("http://n9e5v4d8.ssl.hwcdn.net/repos/weeklyRivensPC.json");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET"); 
			conn.connect(); 
			int responsecode = conn.getResponseCode();
			if(responsecode != 200)
			throw new RuntimeException("Response Code: " +responsecode);
			else
			{
				Scanner sc = new Scanner(url.openStream());
				while(sc.hasNext())
				{
				lines = lines + sc.nextLine();
				}
				sc.close();
				Object jobj = null;
				jobj = parser.parse(lines);
				jsonArr =(JSONArray) jobj;

				for(int i=0;i<jsonArr.size();i++){
					jsonobj = (JSONObject)jsonArr.get(i);
					
					try {
					if (!list.contains(jsonobj.get("itemType").toString()) == true){
						list.add(jsonobj.get("itemType").toString());
					}
					if (!list2.contains(jsonobj.get("compatibility").toString()) == true){
						list2.add(jsonobj.get("compatibility").toString());
					}
					} catch (Exception e) {
						//e.printStackTrace();

					} 
				}
		        

			}

		} catch (Exception e) {
			//e.printStackTrace();

		}
	}
	/**
	 * Create the application.
	 */
	public WarframeJSON() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		fetchlist();
		frmUselessJsonData = new JFrame();
		frmUselessJsonData.setTitle("Warframe data");
		frmUselessJsonData.setBounds(100, 100, 307, 267);
		frmUselessJsonData.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUselessJsonData.getContentPane().setLayout(null);
		
		JLabel lblCompatibility = new JLabel("Weapon");
		lblCompatibility.setBounds(10, 14, 94, 14);
		frmUselessJsonData.getContentPane().add(lblCompatibility);
		
		JTextPane result = new JTextPane();
		result.setEditable(false);
		result.setBounds(10, 99, 271, 118);
		frmUselessJsonData.getContentPane().add(result);
		
		JComboBox compatibility = new JComboBox();
		compatibility.setModel(new DefaultComboBoxModel(list2.toArray()));
		compatibility.setBounds(114, 11, 167, 20);
		frmUselessJsonData.getContentPane().add(compatibility);
		
		JRadioButton reroll = new JRadioButton("Rerolled");
		reroll.setBounds(10, 35, 94, 23);
		frmUselessJsonData.getContentPane().add(reroll);
		
		JButton fetchbtn = new JButton("Fetch");
		fetchbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (reroll.isSelected()== true){
					rolled = "true";
				}
				else {
					rolled = "false";
				}
				compatibilityt = compatibility.getSelectedItem().toString();
				fetch (rolled,compatibilityt);
				result.setText(resultado);
			}
		});
		fetchbtn.setBounds(10, 65, 271, 23);
		frmUselessJsonData.getContentPane().add(fetchbtn);
		
		
	}
}
