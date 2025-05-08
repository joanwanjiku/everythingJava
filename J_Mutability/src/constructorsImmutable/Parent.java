package constructorsImmutable;

public class Parent {
    private final String name;
    private final int age;
    {
//        name = "John"; age = 20;
        System.out.println("In parent block");
    }
//
//    public Parent() {
//    }

    public Parent(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("In parent constructor");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    @Override
    public String toString() {
        return "Parent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
