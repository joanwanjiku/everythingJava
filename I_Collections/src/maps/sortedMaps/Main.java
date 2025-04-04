package maps.sortedMaps;

import java.time.LocalDate;
import java.util.*;

public class Main {

    private static Map<String, Purchase> purchases = new LinkedHashMap<>();
    private static NavigableMap<String, Student> students = new TreeMap<>();

    public static void main(String[] args) {
        Course java = new Course("Java", "CS101", "Programming");
        Course python = new Course("python", "CS103", "Programming");
        addPurchases("John Doe", java, 99.99);
        addPurchases("Joe Doe", java, 93.99);
        addPurchases("Bill Brown", java, 129.99);
        addPurchases("Mary poppins", python, 137.99);
        addPurchases("Joe Jones", python, 109.99);
        addPurchases("Fred Brian", python, 59.99);
        addPurchases("Greg Joy", python, 223.99);
        addPurchases("Lina Hicks", python, 80.99);

        purchases.forEach((k, v) -> System.out.println(k+ " : "+v));
        System.out.println("--------------------------------------------------");
        students.forEach((k, v) -> System.out.println(k+ " : "+v));

        NavigableMap<LocalDate, List<Purchase>> sortedPurchases = new TreeMap<>();
        for (Purchase purchase : purchases.values()) {
            sortedPurchases.compute(purchase.purchaseDate(),
                    (k, v) -> {
                        List<Purchase> list = (v == null) ? new ArrayList<>() : v;
                        list.add(purchase);
                        return list;
                    });
        }
        sortedPurchases.forEach((k, v) -> System.out.println(k+ " : "+v));

        int currentYear = LocalDate.now().getYear();
        LocalDate firstDay = LocalDate.ofYearDay(currentYear,  1);
        LocalDate week1 = firstDay.plusDays(7);
        Map<LocalDate, List<Purchase>> week1Purchases = sortedPurchases.headMap(week1); //Map<LocalDate, List<Purchase>>
        Map<LocalDate, List<Purchase>> week2Purchases = sortedPurchases.tailMap(week1); //Map<LocalDate, List<Purchase>>
//        System.out.println("--------------------------------------------------");
//        week1Purchases.forEach((k, v) -> System.out.println(k+ " : "+v));
//        System.out.println("--------------------------------------------------");
//        week2Purchases.forEach((k, v) -> System.out.println(k+ " : "+v));

        displayStats(1, week1Purchases);
        displayStats(2, week2Purchases);
        System.out.println("--------------------------------------------------");
        LocalDate lastDay = sortedPurchases.lastKey();
        var prevEntry = sortedPurchases.lastEntry();

        while (prevEntry != null){
            List<Purchase> lastDaysData = prevEntry.getValue();
            System.out.println(lastDay + " purchases : " + lastDaysData.size());

            LocalDate prevDate = sortedPurchases.lowerKey(lastDay);
            prevEntry = sortedPurchases.lowerEntry(lastDay);
            lastDay = prevDate;
        }
        System.out.println("--------------------------------------------------");
        var reversed = sortedPurchases.descendingMap();

        LocalDate firstDate = reversed.firstKey();
//        var nextEntry = reversed.firstEntry();
        var nextEntry = reversed.pollFirstEntry();

        while (nextEntry != null){
            List<Purchase> firstDaysData = nextEntry.getValue();
            System.out.println(firstDate + " purchases : " + firstDaysData.size());

            LocalDate nextDate = reversed.higherKey(firstDate);
//            nextEntry = reversed.higherEntry(firstDate);
            nextEntry = reversed.pollFirstEntry(); // removes the entry

            firstDate = nextDate;
        }
        System.out.println("--------------------------------------------------");
        sortedPurchases.forEach((k, v) -> System.out.println(k+ " : "+v));
    }

    private static void addPurchases(String name, Course course, double price) {
        Student existingStudent = students.get(name);
        if (existingStudent == null) {
            existingStudent = new Student(name, course);
            students.put(name, existingStudent);
        }else {
            existingStudent.addCourse(course);
        }
        int day = new Random().nextInt(1, 15);
        String key = course.courseNumber() + "_"+ existingStudent.getId();
        int year = LocalDate.now().getYear();
        purchases.put(key, new Purchase(course.courseNumber(), existingStudent.getId(), price, year, day));
    }
    private static void displayStats(int period, Map<LocalDate, List<Purchase>> purchases) {
        System.out.println("--------------------------------------------------");
        Map<String, Integer> weeklyCounts = new TreeMap<>();
        purchases.forEach((k, v) -> {
            System.out.println(k + " : " + v);
            for (Purchase purchase : v) {
                weeklyCounts.merge(purchase.courseNumber(), 1, Integer::sum);
            }
        });
        System.out.printf("Week %d purchases = %s%n", period, weeklyCounts);
    }
}
