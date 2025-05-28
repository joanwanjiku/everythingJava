package mathRandomPrj;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
//        int maxMinusfive = Integer.MAX_VALUE - 5;
//        for (int i = 0, id = maxMinusfive; i < 10; id = Math.incrementExact(id), i++) {
//            System.out.printf("Assigning id %,d%n", id);
//        }

        System.out.println(Math.abs(-50));
        System.out.println(Math.abs(Integer.MIN_VALUE));
        System.out.println(Math.abs((long)Integer.MIN_VALUE));

//        max -> return the largest value that can be represented as a long
//        min -> return the smallest value that can be represented as a long
        // round -> round to the nearest long
        // ceil -> round up to the nearest long
        System.out.println("-------------------------------");
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.printf("%1$d = %1$c%n", random.nextInt('A', 'Z'));
        }
        System.out.println("-------------------------------");
        random.ints(0, 10).limit(10).forEach(System.out::println);
        System.out.println("-------------------------------");
        random.ints(20, 0, 10).forEach(System.out::println);
        System.out.println("-------------------------------");
    }
}
