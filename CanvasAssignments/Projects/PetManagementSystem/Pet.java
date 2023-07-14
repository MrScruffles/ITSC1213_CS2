import java.util.*;

/**
 *
 * @author Ash
 */
abstract public class Pet implements Comparable<Pet> {
    protected String name;
    protected String sex;
    protected int age;
    protected double weight;
    protected int ID;
    protected double price;
    
    public Pet(String name, String sex, int age, double weight, int ID, double price) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.weight = weight;
        this.ID = ID;
        this.price = price;
    }
    
    // ... getters and setters ...
    
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

    @Override
    public int compareTo(Pet otherPet) {
        return Double.compare(this.price, otherPet.price);
    }
}
