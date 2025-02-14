public class ForLoop {
    public static void main(String[] args) {
        int counter = 0;
        for (int i = 10; i <= 50; i++) {
            if (isPrime(i)) {
                System.out.println("number " +i);
                counter++;
                if (counter == 3) {
                    break;
                }
            }
        }
        int sum = 0;
        int count = 0;
        for (int j = 1; j <= 1000; j++){
            if (j % 3 == 0 && j % 5 == 0) {
                System.out.println("nums that meet condtion " + j);
                count++;
                sum += j;
                if (count == 5) {
                    break;
                }
            }
        }
        System.out.println("sum "+sum);
    }
//    checks for prime numbers
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i < num; i++)
            if (num % i == 0)
                return false;

        return true;
    }
}
