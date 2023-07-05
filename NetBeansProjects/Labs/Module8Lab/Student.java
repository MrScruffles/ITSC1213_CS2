/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * The Student class represents a student, extending the Person class.
 * It contains information about the student's major, GPA, credits, balance, transfer status, and enrolled courses.
 * It provides methods to access and modify the student's information.
 * Additionally, it includes a main method for testing the functionality of the class.
 * 
 * This class assumes the existence of the Person class and the Professor class.
 * 
 * The main method demonstrates the usage of the Student class and its interaction with the Professor class.
 * 
 * @author ash
 */

import java.util.ArrayList;

public class Student extends Person {
    private String major;  // The major of the student
    private double gpa;  // The GPA of the student
    private int credits;  // The number of credits earned by the student
    private double balance;  // The balance of the student
    private boolean transfer;  // The transfer status of the student
    private ArrayList<String> enrolledCourses;  // The list of courses the student is enrolled in

    /**
     * Constructs a Student object with the specified first name, last name, ID, major, GPA, and credits.
     *
     * @param firstName The first name of the student.
     * @param lastName The last name of the student.
     * @param id The ID of the student.
     * @param major The major of the student.
     * @param gpa The GPA of the student.
     * @param credits The number of credits earned by the student.
     */
    public Student(String firstName, String lastName, int id, String major, double gpa, int credits) {
        super(firstName, lastName, id);
        this.major = major;
        this.gpa = gpa;
        this.credits = credits;
        this.enrolledCourses = new ArrayList<>();
    }

    /**
     * Returns the major of the student.
     *
     * @return The major of the student.
     */
    public String getMajor() {
        return major;
    }

    /**
     * Sets the major of the student.
     *
     * @param major The major of the student.
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * Returns the GPA of the student.
     *
     * @return The GPA of the student.
     */
    public double getGpa() {
        return gpa;
    }

    /**
     * Sets the GPA of the student.
     *
     * @param gpa The GPA of the student.
     */
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    /**
     * Returns the number of credits earned by the student.
     *
     * @return The number of credits earned by the student.
     */
    public int getCredits() {
        return credits;
    }

    /**
     * Sets the number of credits earned by the student.
     *
     * @param credits The number of credits earned by the student.
     */
    public void setCredits(int credits) {
        this.credits = credits;
    }

    /**
     * Returns the balance of the student.
     *
     * @return The balance of the student.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets the balance of the student.
     *
     * @param balance The balance of the student.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Returns the transfer status of the student.
     *
     * @return The transfer status of the student.
     */
    public boolean isTransfer() {
        return transfer;
    }

    /**
     * Sets the transfer status of the student.
     *
     * @param transfer The transfer status of the student.
     */
    public void setTransfer(boolean transfer) {
        this.transfer = transfer;
    }

    /**
     * Returns a copy of the list of enrolled courses of the student.
     *
     * @return A copy of the list of enrolled courses of the student.
     */
    public ArrayList<String> getEnrolledCourses() {
        return new ArrayList<>(enrolledCourses);
    }

    /**
     * Adds a course to the list of enrolled courses of the student.
     *
     * @param course The course to be added.
     */
    public void addCourse(String course) {
        this.enrolledCourses.add(course);
    }

    /**
     * Removes a course from the list of enrolled courses of the student.
     *
     * @param course The course to be removed.
     * @return true if the course was successfully removed, false otherwise.
     */
    public boolean dropCourse(String course) {
        return this.enrolledCourses.remove(course);
    }

    /**
     * Displays the student's information, including the inherited information from the Person class.
     */
    @Override
    public void display() {
        super.display();
        System.out.println("Major: " + this.major);
        System.out.println("GPA: " + this.gpa);
        System.out.println("Credits: " + this.credits);
        System.out.println("Enrolled Courses: ");
        for (String course : enrolledCourses) {
            System.out.println("\t" + course);
        }
    }

    @Override
    public String toString() {
        return "Student: " + getFirstName() + " " + getLastName() + ", ID: " + getId();
    }

    /**
     * The main method is used to test the functionality of the Student class.
     */
    public static void main(String[] args) {
        System.out.println("*** Part A ***");
        Student s = new Student("Raya", "Whitaker", 800555555, "Computer Science", 3.5, 90);
        s.addCourse("Math 101");
        s.addCourse("Physics 101");
        s.display();

        System.out.println("*** Part C ***");
        Student s2 = new Student("Kathrine", "Johnson", 900, "CS", 4.0, 100);
        Student s3 = new Student("Roy", "Clay", 901, "Biology", 3.2, 85);
        Student s4 = new Student("Kimberly", "Bryant", 902, "EE", 3.0, 80);
        Professor prof1 = new Professor("Mary", "Castro", 300, "CS", 80000);
        prof1.addAdvisee(s2);
        prof1.addAdvisee(s3);
        prof1.addAdvisee(s4);
        prof1.display();

        if (prof1.removeAdvisee(902)) {
            System.out.println("The advisee has been removed");
        } else {
            System.out.println("This student is not an advisee of Professor "
                    + prof1.getFirstName() + " " + prof1.getLastName());
        }

        ArrayList<Student> myAdvisees = prof1.getAdvisees();
        System.out.println("Professor " + prof1.getFirstName() + " " + prof1.getLastName() + " advisees:");
        for (Student student : myAdvisees) {
            System.out.println(student.getFirstName() + " " + student.getLastName());
        }
        
        ArrayList<Person> personList = new ArrayList<>();
        personList.add(new Professor("John", "Doe", 300, "CS", 80000));
        personList.add(new Student("Jane", "Smith", 800555555, "Biology", 3.2, 85));

        for (Person person : personList) {
            System.out.println(person.toString());
        }


    }

}

