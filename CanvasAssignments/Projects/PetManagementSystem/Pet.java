import java.util.*;

/**
 *
 * @author Ash
 */
public abstract class Pet implements Comparable<Pet> {
    private String name;
    private double price;

    public Pet(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Pet otherPet) {
        return this.name.compareTo(otherPet.name);
    }
}
