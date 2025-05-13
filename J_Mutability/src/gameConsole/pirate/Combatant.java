package gameConsole.pirate;

import gameConsole.GamePlayer;

import java.util.*;

public sealed abstract class Combatant implements GamePlayer permits Islander, Pirate, Soldier {
    private final String name;
    private final Map<String, Integer> gameData;
    private Weapon weapon;
    public Combatant(String name) {
        this.name = name;
    }

    public Combatant(String name, Map<String, Integer> gameData) {
        this.name = name;
        if (gameData != null) {
            this.gameData.putAll(gameData);
        }
    }
    {
        gameData = new HashMap<>(Map.of(
                "health", 100,
                "score", 0
        ));
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
    protected void setValue(String name, int value) {
        gameData.put(name, value);
    }
    protected void addValue(String name, int value) {
        gameData.compute(name, (k, v) -> v += value);
    }
    protected void adjustHealth(int adj) {
        int health = value("health");
        health += adj;
        health = (health < 0) ? 0 : ((health > 100) ? 100 : health);
        setValue("health", health);
    }
    boolean useWeapon(Combatant opponent){
        System.out.println(name +" Used the "+ weapon);
        if( new Random().nextBoolean()){
            System.out.println(" and HIT *** "+ opponent.name() + "! ***");
            opponent.adjustHealth(-weapon.getHitPoints());
            System.out.println("%s's health=%d, %s's health=%d".formatted(name, value("health"), opponent.name(), opponent.value("health")));
            addValue("score", 50);
        }else {
            System.out.println(" and MISSED *** "+ opponent.name() + "! ***");
        }
        return (opponent.value("health") <= 0);
    }


    @Override
    public String name() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
    public String information() {
        return name + " " + gameData;
    }
}
