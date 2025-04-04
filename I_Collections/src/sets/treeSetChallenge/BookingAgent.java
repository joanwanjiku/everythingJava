package sets.treeSetChallenge;

public class BookingAgent {
    public static void main(String[] args) {

        Thearte rodgers = new Thearte("The Art of War", 10, 100);
        rodgers.printSeatMap();

        bookSeat(rodgers, 'A', 3);
        bookSeat(rodgers, 'A', 3);
        bookSeat(rodgers, 'B', 1);
        bookSeat(rodgers, 'C', 2);
        rodgers.printSeatMap();

//        bookSeat(rodgers, 'A', 101);

        bookSeats(rodgers, 5, 'D', 3, 10);
    }

    private static void bookSeat(Thearte thearte, char row, int seatNo) {
        String seat = thearte.reserveSeat(row, seatNo);
        if (seat != null) {
            System.out.println("Congratulations! Your seat has been reserved " + seat);
            thearte.printSeatMap();
        }else {
            System.out.println("Sorry, that seat is not available");
        }

    }
    private static void bookSeats(Thearte thearte, int tickets, char minRow, char maxRow, int minSeat, int maxSeat) {
        var seats = thearte.reserveSeats(tickets, minRow, maxRow, minSeat, maxSeat);
        if (seats != null) {
            System.out.println("Congratulations! Your seats have been reserved: " + seats);
            thearte.printSeatMap();
        }else {
            System.out.println("Sorry, we could not find any suitable seats");
        }
    }
    private static void bookSeats(Thearte thearte, int tickets, char minRow, int minSeat, int maxSeat) {
        var seats = thearte.reserveSeats(tickets, minRow, minRow, minSeat, maxSeat);
        if (seats != null) {
            System.out.println("Congratulations! Your seats have been reserved: " + seats);
            thearte.printSeatMap();
        }else {
            System.out.println("Sorry, we could not find any suitable seats");
        }
    }


}
