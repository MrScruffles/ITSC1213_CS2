import java.util.*;
/**
 *
 * @author nanajjar
 */

public class NotebookDriver {
    public static void main(String[] args) {
        Notebook myNotebook = new Notebook();
        Note myNote = new Note();
        myNote.setCategory("ITS1213");
        myNote.setTitle("UML diagrams");
        myNote.setBody("A UML class diagram consists of one or more classes,"
                + " each with sections for the class name, attributes (data), "
                + "and operations (methods)");
        myNote.setDate("2/8/2022");
        myNotebook.addNote(myNote);

        List<Note> notes = myNotebook.getNotes();
        for (Note aNote : notes) {
            System.out.println("=====================================");
            System.out.println("Note title: " + aNote.getTitle());
            System.out.println("Note category: " + aNote.getCategory());
            System.out.println("Note body: " + aNote.getBody());
            System.out.println("Note date: " + aNote.getDate());
            System.out.println("=====================================");
        }
    }
}
