public class Pet {
    private String name;
    private String type;

    public Pet(String n, String t) {
        name = n;
        type = t;
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

    public static void main(String[] args) {
        Pet p = new Pet("Sammy", "hamster");
        System.out.println(p.getType());
        p.speak();

        Dog d = new Dog("Fido");
        System.out.println(d.getType());
        d.speak();

        Cat c = new Cat("Fluffy");
        System.out.println(c.getType());
        c.speak();
    }
}

class Dog extends Pet {
    public Dog(String name) {
        super(name, "dog");
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

    @Override
    public void speak() {
        System.out.println("Meow!");
    }
}
