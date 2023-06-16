/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;

/**
 *
 * @author ash
 */

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter an integer number for the size of the square:");
        int size = scan.nextInt(); // Size of the next square

        // Create a new Square of the given size
        Square sq = new Square(size);

        // Call its read method to read the values of the square
        sq.readSquare(scan);

        System.out.println("******** Square ********");

        // Print the square
        sq.printSquare();

        // Part B -
        System.out.println("******** Square details ********");

        // Print the sums of its rows
        for (int i = 0; i < size; i++) {
            System.out.println("Row " + i + " sum: " + sq.sumRow(i));
        }

        // Print the sums of its columns
        for (int i = 0; i < size; i++) {
            System.out.println("Column " + i + " sum: " + sq.sumColumn(i));
        }

        // Part C -
        // Print the sum of the main diagonal
        System.out.println("Main diagonal sum: " + sq.sumMainDiag());

        // Print the sum of the other diagonal
        System.out.println("Other diagonal sum: " + sq.sumOtherDiag());

        // Part D -
        // Determine and print whether it is a magic square
        if (sq.isMagic()) {
            System.out.println("This 2D array is a magic square");
        } else {
            System.out.println("This 2D array is not a magic square");
        }
    }
}
