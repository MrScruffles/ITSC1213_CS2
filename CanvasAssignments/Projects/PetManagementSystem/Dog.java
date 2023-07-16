/**
 * Represents a Dog, a type of Pet.
 * 
 * This class extends the Pet class and adds additional functionality specific to a Dog.
 * 
 * @author Ash
 */
public class Dog extends Pet {
    private String breed;

    /**
     * Constructs a Dog object with the specified name, price, and breed.
     * 
     * @param name the name of the Dog
     * @param price the price of the Dog
     * @param breed the breed of the Dog
     */
    public Dog(String name, double price, String breed) {
        super(name, price);
        this.breed = breed;
    }

    /**
     * Retrieves the breed of the Dog.
     * 
     * @return the breed of the Dog
     */
    public String getBreed() {
        return breed;
    }
}
