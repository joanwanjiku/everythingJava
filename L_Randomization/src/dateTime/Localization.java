package dateTime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.zone.ZoneRules;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.time.format.DateTimeFormatter.*;

public class Localization {
    public static void main(String[] args) {
//        System.out.println("Default Locale: " + Locale.getDefault());
//
//        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
//        System.out.println(dtf.format(LocalDateTime.now()));

        Employee jane = new Employee("Jane", Locale.US, "America/Los_Angeles");
        Employee joe = new Employee("Joe", "en-AU", "Australia/Sydney");

        ZoneRules joesRules = joe.zoneId().getRules();
        ZoneRules janesRules = jane.zoneId().getRules();

        ZonedDateTime janeNow = ZonedDateTime.now(jane.zoneId());
        ZonedDateTime joeNow = ZonedDateTime.of(janeNow.toLocalDateTime(), joe.zoneId());
        long hoursBetween = Duration.between(joeNow, janeNow).toHours();
        long minutesBetween = Duration.between(joeNow, janeNow).toMinutesPart();
        System.out.println("Joe is " + Math.abs(hoursBetween) + " hours " +
                Math.abs(minutesBetween) + " minutes " +
                ((hoursBetween < 0) ? "behind" : "ahead"));

        System.out.println("Joe in daylight savings? " +
                joesRules.isDaylightSavings(joeNow.toInstant()) + " " +
                joesRules.getDaylightSavings(joeNow.toInstant()) + ": " +
                joeNow.format(ofPattern("zzzz z")));

        System.out.println("Jane in daylight savings? " +
                janesRules.isDaylightSavings(janeNow.toInstant()) + " " +
                janesRules.getDaylightSavings(janeNow.toInstant()) + ": " +
                janeNow.format(ofPattern("zzzz z")));

        int days = 10;
        var map = schedule(joe, jane, days);
        DateTimeFormatter dtf2 = ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.SHORT);

        for (LocalDate ldt : map.keySet()) {
            System.out.println(ldt.format(ofLocalizedDate(FormatStyle.FULL)));
            for (ZonedDateTime zdt : map.get(ldt)) {
                System.out.println("\t" +
                        jane.getDateInfo(zdt, dtf2) + " <---> " +
                        joe.getDateInfo(zdt.withZoneSameInstant(joe.zoneId()), dtf2));
            }
        }
    }

    private static Map<LocalDate, List<ZonedDateTime>> schedule(Employee first, Employee second, int days) {
        Predicate<ZonedDateTime> rules = zdt ->
                zdt.getDayOfWeek() != DayOfWeek.SATURDAY
                        && zdt.getDayOfWeek() != DayOfWeek.SUNDAY
                        && zdt.getHour() >= 7 && zdt.getHour() < 21;

        LocalDate startingDate = LocalDate.now().plusDays(2);
        return startingDate.datesUntil(startingDate.plusDays(days + 1))
                .map(dt -> dt.atStartOfDay(first.zoneId()))
                .flatMap(dt -> IntStream.range(0, 24).mapToObj(dt::withHour))
                .filter(rules)
                .map(dtz -> dtz.withZoneSameInstant(second.zoneId()))
                .filter(rules)
                .collect(
                        Collectors.groupingBy(ZonedDateTime::toLocalDate,
                                TreeMap::new, Collectors.toList()));
    }
}
