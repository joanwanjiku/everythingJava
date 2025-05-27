package studentSystem;

import java.time.LocalDate;
import java.util.*;
import java.util.Random;

public class Student {
    private static long lastStudentId = 1;
    private final static Random random = new Random();
    private final long studentId;
    private final String countryCode;
    private final int yearEnrolled;
    private final int ageEnrolled;
    private final String gender;
    private final boolean programmingExperience;
    private final Map<String, CourseEngagement> courseEngagements = new HashMap<>();

    public Student(String countryCode, int yearEnrolled, int ageEnrolled, String gender, boolean programmingExperience, Course... courses) {
        this.studentId = lastStudentId++;
        this.countryCode = countryCode;
        this.yearEnrolled = yearEnrolled;
        this.ageEnrolled = ageEnrolled;
        this.gender = gender;
        this.programmingExperience = programmingExperience;
        for (Course course : courses) {
            addCourse(course, LocalDate.of(yearEnrolled, 1, 1));
        }
    }
    void addCourse(Course course) {
        addCourse(course, LocalDate.now());
    }
    private void addCourse(Course course, LocalDate enrollmentDate) {
        courseEngagements.put(course.courseCode(),  new CourseEngagement(course, enrollmentDate, "Enrollment"));
    }

    public long getStudentId() {
        return studentId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public int getYearEnrolled() {
        return yearEnrolled;
    }

    public int getAgeEnrolled() {
        return ageEnrolled;
    }

    public String getGender() {
        return gender;
    }

    public boolean hasProgrammingExperience() {
        return programmingExperience;
    }

    public Map<String, CourseEngagement> getCourseEngagements() {
        return Map.copyOf(courseEngagements);
    }
    public int getYearsSinceEnrolled() {
        return LocalDate.now().getYear() - yearEnrolled;
    }
    public int getAge(){
        return  ageEnrolled + getYearsSinceEnrolled();
    }
    public int getMonthsSinceActive(String courseCode) {
        CourseEngagement info = courseEngagements.get(courseCode);
        return info == null ? 0 : info.getMonthsSinceActive();
    }
    public int getMonthsSinceActive(){
        int inactiveMonths = (LocalDate.now().getYear() - 2014)  *12;
        for (String key : courseEngagements.keySet()) {
            inactiveMonths = Math.min(inactiveMonths, getMonthsSinceActive(key));
        }
        return inactiveMonths;
    }
    public double getPercentageProgress(String courseCode) {
        CourseEngagement info = courseEngagements.get(courseCode);
        return info == null ? 0 : info.getPercentageProgress();
    }
    public void watchLecture(String courseCode, int lectureNumber, int month, int year) {
        var activity = courseEngagements.get(courseCode);
        if (activity != null) {
            activity.watchLecture(lectureNumber, LocalDate.of(year, month, 1));
        }
    }
    private static String getRandomVal(String... data){
        return data[random.nextInt(data.length)];
    }
    public static Student getRandomStudent(Course... courses) {

        int maxYear = LocalDate.now().getYear() + 1;

        Student student = new Student(
                getRandomVal("AU", "CA", "CN", "GB", "IN", "UA", "US"),
                random.nextInt(2015, maxYear),
                random.nextInt(18, 90),
                getRandomVal("M", "F", "U"),
                random.nextBoolean(),
                courses);

        for (Course c : courses) {
            int lecture = random.nextInt(30, c.lectureCount());
            int year = random.nextInt(student.getYearEnrolled(), maxYear);
            int month = random.nextInt(1, 13);
            if (year == (maxYear - 1)) {
                if (month > LocalDate.now().getMonthValue()) {
                    month = LocalDate.now().getMonthValue();
                }
            }
            student.watchLecture(c.courseCode(), lecture, month, year);
        }
        return student;
    }
    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", countryCode='" + countryCode + '\'' +
                ", yearEnrolled=" + yearEnrolled +
                ", ageEnrolled=" + ageEnrolled +
                ", gender='" + gender + '\'' +
                ", programmingExperience=" + programmingExperience +
                ", courseEngagements=" + courseEngagements +
                '}';
    }
}
