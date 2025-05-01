package ImmutableClasses;

public class Main {
    public static void main(String[] args) {
//        Person jane = new Person();
//        jane.setName("Jane");
//        Person bob = new Person();
//        bob.setName("Bob");
//        Person joe = new Person();
//        joe.setName("Joe");
//        Person[] kids = {jane, bob, joe};
//        Person parent = new Person();
//        parent.setName("John");
//        parent.setDob("01/01/1970");
//        parent.setKids(kids);

        Person JohnParent = new Person("John", "01/01/1970");
        Person[] kids = {new Person("Jane", "05/05/1995"), new Person("Bob", "06/06/1996"), new Person("Joe", "07/07/1997")};

        System.out.println(JohnParent);
    }

}
