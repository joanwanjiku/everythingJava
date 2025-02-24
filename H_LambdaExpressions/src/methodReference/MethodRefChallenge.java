package methodReference;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class MethodRefChallenge {
    public static void main(String[] args) {
        String[] names = {"Joan","Bob","LINA","john","Mercy","ed", "Gary"};
        UnaryOperator<String> u1 = String::toUpperCase;
        UnaryOperator<String> u2 = s -> s + " "+ s.charAt(0);
        UnaryOperator<String> u3 = s -> s + " " + new StringBuilder(s).reverse();

        Arrays.asList(names).replaceAll(u1);
        System.out.println(Arrays.toString(names));
        Arrays.asList(names).replaceAll(u2);
        System.out.println(Arrays.toString(names));
        Arrays.asList(names).replaceAll(u3);
        System.out.println(Arrays.toString(names));






    }
    private static void applyChanges(String[] names, List<UnaryOperator<String>> stringFunc){
        List<String> genArray = Arrays.asList(names);
        for (var func: stringFunc) {
            genArray.replaceAll(s -> s.transform(func));
            System.out.println(Arrays.toString(names));
        }

    }
    
}
