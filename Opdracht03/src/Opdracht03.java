
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Opdracht03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        RheaThread newThread = new RheaThread();
        newThread.start(); // start() ipv run(), run() is al functie in thread klasse
        try {
            newThread.sleep(5000); // na 5 seconden tijdelijk uitschakelen (in milliseconde lang)
            newThread.setIsRunning(true); // terwijl hoofdthread stopt, start nieuwe thread
        } catch (InterruptedException ex) {
            Logger.getLogger(Opdracht03.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
