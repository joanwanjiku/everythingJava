package copyingClasses;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Person joe = new Person("Joe", "01/01/1970");
        Person jane = new Person("Jane", "01/01/1970");
        Person bob = new Person("Bob", "01/01/1970");
        Person jill = new Person("Jill", "01/01/1970");
        Person[] persons = {joe, jane, bob, jill};
        Person[] personsCopy = Arrays.copyOf(persons, persons.length);

        for (int i = 0; i < 4; i++) {
            if (persons[i].equals(personsCopy[i])) {
                System.out.println("Equal references");
            }
        }
    }
}
