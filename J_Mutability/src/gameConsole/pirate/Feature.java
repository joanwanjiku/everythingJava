package gameConsole.pirate;

public enum Feature {
    ALLIGATOR(-45),
    ALOE(10),
    JELLYFISH(-10),
    PINEAPPLE(20),
    SNAKE(-25),
    SPRING(30),
    SUN_POISON(-15);

    private final int healthPoints;
    Feature(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

}
