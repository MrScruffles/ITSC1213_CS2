/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;

/**
 *
 * @author ash
 */

public class BasicArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<Integer>();

        // Adding elements to the ArrayList (using a loop with the number 4)
        for(int i = 1; i <= 4; i++) {
            myList.add(i);
        }

        // Adding a new element (0) at the beginning of the ArrayList
        myList.add(0, 0);

        // Printing the contents of the ArrayList
        for(int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }
    }
}

