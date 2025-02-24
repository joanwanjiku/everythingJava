package intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class LambdaChallenge {
    private static Random random = new Random();

    public static void main(String[] args) {
        Consumer<String> printTheParts = s -> Arrays.asList(s.split(" ")).forEach(z -> System.out.println(z));
        printTheParts.accept("Hello World");

        UnaryOperator<String> formattedExpression = (s) -> {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < s.length(); i += 2) {
                result.append(s.charAt(i));
            }
            return result.toString();
        };
        String result = "1234567890".transform(formattedExpression);
        System.out.println(result);

        String answer = everySecondChar("1234567890", formattedExpression);
        System.out.println(answer);

        Supplier<String> iLoveJava = () -> "I love Java";
        System.out.println(iLoveJava.get());

        String[] names = {"Joan","Bob","LINA","john","Mercy","ed", "Gary"};
        Arrays.setAll(names, i -> names[i].toUpperCase());
        List<String> fnames = Arrays.asList(names);


        fnames.replaceAll(s -> s += " "+getRandomChar('A', 'D') + "." );
        System.out.println(Arrays.toString(names));
        fnames.replaceAll(s -> s += " "+reversedname(s.split(" ")[0]));
        System.out.println(fnames);

        List<String> newList = new ArrayList<>(List.of(names));
        newList.removeIf(s -> s.substring(0, s.indexOf(" ")).equals(
                s.substring(s.lastIndexOf(" ") + 1)
        ));
        System.out.println(newList);




    }
    public static String everySecondChar(String source) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < source.length(); i += 2) {
            result.append(source.charAt(i));
        }
        return result.toString();
    }
    public static String everySecondChar(String source, UnaryOperator<String> operator) {
        return operator.apply(source);

    }
    public static char getRandomChar(char startChar, char endChar ){
        return (char) random.nextInt(startChar, endChar + 1);
    }
    private static String reversedname(String fname) {
        return new StringBuilder(fname).reverse().toString();
    }





}
