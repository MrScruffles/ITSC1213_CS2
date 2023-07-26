package NetBeansProjects.Labs.Module12Lab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            File inputFile = new File("./NetBeansProjects/Labs/Module12Lab/inputData.txt");
            Scanner fileScanner = new Scanner(inputFile);
            System.out.println("Input Data:");
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
                String[] splitData = line.split(",");
                if (splitData[0].equalsIgnoreCase("student")) {
                    students.add(new Student(
                        splitData[1], 
                        splitData[2], 
                        Integer.parseInt(splitData[3]), 
                        splitData[4], 
                        Double.parseDouble(splitData[5]), 
                        Integer.parseInt(splitData[6])
                    ));
                }
            }
            fileScanner.close();
            Collections.sort(students);

            FileOutputStream fos = new FileOutputStream("./NetBeansProjects/Labs/Module12Lab/ScholarshipCandidates.txt");
            PrintWriter pw = new PrintWriter(fos);

            System.out.println("\nScholarship Candidates:");
            for (Student student : students) {
                String category;
                if (student.getGPA() >= 3.5) {
                    category = "Top";
                } else if (student.getGPA() >= 3.2) {
                    category = "Middle";
                } else {
                    category = "Ineligible";
                }
                String studentData = category + ": " + student.getFirstName() + " " + student.getLastName() + ", Major: " + student.getMajor() + ", GPA: " + student.getGPA();
                pw.println(studentData);
                System.out.println(studentData);
            }

            pw.close();
            fos.close();

        } catch (FileNotFoundException fnfe) {
            System.out.println("File not found. Please make sure the input file is in the correct directory.");
        } catch (IOException ioe) {
            System.out.println("An error occurred while reading from the file or writing to the file.");
        }
    }
}
