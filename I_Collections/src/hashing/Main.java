package hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String aText = "Hello";
        String bText = "Hello";
        String cText = String.join("l", "He", "lo");
        String dText = "He".concat("llo");
        String eText = "hello";
        List<String> helloStrings = Arrays.asList(aText,bText,cText,dText,eText);

        helloStrings.forEach(s -> System.out.println(s + ": "+ s.hashCode()));

        Set<String> mySet = new HashSet<>(helloStrings); //
        System.out.println("Set size: " + mySet.size());

        PlayingCard aceHearts = new PlayingCard("Hearts", "Ace");
        PlayingCard kingClubs = new PlayingCard("Clubs", "King");
        PlayingCard queenSpades = new PlayingCard("Spades", "Queen");

        List<PlayingCard> cards = Arrays.asList(aceHearts, kingClubs, queenSpades);
        cards.forEach(card -> System.out.println(card + ": "+ card.hashCode()));

        Set<PlayingCard> deck = new HashSet<>();
        for (PlayingCard c: cards) {
            if (!deck.add(c)){
                System.out.println("Found duplicate " + c);
            }
        }
        System.out.println(deck);
    }
}
