/**
 *
 * @author Ash
 */
public class Dog extends Pet {
    private String breed;

    public Dog(String name, double price, String breed) {
        super(name, price);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }
}
