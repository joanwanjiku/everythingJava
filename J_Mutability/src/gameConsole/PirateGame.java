package gameConsole;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PirateGame extends Game<Pirate> {
    private static final List<List<String>> levelMap;

//    Static initializer block
    static {
        levelMap = new ArrayList<>();
        System.out.println("loading data");
        loadData();
        if (levelMap.isEmpty()) {
            throw new RuntimeException("Could not load data");
        }
        System.out.println("Finished loading");
    }

    private static void loadData() {
//        level 1
        levelMap.add(new ArrayList<>(List.of(
                "BridgeTown, Barbados",
                "CapeTown, South Africa",
                "FittVillage, Jamaica",
                "Savannah, USA"
        )));

//        level 2
        levelMap.add(new ArrayList<>(List.of(
                "HowTown, Mauritius",
                "LegTown, Trinidad",
                "SaintTown, Jamaica",
                "Fort-de-France, France"
        )));
    }

    public PirateGame(String gameName) {
        super(gameName);
    }

    @Override
    public Pirate createPlayer(String name) {
        return new Pirate(name);
    }

    @Override
    public Map<Character, GameAction> getGameActions(int playerId) {
        Pirate player = getPlayer(playerId);
        System.out.println(player);
        List<Weapon> weapons = Weapon.getWeaponsByLevel(player.value("level"));
        Map<Character, GameAction> actions = new LinkedHashMap<>();
        for (Weapon weapon : weapons) {
            char init = weapon.name().charAt(0);
            actions.put(init, new GameAction(init, "Use " + weapon, this::useWeapon));
        }
        actions.putAll(getStandardActions());
        return actions;

    }
    public static List<String> getTowns(int level) {
        if (level <= (levelMap.size() - 1)) {
            return levelMap.get(level);
        }
        return null;
    }
    private boolean useWeapon(int playerIndex){
        return getPlayer(playerIndex).useWeapon();
    }

    @Override
    public boolean executeGameAction(int player, GameAction action) {
        getPlayer(player).setCurrentWeapon(Weapon.getWeaponByChar(action.key()));
        return super.executeGameAction(player, action);
    }

}
