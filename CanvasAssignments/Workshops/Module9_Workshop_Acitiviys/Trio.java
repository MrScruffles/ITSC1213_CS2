// 1. Declare the Trio class.  It must implement the MenuItem interface.

// 2. declare the instance variables that you need for a trio object

// 3. write a constructor that takes a Sandwich, Salad, and a Drink, in that order

// 4. write the getName method it should return sandwich name/salad name/drink name Trio

// 5. write the getPrice method it should return the price of the two highest price items in the trio.

public class Trio implements MenuItem {
    private Sandwich sandwich;
    private Salad salad;
    private Drink drink;

    public Trio(Sandwich sandwich, Salad salad, Drink drink) {
        this.sandwich = sandwich;
        this.salad = salad;
        this.drink = drink;
    }

    public String getName() {
        return sandwich.getName() + "/" + salad.getName() + "/" + drink.getName() + " Trio";
    }

    public double getPrice() {
        double sandwichPrice = sandwich.getPrice();
        double saladPrice = salad.getPrice();
        double drinkPrice = drink.getPrice();

        // The price of the Trio is the sum of the two highest-priced items.
        if (sandwichPrice < saladPrice) {
            if (sandwichPrice < drinkPrice) {
                return saladPrice + drinkPrice;
            } else {
                return sandwichPrice + saladPrice;
            }
        } else {
            if (saladPrice < drinkPrice) {
                return sandwichPrice + drinkPrice;
            } else {
                return sandwichPrice + saladPrice;
            }
        }
    }
}
