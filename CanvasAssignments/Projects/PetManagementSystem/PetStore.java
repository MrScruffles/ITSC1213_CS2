/**
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

    public PetStore(String storeName) {
        this.storeName = storeName;
        this.availablePets = new ArrayList<>();
        this.members = new ArrayList<>();
        this.premiumMembers = new ArrayList<>();
    }

    public int generateUniqueMemberID() {
        lastMemberID++;
        return lastMemberID;
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

    public ArrayList<Member> getMemberList() {
        return new ArrayList<>(members);
    }

    public ArrayList<PremiumMember> getPremiumMemberList() {
        return new ArrayList<>(premiumMembers);    }

    public void addNewMember(Member member) {
        members.add(member);
    }

    public void addNewPremiumMember(PremiumMember premiumMember) {
        premiumMembers.add(premiumMember);
    }

    public ArrayList<Dog> getAvailableDogs() {
        ArrayList<Dog> availableDogs = new ArrayList<>();
        for (Pet pet : availablePets) {
            if (pet instanceof Dog) {
                availableDogs.add((Dog) pet);
            }
        }
        return availableDogs;
    }

    public ArrayList<Cat> getAvailableCats() {
        ArrayList<Cat> availableCats = new ArrayList<>();
        for (Pet pet : availablePets) {
            if (pet instanceof Cat) {
                availableCats.add((Cat) pet);
            }
        }
        return availableCats;
    }

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

    public void sortPetsByName() {
        Collections.sort(availablePets);
    }
}
