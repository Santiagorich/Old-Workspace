import java.io.IOException;

public class Ping {

	public static void main(String[] args) {
		String host="";
		boolean ping;
		while(false!=true){
			
				boolean isReachable = false; 
				try { Process proc = new ProcessBuilder("ping", host).start(); 
				int exitValue = proc.waitFor(); 
				System.out.println("Exit Value:" + exitValue); 
				if(exitValue == 0) isReachable = true;
				} catch (IOException e1) 
				{ System.out.println(e1.getMessage()); 
				e1.printStackTrace(); 
				}catch (InterruptedException e) 
				{ e.printStackTrace(); 
				}  }
        
		  
	}

}
