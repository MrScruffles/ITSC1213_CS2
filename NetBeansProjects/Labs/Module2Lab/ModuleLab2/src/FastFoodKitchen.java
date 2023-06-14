/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 import java.util.ArrayList;


 /**
  *
  * @author ash
  */
 
 public class FastFoodKitchen {
     private ArrayList<Order> orderList = new ArrayList<>();
     private static int nextOrderNum = 1;
 
     public FastFoodKitchen() {
         this.orderList.add(new Order(3, 5, 4, 10, true, FastFoodKitchen.getNextOrderNum()));
         incrementNextOrderNum();
         this.orderList.add(new Order(0, 0, 3, 3, false, FastFoodKitchen.getNextOrderNum()));
         incrementNextOrderNum();
         this.orderList.add(new Order(1, 1, 0, 2, false, FastFoodKitchen.getNextOrderNum()));
         incrementNextOrderNum();
     }
 
     public static int getNextOrderNum() {
         return nextOrderNum;
     }
 
     private static void incrementNextOrderNum() {
         nextOrderNum++;
     }
 
     /**
      * Adds a new Order to the orderList.
      * @param ham Number of hamburgers.
      * @param cheese Number of cheeseburgers.
      * @param veggie Number of veggieburgers.
      * @param soda Number of sodas.
      * @param toGo If the order is to go.
      * @return The order number of the newly created order.
      */
     public int addOrder(int ham, int cheese, int veggie, int soda, boolean toGo) {
         Order newOrder = new Order(ham, cheese, veggie, soda, toGo, FastFoodKitchen.getNextOrderNum());
         this.orderList.add(newOrder);
         incrementNextOrderNum();
         return newOrder.getOrderNum();
     }
 
     /**
      * Cancels the last order in the orderList.
      * @return true if an order was cancelled, false if the orderList was already empty.
      */
     public boolean cancelLastOrder() {
         if (!this.orderList.isEmpty()) {
             this.orderList.remove(this.orderList.size() - 1);
             nextOrderNum--;
             return true;
         } else {
             return false;
         }
     }

     public boolean isOrderDone(int orderID) {
        for (Order order : this.orderList) {
            if (order.getOrderNum() == orderID) {
                return false; // Order is still in progress
            }
        }
        return true; // Order is done
    }
    
    public boolean cancelOrder(int orderID) {
        for (Order order : this.orderList) {
            if (order.getOrderNum() == orderID) {
                this.orderList.remove(order); // Remove the order from the list
                return true; // Order cancelled
            }
        }
        return false; // No matching order found, cancellation failed
    }
    

     /**
      * Returns the number of orders currently in the orderList.
      * @return The number of orders.
      */
     public int getNumOrdersPending() {
         return this.orderList.size();
     }
 }
 
 