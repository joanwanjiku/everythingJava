package methodReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("alpha","bravo","charlie","delta"));
        list.forEach(System.out::println);
        calculator(Integer::sum, 3, 3);
        calculator(Double::sum, 3.56, 3.78);

        Supplier<Plain> ref1 = Plain::new;
        Plain pojo = ref1.get();

        System.out.println("-----------");
        Plain[] plainArray = seedArray(Plain::new, 5);

        calculator(String::concat, "Hello", "World");

        BinaryOperator<String> b1 = String::concat;
        BiFunction<String, String, String> b2 = String::concat;
        UnaryOperator<String> u1 = String::toLowerCase;

        System.out.println(b1.apply("Hello","World"));
        System.out.println(b2.apply("Hello","World"));
        System.out.println(u1.apply("Hello"));


    }
    public static <T> void calculator(BinaryOperator<T> func, T value1, T value2) {
        T result = func.apply(value1, value2);
        System.out.println("Result of operation: " + result);
    }
    private static Plain[] seedArray(Supplier<Plain> ref, int count){
        Plain[] array = new Plain[count];
        Arrays.setAll(array, i -> ref.get());
        return array;
    }
}
