/**
 * Represents a PetStore that manages available pets and members.
 * 
 * This class provides methods to add and remove pets, add members, generate unique member IDs,
 * retrieve available pets, retrieve member lists, perform adoption drives, calculate inventory value,
 * and sort pets by name.
 * 
 * The PetStore stores the store name, available pets, members, and premium members.
 * It also keeps track of the last generated member ID for uniqueness.
 * 
 * The class implements the PetStoreSpecification interface to fulfill the required functionalities.
 * 
 * This class is meant to be extended and further customized based on specific requirements.
 * 
 * @author Ash
 */

import java.util.ArrayList;
import java.util.Collections;

public class PetStore implements PetStoreSpecification {
    private String storeName;
    private ArrayList<Pet> availablePets;
    private ArrayList<Member> members;
    private ArrayList<PremiumMember> premiumMembers;

    private static int lastMemberID = 0;

    /**
     * Constructs a PetStore object with the specified store name.
     * 
     * @param storeName the name of the pet store
     */
    public PetStore(String storeName) {
        this.storeName = storeName;
        this.availablePets = new ArrayList<>();
        this.members = new ArrayList<>();
        this.premiumMembers = new ArrayList<>();
    }

    /**
     * Generates a unique member ID.
     * 
     * @return the unique member ID
     */
    public int generateUniqueMemberID() {
        lastMemberID++;
        return lastMemberID;
    }

    /**
     * Retrieves the store name.
     * 
     * @return the store name
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * Adds a pet to the available pets list.
     * 
     * @param pet the pet to add
     */
    public void addPet(Pet pet) {
        availablePets.add(pet);
    }

    /**
     * Removes a pet from the available pets list.
     * 
     * @param pet the pet to remove
     */
    public void removePet(Pet pet) {
        availablePets.remove(pet);
    }

    /**
     * Retrieves a copy of the member list.
     * 
     * @return a copy of the member list
     */
    public ArrayList<Member> getMemberList() {
        return new ArrayList<>(members);
    }

    /**
     * Retrieves a copy of the premium member list.
     * 
     * @return a copy of the premium member list
     */
    public ArrayList<PremiumMember> getPremiumMemberList() {
        return new ArrayList<>(premiumMembers);
    }

    /**
     * Adds a new member to the member list.
     * 
     * @param member the member to add
     */
    public void addNewMember(Member member) {
        members.add(member);
    }

    /**
     * Adds a new premium member to the premium member list.
     * 
     * @param premiumMember the premium member to add
     */
    public void addNewPremiumMember(PremiumMember premiumMember) {
        premiumMembers.add(premiumMember);
    }

    /**
     * Retrieves the available dogs.
     * 
     * @return a list of available dogs
     */
    public ArrayList<Dog> getAvailableDogs() {
        ArrayList<Dog> availableDogs = new ArrayList<>();
        for (Pet pet : availablePets) {
            if (pet instanceof Dog) {
                availableDogs.add((Dog) pet);
            }
        }
        return availableDogs;
    }

    /**
     * Retrieves the available cats.
     * 
     * @return a list of available cats
     */
    public ArrayList<Cat> getAvailableCats() {
        ArrayList<Cat> availableCats = new ArrayList<>();
        for (Pet pet : availablePets) {
            if (pet instanceof Cat) {
                availableCats.add((Cat) pet);
            }
        }
        return availableCats;
    }

    /**
     * Retrieves the available exotic pets.
     * 
     * @return a list of available exotic pets
     */
    public ArrayList<ExoticPet> getAvailableExoticPets() {
        ArrayList<ExoticPet> availableExoticPets = new ArrayList<>();
        for (Pet pet : availablePets) {
            if (pet instanceof ExoticPet) {
                availableExoticPets.add((ExoticPet) pet);
            }
        }
        return availableExoticPets;
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

    /**
     * Sorts the available pets by name.
     */
    public void sortPetsByName() {
        Collections.sort(availablePets);
    }
}
