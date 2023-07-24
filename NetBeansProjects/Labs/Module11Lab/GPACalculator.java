package NetBeansProjects.Labs.Module11Lab;

import java.util.Scanner;
import java.util.InputMismatchException;

public class GPACalculator {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        char letterGrade;    // User defined letter grade 
        int creditHours;     // User defined number of credit hours
        char quitCmd = 'a';  // Indicates quit/continue

        int qualityPoints = 0;
        int totalCreditHrs = 0;

        while (quitCmd != 'q') {
            try {
                // Get user data
                System.out.print("Enter letter grade: ");
                letterGrade = scnr.nextLine().charAt(0);

                // Error checking, unknown letter grade
                if (getLetterGradeValue(letterGrade) == -1) {
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
                qualityPoints += getLetterGradeValue(letterGrade) * creditHours;
            } catch (InputMismatchException ime) {
                // Prints a custom error message
                System.out.println("Invalid input. Please enter an integer for credit hours.");
                // Consume the invalid token
                scnr.nextLine();
            } catch (Exception excpt) {
                // Prints the error message passed by throw statement
                System.out.println(excpt.getMessage());
                System.out.println("Cannot compute GPA");
            }

            System.out.print("\nEnter any key to continue entering grade or 'q' to quit: ");
            quitCmd = scnr.nextLine().charAt(0);
        }

        // Calculate GPA - Divide the total quality points by the total credit hours.
        try {
            double gpa = computeGPA(qualityPoints, totalCreditHrs);
            // Print user GPA info
            System.out.println("GPA: " + gpa);
        } catch (ArithmeticException excpt) {
            System.out.println(excpt.getMessage());
            System.out.println("Illegal operation. Cannot compute GPA.");
        }
    }

    private static int getLetterGradeValue(char letterGrade) {
        if (letterGrade == 'a' || letterGrade == 'A') {
            return 4;
        }
        if (letterGrade == 'b' || letterGrade == 'B') {
            return 3;
        }
        if (letterGrade == 'c' || letterGrade == 'C') {
            return 2;
        }
        if (letterGrade == 'd' || letterGrade == 'D') {
            return 1;
        }
        if (letterGrade == 'f' || letterGrade == 'F') {
            return 0;
        } else {
            return -1;
        }
    }

    private static double computeGPA(int qualityPoints, int creditHours) {
        if (creditHours == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return ((double) qualityPoints) / creditHours;
    }
    
}
