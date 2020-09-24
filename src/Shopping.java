/**
 * This class is the user interface class that handles the input commands, output data and messages.
 *
 * @author Kaivalya Mishra, Ridwanur Sarder
 */
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Shopping {
	private ShoppingBag addCommand(StringTokenizer tokens, ShoppingBag bag) {
		if(tokens.countTokens() != 3) {
			System.out.println("Invalid command!");
			return bag;
		}

		String name = tokens.nextToken();
		double price = Double.parseDouble(tokens.nextToken());
		boolean taxable = Boolean.parseBoolean(tokens.nextToken());
		
		GroceryItem item = new GroceryItem(name,price,taxable);
		bag.add(item);
		System.out.println(name + " added to the bag.");
		return bag;
	}
	
	private ShoppingBag removeCommand(StringTokenizer tokens, ShoppingBag bag) {
		if(tokens.countTokens() != 3) {
			System.out.println("Invalid command!");
			return bag;
		}

		String name = tokens.nextToken();
		double price = Double.parseDouble(tokens.nextToken());
		boolean taxable = Boolean.parseBoolean(tokens.nextToken());

		GroceryItem item = new GroceryItem(name,price,taxable);
		if(bag.remove(item)) {
			System.out.println(name + " " + price + " removed.");
		}
		else {
			System.out.println("Unable to remove, this item is not in the bag.");
		}
		return bag;
	}
	
	private void displayCommand(ShoppingBag bag) {
		if(bag.isEmpty()) {
			System.out.println("The bag is empty!");
		}
		else {
			System.out.println("**You have " + bag.getSize() + " item(s) in the bag: ");
			bag.print();
			System.out.println("**End of list");
		}
	}
	
	private void checkingOutCommand(ShoppingBag bag) {
		System.out.println("**Checking out " + bag.getSize() +  " item(s): ");		
		DecimalFormat salesTaxFormat = new DecimalFormat("0.00");
		DecimalFormat totalFormat = new DecimalFormat("0.00");
		bag.print();
		System.out.println("*Sales total: $" + totalFormat.format(bag.salesPrice()));
		System.out.println("*Sales tax: $" + salesTaxFormat.format(bag.salesTax()));
		System.out.println("*Total amount paid: $" + totalFormat.format(bag.salesPrice() + bag.salesTax()));
	}

    public void run() {
        Scanner shopScan = new Scanner(System.in);
        ShoppingBag shopBag = new ShoppingBag();
        StringTokenizer tokens;
        
        System.out.println("Let's start shopping!");
		quit:
		while(true) {
			tokens = new StringTokenizer(shopScan.nextLine());
			String commandLetter = tokens.nextToken();

			switch (commandLetter) {
				case "Q":
					if (tokens.hasMoreTokens()) {
						System.out.println("Invalid command!");
						break;
					}
					if (!shopBag.isEmpty()) {
						checkingOutCommand(shopBag);
					}
					break quit;
				case "A":
					shopBag = addCommand(tokens, shopBag);
					break;
				case "R":
					shopBag = removeCommand(tokens, shopBag);
					break;
				case "P":
					if (tokens.hasMoreTokens()) {
						System.out.println("Invalid command!");
						break;
					}
					displayCommand(shopBag);
					break;
				case "C":
					if (tokens.hasMoreTokens()) {
						System.out.println("Invalid command!");
						break;
					}
					if (shopBag.isEmpty()) {
						System.out.println("Unable to check out, the bag is empty!");
					}
					else {
						checkingOutCommand(shopBag);
						shopBag = new ShoppingBag();
					}
					break;
				default:
					System.out.println("Invalid command!");
					break;
			}
		}
		System.out.println("Thanks for shopping with us!");
    }
}

