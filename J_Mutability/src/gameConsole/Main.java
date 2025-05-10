package gameConsole;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String gameSelection = """
                Welcome %s to the game console
                Enter c to see the game selection
                Enter q to quit""".formatted(username);
        System.out.println(gameSelection);
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                break;
            }
            if (input.equals("c")) {
                System.out.println(gameSelection);
            }
        }
    }
}
