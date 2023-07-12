import java.util.List;
import java.util.ArrayList;

public class Main{

   public static void main(String[] args)
   {
      Sandwich burger = new Sandwich("Cheeseburger",2.75);
      Sandwich club = new Sandwich("Club Sandwich", 2.75);
      Salad spinachSalad = new Salad("Spinach Salad",1.25);
      Salad coleslaw = new Salad("Coleslaw", 1.25);
      Drink orange = new Drink("Orange Soda", 1.25);
      Drink cap = new Drink("Cappuccino", 3.50);

      System.out.println("******** Test case 1 ********");
      Trio trio1 = new Trio(burger,spinachSalad, orange);
      System.out.println("It should print: \n \t Cheeseburger/Spinach Salad/Orange Soda Trio \nand it prints: \n \t " + trio1.getName());
      System.out.println("It should print: \n \t 4.0 \nand it prints: \n \t " + trio1.getPrice());


      System.out.println("\n******** Test case 2 ********");

      Trio trio2 = new Trio(club,coleslaw,cap);
      System.out.println("It should print: \n \t Club Sandwich/Coleslaw/Capuccino Trio \nand it prints: \n \t " + trio2.getName());
      System.out.println("It should print: \n \t 6.25 \nand it prints: \n \t " + trio2.getPrice());
   }
}
