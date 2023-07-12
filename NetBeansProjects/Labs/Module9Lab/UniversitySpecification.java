import java.util.ArrayList;

public interface UniversitySpecification {
    public void setUp(ArrayList<Person> personnel);
    public ArrayList<Student> getStudents();
    public ArrayList<Professor> getProfessors();
    public void newStudent(Student s);
    public void newProfessor(Professor p);
}
