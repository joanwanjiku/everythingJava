package cardGame;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        Card[] cardArray = new Card[13];
        Card aceOfHearts = Card.getFaceCard(Suit.HEARTS, 'A');
        Arrays.fill(cardArray, aceOfHearts);
        Card.printDeck(Arrays.asList(cardArray), "Array of Ace of Hearts", 4);

        List<Card> cards = new ArrayList<>(52);
        Collections.fill(cards, aceOfHearts);
        System.out.println("cards.size()= "+ cards.size());

        List<Card> acesOfHearts = Collections.nCopies(13, aceOfHearts);
        Card.printDeck(acesOfHearts, "Aces of hearts", 1);

        Card kingOfClub = Card.getFaceCard(Suit.CLUBS, 'K');
        List<Card> kingsOfClub = Collections.nCopies(13, kingOfClub);
        Card.printDeck(kingsOfClub, "King of clubs", 1);

        Collections.addAll(cards, cardArray);
        Collections.addAll(cards, cardArray);

        Card.printDeck(cards, "Card Collection with Aces added", 2);

        Collections.copy(cards, kingsOfClub);
        Card.printDeck(cards, "Card Collection with kings copied", 2);

        List<Card> deck = Card.getStandardCard();
        Collections.shuffle(deck);
        Card.printDeck(deck, "Shuffled deck", 4);

        var sortingAlgo = Comparator.comparing(Card::rank).thenComparing(Card::suit);
        Collections.sort(deck, sortingAlgo);
        Card.printDeck(deck, "Sorted deck by rank, suit", 13);
        Collections.reverse(deck);

        List<Card> kings = new ArrayList<>(deck.subList(4, 8));
        Card.printDeck(kings, "Kings in deck", 1);

        List<Card> tens = new ArrayList<>(deck.subList(16, 20));
        Card.printDeck(kings, "Tens in deck", 1);

        int subListIndex = Collections.indexOfSubList(deck, tens);
        System.out.println("Sublist index of tens = " + subListIndex);
        System.out.println("Contains ="+ deck.containsAll(tens));

//        Binary Search; the list must be sorted suitable for large lists
        deck.sort(sortingAlgo);
        Card tenOfHearts = Card.getNumericCard(Suit.HEARTS, 10);
        int foundIndex = Collections.binarySearch(deck, tenOfHearts, sortingAlgo);
        System.out.println("Found index = "+ foundIndex);
        System.out.println(deck.get(foundIndex));

//        Replace returns a boolean
        Card tenOfClubs = Card.getNumericCard(Suit.CLUBS, 10);
        Collections.replaceAll(deck, tenOfClubs, tenOfHearts);
        Card.printDeck(deck.subList(32,36), "Replaced 10 of Clubs with 10 of Hearts", 1);
        Collections.replaceAll(deck, tenOfHearts, tenOfClubs);
        Card.printDeck(deck.subList(32,36), "Replaced 10 of Hearts with 10 of Clubs", 1);

//        frequency:- returns how many times an item appears
        System.out.println("Tens of clubs= "+ Collections.frequency(deck, tenOfClubs));
        System.out.println("Best Card = "+ Collections.max(deck, sortingAlgo));
        System.out.println("worst Card = "+ Collections.min(deck, sortingAlgo));

        var sortBySuit = Comparator.comparing(Card::suit).thenComparing(Card::rank);
        deck.sort(sortBySuit);
        Card.printDeck(deck, "Sorted deck by suit, rank", 4);

//        Rotate
        List<Card> copied = new ArrayList<>(deck.subList(0,13));
        Collections.rotate(copied, 2);
        System.out.println("Unrotated = "+ deck.subList(0,13));
        System.out.println("Rotated 2= "+ copied);

        copied = new ArrayList<>(deck.subList(0,13));
        Collections.rotate(copied, -2);
        System.out.println("Unrotated = "+ deck.subList(0,13));
        System.out.println("Rotated -2= "+ copied);

//        Swap
        copied = new ArrayList<>(deck.subList(0,13));
        for (int i = 0; i< copied.size() /2; i++){
            Collections.swap(copied, i, copied.size() - 1 - i);
        }
        System.out.println("Manual reverse =" + copied);

    }
}
