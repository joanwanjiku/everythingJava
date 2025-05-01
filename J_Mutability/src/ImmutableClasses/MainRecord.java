package ImmutableClasses;

public class MainRecord {
    public static void main(String[] args) {
        PersonRecord JohnParent = new PersonRecord("John", "01/01/1970");
        PersonRecord[] kids = {new PersonRecord("Jane", "05/05/1995"), new PersonRecord("Bob", "06/06/1996"), new PersonRecord("Joe", "07/07/1997")};

        System.out.println(JohnParent);
        System.out.println("------------------");
        PersonRecord johnParentCopy = new PersonRecord("John", "01/01/1970");
        System.out.println(johnParentCopy);


    }
}
