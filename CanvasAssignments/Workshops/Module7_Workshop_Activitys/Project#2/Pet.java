public class Pet {
    private String name;
    private String type;

    public Pet(String n, String t, String sex, int age, double weight, int iD, double price) {
        name = n;
        type = t;
    }

    public Pet(String name2, String breed, String sex, int age, double weight, int iD, double price) {
    }

    public Pet(String name2, String sex, int age, double weight, int iD, double price) {
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void speak() {
        System.out.println("grr!");
    }

    // public static void main(String[] args) {
    //     Pet p = new Pet("Sammy", "hamster");
    //     System.out.println(p.getType());
    //     p.speak();

    //     Dog d = new Dog("Fido");
    //     System.out.println(d.getType());
    //     d.speak();

    //     Cat c = new Cat("Fluffy");
    //     System.out.println(c.getType());
    //     c.speak();
    // }
}

class Dog extends Pet {
    public Dog(String name) {
        super(name, "dog");
    }

    public Dog(String string, String string2, String string3, int i, int j, int nextPetID, int k) {
    }

    @Override
    public void speak() {
        System.out.println("Woof!");
    }
}

class Cat extends Pet {
    public Cat(String name) {
        super(name, "cat");
    }

    public Cat(String string, String string2, String string3, int i, int j, int nextPetID, int k) {
    }

    @Override
    public void speak() {
        System.out.println("Meow!");
    }
}
