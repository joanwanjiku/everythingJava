import java.util.Arrays;
import java.util.stream.IntStream;

public class streamTerminal {
    public static void main(String[] args) {
        var result = IntStream
                .iterate(0, i -> i <= 1000, i -> i = i + 3)
                .summaryStatistics();
        System.out.println(result);

        var leapYearData = IntStream
                .iterate(2000, i -> i <= 2025, i -> i + 1)
                .filter(i -> i % 4 == 0 && i % 100 != 0 || i % 400 == 0)
                .peek(System.out::println)
                .summaryStatistics();
        System.out.println(leapYearData);
        System.out.println("\n----------------------------------");
        Seat2[] seats = new Seat2[100];
        Arrays.setAll(seats, i -> new Seat2((char) ('A' + i /10), i % 10 + 1));
        long reservationCount = Arrays
                .stream(seats)
                .filter(Seat2::isReserved)
                .count();
        System.out.println(reservationCount);

        System.out.println("\n----------------------------------");
        boolean hasBookings = Arrays
                .stream(seats)
                .anyMatch(Seat2::isReserved);
        System.out.println(hasBookings);

        System.out.println("\n----------------------------------");
        boolean booked = Arrays
                .stream(seats)
                .allMatch(Seat2::isReserved);
        System.out.println(booked);

    }
}
