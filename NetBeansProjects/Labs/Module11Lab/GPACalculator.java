package NetBeansProjects.Labs.Module11Lab;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * The GPACalculator class calculates a student's GPA based on letter grades and credit hours.
 */
public class GPACalculator {

    /**
     * Main method to execute the GPA calculator.
     * 
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        char letterGrade;    // User-defined letter grade 
        int creditHours;     // User-defined number of credit hours
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
                // Prints the error message passed by the throw statement
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

    /**
     * Converts a letter grade to a corresponding grade point value.
     * 
     * @param letterGrade The letter grade to be converted (A, B, C, D, F).
     * @return The grade point value (4 for A, 3 for B, 2 for C, 1 for D, 0 for F, -1 for unknown).
     */
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

    /**
     * Calculates the GPA by dividing the total quality points by the total credit hours.
     * 
     * @param qualityPoints The total quality points earned.
     * @param creditHours The total credit hours attempted.
     * @return The GPA calculated as the quotient of quality points and credit hours.
     * @throws ArithmeticException if creditHours is zero, causing division by zero.
     */
    private static double computeGPA(int qualityPoints, int creditHours) throws ArithmeticException {
        if (creditHours == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return ((double) qualityPoints) / creditHours;
    }
}
