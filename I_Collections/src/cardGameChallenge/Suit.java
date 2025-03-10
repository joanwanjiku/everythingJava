package cardGameChallenge;

public enum Suit {
    CLUBS, DIAMONDS, HEARTS, SPADES;

    public char getImage(){
        return new char[]{9827,9830, 9829,9824}[this.ordinal()];
    }


}
