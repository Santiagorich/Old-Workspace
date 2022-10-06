 
import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;
import java.awt.Toolkit;
 
public class CountDown {
    Timer timer;
 
    public CountDown(int seconds) {
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds * 1000);
    }
 
    class RemindTask extends TimerTask {
        public void run() {
            System.out.println("Zeit vorbei");
            System.out.flush();
            Toolkit.getDefaultToolkit().beep();
            timer.cancel();
        }
    }
 
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int[] zeit = new int[3];
 
        for (int j = 0; j < zeit.length; j++) {
            zeit[j] = j;
            System.out.println("Gib Sekunden fuer Timer" + zeit[j] + " ein ");
            int eingabe = scan.nextInt();
            zeit[j] = eingabe;
            scan.nextLine();
        }
        for (int i = 0; i < zeit.length; i++) {
            zeit[i] = i;
            new CountDown(zeit[i]);
            System.out.println("Zeit laueft");
        }
        scan.close();
    }
}