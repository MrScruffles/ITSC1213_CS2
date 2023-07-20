package NetBeansProjects.Labs.Module11Lab;

import java.util.Scanner;

public class GPACalculator {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        char letterGrade;    // User defined letter grade 
        int creditHours;     // User defined number of credit hours
        char quitCmd;        // Indicates quit/continue

        quitCmd = 'a';

        int qualityPoints = 0;
        int totalCreditHrs = 0;

        while (quitCmd != 'q') {

            // Get user data
            System.out.print("Enter letter grade: ");
            letterGrade = scnr.nextLine().charAt(0);

            if (isValidLetterGrade(letterGrade)) {
                System.out.print("Enter number of credit hours: ");
                creditHours = scnr.nextInt();
                scnr.nextLine(); // Consume the newline character

                if (isValidCreditHours(creditHours)) {
                    totalCreditHrs += creditHours;
                    qualityPoints += getLetterGradeValue(letterGrade) * creditHours;

                    System.out.print("\nEnter any key to continue entering grade or 'q' to quit: ");
                    quitCmd = scnr.nextLine().charAt(0);
                } else {
                    System.out.println("Invalid number of credit hours. Try again!");
                }
            } else {
                System.out.println("Invalid letter grade. Try again!");
            }
        }

        // Calculate GPA - Divide the total quality points by the total credit hours.
        double gpa = computeGPA(qualityPoints, totalCreditHrs);

        // Print user GPA info
        System.out.println("GPA: " + gpa);
    }

    private static boolean isValidLetterGrade(char letterGrade) {
        return (letterGrade == 'a' || letterGrade == 'A' ||
                letterGrade == 'b' || letterGrade == 'B' ||
                letterGrade == 'c' || letterGrade == 'C' ||
                letterGrade == 'd' || letterGrade == 'D' ||
                letterGrade == 'f' || letterGrade == 'F');
    }

    private static boolean isValidCreditHours(int creditHours) {
        return creditHours > 0;
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
        return ((double) qualityPoints) / creditHours;
    }
}
