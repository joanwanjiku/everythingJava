package constructorsImmutable;

public class Parent {
    static {
        System.out.println("In parent static block");
    }
    private final String name;
    private final int age;
    protected final int siblings;
    {
//        name = "John"; age = 20;
        System.out.println("In parent block");
    }
//
//    public Parent() {
//    }

    public Parent(String name, int age, int siblings) {
        this.name = name;
        this.age = age;
        this.siblings = siblings;
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
