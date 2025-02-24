package intro;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class PreRequisites {
    record Person(String fname, String lname){
        @Override
        public String toString() {
            return fname + " "+lname;
        }
    }
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person("John", "Doe"),
                new Person("Lina", "Johnson"),
                new Person("Jane", "Smith"),
                new Person("Alice", "Johnson"),
                new Person("Joan", "Smith")
        ));

//        comparator
        people.sort((o1, o2) -> o1.lname().compareTo(o2.lname()));
        System.out.println(people);
        System.out.println("---------------------");


        interface EnhancedComparator<T> extends Comparator<T> {
            int secondLevel(T o1, T o2);
        }
        var comparatorMixed = new EnhancedComparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int result = o1.lname().compareTo(o2.lname());
                return (result == 0 ? secondLevel(o1, o2): result);
            }

            @Override
            public int secondLevel(Person o1, Person o2) {
                return o1.fname().compareTo(o2.fname());
            }
        };
        people.sort(comparatorMixed);
        System.out.println(people);
    }

}
