import java.util.Scanner;

public class DebugExample {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number between 1 and 12");
        int monthNum = Integer.parseInt(sc.nextLine());

        if (monthNum % 2 == 0) {
            System.out.println("The month is Even");
        } else {
            System.out.println("The month is Odd");
        }

        // Call the method to return the name of the month
        String month = getMonthName(monthNum);
        System.out.println(month);

        // While loop to calculate time to New Year
        int j = 12 - monthNum;
        int i = monthNum;
        while (i != 12) {
            i++;
            j++;
            System.out.println("Calculating time to New Year...");
        }
        System.out.println("Total months left for New Year: " + j);
    }

    private static String getMonthName(int num) {
        String month = "";
        switch (num) {
            case 1:
                month = "January";
                break;
            case 2:
                month = "February";
                break;
            case 3:
                month = "March";
                break;
            case 4:
                month = "April";
                break;
            case 5:
                month = "May";
                break;
            case 6:
                month = "June";
                break;
            case 7:
                month = "July";
                break;
            case 8:
                month = "August";
                break;
            case 9:
                month = "September";
                break;
            case 10:
                month = "October";
                break;
            case 11:
                month = "November";
                break;
            case 12:
                month = "December";
                break;
            default:
                month = "Invalid month";
                break;
        }
        return month;
    }
}
