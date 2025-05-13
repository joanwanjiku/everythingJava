package mainFinal;

import gameConsole.GameConsole;
import gameConsole.pirate.PirateGame;

public class Main {
    public static void main(String[] args) {
        GameConsole specialGameConsole = new GameConsole(new PirateGame("Pirate Game"));

    }
}
