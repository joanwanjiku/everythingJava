package cardGame;

import java.util.ArrayList;
import java.util.List;

public record Card(Suit suit, String faceField, int rank ) {


    public static Card getNumericCard(Suit suit, int cardNum){
        if (cardNum > 1 && cardNum < 11) {
            return new Card(suit, String.valueOf(cardNum), cardNum-2);
        }
        System.out.println("Invalid Numeric card selected");
        return null;
    }
    public static Card getFaceCard(Suit suit, char abbrev){
        int charIndex = "JQKA".indexOf(abbrev);
        if (charIndex > -1){
            return new Card(suit, ""+ abbrev, charIndex+9);
        }
        System.out.println("Invalid Face Card selected");
        return null;
    }
    public static List<Card> getStandardCard(){
        List<Card> deck = new ArrayList<>(52);
        for (Suit suit : Suit.values()){
            for (int i = 2; i <= 10; i++){
                deck.add(getNumericCard(suit, i));
            }
            for (char abbrev : "JQKA".toCharArray()){
                deck.add(getFaceCard(suit, abbrev));
            }
        }
        return deck;
    }
    public static void printDeck(List<Card> deck){
        printDeck(deck, "Current deck", 4);

    }
    public static void printDeck(List<Card> deck, String desc, int rows){
        System.out.println("---------------------------");
        if (desc != null) {
            System.out.println(desc);
        }
        int cardInRows = deck.size() / rows;
        for (int i = 0; i < rows; i++) {
            int startIndex = i * cardInRows;
            int endIndex = startIndex + cardInRows;
            deck.subList(startIndex, endIndex).forEach(c -> System.out.println(c + " "));
            System.out.println();
        }

    }


    @Override
    public String toString() {
        int index = faceField.equals("10") ? 2 : 1;
        String faceString = faceField.substring(0, index);
        return "%s%c(%d)".formatted(faceString, suit.getImage(), rank);
    }
}
