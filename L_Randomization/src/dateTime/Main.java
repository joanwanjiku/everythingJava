package dateTime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;

public class Main {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalDate may31st = LocalDate.of(2020, 5, 31);
        System.out.println(may31st);

        LocalDate yearMid = LocalDate.ofYearDay(2020, 182);
        System.out.println(yearMid);
        System.out.println("-------------------------------------------------------------");
        System.out.println(yearMid.getMonth());
        System.out.println(yearMid.getDayOfWeek());

        System.out.println("-------------------------------------------------------------");
        System.out.println(may31st.plusYears(2));
        System.out.println(may31st.plusMonths(2));
        System.out.println("-------------------------------------------------------------");
        may31st.datesUntil(may31st.plusYears(5), Period.ofMonths(2))
                .forEach(System.out::println);
        System.out.println("-------------------------------------------------------------");
        LocalTime now = LocalTime.now();
        System.out.println(now);
        System.out.println(now.getHour());
        System.out.println(now.getMinute());

        LocalTime yesterday = LocalTime.of(22,57);
        System.out.println(yesterday);

        LocalTime sevenPM = LocalTime.parse("07:00");
        System.out.println(sevenPM);
        System.out.println("-------------------------------------------------------------");
        ZoneId.getAvailableZoneIds().stream()
                .filter(zoneId -> zoneId.contains("America/N"))
                .sorted()
                .map(ZoneId::of)
                .forEach(z -> System.out.println(z.getId() + " " + z.getRules()));
    }
}
