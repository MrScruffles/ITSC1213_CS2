package NetBeansProjects.Labs.Module6Lab;

import java.util.ArrayList;

public class Student extends Person {
    private String major;
    private double gpa;
    private int credits;
    private double balance;
    private boolean transfer;
    private ArrayList<String> enrolledCourses;

    public Student(String firstName, String lastName, int id, String major, double gpa, int credits) {
        super(firstName, lastName, id);
        this.major = major;
        this.gpa = gpa;
        this.credits = credits;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isTransfer() {
        return transfer;
    }

    public void setTransfer(boolean transfer) {
        this.transfer = transfer;
    }

    public ArrayList<String> getEnrolledCourses() {
        return new ArrayList<>(enrolledCourses);
    }

    public void addCourse(String course) {
        this.enrolledCourses.add(course);
    }

    public boolean dropCourse(String course) {
        return this.enrolledCourses.remove(course);
    }

    public void display() {
        super.display();
        System.out.println("Major: " + this.major);
        System.out.println("GPA: " + this.gpa);
        System.out.println("Credits: " + this.credits);
        System.out.println("Balance: " + this.balance);
        System.out.println("Transfer: " + (this.transfer ? "Yes" : "No"));
        System.out.println("Enrolled Courses: " + this.enrolledCourses);
    }

    public static void main(String[] args) {
        Student s = new Student("Raya", "Whitaker", 800555555, "Computer Science", 3.5, 90);
        s.addCourse("Math 101");
        s.addCourse("Physics 101");
        s.display();
    }
}
