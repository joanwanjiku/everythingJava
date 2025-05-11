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
    public void run(int playerId) {
        boolean done = false;
        while (!done) {
            var gameActions = game.getGameActions(playerId);
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
                done = game.executeGameAction(addPlayer(), action);
                if (!done){
                    System.out.println("----------------------------------------");
                }
            }
            }
        }
}
