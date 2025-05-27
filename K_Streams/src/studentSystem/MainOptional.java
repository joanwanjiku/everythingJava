package studentSystem;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainOptional {
    public static void main(String[] args) {
        Course pymc = new Course("PYMC", "Python Machine Learning");
        Course java = new Course("JAVA", "Java Programming");
        List<Student> students =
                Stream.generate(() -> Student.getRandomStudent(java, pymc))
                        .limit(1000)
                        .collect(Collectors.toList());

        Optional<Student> o1 = getStudent(null, "first");
        System.out.println("Empty = "+ o1.isEmpty() + " Present = " + o1.isPresent());
        o1.ifPresentOrElse(System.out::println, () -> System.out.println("No student"));
        System.out.println("\n----------------------------------");
//        students.add(0, null);
        Optional<Student> o2 = getStudent(students, "first");
        System.out.println("Empty = "+ o2.isEmpty() + " Present = " + o2.isPresent());
        o2.ifPresent(System.out::println);

        System.out.println("\n----------------------------------");
        Student firstStd = o1.orElseGet(() -> (getDummyStudent(pymc, java)));
        long id = firstStd.getStudentId();
        System.out.println(id);

        System.out.println("\n----------------------------------");
        List<String> countries = students.stream()
                .map(Student::getCountryCode)
                .distinct()
                .toList();
        Optional.of(countries)
                .map(l -> String.join(", ", l))
                .filter(l -> l.contains("FR"))
                .ifPresentOrElse(System.out::println, () -> System.out.println("No country contains FR"));
    }
    private static Optional<Student> getStudent(List<Student> list, String type){
        if (list == null || list.isEmpty()) {
            return Optional.empty(); // Optional return empty and not null
        } else if (type.equals("first")) {
            return Optional.ofNullable(list.get(0));
        } else if (type.equals("last")) {
            return Optional.ofNullable(list.get(list.size() - 1));
        }
        return Optional.of(list.get(new Random().nextInt(list.size())));

    }
    private static Student getDummyStudent(Course... courses){
        System.out.println("Dummy student");
        return new Student("BG", 2022, 23, "F", true, courses);
    }
}
