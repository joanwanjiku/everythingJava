package gameConsole;

import java.util.Scanner;

public class GameConsole <T extends Game<? extends GamePlayer>> {
    private final T game;
    private static final Scanner scanner = new Scanner(System.in);

    public GameConsole(T game) {
        this.game = game;
    }
    public int addPlayer() {
        System.out.println("Enter your username:- ");
        String username = scanner.nextLine();
        System.out.printf("Welcome %s to %s%n", username, game.getGameName());
        return game.addPlayer(username);
    }
    public void run() {
        while (true) {
            var gameActions = game.getGameActions(addPlayer());
            System.out.println("Game Options:- ");
            for (Character c : gameActions.keySet()) {
                String prompt = gameActions.get(c).prompt();
                System.out.println("\t" + prompt+ " (" + c + ")");
            }
            System.out.print("Enter next Action:");
            char nextAction = scanner.next().toUpperCase().charAt(0);
            GameAction action = gameActions.get(nextAction);
            if (action == null) {
                System.out.println("Invalid Action");
            } else {
                System.out.println("----------------------------------------");
                game.executeGameAction(addPlayer(), action);
            }
            }
        }
}
