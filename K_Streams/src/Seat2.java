import java.util.Random;

public record Seat2(char rowMaker, int number, boolean isReserved) {
    public Seat2(char rowMaker, int number) {
        this(rowMaker, number, new Random().nextBoolean());
    }
}
