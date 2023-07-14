/**
 *
 * @author Ash
 */
public class Cat extends Pet {
    private String breed;

    public Cat(String name, double price, String breed) {
        super(name, price);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }
}
