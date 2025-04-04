package sets.treeSetChallenge;

import java.util.*;

public class Thearte {
    private String name;
    private int seatsPerRow;
    private NavigableSet<Seat> seats;

    public Thearte(String name, int rows, int totalSeats) {
        this.name = name;
        this.seatsPerRow = totalSeats/rows;
        seats = new TreeSet<>();
        for (int i = 0; i < totalSeats; i++) {
            char rowChar = (char) (i / seatsPerRow + (int)'A');
            int seatsInRow = i % seatsPerRow + 1;
            seats.add(new Seat(rowChar, seatsInRow));
        }
    }
    public void printSeatMap(){
        String separatorLine = "-".repeat(120);
        System.out.println(separatorLine);
        System.out.println(name);
        System.out.println(separatorLine);
        int index = 0;
        for (Seat seat : seats) {
            System.out.printf("%-8s %3s", seat.getSeatNum() + (seat.isReserved() ? "(●)" : ""), ((index++ + 1) % seatsPerRow == 0) ? "\n" : "");
        }
        System.out.println(separatorLine);
    }

    public String reserveSeat(char row, int seat){
        Seat requestedSeat = new Seat(row, seat);
        Seat requested = seats.floor(requestedSeat); //
        if (requested == null || !requested.getSeatNum().equals(requestedSeat.getSeatNum())) {
            System.out.println("---> No such seat; " + requestedSeat);
            System.out.printf(": Seat must be between %s and %s%n", seats.first().getSeatNum(), seats.last().getSeatNum());
        } else {
            if (requested.isReserved()) {
                System.out.println("---> Seat already reserved; " + requestedSeat);
            } else {
                requested.reserveSeat();
                System.out.println("---> Reserved seat: " + requestedSeat);
                return requestedSeat.getSeatNum();
            }
        }
        return null;
    }
    public Set<Seat> reserveSeats(int count, char minRow, char maxRow, int minSeat, int maxSeat) {
        char lastValid = seats.last().getSeatNum().charAt(0);
        maxRow = maxRow < lastValid ? maxRow : lastValid;
        if (!validate(count, minRow, maxRow, minSeat, maxSeat)) {
            return null;
        }
        NavigableSet<Seat> selected = null;
        for (char row = minRow; row <= maxRow; row++) {
            NavigableSet<Seat> rowSeats = seats.subSet(
                    new Seat(row, minSeat), true,
                    new Seat(row, maxSeat), true
            );
            int index = 0;
            Seat first = null;
            for (Seat seat : rowSeats) {
                if (seat.isReserved()) {
                    index = 0;
                    continue;
                }
                first = index == 0 ? seat : first;
                if (++index == count) {
                    selected = rowSeats.subSet(first, true, seat, true);
                    break;
                }
            }
            if (selected!= null) {
                break;
            }
        }
        Set<Seat> reservedSeats = null;
        if (selected!= null) {
            selected.forEach(seat -> seat.isReserved());
            reservedSeats = new TreeSet<>(selected);
        }
        return reservedSeats;
    }

    private boolean validate(int count, char first, char last, int min, int max) {
        boolean result = (min > 0 || seatsPerRow >= count || (max-min + 1) >= count);
        result = result && seats.contains(new Seat(first, min));
        if (!result) {
            System.out.printf("Invalid! %1$d seats between " +
                            "%2$c[%3$d-%4$d]-%5$c[%3$d-%4$d] Try again",
                    count, first, min, max, last);
            System.out.printf(": Seat must be between %s and %s%n",
                    seats.first().getSeatNum(), seats.last().getSeatNum());
        }
        return result;
    }
}
