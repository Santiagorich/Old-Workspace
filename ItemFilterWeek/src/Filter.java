import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Filter {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		List<String> items = new ArrayList<String>();  
		String username="";
		String image="";
		boolean found = false;
		try (BufferedReader br = new BufferedReader(new FileReader("output.txt"))) {
		    String line= "";
		    
		     try {
				while ((line = br.readLine()) != null) {	
					line = line.replaceAll("\"", "'");
					if(org.apache.commons.lang3.StringUtils.substringBetween(line, "'url': ",", 'proxy_url':")!=null){
						if(org.apache.commons.lang3.StringUtils.substringBetween(line, "'id': ", ", 'avatar':")!=null){
							username="<@" + org.apache.commons.lang3.StringUtils.substringBetween(line, "'id': ", ", 'avatar':").replaceAll("'", "")+ ">: ";
							image=org.apache.commons.lang3.StringUtils.substringBetween(line, "'url': ",", 'proxy_url':");
							//items=items+"\n"+ "<@" + org.apache.commons.lang3.StringUtils.substringBetween(line, "'id': ", ", 'avatar':").replaceAll("'", "")+ ">: " + org.apache.commons.lang3.StringUtils.substringBetween(line, "'proxy_url': ", ", 'filename':").replaceAll("'", "");
							found = false;
							for(int i = 0; i < items.size(); i++)  {
								if (items.get(i).contains(username)){
									found = true;
									break;
								}
						    }
							if (found==false){
								items.add(username);
							}
							for(int i = 0; i < items.size(); i++)  {
								if (items.get(i).contains(username)){
									items.set(i, items.get(i) +"\r\n"+ image);
								}
						    }
						}
						//items.get(items.indexOf("<@" + org.apache.commons.lang3.StringUtils.substringBetween(line, "'id': ", ", 'avatar':").replaceAll("'", "")+ ">: ")).add("\n"+ "<@" + org.apache.commons.lang3.StringUtils.substringBetween(line, "'id': ", ", 'avatar':").replaceAll("'", "")+ ">: ");
						}
					
}
				for(int i = 0; i < items.size(); i++)  {	
					System.out.println(i+": " + items.get(i));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     


	}
		
		
}
}