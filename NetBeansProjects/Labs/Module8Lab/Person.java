/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * The Person class represents a person with a first name, last name, and ID.
 * It provides methods to access and modify the person's information.
 * It also includes a display method to print the person's information.
 * 
 * This class serves as the superclass for other classes, such as the Student class.
 * 
 * @author ash
 */

public class Person {
    private String firstName;  // The first name of the person
    private String lastName;  // The last name of the person
    private int id;  // The ID of the person

    /**
     * Constructs a Person object with the specified first name, last name, and ID.
     *
     * @param firstName The first name of the person.
     * @param lastName The last name of the person.
     * @param id The ID of the person.
     */
    public Person(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    /**
     * Returns the first name of the person.
     *
     * @return The first name of the person.
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Returns the last name of the person.
     *
     * @return The last name of the person.
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Returns the ID of the person.
     *
     * @return The ID of the person.
     */
    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Person: " + getFirstName() + " " + getLastName() + ", ID: " + getId();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Person person = (Person) other;
        return id == person.id;
    }

    /**
     * Displays the person's information, including the first name, last name, and ID.
     */
    public void display() {
        System.out.println("Full Name: " + this.firstName + " " + this.lastName);
        System.out.println("ID: " + this.id);
    }
}
