package pkg1213debugginglab;

/*
 * ITSC 1213 
 * The Circle class represents a circle with a radius and color.
 */

/**
 * The Circle class represents a circle with a given radius and color.
 * It provides methods to retrieve the radius, calculate the area, and
 * initialize the circle with default or specified values.
 *
 * @author ash
 */

public class Circle {  // Save as "Circle.java"
   // private instance variables, not accessible from outside this class
   private double radius;
   private String color;

   /**
    * Constructs a Circle object with default radius and color.
    * The default radius is 1.0 and the default color is "red".
    */
   public Circle() {
      radius = 1.0;
      color = "red";
   }

   /**
    * Constructs a Circle object with the given radius and color.
    *
    * @param r    the radius of the circle
    * @param clr  the color of the circle
    */
   public Circle(double r, String clr) {
      radius = r;
      color = clr;
   }

   /**
    * Retrieves the radius of the circle.
    *
    * @return the radius of the circle
    */
   public double getRadius() {
     return radius;
   }

   /**
    * Calculates and retrieves the area of the circle.
    *
    * @return the area of the circle
    */
   public double getArea() {
     double area = calculateArea();
      return area;
   }

   // A private method for computing the area of circle
   private double calculateArea(){
     return radius * radius * Math.PI;
   }
}