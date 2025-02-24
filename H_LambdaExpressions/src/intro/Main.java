package intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("alpha","bravo","charlie","delta"));
        for (String s: list) {
            System.out.println(s);
        }
        System.out.println("------------");
//        looping
        list.forEach(alphabet -> System.out.println(alphabet));
        list.forEach(s -> {
            char letter = s.charAt(0);
            System.out.println(s +" means "+ letter);
        });

        System.out.println("-------------------");
        int result = calculator((a,b) -> a+b, 3, 3);
        var result2 = calculator((a,b) -> a-b, 3.6, 3.2);

        System.out.println("----------------------------");
        var coords = Arrays.asList(
                new double[]{47.2160, -95.2348},
                new double[]{38.6270, -121.4668},
                new double[]{33.9425, -118.4072}
        );
        coords.forEach(s -> System.out.println(Arrays.toString(s)));

        System.out.println("Consumer Interface-----------------------");

        BiConsumer<Double, Double> p1 = (lat, lng) -> System.out.printf("[lat:%.3f lon:%.3f]%n", lat, lng);

        coords.forEach(s -> processPoint(s[0], s[1], p1));

        coords.forEach(s -> processPoint(s[0], s[1],
                (lat, lng) -> System.out.printf("[lat:%.3f lon:%.3f]%n", lat, lng)));

        System.out.println("Predicate ----------------------------");
        list.removeIf(s -> s.equalsIgnoreCase("bravo"));
        list.forEach(s -> System.out.println(s));

        list.addAll(List.of("echo","easy", "earnet"));
        list.removeIf(s -> s.startsWith("ea"));
        list.forEach(s -> System.out.println(s));

        System.out.println("Function Interface -----------------------------");
        list.replaceAll(s -> s.charAt(0) + " - "+ s.toUpperCase());
        list.forEach(s -> System.out.println(s));

        String[] emptyStrings = new String[10];
        Arrays.fill(emptyStrings," ");
        Arrays.setAll(emptyStrings, i -> ""+ (i+1) + ". "); //
        System.out.println(Arrays.toString(emptyStrings));

        Arrays.setAll(emptyStrings, i -> ""+ (i+1) + ". "
        + switch (i) {
            case 0 -> "zero";
            case 1 -> "one";
            case 2 -> "two";
            default -> "";
        }); //
        System.out.println(Arrays.toString(emptyStrings));

        System.out.println("Supplier Interface -----------------------------");
        String[] colors = {"red", "green", "blue","orange","purple","black","white"};
        String[] randomList = randomValues(15, colors,
                () -> new Random().nextInt(0,colors.length)
        );
        System.out.println(Arrays.toString(randomList));

    }

    public static <T> T myCalculator(Operation<T> func, T value1, T value2) {
        T result = func.operate(value1, value2);
        System.out.println("Result of operation: " + result);
        return result;
    }

    public static <T> T calculator(BinaryOperator<T> func, T value1, T value2) {
        T result = func.apply(value1, value2);
        System.out.println("Result of operation: " + result);
        return result;
    }

    public static <T> void processPoint(T t1, T t2, BiConsumer<T, T> consumer){
        consumer.accept(t1, t2);
    }
    public static String[] randomValues(int count, String[] values, Supplier<Integer> s) {
        String[] result = new String[count];
        for (int i = 0; i < count; i++) {
            result[i] = values[s.get()];
        }
        return result;
    }

}
