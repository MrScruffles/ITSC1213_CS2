/**
 *
 * @author Ash
 */

 public class PremiumMember extends Member {
    private boolean duesPaid;

    public PremiumMember(String name, int memberID, boolean newsletterSubscribed, boolean duesPaid) {
        super(name, memberID, newsletterSubscribed);  // call the superclass constructor
        this.duesPaid = duesPaid;
    }

    public boolean isDuesPaid() {
        return duesPaid;
    }

    public void setDuesPaid(boolean duesPaid) {
        this.duesPaid = duesPaid;
    }
}
