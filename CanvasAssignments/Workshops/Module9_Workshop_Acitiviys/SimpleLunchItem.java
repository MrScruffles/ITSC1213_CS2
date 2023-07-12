// 1. Declare the SimpleLunchItem class.  It must implement the MenuItem interface.

// 2. declare the instance variables that you need for a simple item menu object

// 3. write a constructor that takes a String, and a double, in that order

// 4. write the getName method it should return the name of a simple item menu

// 5. write the getPrice method it should return the price of a simple item menu 

public abstract class SimpleLunchItem implements MenuItem {
    protected String name;
    protected double price;

    public SimpleLunchItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
