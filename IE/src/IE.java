import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IE {
	public static void main(String[] args) {
	try
    {	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		BufferedReader in;
		int contador = 0;
		String line;
		String Texto="";
		in = new BufferedReader(new FileReader("Inasistencias.txt"));
		while((line = in.readLine()) != null){
			if (line.contains("CASTRO") && line.contains("JOSE")) {
				Texto=Texto +line +" (Ingles)\r\n" + in.readLine() + "\r\n" + "---------------------------------\r\n"; 
			} 
				else if (line.contains("VILLAMIL")
					&& line.contains("SILVIA")) {
				Texto=Texto +line +" (APT)\r\n" + in.readLine() + "\r\n" + "---------------------------------\r\n"; 
			} 
				else if (line.contains("ARES") && line.contains("MANUEL")) {
				Texto=Texto +line +" (Electronica)\r\n" + in.readLine() + "\r\n" + "---------------------------------\r\n"; 
			} 
				else if (line.contains("GIACOBBE")
					&& line.contains("RUDDY")) {
				Texto=Texto +line +" (Diseño web)\r\n" + in.readLine() + "\r\n" + "---------------------------------\r\n"; 
			} 
				else if (line.contains("LATIERRO")
					&& line.contains("HUGO")) {
				Texto=Texto +line +" (Matematica)\r\n" + in.readLine() + "\r\n" + "---------------------------------\r\n"; 
			} 
				else if (line.contains("HERNANDEZ")
					&& line.contains("NORA")) {
				Texto=Texto +line +" (Programacion)\r\n" + in.readLine() + "\r\n" + "---------------------------------\r\n"; 
			} 
			
				else if (line.contains("FERNANDEZ L")) {
				Texto=Texto +line +" (Quimica)\r\n" + in.readLine() + "\r\n" + "---------------------------------\r\n"; 
			} 
				else if (line.contains("OLAZARRI")) {
				Texto=Texto +line +" (Geometria)\r\n" + in.readLine() + "\r\n" + "---------------------------------\r\n"; 
			} 
				else if (line.contains("CHIRIBAO")
					&& line.contains("ESTHER")) {
				Texto=Texto +line +" (S.O)\n";
			} 
				else if (line.contains("LIZUAIN")
					&& line.contains("CARLOS")) {
				Texto=Texto +line +" (Economia)\r\n" + in.readLine() + "\r\n" + "---------------------------------\r\n"; 
			} 
				else if (line.contains("NUÑEZ") && line.contains("VICTOR")) {
				Texto=Texto +line +" (Taller de mantenimiento)\r\n" + in.readLine() + "\r\n" + "---------------------------------\r\n"; 
			} 
				else if (line.contains("GONZALEZ") && line.contains("ANA")) {
				Texto=Texto +line +" (Base de datos)\r\n" + in.readLine() + "\r\n" + "---------------------------------\r\n"; 
			} 
		
			
	    }
		if (Texto==""||Texto==null){
			Texto="Ninguno de nuestros profesores tiene aviso :/";
		}
		File file = new File("IE.txt");
	    if (file.exists()) {
	      file.delete();
	    }
	    FileWriter archivo = null;
	    boolean bool = file.createNewFile();
	      archivo = new FileWriter("IE.txt", true);
	      archivo.write(Texto + "\r\n");
          archivo.write("Actualizado: "+dateFormat.format(date));
	      if (archivo != null) {
	          archivo.close();
	        }
	      }catch (Exception ex) {
    }
	
	

}

}

