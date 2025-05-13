package gameConsole;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class Game<T extends GamePlayer> {
    private final String gameName;
    private final List<T> players = new ArrayList<>();
    private Map<Character, GameAction> standardActions = null;

    public Game(String gameName) {
        this.gameName = gameName;
    }

    public String getGameName() {
        return gameName;
    }

    public Map<Character, GameAction> getStandardActions() {
        if (standardActions == null) {
            standardActions = new LinkedHashMap<>(Map.of(
                    'I', new GameAction('I', "Print player info", p -> this.printPlayer(p)),
                    'Q', new GameAction('Q', "Quit game", p -> this.quit(p))
            ));
        }
        return standardActions;
    }
    public abstract T createPlayer(String name);
    public abstract Map<Character, GameAction> getGameActions(int playerId);
    final int addPlayer(String name) {
        T player = createPlayer(name);
        if (player != null) {
            players.add(player);
            return players.size() - 1;
        }
        return -1;
    }
    protected final T getPlayer(int playerId) {
        return players.get(playerId);
    }
    public boolean executeGameAction(int player, GameAction action){
        return action.action().test(player);
    }
    public boolean printPlayer(int playerId) {
        GamePlayer player = players.get(playerId);
        System.out.println(player.name() +" is at "+ playerId);
        return false;
    }

    public boolean quit(int playerId) {
        GamePlayer player = players.get(playerId);
        System.out.println(player.name() + " has quit at " + playerId);
        return true;
    }
}
