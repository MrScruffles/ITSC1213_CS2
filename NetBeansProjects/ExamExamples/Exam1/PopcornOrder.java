public class PopcornOrder {
    private String variety;
    private int quantity;

    public PopcornOrder(String variety, int quantity) {
        this.variety = variety;
        this.quantity = quantity;
    }

    public String getVariety() {
        return variety;
    }

    public int getNumOrdered() {
        return quantity;
    }
}
