package sets;

import java.util.*;

public class TreeSetMain {
    public static void main(String[] args) {
        List<Contact> emails = ContactData.getData("email");
        List<Contact> phones = ContactData.getData("phone");

//        NavigableSet<Contact> sorted = new TreeSet<>(phones);
        Comparator<Contact> mySort = Comparator.comparing(Contact::getName);
        NavigableSet<Contact> sorted = new TreeSet<>(mySort);
        sorted.addAll(emails);
        sorted.forEach(System.out::println);

        NavigableSet<String> justNames = new TreeSet<>();
        phones.forEach(c -> justNames.add(c.getName()));
        System.out.println(justNames);

        NavigableSet<Contact> fullSet = new TreeSet<>(sorted);
        fullSet.addAll(emails);
        fullSet.forEach(System.out::println);

        Contact min = Collections.min(fullSet, fullSet.comparator());
        Contact max = Collections.max(fullSet, fullSet.comparator());

        NavigableSet<Contact> copiedSet = new TreeSet<>(fullSet);
        System.out.println("First Element = "+ copiedSet.pollFirst());
        System.out.println("Last Element = "+ copiedSet.pollLast());
        copiedSet.forEach(System.out::println);
        System.out.println("--------------------------");

        Contact daffy = new Contact("Daffy duck");
        Contact daisy = new Contact("Daisy duck");
        Contact snoopy = new Contact("Snoopy duck");

        for (Contact c : List.of(daffy,daisy, snoopy)) {
            System.out.printf("ceiling(%s)=%s%n", c.getName(), fullSet.ceiling(c));
            System.out.printf("higher(%s)=%s%n", c.getName(), fullSet.higher(c));
        }
        System.out.println("--------------------------");





    }
}
