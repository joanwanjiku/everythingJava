package studentSystem;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class MainTerminalOptional {
    public static void main(String[] args) {
        Course pymc = new Course("PYMC", "Python Machine Learning");
        Course java = new Course("JAVA", "Java Programming");
        List<Student> students =
                Stream.generate(() -> Student.getRandomStudent(java, pymc))
                        .limit(1000)
                        .toList();

        int minAge = 21;
        students.stream()
                .filter(s -> s.getAge() <= minAge)
                .findAny()
                .ifPresentOrElse(s -> System.out.printf("Student %d from %s is %d%n", s.getStudentId(), s.getCountryCode(), s.getAge()), () -> System.out.println("No student found"));
        System.out.println("\n----------------------------------");

        students.stream()
                .filter(s -> s.getAge() <= minAge)
                .min(Comparator.comparing(Student::getAge))
                .ifPresentOrElse(s -> System.out.printf("Student %d from %s is %d%n", s.getStudentId(), s.getCountryCode(), s.getAge()), () -> System.out.println("No student found"));

        System.out.println("\n----------------------------------");
        students.stream()
                .filter(s -> s.getAge() <= minAge)
                .max(Comparator.comparing(Student::getAge))
                .ifPresentOrElse(s -> System.out.printf("Student %d from %s is %d%n", s.getStudentId(), s.getCountryCode(), s.getAge()), () -> System.out.println("No student found"));
        System.out.println("\n----------------------------------");
        students.stream()
                .filter(s -> s.getAge() <= minAge)
                .map(Student::getCountryCode)
                .distinct()
                .reduce((s1, s2) -> s1 + ", " + s2)
                .ifPresentOrElse(System.out::println, () -> System.out.println("No student found"));
    }
}
