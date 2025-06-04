package basics;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String helloWorld = "%s %s".formatted("Hello", "World");
        System.out.println(helloWorld);

        String regex = format("%s %s", "Hello", "World");
        System.out.println(regex);

        String testString = "Anyone can learn abc's, 123's and any regular expressions";
        String replacement = "(-)";
        String[] patterns = {
                "[abc]",
                "ab|c",
                "[123]",
                "[a-zA-Z]",  //
                "[A]",
                "[a-z]*", // matches any string of lowercase letters
                "[a-zA-Z]+", // matches any string of lowercase letters
                "[a-z]{2}", // matches any string of lowercase letters
                "[a-z]{2,3}", // matches any string of lowercase letters
                "[0-9]{3,4}", // matches any string of lowercase letters
                "[a-zA-Z]*$", // matches any string that ends with zero or more alphanumeric characters (both lowercase and uppercase
                "^[a-zA-Z]{3}", //
                "[aA]ny\\b" // \\b is a word boundary, ensuring that the match is a whole word, not part of another word.

        };
        for (String pa : patterns) {
            String outpot = testString.replaceFirst(pa, replacement);
            System.out.println("pattern: " + pa + ", output ---> " + outpot);
        }
        System.out.println("------------------------------------------------------------");

        String paragraph = """
                Double, double toil and trouble;
                Fire burn and caldron bubble.
                Fillet of a fenny snake,
                In the caldron boil and bake
                Eye of newt and toe of frog,
                Wool of bat and tongue of dog,
                Adder's fork and blind-worm's sting,
                Lizard's leg and howlet's wing,
                For a charm of powerful trouble,
                Like a hell-broth boil and bubble.
                """;
        String[] lines = paragraph.split("\n");
        System.out.println(lines.length);
        String[] words = paragraph.split("\\s");
        System.out.println("This paragraph has " + words.length + " words");
        System.out.println(paragraph.replaceAll("[a-zA-Z]+ble",
                "[GRUB]"));
        System.out.println("------------------------------------------------------------");
        Scanner scanner = new Scanner(paragraph);
        System.out.println(scanner.delimiter());

        System.out.println("------------------------------------------------------------");
        scanner.useDelimiter("\\R");

//        while (scanner.hasNext()) {
//            String element = scanner.next();
//            System.out.println("--------"+ element +"--------");
//
//        }
//
//        scanner.tokens()
//                .map(s -> s.replaceAll("\\p{Punct}", ""))
//                .flatMap(s -> Arrays.stream(s.split("\\s+")))
//                .filter(s -> s.matches("[a-zA-Z]+ble"))
//                .forEach(System.out::println);
        System.out.println(scanner.findInLine("[a-zA-Z]+ble"));
        System.out.println(scanner.findInLine("[a-zA-Z]+ble"));
        scanner.close();
    }
    private static String format(String regex, String... args) {
        int index = 0;
        while(regex.matches(".*%s*.")) {
            regex = regex.replaceFirst("%s", args[index++]);
        }
        return regex;
    }
}
