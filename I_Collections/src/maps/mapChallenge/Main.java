package maps.mapChallenge;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String myLocations = """
                road,at the end of the road, W: hill, E:well house,S:valley,N:forest
                hill,on top of hill with a view in all directions,N:forest, E:road
                valley,in a forest valley beside a tumbling stream,N:road,W:hill,E:stream""";
        AdventureGame game = new AdventureGame();
        game.play("road");
        Scanner scanner = new Scanner(System.in);
        while (true){
            String input = scanner.nextLine().trim().toUpperCase().substring(0, 1);
            if (input.equals("Q")){
                break;
            }
            game.move(input);
        }
    }
}
