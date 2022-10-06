import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Filter {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("output.txt"))) {
		    String line= "";
		    String items="";
		    try {
				while ((line = br.readLine()) != null) {
					if(org.apache.commons.lang3.StringUtils.substringBetween(line, "'item':{'id':", "','description':")!=null){
						if(org.apache.commons.lang3.StringUtils.substringBetween(line, "'item':{'id':", "','description':").contains("Welcome Buff")==false){
					items=items+"\n"+org.apache.commons.lang3.StringUtils.substringBetween(org.apache.commons.lang3.StringUtils.substringBetween(line, "'item':{'id':", ",'description':"), "'name':'", "'");
						}
						}
					
}
System.out.println(items);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


	}

}
}