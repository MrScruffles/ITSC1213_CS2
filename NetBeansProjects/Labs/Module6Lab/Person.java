package NetBeansProjects.Labs.Module6Lab;

public class Person {
    private String firstName;
    private String lastName;
    private int id;

    public Person(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getId() {
        return this.id;
    }

    public void display() {
        System.out.println("Full Name: " + this.firstName + " " + this.lastName);
        System.out.println("ID: " + this.id);
    }
}
