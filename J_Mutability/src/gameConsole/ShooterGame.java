package gameConsole;

import java.util.LinkedHashMap;
import java.util.Map;

public class ShooterGame extends Game<Shooter> {

    public ShooterGame(String gameName) {
        super(gameName);
    }

    @Override
    public Shooter createPlayer(String name) {
        return new Shooter(name);
    }

    @Override
    public Map<Character, GameAction> getGameActions(int playerId) {
        var map = new LinkedHashMap<>(Map.of(
                'F', new GameAction('F', "Find a Prize", this::findPrize),
                'S', new GameAction('S', "Use a Weapon", this::useWeapon)
        ));
        map.putAll(getStandardActions());
        return map;
    }

    private boolean findPrize(int playerIndex) {
        return getPlayer(playerIndex).findPrize();
    }
    public boolean useWeapon(int playerIndex){
        return getPlayer(playerIndex).useWeapon("Rifle");
    }

}
