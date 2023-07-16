/**
 * Represents an ExoticPet, a type of Pet.
 * 
 * This class extends the Pet class and adds additional functionality specific to an ExoticPet.
 * 
 * @author Ash
 */
public class ExoticPet extends Pet {
    private String type;

    /**
     * Constructs an ExoticPet object with the specified name, price, and type.
     * 
     * @param name the name of the ExoticPet
     * @param price the price of the ExoticPet
     * @param type the type of the ExoticPet
     */
    public ExoticPet(String name, double price, String type) {
        super(name, price);
        this.type = type;
    }

    /**
     * Retrieves the type of the ExoticPet.
     * 
     * @return the type of the ExoticPet
     */
    public String getType() {
        return type;
    }
}
