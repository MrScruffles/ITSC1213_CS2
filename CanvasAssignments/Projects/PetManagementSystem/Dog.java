/**
 *
 * @author Ash
 */
public class Dog extends Pet {
    private String breed;

    public Dog(String name, String breed, String sex, int age, double weight, int ID, double price) {
        super(name, sex, age, weight, ID, price);
        this.breed = breed;
    }

    // ... getters and setters ...
    
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
