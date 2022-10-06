import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Random;
public class Sliver {
	public static void main(String[] args) {
		String username="";
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 7; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		username = sb.toString();
		StringSelection stringSelection = new StringSelection(username);
		Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
		clpbrd.setContents(stringSelection, null);
}
}