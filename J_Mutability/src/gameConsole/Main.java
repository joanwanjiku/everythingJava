package gameConsole;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var console = new GameConsole(new ShooterGame("Shooter Game"));
        var playerId = console.addPlayerTest();
        console.run(playerId);

    }
}
