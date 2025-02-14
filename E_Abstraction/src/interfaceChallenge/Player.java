package interfaceChallenge;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable {
    private String name;
    private String weapon;
    private int hitPoints;
    private int strength;

    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.weapon = "Sword";
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public List<String> write() {
        List<String> saveData = new ArrayList<>();
        saveData.add(0, this.name);
        saveData.add(1, this.weapon);
        saveData.add(2, String.valueOf(this.hitPoints));
        saveData.add(3, String.valueOf(this.strength));
        return saveData;
    }

    @Override
    public void read(List<String> words) {
        if (words.size() > 0 || words != null) {
            this.name = words.get(0);
            this.weapon = words.get(1);
            this.hitPoints = Integer.parseInt(words.get(2));
            this.strength = Integer.parseInt(words.get(3));
        }

    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hitPoints='" + hitPoints + '\'' +
                ", strength=" + strength +
                ", weapon=" +weapon  +
                '}';
    }
}
