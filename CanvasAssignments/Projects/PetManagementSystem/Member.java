import java.util.ArrayList;

/**
 * Represents a Member in a pet club.
 * 
 * This class stores information about a member, including their name, member ID,
 * newsletter subscription status, pets owned, and amount spent.
 * 
 * It provides methods to manage the member's information and pets.
 * 
 * The member can own dogs, cats, and exotic pets.
 * 
 * The class also provides a method to display the pets owned by the member.
 * 
 * @author Ash
 */
public class Member {
    
    private String name;
    private int memberID;
    private boolean newsletterSubscribed;
    private ArrayList<Dog> dogsOwned = new ArrayList<>();
    private ArrayList<Cat> catsOwned = new ArrayList<>();
    private ArrayList<ExoticPet> exoticPetsOwned = new ArrayList<>();
    private double amountSpent = 0;

    /**
     * Constructs a Member object with the specified name, member ID, and newsletter subscription status.
     * 
     * @param name the name of the member
     * @param memberID the member ID
     * @param newsletterSubscribed the newsletter subscription status
     */
    public Member(String name, int memberID, boolean newsletterSubscribed) {
        this.name = name;
        this.memberID = memberID;
        this.newsletterSubscribed = newsletterSubscribed;
    }

    /**
     * Retrieves the name of the member.
     * 
     * @return the name of the member
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the member ID.
     * 
     * @return the member ID
     */
    public int getMemberID() {
        return memberID;
    }

    /**
     * Checks if the member is subscribed to the newsletter.
     * 
     * @return true if the member is subscribed to the newsletter, false otherwise
     */
    public boolean isNewsletterSubscribed() {
        return newsletterSubscribed;
    }

    /**
     * Retrieves the list of dogs owned by the member.
     * 
     * @return the list of dogs owned by the member
     */
    public ArrayList<Dog> getDogsOwned() {
        return dogsOwned;
    }

    /**
     * Retrieves the list of cats owned by the member.
     * 
     * @return the list of cats owned by the member
     */
    public ArrayList<Cat> getCatsOwned() {
        return catsOwned;
    }

    /**
     * Retrieves the list of exotic pets owned by the member.
     * 
     * @return the list of exotic pets owned by the member
     */
    public ArrayList<ExoticPet> getExoticPetsOwned() {
        return exoticPetsOwned;
    }

    /**
     * Retrieves the amount spent by the member.
     * 
     * @return the amount spent by the member
     */
    public double getAmountSpent() {
        return amountSpent;
    }

    /**
     * Sets the name of the member.
     * 
     * @param name the name of the member
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the member ID.
     * 
     * @param memberID the member ID
     */
    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    /**
     * Sets the newsletter subscription status of the member.
     * 
     * @param newsletterSubscribed the newsletter subscription status
     */
    public void setNewsletterSubscribed(boolean newsletterSubscribed) {
        this.newsletterSubscribed = newsletterSubscribed;
    }

    /**
     * Sets the amount spent by the member.
     * 
     * @param amountSpent the amount spent
     */
    public void setAmountSpent(double amountSpent) {
        this.amountSpent += amountSpent;
    }
     
    /**
     * Adds a dog to the list of dogs owned by the member.
     * 
     * @param dog the dog to add
     */
    public void addDog(Dog dog) {
        dogsOwned.add(dog);
    }
    
    /**
     * Adds a cat to the list of cats owned by the member.
     * 
     * @param cat the cat to add
     */
    public void addCat(Cat cat) {
        catsOwned.add(cat);
    }
    
    /**
     * Adds an exotic pet to the list of exotic pets owned by the member.
     * 
     * @param exoticPet the exotic pet to add
     */
    public void addExoticPet(ExoticPet exoticPet) {
        exoticPetsOwned.add(exoticPet);
    }

    /**
     * Displays the pets owned by the member.
     */
    public void displayPets() {
        System.out.println("Dogs owned:");
        for (Dog dog : dogsOwned) {
            System.out.println("\t" + dog.getName());
        }
        System.out.println("Cats owned:");
        for (Cat cat : catsOwned) {
            System.out.println("\t" + cat.getName());
        }
        System.out.println("Exotic pets owned:");
        for (ExoticPet exoticPet : exoticPetsOwned) {
            System.out.println("\t" + exoticPet.getName());
        }
    }
}
