import java.util.ArrayList;

public class University implements UniversitySpecification {
    private ArrayList<Person> personnel;

    @Override
    public void setUp(ArrayList<Person> personnel) {
        this.personnel = personnel;
    }

    @Override
    public ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();
        for (Person person : personnel) {
            if (person instanceof Student) {
                students.add((Student) person);
            }
        }
        return students;
    }

    @Override
    public ArrayList<Professor> getProfessors() {
        ArrayList<Professor> professors = new ArrayList<>();
        for (Person person : personnel) {
            if (person instanceof Professor) {
                professors.add((Professor) person);
            }
        }
        return professors;
    }

    @Override
    public void newStudent(Student s) {
        personnel.add(s);
    }

    @Override
    public void newProfessor(Professor p) {
        personnel.add(p);
    }
}
