/**
 * This class is the user interface class that handles the input commands, output data and messages.
 *
 * @author Kaivalya Mishra, Ridwanur Sarder
 */
import java.util.Scanner;
import java.util.StringTokenizer;
public class Shopping {

    public void run() {
        Scanner shopScan = new Scanner(System.in);
        ShoppingBag shopBag = new ShoppingBag();
        String delims = "\\s";

        String shopCommand = " ";
        System.out.println("Let's start shopping!");
        while(true) {
            shopCommand = shopScan.nextLine();
        }
        System.out.println("Thanks for shopping with us!");
    }

}
