/**
 * This is the container class that defines the abstract data type for a shopping bag and its operations.
 *
 * @author Kaivalya Mishra, Ridwanur Sarder
 */
public class ShoppingBag {

    /**
     * Array of grocery items.
     */
    private GroceryItem[] bag;

    /**
     * Number of items in bag.
     */
    private int size;

    /**
     * Constructor to initialize a ShoppingBag with a bag of length 5 and size 0.
     */
    public ShoppingBag() {
        this.bag = new GroceryItem[5];
        this.size = 0;
    }

    /**
     * Finds a GroceryItem object (item) within the bag and returns its index.
     *
     * @param item GroceryItem object
     * @return Returns index of item or -1 if item is not found
     */
    private int find(GroceryItem item) {
        for(int i = 0; i < this.size; i++) {
            if(this.bag[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Increases the capacity of the bag by 5.
     */
    private void grow() {
        GroceryItem[] replaceBag = new GroceryItem[this.bag.length+5];
        System.arraycopy(this.bag, 0, replaceBag, 0, this.bag.length);
        this.bag = replaceBag;
    }

    /**
     * Adds a GroceryItem object (item) to the bag.
     * Utilizes grow() if bag is full and then adds.
     *
     * @param item GroceryItem object
     */
    public void add(GroceryItem item) {
        if(this.size == this.bag.length) {
            grow();
        }
        this.bag[size] = item;
        size++;
    }

    /**
     * Removes the first instance of a GroceryItem object (item) from the bag.
     * Utilizes find() to locate item.
     *
     * @param item GroceryItem object
     * @return Returns true if item is removed and false if otherwise
     */
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

    /**
     * Takes the sum of all the GroceryItem objects' price values within the bag.
     *
     * @return Returns sum price of bag GroceryItem objects as a double
     */
    public double salesPrice() {
        double salesTotal = 0;
        for(int i = 0; i < this.size; i++) {
            salesTotal += this.bag[i].getPrice();
        }
        return salesTotal;
    }

    /**
     * Takes the sum of all "taxable" GroceryItem objects' price values multiplied by the constant 0.06625 within the bag.
     *
     * @return Returns sum price of bag's "taxable" GroceryItem objects multiplied by 0.06625 as a double
     */
    public double salesTax() {
        double taxTotal = 0;
        for(int i = 0; i < this.size; i++) {
            if(this.bag[i].isTaxable()) {
                taxTotal += this.bag[i].getPrice() * 0.06625;
            }
        }
        return taxTotal;
    }

    /**
     * Prints out the name, price, and taxable values of each GroceryItem object in the bag.
     */
    public void print() {
        for (int i = 0; i < this.size; i++) {
            System.out.println("·" + this.bag[i].toString());
        }
    }

    /**
     * Checks to see if the bag is empty.
     *
     * @return Returns true if empty and false otherwise
     */
    public boolean isEmpty() {
    	return this.size == 0;
    }

    /**
     * Returns the size value (number of items within the bag) of the respective ShoppingBag object.
     *
     * @return Number of items within the bag
     */
    public int getSize() {
    	return this.size;
    }

    /**
     * Testbed main for the ShoppingBag class.
     * @param args
     */
    public static void main(String[] args) {
        ShoppingBag testBag = new ShoppingBag();

        //Test to see if bag is initially empty
        testBag.testHelper();

        //Test for add()
        testBag.add(new GroceryItem("bread",2.15,false));

        testBag.testHelper();

        //Tests for add() up to max capacity
        testBag.add(new GroceryItem("milk",2.50,true));
        testBag.add(new GroceryItem("milk",2.50,true));
        testBag.add(new GroceryItem("milk",2.50,true));
        testBag.add(new GroceryItem("milk",2.50,true));

        testBag.testHelper();

        //Tests for add() past max capacity (and subsequently grow())
        testBag.add(new GroceryItem("bread",2,true));

        testBag.testHelper();

        //Tests for successful remove() (and subsequently find())
        testBag.remove(new GroceryItem("bread",2.15,false));

        testBag.testHelper();

        //Tests for unsuccessful remove() (and subsequently find())
        testBag.remove(new GroceryItem("bread",2.15,false));

        testBag.testHelper();
    }

    /**
     * Method that tests for salesPrice(), salesTax(), print(), getSize(), and isEmpty().
     */
    private void testHelper() {
        if(this.isEmpty()) {
            System.out.println("Bag is empty.");
        }
        else {
            System.out.println("Checking items, bag size, and capacity:");
            this.print();
            System.out.println("Current bag size (# of items): " + this.getSize());
            System.out.println("Current bag capacity: " + this.bag.length);
            System.out.println("Sales Price Total: " + this.salesPrice());
            System.out.println("Sales Tax Total: " + this.salesPrice());
        }
    }
}