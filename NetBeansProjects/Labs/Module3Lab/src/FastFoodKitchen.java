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
       * 
       * @param ham    Number of hamburgers.
       * @param cheese Number of cheeseburgers.
       * @param veggie Number of veggieburgers.
       * @param soda   Number of sodas.
       * @param toGo   If the order is to go.
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
       * 
       * @return true if an order was cancelled, false if the orderList was already
       *         empty.
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
  
      public int findOrderSeq(int orderID) {
          for (int i = 0; i < this.orderList.size(); i++) {
              Order order = this.orderList.get(i);
              if (order.getOrderNum() == orderID) {
                  return i; // Return the position (index + 1) of the order
              }
          }
          return -1; // Order not found
      }
  
      /**
       * Returns the number of orders currently in the orderList.
       * 
       * @return The number of orders.
       */
      public int getNumOrdersPending() {
          return this.orderList.size();
      }

        /**
       * Using selectionSort the orderList is sorted based on the total number of burgers.
       */
        public void selectionSort() {
        int n = orderList.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (getTotalBurgers(orderList.get(j)) < getTotalBurgers(orderList.get(minIndex))) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Order temp = orderList.get(i);
                orderList.set(i, orderList.get(minIndex));
                orderList.set(minIndex, temp);
            }
        }
    }
  
      /**
       * Using binary search to find specific order in a list of burger orders.
       */
        public int findOrderBin(int orderID) {
        int low = 0;
        int high = orderList.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Order order = orderList.get(mid);
            if (order.getOrderNum() == orderID) {
                return mid; // Order found
            } else if (order.getOrderNum() < orderID) {
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }

        return -1; // Order not found
    }

  
      /**
       * Sorts orderList using insertion sort algorithm based on the total number of
       * burgers in each order.
       */
      public void insertionSort() {
          int n = orderList.size();
          for (int i = 1; i < n; i++) {
              Order key = orderList.get(i);
              int j = i - 1;
  
              while (j >= 0 && getTotalBurgers(orderList.get(j)) > getTotalBurgers(key)) {
                  orderList.set(j + 1, orderList.get(j));
                  j = j - 1;
              }
              orderList.set(j + 1, key);
          }
      }
  
      private int getTotalBurgers(Order order) {
          return order.getNumCheeseburgers() + order.getNumHamburgers() + order.getNumSodas() + order.getNumVeggieburgers();
      }

    /**
     * Returns the orderList.
     * 
     * @return The orderList.
     */
    public ArrayList<Order> getOrderList() {
        return orderList;
    }
}
  
 
 