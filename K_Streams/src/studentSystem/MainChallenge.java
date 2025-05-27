package studentSystem;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class MainChallenge {
    public static void main(String[] args) {
        Course pymc = new Course("PYMC", "Python Machine Learning", 50);
        Course java = new Course("JAVA", "Java Programming", 100);
        Course gaming = new Course("JMC", "Creating Games in Java");

        List<Student> students = Stream.iterate(1, s -> s <= 5000, s -> s + 1)
                .map(s -> Student.getRandomStudent(java, pymc, gaming))
                .toList();
        double javaComplete = students.stream()
                .mapToDouble(s -> s.getPercentageProgress("JAVA"))
                .reduce(0, Double::sum);
        double avgPercent = javaComplete / students.size();
        System.out.println(avgPercent);
        System.out.println("\n----------------------------------");

        int topPercent = ( int) (1.25 * avgPercent);
        System.out.println(topPercent);
        System.out.println("\n----------------------------------");
        Comparator<Student> comp = Comparator.comparing(Student::getYearEnrolled);
        List<Student> hardWorkers = students.stream()
                .filter(s -> s.getMonthsSinceActive("JMC") == 0)
                .filter(s -> s.getPercentageProgress("JMC") >= topPercent)
                .sorted(comp)
                .limit(10)
                .toList();
        hardWorkers.forEach(s -> {
            s.addCourse(gaming);
            System.out.println(s.getStudentId()+ " ");;
        });




    }
}
