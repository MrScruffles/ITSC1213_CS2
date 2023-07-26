package NetBeansProjects.Labs.Module12Lab;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("inputData.txt");
        Scanner fileScanner = new Scanner(inputFile);
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            System.out.println(line);
        }
        fileScanner.close();
    }
}
