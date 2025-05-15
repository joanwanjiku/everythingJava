public record Seat(char rowMaker, int number, double price) {
    public Seat(char rowMaker, int number) {
        this(rowMaker, number, rowMaker > 'C' && (number <=2 || number >= 9) ? 50 : 75);
    }

    @Override
    public String toString() {
        return "%c%03d %.0f".formatted(rowMaker, number, price);
    }
}
