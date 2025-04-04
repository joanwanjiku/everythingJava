package maps.sortedMaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student {
    public static int lastId = 1;
    public int id;
    public String name;
    public List<Course> courses;

    public Student(String name, List<Course> courseList) {
        this.name = name;
        this.courses = courseList;
        this.id = lastId++;
    }
    public Student(String name, Course course) {
        this(name, new ArrayList<>(List.of(course)));
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }
    @Override
    public String toString() {
        String[] courseNames = new String[courses.size()];
        Arrays.setAll(courseNames, i -> courses.get(i).courseName());
        return "[%d] : %s".formatted(id, String.join(", ", courseNames));
    }
}
