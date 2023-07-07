/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * The Professor class represents a student, extending the Person class.
 * It contains information about the student's major, GPA, credits, balance, transfer status, and enrolled courses.
 * It provides methods to access and modify the student's information.
 * Additionally, it includes a main method for testing the functionality of the class.
 *
 * @author ash
 */

import java.util.ArrayList;

public class Professor extends Person {
    private String department; // The department of the professor
    private double salary; // The salary of the professor
    private ArrayList<Student> advisees; // The list of students advised by the professor

    /**
     * Constructs a Professor object with the specified first name, last name, ID,
     * department, and salary.
     *
     * @param firstName  The first name of the professor.
     * @param lastName   The last name of the professor.
     * @param id         The ID of the professor.
     * @param department The department of the professor.
     * @param salary     The salary of the professor.
     */
    public Professor(String firstName, String lastName, int id, String department, double salary) {
        super(firstName, lastName, id);
        this.department = department;
        this.salary = salary;
        this.advisees = new ArrayList<>();
    }

    /**
     * Returns the department of the professor.
     *
     * @return The department of the professor.
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the department of the professor.
     *
     * @param department The department of the professor.
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Returns the salary of the professor.
     *
     * @return The salary of the professor.
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Sets the salary of the professor.
     *
     * @param salary The salary of the professor.
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Returns a copy of the list of advisees (students) of the professor.
     *
     * @return A copy of the list of advisees (students) of the professor.
     */
    public ArrayList<Student> getAdvisees() {
        return new ArrayList<>(advisees);
    }

    /**
     * Adds a student as an advisee of the professor.
     *
     * @param student The student to be added as an advisee.
     */
    public void addAdvisee(Student student) {
        advisees.add(student);
    }

    /**
     * Removes an advisee (student) with the specified ID from the list of advisees.
     *
     * @param studentId The ID of the advisee to be removed.
     * @return true if the advisee was successfully removed, false otherwise.
     */
    public boolean removeAdvisee(int studentId) {
        for (int i = 0; i < advisees.size(); i++) {
            Student student = advisees.get(i);
            if (student.getId() == studentId) {
                advisees.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Professor: " + getFirstName() + " " + getLastName() + ", ID: " + getId();
    }

    /**
     * Displays the professor's information, including the inherited information
     * from the Person class,
     * as well as the department, salary, and list of advisees.
     */
    @Override
    public void display() {
        super.display();
        System.out.println("Department: " + this.department);
        System.out.println("Salary: " + this.salary);
        System.out.println("Advisees: ");
        for (Student advisee : advisees) {
            System.out.println("\t" + advisee.getFirstName() + " " + advisee.getLastName());
        }
    }

    /**
     * The main method is used to test the functionality of the Professor class.
     */
    public static void showProfile(Person p, int id) {
        if (p.getId() == id) {
            p.display();
        }
    }

    public static void main(String[] args) {
        ArrayList<Person> contactList = new ArrayList<>();

        Student s1 = new Student("John", "Doe", 123, "CS", 3.5, 75);
        Student s2 = new Student("Kathrine", "Johnson", 900, "CS", 4.0, 100);
        Student s3 = new Student("Roy", "Clay", 901, "Biology", 3.2, 85);
        Student s4 = new Student("Kimberly", "Bryant", 902, "EE", 3.0, 80);
        Professor prof1 = new Professor("Mary", "Castro", 300, "CS", 60000);

        contactList.add(s1);
        contactList.add(s2);
        contactList.add(s3);
        contactList.add(s4);
        contactList.add(prof1);

        System.out.println("*** Part B ***");
        for (Person person : contactList) {
            showProfile(person, 900);
        }
        System.out.println("----------------");

            // Eligible for Scholarship
    System.out.println("*** Part C ***");
    System.out.println("----------------");
    System.out.println("Students eligible for scholarship:");
    for (Person person : contactList) {
        if (person instanceof Student) {
            Student student = (Student) person;
            if (student.getGpa() > 3.5) {
                System.out.println(student.getFirstName() + " " + student.getLastName());
            }
        }
    }

    System.out.println("----------------");
    // Professors in CS Department
    System.out.println("Professors in the CS Department:");
    for (Person person : contactList) {
        if (person instanceof Professor) {
            Professor professor = (Professor) person;
            if (professor.getDepartment().equals("CS")) {
                System.out.println(professor.getFirstName() + " " + professor.getLastName());
               }
          }
        }
    }
}

//     public class Main {
//         public static void main(String[] args) {
//             ArrayList<Person> contactList = new ArrayList<>();

//             Student s1 = new Student("John", "Doe", 123, "CS", 3.5, 75);
//             Student s2 = new Student("Kathrine", "Johnson", 900, "CS", 4.0, 100);
//             Student s3 = new Student("Roy", "Clay", 901, "Biology", 3.2, 85);
//             Student s4 = new Student("Kimberly", "Bryant", 902, "EE", 3.0, 80);
//             Professor prof1 = new Professor("Mary", "Castro", 300, "CS", 60000);

//             contactList.add(s1);
//             contactList.add(s2);
//             contactList.add(s3);
//             contactList.add(s4);
//             contactList.add(prof1);

//             for (Person p : contactList) {
//                 p.display();
//                 System.out.println("----------------");
//             }
//         }
//     }
// }
