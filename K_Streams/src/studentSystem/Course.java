package studentSystem;

public record Course(String courseCode, String courseName, int lectureCount) {
    public Course {
        if (lectureCount <= 0) {
            lectureCount = 1;
        }
    }
    public Course(String courseCode, String courseName) {
        this(courseCode, courseName, 40);
    }

    @Override
    public String toString() {
        return "%s %s ".formatted(courseCode, courseName);
    }
}
