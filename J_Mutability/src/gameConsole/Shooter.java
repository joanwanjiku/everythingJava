package gameConsole;

public record Shooter(String name) implements GamePlayer {
    boolean findPrize(){
        System.out.println("Found a prize");
        return false;
    }
    boolean useWeapon(String weapon){
        System.out.println("You Shot your weapon "+ weapon);
        return false;
    }
}
