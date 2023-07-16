import java.util. *;

/**
 *
 * @author Ash 
 */

public class Main {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        PetStore ps = new PetStore("Ash's Pet Store");
        System.out.println("**** Welcome to " + ps.getStoreName() + "****");
        while (true) {
            System.out.println("Please select from one of the following menu options");
            System.out.println("\t1. Buy a new pet");
            System.out.println("\t2. Register a new member");
            System.out.println("\t3. Start adoption drive (add new pets)");
            System.out.println("\t4. Check current inventory");
            System.out.println("\t5. Register new pet to Owner profile");
            System.out.println("\t6. Exit");

            int choice1 = scnr.nextInt();

            switch (choice1) {
                case 1:
                    System.out.println("-----------------------------------");
                    purchase(ps, scnr, new ArrayList<Dog>());
                    break;
                case 2:
                    System.out.println("-----------------------------------");
                    registerNewMember(ps, scnr);
                    break;
                case 3:
                    System.out.println("-----------------------------------");
                    startAdoptionDrive(ps, scnr);
                    break;
                case 4:
                    System.out.println("-----------------------------------");
                    checkInventory(ps);
                    break;
                case 5:
                    System.out.println("-----------------------------------");
                    System.out.println("Enter the member's name:");
                    scnr.nextLine();
                    String memberName = scnr.nextLine();
                    Member member = findMemberByName(memberName, ps.getMemberList());
                    if (member == null) {
                        member = findMemberByName(memberName, ps.getPremiumMemberList());
                    }
                    if (member != null) {
                        registerPetToOwner(member, scnr);
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;
                case 6:
                    System.out.println("Thanks for visiting!");
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

private static void purchase(PetStore petStore, Scanner scnr, ArrayList<Dog> cart) {
    System.out.println("What type of pet are you here to purchase?");
    System.out.println("\t1. Dogs");
    System.out.println("\t2. Cats"); 
    System.out.println("\t3. Exotic Pets");

    int petTypeChoice = scnr.nextInt();

    // display inventory menu
    int itemNum = 1;
    ArrayList<? extends Pet> inventory = null;

    if (petTypeChoice == 1) {
        inventory = petStore.getAvailableDogs();
    } else if (petTypeChoice == 2) {
        inventory = petStore.getAvailableCats();
    } else if (petTypeChoice == 3) {
        inventory = petStore.getAvailableExoticPets();
    } else {
        System.out.println("Invalid choice.");
        return;
    }

    if (inventory.isEmpty()) {
        System.out.println("Sorry! we currently have no pets of this type available.");
        return;
    }

    System.out.println("Which of the following pets would you like to purchase?:");

    for (Pet pet : inventory) {
        String breed;
        if (pet instanceof Dog) {
            breed = ((Dog) pet).getBreed();
        } else if (pet instanceof Cat) {
            breed = ((Cat) pet).getBreed();
        } else if (pet instanceof ExoticPet) {
            breed = ((ExoticPet) pet).getType();
        } else {
            breed = "Unknown";
        }
        System.out.println(
            "\t" + itemNum + ". $" + pet.getPrice() + " - " + breed + "(" + pet.getName() +
            ")"
        );
        itemNum++;
    }

    // get user selection for product to add arraylist (cart)
    int choice = scnr.nextInt();
    if (choice <= inventory.size()) {
        Dog chosenDog = (Dog) inventory.get(choice - 1);
        cart.add(chosenDog);
        //update inventory for this item
        Dog petToRemove = (Dog) inventory.get(choice - 1);
        petStore.removePet(petToRemove);
        //cart summary
        System.out.println(
            "You have " + cart.size() + " items in your cart. Are you done shopping?"
        );
        System.out.println("\t1. Yes");
        System.out.println("\t2. No");

        int doneShopping = scnr.nextInt();
        if (doneShopping == 1) {
            checkout(petStore, scnr, cart);
        } else if (doneShopping == 2) { // more shopping
            purchase(petStore, scnr, cart); // recursively call purchase(...) until done
        } else {
            System.out.println("Invalid Choice.");
        }
    } else {
        System.out.println("Please enter a valid product number. Try again");
        purchase(petStore, scnr, cart);
    }
}

    private static void checkout(PetStore petStore, Scanner scnr, ArrayList<Dog> cart) {
        // calculate total
        double total = 0;
        for (Dog pet : cart) {
            total += pet.getPrice();
        }
        System.out.println(
            "Your total comes to " + total + ". \nPlease select which member is making this" +
            " purchase."
        );

        // list members and option to register
        int num = 1;
        for (Member member : petStore.getMemberList()) {
            System.out.println(num + ". " + member.getName());
            num++;
        }
        for (PremiumMember member : petStore.getPremiumMemberList()) {
            System.out.println(num + ". " + member.getName());
            num++;
        }
        System.out.println(num + ". Register a new Member.");

        System.out.println(""); // space line
        int memberSelect = scnr.nextInt();
        Member purchaser = null;
        PremiumMember premiumPurchaser = null;

        if (memberSelect > petStore.getMemberList().size() + petStore.getPremiumMemberList().size() + 1) { // invalid selection
            System.out.println("Invalid Selection");
            checkout(petStore, scnr, cart); // recursive call if valid user input

        } else { // valid selection
            if (memberSelect == (petStore.getMemberList().size() + petStore.getPremiumMemberList().size()) + 1) { // adding a new member
                boolean premium = registerNewMember(petStore, scnr);
                if (premium) {
                    premiumPurchaser = petStore.getPremiumMemberList().get(
                        petStore.getPremiumMemberList().size() - 1
                    );
                } else {
                    purchaser = petStore.getMemberList().get(petStore.getMemberList().size() - 1);
                }
            } else if (memberSelect <= (petStore.getMemberList().size())) {
                purchaser = petStore.getMemberList().get(memberSelect - 1);
            } else { // existing premium member
                premiumPurchaser = petStore.getPremiumMemberList().get(
                    memberSelect - petStore.getMemberList().size() - 1
                );
            }

            // check if premium member and fees are due
            if (purchaser == null && premiumPurchaser != null) {
                if (!premiumPurchaser.isDuesPaid()) {
                    System.out.println(
                        "Premium Membership dues unpaid, $5 will be added to purchase total to cover dues."
                    );
                    total += 5;
                }
                premiumPurchaser.setDuesPaid(true);
                // update amount of purchases for this member
                premiumPurchaser.setAmountSpent(total);
                // done
                System.out.println("Your purchase total was: " + total);
                System.out.println(
                    "Congrats on your purchase " + premiumPurchaser.getName()
                );

            } else {
                // update amount of purchases for this member
                purchaser.setAmountSpent(total);
                System.out.println("Your purchase total was: " + total);
                System.out.println("Congrats on your purchase " + purchaser.getName());

            }
        }
    }

    private static boolean registerNewMember(PetStore petStore, Scanner scnr) {
        // prompt user to select membership type
        System.out.println("Let's get you registered as a new Member!");
        System.out.println("Would you like to register as a free-tier or premium member?");
        System.out.println("\t1. Free-tier");
        System.out.println("\t2. Premium");

        // user selection
        int choice1 = scnr.nextInt();
        // if user selects a wrong choice 
        if (choice1 > 2 || choice1 < 1) {
            System.out.println("Invalid choice.");
            return registerNewMember(petStore, scnr); // try again

        } else {
            // prompt user for name 
            System.out.println("Please enter your name:");
            scnr.nextLine();
            String name = scnr.nextLine();
            System.out.println("Welcome to our membership program! Thank you for registering.");
            int memberID = petStore.generateUniqueMemberID(); // Generate unique ID through the PetStore instance
            if (choice1 == 1) { // regular membership
                Member newMember = new Member(name, memberID, false);
                petStore.addNewMember(newMember);
                return false;
            } else { // user entered 2 - premium membership
                PremiumMember newPremiumMember = new PremiumMember(name, memberID, false, true);
                petStore.addNewPremiumMember(newPremiumMember);
                return true;
            }
        }
    }

    public static void startAdoptionDrive(PetStore ps, Scanner scnr) {
        System.out.println("How many dogs are you adding?");
        int dogCount = scnr.nextInt();
        for (int i = 0; i < dogCount; i++) {
            Dog dog = new Dog("Dog" + i, 10.0, "Breed" + i); // create new dog
            ps.addPet(dog); // add new dog to the pet store
        }

        System.out.println("How many cats are you adding?");
        int catCount = scnr.nextInt();
        for (int i = 0; i < catCount; i++) {
            Cat cat = new Cat("Cat" + i, 10.0, "Breed" + i); // create new cat
            ps.addPet(cat); // add new cat to the pet store
        }

        System.out.println("Adoption drive has successfully started!");
    }

    public static void checkInventory(PetStore ps) {
        System.out.println("Current pet inventory value: $" + ps.inventoryValue());
    
        System.out.println("Members and their pets:");
        for (Member member : ps.getMemberList()) {
            System.out.println("Member name: " + member.getName());
            member.displayPets();
        }
    
        System.out.println("Premium members and their pets:");
        for (PremiumMember premiumMember : ps.getPremiumMemberList()) {
            System.out.println("Premium member name: " + premiumMember.getName());
            premiumMember.displayPets();
        }
    }
    

    public static void registerPetToOwner(Member member, Scanner scnr) {
        System.out.println("What type of pet is it? (dog/cat/exotic)");
        String petType = scnr.nextLine();
        double petPrice = 10.0; // For simplicity, let's assume all pets cost the same

        if (petType.equalsIgnoreCase("dog")) {
            Dog dog = new Dog("Dog", petPrice, "Breed"); // create new dog
            member.addDog(dog); // add new dog to the member's pets
        } else if (petType.equalsIgnoreCase("cat")) {
            Cat cat = new Cat("Cat", petPrice, "Breed"); // create new cat
            member.addCat(cat); // add new cat to the member's pets
        } else if (petType.equalsIgnoreCase("exotic")) {
            ExoticPet exoticPet = new ExoticPet("ExoticPet", petPrice, "Species"); // create new exotic pet
            member.addExoticPet(exoticPet); // add new exotic pet to the member's pets
        } else {
            System.out.println("Invalid pet type.");
        }
    }

    private static Member findMemberByName(String name, ArrayList<? extends Member> members) {
        for (Member member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

}
