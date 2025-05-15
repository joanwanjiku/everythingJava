import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> bingoPool = new ArrayList<>(75);
        int start = 1;
        for (char c : "BINGO".toCharArray()) {
            for (int i = start; i <  (start + 15); i++) {
                bingoPool.add("" + c + i);
            }
            start += 15;
        }
        Collections.shuffle(bingoPool);
//        List<String> firstOnes = bingoPool.subList(0, 15); this alters the original list
        List<String> firstOnes = new ArrayList<>(bingoPool.subList(0, 15));
        firstOnes.sort(Comparator.naturalOrder());
        firstOnes.replaceAll(s -> {
            if (s.indexOf('G') == 0 || s.indexOf('O') == 0) {
                String updated = s.charAt(0) + "-" + s.charAt(1);
                System.out.println(updated + " ");
                return updated;
            }
            return s;
        });
//        System.out.println(bingoPool);
        System.out.println("\n----------------------------------");
        var tempStream = bingoPool.stream()
                .limit(15)
                .filter(s -> s.indexOf('G') == 0 || s.indexOf('O') == 0)
                .map(s -> s.charAt(0) + "-" + s.charAt(1))
                .sorted();
//                .forEach(System.out::println);
//        tempStream.forEach(System.out::println); closes the stream
        tempStream.forEach(s -> System.out.println(s.toLowerCase() + " "));

        System.out.println("\n----------------------------------");
        String[] strings = {"A", "B", "C", "D", "E", "F", "G"};
        var firstStream = Arrays.stream(strings)
                .sorted(Comparator.reverseOrder());
        var secondStream = Stream.of("J", "K", "L", "M", "N", "O", "P")
                .map(String::toLowerCase);
        Stream.concat(firstStream, secondStream)
                .map(s -> s + " -")
                .forEach(System.out::println);
        System.out.println("\n----------------------------------");

        Map<Character, int[]> myMap = new LinkedHashMap<>();
        int bingoIndex = 1;
        for (char c : "BINGO".toCharArray()) {
            int[] numbers = new int[15];
            int labelNo = bingoIndex;
            Arrays.setAll(numbers, i -> i + labelNo);
            myMap.put(c, numbers);
            bingoIndex += 15;
        }
        myMap.entrySet()
                .stream()
                .map(e -> e.getKey() + " has range "+ e.getValue()[0] + " to " + e.getValue()[e.getValue().length - 1])
                .forEach(System.out::println);
        System.out.println("\n----------------------------------");
        Random random = new Random();
        Stream.generate(() -> random.nextInt(2))
                .limit(10)
                .forEach(System.out::print);
        System.out.println("\n----------------------------------");
        IntStream.iterate(1, i -> i + 1)
                .filter(Main::isPrime)
                .limit(20)
                .forEach(System.out::println);

        System.out.println("\n----------------------------------");
        IntStream.iterate(1, i -> i + 1)
                .limit(20)
                .filter(Main::isPrime)
                .forEach(System.out::println);

        System.out.println("\n----------------------------------");
        IntStream.iterate(1, n -> n <=20,i -> i + 1)
                .filter(Main::isPrime)
                .forEach(System.out::println);

        System.out.println("\n----------------------------------");
        IntStream.range(1,100)
                .filter(Main::isPrime)
                .forEach(System.out::println);


    }
    public static boolean isPrime(int n) {
        if (n <= 2){
            return n == 2;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
