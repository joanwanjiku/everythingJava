import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Challenge {
    static int counter = 0;
    public static void main(String[] args) {
        int seed = 1;

        var streamB = Stream.iterate(seed, i -> i <= 15, i -> i + 1)
                .map(i -> "B" + i);
        seed += 15;
        var streamI = IntStream.range(seed, seed + 15)
                .mapToObj(i -> "I" + i);
        seed += 15;
        var kSeed = seed;
        var streamN = Stream.generate(Challenge::getCounter)
                .limit(15)
                .map(i -> "N" + (kSeed+i));
        seed += 15;
        var streamG = Stream.iterate(seed, i -> i+1)
                        .limit(15)
                        .map(i -> "G" + i);
        seed += 15;
        int nSeed = seed;
        String[] arr0 = new String[15];
        Arrays.setAll(arr0, i -> "O" + (nSeed + i));
        var streamO = Arrays.stream(arr0);

        var stream = Stream.concat(streamB, Stream.concat(streamI, Stream.concat(streamN, Stream.concat(streamG, streamO))));
        stream.forEach(System.out::println);
    }
    private static int getCounter() {
        return counter++;
    }
}
