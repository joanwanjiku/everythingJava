package maps;

import sets.Contact;
import sets.ContactData;

import java.util.*;

public class MapViewMain {
    public static void main(String[] args) {
        Map<String, Contact> contacts = new HashMap<>();
        ContactData.getData("phone").forEach(contact -> contacts.put(contact.getName(), contact));
        ContactData.getData("email").forEach(contact -> contacts.put(contact.getName(), contact));
        Set<String> keysView = contacts.keySet();
        System.out.println(keysView);

        Set<String> copyOfKeys = new TreeSet<>(contacts.keySet());
        System.out.println(copyOfKeys);

        System.out.println("--------------------------------------------------------------");
        keysView.remove("Daffy Duck");
        System.out.println(keysView);
        contacts.forEach((k,v) -> System.out.println(v));
        System.out.println("--------------------------------------------------------------");
        copyOfKeys.remove("Minnie Mouse");
        System.out.println(copyOfKeys);
        contacts.forEach((k,v) -> System.out.println(v));
        System.out.println("--------------------------------------------------------------");
        keysView.retainAll(List.of("Maid Marion", "Charlie Brown", "Robin Hood"));
        System.out.println(keysView);
        contacts.forEach((k,v) -> System.out.println(v));

        System.out.println("--------------------------------------------------------------");
        keysView.clear();
        System.out.println(contacts);
        ContactData.getData("phone").forEach(contact -> contacts.put(contact.getName(), contact));
        ContactData.getData("email").forEach(contact -> contacts.put(contact.getName(), contact));
        System.out.println(keysView);

        System.out.println("-----------------------------------------------------------------------------");
        var values = contacts.values();
        values.forEach(System.out::println);

        System.out.println("-----------------------------------------------------------------------------");
        values.retainAll(ContactData.getData("email"));
        System.out.println(keysView);
        contacts.forEach((k,v)-> System.out.println(v));
        System.out.println("-----------------------------------------------------------------------------");
        List<Contact> list = new ArrayList<>(values);
        list.sort(Comparator.comparing(Contact::getNameLastFirst));
        list.forEach(c -> System.out.println(c.getNameLastFirst() + ": "+ c));
        System.out.println("-----------------------------------------------------------------------------");
        Contact first = list.get(0);
        contacts.put(first.getNameLastFirst(), first);
        values.forEach(System.out::println);
        keysView.forEach(System.out::println);

        System.out.println("-----------------------------------------------------------------------------");
        HashSet<Contact> sets = new HashSet<>(values);
        sets.forEach(System.out::println);
        if (sets.size() < contacts.keySet().size()){
            System.out.println("Duplicate names exist");
        }

        System.out.println("-----------------------------------------------------------------------------");
        var nodeSet = contacts.entrySet();
        for (var node : nodeSet) {
            if (!node.getKey().equals(node.getValue().getName())) {
                System.out.println("Key doesn't match name: "+ node.getKey() + ": "+ node.getValue());
            }
        }
        System.out.println("-----------------------------------------------------------------------------");

    }
}
