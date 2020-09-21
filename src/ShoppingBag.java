/**
 * This is the container class that defines the abstract data type for a shopping bag and its operations.
 *
 * @author Kaivalya Mishra, Ridwanur Sarder
 */
public class ShoppingBag {
    private GroceryItem[] bag;
    private int size;
    private int capacity;

    public ShoppingBag() {

    }
    private int find(GroceryItem item) {
        return 0;
    }
    private void grow() {

    }
    public void add(GroceryItem item) {

    }
    public boolean remove(GroceryItem item) {
        return false;
    }
    public double salesPrice() {
        return 0;
    }
    public double salesTax() {
        return 0;
    }
    public void print() {

    }
    public boolean isEmpty() {
    	return getSize() == 0;
    }
    public int getSize() {
    	return size;
    }
}