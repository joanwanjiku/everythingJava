package gameConsole;

import java.util.*;

public class Pirate implements GamePlayer {
    private final String name;
    private final Map<String, Integer> gameData;
    private final List<String> townsVisited = new LinkedList<>();
    private Weapon weapon;

    public Pirate(String name) {
        this.name = name;
    }
    {
        gameData = new HashMap<>(Map.of(
                "health", 100,
                "score", 0,
                "level", 0,
                "townIndex", 0
        ));
        vistTown();
    }
    public Weapon getCurrentWeapon(){
        return weapon;
    }

    void setCurrentWeapon(Weapon weapon){
        this.weapon = weapon;
    }
    int value(String name) {
       return gameData.get(name);
    }
    private void setValue(String name, int value) {
        gameData.put(name, value);
    }
    private void addValue(String name, int value) {
        gameData.compute(name, (k, v) -> v += value);
    }
    private void adjustHealth(int adj) {
        int health = value("health");
        health += adj;
        health = (health < 0) ? 0 : ((health > 100) ? 100 : health);
        setValue("health", health);
    }
    boolean useWeapon(){
        System.out.println("Used the "+ weapon);
        return visitNextTown();
    }
    boolean vistTown(){
        List<String> towns = PirateGame.getTowns(value("level"));
        if (towns == null) return true;
        String town = towns.get(value("townIndex"));
        if (town !=null){
            townsVisited.add(town);
            return false;
        }
        return true;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String toString() {
        var current = ((LinkedList<String>) townsVisited).getLast();
        String[] simpleNames = new String[townsVisited.size()];
        Arrays.setAll(simpleNames, i -> townsVisited.get(i).split(",")[0]);
        return "-----> " + current +
                "\nPirate "+ name + " "+ gameData +
                "\nTownsVisited: " + Arrays.toString(simpleNames);
    }
    private boolean visitNextTown(){
        int townIndex = value("townIndex");
        var towns = PirateGame.getTowns(value("level"));
        if (towns == null) return true;
        if (townIndex >= towns.size() -1) {
            System.out.println("You have visited all the towns: 500 bonus points");
            addValue("score", 500);
            addValue("level", 1);
            setValue("townIndex", 0);

        }else {
            System.out.println("Sailing to nex town! Bonus 50 points");
            addValue("score", 50);
            addValue("townIndex", 1);

        }
        return vistTown();
    }
}
