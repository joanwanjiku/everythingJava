package mathRandomPrj.dice;

import mathRandomPrj.game.GameConsole;
import mathRandomPrj.game.Player;

import java.util.*;

public class DicePlayer implements Player {
    private final String name;
    private final List<Integer> dice = new ArrayList<>();
    private final Map<ScoredItem, Integer> scores = new EnumMap<>(ScoredItem.class);

    public DicePlayer(String name) {
        this.name = name;
        for (ScoredItem s: ScoredItem.values()) {
            scores.put(s, null);
        }
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String toString() {
        return "DicePlayer{" +
                "name='" + name + '\'' +
                ", dice=" + dice +
                ", scores=" + scores +
                '}';
    }
    public void rollDice() {
        int randomCount = 5 - dice.size();
        var newDice = new Random().ints(randomCount, 1, 7)
                .sorted()
                .boxed()
                .toList();
        dice.addAll(newDice);
        System.out.println("You rolled: " + dice);
    }
    private  boolean pickLosers() {
        String prompt = """
                Press Enter to score
                type ALL to re-roll all the dice
                List numbers(separated by commas) to re-roll those dice 
                """;
        String input = GameConsole.getUserInput(prompt+ "----> ").trim();
        if (input.isBlank()){
            return true;
        }
        try {
            removeDice(input.split(" "));
        }catch (Exception e){
            e.printStackTrace(System.out);
            System.out.println("Invalid input, Try again");
        }
        return false;
    }

    private void removeDice( String[] s) {
        if (s[0].equals("ALL")) {
            dice.clear();
        }else {
            for (String s1 : s) {
                dice.remove(Integer.parseInt(s1));
            }
            System.out.println("Keeping: " + dice);
        }
    }
    public boolean rollDiceSelect(){
        do {
            rollDice();

        }while (!pickLosers());
        do {
            System.out.println("Select a score category");
        }while (!scoreDice());
        dice.clear();
        return getItemList().isEmpty();

    }
    public List<String> getItemList(){
        return scores.entrySet()
                .stream()
                .filter(e -> e.getValue() == null)
                .map(e -> e.getKey().name())
                .toList();
    }
    private boolean scoreDice() {
        List<String> remainainingItems = getItemList();
        String prompt = String.join("\n", remainainingItems.toArray(new String[0]));
        String userInput = GameConsole.getUserInput(prompt + "\n----> ").toUpperCase();
        if (userInput.isBlank()){
            return false;
        }
        if (!remainainingItems.contains(userInput)){
            System.out.println("Invalid input, Try again");
            return false;
        }
        scores.put(ScoredItem.valueOf(userInput), ScoredItem.valueOf(userInput).score(dice));
        return true;
    }
}
