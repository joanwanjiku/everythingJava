package gameConsole;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public enum Weapon {
    KNIFE(0, 10),
    AXE(0,30),
    MACHETE(1,40),
    PISTOL(1,50),
    TRIAL(2,60);

    private final int minLevel;
    private final int hitPoints;

    Weapon(int minLevel, int hitPoints) {
        this.minLevel = minLevel;
        this.hitPoints = hitPoints;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public int getHitPoints() {
        return hitPoints;
    }
    public static Weapon getWeaponByChar(char c){
        for (Weapon w : Weapon.values()) {
            if (w.name().charAt(0) == c) return w;
        }
        return values()[0];
    }
    public static List<Weapon> getWeaponsByLevel(int levelOfPlay){
        List<Weapon> weapons = new ArrayList<>(EnumSet.allOf(Weapon.class));
        weapons.removeIf(w -> w.getMinLevel() > levelOfPlay);
        return weapons;
    }
}
