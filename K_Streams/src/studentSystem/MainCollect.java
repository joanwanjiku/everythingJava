package studentSystem;

import java.util.*;
import java.util.stream.*;
import java.util.stream.Stream;

public class MainCollect {
    public static void main(String[] args) {
        Course pymc = new Course("PYMC", "Python Machine Learning");
        Course java = new Course("JAVA", "Java Programming");
        List<Student> students =
                Stream.generate(() -> Student.getRandomStudent(java, pymc))
                        .limit(1000)
                        .toList();

        Set<Student> ausStudents =
                students.stream()
                        .filter(s -> s.getCountryCode().equals("AU"))
                        .collect(Collectors.toSet());
        System.out.println("# of aus students: " + ausStudents.size());
        System.out.println("\n----------------------------------");

        Set<Student> under30 =
                students.stream()
                        .filter(s -> s.getAgeEnrolled() < 30)
                        .collect(Collectors.toSet());
        System.out.println("# of under 30 students: " + under30.size());
        System.out.println("\n----------------------------------");

        Set<Student> youngAussuies = new TreeSet<>(Comparator.comparing(Student::getStudentId));
        youngAussuies.addAll(ausStudents);
        youngAussuies.retainAll(under30);
        youngAussuies.forEach(student -> System.out.print(student.getStudentId()+ " "));
        System.out.println();

        Set<Student> youngAussuies2 =
                students.stream()
                        .filter(s -> s.getAgeEnrolled() < 30)
                        .filter(s -> s.getCountryCode().equals("AU"))
                        .collect(() -> new TreeSet<>(Comparator.comparing(Student::getStudentId)), TreeSet::add, TreeSet::addAll);
        youngAussuies2.forEach(student -> System.out.print(student.getStudentId()+ " "));
        System.out.println("\n----------------------------------");
    }
}
