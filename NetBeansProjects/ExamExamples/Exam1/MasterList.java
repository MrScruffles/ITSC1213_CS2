import java.util.ArrayList;

public class MasterList {
    private ArrayList<PopcornOrder> orders;

    public MasterList() {
        orders = new ArrayList<>();
    }

    public void addOrder(PopcornOrder order) {
        orders.add(order);
    }

    public int getTotalOrders() {
        int total = 0;
        for (PopcornOrder order : orders) {
            total += order.getNumOrdered();
        }
        return total;
    }

    public int removeVariety(String variety) {
        int removedCount = 0;
        for (int i = orders.size() - 1; i >= 0; i--) {
            PopcornOrder order = orders.get(i);
            if (order.getVariety().equals(variety)) {
                orders.remove(i);
                removedCount += order.getNumOrdered();
            }
        }
        return removedCount;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (orders.isEmpty()) {
            sb.append("No orders in the master list.");
        } else {
            for (PopcornOrder order : orders) {
                sb.append("Variety: ").append(order.getVariety())
                        .append(", Quantity: ").append(order.getNumOrdered())
                        .append("\n");
            }
        }
        return sb.toString();
    }
}
