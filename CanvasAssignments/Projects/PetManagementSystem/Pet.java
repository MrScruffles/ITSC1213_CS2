/**
 * Represents an abstract Pet.
 * 
 * This class provides a common blueprint for different types of pets.
 * It implements the Comparable interface to enable sorting of pets based on their names.
 * 
 * Subclasses are expected to provide concrete implementations for specific pet types.
 * 
 * The Pet class stores information about the pet's name and price.
 * It also provides methods to retrieve the name and price, and overrides the toString method.
 * 
 * Pets can be compared based on their names using the compareTo method.
 * 
 * @author Ash
 */
public abstract class Pet implements Comparable<Pet> {
    private String name;
    private double price;

    /**
     * Constructs a Pet object with the specified name and price.
     * 
     * @param name the name of the pet
     * @param price the price of the pet
     */
    public Pet(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Retrieves the name of the pet.
     * 
     * @return the name of the pet
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the price of the pet.
     * 
     * @return the price of the pet
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns a string representation of the pet.
     * 
     * @return the name of the pet
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Compares this pet with another pet based on their names.
     * 
     * @param otherPet the other pet to compare
     * @return a negative integer, zero, or a positive integer as this pet is less than, equal to, or greater than the other pet
     */
    @Override
    public int compareTo(Pet otherPet) {
        return this.name.compareTo(otherPet.name);
    }
}
