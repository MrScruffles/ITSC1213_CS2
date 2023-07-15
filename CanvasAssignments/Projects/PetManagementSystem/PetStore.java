/**
 *
 * @author Ash
 */

import java.util. *;
import java.util.ArrayList;
import java.util.Collections;

public class PetStore implements PetStoreSpecification {
    private String storeName;
    private ArrayList<Pet> availablePets;

    public PetStore(String storeName) {
        this.storeName = storeName;
        this.availablePets = new ArrayList<>();
    }

    public String getStoreName() {
        return storeName;
    }

    public void addPet(Pet pet) {
        availablePets.add(pet);
    }

    public void removePet(Pet pet) {
        availablePets.remove(pet);
    }

    @Override
    public void adoptionDrive(ArrayList<Object> pets) {
        for (Object pet : pets) {
            if (pet instanceof Pet) {
                removePet((Pet) pet);
                System.out.println("Congratulations on adopting " + pet.toString() + "!");
            } else {
                System.out.println("Invalid pet for adoption.");
            }
        }
    }

    @Override
    public double inventoryValue() {
        double value = 0;
        for (Pet pet : availablePets) {
            value += pet.getPrice();
        }
        return value;
    }

    public void sortPetsByName() {
        Collections.sort(availablePets);
    }
}
