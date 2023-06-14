/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author ash
 */
public class ArrayUtilities {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Lab 1 Part C
        String message = "Welcome to ITSC1213 ArrayUtilities Program!";
        int n = 5;

        for (int i = 0; i < n; i++) {
            System.out.println(message);

        }

        // Test Sum
        int[] numArray = {0, 2, 4, 6, 17, 20, 4};
        System.out.println("The sum of this array is: " + sum(numArray));
        // Test findMax
        System.out.println("The largest number in this array is: " + findMax(numArray));
        // Test findFirstOdd
        System.out.println("The first odd number in this array is: " + findFirstOdd(numArray));

    }

    public static int sum(int[] numbers) {
        // Initialize a variable to hold the total
        int total = 0;

        // Iterate over the array adding the numbers
        for (int num : numbers) {
            total += num;
        }
        // Return calculated Total Value
        return total;

    }

    public static int findMax(int[] numbers) {
        // Initilize a variable to keep track of max number
        int max = 0;

        // Iterate over the array checking each number if it larger than value of max
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                // New max value found, update variable value
                max = numbers[i];
            }
        }
        //Return Largest Value Found
        return max;

    }

    public static int findFirstOdd(int[] numbers) {
        // Iterate over the array checking each number if it is odd/even
        int i = 0;
        while (i < numbers.length) {
            if (numbers[i] % 2 == 1) {
                // Return first odd number found
                return numbers[i];
            }
            i++;
        }
        // If no odd numbers found return 0
        return 0;
    }

}
