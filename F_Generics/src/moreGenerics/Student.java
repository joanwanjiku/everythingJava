package F_Generics.src.moreGenerics;

import java.util.Random;

public class Student {
    private String name;
    private String course;
    private int yearStarted;
    protected static Random random = new Random();

    protected static String[] firstNames = {"Ann", "Joan", "Lia", "Brian", "Tim"};
    protected static String[] courses = {"Math", "Science", "Engish"};

    public Student() {
        int lastIndex = random.nextInt(65, 91);
        name = firstNames[random.nextInt(5)] + " "+ (char) lastIndex;
        course = courses[random.nextInt(3)];
        yearStarted = random.nextInt(2018, 2023);
    }

    @Override
    public String toString() {
        return "%-15s %-15s %d".formatted(name, course, yearStarted);
    }

    public int getYearStarted() {
        return yearStarted;
    }
}
