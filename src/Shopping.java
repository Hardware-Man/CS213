/**
 * This class is the user interface class that handles the input commands, output data and messages.
 *
 * @author Kaivalya Mishra, Ridwanur Sarder
 */
import java.util.Scanner;
public class Shopping {

    public void run() {
        Scanner shopScan = new Scanner(System.in);
        ShoppingBag shopBag = new ShoppingBag();
        String shopCommand = shopScan.nextLine();
        System.out.println("Let's start shopping!");
        while(shopCommand.charAt(0) != 'Q' && shopCommand.length() > 1) {
            if(shopCommand.charAt(0) == 'A') {
//                GroceryItem tempItem
//                shopBag.add();
            }
            shopCommand = shopScan.nextLine();
        }
        System.out.println("Thanks for shopping with us!");
    }

}
