package CanvasAssignments.Projects.Project_2;

import java.util.ArrayList;
import java.io.*;

public class FastFoodKitchen {
    private ArrayList<BurgerOrder> orderList = new ArrayList<>();
    private ArrayList<String> orderLog = new ArrayList<>(); // Logging mechanism
    private static int nextOrderNum = 1;

    FastFoodKitchen() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./CanvasAssignments/Projects/Project_2/burgerOrders.csv"));
            String line = reader.readLine(); // Read the header line
            while ((line = reader.readLine()) != null) {
                String[] orderDetails = line.split(",");
                int ham = Integer.parseInt(orderDetails[1].trim());
                int cheese = Integer.parseInt(orderDetails[2].trim());
                int veggie = Integer.parseInt(orderDetails[3].trim());
                int soda = Integer.parseInt(orderDetails[4].trim());
                boolean toGo = Boolean.parseBoolean(orderDetails[5].trim());
                orderList.add(new BurgerOrder(ham, cheese, veggie, soda, toGo, getNextOrderNum()));
                incrementNextOrderNum();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("The specified file was not found.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    public static int getNextOrderNum() {
        return nextOrderNum;
    }

    private void incrementNextOrderNum() {
        nextOrderNum++;
    }

    public int addOrder(int ham, int cheese, int veggie, int soda, boolean toGo) {
        int orderNum = getNextOrderNum();
        BurgerOrder newOrder = new BurgerOrder(ham, cheese, veggie, soda, toGo, orderNum);
        orderList.add(newOrder);
        incrementNextOrderNum();
        orderCallOut(newOrder);
        orderLog.add(orderDetails(newOrder, "Pending")); // Logging detailed order as "Pending"
        return orderNum;
    }
    

    public boolean isOrderDone(int orderID) {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getOrderNum() == orderID) {
                return false;
            }
        }
        return true;
    }

    public boolean cancelOrder(int orderID) {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getOrderNum() == orderID) {
                orderLog.add(orderDetails(orderList.get(i), "Canceled")); // Logging detailed order as "Canceled"
                orderList.remove(i);
                return true;
            }
        }
        return false;
    }
    
    // Helper method to format order details for logging
    private String orderDetails(BurgerOrder order, String status) {
    return "Order ID: " + order.getOrderNum() + "\n" +
           "Hamburgers: " + order.getNumHamburgers() + "\n" +
           "Cheeseburgers: " + order.getNumCheeseburgers() + "\n" +
           "Veggieburgers: " + order.getNumVeggieburgers() + "\n" +
           "Sodas: " + order.getNumSodas() + "\n" +
           "Status: " + status + "\n";
}

    public int getNumOrdersPending() {
        return orderList.size();
    }

    public boolean cancelLastOrder() {
        if (!orderList.isEmpty()) {
            orderList.remove(orderList.size() - 1);
            orderLog.add("Last order canceled."); // Logging
            return true;
        }
        return false;
    }

    private void orderCallOut(BurgerOrder order) {
        if (order.getNumCheeseburgers() > 0) {
            System.out.println("You have " + order.getNumHamburger() + " hamburgers");
        }
        if (order.getNumCheeseburgers() > 0) {
            System.out.println("You have " + order.getNumCheeseburgers() + " cheeseburgers");
        }
        if (order.getNumVeggieburgers() > 0) {
            System.out.println("You have " + order.getNumVeggieburgers() + " veggieburgers");
        }
        if (order.getNumSodas() > 0) {
            System.out.println("You have " + order.getNumSodas() + " sodas");
        }
    }

    public void completeSpecificOrder(int orderID) {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getOrderNum() == orderID) {
                System.out.println("Order number " + orderID + " is done!");
                orderLog.add(orderDetails(orderList.get(i), "Completed")); // Logging detailed order as "Completed"
                if (orderList.get(i).isOrderToGo()) {
                    orderCallOut(orderList.get(i));
                }
                orderList.remove(i);
            }
        }
    }
    

    public void completeNextOrder() {
        int nextOrder = orderList.get(0).getOrderNum();
        completeSpecificOrder(nextOrder);
    }

    public ArrayList<BurgerOrder> getOrderList() {
        return orderList;
    }

    public int findOrderSeq(int whatWeAreLookingFor) {
        for (int j = 0; j < orderList.size(); j++) {
            if (orderList.get(j).getOrderNum() == whatWeAreLookingFor) {
                return j;
            }
        }
        return -1;
    }

    public int findOrderBin(int orderID){
        int left = 0;
        int right = orderList.size()-1;
        while (left <= right){
            int middle = ((left + right)/2);
            if (orderID < orderList.get(middle).getOrderNum()){
                right = middle-1;
            } else if(orderID > orderList.get(middle).getOrderNum()){
                left = middle +1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public void selectionSort(){
        for (int i = 0; i< orderList.size()-1; i++){
            int minIndex = i;
            for (int k = i+1; k < orderList.size(); k++){
                if (orderList.get(minIndex).getTotalBurgers() > orderList.get(k).getTotalBurgers()){
                    minIndex = k;
                }
            }
            BurgerOrder temp = orderList.get(i);
            orderList.set(i , orderList.get(minIndex));
            orderList.set(minIndex, temp);
        }
    }

    public void insertionSort() {
        for (int j = 1; j < orderList.size(); j++) {
            BurgerOrder temp = orderList.get(j);
            int possibleIndex = j;
            while (possibleIndex > 0 && temp.getTotalBurgers() < orderList.get(possibleIndex - 1).getTotalBurgers()) {
                orderList.set(possibleIndex, orderList.get(possibleIndex - 1));
                possibleIndex--;
            }
            orderList.set(possibleIndex, temp);
        }
    }

    public void generateEndOfDayReport() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("./CanvasAssignments/Projects/Project_2/endOfDayReport.txt"));

            writer.write("End of Day Report\n");
            writer.write("====================\n\n");

            writer.write("Order Log:\n");
            writer.write("====================\n");
            for (String logEntry : orderLog) {
                writer.write(logEntry + "\n");
            }
            writer.write("\n");

            int totalHamburgers = 0;
            int totalCheeseburgers = 0;
            int totalVeggieburgers = 0;
            int totalSodas = 0;

            for (BurgerOrder order : orderList) {
                writer.write("Order ID: " + order.getOrderNum() + "\n");
                writer.write("Hamburgers: " + order.getNumHamburgers() + "\n");
                writer.write("Cheeseburgers: " + order.getNumCheeseburgers() + "\n");
                writer.write("Veggieburgers: " + order.getNumVeggieburgers() + "\n");
                writer.write("Sodas: " + order.getNumSodas() + "\n");
                writer.write("Status: " + (isOrderDone(order.getOrderNum()) ? "Completed" : "Pending") + "\n\n");

                totalHamburgers += order.getNumHamburgers();
                totalCheeseburgers += order.getNumCheeseburgers();
                totalVeggieburgers += order.getNumVeggieburgers();
                totalSodas += order.getNumSodas();
            }

            writer.write("Total Hamburgers Sold: " + totalHamburgers + "\n");
            writer.write("Total Cheeseburgers Sold: " + totalCheeseburgers + "\n");
            writer.write("Total Veggieburgers Sold: " + totalVeggieburgers + "\n");
            writer.write("Total Sodas Sold: " + totalSodas + "\n");

            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("The specified file was not found.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public void generateUpdatedOrdersFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("./CanvasAssignments/Projects/Project_2/burgerOrders2.csv"));

            writer.write("orderID,numHamburgers,numCheeseburgers,numVeggieburgers,numSodas,toGo\n");

            for (BurgerOrder order : orderList) {
                if (!isOrderDone(order.getOrderNum())) {
                    writer.write(order.getOrderNum() + "," + order.getNumHamburgers() + "," + 
                                 order.getNumCheeseburgers() + "," + order.getNumVeggieburgers() + "," + 
                                 order.getNumSodas() + "," + order.isToGo() + "\n");
                }
            }

            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("The specified file was not found.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
