Member.java

Code:


import java.util.ArrayList;


/**
 *
 * @author Ash
 */
public class Member {
    
    private String name;
    private int memberID;
    private boolean newsletterSubscribed;
    private ArrayList<Dog> dogsOwned = new ArrayList();
    private ArrayList<Cat> catsOwned = new ArrayList();
    private ArrayList<ExoticPet> exoticPetsOwned = new ArrayList();
     private double amountSpent = 0;

    public Member(String name, int memberID, boolean newsletterSubscribed) {
        this.name = name;
        this.memberID = memberID;
        this.newsletterSubscribed = newsletterSubscribed;
    }

    public String getName() {
        return name;
    }

    public int getMemberID() {
        return memberID;
    }

    public boolean isNewsletterSubscribed() {
        return newsletterSubscribed;
    }

    public ArrayList<Dog> getDogsOwned() {
        return dogsOwned;
    }

    public ArrayList<Cat> getCatsOwned() {
        return catsOwned;
    }

    public ArrayList<ExoticPet> getExoticPetsOwned() {
        return exoticPetsOwned;
    }

    public double getAmountSpent() {
        return amountSpent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public void setNewsletterSubscribed(boolean newsletterSubscribed) {
        this.newsletterSubscribed = newsletterSubscribed;
    }

    public void setAmountSpent(double amountSpent) {
        this.amountSpent = this.amountSpent + amountSpent;
    }
     
     public void addDog(Dog dog) {
         dogsOwned.add(dog);
     }
     public void addCat(Cat cat) {
         catsOwned.add(cat);
     }
     public void addExoticPet(ExoticPet exoticPet) {
         exoticPetsOwned.add(exoticPet);
     }
}



Main.java

Code:

import java.util. *;

/**
 *
 * @author Ash 
 */


public class Main {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System. in);
        PetStore ps = new PetStore("Insert Petstore name here");
        System.out.println("**** Welcome to " + ps.getStoreName() + "****");
        while (true) {

            System.out.println("Please select from one of the following menu otions");
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
                    break;
                case 4:
                    break;
                case 5:
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
        //System.out.println("\t2. Cats"); System.out.println("\t3. Exotic Pets");

        int petTypeChoice = scnr.nextInt();

        // display inventory menu
        int itemNum = 1;
        if (petTypeChoice == 1) {
            ArrayList<Dog> inventory = petStore.getAvailableDogs();
            if (!inventory.isEmpty()) {

                System.out.println("Which of the following dogs would you like to purchase?:");

                for (Dog pet : inventory) {
                    System.out.println(
                        "\t" + itemNum + ". $" + pet.getPrice() + " - " + pet.getBreed() + "(" + pet.getName() +
                        ")"
                    );
                    itemNum++;
                }
                // get user selection for product to add arraylist (cart)
                int choice = scnr.nextInt();
                if (choice <= inventory.size()) {
                    cart.add(inventory.get(choice - 1));
                    //update inventory for this item
                    petStore.removePet("dog", choice - 1);
                    //cart summary
                    System.out.println(
                        "You have " + cart.size() + " items in your cart. Are you done shopping?"
                    );
                    System.out.println("\t1. Yes");
                    System.out.println("\t2. No");

                    int doneShopping = scnr.nextInt();
                    if (doneShopping == 1) {
                        //System.out.println("TO DO - CHEKOUT ");
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
            } else {
                System.out.println("Sorry! we currently have no dogs available.");
            }

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
                if( !premiumPurchaser.isDuesPaid()){
                System.out.println(
                    "Premium Membership dues unpaid, $5 will be added to purchase total to cover du" +
                    "es."
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
        System.out.println( "Would you like to register as a free-tier or premium member?");
        System.out.println("\t1. Free-tier");
        System.out.println("\t2. Premium");

        // user selection
        int choice1 = scnr.nextInt();
        // if user selects a wrong choice 
        if (choice1 > 2 || choice1 < 1) {
            System.out.println("Invalid choice.");
            registerNewMember(petStore, scnr); // try again

        } else {
            // prompt user for name 
            System.out.println("Please enter your name:");
            scnr.nextLine();
            String name = scnr.nextLine();
             System.out.println("Welcome to our membership program! Thank you for registering.");
            if (choice1 == 1) { // regular membership
                petStore.addNewMember(name, false);
                return false;
            } else { // user entered 2 - premimum membership
                petStore.addNewMember(name, true);
                return true;
            }
        }
        return false;
    }

}


Dog.java

Code:

/**
 *
 * @author Ash
 */
public class Dog {
    
    
    private String name;
    private String breed;
    private String sex;
    private int age;
    private double weight;
    private int ID;
    private double price;

    public Dog(String name, String breed, String sex, int age, double weight, int ID, double price) {
        this.name = name;
        this.breed = breed;
        this.sex = sex;
        this.age = age;
        this.weight = weight;
        this.ID = ID;
        this.price =  price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    
    
}



ExoticPet.java

Code:


/**
 *
 * @author Ash
 */
 
public class ExoticPet {
    
    private String name;
    private String species;
    private String sex;
    private int age;
    private double weight;
    private int ID;
    private double price;
    
    public ExoticPet(String name, String species, String sex, int age, double weight, int ID, double price) {
        this.name = name;
        this.species = species;
        this.sex = sex;
        this.age = age;
        this.weight = weight;
        this.ID = ID;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    
    
}



Cat.java

Code:

/**
 *
 * @author Ash
 */
public class Cat {
    
    private String name;
    private String breed;
    private String sex;
    private int age;
    private double weight;
    private int ID;
    private double price;

    public Cat(String name, String breed, String sex, int age, double weight, int ID, double price) {
        this.name = name;
        this.breed = breed;
        this.sex = sex;
        this.age = age;
        this.weight = weight;
        this.ID = ID;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    
    
    
}



PetStore.java

Code:

/**
 *
 * @author Ash
 */

import java.util. *;

public class PetStore {

    private String storeName;

    private ArrayList<Dog> availableDogs = new ArrayList();
    private ArrayList<Cat> availableCats = new ArrayList();
    private ArrayList<ExoticPet> availableExoticPets = new ArrayList();
    private ArrayList<Member> memberList = new ArrayList();
    private ArrayList<PremiumMember> premiumMemberList = new ArrayList();
    private static int nextPetID = 1;
    private static int nextMemberID = 1;


    public PetStore(String storeName) {
        this.storeName = storeName;
        Dog dog1 = new Dog(
            "Waffle",
            "German Shepherd",
            "Female",
            12,
            85,
            getNextPetID(),
            500
        );
        Dog dog2 = new Dog("Poe", "Corgi", "Male", 3, 35, getNextPetID(), 450);
        Cat cat1 = new Cat(
            "Karma",
            "Orange Tabby",
            "Female",
            6,
            15,
            getNextPetID(),
            200
        );
        Cat cat2 = new Cat("Kit", "Maine Coon", "Male", 6, 18, getNextPetID(), 150);
        ExoticPet ep1 = new ExoticPet(
            "Pancake",
            "Bearded Dragon",
            "Male",
            6,
            0.8,
            getNextPetID(),
            75
        );
        ExoticPet ep2 = new ExoticPet(
            "Noodle",
            "Ball Python",
            "Male",
            4,
            2,
            getNextPetID(),
            95
        );

        availableDogs.add(dog1);
        availableDogs.add(dog2);
        availableCats.add(cat1);
        availableCats.add(cat2);
        availableExoticPets.add(ep1);
        availableExoticPets.add(ep2);

        Member member1 = new Member("Jo", getNextMemberID(), true);
        member1.addCat(new Cat("Valjean", "White tabby", "Male", 1, 10, 0, 0));
        memberList.add(member1);

        PremiumMember member2 = new PremiumMember("Sage", getNextMemberID(), false, false);
        premiumMemberList.add(member2);
        member2.addExoticPet(
            new ExoticPet("Smaug", "Bearded Dragon", "Male", 5, 1, 0, 0)
        );

    }

    public static int getNextPetID() {
        nextPetID++;
        return nextPetID - 1;
    }
    
    public static int getNextMemberID() {
        nextMemberID++;
        return nextMemberID - 1;
    }


    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public ArrayList<Dog> getAvailableDogs() {
        return availableDogs;
    }

    public void setAvailableDogs(ArrayList<Dog> availableDogs) {
        this.availableDogs = availableDogs;
    }

    public ArrayList<Cat> getAvailableCats() {
        return availableCats;
    }

    public void setAvailableCats(ArrayList<Cat> availableCats) {
        this.availableCats = availableCats;
    }

    public ArrayList<ExoticPet> getAvailableExoticPets() {
        return availableExoticPets;
    }

    public void setAvailableExoticPets(ArrayList<ExoticPet> availableExoticPets) {
        this.availableExoticPets = availableExoticPets;
    }

    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(ArrayList<Member> memberList) {
        this.memberList = memberList;
    }

    public ArrayList<PremiumMember> getPremiumMemberList() {
        return premiumMemberList;
    }

    public void setPremiumMemberList(ArrayList<PremiumMember> premiumMemberList) {
        this.premiumMemberList = premiumMemberList;
    }

    public void removePet(String type, int index) {
        if (type.equals("dog")) 
            availableDogs.remove(index);
        else if (type.equals("cat")) 
            availableCats.remove(index);
        else if (type.equals("exoticPet")) 
            availableExoticPets.remove(index);

    }

     public void addNewMember(String name, boolean premium) {
        if (premium) {
            premiumMemberList.add(new PremiumMember(name,getNextMemberID(),false,false));
        } else {
            memberList.add(new Member(name,getNextMemberID(), false));
        }
    }
}



PremiumMember.java

Code:


import java.util.ArrayList;
/**
 *
 * @author Ash
 */

public class PremiumMember {
    
    private String name;
    private int memberID;
    private boolean newsletterSubscribed;
    private ArrayList<Dog> dogsOwned = new ArrayList();
    private ArrayList<Cat> catsOwned = new ArrayList();
    private ArrayList<ExoticPet> exoticPetsOwned = new ArrayList();
    private boolean duesPaid;
    private double amountSpent = 0;

    public PremiumMember(String name, int memberID, boolean newsletterSubscribed, boolean duesPaid) {
        this.name = name;
        this.memberID = memberID;
        this.newsletterSubscribed = newsletterSubscribed;
        this.duesPaid = duesPaid;
    }

    public boolean isDuesPaid() {
        return duesPaid;
    }

    public void setDuesPaid(boolean duesPaid) {
        this.duesPaid = duesPaid;
    }
    
    
     public String getName() {
        return name;
    }

    public int getMemberID() {
        return memberID;
    }

    public boolean isNewsletterSubscribed() {
        return newsletterSubscribed;
    }

    public ArrayList<Dog> getDogsOwned() {
        return dogsOwned;
    }

    public ArrayList<Cat> getCatsOwned() {
        return catsOwned;
    }

    public ArrayList<ExoticPet> getExoticPetsOwned() {
        return exoticPetsOwned;
    }

    public double getAmountSpent() {
        return amountSpent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public void setNewsletterSubscribed(boolean newsletterSubscribed) {
        this.newsletterSubscribed = newsletterSubscribed;
    }

    public void setAmountSpent(double amountSpent) {
        this.amountSpent = this.amountSpent + amountSpent;
    }     
     public void addDog(Dog dog) {
         dogsOwned.add(dog);
     }
     public void addCat(Cat cat) {
         catsOwned.add(cat);
     }
     public void addExoticPet(ExoticPet exoticPet) {
         exoticPetsOwned.add(exoticPet);
     }
}



