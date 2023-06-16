public class Main {

    public static void main(String[] args) {
        // Demonstrate how the MasterList class keeps track of orders
        System.out.println("***********************************");
        System.out.println("Popcorn order list");
        System.out.println("***********************************");

        // 1. Create a master list of popcorn orders named popcorn2023
        MasterList popcorn2023 = new MasterList();

        // 2. Add popcorn orders received so far
        popcorn2023.addOrder(new PopcornOrder("Butter Microwave", 3));
        popcorn2023.addOrder(new PopcornOrder("Classic Caramel Corn", 2));
        popcorn2023.addOrder(new PopcornOrder("Sea Salt Splash", 5));

        // 3. Call the toString() and print what it returns to ensure the ArrayList is filled correctly
        System.out.println(popcorn2023.toString());

        // 4. Test the other methods of the MasterList class by using print statements to check the return values
        System.out.println("Total orders: " + popcorn2023.getTotalOrders());
        System.out.println("Removed orders: " + popcorn2023.removeVariety("Butter Microwave"));
        System.out.println("Removed orders: " + popcorn2023.removeVariety("Cheddar Cheese"));
        System.out.println("Total orders: " + popcorn2023.getTotalOrders());

        // 5. Call the toString() again to verify the master list was updated and all "Butter Microwave" orders have been removed
        System.out.println(popcorn2023.toString());

        // 6. Create a new ArrayList called popcorn2024 to get ready for next year
        MasterList popcorn2024 = new MasterList();

        // 7. Call the following methods to ensure an empty ArrayList does not cause any errors
        System.out.println("Total orders: " + popcorn2024.getTotalOrders());
        System.out.println("Removed orders: " + popcorn2024.removeVariety("Sea Salt Splash"));
        System.out.println(popcorn2024.toString());
    }
}
