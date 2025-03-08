package cardGame;

public enum Suit {
    HEARTS, DIAMONDS, CLUBS, SPADES;;

    public char getImage(){
        return new char[]{9829, 9830,9827,9824}[this.ordinal()];
    }


}
