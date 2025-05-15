package studentSystem;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Course pymc = new Course("PYMC", "Python Machine Learning");
        Course java = new Course("JAVA", "Java Programming");
//        Student joan = new Student("BG", 2022, 23, "F", true, pymc, java);
//        System.out.println(joan);
//
//        joan.watchLecture("JAVA", 10, 5, 2022);
//        joan.watchLecture("PYMC", 7, 7, 2023);

//        System.out.println(joan);
        Stream.generate(() -> Student.getRandomStudent(java, pymc))
                .limit(10)
                .forEach(System.out::println);
    }
}
