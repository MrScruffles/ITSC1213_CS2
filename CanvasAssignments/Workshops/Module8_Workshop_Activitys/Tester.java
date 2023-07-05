import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.add(new Item("bread", 3.25));
        cart.add(new Item("milk", 2.50));

        cart.add(new DiscountedItem("ice cream", 4.50, 1.50));
        cart.add(new DiscountedItem("apples", 1.35, 0.25));

        cart.printOrder();
    }
}

class DiscountedItem extends Item {
    private double discount;

    public DiscountedItem(String name, double price, double discount) {
        super(name, price);
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return super.toString() + " (" + valueToString(-discount) + ")";
    }

    @Override
    public String valueToString(double value) {
        String result = super.valueToString(value);
        return result.substring(0, result.length() - 1); // Remove the "$" symbol from super's valueToString()
    }
}


class ShoppingCart {
    private ArrayList<Item> order;
    private double total;
    private double internalDiscount;

    public ShoppingCart() {
        order = new ArrayList<Item>();
        total = 0.0;
        internalDiscount = 0.0;
    }

    public void add(Item i) {
        order.add(i);
        total += i.getPrice();
        if (i instanceof DiscountedItem)
            internalDiscount += ((DiscountedItem) i).getDiscount();
    }

    public void printOrder() {
        System.out.println(this);
    }

    public String toString() {
        return discountToString();
    }

    public String discountToString() {
        return orderToString() + "\nSub-total: " + valueToString(total) + "\nDiscount: " + valueToString(internalDiscount) + "\nTotal: " + valueToString(total - internalDiscount);
    }

    private String valueToString(double value) {
        value = Math.rint(value * 100) / 100.0;
        String result = "" + Math.abs(value);
        if (result.indexOf(".") == result.length() - 2) {
            result += "0";
        }
        result = "$" + result;
        return result;
    }

    public String orderToString() {
        String build = "\nOrder Items:\n";
        for (int i = 0; i < order.size(); i++) {
            build += "   " + order.get(i);
            if (i != order.size() - 1) {
                build += "\n";
            }
        }
        return build;
    }
}

class Item {
    private String name;
    private double price;

    public Item() {
        this.name = "";
        this.price = 0.0;
    }

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String valueToString(double value) {
        String result = "" + Math.abs(value);
        if (result.indexOf(".") == result.length() - 2) {
            result += "0";
        }
        result = "$" + result;
        return result;
    }

    public String toString() {
        return name + " " + valueToString(price);
    }
}
