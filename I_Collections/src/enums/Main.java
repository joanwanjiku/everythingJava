package enums;

import java.util.*;

public class Main {
    enum Weekday {
        SUNDAY,MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    public static void main(String[] args) {
        List<Weekday> ansWorkDays = new ArrayList<>(List.of(Weekday.MONDAY, Weekday.TUESDAY, Weekday.THURSDAY, Weekday.FRIDAY));
        var ansDaysSet = EnumSet.copyOf(ansWorkDays);
        ansDaysSet.forEach(System.out::println);
        System.out.println("--------------------------------------------------");
        var allDays = EnumSet.allOf(Weekday.class);
        allDays.forEach(System.out::println);
        System.out.println("--------------------------------------------------");
        Set<Weekday> newPersonsDay = EnumSet.complementOf(ansDaysSet);
        newPersonsDay.forEach(System.out::println);
        System.out.println("--------------------------------------------------");
        Set<Weekday> workDays = EnumSet.range(Weekday.MONDAY, Weekday.FRIDAY);
        workDays.forEach(System.out::println);

//        EnumMap
        Map<Weekday, String[]> map = new EnumMap<>(Weekday.class);
        map.put(Weekday.MONDAY, new String[]{"bob", "Mary", "Lina"});
        map.put(Weekday.FRIDAY, new String[]{"Carr", "Joe", "Dinner"});

        map.forEach((k, v) -> System.out.println(k + " : " + Arrays.toString(v)));
    }
}
