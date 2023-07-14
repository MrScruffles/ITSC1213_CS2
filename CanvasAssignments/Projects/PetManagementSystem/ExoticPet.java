/**
 *
 * @author Ash
 */
public class ExoticPet extends Pet {
    private String type;

    public ExoticPet(String name, double price, String type) {
        super(name, price);
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
