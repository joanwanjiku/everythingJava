package mathRandomPrj;

import java.util.*;
import java.util.Random;
import java.util.Scanner;

public class Challenge {
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        List<Integer> currentList = new ArrayList<>();
//        int rolls = 0;
        do {
            rollDice(currentList);
        }while (!pickLosers(currentList));
        System.out.println("Game Over, Real game would score and continue");


    }
    private static void rollDice(List<Integer> currentList) {
        int randomCount = 5 - currentList.size();
        var newDice = random.ints(randomCount, 1, 7)
                .sorted()
                .boxed()
                .toList();
        currentList.addAll(newDice);
        System.out.println("You rolled: " + currentList);
    }
    private static boolean pickLosers(List<Integer> currentList) {
        String prompt = """
                Press Enter to score
                type ALL to re-roll all the dice
                List numbers(separated by commas) to re-roll those dice 
                """;
        System.out.println(prompt+ "----> ");
        String input = scanner.nextLine();
        if (input.isBlank()){
            return true;
        }
        try {
            removeDice(currentList, input.split(" "));
        }catch (Exception e){
            e.printStackTrace(System.out);
            System.out.println("Invalid input, Try again");
        }
        return false;
    }

    private static void removeDice(List<Integer> currentList, String[] s) {
        if (s[0].equals("ALL")) {
            currentList.clear();
        }else {
            for (String s1 : s) {
                currentList.remove(Integer.parseInt(s1));
            }
            System.out.println("Keeping: " + currentList);
        }
    }
}
