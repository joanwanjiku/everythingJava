import java.time.Year;
import java.util.Date;
import java.util.Scanner;

public class ScannerConsole {
    public static void main(String[] args) {
        int year = Year.now().getValue();

        try {
            System.out.println(getInputFromScanner(year));
        } catch (NullPointerException e) {
            System.out.println(getInputFromScanner(year));
        }
    }
    public static int checkData(int currentYear, String dateOfBirth) {
        int dob = Integer.parseInt(dateOfBirth);
        int minimumYear = currentYear - 125;

        if (dob < minimumYear || dob > currentYear) {
            return -1;
        }
        return  currentYear - dob;
    }
    public static String getInputFromConsole(int currentYear) {
        String name = System.console().readLine("What is your name? ");
        String dateOfBirth = System.console().readLine("What year were you born ");
        int age = currentYear - Integer.parseInt(dateOfBirth);
        return name + " You are "+ age + " years old";

    }
    public static String getInputFromScanner(int currentYear) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        boolean validDOB = false;
        int age = 0;
        do {
            try {
                System.out.println("Enter your date of birth >= : "+ (currentYear -125)+ " and <= " + currentYear);
                age = checkData(currentYear, scanner.nextLine());
                validDOB = age < 0 ? false :true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }
        } while (!validDOB);

        return name + " You are "+ age + " years old";
    }
}
