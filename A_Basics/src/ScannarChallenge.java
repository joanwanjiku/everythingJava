import java.util.Scanner;

public class ScannarChallenge {
    public static void main(String[] args) {
        inputSumAvg();
    }
    public static int checkValid(String number) {
        int num = Integer.parseInt(number);
        return num > 0 ? num : -1;

    }
    public static int getSum() {
        int sum = 0;
        int count = 1;
        int number = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.println("Enter number " + count + " ");
                number = checkValid(scanner.nextLine());
                if (number > 0) {
                    sum += number;
                    count++;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }

        } while (count < 6);
        return sum;
    }

    public static String minMax() {
        int min = 0;
        int max = 0;
        int number = 0;
        int loopCount = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            try {
                System.out.println("Enter a number");
                number = Integer.parseInt(scanner.nextLine());
                if (number > max) {
                    max = number;
                }
                if (number < min) {
                    min = number;
                }

            }catch (NumberFormatException e) {
                System.out.println("Invalid number");
                break;
            }
        } while (true);

        return max +" and min "+ min;

    }
    public static void inputSumAvg(){
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int count = 0;
        while (true) {
            System.out.println("Enter a num");
            String nextEntry = scanner.nextLine();
            try {
                int validNum = Integer.parseInt(nextEntry);
                sum += validNum;
                count++;
            }catch (NumberFormatException e) {
                break;
            }
        }
        double avg = Math.round(sum / count);
        System.out.println("Sum "+ sum + " AVG "+ avg);
    }
}
