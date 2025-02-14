package Comparing;

import java.util.Random;

public class Student implements Comparable<Student>{
    private static Random random = new Random();
    private static int LAST_ID = 1000;
    String name;

    private int id;
    protected double gpa;
    public Student(String name) {
        this.name = name;
        id = LAST_ID++;
        gpa = random.nextDouble(1.0, 4.0);
    }
    @Override
    public int compareTo(Student o) {
        return Integer.valueOf(id).compareTo(Integer.valueOf(o.id));
    }
    @Override
    public String toString() {
        return "%d - %s (%.2f)".formatted(id, name, gpa);
    }
}
