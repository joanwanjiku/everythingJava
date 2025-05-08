package constructorsImmutable;

public class Main {
    public static void main(String[] args) {
        Parent parent = new Parent("John", 30);
        Child child = new Child();
        System.out.println(parent);
        System.out.println(child);
    }
}
