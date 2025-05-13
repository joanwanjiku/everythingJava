package gameConsole.pirate;

public enum Loot {
    Silver(10),
    Gold(20),
    Diamond(30),
    Ruby(40),
    Emerald(50);
    private final int worth;
    Loot(int worth) {
        this.worth = worth;
    }

    public int getWorth() {
        return worth;
    }

}
