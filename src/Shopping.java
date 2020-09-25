/**
 * This class is the user interface class that handles the input commands, output data and messages.
 *
 * @author Kaivalya Mishra, Ridwanur Sarder
 */

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Shopping {

    /**
	 * Adds an object of type GroceryItem initialized by input tokens to a ShoppingBag object.
	 *
	 * @param tokens in the add request(item name, price, and taxable)
	 * @param bag prior to addition of item
	 * @return updated shopping bag with item added
	 */
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

	/**
	 * Removes an object of type GroceryItem described by input tokens from a ShoppingBag object.
	 * If item is not found in the ShoppingBag object, prints out a message saying so.
	 *
	 * @param tokens in the remove request(item name, price, and taxable)
	 * @param bag prior to removal of item
	 * @return updated shopping bag with item removed
	 */
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

	/**
	 * Displays the contents of a shopping bag.
	 *
	 * @param bag to display contents of
	 */
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

	/**
	 * Checks out all the objects in the shopping bag, emptying it afterwards.
	 * If bag is empty, will display a message saying so. 
	 * Prints out the items being checked out, sales total, sales tax, and total amount paid.
	 *
	 * @param bag to be checked out
	 */
	private void checkingOutCommand(ShoppingBag bag) {
		System.out.println("**Checking out " + bag.getSize() +  " item(s): ");
		DecimalFormat salesTaxFormat = new DecimalFormat("0.00");
		DecimalFormat totalFormat = new DecimalFormat("0.00");
		bag.print();
		System.out.println("*Sales total: $" + totalFormat.format(bag.salesPrice()));
		System.out.println("*Sales tax: $" + salesTaxFormat.format(bag.salesTax()));
		System.out.println("*Total amount paid: $" + totalFormat.format(bag.salesPrice() + bag.salesTax()));
	}


	/**
	 * User interface method to emulate a shopping bag and shopping functions.
	 * Commands include add, remove, display, check out, and quit.
	 */
	public void run() {
		Scanner shopScan = new Scanner(System.in);
		ShoppingBag shopBag = new ShoppingBag();
		StringTokenizer tokens;

		System.out.println("Let's start shopping!");
		
		//Read input and run methods accordingly
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
