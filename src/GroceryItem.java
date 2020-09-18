/**
 * This class defines the abstract data type GroceryItem, which encapsulates the data fields (name, price, taxable)
 * and methods (equals, toString) of a grocery item.
 *
 * @author Kaivalya Mishra, Ridwanur Sarder
 */
import java.text.DecimalFormat;
public class GroceryItem {
    private String name;
    private double price;
    private boolean taxable;

    public GroceryItem(String name, double price, boolean taxable) {
        this.name = name;
        this.price = price;
        this.taxable = taxable;
    }
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
    public String toString() {
        DecimalFormat df = new DecimalFormat("##.##");
        String taxCheck = this.taxable ? "is taxable" : "tax free";
        return this.name + ": $" + df.format(this.price) + " : " + taxCheck;
    }
}
