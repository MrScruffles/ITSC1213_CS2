import java.util.ArrayList;

public class UniversityDriver {
    public static void main(String[] args) {
        // Initialize university personnel
        ArrayList<Person> personnel = new ArrayList<>();

        // Create some students and professors
        Student s1 = new Student("Alice", "Johnson", 1, 3.5);
        Student s2 = new Student("Bob", "Smith", 2, 3.8);
        Professor p1 = new Professor("Dr. James", "Anderson", 3, "Computer Science");

        // Add to personnel
        personnel.add(s1);
        personnel.add(s2);
        personnel.add(p1);

        // Create a university
        University univ = new University();

        // Set up university
        univ.setUp(personnel);

        // Print students and professors
        System.out.println("Students: " + univ.getStudents());
        System.out.println("Professors: " + univ.getProfessors());
    }
}
