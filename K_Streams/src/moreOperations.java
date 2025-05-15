import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class moreOperations {
    public static void main(String[] args) {
        IntStream.iterate((int) 'A', i -> i <= (int) 'z', i -> i + 1)
                .filter(Character::isAlphabetic)
                .takeWhile(Character::isUpperCase)
//                .dropWhile(Character::isLowerCase)
//                .skip(5)
//                .filter(i -> Character.toUpperCase(i) > 'E')
                .forEach(d -> System.out.printf("%c ", d));

        System.out.println("\n----------------------------------");
        int maxSeats = 100;
        int seatsInRow = 10;
        var stream =
                Stream.iterate(0, i -> i < maxSeats, i -> i + 1)
                        .map(i -> new Seat((char) ('A' + i / seatsInRow),
                                i % seatsInRow + 1))
                        .skip(5)
                        .limit(10)
                        .peek(s -> System.out.println("---> " + s))
                                .sorted(Comparator.comparing(Seat::price)
                                        .thenComparing(Seat::toString));
//                        .mapToDouble(Seat::price) // primitive stream
//                        .boxed()
//                        .map("$%.2f"::formatted);
        stream.forEach(System.out::println);
    }
}
