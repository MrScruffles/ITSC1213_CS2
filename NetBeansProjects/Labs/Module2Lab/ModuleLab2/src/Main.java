/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 import java.util.Scanner;

 /**
  *
  * @author ash
  */
 
 //public class Main {
 //    public static void main(String[] args) {
 //        Order order1 = new Order(3, 5, 4, 10, true, 1);
 //        Order order2 = new Order(0, 0, 3, 3, false, 2);
 //        Order order3 = new Order(1, 1, 0, 2, false, 3);
 //
 //        System.out.println(
 //            "Order{" + "numHamburgers=" + order1.getNumHamburgers() + ", numCheeseburgers="
 //            + order1.getNumCheeseburgers() + ", numVeggieburgers=" + order1.getNumVeggieburgers()
 //            + ", numSodas=" + order1.getNumSodas() + ", orderToGo=" + order1.isOrderToGo() + ", orderNum=" + order1.getOrderNum() + '}');
 //        
 //                System.out.println(
 //            "Order{" + "numHamburgers=" + order2.getNumHamburgers() + ", numCheeseburgers="
 //            + order2.getNumCheeseburgers() + ", numVeggieburgers=" + order2.getNumVeggieburgers()
 //            + ", numSodas=" + order2.getNumSodas() + ", orderToGo=" + order2.isOrderToGo() + ", orderNum=" + order2.getOrderNum() + '}');
 //                
 //                        System.out.println(
 //            "Order{" + "numHamburgers=" + order3.getNumHamburgers() + ", numCheeseburgers="
 //            + order3.getNumCheeseburgers() + ", numVeggieburgers=" + order3.getNumVeggieburgers()
 //            + ", numSodas=" + order3.getNumSodas() + ", orderToGo=" + order3.isOrderToGo() + ", orderNum=" + order3.getOrderNum() + '}');
 //    }
 //}
 
 public class Main {
    public static void main(String[] args) {
        FastFoodKitchen kitchen = new FastFoodKitchen();
        Scanner sc = new Scanner(System.in);

        while (true) {
            // see what the user wants to do
            System.out.println("Please select from the following menu of options, by typing a number:");
            System.out.println("\t 1. Order food");
            System.out.println("\t 2. Cancel last order");
            System.out.println("\t 3. Show number of orders currently pending.");
            System.out.println("\t 4. Check order status");
            System.out.println("\t 5. Cancel an order");
            System.out.println("\t 6. Exit");

            int num = sc.nextInt();
            switch (num) {
                case 1:
                    System.out.println("How many hamburgers do you want?");
                    int ham = sc.nextInt();
                    System.out.println("How many cheeseburgers do you want?");
                    int cheese = sc.nextInt();
                    System.out.println("How many veggieburgers do you want?");
                    int veggie = sc.nextInt();
                    System.out.println("How many sodas do you want?");
                    int sodas = sc.nextInt();
                    System.out.println("Is your order to go? (Y/N)");
                    char letter = sc.next().charAt(0);
                    boolean toGo = false;
                    if (letter == 'Y' || letter == 'y') {
                        toGo = true;
                    }
                    int orderNum = kitchen.addOrder(ham, cheese, veggie, sodas, toGo);
                    System.out.println("Thank you. Your order number is " + orderNum);
                    System.out.println();
                    break;
                case 2:
                    boolean cancelled = kitchen.cancelLastOrder();
                    if (cancelled) {
                        System.out.println("Thank you. The last order has been canceled.");
                    } else {
                        System.out.println("Sorry. There are no orders to cancel.");
                    }
                    System.out.println();
                    break;
                case 3:
                    int numOrders = kitchen.getNumOrdersPending();
                    System.out.println("There are " + numOrders + " pending orders.");
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Enter the order number you want to check:");
                    int orderID = sc.nextInt();
                    boolean orderDone = kitchen.isOrderDone(orderID);
                    if (orderDone) {
                        System.out.println("Your order has been completed.");
                    } else {
                        System.out.println("Your order is being prepared.");
                    }
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Enter the order number you want to cancel:");
                    int cancelID = sc.nextInt();
                    boolean orderCancelled = kitchen.cancelOrder(cancelID);
                    if (orderCancelled) {
                        System.out.println("Your order has been successfully cancelled.");
                    } else {
                        System.out.println("Sorry, we can't find your order number in the system.");
                    }
                    System.out.println();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Sorry, but you need to enter a valid option (1-6)");
                    System.out.println();
            }
        }
    }
}
