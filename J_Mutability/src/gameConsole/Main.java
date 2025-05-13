package gameConsole;

public class Main {
    public static void main(String[] args) {
//        var console = new GameConsole(new ShooterGame("Shooter Game"));
//        var playerId = console.addPlayerTest();
//        console.run(playerId);
        Weapon weapon = Weapon.getWeaponByChar('P');
        System.out.println("weapon = "+ weapon + ", hitPoints = " + weapon.getHitPoints());

        var list = Weapon.getWeaponsByLevel(1);
        list.forEach(System.out::println);
        Pirate tim = new Pirate("Tim");
        System.out.println(tim);
        PirateGame.getTowns(0).forEach(System.out::println);
        System.out.println("------------------");
        PirateGame.getTowns(1).forEach(System.out::println);
        System.out.println("----------------------------------------------------------------------------");
        var console = new GameConsole<>(new PirateGame("Pirate Game"));
        var playerId = console.addPlayerTest();
        console.run(playerId);

    }
}
