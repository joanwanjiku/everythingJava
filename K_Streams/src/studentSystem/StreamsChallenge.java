package studentSystem;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsChallenge {
    public static void main(String[] args) {
        Course pymc = new Course("PYMC", "Python Machine Learning", 50);
        Course java = new Course("JAVA", "Java Programming", 100);
        Course gaming = new Course("JMC", "Creating Games in Java");

        int currentYear = LocalDate.now().getYear();
        List<Student> students = Stream
                .generate(() -> Student.getRandomStudent(java, pymc, gaming))
                .filter(s -> s.getYearEnrolled() >= (currentYear -4))
                .limit(10000)
                .toList();

        System.out.println(students.stream()
                .mapToInt(Student::getYearEnrolled)
                .summaryStatistics());

        students.subList(0,10).forEach(System.out::println);
        System.out.println("\n----------------------------------");

        System.out.println(students.stream()
                .mapToInt(s -> s.getCourseEngagements().size())
                .summaryStatistics());

        System.out.println("\n----------------------------------");
        var mappedActivity = students.stream()
                .flatMap(s -> s.getCourseEngagements().values().stream())
                .collect(Collectors.groupingBy(CourseEngagement::getCourseCode, Collectors.counting()));
        mappedActivity.forEach((k, v) -> System.out.println(k + " : " + v));
        System.out.println("\n----------------------------------");
        var percentages = students.stream()
                .flatMap(s -> s.getCourseEngagements().values().stream())
                .collect(Collectors.groupingBy(CourseEngagement::getCourseCode,
                        Collectors.summarizingDouble(CourseEngagement::getPercentageProgress)));

        percentages.forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println("\n----------------------------------");
        var yearMap = students.stream()
                .flatMap(s -> s.getCourseEngagements().values().stream())
                .collect(Collectors.groupingBy(CourseEngagement::getCourseCode,
                        Collectors.groupingBy(CourseEngagement::getLastActivityYear,
                                Collectors.counting())));

        yearMap.forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println("\n----------------------------------");

        students.stream()
                .flatMap(s -> s.getCourseEngagements().values().stream())
                .collect(Collectors.groupingBy(CourseEngagement::getEnrollmentYear,
                        Collectors.groupingBy(CourseEngagement::getCourseCode,
                                Collectors.counting())))
                .forEach((k, v) -> System.out.println(k + ": " + v));

    }
}
