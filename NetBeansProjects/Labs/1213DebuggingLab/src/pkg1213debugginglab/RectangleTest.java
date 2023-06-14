/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg1213debugginglab;
import java.awt.Rectangle;

/**
 *
 * @author ash
 */

public class RectangleTest {

    public static void main(String[] args) {
        // Create box1 object with specified properties
        Rectangle box1 = new Rectangle(10, 10, 40, 30);
        System.out.println("box1: " + box1);

        // Create box2 object with width of 100 and height of 50
        Rectangle box2 = new Rectangle(100, 50);
        System.out.println("box2: " + box2);

        // Move box1 to a new location (x: 20, y: 20)
        box1.setLocation(20, 20);

        // Change box2's dimensions to width: 50 and height: 30
        box2.setSize(50, 30);

        // Display properties of box1 and box2
        System.out.println("box1 properties:");
        System.out.println("x: " + box1.getX());
        System.out.println("y: " + box1.getY());
        System.out.println("width: " + box1.getWidth());
        System.out.println("height: " + box1.getHeight());

        System.out.println("box2 properties:");
        System.out.println("x: " + box2.getX());
        System.out.println("y: " + box2.getY());
        System.out.println("width: " + box2.getWidth());
        System.out.println("height: " + box2.getHeight());

        // Find the smallest intersection of box1 and box2
        Rectangle box3 = box1.intersection(box2);

        // Calculate and display the area of box3
        double area = box3.getWidth() * box3.getHeight();
        System.out.println("Area of box3: " + area);

        // Display properties of box3
        System.out.println("box3 properties:");
        System.out.println("x: " + box3.getX());
        System.out.println("y: " + box3.getY());
        System.out.println("width: " + box3.getWidth());
        System.out.println("height: " + box3.getHeight());
    }
}

