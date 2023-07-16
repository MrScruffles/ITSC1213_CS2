/**
 * 
 * Represents a Cat, a type of Pet.
 * 
 * This class extends the Pet class and adds additional functionality specific
 * to a Cat.
 * 
 * @author Ash
 */
public class Cat extends Pet {
    private String breed;

    /**
     * 
     * Constructs a Cat object with the specified name, price, and breed.
     * 
     * @param name  the name of the Cat
     * @param price the price of the Cat
     * @param breed the breed of the Cat
     */
    public Cat(String name, double price, String breed) {
        super(name, price);
        this.breed = breed;
    }

    /**
     * 
     * Retrieves the breed of the Cat.
     * 
     * @return the breed of the Cat
     */
    public String getBreed() {
        return breed;
    }
}