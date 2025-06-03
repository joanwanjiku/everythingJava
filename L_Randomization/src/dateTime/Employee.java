package dateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public record Employee(String name, Locale locale, ZoneId zoneId) {
    public Employee(String name, String locale, String zoneId) {
        this(name, Locale.forLanguageTag(locale), ZoneId.of(zoneId));
    }

    public Employee(String name, Locale locale, String zoneId) {
        this(name, locale, ZoneId.of(zoneId));
    }
    String getDateInfo(ZonedDateTime zdt, DateTimeFormatter dtf) {
        return "%s [%s] : %s".formatted(name, zoneId, zdt.format(dtf.localizedBy(locale)));
    }
}
