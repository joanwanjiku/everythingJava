package gameConsole.pirate;

import gameConsole.GamePlayer;

import java.util.*;

public final class Pirate extends Combatant {

    private final List<String> townsVisited = new LinkedList<>();
    private List<Loot> loot;
    private List<Combatant> opponents;
    private List<Feature> features;

    public Pirate(String name) {
        super(name, Map.of("level", 0, "townIndex", 0));
        vistTown();
    }

    boolean useWeapon(){
        System.out.println("Used the "+ super.getCurrentWeapon());
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

    public String information() {
        var current = ((LinkedList<String>) townsVisited).getLast();
        String[] simpleNames = new String[townsVisited.size()];
        Arrays.setAll(simpleNames, i -> townsVisited.get(i).split(",")[0]);
        return "-----> " + current +
                "\n" + super.information() +
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
