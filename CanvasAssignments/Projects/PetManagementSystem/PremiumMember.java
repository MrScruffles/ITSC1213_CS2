/**
 * Represents a Premium Member in a pet club.
 * 
 * This class extends the Member class and adds additional functionality specific to a Premium Member.
 * 
 * A Premium Member is a member who has paid their dues.
 * 
 * Premium Members inherit the properties and methods from the Member class.
 * They have an additional property to track their dues payment status.
 * 
 * Premium Members can be created with a name, member ID, newsletter subscription status, and dues payment status.
 * They have methods to retrieve and update the dues payment status.
 * 
 * Premium Members are intended to be used in the context of the PetStore or its subclasses.
 * 
 * @author Ash
 */
public class PremiumMember extends Member {
    private boolean duesPaid;

    /**
     * Constructs a PremiumMember object with the specified name, member ID, newsletter subscription status, and dues payment status.
     * 
     * @param name the name of the PremiumMember
     * @param memberID the member ID of the PremiumMember
     * @param newsletterSubscribed the newsletter subscription status of the PremiumMember
     * @param duesPaid the dues payment status of the PremiumMember
     */
    public PremiumMember(String name, int memberID, boolean newsletterSubscribed, boolean duesPaid) {
        super(name, memberID, newsletterSubscribed);  // call the superclass constructor
        this.duesPaid = duesPaid;
    }

    /**
     * Checks if the dues payment is paid for the Premium Member.
     * 
     * @return true if dues are paid, false otherwise
     */
    public boolean isDuesPaid() {
        return duesPaid;
    }

    /**
     * Updates the dues payment status for the Premium Member.
     * 
     * @param duesPaid the new dues payment status
     */
    public void setDuesPaid(boolean duesPaid) {
        this.duesPaid = duesPaid;
    }
}
