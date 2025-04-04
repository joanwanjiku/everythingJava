package maps.sortedMaps;

import java.time.LocalDate;

public record Purchase(String courseNumber, int studentId, double price, int yr, int dayOfTheyear) {
    public LocalDate purchaseDate() {
        return LocalDate.ofYearDay(yr, dayOfTheyear);
    }
}
