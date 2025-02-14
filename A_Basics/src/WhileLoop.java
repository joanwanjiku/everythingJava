public class WhileLoop {
    public static void main(String[] args) {
        int num = 5;
        int count = 0;
       while (num  <= 20) {
           if (isEvenNumber(num)) {
               System.out.println(num + " is an even number");
               count += 1;
               if (count == 5) {
                   break;
               }
           }
           num++;

       }
        System.out.println(count);

        System.out.println(sumDigits(345));
    }

    public static boolean isEvenNumber(int num) {
            return num % 2 ==0;
    }
    public static int sumDigits(int num) {
        if (num < 0) {
            return -1;
        }
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static boolean isPalindrome(int number) {
        if (number < 0) {
            return false;
        }
        int reverse = 0;
        while (number > reverse) {
            reverse = reverse * 10 + number % 10;
            number /= 10;
        }
        return number == reverse;
    }
    public static int getEvenDigitSum(int number) {
        if (number < 0) {
            return -1;
        }
        int sum = 0;
        while (number > 0 ) {
            if (number % 2 == 0) {
                sum += number % 10;
            }
            number /= 10;
        }
        return sum;
    }


}
