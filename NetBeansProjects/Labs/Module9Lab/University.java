import java.util.ArrayList;
import java.util.List;

public class University implements UniversitySpecification {

    public University(String name) {
        this.name = name;
        this.personnel = new ArrayList<>();
    }

    private String name;
    private ArrayList<Person> personnel;

    // @Override
    public void setUp(ArrayList<Person> personnel) {
        this.personnel = personnel;
    }

@Override
public List<Student> getStudents() {
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

    public ArrayList<Person> getPersonnel() {
        return personnel;
    }
}
