package CanvasAssignments.Projects.Project_2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * ITSC 1213 
 * University of North Carolina at Charlotte
 */

public class FastFoodKitchenDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        FastFoodKitchen kitchen = new FastFoodKitchen();

        try (Scanner sc = new Scanner(System.in)) {
            while (kitchen.getNumOrdersPending() != 0) {
                // see what the user wants to do
                System.out.println("Please select from the following menu of options, by typing a number:");
                System.out.println("\t 1. Order food");
                System.out.println("\t 2. Cancel last order");
                System.out.println("\t 3. Show number of orders currently pending");
                System.out.println("\t 4. Complete order");
                System.out.println("\t 5. Check on order");
                System.out.println("\t 6. Cancel order");
                System.out.println("\t 7. Exit");

                int num = getIntInput(sc);
                switch (num) {
                    case 1:
                        System.out.println("How many hamburgers do you want?");
                        int ham = getIntInput(sc);
                        System.out.println("How many cheeseburgers do you want?");
                        int cheese = getIntInput(sc);
                        System.out.println("How many veggieburgers do you want?");
                        int veggie = getIntInput(sc);
                        System.out.println("How many sodas do you want?");
                        int sodas = getIntInput(sc);
                        System.out.println("Is your order to go? (Y/N)");
                        char letter = sc.next().charAt(0);
                        boolean TOGO = false;
                        if (letter == 'Y' || letter == 'y') {
                            TOGO = true;
                        }
                        int orderNum = kitchen.addOrder(ham, cheese, veggie, sodas, TOGO);
                        System.out.println("Thank you. Your order number is " + orderNum);
                        System.out.println();
                        break;
                    case 2:
                        boolean ready = kitchen.cancelLastOrder();
                        if (ready) {
                            System.out.println("Thank you. The last order has been canceled");
                        } else {
                            System.out.println("Sorry. There are no orders to cancel.");
                        }
                        System.out.println();
                        break;
                    case 3:
                        System.out.println("There are " + kitchen.getNumOrdersPending() + " pending orders");
                        break;
                    case 4:
                        System.out.println("Enter order number to complete?");
                        int order = getIntInput(sc);
                        kitchen.completeSpecificOrder(order);
                        System.out.println("Your order is ready. Thank you!");
                        break;
                    case 5:
                        System.out.println("What is your order number?");
                        order = getIntInput(sc);
                        ready = kitchen.isOrderDone(order);
                        if (ready) {
                            System.out.println("Sorry, no order with this number was found.");
                        } else {
                            System.out.println("No, it's not ready, but it should be up soon. Sorry for the wait.");
                        }
                        System.out.println();
                        break;
                    case 6:
                        System.out.println("What is your order number?");
                        order = getIntInput(sc);
                        boolean cancel = kitchen.cancelOrder(order);
                        if (cancel) {
                            System.out.println("Your order has been successfully cancelled ");
                        } else {
                            System.out.println("Sorry, we can’t find your order number in the system");
                        }
                        System.out.println();
                        break;
                    case 7:
                        //Part B
                        kitchen.generateEndOfDayReport();
                        kitchen.generateUpdatedOrdersFile();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Sorry, but you need to enter a 1, 2, 3, 4, 5, 6, or a 7");
                } //end switch
            } //end while loop 
        }
    } // end main

    private static int getIntInput(Scanner sc) {
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number!");
                sc.next(); // Clear the invalid input
            }
        }
    }
}// end class
