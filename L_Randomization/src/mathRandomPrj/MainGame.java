package mathRandomPrj;

import mathRandomPrj.dice.DiceGame;
import mathRandomPrj.dice.ScoredItem;
import mathRandomPrj.game.Game;
import mathRandomPrj.game.GameConsole;

import java.util.ArrayList;
import java.util.List;

public class MainGame {
    public static void main(String[] args) {
//        List<Integer> currentDice = new ArrayList<>(List.of(2,3,5,4,3));
//        for (ScoredItem s : ScoredItem.values()){
//            System.out.printf("Score for %s is %d%n", s, s.score(currentDice));
//
//        }
        var console = new GameConsole(new DiceGame("Dice Game"));
        console.playGame(console.addPlayer());
    }
}
