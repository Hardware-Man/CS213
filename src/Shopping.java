/**
 * This class is the user interface class that handles the input commands, output data and messages.
 *
 * @author Kaivalya Mishra, Ridwanur Sarder
 */
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Shopping {
	
	final double TAX_RATE = 0.06625; 
	double salesTotal = 0;
	double taxTotal = 0;

	private ShoppingBag addCommand(StringTokenizer st, ShoppingBag bag) {
		String name = st.nextToken();
		double price = Double.valueOf(st.nextToken());
		boolean taxable = Boolean.valueOf(st.nextToken());
		if(taxable) {
			taxTotal += price * TAX_RATE;
		}
		salesTotal += price;
		
		GroceryItem item = new GroceryItem(name,price,taxable);
		bag.add(item);
		System.out.println(name + " added to the bag.");
		return bag;
	}
	
	private ShoppingBag removeCommand(StringTokenizer st, ShoppingBag bag) {
		String name = st.nextToken();
		double price = Double.valueOf(st.nextToken());
		boolean taxable = Boolean.valueOf(st.nextToken());
		GroceryItem item = new GroceryItem(name,price,taxable);

		if(bag.remove(item)) {
			if(taxable) {
				taxTotal -= price * TAX_RATE;
			}
			salesTotal -= price;
			System.out.println(name + " " + price + " removed.");
		}else {
			System.out.println("Unable to remove, this item is not in the bag.");
		}
		return bag;
	}
	
	private void displayCommand(ShoppingBag bag) {
		if(bag.isEmpty()) {
			System.out.println("The bag is empty!");
		} else {
		System.out.println("**You have " + bag.getSize() + " item(s) in the bag: ");
		bag.print();
		System.out.println("**End of list");
		}
	}
	
	private void checkingOutCommand(ShoppingBag bag) {
		System.out.println("**Checking out " + bag.getSize() +  " item(s): ");		
		DecimalFormat salesTaxFormat = new DecimalFormat("##.##");
		DecimalFormat totalFormat = new DecimalFormat("###.##");
		bag.print();
		System.out.println("*Sales total: $" + totalFormat.format(salesTotal));
		System.out.println("*Sales tax: $" + salesTaxFormat.format(taxTotal));
		System.out.println("*Total amount paid: $" + totalFormat.format(salesTotal + taxTotal));
		

	}
	
	
    public void run() {
        Scanner shopScan = new Scanner(System.in);
        ShoppingBag shopBag = new ShoppingBag();
        StringTokenizer tokens;
        
        System.out.println("Let's start shopping!");
        while(true) {
        	tokens = new StringTokenizer(shopScan.nextLine());
        	String commandLetter = tokens.nextToken();
        	
        	if(commandLetter.equals("Q")) {
        		if(!shopBag.isEmpty()) {
        			checkingOutCommand(shopBag);
        		}
        		break;
        	}
        	else if(commandLetter.equals("A")) {
        		shopBag = addCommand(tokens,shopBag);
        	}
        	else if(commandLetter.equals("R")) {
        		shopBag = removeCommand(tokens,shopBag);
        	}
        	else if(commandLetter.equals("P")) {
        		displayCommand(shopBag);
        	}
        	else if(commandLetter.equals("C")) {
        		if(shopBag.isEmpty()) {
        			System.out.println("Unable to check out, the bag is empty!");
        		}else {
        			checkingOutCommand(shopBag);
        		}
        	}
        	else System.out.println("Invalid command!");;
             
        	

        }
        System.out.println("Thanks for shopping with us!");
    }

}

