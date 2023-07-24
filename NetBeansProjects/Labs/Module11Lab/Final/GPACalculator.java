package NetBeansProjects.Labs.Module11Lab.Final;

public class GPACalculator {

    /**
     * Converts a letter grade to a corresponding grade point value.
     *
     * @param letterGrade The letter grade to be converted (A, B, C, D, F).
     * @return The grade point value (4 for A, 3 for B, 2 for C, 1 for D, 0 for F, -1 for unknown).
     */
    public int getLetterGradeValue(char letterGrade) {
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
    public double computeGPA(int qualityPoints, int creditHours) throws ArithmeticException {
        if (creditHours == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return ((double) qualityPoints) / creditHours;
    }
}
