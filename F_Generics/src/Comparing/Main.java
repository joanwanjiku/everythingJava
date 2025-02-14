package Comparing;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Integer five = 5;

        Integer[] others = {0, 1, -4, 6, 5};
        for (int other: others) {
            int val = five.compareTo(other);
            System.out.printf("%d %s %d : compareTo = %d%n", five, (val == 0 ? "==" : (val <0 ) ? "<":">"), other, val);
        }
        Student lina = new Student("Lina");
        Student[]  students = {new Student("Joao"), new Student("Noah"), new Student("Amos")};
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
        System.out.println("result:- "+ lina.compareTo(new Student("LINA")));

        Comparator<Student> gpaSorter = new StudentGPAComparator();
        Arrays.sort(students, gpaSorter.reversed());
        System.out.println(Arrays.toString(students));
    }
}


