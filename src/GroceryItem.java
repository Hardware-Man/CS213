import java.text.DecimalFormat;

/**
 * This class defines the abstract data type GroceryItem, which encapsulates the data fields (name, price, taxable)
 * and methods (equals, toString) of a grocery item.
 *
 * @author Kaivalya Mishra, Ridwanur Sarder
 */
public class GroceryItem {
    /**
     * Name of GroceryItem object.
     */
    private String name;

    /**
     * Price of GroceryItem object as a double.
     */
    private double price;

    /**
     * Boolean to indicate whether or not GroceryItem object is taxable.
     */
    private boolean taxable;

    /**
     * Constructor to initialize a GroceryItem object given the name, price, and taxable.
     *
     * @param name of item
     * @param price of item
     * @param taxable  boolean of whether or not the item is taxable
     */
    public GroceryItem(String name, double price, boolean taxable) {
        this.name = name;
        this.price = price;
        this.taxable = taxable;
    }

    /**
     * Compares two GroceryItem objects.
     *
     * @return true if two GroceryItem objects are equal to each other
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GroceryItem) {
            GroceryItem anItem = (GroceryItem)obj;
            return name.equals(anItem.name) && (price == anItem.price) && (taxable == anItem.taxable);
        }
        return false;
    }

    /**
     * Gives a description of grocery item including the name, price, and taxable.
     *
     * @return formatted description of GroceryItem object
     */
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        String taxCheck = this.taxable ? "is taxable" : "tax free";
        return this.name + ": $" + df.format(this.price) + " : " + taxCheck;
    }

    /**
     * Is a get method to retrieve the price of a grocery item.
     *
     * @return price of GroceryItem object
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Is a get method to retrieve the taxable status of a grocery item.
     *
     * @return true if item is taxable
     */
    public boolean isTaxable() {
        return this.taxable;
    }
}
