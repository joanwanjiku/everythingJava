import java.util.*;

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
        bingoPool.stream()
                .limit(15)
                .filter(s -> s.indexOf('G') == 0 || s.indexOf('O') == 0)
                .map(s -> s.charAt(0) + "-" + s.charAt(1))
                .sorted()
                .forEach(System.out::println);

    }
}
