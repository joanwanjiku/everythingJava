package Comparing;

import java.util.Comparator;

public class StudentGPAComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return (s1.gpa + s1.name).compareTo(s2.gpa + s2.name);
    }
}
