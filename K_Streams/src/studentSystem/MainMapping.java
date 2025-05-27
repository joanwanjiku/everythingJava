package studentSystem;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

public class MainMapping {
    public static void main(String[] args) {
        Course pymc = new Course("PYMC", "Python Machine Learning");
        Course java = new Course("JAVA", "Java Programming");
        List<Student> students =
                Stream.generate(() -> Student.getRandomStudent(java, pymc))
                        .limit(5000)
                        .toList();

        var mappedStudents = students.stream()
                .collect(Collectors.groupingBy(Student::getCountryCode));
        mappedStudents.forEach((k, v) -> System.out.println(k + " : " + v.size()));
        System.out.println("\n----------------------------------");
        int minAge = 21;
        var youngest = students.stream()
                .collect(groupingBy(Student::getCountryCode, filtering(s -> s.getAge() <= minAge, toList())));
        youngest.forEach((k, v) -> System.out.println(k + " : " + v.size()));
        System.out.println("\n----------------------------------");
        var experienced = students.stream()
                .collect(partitioningBy(Student::hasProgrammingExperience));
        experienced.forEach((k, v) -> System.out.println(k + " : " + v.size()));
        System.out.println("\n----------------------------------");
        var expCount = students.stream()
                .collect(partitioningBy(Student::hasProgrammingExperience, counting()));
        System.out.println("experienced : " + expCount.get(true) + " inexperienced : " + expCount.get(false));
        System.out.println("\n----------------------------------");
        var multiLevel = students.stream()
                .collect(groupingBy(Student::getCountryCode, groupingBy(Student::getGender)));
        multiLevel.forEach((k, v) -> {
            System.out.println(k + " : ");
            v.forEach((k2, v2) -> System.out.println("\t" + k2 + " : " + v2.size()));
        });

    }
}
