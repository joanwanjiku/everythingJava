package studentSystem;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Course pymc = new Course("PYMC", "Python Machine Learning");
        Course java = new Course("JAVA", "Java Programming");
//        Student joan = new Student("BG", 2022, 23, "F", true, pymc, java);
//        System.out.println(joan);
//
//        joan.watchLecture("JAVA", 10, 5, 2022);
//        joan.watchLecture("PYMC", 7, 7, 2023);

//        System.out.println(joan);

        Student[] students = new Student[1000];
        Arrays.setAll(students, i -> Student.getRandomStudent(java, pymc));
        var maleStudents = Arrays.stream(students)
                .filter(s -> s.getGender().equals("M"))
                .count();
        System.out.println(maleStudents);
        System.out.println("\n----------------------------------");

        for (String gender : List.of("M", "F", "U")) {
            var myStudents = Arrays.stream(students)
                    .filter(s -> s.getGender().equals(gender));
            System.out.println("# of " + gender + " students: " + myStudents.count());
        }
        System.out.println("\n----------------------------------");
        List< Predicate<Student>> predicates = List.of(
                s -> s.getAge() < 30,
                (Student s) -> s.getAge() > 30 && s.getAge() < 60
        );
        long total = 0;
        for (int i = 0; i < predicates.size(); i++) {
            var myStudents = Arrays.stream(students)
                    .filter(predicates.get(i));
            long cnt = myStudents.count();
            total += cnt;
            System.out.printf("# of students (%s) = %d%n", i == 0 ? "< 30" : "30 < x < 60", cnt);
        }
        System.out.println("# of all students >= 60: " + (students.length - total));
        System.out.println("\n----------------------------------");
        var studentsStats = Arrays.stream(students)
                .mapToInt(Student::getAgeEnrolled)
                .summaryStatistics();
        System.out.println(studentsStats);
        System.out.println("\n----------------------------------");
        var countryOrigin = Stream.generate(() -> Student.getRandomStudent(java, pymc))
                .limit(30)
                .map(Student::getCountryCode)
                .distinct()
                .sorted();
        countryOrigin.forEach(System.out::println);
        System.out.println("\n----------------------------------");
        boolean longTerm = Arrays.stream(students)
                .anyMatch(s -> (s.getAge() - s.getAgeEnrolled() >= 7 ) && (s.getMonthsSinceActive() < 12));
        System.out.println("LongTerm Student: " + longTerm);
        System.out.println("\n----------------------------------");

        long longTermCount = Arrays.stream(students)
                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7 ) && (s.getMonthsSinceActive() < 12))
                .count();
        System.out.println("LongTerm Student count: " + longTermCount);
        System.out.println("\n----------------------------------");

        var longTimeLearners = Arrays.stream(students)
                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7 ) && (s.getMonthsSinceActive() < 12))
                .filter(student -> !student.hasProgrammingExperience())
                .limit(5)
                .toArray(Student[]::new);
        System.out.println("\n----------------------------------");

        var justLearners = Arrays.stream(students)
                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7 ) && (s.getMonthsSinceActive() < 12))
                .filter(student -> !student.hasProgrammingExperience())
                .limit(5)
                        .collect(Collectors.toList());
        Collections.shuffle(justLearners);
        System.out.println("\n----------------------------------");







    }
}
