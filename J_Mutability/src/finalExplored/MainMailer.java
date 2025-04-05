package finalExplored;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MainMailer {
    public static void main(String[] args) {
        String[] names = {"John Green", "Jane Moss", "Bob Smith", "John Doe Ph.D.", "John Doe M.D.", "Ed Doe"};

        List<StringBuilder> population = getNames(names);
        Map<StringBuilder, Integer> counts = new TreeMap<>();
        population.forEach(s -> {
            counts.merge(s, 1, Integer::sum);
        });
        System.out.println(counts);

        StringBuilder bob = new StringBuilder("Bob Smith");
        System.out.println("Bob Smith: " + counts.get(bob));

        System.out.println("------------------");

        List<StringBuilder> standardNames = standardNames(population);
        System.out.println(standardNames);
    }
    private static List<StringBuilder> getNames(String[] names) {
        List<StringBuilder> nameList = new ArrayList<>();
        int index = 3;
        for (String name : names) {
            for (int i = 0; i < index; i++) {
                nameList.add(new StringBuilder(name));
            }
            index++;
        }
        return nameList;
    }
    private static List<StringBuilder> standardNames(List<StringBuilder> namesList) {
        List<StringBuilder> nameList = new ArrayList<>();
        for (StringBuilder name : namesList) {
            for (String suffix : new String[]{"Ph.D.", "M.D."}) {
                int startIndex = -1;
                if ((startIndex = name.indexOf(suffix)) != -1) {
                    name.replace(startIndex -1, startIndex + suffix.length(), "");
                }
                nameList.add(name);
            }
        }
        return nameList;

    }
}
