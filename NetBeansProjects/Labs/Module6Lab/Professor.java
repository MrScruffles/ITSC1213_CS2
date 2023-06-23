package NetBeansProjects.Labs.Module6Lab;

import java.util.ArrayList;

public class Professor extends Person {
    private String department;
    private double salary;
    private ArrayList<Student> advisees;

    public Professor(String firstName, String lastName, int id, String department, double salary) {
        super(firstName, lastName, id);
        this.department = department;
        this.salary = salary;
        this.advisees = new ArrayList<>();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public ArrayList<Student> getAdvisees() {
        return new ArrayList<>(advisees);
    }

    public void addAdvisee(Student student) {
        advisees.add(student);
    }

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

    public void display() {
        super.display();
        System.out.println("Department: " + this.department);
        System.out.println("Salary: " + this.salary);
        System.out.println("Advisees: ");
        for (Student student : advisees) {
            System.out.println(student.getFirstName() + " " + student.getLastName());
        }
    }

    public static void main(String[] args) {
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
        for (Student s : myAdvisees) {
            System.out.println(s.getFirstName() + " " + s.getLastName());
        }
    }
}
