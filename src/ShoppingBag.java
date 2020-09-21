/**
 * This is the container class that defines the abstract data type for a shopping bag and its operations.
 *
 * @author Kaivalya Mishra, Ridwanur Sarder
 */

public class ShoppingBag {
    private GroceryItem[] bag;
    private int size;

    public ShoppingBag() {
        this.bag = new GroceryItem[5];
        this.size = 0;
    }

    private int find(GroceryItem item) {
        for(int i = 0; i < this.size; i++) {
            if(this.bag[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    private void grow() {
        GroceryItem[] replaceBag = new GroceryItem[this.bag.length+5];
        System.arraycopy(this.bag, 0, replaceBag, 0, this.bag.length);
        this.bag = replaceBag;
    }

    public void add(GroceryItem item) {
        if(this.size == this.bag.length) {
            grow();
        }
        this.bag[size] = item;
        size++;
    }

    public boolean remove(GroceryItem item) {
        int itemPosition = find(item);
        if(itemPosition == -1) {
            return false;
        }
        this.bag[itemPosition] = this.bag[this.size-1];
        this.bag[this.size-1] = null;
        size--;
        return true;
    }

    public double salesPrice() {
        double salesTotal = 0;
        for(int i = 0; i < this.size; i++) {
            salesTotal += this.bag[i].getPrice();
        }
        return salesTotal;
    }

    public double salesTax() {
        double taxTotal = 0;
        for(int i = 0; i < this.size; i++) {
            if(this.bag[i].isTaxable()) {
                taxTotal += this.bag[i].getPrice() * 0.06625;
            }
        }
        return taxTotal;
    }

    public void print() {
        for (int i = 0; i < this.size; i++) {
            System.out.println("·" + this.bag[i].toString());
        }
    }

    public boolean isEmpty() {
    	return getSize() == 0;
    }

    public int getSize() {
    	return size;
    }

    public static void main(String[] args) {

    }
}