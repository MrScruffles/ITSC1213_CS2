/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;

/**
 *
 * @author ash
 */

public class Square {
    private int[][] square;

    public Square(int size) {
        square = new int[size][size];
    }

    public int[][] getSquare() {
        return square;
    }

    public int sumRow(int row) {
        int total = 0;
        for (int col = 0; col < square.length; col++) {
            total += square[row][col];
        }
        return total;
    }

    public int sumColumn(int col) {
        int total = 0;
        for (int row = 0; row < square.length; row++) {
            total += square[row][col];
        }
        return total;
    }

    public int sumMainDiag() {
        int total = 0;
        for (int i = 0; i < square.length; i++) {
            total += square[i][i];
        }
        return total;
    }

    public int sumOtherDiag() {
        int total = 0;
        for (int i = 0; i < square.length; i++) {
            total += square[i][square.length - 1 - i];
        }
        return total;
    }

    public boolean isMagic() {
        int targetSum = sumRow(0); // Assuming the first row's sum is the target sum

        // Check rows
        for (int row = 1; row < square.length; row++) {
            if (sumRow(row) != targetSum) {
                return false;
            }
        }

        // Check columns
        for (int col = 0; col < square.length; col++) {
            if (sumColumn(col) != targetSum) {
                return false;
            }
        }

        // Check diagonals
        if (sumMainDiag() != targetSum || sumOtherDiag() != targetSum) {
            return false;
        }

        return true;
    }

    public void readSquare(Scanner scan) {
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square.length; col++) {
                System.out.println("Enter an integer number:");
                square[row][col] = scan.nextInt();
            }
        }
    }

    public void printSquare() {
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square.length; col++) {
                System.out.print(square[row][col] + "  ");
            }
            System.out.println();
        }
    }
}
