package NetBeansProjects.Labs.Module11Lab.Final;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        char letterGrade;    // User-defined letter grade 
        int creditHours;     // User-defined number of credit hours
        char quitCmd = 'a';  // Indicates quit/continue

        int qualityPoints = 0;
        int totalCreditHrs = 0;
        GPACalculator gpaCalculator = new GPACalculator();

        while (quitCmd != 'q') {
            try {
                // Get user data
                System.out.print("Enter letter grade: ");
                letterGrade = scnr.nextLine().charAt(0);

                // Error checking, unknown letter grade
                if (gpaCalculator.getLetterGradeValue(letterGrade) == -1) {
                    throw new Exception("Invalid letter grade.");
                }

                System.out.print("Enter number of credit hours: ");
                creditHours = scnr.nextInt();
                scnr.nextLine();  // Consume newline left-over

                // Error checking, negative credit hours
                if (creditHours < 0) {
                    throw new Exception("Invalid number of credit hours. Try again!");
                }

                totalCreditHrs += creditHours;
                qualityPoints += gpaCalculator.getLetterGradeValue(letterGrade) * creditHours;
            } catch (InputMismatchException ime) {
                // Prints a custom error message
                System.out.println("Invalid input. Please enter an integer for credit hours.");
                // Consume the invalid token
                scnr.nextLine();
            } catch (Exception excpt) {
                // Prints the error message passed by the throw statement
                System.out.println(excpt.getMessage());
                System.out.println("Cannot compute GPA");
            }

            System.out.print("\nEnter any key to continue entering grade or 'q' to quit: ");
            quitCmd = scnr.nextLine().charAt(0);
        }

        // Calculate GPA - Divide the total quality points by the total credit hours.
        try {
            double gpa = gpaCalculator.computeGPA(qualityPoints, totalCreditHrs);
            // Print user GPA info
            System.out.println("GPA: " + gpa);
        } catch (ArithmeticException excpt) {
            System.out.println(excpt.getMessage());
            System.out.println("Illegal operation. Cannot compute GPA.");
        }
    }
}
